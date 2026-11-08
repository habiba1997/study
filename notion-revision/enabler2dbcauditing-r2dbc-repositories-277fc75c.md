# EnableR2dbcAuditing && R2DBC repositories

Source: https://app.notion.com/p/277fc75cbbd980dca441ff7b72dcba8f?pvs=204

<code>@EnableR2dbcAuditing</code> in Spring Data is the annotation that <b>turns on automatic population of auditing fields</b> when you’re using <b>R2DBC repositories</b>.

### 🔑 What it does

- Activates a bean like <code>ReactiveIsNewAwareAuditingHandler</code>.
- Makes Spring automatically set values for special annotations on your entities:
  - <code>@CreatedDate</code> → auto-fill creation timestamp.
  - <code>@LastModifiedDate</code> → auto-fill update timestamp.
  - <code>@CreatedBy</code> / <code>@LastModifiedBy</code> → auto-fill user info (if an auditor provider is configured).

### ✅ Example

```java
@Table("users")
public class User {

    @Id
    private Long id;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    // getters/setters
}


```

With <code>@EnableR2dbcAuditing</code> in a <code>@Configuration</code> class:

```java
@Configuration
@EnableR2dbcAuditing
public class DataConfig {
}


```

When you save a new <code>User</code>, Spring will automatically set <code>createdAt</code> and <code>updatedAt</code> for you (reactively, since it’s R2DBC).

---

📌 In short:

- <b>Without it</b> → you must manually set auditing fields.
- <b>With it</b> → Spring handles timestamps (and optionally users) whenever you persist/update an entity via R2DBC repositories

---

### 1. <b>What is “auditing” in Spring Data?</b>

In Spring, <i>auditing</i> means <b>automatically keeping track of metadata about your entities</b> — things like:

- <b>When</b> a record was created → <code>@CreatedDate</code>
- <b>When</b> it was last updated → <code>@LastModifiedDate</code>
- <b>Who</b> created it → <code>@CreatedBy</code>
- <b>Who</b> last modified it → <code>@LastModifiedBy</code>

Instead of you manually setting these fields, Spring does it automatically whenever you save or update entities.

---

### 2. <b>What are R2DBC repositories?</b>

- <b>R2DBC</b> = Reactive Relational Database Connectivity.
  <p>
  It’s like JDBC but <b>non-blocking</b> and works with reactive programming (<code>Flux</code> / <code>Mono</code>).
  </p>
- <b>R2DBC repositories</b> are the Spring Data way to access relational databases <b>reactively</b>.

📌 Example:

```java
public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
    Flux<Order> findByStatus(String status);
}


```

This gives you methods like <code>findAll()</code>, <code>save()</code>, <code>deleteById()</code> — but returning <code>Mono<T></code> or <code>Flux<T></code> (reactive types) instead of blocking objects.

---

### 3. <b>How they work together</b>

- If you use R2DBC repositories with auditing enabled (<code>@EnableR2dbcAuditing</code>),
  <p>
  → then when you <code>save()</code> an entity, Spring will <b>auto-populate those audit fields</b>.
  </p>

So:

- <b>R2DBC repository</b> = reactive way to talk to DB.
- <b>Auditing</b> = auto-managing created/updated/by fields.
