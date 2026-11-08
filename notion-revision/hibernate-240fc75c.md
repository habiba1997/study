# Hibernate

Source: https://app.notion.com/p/240fc75cbbd9800381f4f6b91e1145d1?pvs=204

### <b>Persist</b>, F<b>ind</b>, R<b>efresh</b>, D<b>etach</b>, and M<b>erge</b>

<p>
 These methods are crucial for managing the lifecycle and state transitions of entity objects within the persistence context, which acts as a first-level cache or a managed environment for entity instances.
</p>

<p />

<b>The persistence context</b> bridges the Java application and the underlying database, ensuring synchronization between in-memory entities and their corresponding database records.

It is as a cache within the JVM heap that holds entity objects managed by JPA/Hibernate during a transaction. It explains that the Entity Manager interface is used to interact with this persistence context, allowing operations on entities that eventually translate into database CRUD (Create, Read, Update, Delete) operations.

<p>
The <b><u>persist</u></b> method adds a new entity to the persistence context and schedules an insert operation during transaction commit. Updates are handled implicitly through “dirty checking”—Hibernate detects changes in managed entities and generates update queries automatically. 
</p>

The <b><u>find</u></b> method retrieves an entity by its primary key, first checking the persistence context cache before querying the database.

The <b><u>refresh</u></b> method is used to reset an entity’s state in the persistence context to match the current database state, <b>discarding</b> any unsaved changes. Conversely, <b>merge</b> is the reverse operation where changes made to a <b>detached entity</b> (an entity no longer managed by the persistence context) are merged back into the persistence context and subsequently synchronized with the database.

The <b>detach</b> method explicitly removes an entity from the persistence context, making it unmanaged so that changes to it are no longer tracked by Hibernate. This is useful for scenarios where changes should not be persisted automatically but can later be reattached using <b>merge</b> if needed.

The <i><b>persistent</b></i><b> instance is “online,”</b> whereas the <i><b>detached</b></i><b> instance is “offline”</b> and is not monitored for changes. This means that when we change the fields of a <i>persistent</i> object, we don’t have to call <i>save</i>, <i>update,</i> or any of those methods to get these changes to the database. All we need to do is commit the transaction, flush the session, or close the session.

### JPA Vs Hibernate

<b>JPA</b> = <i>The interface / contract</i>

<b>Hibernate</b> = <i>One popular implementation of that contract</i>

---

### <b>JPA (Java Persistence API)</b>

- A <b>Java specification</b> (part of Jakarta EE) for object-relational mapping (ORM).
- Defines <i>how</i> Java objects map to database tables, <i>how</i> queries are written, and <i>how</i> persistence is managed — but does <b>not</b> provide the actual code.
- Examples of what JPA defines:
  - Annotations like <code>@Entity</code>, <code>@Id</code>, <code>@OneToMany</code>
  - <code>EntityManager</code> API for persisting/fetching data
  - JPQL query language
- Requires a provider (implementation) to work.

---

### <b>Hibernate</b>

- A <b>framework</b> that implements the JPA specification.
- Also adds many extra features beyond standard JPA:
  - Hibernate Query Language (HQL)
  - Caching
  - Automatic dirty checking
  - Advanced fetching strategies

### Details

