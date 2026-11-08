# Spring Transaction Managers & IoC Context Behavior

Source: https://app.notion.com/p/2a2fc75cbbd980d6864ed197e68d9b81?pvs=204

## When Both JPA and JDBC Starters Exist

If your application includes <b>both</b> dependencies:

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

<br />Spring Boot's <b>auto-configuration uses conditional logic</b>, not runtime selection from semi-initialized beans. Here's what actually happens:

```java
// Spring Boot's auto-configuration logic (simplified)

// JpaTransactionManager is created ONLY if:
@ConditionalOnClass(EntityManager.class)  // JPA classes exist
@ConditionalOnBean(DataSource.class)       // DataSource bean exists
@ConditionalOnMissingBean(TransactionManager.class) // No TM already defined
public class JpaBaseConfiguration {
    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
}

// DataSourceTransactionManager is created ONLY if:
@ConditionalOnClass(JdbcTemplate.class)
@ConditionalOnMissingBean(TransactionManager.class) // Key: checks if TM exists
public class DataSourceTransactionManagerAutoConfiguration {
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager();
    }
}
```

<b>Key Points:</b>

- ✅ Spring creates <b>only ONE</b> transaction manager bean, not multiple semi-initialized ones
- ✅ If you have both <code>spring-boot-starter-data-jpa</code> AND <code>spring-boot-starter-jdbc</code>, <b>JpaTransactionManager wins</b> (it's evaluated first)
- ✅ <code>@ConditionalOnMissingBean</code> prevents creating a second transaction manager
- ❌ It's NOT based on <code>application.properties</code> configuration
- ❌ It's NOT based on whether you use <code>JdbcTemplate</code> or <code>EntityManager</code> in your code

### 2. ✅ <b>Your Understanding is Partially Correct About Using Specific Managers</b>

<b>What you said:</b>

> "If I use JdbcTemplate, it will use JDBC transaction manager"

<b>Clarification:</b><br />The transaction manager is chosen <b>at application startup</b>, not based on what you use in your code

```javascript
// Scenario: Both dependencies present
// Result: JpaTransactionManager is created

@Service
public class MyService {
    @Autowired
    private JdbcTemplate jdbcTemplate; // ✅ Works fine!
    
    @Transactional // Uses JpaTransactionManager
    public void doJdbcStuff() {
        jdbcTemplate.update("UPDATE ...");
        // JpaTransactionManager can handle JDBC operations
        // because it delegates to DataSource internally
    }
}
```

<b>Why this works:</b> <code>JpaTransactionManager</code> extends <code>DataSourceTransactionManager</code> internally, so it can manage both JPA and JDBC operations.

## 🧰 About Spring IoC and Bean Injection (Correction & Clarification)

### Bean Creation Process (Simplified):

- <b>Spring IoC Container</b> scans the classpath, detects configuration classes, and registers bean definitions.
- Each bean goes through <b>three phases</b>:
  1. <b>Instantiation</b> – Object is created.
  2. <b>Dependency Injection</b> – Dependencies are injected (via constructor, setter, or field).
  3. <b>Initialization</b> – <code>@PostConstruct</code> and lifecycle callbacks run.

> ✅ “Semi-initialized” is not an official Spring term. You likely meant “i<b>nstantiated but not yet fully initialized</b>.”

### Types of Dependency Injection:

Both constructor and field injection create <b>fully initialized beans</b>, but at different lifecycle stages:

```javascript
// Constructor Injection (Recommended)
@Service
public class AccountService {
    private final AccountRepository repository;
    
    // Bean is created with all dependencies immediately
    public AccountService(AccountRepository repository) {
        this.repository = repository;
        // Dependencies are available in constructor
    }
}

// Field Injection
@Service
public class AccountService {
    @Autowired
    private AccountRepository repository; // Injected AFTER construction
    
    public AccountService() {
        // repository is NULL here!
    }
    
    @PostConstruct
    public void init() {
        // repository is available here
    }
}
```

- <b>Constructor injection</b>: Dependencies injected <b>during</b> object creation
- <b>Field injection</b>: Dependencies injected <b>after</b> object creation (via reflection)
- Both result in fully initialized beans when Spring context is ready

## 🧭 How Spring Chooses Between Multiple Implementations

If you have <b>multiple beans implementing the same interface</b>, Spring needs to know which one to inject. Spring uses <b>very specific rules</b>, not "closeness to context":

### Selection Rules:

1. <b>@Primary</b> — If one bean is annotated with <code>@Primary</code>, it’s chosen automatically.
2. <b>@Qualifier</b> — You can explicitly tell Spring which bean to use.
3. <b>Single Candidate Rule</b> — If only one bean of that type exists, Spring injects it automatically.
4. <b>By Name Fallback</b> — If multiple exist and no qualifier/primary is set, Spring matches by field or parameter name.

### Example – JPA Repository Case:

````java
// You define the INTERFACE
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByBalanceGreaterThan(double balance);
}

// Spring Data JPA creates the IMPLEMENTATION automatically
// Implementation class: SimpleJpaRepository (internal Spring class)
// You NEVER create the implementation yourself

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository; 
    // ✅ Gets auto-generated SimpleJpaRepository proxy
    // Spring creates it at runtime using CGLIB proxies
}

//If you create a custom implementation:

// Your repository interface
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Custom method you want to implement manually
    void complexCustomLogic();
}

// Custom implementation fragment interface
public interface AccountRepositoryCustom {
    void complexCustomLogic();
}

// Your manual implementation
@Component  // ✅ Must be annotated
public class AccountRepositoryImpl implements AccountRepositoryCustom {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void complexCustomLogic() {
        // Your custom JPQL/native query logic
        entityManager.createQuery("...").executeUpdate();
    }
}

// Spring Data JPA automatically detects "Impl" suffix and merges
public interface AccountRepository 
    extends JpaRepository<Account, Long>, AccountRepositoryCustom {
    // Now has both auto-generated and custom methods
}
```

**Spring merges:**
- Auto-generated CRUD methods from `SimpleJpaRepository`
- Your custom methods from `AccountRepositoryImpl`

**Naming convention matters:**
- Repository interface: `AccountRepository`
- Custom implementation: `AccountRepositoryImpl` (must end with `Impl`)

---

## Summary: The Decision Tree
```
Does Spring need to inject a bean of type X?
│
├─ Is there only ONE bean of type X?
│  └─ ✅ Use that bean (Rule 4)
│
├─ Are there MULTIPLE beans of type X?
│  │
│  ├─ Is @Qualifier specified?
│  │  └─ ✅ Use the bean matching @Qualifier (Rule 2)
│  │
│  ├─ Is one marked with @Primary?
│  │  └─ ✅ Use the @Primary bean (Rule 1)
│  │
│  ├─ Does variable/parameter name match a bean name?
│  │  └─ ✅ Use the matching bean (Rule 3)
│  │
│  └─ ❌ Throw NoUniqueBeanDefinitionException
````
