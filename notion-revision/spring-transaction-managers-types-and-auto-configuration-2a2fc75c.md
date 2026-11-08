# Spring Transaction Managers: Types and Auto-Configuration

Source: https://app.notion.com/p/2a2fc75cbbd980c5b75ce8114fe2a9a7?pvs=204

## How Spring Auto-Configuration Determines Transaction Manager

### The Discovery Process (from the video)

<b>Step 1: Navigate to Spring Boot Auto-Configuration</b>

Project Libraries<br />→ spring-boot-autoconfigure.jar<br />→ META-INF/spring/<br />→ org.springframework.boot.autoconfigure.AutoConfiguration.imports

<b>Step 2: Find JPA Auto-Configuration</b>

<code>org.springframework.boot.autoconfigure.AutoConfiguration.imports
  → Search for: JpaRepositoriesAutoConfiguration
    → Opens: HibernateJpaAutoConfiguration
      → Imports: JpaBaseConfiguration</code>

<b>Step 3: Check the Conditions</b>

```javascript
@Configuration
@ConditionalOnClass({ LocalContainerEntityManagerFactoryBean.class, EntityManager.class })
@ConditionalOnBean(DataSource.class)
@ConditionalOnMissingBean(type = "JpaTransactionManager")
public class JpaBaseConfiguration {
    
    @Bean
    @ConditionalOnMissingBean(TransactionManager.class)
    public JpaTransactionManager transactionManager(...) {
        return new JpaTransactionManager();
    }
}
```

### Key Auto-Configuration Logic

<b>Spring creates a transaction manager based on:</b>

1. <b>@ConditionalOnClass</b>: Are JPA classes on classpath?
2. <b>@ConditionalOnBean(DataSource.class)</b>: Is there a DataSource bean?
3. <b>@ConditionalOnMissingBean</b>: Did you define your own TransactionManager?

<b>If you don't explicitly define a TransactionManager bean</b>, Spring auto-configures one based on your dependencies.

---

## The Three Main Transaction Managers

### 1. <b>DataSourceTransactionManager</b> (JDBC)

<b>Use Case</b>: Pure JDBC operations (JdbcTemplate, NamedParameterJdbcTemplate)

<code><dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency></code>

<b>What it manages</b>:

- Direct JDBC <code>Connection</code> objects
- Works with <code>java.sql.Connection</code>
- Manages connection lifecycle: begin, commit, rollback

```javascript
@Service
public class AccountService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional  // Uses DataSourceTransactionManager
    public void transfer(Long from, Long to, double amount) {
        jdbcTemplate.update(
            "UPDATE accounts SET balance = balance - ? WHERE id = ?", 
            amount, from
        );
        jdbcTemplate.update(
            "UPDATE accounts SET balance = balance + ? WHERE id = ?", 
            amount, to
        );
    }
}


// Internal Behavior:

Connection conn = dataSource.getConnection();
conn.setAutoCommit(false);  // Start transaction
try {
    // Your JDBC operations
    conn.commit();
} catch (Exception e) {
    conn.rollback();
}
```

---

### 2. <b>JpaTransactionManager</b> (JPA/Hibernate)

<b>Use Case</b>: JPA/Hibernate operations (EntityManager, Spring Data JPA)

<b>Configuration Trigger</b>:

<code><dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency></code>

<b>What it manages</b>:

- JPA <code>EntityManager</code>
- Hibernate <code>Session</code> (since Hibernate is the default JPA provider)
- First-level cache (persistence context)
- Lazy loading within transaction boundaries

```javascript
@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository; // Spring Data JPA
    
    @Transactional  // Uses JpaTransactionManager
    public void transfer(Long from, Long to, double amount) {
        Account sender = accountRepository.findById(from).get();
        Account receiver = accountRepository.findById(to).get();
        
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
        
        // No explicit save needed if entities are managed!
        // JPA tracks changes and flushes on commit
    }
}
//Internal Behavior:
// Pseudo-code
EntityManager em = entityManagerFactory.createEntityManager();
EntityTransaction tx = em.getTransaction();
tx.begin();
try {
    // Your JPA operations
    // Persistence context tracks entity changes
    em.flush();  // Sync changes to DB
    tx.commit();
} catch (Exception e) {
    tx.rollback();
}
```

<p />

<b>Key Difference</b>: JPA manages <b>entities</b> and their state, not just SQL.

---

### 3. <b>JdbcTransactionManager</b> (Legacy/Specialized)

<b>Note</b>: In modern Spring Boot, <code>DataSourceTransactionManager</code> is used instead of a separate <code>JdbcTransactionManager</code>. They're essentially the same for JDBC operations.

Note: <code>JdbcTransactionManager</code> is a simplified modern alternative to <code>DataSourceTransactionManager</code>, introduced in Spring 5.3+. Functionally, they behave the same for typical single-database JDBC use cases.

## <b>How to Check Which Transaction Manager is Active</b>

### Method 1: Enable Debug Logging

```javascript
@Service
public class AccountService {
    
    @Autowired
    private PlatformTransactionManager transactionManager;
    
    public void checkTransactionManager() {
        System.out.println("Transaction Manager: " + 
            transactionManager.getClass().getName());
        // Output: org.springframework.orm.jpa.JpaTransactionManager
    }
}
```

### Method 2: Debugging in Code

```javascript
@Configuration
public class TransactionConfig {
    
    @Bean
    @Primary
    public JpaTransactionManager jpaTransactionManager(
            EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
    
    @Bean
    public DataSourceTransactionManager jdbcTransactionManager(
            DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
```

### Method 3: Breakpoint in TransactionInterceptor

Set breakpoint at line 348 in <code>TransactionAspectSupport.createTransactionIfNecessary()</code> and inspect the <code>transactionManager</code> variable.

| Transaction Manager | Used For | Backed By | Manages |
| --- | --- | --- | --- |
| <code>DataSourceTransactionManager</code> | Plain JDBC | <code>java.sql.Connection</code> | Connection lifecycle (commit/rollback) |
| <code>JpaTransactionManager</code> | JPA/Hibernate | <code>EntityManager</code> / <code>Session</code> | Persistence context, entity state, lazy loading |
| <code>JtaTransactionManager</code> | Distributed transactions (multiple resources) | JTA | Global transactions across multiple DBs or JMS |

<p />