In Hibernate, the persistence context is represented by the [<i>org.hibernate.Session</i>](http://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/Session.html) instance. For JPA, it’s the [<i>jakarta.persistence.EntityManager</i>](http://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html). When we use Hibernate as a JPA provider, and operate via the <i>EntityManager</i> interface, the implementation of this interface basically wraps the underlying <i>Session</i> object.

Hibernate was the most successful Java ORM implementation. As such, the Hibernate API heavily influenced the specifications for the Java persistence API (JPA). Unfortunately, there were also many differences, some major and some more subtle.

To act as an implementation of the JPA standard, Hibernate APIs had to be revised. To match the <i>EntityManager</i> interface. several methods were added to the <i>Session</i> interface. These methods serve the same purpose as the original methods, but conform to the specification, and thus have some differences.

The <i>save</i> method is an “original” Hibernate method that doesn’t conform to the JPA specification.

As with <i>persist</i> and <i>save</i>, the <i>update</i> method is an “original” Hibernate method. Its semantics differ in several key points:

saveOrUpdate method appears only in the Hibernate API and doesn’t have its standardized counterpart.

if we don’t have any special requirements, we should stick to the <i>persist</i> and <i>merge</i> methods because they’re standardized and will conform to the JPA specification.

Starting with hibernate 6 the following methods was marked as deprecated and is not encouraged to use:

- save
- update
- saveOrUpdate

> The update() and saveOrUpdate() operations were, essentially, a failed experiment from early in the history of Hibernate, and were replaced by merge() in the JPA spec. It seems clear to me that users have had many fewer problems with merge() than with update(), and I think we probably should have deprecated these operations long ago.

> https://github.com/hibernate/hibernate-orm/discussions/4520

### <b>Highlights</b>

- 🗃️ Persistence context acts as a cache managing entity states in JPA/Hibernate.
- 🔄 <b>Persist</b> method inserts new entities by adding them to the persistence context.
- 🔍 <b>Find</b> method first checks cache before querying the database for entities by primary key.
- ♻️ <b>Refresh</b> resets an entity’s state from the database, discarding unsaved changes.
- 🔗 <b>Merge</b> synchronizes detached entity changes back into the persistence context.
- 🚪 <b>Detach</b> removes an entity from the persistence context, stopping Hibernate from tracking changes.
- ⚙️ <b>Entity Manager Factory</b> creates Entity Manager instances to interact with the persistence context.

### <b>Key Insights</b>

- 🧠 <b>Persistence Context as a First-Level Cache:</b> The persistence context is a crucial concept in JPA, acting as a cache that manages entity objects during a transaction. It helps improve performance by reducing unnecessary database calls, as entities are loaded once and reused within a transaction scope. This also ensures consistency between the in-memory entity state and the database. Understanding this is fundamental to mastering JPA operations.
- 🔄 <b>Persist and Implicit Update via Dirty Checking:</b> The persist method not only inserts new entities but also plays a role in updating entities within the persistence context. Hibernate’s automatic dirty checking detects changes in managed entities and triggers update queries upon transaction commit. This implicit mechanism removes the need for explicit update calls, simplifying development and reducing human error.
- 🔍 <b>Efficiency of Find Method Using Cache Lookup:</b> The find method optimizes data retrieval by first checking if the entity is already present in the persistence context. This avoids redundant database queries, improving application efficiency. This mechanism highlights the importance of the persistence context in managing entity lifecycle and reducing latency.
- ♻️ <b>Refresh Method for Entity State Synchronization:</b> The refresh method is vital when the current in-memory entity state may be stale or unknown, especially in concurrent applications where other transactions might modify the database. By discarding local changes and reloading the entity from the database, it guarantees that the application works on the most recent and consistent data.
- 🔗 <b>Merge Enables Synchronization of Detached Entities:</b> Detached entities, which are not tracked by the persistence context, can be merged back to synchronize their changes. This is essential in long-running conversations or distributed systems where entities might be serialized and later updated. Merge provides a controlled way to reattach and update these entities without losing changes.
- 🚪 <b>Detach to Control Change Tracking:</b> Detaching entities is useful when changes should not be automatically tracked or persisted, giving developers fine-grained control over transactions. This can prevent unintended updates and is useful in scenarios like read-only operations or when manipulating entities temporarily without affecting the database.
- ⚙️ <b>Entity Manager Lifecycle and Factory Management:</b> The Entity Manager Factory is a heavyweight object created once per application lifecycle, while Entity Manager instances are lightweight and short-lived, created per operation or transaction. This distinction is important for resource management and application performance, especially in frameworks like Spring where Entity Manager Factory is managed as a singleton bean.

The video not only explains each method’s functionality but also demonstrates the interplay between the persistence context, entity states (transient, managed, detached), and database operations. This understanding is essential for building robust JPA applications that efficiently manage data consistency and transactional integrity.

<p />

<p />

<page url="https://app.notion.com/p/2ddfc75cbbd980d89c78c6a86c71d827">
<b>Hibernate Dialect</b> 
</page>
