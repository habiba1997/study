# Interview topic and terminology index

Consolidated on 15 October 2026 from the Study repository and the supplied Java-plan chat handoff. Rechecked against GitHub main at `3493c78`, including the newly added Gaps folder; the original study files match the earlier `2c7dd17` snapshot.

This is a question-selection and recall index. It brings together topics, named concepts, comparisons, tools, annotations, APIs, and terminology found in the source prose, tables, examples, and PDF diagrams. Related terms are grouped; the source inventories at the end preserve where topics appear. A term appearing here does not mean it has already been practiced or mastered.

Scope excludes incidental example names, sample passwords/tokens, personal contact information, local computer paths, repeated form controls, and ordinary words that are not study concepts. Project names identify study scenarios; they do not establish production experience or personal ownership. The original documents remain the place to read full explanations. Some explanations need the corrections noted below.

## Sources and navigation

| Key | Source | Reviewed material |
| --- | --- | --- |
| J | [Java and Spring cheat sheet](java-spring-cheatsheet.md) | All 1,694 lines, including migration notes, examples, tables, and corrections |
| F | [Frontend cheat sheet](frontend-cheatsheet.md) | All 739 lines, including JavaScript, TypeScript, React, Angular, and tooling |
| A | [Architecture patterns cheat sheet](architecture-patterns-cheat-sheet.md) | All 1,303 lines, including diagrams, comparisons, deployment strategies, and final glossary |
| H | [Interview preparation cheat sheet](habiba-interview-prep-cheatsheet.md) | All 512 lines, including migration, messaging, project, testing, and leadership topics |
| P | [Java reference PDF](java.pdf) | All 145 pages; text, tables, code, and embedded diagrams/screenshots |
| N | [Practice notes](notes.md) | All 14 lines, including strings, interfaces, overriding, and hashing |
| R | [Project interview reference](project-interview-reference.md) | All 259 lines, including implementation caveats and project-specific discussion topics |
| S | [Principal self-assessment](Principal%20-%20Self-Assessment.pdf) | All 14 pages; all 33 competency prompts and their detailed breakdowns |
| README | [Repository README](README.md) | All 15 lines; repository purpose and scope |
| G0 | [Gap-tracking overview](Gaps/README.md) | All 8 lines; terminology recall versus domain study |
| G1 | [DDD recall topics](Gaps/Domains/DDD.md) | All 24 lines; boundaries, entities, aggregates, and scenarios |
| G2 | [Deployment recall topics](Gaps/Domains/Deployment-Strategies.md) | All 28 lines; strategy names, recognition, and trade-offs |
| G3 | [JWT recall topics](Gaps/Terminology/JWT-Parts.md) | All 25 lines; token parts, signature verification, and claims |
| C | Supplied Java-plan chat handoff | Additional practice topics and coaching continuity; attachment supplied in chat, not copied into the public repository |

The five uploaded study files were byte-for-byte identical to the repository copies. Sources N, R, S, and G0–G3 extend the uploaded set. References to outside projects in R were read as documentation; those external project folders were not available for inspection here. P contains an already-broken image placeholder on page 88; its surrounding inheritance text and schema diagrams were readable.

### Main study areas

1. [Java foundations and OOP](#01-java-foundations-and-oop)
2. [Strings, equality, and immutability](#02-strings-equality-and-immutability)
3. [Collections, hashing, and trees](#03-collections-hashing-and-trees)
4. [Functional Java and streams](#04-functional-java-and-streams)
5. [Exceptions and resources](#05-exceptions-and-resources)
6. [Hardware, memory, JVM, and diagnostics](#06-hardware-memory-jvm-and-diagnostics)
7. [Concurrency and asynchronous Java](#07-concurrency-and-asynchronous-java)
8. [Java versions and tooling](#08-java-versions-and-tooling)
9. [HTTP, REST, and API design](#09-http-rest-and-api-design)
10. [Spring container and dependency injection](#10-spring-container-and-dependency-injection)
11. [AOP and transactions](#11-aop-and-transactions)
12. [Spring web and Boot](#12-spring-web-and-boot)
13. [SQL, JDBC, and query performance](#13-sql-jdbc-and-query-performance)
14. [JPA, Hibernate, and Spring Data](#14-jpa-hibernate-and-spring-data)
15. [Caching](#15-caching)
16. [Security, JWT, OAuth, and OIDC](#16-security-jwt-oauth-and-oidc)
17. [Browser security and cryptography](#17-browser-security-and-cryptography)
18. [Testing and verification](#18-testing-and-verification)
19. [Maven and dependency management](#19-maven-and-dependency-management)
20. [Modernization and migration](#20-modernization-and-migration)
21. [Distributed systems and service integration](#21-distributed-systems-and-service-integration)
22. [Events, messaging, and delivery](#22-events-messaging-and-delivery)
23. [CQRS, event sourcing, and snapshots](#23-cqrs-event-sourcing-and-snapshots)
24. [Saga, 2PC, outbox, and idempotency](#24-saga-2pc-outbox-and-idempotency)
25. [DDD and architectural boundaries](#25-ddd-and-architectural-boundaries)
26. [Object-oriented design patterns](#26-object-oriented-design-patterns)
27. [Batch processing and background jobs](#27-batch-processing-and-background-jobs)
28. [Containers, cloud, delivery, and operations](#28-containers-cloud-delivery-and-operations)
29. [Deployment and release strategies](#29-deployment-and-release-strategies)
30. [JavaScript and browser fundamentals](#30-javascript-and-browser-fundamentals)
31. [TypeScript and frontend structure](#31-typescript-and-frontend-structure)
32. [React, Angular, and state management](#32-react-angular-and-state-management)
33. [Frontend routing, forms, HTTP, and RxJS](#33-frontend-routing-forms-http-and-rxjs)
34. [Frontend build tools and performance](#34-frontend-build-tools-and-performance)
35. [AI, RAG, agents, and retrieval security](#35-ai-rag-agents-and-retrieval-security)
36. [Go, C++, and platform comparisons](#36-go-c-and-platform-comparisons)
37. [Project scenarios and engineering leadership](#37-project-scenarios-and-engineering-leadership)

38. [Relational modeling, normalization, and integrity](#38-relational-modeling-normalization-and-integrity)
39. [Advanced SQL, CTEs, and window functions](#39-advanced-sql-ctes-and-window-functions)
40. [Index design and storage structures](#40-index-design-and-storage-structures)
41. [Query plans, statistics, and database tuning](#41-query-plans-statistics-and-database-tuning)
42. [Database transactions, isolation, and MVCC](#42-database-transactions-isolation-and-mvcc)
43. [Locking, contention, and deadlocks](#43-locking-contention-and-deadlocks)
44. [Views, materialized views, and database programming](#44-views-materialized-views-and-database-programming)
45. [Table partitioning and data lifecycle](#45-table-partitioning-and-data-lifecycle)
46. [Sharding and distributed data placement](#46-sharding-and-distributed-data-placement)
47. [Replication, read replicas, and failover](#47-replication-read-replicas-and-failover)
48. [Database scaling and system-design tradeoffs](#48-database-scaling-and-system-design-tradeoffs)
49. [Backup, recovery, and database operations](#49-backup-recovery-and-database-operations)
50. [Schema evolution, data migration, and CDC](#50-schema-evolution-data-migration-and-cdc)

51. [Creational and structural design patterns](#51-creational-and-structural-design-patterns)
52. [Behavioral patterns and pattern selection](#52-behavioral-patterns-and-pattern-selection)

Then use [important distinctions](#important-distinctions-and-source-caveats), [practice order](#practice-order-and-session-format), and the source inventories below to locate material.

## 01 Java foundations and OOP

Sources: J, N, P pp. 13–20, H, C.

- **Objects and types:** class; object; instance; blueprint; state; behavior; fields; attributes; member methods; constructors; reference type; actual object type; declared reference type; superclass; subclass; parent/child class; `Object`; `Class`.
- **Four OOP principles:** encapsulation; abstraction; inheritance; polymorphism; data hiding; contracts; implementation hiding; modularity; maintainability.
- **Relationships:** association; aggregation; composition; ownership; object lifecycle; is-a versus has-a; composition over inheritance; single class inheritance; multiple interface inheritance.
- **Interfaces and abstract classes:** `interface`; `abstract class`; abstract methods; shared state; partial implementation; abstract class with no abstract methods; interface constants (`public static final`); `default` methods; static interface methods; private interface helpers; interface constructors; interface method visibility; backward-compatible interface evolution.
- **Method selection:** overloading; overriding; method signature; parameter list; return-type-only overload prohibition; covariant return type; compile-time/static/early binding; runtime/dynamic/late binding; virtual method dispatch; static method hiding; field hiding; reference-type versus object-type selection.
- **Access:** `public`; `protected`; package-private/default access; `private`; access widening; forbidden access narrowing on overrides; checked-exception restrictions on overrides; top-level versus nested type access.
- **Members and modifiers:** instance/member variable; class/static variable; static method; private static utility; static initializer block; static nested class; `final` field/variable; final reference versus mutable object; final method; final class; `transient`; `this`; `super`; `new`; `extends`; `implements`.
- **Language constructs:** primitive types (`int`, `long`, `boolean`, `char`, etc.); wrappers (`Integer`, `Long`, `Boolean`, `Double`); autoboxing; unboxing; null unboxing; enums; named constants; anonymous class; anonymous function; varargs/variable-length arguments (`Type...`); array parameter; pre-increment; post-increment; switch statement; case labels; compile-time constants; `break`; fall-through; `default`; switch expression; arrow labels; exhaustive switch.
- **Serialization and copying:** serialization; deserialization; byte stream; Java object serialization versus JSON mapping; `Serializable`; `serialVersionUID`; marker interface; `Cloneable`; `Object.clone()`; `CloneNotSupportedException`; copy constructor; shallow copy; deep/defensive copy; `RandomAccess`; `ObjectOutputStream.writeObject`; `ObjectInputStream.readObject`; `FileOutputStream`; `FileInputStream`.
- **Reflection and metadata:** runtime inspection; fields/methods/constructors; `Class.forName`; `Class.getMethod`; `Method.invoke`; reflective instantiation; annotations; bytecode manipulation; runtime reflection versus compile-time code generation; generics; type parameters; type erasure; type safety.

## 02 Strings, equality, and immutability

Sources: N, J, P pp. 18, 87, 142–143, C.

- **Strings:** `String`; string immutability; `String.concat()`; returned value versus mutation; reference reassignment; `StringBuilder`; `StringBuilder.append()`; `StringBuffer`; synchronized methods; local versus shared builders; `charAt(0)`.
- **Equality:** `==`; reference identity; value equality; `equals()`; `hashCode()`; equal objects must have equal hashes; equal hashes need not mean equal objects; mutable map keys; stable key fields; boxed integer cache; `Integer.valueOf`; object identity versus domain identity.
- **Immutability:** mutable versus immutable; immutable class; private final fields; constructor validation; defensive copying on input/output; shallow immutability; nested mutable collections; unmodifiable wrapper versus immutable contents; `Collections.unmodifiableList`; `List.copyOf` as a related defensive-copy practice, beyond the handoff's Java 8 example.
- **Collection construction:** `ArrayList`; `Arrays.asList`; fixed-size list; `Collections.singletonList`; unmodifiable singleton list; mutable list copy; `add()`; `set()`; `remove()`; `UnsupportedOperationException` as the behavior to recognize in these list exercises; `List.of`; `Set.of`; `Map.of`.
- **Records:** `record`; components; canonical constructor; component accessors (`name()` rather than `getName()`); generated `equals`, `hashCode`, `toString`; final record class; final component fields; shallow versus deep immutability; defensive copying of a record's collection component.

## 03 Collections, hashing, and trees

Sources: J, N, P pp. 7–13, 54–56, 64–68, C.

- **Collection families:** array; `Collection`; `Collections`; `List`; `Set`; `Queue`; `Deque`; `Map`; `ArrayList`; `LinkedList`; `HashSet`; associative array/dictionary; key-value pair; unique map key; duplicate value; index-based versus key-based access.
- **Costs and storage:** fixed size versus dynamic resizing; random access; sequential access; insertion/deletion/search/lookup; iteration order; memory overhead; contiguous storage; node/pointer storage; fragmentation; Big O; O(1); O(n); O(log n); amortized operations; cache locality.
- **Hashing:** hash function; hash code; bucket; bucket index; hash table; hash collision; key equality; duplicate key versus collision; load factor; resizing; rehashing; chaining; separate chaining; linked-list bucket; tree bin; red-black tree; treeification.
- **Open addressing:** probing sequence; linear probing; quadratic probing; double hashing; tombstone; occupied slot; contiguous table; collision-resolution trade-offs.
- **Map implementations:** `HashMap` (unspecified order); `LinkedHashMap` (insertion/access order); `TreeMap` (sorted keys); natural ordering; `Comparable.compareTo`; `Comparator`; null-key handling; `NavigableMap`; `firstKey`; `floorKey`; `ceilingKey`; `headMap`; `tailMap`; `subMap`; `removeEldestEntry`; LRU cache.
- **Map and collection APIs:** `put`; `get`; `containsKey`; `entrySet`; `size`; `putIfAbsent`; `computeIfAbsent`; `merge`; `remove`; `poll`; `peek`; iterator; for-each; internal versus external iteration; fail-fast behavior; `ConcurrentModificationException`; snapshot iteration; weakly consistent iteration.
- **Trees:** node; root; left/right subtree; balanced tree; binary tree; red-black tree; recursion; pre-order (root-left-right); in-order (left-root-right); post-order (left-right-root); level-order; breadth-first search/BFS; tree traversal.
- **Concurrent collections:** `ConcurrentHashMap`; Java 7 segment locking versus Java 8+ per-bin coordination and CAS; atomic single-key operations; check-then-act race; compound operations; `ConcurrentLinkedQueue`; nonblocking FIFO queue; unbounded queue; `CopyOnWriteArrayList`; copying the backing array; read-heavy workloads.

## 04 Functional Java and streams

Sources: J, P pp. 12–13, 57–68, 119, 130–133, C.

- **Functional vocabulary:** lambda expression; anonymous function; method reference (`::`); functional interface; single abstract method/SAM; declarative processing; stateless operation; side effects; pure function.
- **Functional interfaces:** `Predicate.test`; `Function.apply`; `Supplier.get`; `Consumer.accept`; `Runnable.run`; `BinaryOperator`; `BiFunction`; `BiConsumer`; generics and wildcard bounds in functional signatures.
- **Pipelines:** stream source; intermediate operation; terminal operation; lazy evaluation; eager evaluation; single-use stream; `stream()`; `parallelStream()`; `parallel()`; `filter`; `map`; `sorted`; `forEach`; `count`; `collect`; `findFirst`; `Files.lines`; `Arrays.stream`; `IntStream.rangeClosed`; resource-backed streams.
- **Reduction:** `reduce`; identity; accumulator; combiner; associativity; valid neutral identity; empty stream; optional result; repeated nonneutral identity in parallel reduction; partial results; merging costs.
- **Collectors:** `Collectors.toList`; `Collectors.toSet`; `Collectors.joining`; `Collectors.toMap`; duplicate map-key failure; merge function; keeping first versus last value; grouping multiple values by one key; `Map<Character, List<String>>` versus `Map<Character, String>`.
- **Optional:** present/empty value; null alternative; `Optional`; `ifPresent`; `orElse`; `orElseGet`; eager fallback evaluation versus lazy supplier; return-type use.
- **Parallel execution:** sequential versus parallel streams; encounter/execution order; source splitting; merging; worker pool; common `ForkJoinPool`; fork/join framework; task threshold; `RecursiveTask`; `RecursiveAction`; work stealing; per-worker deque; `ForkJoinPool.common.parallelism`; CPU-bound versus I/O-bound work.
- **Performance model:** scheduling overhead; uneven split; ArrayList versus LinkedList splitting; primitive array versus boxed array; memory locality; hardware prefetch; benchmark; NQ model (element count N × work per element Q); measurement before parallelization.

## 05 Exceptions and resources

Sources: J, P pp. 25–28, 43–47, S competencies 11–12, R, C.

- **Hierarchy:** `Throwable`; `Exception`; `RuntimeException`; `Error`; checked versus unchecked; compiler catch-or-declare rule; runtime occurrence of both checked and unchecked exceptions.
- **Named failures:** `IOException`; `FileNotFoundException`; `SQLException`; `ClassNotFoundException`; `InvocationTargetException`; `NullPointerException`; `IllegalArgumentException`; `IndexOutOfBoundsException`; `ArrayIndexOutOfBoundsException`; `ArithmeticException`; `NumberFormatException`; `IllegalStateException`; `InterruptedException`; `ExecutionException`; `OutOfMemoryError`; `StackOverflowError`; `NoClassDefFoundError`; `InaccessibleObjectException`.
- **Handling:** `throw` versus `throws`; `try`; `catch`; specific-before-general catches; multiple catch blocks; multi-catch (`|`); rethrow; propagation; exception chaining/context; custom/domain-specific exception; meaningful message; swallowed exception; empty catch; cleanup; `finally`; return in finally; try-with-resources; `AutoCloseable`; reverse close order.
- **Application policies:** asynchronous exception handling; global exception middleware/interceptor; exception governance; centralized logging/tracking; appropriate HTTP status; consistent error response; preventing implementation-detail leakage; typed success/error result versus error text returned as ordinary data.

## 06 Hardware, memory, JVM, and diagnostics

Sources: J, P pp. 8, 20–24, 43–47, 65–75, 139–145.

- **Hardware:** CPU/central processing unit; processor; core; register; CPU cache; L1/L2/L3; cache line; cache hit/miss; spatial locality; memory locality; cache friendliness; cache coherence; hardware prefetch; write buffer; instruction reordering; clock speed; clock cycle; GHz; latency/access time.
- **Storage hierarchy:** RAM/random access memory; volatile versus nonvolatile memory; SSD/solid-state drive; NAND flash; HDD/hard disk drive; optical drive; CD/DVD/Blu-ray; USB flash drive; NAS/network-attached storage; memory capacity; storage speed/cost trade-offs.
- **Runtime memory:** JVM; stack; per-thread stack; stack frame; method call frame; local variable; object reference; shared heap; arrays; instance fields; static class fields; native memory; OS-managed memory; allocation; object lifetime; runtime versus compile-time sizing; LIFO.
- **Garbage collection:** reachability; live thread; static reference; garbage collector/GC; unreachable cycles; reference counting comparison; generational collection; young generation; Eden; survivor space; old/tenured generation; allocation rate; memory reclamation; class unloading.
- **Failures:** memory leak; retained but unused objects; static growing collection; listener leak; unclosed resource; pooled `ThreadLocal`; classloader leak; Java heap space; Permanent Generation/PermGen; Metaspace; native-memory exhaustion; stack overflow; recursion base case.
- **Diagnostics:** heap dump; heap histogram; class/instance counts; per-thread allocation; thread dump; thread state; stack trace; deadlock; lock contention; starvation; CPU/memory sampling; profiling; performance bottleneck; method execution time; `jmap`; `jstack`; `kill -3`; `-XX:+HeapDumpOnOutOfMemoryError`; `-XX:MaxMetaspaceSize`.
- **Tools and screenshot terms:** VisualVM; Eclipse MAT; JProfiler; YourKit; Java Flight Recorder/JFR; JDK Mission Control/JMC; async-profiler; Javassist `ClassPool`; HotSpot; `WeakReference`; `SoftReference`; `Thread.State.WAITING`; `TIMED_WAITING`; daemon thread; parking; `LockSupport.parkNanos`; `SynchronousQueue`; `ThreadPoolExecutor`; locked ownable synchronizers.

## 07 Concurrency and asynchronous Java

Sources: J, P pp. 54–79, 130, 138–141, R concurrency lab, S competencies 14–15 and 22.

- **Core concepts:** concurrency versus parallelism; synchronous versus asynchronous; blocking versus nonblocking; thread safety; shared mutable state; race condition; lost update; read-modify-write; visibility; mutual exclusion; atomicity; critical section; contention; context switch; deadlock; starvation; consistent snapshot; business invariant.
- **Intrinsic locking:** `synchronized` method/block; instance monitor (`this`); class monitor for static synchronization; intrinsic/monitor lock; monitor ownership; reentrancy; locking scope; shared lock; lock acquisition/release.
- **Visibility and state:** `volatile`; final-field semantics; immutable objects; safe state sharing; Java memory-model ordering; cache-coherence explanation versus language-level guarantees; `ThreadLocal`; thread-bound security context; child-thread context propagation.
- **Atomics:** `AtomicInteger`; `AtomicLong`; `AtomicBoolean`; `AtomicReference`; compare-and-swap/CAS; expected/current/new value; compare-and-set; CAS retry loop; contention costs; `get`; `set`; `lazySet`; `compareAndSet`; `incrementAndGet`; `decrementAndGet`; `addAndGet`; single-variable atomicity versus workflow atomicity.
- **Explicit locks:** `Lock`; `ReentrantLock`; hold count; `lock`; `unlock`; `tryLock`; timeout; `lockInterruptibly`; fairness policy; `Condition`; `ReadWriteLock`; `ReentrantReadWriteLock`; `readLock`; `writeLock`; concurrent readers; exclusive writer; writer starvation; unlocking in finally.
- **Thread execution:** `Thread`; `start`; `run`; `sleep`; `yield`; `Object.wait`; executor; `Executor`; worker thread; fixed thread pool; task queue; submitted tasks versus simultaneous threads; core/max size; rejection policy; pool metrics; pool starvation; dedicated threads; OS thread/resource limits; `CountDownLatch` and start/end latch coordination.
- **Futures:** `Future`; `CompletableFuture`; `CompletionStage`; manual completion; callbacks; chaining; dependent versus independent stages; `get` versus `join`; `complete`; `completeExceptionally`; `supplyAsync`; `runAsync`; `thenApply`; `thenAccept`; `thenRun`; corresponding `Async` methods; `thenCompose`; `thenCombine`; `thenAcceptBoth`; `allOf`; `anyOf`; `exceptionally`; `handle`; `whenComplete`; custom executor versus common pool.
- **Virtual threads:** platform thread; OS thread; virtual thread; carrier thread; mounting/unmounting; blocking I/O; CPU-bound limitations; thread-per-task; pinning; version-specific synchronized behavior; `spring.threads.virtual.enabled`; scoped values; structured concurrency.
- **Booking lab:** capacity check plus update; overselling; atomic reservation; cancellation; atomic map removal; duplicate cancellation; counter/map agreement; concurrent reads of stats; per-instance memory versus shared authoritative state; distributed reservation boundary.

## 08 Java versions and tooling

Sources: J, H, P pp. 109, 132–143.

- **Platform:** JDK/Java Development Kit; JRE/Java Runtime Environment; JVM/Java Virtual Machine; compiler; bytecode; runtime libraries; `javac`; `java`; `jar`; `javadoc`; `jdb`; `jlink`; JavaFX (mentioned in older notes); executable JAR; standalone runtime distribution.
- **Java 8:** lambdas; streams; functional interfaces; method references; `Optional`; `java.time`; interface default/static methods; `CompletableFuture`; Nashorn; Metaspace.
- **Java 9–11:** Project Jigsaw/Java Platform Module System; `module-info.java`; `module`; `exports`; `requires`; strong encapsulation; `java.base`; `java.sql`; `java.net.http`; collection factory methods; private interface methods; JShell/REPL; reactive `Flow` API; local-variable type inference/`var`; AppCDS/application class-data sharing; HTTP/2 client; standard `HttpClient`; `String.isBlank`, `lines`, `strip`; single-file source execution; lambda-parameter syntax; Epsilon no-op GC; TLS 1.3.
- **Java 12–17:** switch expressions; text blocks; helpful NPE messages; sealed classes/interfaces; `permits`; `non-sealed`; pattern matching for `instanceof`; records; hidden classes; JVM Constants API; default CDS archives; legacy socket API changes; NUMA-aware allocation; Vector API; preview/incubator versus final features.
- **Java 18–21:** UTF-8 default; simple web server; Javadoc code snippets; virtual threads; record patterns; pattern matching for switch; sequenced collections; `getFirst`; `getLast`; `reversed`; generational ZGC; structured concurrency.
- **Java 22–25 terminology in J:** Foreign Function & Memory API; unnamed variables (`_`); stream gatherers; class-file API; module import declarations; compact source files; instance main methods; flexible constructor bodies; scoped values; compact object headers; Key Derivation Function API; primitive types in patterns; stable values; AOT class loading/linking; AOT ergonomics; AOT method profiling.
- **Compatibility and support:** LTS/long-term support; patch release; preview feature; incubator API; deprecation; removal; baseline; support lifetime; Java 8 → 17 → 21; Java 11 → 17 → 21 → 25; GC families CMS, G1, ZGC, Shenandoah; Security Manager/`SecurityManager`; `System.setSecurityManager`; `java.util.Random` interfaces; `sun.misc.Unsafe`; 32-bit x86 port; RMI Activation; Pack200; Applet API; dynamic agent loading; finalization; `Cleaner`.

## 09 HTTP, REST, and API design

Sources: J, F, H, P pp. 28–33, S competency 10.

- **Basics:** API/application programming interface; endpoint; resource; URI; URL; HTTP request/response; header; body; JSON; XML; RPC/remote procedure call; REST; RESTful API; CRUD; request-response; client/server; AJAX.
- **Methods and semantics:** GET; HEAD; POST; PUT; PATCH; DELETE; OPTIONS; safe method; idempotent method; replacement versus partial update; create/update; repeat request; state effect versus identical response; method discovery; `Allow` header.
- **Status codes:** 100 Continue; 200 OK; 201 Created; 204 No Content; 400 Bad Request; 401 Unauthorized/unauthenticated; 403 Forbidden; 404 Not Found; 405 Method Not Allowed; 409 Conflict; 422 Unprocessable Content/Entity; 429 Too Many Requests; 500 Internal Server Error; 503 Service Unavailable.
- **Headers:** `Content-Type`; MIME/media type; `Content-Length`; `Accept`; `Authorization`; Bearer; `Host`; `User-Agent`; `Set-Cookie`; `Location`; `Server`; `Cache-Control`; `ETag`; origin; scheme/host/port.
- **API maturity:** RESTful/Richardson maturity model; level 0/Swamp of POX; level 1/resources; level 2/HTTP verbs; level 3/hypermedia controls; HATEOAS/Hypermedia As The Engine Of Application State; self/action links; resource discovery.
- **API design:** consistent contracts; API documentation; URL/header/query versioning; backward compatibility; breaking/nonbreaking changes; API composition; overfetching; field selection; REST versus GraphQL; DGS; GraphQL schema; resolver/data fetcher; nested query; DataLoader/batch loader; N+1 network/database calls.

## 10 Spring container and dependency injection

Sources: J, P pp. 33–35, 40–42, 133–138, H, S competency 9.

- **Principles:** IoC/inversion of control; DI/dependency injection; service locator versus DI; loose coupling; testability; dependency inversion; container-managed construction; constructor injection; field injection; setter injection; required/optional dependencies; hidden dependencies; reflection-based injection.
- **Container APIs:** Spring container; bean; bean definition; `BeanFactory`; `ApplicationContext`; `ClassPathXmlApplicationContext`; `getBean`; `SpringApplication.run`; resource loading; internationalization; event propagation/publishing; `ApplicationContextAware`.
- **Lifecycle:** instantiation; property population; initialization callback; `@PostConstruct`; `InitializingBean.afterPropertiesSet`; `initMethod`; ready-to-use bean; destruction callback; `@PreDestroy`; `DisposableBean.destroy`; `destroyMethod`; prototype destruction responsibility.
- **Scopes:** singleton per application context; prototype; request; session; application/`ServletContext`; websocket; injecting prototype into singleton; scoped proxy; `ObjectProvider`; bean lifecycle versus GoF Singleton/Prototype.
- **Stereotypes:** `@Component`; `@Service`; `@Repository`; persistence exception translation; `DataAccessException`; `@Controller`; `@RestController`; `@ResponseBody`.
- **Wiring/configuration:** `@Autowired`; by-type matching; `required=false`; `@Qualifier`; `@Primary`; `@Configuration`; `@Bean`; XML configuration; Java configuration; annotation configuration; component scanning; `@ComponentScan`; `@Value`; property placeholder/default; `@Profile`; `@Conditional`; `@ConditionalOnClass`; `@ConditionalOnMissingBean`; `@ConditionalOnProperty`.
- **Advanced configuration:** `BeanDefinitionRegistryPostProcessor`; bean registry; add/remove/rename definition; duplicate bean definition; `NamedParameterJdbcTemplate`; multi-datasource bean selection; `@ConfigurationProperties`; `@ConstructorBinding`.
- **SpEL:** Spring Expression Language; object graph; property access; method invocation; arithmetic/relational/logical operators; regular expression; collection selection; collection projection; templating; `target`; bean references; `@Value`; security expressions; query/projection expressions.

## 11 AOP and transactions

Sources: J, P pp. 50–51, 130, 135–138, H, R, S competencies 17 and 22, C.

- **AOP terms:** aspect-oriented programming; cross-cutting concern; aspect; advice; join point; pointcut; interception; delegation; target bean; proxy; JDK dynamic proxy; CGLIB subclass proxy; self-invocation; `this.method()`; proxy boundary.
- **Aspect APIs:** AspectJ; weaving; compile-time/load-time weaving; bytecode instrumentation; `@Aspect`; `@Pointcut`; `@Before`; `@After`; `@AfterReturning`; `@AfterThrowing`; `@Around`; `JoinPoint`; `ProceedingJoinPoint`; `proceed`; execution expression.
- **Transactions:** programmatic versus declarative management; local/database transaction; begin; commit; rollback; transaction boundary; transaction attribute; `@Transactional`; `@EnableTransactionManagement`; transaction manager; `PlatformTransactionManager`; `DataSourceTransactionManager`; `JpaTransactionManager`; datasource binding.
- **Propagation:** REQUIRED; REQUIRES_NEW; SUPPORTS; MANDATORY; NOT_SUPPORTED; NEVER; NESTED; joining; suspending; independent transaction; savepoint.
- **Isolation:** READ_UNCOMMITTED; READ_COMMITTED; REPEATABLE_READ; SERIALIZABLE; dirty read; nonrepeatable read; phantom read; concurrency anomalies; throughput/consistency trade-off; database-specific behavior.
- **Failure behavior:** checked versus unchecked rollback; `rollbackFor`; rollback rules; `Error`; caught/swallowed exception; timeout; `readOnly`; method versus class annotation; advised method visibility; private/static/final method limitations; annotation presence versus verified behavior.
- **Integrity:** ACID/atomicity, consistency, isolation, durability; transaction scope; optimistic locking; pessimistic locking; deadlock prevention; multiple databases; explicit transaction-manager selection; database versus Kafka transaction boundary.

## 12 Spring web and Boot

Sources: J, P pp. 39–42, 114–116, 138–139, H.

- **Request path:** servlet container; Tomcat; Jetty; Undertow; request thread pool; servlet; front controller; `DispatcherServlet`; handler mapping; MVC/Model–View–Controller; model; view; controller; Jackson serialization; `HttpMessageConverter`; `ObjectMapper`; `writeValueAsString`; `@JsonProperty`; `@JsonIgnore`; `@JsonInclude`; `@JsonFormat`; Bean Validation; `@Valid`; `@NotNull`.
- **Filters:** servlet filter; `Filter`; `HttpFilter`; `FilterChain`; `doFilter`; request/response wrapping; raw `ServletRequest`/`ServletResponse`; `HttpServletRequest`/`HttpServletResponse`; authentication/logging/compression/CORS filters.
- **Interceptors:** `HandlerInterceptor`; `preHandle`; `postHandle`; `afterCompletion`; handler metadata; method annotations; `ModelAndView`; filter versus interceptor.
- **Web annotations:** `@GetMapping`; `@PostMapping`; `@PathVariable`; URI template; `@RequestParam`; query parameter; `@RequestBody`; `@ResponseBody`; `ResponseEntity`; `HttpStatus`; `@ControllerAdvice`; `@RestControllerAdvice`; `@ExceptionHandler`; `@ModelAttribute`; `@InitBinder`; global exception mapping.
- **Boot:** convention over configuration; auto-configuration; starter dependency; classpath conditions; `@SpringBootApplication`; `@EnableAutoConfiguration`; root-package scan; embedded server; executable JAR versus WAR/external container; `spring-boot-starter-web`; `spring-boot-starter-security`; `spring-boot-starter-test`.
- **Configuration and management:** `application.properties`; `application.yml`; profile-specific configuration; command-line/environment/file precedence; `spring.profiles.active`; Actuator; health; metrics; info; env; loggers; conditions; `--debug`; endpoint exposure; monitoring/management.
- **Client and runtime ecosystem:** `RestTemplate`; `RestClient`; `HttpClient`; `JdbcClient`; WebFlux; Kotlin; AOT processing; GraalVM native image; declarative HTTP interface; `HttpServiceProxyFactory`; `@HttpExchange`; `@GetExchange`; `RestTestClient`.

## 13 SQL, JDBC, and query performance

Sources: J, H, R, P pp. 35–39, 80–98, S competencies 16–17 and 22–24.

- **Database vocabulary:** relational database; table; row; column; schema; primary key/PK; foreign key/FK; unique constraint; `NOT NULL`; identity/auto-increment; sequence; join table; shared primary key; schema generation; database dialect; SQL vendor coupling.
- **Query operations:** SELECT; INSERT; UPDATE; DELETE; WHERE; `WHERE ... IN`; JOIN; INNER JOIN; LEFT/OUTER JOIN; subquery; subselect; UNION/UNION ALL; aggregation; SUM; AVG; COUNT; MIN; MAX; GROUP BY; sort; projection; parameterized statement; query result mapping.
- **Optimization:** execution plan; query analysis; table scan; index scan; index seek; missing index; join optimization; sort/spool cost; query hint; query performance metrics; query count; SQL logging; batch loading; N+1 queries; network round trips.
- **Views:** view versus materialized view; stored/derived read representation; denormalization; immediate/scheduled refresh; refresh strategy; read model freshness; normalized write model.
- **Access stack:** JDBC; JDBC driver; `DataSource`; connection; prepared statement; `JdbcTemplate`; `JdbcTemplate.queryForList`; `NamedParameterJdbcTemplate`; connection pool; Hikari/Hikari metrics; active connections; pool exhaustion/leak; multiple datasources; transaction boundaries.
- **Products:** PostgreSQL/Postgres; SQL Server; MySQL/InnoDB; Oracle; distributed SQL; CockroachDB; Google Spanner; TiDB; YugabyteDB; SingleStore; routing; sharding; distributed query execution.
- **Project-specific SQL:** intent-to-SQL generation; schema context; bounded SQL correction; application-defined checkout SQL; PostgreSQL function; cart/stock validation; categories before products; typed result/error handling; trusted user identity; database privileges; validation of generated operations.

## 14 JPA, Hibernate, and Spring Data

Sources: J, P pp. 35–39, 80–98, H.

- **Layers:** ORM/object-relational mapping; JPA/Java Persistence API; Jakarta Persistence; specification versus provider; Hibernate; Spring Data JPA; JDBC; `EntityManager`; `EntityManagerFactory`; `Session`; `SessionFactory`; persistence context; entity identity.
- **Repository/query APIs:** `Repository`; `CrudRepository`; `JpaRepository`; derived query method; `@Query`; JPQL; native SQL; `createQuery`; `getResultList`; paging; sorting; `@EnableJpaRepositories`; `basePackages`; `entityManagerFactoryRef`; `transactionManagerRef`.
- **Entity mapping:** `@Entity`; `@Table`; `@Id`; `@Column`; `@GeneratedValue`; GenerationType.IDENTITY, SEQUENCE, TABLE, AUTO, UUID; `@Version`; UUID; `@Enumerated`; type mapping; Boolean mapping.
- **Associations:** `@OneToOne`; `@OneToMany`; `@ManyToOne`; `@ManyToMany`; unidirectional/bidirectional association; owning side; inverse side; `mappedBy`; `@JoinColumn`; `@JoinTable`; `joinColumns`; `inverseJoinColumns`; `referencedColumnName`; Set versus List in many-to-many mappings.
- **Fetching:** eager loading; lazy loading; `FetchType.EAGER`; `FetchType.LAZY`; default association fetch types; lazy proxy; open session; `LazyInitializationException`; N+1 selects; JOIN FETCH; `@EntityGraph`; `@BatchSize`; DTO projection; SQL/query-count checks.
- **Projections:** closed projection; open projection; interface projection; proxy projection; nested/recursive projection; SpEL-computed property; class-based/DTO projection; constructor projection; record projection; dynamic projection; `Class<T>` selection; constructor parameter matching; entity versus selected columns.
- **Inheritance:** polymorphic query/association; `@MappedSuperclass`; table per class; `@Inheritance`; `InheritanceType.TABLE_PER_CLASS`; `SINGLE_TABLE`; `JOINED`; inherited fields; union queries; superclass/subclass joins; null columns; subclass constraints; discriminator column; DTYPE; `@DiscriminatorColumn`; `@DiscriminatorValue`; `@DiscriminatorFormula` (misspelled `@DiscriminatorFormular` in P).
- **Computed values:** `@Formula`; read-only calculated property; SQL expression; `datediff`; `curdate`; SQL aggregate in an expression; select-time evaluation; SQL dialect portability.

## 15 Caching

Sources: J, P pp. 82–84, A, H, S competency 4.

- **General:** cache; cache hit/miss; cached data; latency reduction; cache invalidation; cache synchronization; cache provider; cache region; read-heavy workload; cache-aside; stale data; caching versus source of truth.
- **Hibernate:** first-level/session cache; persistence-context identity; session scope; second-level/shared cache; SessionFactory scope; query cache; entity IDs/result sets; query parameters; query-region invalidation; `hibernate.cache.use_query_cache`; `@QueryHint`; `@QueryHints`; `org.hibernate.cacheable`.
- **Annotations and strategies:** JPA `jakarta.persistence.Cacheable` on entities; Spring `org.springframework.cache.annotation.Cacheable` on methods; Hibernate `@Cache`; `CacheConcurrencyStrategy`; read-only; read-write; transactional; soft lock; method-result cache; cache key/arguments; self-invocation caveat.
- **Providers and stores:** Ehcache; Infinispan; Hazelcast; Caffeine; Redis; in-memory store; session store; rate limiting; pub/sub; `INCR`; `SETNX`; expensive `KEYS` command; Redis command atomicity; LRU/access-order LinkedHashMap.

## 16 Security, JWT, OAuth, and OIDC

Sources: J, F, P pp. 110–120, 128–132, 144–145, R, S competencies 20 and 31–33, C.

- **Identity and permissions:** authentication/AuthN; authorization/AuthZ; principal; credentials; role; authority; permission; RBAC/role-based access control; `ROLE_` prefix; `GrantedAuthority`; `SimpleGrantedAuthority`; groups-to-authorities mapping; trusted identity versus user-supplied ID.
- **Spring authentication:** `Authentication`; `AuthenticationManager`; `AuthenticationProvider`; `UserDetails`; `UserDetailsService`; `loadUserByUsername`; `UsernameNotFoundException`; `PasswordEncoder`; `BCryptPasswordEncoder`; `UsernamePasswordAuthenticationToken`; `AuthenticationException`; `AccessDeniedException`; `SecurityContext`; thread-bound context; context propagation; Atlassian Crowd as an external identity-provider example.
- **Filter configuration:** `SecurityFilterChain`; `HttpSecurity`; `@EnableWebSecurity`; `WebSecurityConfigurerAdapter` (legacy); `authorizeRequests` versus `authorizeHttpRequests`; `antMatchers`, `mvcMatchers`, `regexMatchers` versus `requestMatchers`; first-match rule ordering; `anyRequest`; `authenticated`; `permitAll`; `hasRole`; `hasAnyRole`; `hasAuthority`; `hasAnyAuthority`; `access`; `hasIpAddress`; form login; HTTP Basic; logout; custom handlers.
- **JWT:** JSON Web Token; header; payload; signature; dot-separated compact token; Base64url; signed versus encrypted representation; claims; registered/public/private claims; `alg`; `typ`; HS256/HMAC-SHA256; RS256/RSA; `sub`; `iss`; `aud`; `exp`; `iat`; `nbf`/not-before; trusted signing key; signature/issuer/audience/expiry validation; permitted algorithm; roles/permissions after validation; decoding versus verifying; re-encoding versus re-signing; forged role claim; application-specific user database lookup.
- **Tokens:** access token; refresh token; ID token; bearer credential; token lifetime; expiry; rotation; revocation/logout; stateless API; stateful session; token storage; in-memory storage; localStorage; HttpOnly cookie; refresh and retry; stopping refresh loops.
- **OAuth 2.0 roles:** resource owner; client; authorization server; resource server; delegated authorization; scopes; consent; protected resource; confidential client; public client/SPA; client ID; client secret; redirect URI; callback; state parameter.
- **Flows:** authorization request; authorization grant; authorization code; code exchange; token endpoint; access token request/response; refresh flow; authorization code with PKCE; Device Code Flow; callback/error handling; `grant_type`; `response_type`; `access_token`; `refresh_token`; `expires_in`; `token_type`.
- **OIDC and providers:** OpenID Connect; authentication layer over OAuth; `openid` scope; ID token; `userinfo`; `preferred_username`; Keycloak; realm; roles; stateless OAuth2 resource server; `oauth2ResourceServer`; JWT authority conversion; SAML (named in P); identity-provider login page versus app login entry point.
- **Method security:** `@EnableGlobalMethodSecurity` (legacy); `@EnableMethodSecurity`; `prePostEnabled`; `securedEnabled`; `jsr250Enabled`; `@Secured`; `@RolesAllowed`; `@PreAuthorize`; `@PostAuthorize`; `@PreFilter`; `@PostFilter`; `filterObject`; `filterTarget`; `returnObject`; `authentication.principal`; `isAnonymous`; class-level security; combined pre/post checks; security meta-annotation; `@Target`; `@Retention`; self-invocation bypass.

## 17 Browser security and cryptography

Sources: J, F, P pp. 29–30, 121–128, S competencies 20 and 32.

- **Browser boundaries:** same-origin policy/SOP; origin (scheme, hostname, port); cross-origin request; CORS/Cross-Origin Resource Sharing; simple request; preflight/OPTIONS; browser enforcement versus curl/Postman; credentials/cookies; `Access-Control-Allow-Origin`, `-Allow-Methods`, `-Allow-Headers`, `-Allow-Credentials`, `-Max-Age`.
- **Attacks:** CSRF/Cross-Site Request Forgery; XSRF naming; automatic credential attachment; XSS/Cross-Site Scripting; malicious script; compromised dependency; clickjacking; iframe; MIME/content sniffing; browser cache exposure; timing attack; brute-force attack; rainbow table; unsafe deserialization; remote code execution.
- **Defenses and headers:** CSRF token; session-bound token; hidden form field; `HttpSessionCsrfTokenRepository`; `CookieCsrfTokenRepository`; `withHttpOnlyFalse`; `_csrf`; `X-CSRF-TOKEN`; `XSRF-TOKEN`; `X-XSRF-TOKEN`; CSRF filter; Thymeleaf; FreeMarker; HttpOnly; `Cache-Control`; `X-Content-Type-Options: nosniff`; `X-Frame-Options`; legacy `X-XSS-Protection` header.
- **Cryptography:** plaintext; ciphertext; encryption/decryption; symmetric key; asymmetric/public-key encryption; private/public key; digital signature; key distribution; TLS; bit; block cipher; hashing; one-way function; salt; per-password random salt; fixed versus variable salt; stored salt; slow password hash.
- **Named algorithms:** AES; DES; Triple DES/3DES; Blowfish; RSA/Rivest–Shamir–Adleman; MD5; SHA-1; SHA-256; HMAC-SHA256; BCrypt; Argon2; scrypt; PBKDF2. Presence in the old PDF is not a recommendation for password storage.
- **Secrets:** key vault; secrets store; programmatic secret retrieval; secret expiration; secure configuration; secrets in CI/CD; key management; password hashing versus reversible encryption.

## 18 Testing and verification

Sources: J, H, R, P pp. 47–54, A BDD, S competency 26.

- **Test levels and intent:** unit test; integration test/IT; smoke test; functional behavior; isolated dependency; fixture; assertion; interaction verification; setup/teardown; lifecycle callback; regression; field-by-field mapping assertion; failure path; invariant; coverage versus correctness.
- **Frameworks:** JUnit 4; JUnit 5/Jupiter; JUnit Vintage; JUnit 6 terminology in migration notes; TestNG; Mockito; JMockit; Hamcrest; AssertJ; Spring TestContext Framework; WireMock; Testcontainers; RestAssured; JaCoCo.
- **JUnit APIs:** `@Test`; `@Before`; `@After`; `@BeforeEach`; `@Rule`; `Timeout`; `@RunWith`; `MockitoJUnitRunner`; `SpringRunner`; `@ExtendWith`; `MockitoExtension`; `SpringExtension`; runner versus extension; multiple extensions; `assertEquals`; `assertThat`; `assertThrows`; expected-exception annotation versus assertion.
- **Mocking:** mock; stub; spy/partial mock; `@Mock`; `@Spy`; `@InjectMocks`; `@Mocked`; expectations; `MockitoAnnotations.openMocks`; `when`; `thenReturn`; `doReturn`; `verify`; argument matcher; `any`; `ArgumentCaptor`; `capture`; `getValue`; `mockStatic`; inline mock maker; final/static/private mocking limitations.
- **Matchers:** `hasItem`; `startsWith`; `allOf`; `greaterThan`; `lessThan`; readable assertion messages; assertion library versus mocking framework.
- **Spring tests:** application-context loading/caching; `@ContextConfiguration`; `@SpringBootTest`; transactional rollback after tests; `@MockBean`; `@SpyBean`; `@MockitoBean`; `@MockitoSpyBean`; test slices; `@DataJpaTest`; `@WebMvcTest`; `@JsonTest`; `@RestClientTest`; `TestEntityManager`; MockMvc; in-memory datasource.
- **Integration infrastructure:** HTTP stubbing; real DB/broker containers; PostgreSQL/RabbitMQ test setup; test bootstrap/resources; `bootstrap-it`; spring-cloud-test dependency wiring; embedded Elasticsearch/JNA conflicts; container boot versus passing unit tests.
- **Coverage and execution:** JaCoCo agent; `jacoco:prepare-agent`; `jacoco:report`; line/branch coverage; Maven Surefire/Failsafe; test discovery; test report; meaningful fixtures; concurrency tests; latches; fixed executor; atomic test counters; reservations/cancellation invariants.
- **Behavior specifications:** BDD/behavior-driven development; Given/When/Then; Gherkin; Cucumber; business examples; observable outcome; shared acceptance criteria.

## 19 Maven and dependency management

Sources: J, P pp. 98–109, H.

- **Project model:** Maven; `pom.xml`; POM/Project Object Model; Super POM; effective POM; parent POM; aggregator POM; multi-module build; reactor/module ordering; inheritance versus aggregation; BOM/Bill Of Materials; imported BOM; dependency management; plugin management.
- **Coordinates and tags:** `groupId`; `artifactId`; `version`; SNAPSHOT; dependency; dependencies; dependencyManagement; scope; exclusions/exclusion; optional; type; packaging; repositories/repository; modules/module; parent; properties; build; plugins/plugin; executions; goals/goal; phase; configuration; includes/include.
- **Scopes and artifacts:** compile; provided; runtime; test; system; import; JAR; WAR; EAR; POM packaging; artifact; binary; source/target compatibility; `maven.compiler.release`; classpath; transitive dependency; direct dependency; optional transitive exposure.
- **Repositories:** local repository (`.m2/repository`); remote repository; Maven Central; repository manager; JFrog Artifactory; Sonatype Nexus; cached artifacts; internal libraries; artifact publication.
- **Resolution:** dependency tree; dependency mediation; nearest definition wins; equal-depth declaration order; managed version override; incompatible transitive version; exclusions; vulnerable dependency replacement; aligning a coherent dependency stack.
- **Lifecycles:** clean; default/build; site; validate; compile; test; package; integration-test; verify; install; deploy; lifecycle versus phase versus goal; preceding phases; local install versus remote deploy.
- **Plugins:** Compiler; Surefire; Failsafe; JAR; WAR; Deploy; JaCoCo; Maven Versions; OpenRewrite; plugin execution; goal binding; test-name includes; source level; bytecode target; archive; manifest; `addDefaultImplementationEntries`.
- **Commands/configuration:** `mvn clean install`; `mvn compile`; `mvn compiler:compile`; `mvn dependency:tree`; `mvn help:effective-pom`; `mvn versions:display-dependency-updates`; `mvn rewrite:run`; Maven profile; `-Pcoverage`; property/JDK/OS activation; Java module `exports` versus Maven modules.

## 20 Modernization and migration

Sources: J, H, R project history, P legacy terminology.

- **Planning:** compatibility engineering; staged uplift; baseline; intermediate stable release; risk/blocker inventory; dependency/integration map; behavior preservation; rollback point; deprecation cleanup; small migration batches; tests before upgrade; security support lifetime.
- **Version paths:** Java 8/Boot 2.3 → Java 17/Boot 2.7 → Java 21/Boot 3.x; Java 11 → 17 → 21 → 25; Spring Framework 1–7 history; Boot 2/3/4; Hibernate 5 → 6; Spring Security 5 → 6; JUnit 4 → 5; JMockit → Mockito.
- **Namespaces:** Java EE; Eclipse Foundation; Jakarta EE 9+/11; `javax.persistence` → `jakarta.persistence`; servlet; validation; annotation; transaction; retained JDK packages `javax.sql`, `javax.crypto`, `javax.net`, `javax.naming`; third-party Jakarta compatibility.
- **ORM changes:** SQL generation; stricter type handling; UUID/Boolean/enum mapping; sequence-per-entity versus shared sequence; `@GenericGenerator`; `GenerationType.UUID`; `@TypeDef`; `JsonBinaryType`; `@JdbcTypeCode`; `SqlTypes.JSON`; `PostgreSQL94Dialect` → `PostgreSQLDialect`; property renames.
- **Mapping libraries:** Dozer; Dozer XML; ModelMapper; MapStruct; reflection versus generated code; nested property path; null skipping; empty nested object versus null; `PropertyMap`; converter; collection `TypeToken`; mapping fidelity.
- **Web/security changes:** SecurityFilterChain bean; lambda DSL; method-security migration; role-prefix handling; trailing slash matching; `PathPatternParser` versus `AntPathMatcher`; client compatibility; Swagger2/Springfox → Springdoc/OpenAPI 3; Feign → RestClient/HTTP interfaces.
- **Observability/configuration:** Sleuth → Micrometer Tracing/Observation; span migration; Actuator changes; structured JSON logging; `@ConstructorBinding`; `spring-boot-properties-migrator`; temporary migration tooling.
- **JDK compatibility:** strong encapsulation; `sun.*`; `jdk.internal.*`; `--illegal-access`; `--add-opens`; `--add-exports`; `jdeps --jdk-internals`; `jdeprscan`; OpenRewrite `rewrite-spring`/`rewrite-migrate-java`; removed APIs/GC flags; `-XX:+UseConcMarkSweepGC`; finalization/Cleaner; dynamic agents; Unsafe usage.
- **Service dependencies:** internal API client module; client starter pattern; client-starter dependency; Java dependency coupling versus REST contract; dependency upgrade order; shared business logic; alignment of internal artifacts.
- **Migration incidents:** transaction-manager mismatch; connection-pool spike; missing test bootstrap; JNA/`dockerPresenceMarker`; embedded Elasticsearch transitive conflict; duplicate JDBC bean; bean-registry cleanup; Liquibase empty IDs; Jersey v1; Neo4j; Rabbit test libraries; Quartz; file storage.
- **Next-generation names in J:** Spring Boot 4; Spring Framework 7; Servlet 6.1; JPA 3.2; Bean Validation 3.1; Jackson 3 migration; focused auto-configuration modules; API versioning; `@Retryable`; `@ConcurrencyLimit`; declarative HTTP clients; `RestTestClient`; JSpecify. Verify exact compatibility against the target release when practicing migration answers.

## 21 Distributed systems and service integration

Sources: A, J, H, S competencies 4–8, 10, 14–15.

- **Architecture:** monolith; microservice; distributed system; database-per-service; shared database; service-owned data; independent deploy/scale; polyglot persistence; cross-service query; duplicated data; distributed transaction; network dependency.
- **Trade-offs:** latency versus throughput; consistency versus availability; complexity versus benefit; synchronous versus asynchronous communication; partial failure; availability dependency; inconsistent snapshot; bottleneck; fan-out; parallel/reactive composition; eventual versus immediate consistency.
- **Gateway and composition:** API gateway; API composer; gateway aggregator; backend for frontend/BFF; provider API; response/JSON merge; routing; authentication/authorization; request/response transformation; aggregation; load balancer; rate limit; service discovery; centralized configuration.
- **Spring Cloud:** Config; Gateway; OpenFeign; LoadBalancer; Kubernetes integration; Services; ConfigMaps; Secrets; declarative REST client; service registry; Consul.
- **Resilience and scale:** queue-based load leveling; cache-aside; retry; exponential backoff; increasing delay; timeout policy; durable worker; background queue; failure recovery; connection reset; reconciliation; circuit breaker/Resilience4j (named as an artifact example in P p. 101); bounded retries.
- **Data/API alternatives:** normalized write data; denormalized view; live API composition versus precomputed read model; GraphQL aggregation; SQL sharding/routing; Apache Camel integration routing; SNS/SQS; DynamoDB.

## 22 Events, messaging, and delivery

Sources: A, H, R, J, S competency 19, C.

- **Event vocabulary:** event-driven architecture/EDA; event; domain event; immutable fact; command/intent; producer/publisher; consumer/subscriber; event handler; event bus; message bus; message broker; publish/subscribe; decoupling; asynchronous propagation; eventual consistency.
- **Kafka:** record; topic; partition; partition key/ordering; broker; append-only disk log; replication; durability; retention window; replay; offset; offset commit; consumer group; partition assignment; reassignment/rebalancing; independent groups; one partition owner per group; consumer scaling; Kafka transactions.
- **RabbitMQ:** producer; exchange; routing key; binding; matching queue; copy per queue; competing consumers; queue ordering; acknowledgement/ack; manual ack; `autoAck`; delivery versus successful processing; unacked message; requeue/redelivery; persistence; broker restart; message removal after acknowledgement; task/workflow queue.
- **Comparisons:** retained log versus work queue; durability versus replay; offset commit versus delete; partition assignment versus binding; broadcast across groups/queues versus competition within a group/queue; streaming/analytics/audit versus workflow commands; throughput; routing complexity; operational trade-offs.
- **Delivery failures:** duplicate publication; duplicate consumption; at-least-once delivery; lost response after successful write; retry-induced duplicate side effect; stable event ID; deduplication; idempotent consumer; processed-event store; unique constraint; exactly-once claim boundaries.
- **Cloud queues:** enqueue; dequeue; polling; message lifecycle; visibility timeout; expiration; retention; size limit; throughput limit; queue performance; queue health; background processing.

## 23 CQRS, event sourcing, and snapshots

Sources: A, C, S competency 23.

- **CQRS:** Command Query Responsibility Segregation; command; query; write API; read API; command/write model; query/read model; command handler; query handler; read/write separation; one database versus separate stores; independent scaling; event-driven read-model update.
- **Read side:** projection; view database; materialized view; denormalized read representation; event handler; customer summary/dashboard; read-model lag; staleness; eventual consistency; freshness/consistency of the read.
- **Event sourcing:** event stream; append-only event log; event store; source of truth; aggregate; command validation; applying events; replay; reconstruct current/historical state; state at time T; audit trail; event sourcing versus ordinary audit log; new projection from existing history.
- **Snapshots:** aggregate snapshot; snapshot store; aggregate ID; event position/version; every-N-events frequency; restore latest snapshot plus later events; snapshot validity; replay cost; storage/performance trade-off; snapshot versus query projection.

## 24 Saga, 2PC, outbox, and idempotency

Sources: A, H, R, C.

- **Saga:** distributed business process; sequence of local transactions; T-step/forward step; C-step/compensating step; happy path; failure path; reverse compensation order; compensation as a new transaction; eventual consistency; reservation; release; refund; cancellation; timeout; uncertain outcome; retrying durable worker.
- **Coordination:** choreography/decentralized events; orchestration/central commands; saga manager; orchestrator; workflow sequencing; order-payment-inventory; car-hotel-flight; multi-service customer-data update.
- **Two-phase commit:** 2PC; XA; coordinator; resource manager/participant; prepare; vote; durable prepared state; commit/abort decision; locks; in-doubt transaction; coordinator recovery; durable decision log; retrying an unfinished commit; participating-system support.
- **Transactional outbox:** dual-write problem; business row; outbox row; same local database transaction; commit/rollback together; relay; poller; CDC/Change Data Capture; Debezium; later asynchronous publication; publish-versus-mark-sent crash window; retry after broker outage.
- **Consumer idempotency:** event ID; idempotency key; uniqueness; processed event plus business update in one transaction; duplicate handling at the consumer's effect boundary; event-ID equality versus broker deduplication; exactly-once effect versus delivery guarantee.
- **Migration/workflow safety:** migration event store; SUCCESS/FAILURE status; skip-successful-records policy; per-jurisdiction key; partial failure; publish-versus-record transaction gap; downstream deduplication; preventing double stock release; reconciliation after lost responses.

## 25 DDD and architectural boundaries

Sources: A, H, R, S competency 6.

- **DDD:** domain-driven design; Eric Evans; business expert; business domain; domain model; strategic design; tactical design; subdomain; core domain; ubiquitous language; bounded context; context map; upstream/downstream direction; anti-corruption layer/ACL; translating between models.
- **Tactical terms:** entity; identity; value object/VO; immutable value; constructor validation; aggregate; aggregate root; child entity; invariant; consistency boundary; local transaction; small aggregate; reference other aggregates by ID; repository; domain service; entity versus value object.
- **Boundaries and examples:** billing subscriber versus streaming viewer; business subdomain versus software bounded context; bounded context versus microservice; order/order lines/address; domain model independent of storage; ordinary persistence versus event-sourced aggregate.
- **Strangler Fig:** incremental monolith replacement; routing layer/gateway; feature slice; seam; new service ownership; data copy/synchronization; jobs/events/read-through APIs; avoid permanent shared-table coupling; retire old system; big-bang rewrite comparison.
- **Hexagonal architecture:** ports and adapters; Alistair Cockburn; domain/application core; inbound/driving/left adapter; outbound/driven/right adapter; core-owned port/interface; REST/message input; database/file/email/service output; dependency injection; technology substitution; framework-independent domain; three-tier comparison.
- **Clean Architecture:** independent layers; entities; use cases; interfaces; dependency inversion; inward dependencies; business-logic isolation; testability; maintainability; technology independence; SOLID at architectural level; single responsibility; open/closed principle.

## 26 Object-oriented design patterns

Sources: A, J, F, P examples.

- **Families:** GoF/Gang of Four; creational; structural; behavioral; object creation; object composition; object interaction; pattern intent versus similar class diagram.
- **Creational:** Singleton; private constructor; static instance/`getInstance`; enum singleton; Spring singleton scope; Prototype; clone/copy constructor; shallow copy; Builder; fluent interface/chaining; `build`; Lombok `@Builder`; simple factory; Factory Method; Abstract Factory; family of related products; factory versus builder.
- **Structural:** Facade/façade; small API over multiple subsystems; Proxy; stand-in/placeholder; same interface; protection proxy; caching proxy; virtual/lazy proxy; remote proxy; logging/smart proxy; delegation; RMI/Feign stub; Adapter; interface translation; Decorator; stacked added responsibilities.
- **Concrete wrappers:** `Arrays.asList`; `InputStreamReader`; `BufferedInputStream`; `GZIPInputStream`; `FileInputStream`; Java I/O decorator chain; Spring AOP/transaction proxy; Hibernate lazy proxy; SLF4J facade; service/application facade.
- **Behavioral:** Observer; subject; subscribe/notify/next; one-to-many push; `ApplicationEventPublisher`; RxJava `Subject`; Firebase; Strategy; interchangeable algorithm; `Comparator`; `Comparator.comparing`; payment strategy; Iterator/pull iteration; Mediator/coordination; State/internal-lifecycle behavior.
- **Comparisons:** Adapter versus Proxy versus Decorator; Facade versus Proxy; Factory versus Builder; Strategy versus State; Observer versus Iterator; Observer versus Mediator; GoF patterns versus architectural patterns; Spring scopes versus GoF creation patterns.

## 27 Batch processing and background jobs

Sources: H, R, S competency 14, C.

- **Spring Batch:** job; step; chunk-oriented step; reader; processor; writer; read → process → write → commit; chunk size; transaction per chunk; rollback current chunk; earlier committed chunks; retry/skip discussion; restartability; reader state; item ordering.
- **Ingestion:** CSV; XML; file processing; category-before-product dependency; database job; normalization; negative-stock handling; task executor; concurrency limit; reader/writer thread safety; stateful resources; restart TODO versus tested recovery.
- **Workers:** hosted service; background worker; recurring job; scheduler; Quartz; long-running task; job queue; retries; durable progress; failed-job recovery; monitoring job execution; polling relay; migration batch; replay safety.

## 28 Containers, cloud, delivery, and operations

Sources: H, J, A, R, S competencies 13–15, 18–21, 25–26.

- **Docker:** image; container; Dockerfile; base JRE image; Java runtime uplift; build; tag/version; registry; push; run; start/stop/remove; inspect; container logs; execute command; lifecycle; same built artifact across local/CI/cluster.
- **Kubernetes:** orchestration; desired state; cluster; node; Pod; Deployment; replicas; scheduling; restart; scale; Service; stable DNS/IP; selector; namespace; Ingress; ConfigMap; Secret; manifest; YAML; Helm; rolling deployment.
- **CI/CD:** continuous integration; continuous delivery/deployment; GitHub Actions; workflow; runner; push/PR trigger; build steps; automated tests; artifact publishing; image publishing; release pipeline; dev/staging/prod; deployment stages; Argo CD; GitOps; Git desired state; live-versus-desired diff; sync; revert/pin image for rollback.
- **Configuration:** environment variable; profile; external configuration store; centralized config; dev/test/prod separation; hot reload; feature flag; secure secret management; Consul discovery/config.
- **Observability:** logs; metrics; traces; span; correlation; instrumentation; Micrometer; Micrometer Tracing; Observation API; Prometheus; Grafana; OpenTelemetry/OTel; Sleuth; log collection; metrics export; dashboard; query logs/metrics; pool/thread metrics; error rate; latency; p99; startup/smoke validation.
- **Cloud storage:** blob/object storage; block blob; append blob; page blob; storage selection; blob operation; data transfer SDK/tools; archiving policy; cloud queue storage; secret/key vault.
- **Delivery vocabulary:** build versus deploy versus release/ship; local image boot; dev deployment; functional smoke test; immutable artifact; rollback; compatibility during coexistence.

## 29 Deployment and release strategies

Sources: A, H, C.

- **Rolling:** batches of old/new instances; `RollingUpdate`; `maxUnavailable`; `maxSurge`; readiness; mixed versions; backward compatibility; rollout; rollback; capacity/downtime conditions.
- **Blue-green:** two environments; blue live/green candidate; test before switch; load balancer/Service/DNS switch; selector; duplicate infrastructure; instant traffic rollback; data compatibility.
- **Canary:** deliberately weighted real traffic/users; small percentage; staged increase; blast radius; abort; metric threshold; p99/error monitoring; traffic splitting; Istio; Argo Rollouts.
- **Recreate:** stop old then start new; `strategy: Recreate`; scale to zero; downtime; incompatible coexistence; one-of-a-kind resource.
- **Feature flags:** feature toggle; release toggle; dark launch; deploy versus release; targeted user/group rollout; runtime switch; kill switch; flag debt; default if flag service fails; LaunchDarkly; Unleash.
- **Shadow:** traffic mirroring; copied request; discarded candidate response; live response from old version; offline diff/latency comparison; sidecar; gateway fork; duplicate-write hazard; sandbox/read-only side effects.
- **Comparisons:** replacing instances versus allocating user traffic; full environment switch versus partial exposure; canary serving users versus shadow observation; operational rollout versus feature behavior switch.

## 30 JavaScript and browser fundamentals

Sources: F, S competency 29.

- **DOM:** Document Object Model; browser API; HTML tree; node; `document`; real DOM; Virtual DOM; declarative rendering; diffing/reconciliation; layout/reflow/repaint; update cost; React heuristic; O(n) versus O(n³); stable list key.
- **Execution:** function invocation; call/execution stack; frame; LIFO; execution context; global context; function context; creation/hoisting phase; execution phase; `this`; environment record; lexical environment; legacy Variable Object; `window`; browser versus Node runtime.
- **Declarations:** hoisting; function declaration; `var`; `let`; `const`; function scope; block scope; redeclaration; reassignment; fixed binding versus mutable object; uninitialized binding; Temporal Dead Zone/TDZ; `undefined`; `ReferenceError`.
- **Scope:** scope chain; lexical/static scope; closure; retained variable environment; function factory; captured state; shadowing; nearest declaration; parent lookup; inner variables; global variables; memory retained by closure.
- **Types/operators:** dynamic typing; type coercion; string concatenation; numeric conversion; loose equality `==`; strict equality `===`; null/undefined comparison; destructuring; object/array destructuring; rename/default; spread; rest parameter; shallow copy; optional chaining `?.`; optional call/index; nullish coalescing `??`; logical OR `||`; falsy values (`0`, empty string, false, NaN).
- **Asynchrony:** single-threaded main execution; concurrent versus parallel; Web Worker; message passing; event loop; task/macrotask/callback queue; FIFO; microtask/promise-job queue; draining microtasks; starvation; synchronous-before-microtask-before-timer ordering.
- **Browser APIs:** `setTimeout`; `setInterval`; DOM event listener; `fetch`; `localStorage`; geolocation; `queueMicrotask`; `MutationObserver`; JSON language object versus host-provided APIs.
- **Promises:** pending/fulfilled/rejected; settled; `.then`; `.catch`; `.finally`; callback hell; chaining; `Promise.resolve`; `Promise.all`; `allSettled`; `race`; `any`; `async`; `await`; continuation; try/catch; suspending a function versus blocking a thread.
- **Memory/errors:** reachability; garbage collection; retained closure; listener/timer/subscription leak; detached DOM node; growing cache; `clearInterval`; cleanup; infinite recursion; stack overflow; `RangeError`; `TypeError`.

## 31 TypeScript and frontend structure

Sources: F, S competencies 27–30.

- **TypeScript:** static typing; compile-time checking; transpilation; JavaScript output; type erasure; runtime boundary validation; interface erased at runtime; `instanceof` limitation; Zod; shared JavaScript event loop/runtime.
- **Metaprogramming:** decorator; class/method/property/parameter decorator; custom decorator; framework-specific decorator; multiple decorators; legacy versus standard decorator behavior when version matters.
- **Frontend DI:** injector; provider; injected service; component injection; injection types; service lifecycle; loose coupling; dependency-injection benefits; Angular DI and decorators.
- **Structure:** component-based architecture; reusable component; composition; one responsibility; module; ES module; import/export; named export; single responsibility principle/SRP; naming conventions; PascalCase; camelCase; UPPER_SNAKE_CASE; kebab-case.

## 32 React, Angular, and state management

Sources: F, H, S competencies 27–28.

- **React:** UI library; function component; class component; props versus state; read-only props; parent-child flow; render/re-render; state ownership; hooks; top-level hook rule; custom hook; hook call order; `eslint-plugin-react-hooks`.
- **Hooks:** `useState`; setter; functional update; batching; stale state read; `useEffect`; side effect; dependency array; mount/update/unmount; cleanup; StrictMode development checks; `useRef`; `ref.current`; DOM ref; mutable value without rerender; `useMemo`; cached value; `useCallback`; stable function reference; `useContext`; Context; prop drilling; `React.memo`.
- **Rendering rules:** pure render; pure function; side effects outside rendering; stable unique key; array-index key problem; reference identity; memoization cost; context consumer updates.
- **Angular:** framework versus library; opinionated structure; modules/services/DI; TypeScript; strict templates; binding; change detection; `ChangeDetectionStrategy.OnPush`; input reference; component composition; props/events; slots/content projection.
- **State management:** storing/updating/reacting; shared state; centralized state; single source of truth; unidirectional flow; subscription; state synchronization; immutable update; shallow comparison; time-travel debugging; replayable state.
- **Redux:** store; state; action; `type`; `payload`; dispatch; reducer; pure reducer; state slice; selector; `getState`; `dispatch`; `subscribe`; `useSelector`; Redux Toolkit/RTK; Immer; mutation-style syntax producing immutable updates.
- **NgRx:** Angular Redux-style state; Store; actions; reducers; selectors; Effects; RxJS observable-based asynchronous effects.

## 33 Frontend routing, forms, HTTP, and RxJS

Sources: F, S competencies 28–31, J security.

- **Routing:** SPA/single-page application; History API; route; nested route; route parameter; protected route; React Router; authorization wrapper component; child route; unauthorized view; Angular Router; route guard; `AuthGuard`; `canActivate`; `canDeactivate`; `canLoad`; `canMatch`; functional guard; unsaved-change guard.
- **HTTP/auth flow:** Axios; native fetch; Angular HttpClient; `HttpInterceptor`; request/response interceptor; Authorization Bearer header; centralized token attachment; 401 response; refresh token; original-request replay; refresh-loop prevention; JSON parsing; HTTP error versus network error; timeout; cancellation; response transformation; toast/fallback.
- **Forms:** form state; value/error/touched/dirty state; controlled input; uncontrolled input; DOM/ref; React Hook Form; Formik; Angular Reactive Forms; client-side validation; server-side validation; required/format/length checks; API boundary validation.
- **Error UX:** error boundary; render-time error; fallback; retry; cached data; degraded view; user-actionable message; technical logging.
- **Realtime:** socket; WebSocket; bidirectional communication; server push; long-lived TCP connection; notifications; live update; stream of events.
- **Reactive programming:** asynchronous data stream; declared reaction to change; RxJS; Observable; Observer/subscriber; `next`; `error`; `complete`; Subscription; lazy/cold versus hot source; one versus many values; observable versus Promise; eager/lazy behavior; cancellation/unsubscribe.
- **Operators:** `.pipe`; `map`; `filter`; `merge`; `switchMap`; `mergeMap`; `debounceTime`; `catchError`; `takeUntil`; `combineLatest`; typeahead; cancelling previous inner stream; transformation/filter/combination.
- **Cleanup:** subscription completion/error; explicit unsubscribe; `takeUntil(destroy$)`; Angular async pipe; `takeUntilDestroyed`; observable-chain debugging; event-loop behavior; memory leaks.

## 34 Frontend build tools and performance

Sources: F, H.

- **Packages:** `package.json`; project metadata; dependencies; devDependencies; scripts; `package-lock.json`; exact version pinning; npm; runtime versus build-time use.
- **Build:** bundle; bundling; module resolution; Vite; webpack; Rollup; esbuild; Parcel; code splitting; chunk; dynamic import; route split; initial download/parse cost.
- **Lazy loading:** `React.lazy`; Suspense; fallback/spinner; Angular `loadChildren`; feature module; standalone component; `loadComponent`; code loading versus media/data loading; `loading="lazy"`; `IntersectionObserver`; virtualization; infinite scroll.
- **Transpilation:** Babel; ES6+/ES5; browser compatibility; JSX; TypeScript syntax stripping; transpiler versus language compiler.
- **Quality:** linting; ESLint; Prettier; code standards; correctness versus formatting; CI enforcement; performance measurement; memoization trade-offs.
- **Document tooling named in the sources:** Markdown; HTML; fenced code; tables; headings; anchors/slugs; `build_html.py` (referenced helper, absent from this checkout); Python `markdown` package; generated search/filter cards; hand-maintained correction table.

## 35 AI, RAG, agents, and retrieval security

Sources: H, R, S competencies 1–3 and 33; C names LangChain/LangGraph for later study.

- **Core AI:** LLM/large language model; direct model call; prompt; system/user prompt; chat history; context; token; temperature; text generation; summary; intent classification; structured output; grounding; hallucination/unsupported answer; prototype versus measured production capability.
- **RAG:** Retrieval-Augmented Generation; document ingestion; text extraction; chunking; chunk size; overlap; chapter/page/paragraph/sentence boundary; character count versus token count; embedding model; embedding vector; vector dimension; semantic similarity; distance metric; vector index/database; similarity search; top-K; threshold; retrieval relevance; supplied context.
- **Retrieval engineering:** storing/upserting documents; metadata; collection; chunk/document ID; chapter title/order; original text versus summary; retrieving original passages; context expansion/character margin; collection-level summary; summary of summaries; maintaining an updated index; narrow question versus whole-document summary.
- **Evaluation/diagnostics:** expected source passage; retrieval quality; retrieval-versus-generation failure; answer support; grounding verification; threshold enforcement; returned score; stage timing; embedding/retrieval/generation latency; context diagnostics; prompt settings; measurable improvement versus unverified assumption.
- **Tools/models:** Spring AI; Spring AI `Document`; ChromaDB/Chroma; vector store; `InMemoryVectorStore`; Ollama; LM Studio; `google/gemma-3-12b-it`; `nomic-embed-text`; Apache PDFBox; chat-completions endpoint; RestTemplate integration; local model serving.
- **Commerce prototype:** query/add-to-cart/checkout classification; natural-language-to-SQL; entity type; schema-guided SQL generation; bounded correction loop; two total execution attempts; product-ID lookup; fixed PostgreSQL function; fixed checkout SQL; `JdbcTemplate`; trusted identity; generated query validation; application-controlled write boundary.
- **Agents:** agent; goal; action; observation; context; stateful agent loop; stateless prompt; autonomy; decision-making; appropriate use versus simple prompt; limitations; failure modes; orchestration; tool integration; LangChain; MCP/Model Context Protocol; LangGraph (handoff-only, deferred).
- **RAG access control:** document-level policy; user-based filtering; role-based access; metadata-based access control; permission-filtered retrieval; unauthorized-document handling; audit access attempts; testing authorization enforcement.
- **Automation:** CSV-to-structured-worklog parsing; normalization; deterministic validation after model output; issue type/assignee validation; human fallback; retry/reconnect; recording failed source rows; stable operation identity; reconciliation to prevent duplicated remote writes.

## 36 Go, C++, and platform comparisons

Sources: H, P p. 145, R Overtime caveat.

- **Go:** compiled/static language; static binary; compile/deploy time; goroutine; concurrent shared state; Gin; router; handler; `gin.Context`; `c.JSON`; `go mod`; `go.sum`; dependency checksum; `database/sql`; ORM; PostgreSQL; React integration; small API/internal service/CLI.
- **C++:** procedural and object-oriented programming; native machine code; manual memory; `new`/`delete`; RAII/resource acquisition is initialization; pointers; multiple inheritance; templates; compile-time instantiation; memory safety; platform dependence; performance-sensitive systems.
- **Java comparison:** bytecode/JVM; garbage collection; generics/type erasure; interface inheritance; portability; enterprise ecosystem; Spring starters; fat JAR; startup/runtime overhead; platform versus virtual threads; delivery speed versus runtime speed.
- **Workflow scenario:** job posting; skill matching; approval routing; lead/finance approval; explicit state transition; timesheet; duplicate/overlapping entry; auditability; role-based transition permission; transaction over status and related records. Exact Overtime implementation remains unverified in R.

## 37 Project scenarios and engineering leadership

Sources: H, R, S, README.

- **Shield modernization:** dependency inventory; migration playbook; compatibility risk; test strategy; mapping regression; transaction manager incident; pool metrics; context bootstrap; internal client modules; staged rollback; Docker base image; CI/GitOps rollout.
- **GED/LDR migration:** legacy learner records; jurisdiction; extraction/mapping; GED credential document; GEDRootModel/GEDH payload; RabbitMQ publication; assessment processing; award workflow; roster/library; suppressing fulfillment; migration event status; rerun idempotency; implementation evidence still needed.
- **E-commerce CDP:** multi-module application; batch/ecommerce/vector/AI/security modules; natural-language query path; document RAG path; inventory ingestion; cart/order transaction; Keycloak role extraction; authenticated route versus role-specific enforcement.
- **Concurrency lab:** overselling reproduction; CAS reservation; synchronized historical version versus later CAS version; atomic cancellation; business-invariant tests; plain registry HashMap; multi-value snapshots; local state versus distributed correctness.
- **3-buddy/Shield knowledge tooling:** study-domain entities; sessions/topics/question types; Liquibase; MongoDB repository; MongoTemplate; allowed collection/query pair; JSON parsing; migration steps/issues knowledge; unfinished AI wiring; GraphQL data fetcher/schema; Jackson polymorphic deserialization; restricted accepted types.
- **Jira automation:** Node.js/Python; local LLM; LangChain/MCP exploration; CSV tasks; worklog grouping; subtask resolution; assignee check; interactive create/select/skip; remote write verification; transport retries; duplication risk; task-record deduplication.
- **Leadership:** Principal versus Senior scope; mentoring; onboarding; pair programming; PR review; standards; cross-team alignment; domain-flow explanation; architecture decisions; risk scanning; clear trade-offs; evidence-based incident narrative.
- **Evidence literacy:** inspected code versus executed behavior; local history versus sole ownership; personal lab versus work-assigned prototype versus production; measured result versus proposed improvement; implementation limitation; ownership confirmation; no inferred latency/scale/coverage/saved-hours claim.

## Database coverage expansion — 27 October 2026

The index now has **52 study areas**. Original IDs 01–37 remain stable. Database notes deepen topics 13/14/11 and now receive explicit assessment areas 38–50; design patterns receive areas 51–52. Sharding, replication, recovery, and migration questions extend the source material at Habiba’s request; inclusion is not evidence of a knowledge gap or prior experience.

New source files: [database notes](database.md), [database PDF](database.pdf), [second database PDF](database0.pdf), [DevOps notes](devops.md), [design-pattern notes](design.md), and [Design Patterns PDF](Design%20Patterns.pdf). Topic selection here uses the Markdown notes; the PDFs are uploaded companion references, not claimed as newly page-by-page reviewed.

DevOps notes map to **28** (Git merge/rebase, branching, Jenkins/GitLab/GitHub Actions pipelines) and **29** (delivery/release). Design notes map to **26** (Observer and Strategy, alongside the existing pattern inventory). These sources do not need duplicate top-level areas.

Scope boundaries: **13** covers query/JDBC basics; **11** covers Spring transaction interception; **14** covers ORM behavior. New areas cover database mechanics and design directly. Avoid double-counting one answer as independent evidence across overlapping topics.

## 38 Relational modeling, normalization, and integrity

Start with [database notes](database.md#normalization-and-entity-relations); include the interview extensions listed below.

- **Coverage:** Keys; cardinality; ER diagrams; 1NF/2NF/3NF; functional dependencies; denormalization; CHECK/UNIQUE/FK constraints; CASCADE versus RESTRICT.
- **First interview question:** Model customers, orders, and products: where do foreign keys and uniqueness constraints belong, and when would you denormalize?

## 39 Advanced SQL, CTEs, and window functions

Start with [database notes](database.md#ranking-and-partitioning); include the interview extensions listed below.

- **Coverage:** Joins and NULL semantics; GROUP BY/HAVING; subqueries; recursive CTEs; temporary tables; ROW_NUMBER/RANK/DENSE_RANK; window PARTITION BY; keyset versus offset pagination.
- **First interview question:** Return the top three salaries per department including ties. How does window PARTITION BY differ from physically partitioning a table?

## 40 Index design and storage structures

Start with [database notes](database.md#indexes); include the interview extensions listed below.

- **Coverage:** B-tree versus hash; composite key order; covering and filtered/partial indexes; selectivity; clustered versus nonclustered indexes; pages; page splits; fill factor; write amplification. Name the database engine before describing storage behavior.
- **First interview question:** For tenant_id = ? with a date range and ORDER BY created_at, which composite index would you try, and what would it cost on writes?

## 41 Query plans, statistics, and database tuning

Start with [database notes](database.md#database-tunning); include the interview extensions listed below.

- **Coverage:** Estimated versus actual rows; scans/seeks; join algorithms; sorts/spills; cardinality estimates; statistics; plan cache; parameter sensitivity; wait statistics; I/O versus CPU versus blocking; SQL Server tempdb.
- **First interview question:** A query becomes slow as data grows: how would the actual execution plan, row estimates, waits, and index usage guide your investigation?

## 42 Database transactions, isolation, and MVCC

Start with [database notes](database.md#transactions); include the interview extensions listed below.

- **Coverage:** ACID; commit/rollback; dirty/nonrepeatable/phantom reads; lost update; write skew; read committed/repeatable read/serializable; snapshots; MVCC; serialization retries; engine-specific guarantees.
- **First interview question:** Two concurrent transactions both see one remaining seat. Which transaction/isolation strategy prevents overselling, and what failures must the application retry?

## 43 Locking, contention, and deadlocks

Start with [database notes](database.md#locking); include the interview extensions listed below.

- **Coverage:** Shared/exclusive locks; row/table scope; lock ordering; blocking versus deadlock; lock timeout; optimistic versus pessimistic concurrency; conditional updates; deadlock victim and safe retry.
- **First interview question:** Two transfers lock accounts in opposite order. Explain the deadlock, how to diagnose it, and how lock ordering and transaction-level retry help.

## 44 Views, materialized views, and database programming

Start with [database notes](database.md#comparison-of-database-objects); include the interview extensions listed below.

- **Coverage:** Views versus materialized views; refresh/freshness; stored procedures; scalar/table-valued functions; triggers; dynamic SQL and parameterization; set-based operations versus cursors.
- **First interview question:** A dashboard runs expensive aggregates: compare a normal view, materialized view, and application cache. When would a stored procedure or trigger be justified?

## 45 Table partitioning and data lifecycle

Start with [database notes](database.md#partitioning-tables); include the interview extensions listed below.

- **Coverage:** Range/list/hash partitioning; horizontal versus vertical partitioning; partition keys; pruning; indexes and uniqueness; retention and partition removal; operational overhead.
- **First interview question:** Partition a large events table by month. Which queries benefit from pruning, and what happens when a query filters only by customer ID?

## 46 Sharding and distributed data placement

Requested database/system-design extension; use the existing migration/distributed-systems notes where relevant.

- **Coverage:** Sharding versus single-database partitioning; shard keys; range/hash routing; hotspots; tenant skew; resharding; global IDs; cross-shard joins and transactions.
- **First interview question:** A tenant-based orders database exceeds one server: choose a shard key and explain how you handle a very large tenant, rebalancing, and cross-tenant reporting.

## 47 Replication, read replicas, and failover

Requested database/system-design extension; use the existing migration/distributed-systems notes where relevant.

- **Coverage:** Leader/follower; synchronous versus asynchronous replication; replication lag; read-after-write; promotion; failover; split-brain prevention; logical versus physical replication; replicas versus backups.
- **First interview question:** A write succeeds on the primary but the next read from a replica misses it. Explain why, mitigation choices, and the data-loss tradeoff during failover.

## 48 Database scaling and system-design tradeoffs

Start with [database notes](database.md#olap-online-analytical-processing-and-oltp-online-transaction-processing-in-databases); include the interview extensions listed below.

- **Coverage:** Compare replication, partitioning, and sharding; vertical/horizontal scaling; read-heavy versus write-heavy bottlenecks; relational versus document/key-value models; OLTP versus OLAP; consistency and availability during network partitions.
- **First interview question:** Compare replication, partitioning, and sharding using one e-commerce system. Which addresses read load, write/data volume, availability, and retention? Can they be combined?

## 49 Backup, recovery, and database operations

Requested database/system-design extension; use the existing migration/distributed-systems notes where relevant.

- **Coverage:** Full/incremental/log backups; point-in-time recovery; restore testing; RPO/RTO; replication versus recovery; capacity and growth; monitoring lag/storage/connections; maintenance tradeoffs.
- **First interview question:** An accidental DELETE reaches every replica. How do you recover, and how do RPO/RTO affect your backup and restore plan?

## 50 Schema evolution, data migration, and CDC

Requested database/system-design extension; use the existing migration/distributed-systems notes where relevant.

- **Coverage:** Expand/contract migrations; backfill batching; checkpoints; reconciliation; idempotent reruns; dual-write failure windows; CDC; cutover and rollback; compatibility during rolling deployment.
- **First interview question:** Move a large populated table to a new schema while writes continue. Explain backfill, change capture, validation, cutover, and recovery after a partial failure.

## 51 Creational and structural design patterns

Sources: [design notes](design.md), [architecture pattern reference](architecture-patterns-cheat-sheet.md), and [Design Patterns PDF](Design%20Patterns.pdf).

- **Coverage:** Factory, Builder, Singleton, Prototype; Adapter, Decorator, Proxy, Facade; intent, tradeoffs, and real code examples. Distinguish a GoF object pattern from an architectural pattern.
- **First interview question:** Compare Factory, Builder, Adapter, Decorator, and Proxy using one application: what problem does each solve?

## 52 Behavioral patterns and pattern selection

Sources: [design notes](design.md) (Observer and Strategy) and [architecture pattern reference](architecture-patterns-cheat-sheet.md).

- **Coverage:** Strategy, Observer, changing algorithms at runtime, event/listener notifications, coupling, testing, when a simple conditional is sufficient.
- **First interview question:** Compare Strategy and Observer in a notification or payment workflow. How do you decide whether a pattern helps or adds unnecessary complexity?

## Important distinctions and source caveats

Use the vocabulary above to select questions. Do not memorize every original sentence as a verified rule. These are concrete caveats encountered during review, not a complete technical errata pass:

| Topic | Precision to preserve during practice |
| --- | --- |
| Java array size | The length can be chosen at runtime; it becomes fixed after that array is created. |
| Stack, heap, primitives | Java runtime allocation is not simply “stack at compile time, heap at runtime.” Primitive fields can be stored within heap objects. |
| Checked exceptions | Checked exceptions occur at runtime; the compiler enforces catching or declaring them. A multi-catch cannot combine a superclass and its subclass. |
| Interfaces and overriding | Interfaces can have constants, default/static methods, and private helpers. Private methods are not overridden. An override cannot reduce access. |
| Final and records | A final reference does not freeze its object. Records provide shallow immutability; records became final in Java 16 after preview releases. |
| HashMap and TreeMap | A collision is not a duplicate key. HashMap treeification has capacity/threshold conditions. TreeMap null-key behavior depends on its comparator; natural ordering rejects null. |
| Streams | Stream code can still mutate objects through side effects; noninterference is a requirement for safe use, not a blanket runtime guarantee. |
| Locks and volatile | Both intrinsic locks and ReentrantLock are reentrant. Volatile supplies ordering/visibility guarantees; “never cached” is an oversimplification. It does not make increment atomic. |
| Virtual threads | Pinning behavior is JDK-version-dependent; do not apply Java 21 caveats unchanged to later JDKs. |
| Spring proxies | Self-invocation bypasses proxy advice. Method visibility/finality limitations depend on proxy type and framework version; “only public methods ever” is too broad. |
| JPA fetch strategy | EAGER does not guarantee a single SQL query or eliminate N+1. Fetch plans, joins, and query counts matter. |
| HTTP semantics | POST/PATCH are not guaranteed idempotent by their method semantics, but an operation can be designed to be idempotent. A 403 does not always establish successful authentication. |
| CQRS | Separate command/query models do not require separate databases. Sharing a database alone does not prove fresh reads. |
| Outbox and Kafka | The local transaction includes business and outbox rows; publication happens later. Kafka does not deduplicate arbitrary events merely because application event IDs match. Ordinary Kafka publication is not an XA participant. |
| JWT | The common signed compact JWT has three parts. JWT formats can also use encryption. Verify the expected token type, signature, permitted algorithm, issuer, audience, and lifetime before trusting claims. Revocation is possible with additional state/design. |
| Password storage | Hashing is not encryption. Use an appropriate salted password hash; MD5/SHA-1/plain SHA-256 or reversible password encryption are not suitable defaults. |
| CORS, CSRF, XSS | CORS is not a CSRF defense by itself. Statelessness alone does not eliminate CSRF if credentials are attached automatically. HttpOnly does not eliminate all XSS harm; legacy X-XSS-Protection is not a modern complete XSS defense. |
| Frontend generalizations | OnPush has triggers beyond input changes; not all observables are cold; a Promise has no general cancellation method, but its underlying operation may support abort. TypeScript has some runtime-emitting features; JSON is an ECMAScript built-in. |
| Maven optional dependencies | Optional affects downstream transitive inclusion; it does not mean the declaring project no longer needs the dependency. Aggregation and parent inheritance are separate concepts. |
| Version histories | Some removal/support claims in the notes need release-specific checking, including Applet APIs and Jackson compatibility. Retain their names as migration topics without treating the notes as a compatibility matrix. |
| Deployments | Zero downtime and easy rollback depend on health, capacity, schema, and compatibility—not only the strategy's name. |

## Practice order and session format

Start with Java terminology and fundamentals, then rotate through Spring/transactions, JWT and frontend/backend authentication, SQL/JPA, concurrency, messaging, design patterns, saga/outbox/CQRS, system design, and a smaller share of frontend questions. Keep AI orchestration topics such as LangChain and LangGraph for later unless requested.

Use one short, concrete question at a time, under 100 words, with a scenario or small snippet where useful. Allow an aloud answer. Then evaluate precisely, give a brief correction, ask at most one targeted follow-up, and rotate. Revisit terms through spaced recall; do not treat a missed practice session as failure. This file describes practice content and does not create scheduled tasks.

Continuity: the newer [Gaps notes](Gaps/README.md) supersede the older handoff where they overlap. JWT has now been practiced; revisit payload/signature terminology, decoding versus signature verification, and `exp`/`nbf`/`iss`/`aud` checks. Include short deployment-name recall and gradual DDD scenarios. Earlier pending prompts include `Arrays.asList` versus `Collections.singletonList` versus `ArrayList`, and event sourcing versus an audit log. Use recorded answers to guide later practice; do not infer mastery from topic presence.


## Additional terminology found in the coverage audit

A second audit compared source inline code, named APIs, acronyms, emphasized concepts, and PDF identifiers against the index. It found the following details that were not individually searchable in the first version, even where their parent topic was present. These are source-derived lookup terms, not separate claims of mastery. Incidental example class names and sample values remain excluded.

Legacy names and source errors are preserved for recognition: `jakarta.persistence.@Cacheable` and `org.springframework.cache.annotation.@Cacheable` are source notation, not valid fully qualified Java annotation syntax. The PDF's `SimpleGrantedAuthorities` refers to `SimpleGrantedAuthority`; `UsernamePasswordToken` occurs in its security example and should not be confused with Spring Security's `UsernamePasswordAuthenticationToken`. `AtlassianCrowdAuthenticationProvider` is the PDF's custom provider example. Deprecated methods and old Spring Security configuration calls should be studied alongside their modern replacements.

### Java APIs and runtime details

- `BigDecimal` — [java-spring-cheatsheet.md L892](java-spring-cheatsheet.md?plain=1#L892).
- `getFirst()` — [java-spring-cheatsheet.md L1596](java-spring-cheatsheet.md?plain=1#L1596).
- `getLast()` — [java-spring-cheatsheet.md L1596](java-spring-cheatsheet.md?plain=1#L1596).
- `reversed()` — [java-spring-cheatsheet.md L1596](java-spring-cheatsheet.md?plain=1#L1596).
- `lock()` — [java-spring-cheatsheet.md L381](java-spring-cheatsheet.md?plain=1#L381), [Java PDF p. 77](java.pdf#page=77).
- `lockInterruptibly()` — [java-spring-cheatsheet.md L382](java-spring-cheatsheet.md?plain=1#L382).
- `tryLock()` — [java-spring-cheatsheet.md L382](java-spring-cheatsheet.md?plain=1#L382).
- `unlock()` — [java-spring-cheatsheet.md L381](java-spring-cheatsheet.md?plain=1#L381), [Java PDF p. 77](java.pdf#page=77).
- `RecursiveTask<V>` — [java-spring-cheatsheet.md L279](java-spring-cheatsheet.md?plain=1#L279).
- `finalize()` — [java-spring-cheatsheet.md L1600](java-spring-cheatsheet.md?plain=1#L1600).
- `JEP 396` — [java-spring-cheatsheet.md L1577](java-spring-cheatsheet.md?plain=1#L1577).
- `JEP 411` — [java-spring-cheatsheet.md L1587](java-spring-cheatsheet.md?plain=1#L1587).
- `JEP 444` — [java-spring-cheatsheet.md L1595](java-spring-cheatsheet.md?plain=1#L1595).
- `JEP 451` — [java-spring-cheatsheet.md L1599](java-spring-cheatsheet.md?plain=1#L1599).
- `JEP 486` — [java-spring-cheatsheet.md L1604](java-spring-cheatsheet.md?plain=1#L1604).
- `JEP 503` — [java-spring-cheatsheet.md L1606](java-spring-cheatsheet.md?plain=1#L1606).

### Spring lifecycle, web, security, and migration details

- `SpringApplication.run()` — [java-spring-cheatsheet.md L572](java-spring-cheatsheet.md?plain=1#L572).
- `InitializingBean.afterPropertiesSet()` — [java-spring-cheatsheet.md L577](java-spring-cheatsheet.md?plain=1#L577).
- `DisposableBean.destroy()` — [java-spring-cheatsheet.md L579](java-spring-cheatsheet.md?plain=1#L579).
- `Access-Control-Max-Age` — [java-spring-cheatsheet.md L505](java-spring-cheatsheet.md?plain=1#L505), [Java PDF p. 30](java.pdf#page=30).
- `/actuator/health` — [java-spring-cheatsheet.md L1564](java-spring-cheatsheet.md?plain=1#L1564).
- `/conditions` — [java-spring-cheatsheet.md L773](java-spring-cheatsheet.md?plain=1#L773).
- `/health` — [java-spring-cheatsheet.md L773](java-spring-cheatsheet.md?plain=1#L773).
- `/info` — [java-spring-cheatsheet.md L773](java-spring-cheatsheet.md?plain=1#L773).
- `/loggers` — [java-spring-cheatsheet.md L773](java-spring-cheatsheet.md?plain=1#L773).
- `/userinfo` — [java-spring-cheatsheet.md L1061](java-spring-cheatsheet.md?plain=1#L1061).
- `redirect_uri` — [java-spring-cheatsheet.md L1053](java-spring-cheatsheet.md?plain=1#L1053), [Java PDF p. 112](java.pdf#page=112).
- `WebSecurityConfigurerAdapter.authenticationManagerBean()` — [java-spring-cheatsheet.md L1527](java-spring-cheatsheet.md?plain=1#L1527).
- `configure(HttpSecurity http)` — [java-spring-cheatsheet.md L1523](java-spring-cheatsheet.md?plain=1#L1523), [Java PDF p. 115](java.pdf#page=115).
- `authorizeHttpRequests()` — [java-spring-cheatsheet.md L1005](java-spring-cheatsheet.md?plain=1#L1005).
- `authorizeRequests()` — [java-spring-cheatsheet.md L1005](java-spring-cheatsheet.md?plain=1#L1005), [Java PDF p. 115](java.pdf#page=115).
- `antMatchers()` — [java-spring-cheatsheet.md L1005](java-spring-cheatsheet.md?plain=1#L1005).
- `mvcMatchers()` — [java-spring-cheatsheet.md L1525](java-spring-cheatsheet.md?plain=1#L1525).
- `regexMatchers()` — [java-spring-cheatsheet.md L1525](java-spring-cheatsheet.md?plain=1#L1525).
- `requestMatchers()` — [java-spring-cheatsheet.md L1005](java-spring-cheatsheet.md?plain=1#L1005).
- `spring.mvc.pathmatch.matching-strategy` — [java-spring-cheatsheet.md L1559](java-spring-cheatsheet.md?plain=1#L1559).
- `spring.jpa.show-sql` — [java-spring-cheatsheet.md L862](java-spring-cheatsheet.md?plain=1#L862).
- `application-dev.yml` — [java-spring-cheatsheet.md L769](java-spring-cheatsheet.md?plain=1#L769).
- `jakarta.annotation` — [java-spring-cheatsheet.md L1138](java-spring-cheatsheet.md?plain=1#L1138).
- `javax.annotation-api` — [java-spring-cheatsheet.md L1138](java-spring-cheatsheet.md?plain=1#L1138), [Java PDF p. 129](java.pdf#page=129).
- `spring-security-core` — [java-spring-cheatsheet.md L1134](java-spring-cheatsheet.md?plain=1#L1134), [Java PDF p. 129](java.pdf#page=129).
- `spring-boot-starter-logging` — [java-spring-cheatsheet.md L1333](java-spring-cheatsheet.md?plain=1#L1333).

### Persistence, testing, and Maven details

- `findByLastNameAndActiveTrue` — [java-spring-cheatsheet.md L790](java-spring-cheatsheet.md?plain=1#L790).
- `lower()` — [java-spring-cheatsheet.md L939](java-spring-cheatsheet.md?plain=1#L939).
- `@JdbcTypeCode(SqlTypes.JSON)` — [habiba-interview-prep-cheatsheet.md L70](habiba-interview-prep-cheatsheet.md?plain=1#L70).
- `jakarta.persistence.@Cacheable` — [java-spring-cheatsheet.md L883](java-spring-cheatsheet.md?plain=1#L883).
- `org.springframework.cache.annotation.@Cacheable` — [java-spring-cheatsheet.md L884](java-spring-cheatsheet.md?plain=1#L884).
- `mockStatic()` — [java-spring-cheatsheet.md L23](java-spring-cheatsheet.md?plain=1#L23).
- `@ExtendWith(MockitoExtension.class)` — [java-spring-cheatsheet.md L1224](java-spring-cheatsheet.md?plain=1#L1224), [Java PDF p. 52](java.pdf#page=52).
- `@ExtendWith(SpringExtension.class)` — [java-spring-cheatsheet.md L1224](java-spring-cheatsheet.md?plain=1#L1224).
- `@RunWith(MockitoJUnitRunner.class)` — [java-spring-cheatsheet.md L1219](java-spring-cheatsheet.md?plain=1#L1219), [Java PDF p. 52](java.pdf#page=52).
- `@RunWith(SpringRunner.class)` — [java-spring-cheatsheet.md L1219](java-spring-cheatsheet.md?plain=1#L1219), [Java PDF p. 50](java.pdf#page=50).
- `doReturn(x).when(spy).method()` — [java-spring-cheatsheet.md L1184](java-spring-cheatsheet.md?plain=1#L1184).
- `when(spy.method())` — [java-spring-cheatsheet.md L1184](java-spring-cheatsheet.md?plain=1#L1184).
- `assertThat(x).contains(...)` — [java-spring-cheatsheet.md L1214](java-spring-cheatsheet.md?plain=1#L1214).
- `spring-boot-dependencies` — [java-spring-cheatsheet.md L1359](java-spring-cheatsheet.md?plain=1#L1359).
- `<build>` — [java-spring-cheatsheet.md L1299](java-spring-cheatsheet.md?plain=1#L1299), [Java PDF p. 107](java.pdf#page=107).
- `<dependencies>` — [java-spring-cheatsheet.md L1352](java-spring-cheatsheet.md?plain=1#L1352), [Java PDF p. 100](java.pdf#page=100).
- `<modules>` — [java-spring-cheatsheet.md L1368](java-spring-cheatsheet.md?plain=1#L1368), [Java PDF p. 103](java.pdf#page=103).
- `<packaging>pom</packaging>` — [java-spring-cheatsheet.md L1362](java-spring-cheatsheet.md?plain=1#L1362), [Java PDF p. 103](java.pdf#page=103).
- `<parent>` — [java-spring-cheatsheet.md L1372](java-spring-cheatsheet.md?plain=1#L1372), [Java PDF p. 104](java.pdf#page=104).
- `<type>pom</type>` — [java-spring-cheatsheet.md L1329](java-spring-cheatsheet.md?plain=1#L1329), [Java PDF p. 103](java.pdf#page=103).
- `target/classes` — [java-spring-cheatsheet.md L1273](java-spring-cheatsheet.md?plain=1#L1273).
- `mvn clean install -Pcoverage` — [java-spring-cheatsheet.md L1396](java-spring-cheatsheet.md?plain=1#L1396).
- `mvn test` — [habiba-interview-prep-cheatsheet.md L352](habiba-interview-prep-cheatsheet.md?plain=1#L352).

### Architecture and delivery details

- `AWS` — [architecture-patterns-cheat-sheet.md L602](architecture-patterns-cheat-sheet.md?plain=1#L602).
- `DAO` — [architecture-patterns-cheat-sheet.md L1268](architecture-patterns-cheat-sheet.md?plain=1#L1268).
- `KafkaTemplate` — [architecture-patterns-cheat-sheet.md L925](architecture-patterns-cheat-sheet.md?plain=1#L925).
- `docker build` — [habiba-interview-prep-cheatsheet.md L349](habiba-interview-prep-cheatsheet.md?plain=1#L349).
- `kubectl apply` — [habiba-interview-prep-cheatsheet.md L362](habiba-interview-prep-cheatsheet.md?plain=1#L362).

### Frontend APIs and historical wording

- `ES3` — [frontend-cheatsheet.md L17](frontend-cheatsheet.md?plain=1#L17).
- `takeUntilDestroyed()` — [frontend-cheatsheet.md L609](frontend-cheatsheet.md?plain=1#L609).
- `<Suspense>` — [frontend-cheatsheet.md L641](frontend-cheatsheet.md?plain=1#L641).
- `dispatch()` — [frontend-cheatsheet.md L22](frontend-cheatsheet.md?plain=1#L22).
- `getState()` — [frontend-cheatsheet.md L22](frontend-cheatsheet.md?plain=1#L22).
- `store.subscribe()` — [frontend-cheatsheet.md L468](frontend-cheatsheet.md?plain=1#L468).
- `subscribe()` — [frontend-cheatsheet.md L22](frontend-cheatsheet.md?plain=1#L22).
- `next(value)` — [architecture-patterns-cheat-sheet.md L953](architecture-patterns-cheat-sheet.md?plain=1#L953).
- `complete()` — [frontend-cheatsheet.md L606](frontend-cheatsheet.md?plain=1#L606).
- `error()` — [frontend-cheatsheet.md L607](frontend-cheatsheet.md?plain=1#L607).
- `.pipe()` — [frontend-cheatsheet.md L602](frontend-cheatsheet.md?plain=1#L602).
- `.catch()` — [frontend-cheatsheet.md L279](frontend-cheatsheet.md?plain=1#L279).
- `.finally()` — [frontend-cheatsheet.md L279](frontend-cheatsheet.md?plain=1#L279).
- `.then()` — [frontend-cheatsheet.md L279](frontend-cheatsheet.md?plain=1#L279).
- `fn?.()` — [frontend-cheatsheet.md L217](frontend-cheatsheet.md?plain=1#L217).
- `user?.address?.city` — [frontend-cheatsheet.md L216](frontend-cheatsheet.md?plain=1#L216).
- `count ?? 10` — [frontend-cheatsheet.md L223](frontend-cheatsheet.md?plain=1#L223).

### JWT recall notation

- `header.payload.signature` — [JWT-Parts.md L7](Gaps/Terminology/JWT-Parts.md?plain=1#L7).

### PDF annotation metadata and security examples

- `ElementType` — [Java PDF p. 131](java.pdf#page=131).
- `RetentionPolicy` — [Java PDF p. 131](java.pdf#page=131).
- `ServletException` — [Java PDF p. 42](java.pdf#page=42).
- `AtlassianCrowdAuthenticationProvider` — [Java PDF p. 117](java.pdf#page=117).
- `UsernamePasswordToken` — [Java PDF p. 114](java.pdf#page=114).
- `SimpleGrantedAuthorities` — [Java PDF p. 118](java.pdf#page=118).

### Further PDF method-level lookup

These entries retain the receiver names used in the PDF examples. Security-header APIs and reflective construction examples include legacy usage; consult current framework/JDK documentation before adopting them.

- `thenAcceptAsync` — [Java PDF p. 59](java.pdf#page=59).
- `thenApplyAsync` — [Java PDF p. 59](java.pdf#page=59).
- `thenRunAsync` — [Java PDF p. 59](java.pdf#page=59).
- `authentication.getCredentials` — [Java PDF p. 120](java.pdf#page=120).
- `authentication.getPrincipal` — [Java PDF p. 120](java.pdf#page=120).
- `getAuthority` — [Java PDF p. 119](java.pdf#page=119).
- `formLogin` — [Java PDF p. 115](java.pdf#page=115).
- `httpBasic` — [Java PDF p. 115](java.pdf#page=115).
- `loginPage` — [Java PDF p. 115](java.pdf#page=115).
- `cacheControl` — [Java PDF p. 121](java.pdf#page=121).
- `contentTypeOptions` — [Java PDF p. 121](java.pdf#page=121).
- `frameOptions` — [Java PDF p. 122](java.pdf#page=122).
- `xssProtection` — [Java PDF p. 122](java.pdf#page=122).
- `chain.doFilter` — [Java PDF p. 42](java.pdf#page=42).
- `response.setStatus` — [Java PDF p. 114](java.pdf#page=114).
- `classPool.makeClass` — [Java PDF p. 47](java.pdf#page=47).
- `toClass` — [Java PDF p. 47](java.pdf#page=47).
- `clazz.newInstance` — [Java PDF p. 53](java.pdf#page=53).
- `context.getBean` — [Java PDF p. 34](java.pdf#page=34).
- `argumentCaptor.capture` — [Java PDF p. 54](java.pdf#page=54).
- `argumentCaptor.getValue` — [Java PDF p. 54](java.pdf#page=54).
- `forClass` — [Java PDF p. 54](java.pdf#page=54).
- `joinPoint.getSignature` — [Java PDF p. 136](java.pdf#page=136).
- `joinPoint.proceed` — [Java PDF p. 136](java.pdf#page=136).
- `entityManager.createQuery` — [Java PDF p. 37](java.pdf#page=37).
- `isEqualTo` — [Java PDF p. 64](java.pdf#page=64).
- `isNotEqualTo` — [Java PDF p. 64](java.pdf#page=64).
- `currentTimeMillis` — [Java PDF p. 136](java.pdf#page=136).
- `parseInt` — [Java PDF p. 25](java.pdf#page=25).
- `rwLock.readLock` — [Java PDF p. 78](java.pdf#page=78).
- `rwLock.writeLock` — [Java PDF p. 78](java.pdf#page=78).

## Source inventories

These inventories preserve the source headings and locations so a small topic is not lost in the consolidated groups. Heading wording is retained as a locator, including historical terminology and claims that need the caveats above. Documentation-maintenance headings are included for audit completeness. PDF page numbers refer to the physical pages of the supplied files.

### Markdown section inventory

#### J: java-spring-cheatsheet.md

- [Java & Spring interview cheat sheet](java-spring-cheatsheet.md?plain=1#L1) — line 1.
- [⚠️ Corrections — your notes vs. the fix](java-spring-cheatsheet.md?plain=1#L8) — line 8.
- [OOP fundamentals](java-spring-cheatsheet.md?plain=1#L32) — line 32.
- [Encapsulation](java-spring-cheatsheet.md?plain=1#L34) — line 34.
- [Abstraction](java-spring-cheatsheet.md?plain=1#L39) — line 39.
- [Inheritance](java-spring-cheatsheet.md?plain=1#L44) — line 44.
- [Polymorphism](java-spring-cheatsheet.md?plain=1#L49) — line 49.
- [Method overloading](java-spring-cheatsheet.md?plain=1#L53) — line 53.
- [Method overriding](java-spring-cheatsheet.md?plain=1#L57) — line 57.
- [Overriding and visibility](java-spring-cheatsheet.md?plain=1#L62) — line 62.
- [Association](java-spring-cheatsheet.md?plain=1#L67) — line 67.
- [Composition](java-spring-cheatsheet.md?plain=1#L71) — line 71.
- [Java language basics](java-spring-cheatsheet.md?plain=1#L78) — line 78.
- [Access modifiers](java-spring-cheatsheet.md?plain=1#L80) — line 80.
- [static](java-spring-cheatsheet.md?plain=1#L87) — line 87.
- [final](java-spring-cheatsheet.md?plain=1#L94) — line 94.
- [transient](java-spring-cheatsheet.md?plain=1#L100) — line 100.
- [Wrapper vs primitive](java-spring-cheatsheet.md?plain=1#L104) — line 104.
- [Varargs ⚠️](java-spring-cheatsheet.md?plain=1#L110) — line 110.
- [Switch statement](java-spring-cheatsheet.md?plain=1#L124) — line 124.
- [Anonymous class](java-spring-cheatsheet.md?plain=1#L131) — line 131.
- [Marker interface](java-spring-cheatsheet.md?plain=1#L139) — line 139.
- [Serialization](java-spring-cheatsheet.md?plain=1#L144) — line 144.
- [record ⚠️](java-spring-cheatsheet.md?plain=1#L149) — line 149.
- [Sealed class](java-spring-cheatsheet.md?plain=1#L160) — line 160.
- [a = x++ vs a = ++x](java-spring-cheatsheet.md?plain=1#L173) — line 173.
- [Reflection](java-spring-cheatsheet.md?plain=1#L178) — line 178.
- [Exceptions & error handling](java-spring-cheatsheet.md?plain=1#L185) — line 185.
- [Throwable hierarchy](java-spring-cheatsheet.md?plain=1#L187) — line 187.
- [Checked exception](java-spring-cheatsheet.md?plain=1#L192) — line 192.
- [Unchecked exception](java-spring-cheatsheet.md?plain=1#L197) — line 197.
- [Resource management](java-spring-cheatsheet.md?plain=1#L202) — line 202.
- [Collections & hashing](java-spring-cheatsheet.md?plain=1#L213) — line 213.
- [Collection](java-spring-cheatsheet.md?plain=1#L215) — line 215.
- [Hash collision](java-spring-cheatsheet.md?plain=1#L219) — line 219.
- [Separate chaining](java-spring-cheatsheet.md?plain=1#L222) — line 222.
- [Open addressing](java-spring-cheatsheet.md?plain=1#L227) — line 227.
- [HashMap](java-spring-cheatsheet.md?plain=1#L232) — line 232.
- [LinkedHashMap](java-spring-cheatsheet.md?plain=1#L237) — line 237.
- [TreeMap ⚠️](java-spring-cheatsheet.md?plain=1#L241) — line 241.
- [TreeMap vs LinkedHashMap — the one-liner](java-spring-cheatsheet.md?plain=1#L248) — line 248.
- [Streams & functional Java](java-spring-cheatsheet.md?plain=1#L253) — line 253.
- [Stream](java-spring-cheatsheet.md?plain=1#L255) — line 255.
- [reduce](java-spring-cheatsheet.md?plain=1#L261) — line 261.
- [Parallel stream](java-spring-cheatsheet.md?plain=1#L270) — line 270.
- [Fork/Join framework](java-spring-cheatsheet.md?plain=1#L276) — line 276.
- [Optional](java-spring-cheatsheet.md?plain=1#L281) — line 281.
- [Hardware & memory basics](java-spring-cheatsheet.md?plain=1#L287) — line 287.
- [CPU (Central Processing Unit)](java-spring-cheatsheet.md?plain=1#L289) — line 289.
- [CPU register](java-spring-cheatsheet.md?plain=1#L292) — line 292.
- [CPU cache](java-spring-cheatsheet.md?plain=1#L295) — line 295.
- [RAM (Random Access Memory)](java-spring-cheatsheet.md?plain=1#L300) — line 300.
- [Memory hierarchy — fastest to slowest](java-spring-cheatsheet.md?plain=1#L303) — line 303.
- [Volatile memory](java-spring-cheatsheet.md?plain=1#L307) — line 307.
- [Stack memory vs heap memory ⚠️](java-spring-cheatsheet.md?plain=1#L311) — line 311.
- [Thread caching of shared data](java-spring-cheatsheet.md?plain=1#L317) — line 317.
- [JVM memory, GC & diagnostics](java-spring-cheatsheet.md?plain=1#L324) — line 324.
- [Garbage collection (GC)](java-spring-cheatsheet.md?plain=1#L326) — line 326.
- [Memory leak](java-spring-cheatsheet.md?plain=1#L331) — line 331.
- [Heap dump](java-spring-cheatsheet.md?plain=1#L335) — line 335.
- [Thread dump](java-spring-cheatsheet.md?plain=1#L339) — line 339.
- [Profiling](java-spring-cheatsheet.md?plain=1#L343) — line 343.
- [PermGen / Metaspace ⚠️](java-spring-cheatsheet.md?plain=1#L347) — line 347.
- [Concurrency & threading](java-spring-cheatsheet.md?plain=1#L354) — line 354.
- [Thread-safe](java-spring-cheatsheet.md?plain=1#L356) — line 356.
- [synchronized](java-spring-cheatsheet.md?plain=1#L359) — line 359.
- [Intrinsic lock (monitor lock)](java-spring-cheatsheet.md?plain=1#L364) — line 364.
- [volatile](java-spring-cheatsheet.md?plain=1#L368) — line 368.
- [Atomic variables](java-spring-cheatsheet.md?plain=1#L373) — line 373.
- [ReentrantLock](java-spring-cheatsheet.md?plain=1#L379) — line 379.
- [ReadWriteLock](java-spring-cheatsheet.md?plain=1#L385) — line 385.
- [Atomics vs locks — comparison](java-spring-cheatsheet.md?plain=1#L390) — line 390.
- [ConcurrentHashMap ⚠️](java-spring-cheatsheet.md?plain=1#L397) — line 397.
- [ConcurrentLinkedQueue](java-spring-cheatsheet.md?plain=1#L404) — line 404.
- [CopyOnWriteArrayList ⚠️](java-spring-cheatsheet.md?plain=1#L409) — line 409.
- [CompletableFuture](java-spring-cheatsheet.md?plain=1#L415) — line 415.
- [Virtual threads (Java 21+)](java-spring-cheatsheet.md?plain=1#L422) — line 422.
- [Thread pool](java-spring-cheatsheet.md?plain=1#L428) — line 428.
- [Servlet container](java-spring-cheatsheet.md?plain=1#L433) — line 433.
- [JDK, JRE & Java versions](java-spring-cheatsheet.md?plain=1#L439) — line 439.
- [JDK (Java Development Kit)](java-spring-cheatsheet.md?plain=1#L441) — line 441.
- [JRE (Java Runtime Environment)](java-spring-cheatsheet.md?plain=1#L445) — line 445.
- [Java 8 (2014, LTS)](java-spring-cheatsheet.md?plain=1#L449) — line 449.
- [Java 9 (2017)](java-spring-cheatsheet.md?plain=1#L455) — line 455.
- [Java 11 (2018, LTS)](java-spring-cheatsheet.md?plain=1#L461) — line 461.
- [Java 17 (2021, LTS)](java-spring-cheatsheet.md?plain=1#L464) — line 464.
- [Java 21 (2023, LTS)](java-spring-cheatsheet.md?plain=1#L471) — line 471.
- [HTTP & REST](java-spring-cheatsheet.md?plain=1#L476) — line 476.
- [Status codes worth memorizing](java-spring-cheatsheet.md?plain=1#L478) — line 478.
- [HTTP headers](java-spring-cheatsheet.md?plain=1#L489) — line 489.
- [OPTIONS method](java-spring-cheatsheet.md?plain=1#L493) — line 493.
- [CORS (Cross-Origin Resource Sharing)](java-spring-cheatsheet.md?plain=1#L497) — line 497.
- [Preflight request](java-spring-cheatsheet.md?plain=1#L503) — line 503.
- [Idempotent request](java-spring-cheatsheet.md?plain=1#L507) — line 507.
- [HATEOAS](java-spring-cheatsheet.md?plain=1#L513) — line 513.
- [MVC (Model–View–Controller)](java-spring-cheatsheet.md?plain=1#L521) — line 521.
- [Spring core — IoC & dependency injection](java-spring-cheatsheet.md?plain=1#L526) — line 526.
- [IoC (Inversion of Control)](java-spring-cheatsheet.md?plain=1#L528) — line 528.
- [DI (Dependency Injection)](java-spring-cheatsheet.md?plain=1#L533) — line 533.
- [Constructor injection](java-spring-cheatsheet.md?plain=1#L537) — line 537.
- [Field injection](java-spring-cheatsheet.md?plain=1#L544) — line 544.
- [Setter injection](java-spring-cheatsheet.md?plain=1#L549) — line 549.
- [@Autowired](java-spring-cheatsheet.md?plain=1#L554) — line 554.
- [Spring core — container & beans](java-spring-cheatsheet.md?plain=1#L561) — line 561.
- [Spring container](java-spring-cheatsheet.md?plain=1#L563) — line 563.
- [BeanFactory](java-spring-cheatsheet.md?plain=1#L566) — line 566.
- [ApplicationContext](java-spring-cheatsheet.md?plain=1#L569) — line 569.
- [Bean lifecycle](java-spring-cheatsheet.md?plain=1#L574) — line 574.
- [Bean scopes](java-spring-cheatsheet.md?plain=1#L582) — line 582.
- [Spring core — stereotype annotations](java-spring-cheatsheet.md?plain=1#L593) — line 593.
- [@Component](java-spring-cheatsheet.md?plain=1#L595) — line 595.
- [@Service](java-spring-cheatsheet.md?plain=1#L599) — line 599.
- [@Repository](java-spring-cheatsheet.md?plain=1#L603) — line 603.
- [@Controller](java-spring-cheatsheet.md?plain=1#L608) — line 608.
- [@RestController](java-spring-cheatsheet.md?plain=1#L612) — line 612.
- [@ResponseBody](java-spring-cheatsheet.md?plain=1#L615) — line 615.
- [@ControllerAdvice / @RestControllerAdvice ⚠️](java-spring-cheatsheet.md?plain=1#L619) — line 619.
- [@ExceptionHandler](java-spring-cheatsheet.md?plain=1#L625) — line 625.
- [@Configuration](java-spring-cheatsheet.md?plain=1#L630) — line 630.
- [@Bean](java-spring-cheatsheet.md?plain=1#L633) — line 633.
- [@Value](java-spring-cheatsheet.md?plain=1#L636) — line 636.
- [@Profile](java-spring-cheatsheet.md?plain=1#L640) — line 640.
- [@Conditional](java-spring-cheatsheet.md?plain=1#L644) — line 644.
- [SpEL (Spring Expression Language)](java-spring-cheatsheet.md?plain=1#L648) — line 648.
- [Spring core — AOP & transactions](java-spring-cheatsheet.md?plain=1#L659) — line 659.
- [Proxy-based AOP](java-spring-cheatsheet.md?plain=1#L661) — line 661.
- [AspectJ-based AOP](java-spring-cheatsheet.md?plain=1#L667) — line 667.
- [Declarative transaction management](java-spring-cheatsheet.md?plain=1#L672) — line 672.
- [@Transactional](java-spring-cheatsheet.md?plain=1#L678) — line 678.
- [Propagation behaviour](java-spring-cheatsheet.md?plain=1#L684) — line 684.
- [Isolation level](java-spring-cheatsheet.md?plain=1#L694) — line 694.
- [Transaction manager](java-spring-cheatsheet.md?plain=1#L702) — line 702.
- [Spring web — request pipeline](java-spring-cheatsheet.md?plain=1#L708) — line 708.
- [DispatcherServlet](java-spring-cheatsheet.md?plain=1#L710) — line 710.
- [Servlet filter](java-spring-cheatsheet.md?plain=1#L713) — line 713.
- [Interceptor](java-spring-cheatsheet.md?plain=1#L719) — line 719.
- [Filter vs interceptor — the one-liner](java-spring-cheatsheet.md?plain=1#L724) — line 724.
- [@PathVariable](java-spring-cheatsheet.md?plain=1#L727) — line 727.
- [Spring Boot](java-spring-cheatsheet.md?plain=1#L739) — line 739.
- [Spring vs Spring Boot — deployment](java-spring-cheatsheet.md?plain=1#L741) — line 741.
- [Spring vs Spring Boot — configuration](java-spring-cheatsheet.md?plain=1#L745) — line 745.
- [@SpringBootApplication](java-spring-cheatsheet.md?plain=1#L750) — line 750.
- [@EnableAutoConfiguration](java-spring-cheatsheet.md?plain=1#L754) — line 754.
- [Starter dependency](java-spring-cheatsheet.md?plain=1#L758) — line 758.
- [Spring Web (what the starter gives you automatically)](java-spring-cheatsheet.md?plain=1#L762) — line 762.
- [application.properties / application.yml](java-spring-cheatsheet.md?plain=1#L767) — line 767.
- [Spring Boot Actuator](java-spring-cheatsheet.md?plain=1#L772) — line 772.
- [JPA, Hibernate & Spring Data](java-spring-cheatsheet.md?plain=1#L777) — line 777.
- [JPA (Java Persistence API)](java-spring-cheatsheet.md?plain=1#L779) — line 779.
- [Hibernate](java-spring-cheatsheet.md?plain=1#L783) — line 783.
- [Spring Data JPA](java-spring-cheatsheet.md?plain=1#L788) — line 788.
- [JPQL (Java Persistence Query Language)](java-spring-cheatsheet.md?plain=1#L793) — line 793.
- [@EnableJpaRepositories](java-spring-cheatsheet.md?plain=1#L803) — line 803.
- [Entity relationships — the annotations](java-spring-cheatsheet.md?plain=1#L810) — line 810.
- [@JoinColumn — the owning side](java-spring-cheatsheet.md?plain=1#L831) — line 831.
- [mappedBy — the inverse side](java-spring-cheatsheet.md?plain=1#L836) — line 836.
- [@JoinTable — many-to-many](java-spring-cheatsheet.md?plain=1#L840) — line 840.
- [Eager fetching](java-spring-cheatsheet.md?plain=1#L844) — line 844.
- [Lazy fetching](java-spring-cheatsheet.md?plain=1#L848) — line 848.
- [JPA default fetch types](java-spring-cheatsheet.md?plain=1#L853) — line 853.
- [N+1 problem](java-spring-cheatsheet.md?plain=1#L858) — line 858.
- [Caching (general)](java-spring-cheatsheet.md?plain=1#L864) — line 864.
- [First-level cache (session cache)](java-spring-cheatsheet.md?plain=1#L868) — line 868.
- [Second-level cache](java-spring-cheatsheet.md?plain=1#L875) — line 875.
- [@Cacheable — two different annotations ⚠️](java-spring-cheatsheet.md?plain=1#L881) — line 881.
- [Second-level cache concurrency strategies](java-spring-cheatsheet.md?plain=1#L895) — line 895.
- [Query cache](java-spring-cheatsheet.md?plain=1#L901) — line 901.
- [Projection](java-spring-cheatsheet.md?plain=1#L906) — line 906.
- [Open projection](java-spring-cheatsheet.md?plain=1#L916) — line 916.
- [Class-based projection (DTO projection)](java-spring-cheatsheet.md?plain=1#L927) — line 927.
- [@Formula ⚠️](java-spring-cheatsheet.md?plain=1#L932) — line 932.
- [Entity inheritance strategies](java-spring-cheatsheet.md?plain=1#L944) — line 944.
- [Polymorphic query](java-spring-cheatsheet.md?plain=1#L946) — line 946.
- [Mapped superclass](java-spring-cheatsheet.md?plain=1#L950) — line 950.
- [Table per class](java-spring-cheatsheet.md?plain=1#L956) — line 956.
- [Single table](java-spring-cheatsheet.md?plain=1#L962) — line 962.
- [Joined table](java-spring-cheatsheet.md?plain=1#L969) — line 969.
- [Choosing between them — quick rule](java-spring-cheatsheet.md?plain=1#L975) — line 975.
- [Spring Security](java-spring-cheatsheet.md?plain=1#L980) — line 980.
- [Spring Security](java-spring-cheatsheet.md?plain=1#L982) — line 982.
- [Authentication](java-spring-cheatsheet.md?plain=1#L987) — line 987.
- [Authorization](java-spring-cheatsheet.md?plain=1#L991) — line 991.
- [RBAC (Role-Based Access Control)](java-spring-cheatsheet.md?plain=1#L994) — line 994.
- [Token-based authentication](java-spring-cheatsheet.md?plain=1#L998) — line 998.
- [Security filter chain ⚠️](java-spring-cheatsheet.md?plain=1#L1001) — line 1001.
- [antMatchers / requestMatchers](java-spring-cheatsheet.md?plain=1#L1007) — line 1007.
- [The three authentication scenarios](java-spring-cheatsheet.md?plain=1#L1023) — line 1023.
- [JWT, OAuth2 & OIDC](java-spring-cheatsheet.md?plain=1#L1030) — line 1030.
- [JWT (JSON Web Token)](java-spring-cheatsheet.md?plain=1#L1032) — line 1032.
- [Refresh token](java-spring-cheatsheet.md?plain=1#L1040) — line 1040.
- [OAuth2](java-spring-cheatsheet.md?plain=1#L1045) — line 1045.
- [OAuth2 authorization code flow](java-spring-cheatsheet.md?plain=1#L1050) — line 1050.
- [OIDC (OpenID Connect)](java-spring-cheatsheet.md?plain=1#L1059) — line 1059.
- [Keycloak](java-spring-cheatsheet.md?plain=1#L1065) — line 1065.
- [CSRF, CORS & encryption](java-spring-cheatsheet.md?plain=1#L1071) — line 1071.
- [CSRF (Cross-Site Request Forgery)](java-spring-cheatsheet.md?plain=1#L1073) — line 1073.
- [CSRF protection in Spring Security ⚠️](java-spring-cheatsheet.md?plain=1#L1078) — line 1078.
- [CSRF and session-centric applications](java-spring-cheatsheet.md?plain=1#L1086) — line 1086.
- [Symmetric key encryption](java-spring-cheatsheet.md?plain=1#L1090) — line 1090.
- [Public key (asymmetric) encryption](java-spring-cheatsheet.md?plain=1#L1094) — line 1094.
- [Hashing](java-spring-cheatsheet.md?plain=1#L1099) — line 1099.
- [Salting](java-spring-cheatsheet.md?plain=1#L1104) — line 1104.
- [Method-level security](java-spring-cheatsheet.md?plain=1#L1112) — line 1112.
- [Method security ⚠️](java-spring-cheatsheet.md?plain=1#L1114) — line 1114.
- [@Secured](java-spring-cheatsheet.md?plain=1#L1133) — line 1133.
- [@RolesAllowed](java-spring-cheatsheet.md?plain=1#L1137) — line 1137.
- [@PreAuthorize](java-spring-cheatsheet.md?plain=1#L1141) — line 1141.
- [@PostAuthorize](java-spring-cheatsheet.md?plain=1#L1149) — line 1149.
- [@PreFilter](java-spring-cheatsheet.md?plain=1#L1153) — line 1153.
- [@PostFilter](java-spring-cheatsheet.md?plain=1#L1163) — line 1163.
- [Testing](java-spring-cheatsheet.md?plain=1#L1168) — line 1168.
- [Mockito](java-spring-cheatsheet.md?plain=1#L1170) — line 1170.
- [@Mock](java-spring-cheatsheet.md?plain=1#L1179) — line 1179.
- [@Spy](java-spring-cheatsheet.md?plain=1#L1182) — line 1182.
- [@InjectMocks](java-spring-cheatsheet.md?plain=1#L1186) — line 1186.
- [Mockito's stubbing limits ⚠️](java-spring-cheatsheet.md?plain=1#L1190) — line 1190.
- [ArgumentCaptor](java-spring-cheatsheet.md?plain=1#L1194) — line 1194.
- [JMockit](java-spring-cheatsheet.md?plain=1#L1204) — line 1204.
- [Hamcrest](java-spring-cheatsheet.md?plain=1#L1207) — line 1207.
- [@RunWith (JUnit 4)](java-spring-cheatsheet.md?plain=1#L1216) — line 1216.
- [@ExtendWith (JUnit 5)](java-spring-cheatsheet.md?plain=1#L1221) — line 1221.
- [@Rule (JUnit 4)](java-spring-cheatsheet.md?plain=1#L1226) — line 1226.
- [Spring TestContext Framework](java-spring-cheatsheet.md?plain=1#L1230) — line 1230.
- [@SpringBootTest](java-spring-cheatsheet.md?plain=1#L1235) — line 1235.
- [@MockBean ⚠️](java-spring-cheatsheet.md?plain=1#L1251) — line 1251.
- [@DataJpaTest](java-spring-cheatsheet.md?plain=1#L1257) — line 1257.
- [JaCoCo](java-spring-cheatsheet.md?plain=1#L1262) — line 1262.
- [Maven](java-spring-cheatsheet.md?plain=1#L1268) — line 1268.
- [Maven default lifecycle ⚠️](java-spring-cheatsheet.md?plain=1#L1270) — line 1270.
- [Phase](java-spring-cheatsheet.md?plain=1#L1281) — line 1281.
- [Goal](java-spring-cheatsheet.md?plain=1#L1285) — line 1285.
- [<goals> vs <phase>](java-spring-cheatsheet.md?plain=1#L1291) — line 1291.
- [Maven as a plugin execution framework](java-spring-cheatsheet.md?plain=1#L1296) — line 1296.
- [Compiler Plugin](java-spring-cheatsheet.md?plain=1#L1301) — line 1301.
- [Surefire Plugin](java-spring-cheatsheet.md?plain=1#L1306) — line 1306.
- [Failsafe Plugin](java-spring-cheatsheet.md?plain=1#L1310) — line 1310.
- [<groupId>](java-spring-cheatsheet.md?plain=1#L1314) — line 1314.
- [<artifactId>](java-spring-cheatsheet.md?plain=1#L1317) — line 1317.
- [<version>](java-spring-cheatsheet.md?plain=1#L1320) — line 1320.
- [<scope>](java-spring-cheatsheet.md?plain=1#L1323) — line 1323.
- [<exclusions>](java-spring-cheatsheet.md?plain=1#L1331) — line 1331.
- [<repositories>](java-spring-cheatsheet.md?plain=1#L1335) — line 1335.
- [Local repository](java-spring-cheatsheet.md?plain=1#L1339) — line 1339.
- [pom.xml](java-spring-cheatsheet.md?plain=1#L1342) — line 1342.
- [Super POM](java-spring-cheatsheet.md?plain=1#L1345) — line 1345.
- [<dependencyManagement>](java-spring-cheatsheet.md?plain=1#L1349) — line 1349.
- [BOM (Bill Of Materials)](java-spring-cheatsheet.md?plain=1#L1355) — line 1355.
- [POM packaging](java-spring-cheatsheet.md?plain=1#L1361) — line 1361.
- [JAR packaging](java-spring-cheatsheet.md?plain=1#L1364) — line 1364.
- [Aggregator POM](java-spring-cheatsheet.md?plain=1#L1367) — line 1367.
- [Parent POM](java-spring-cheatsheet.md?plain=1#L1371) — line 1371.
- [Transitive dependency](java-spring-cheatsheet.md?plain=1#L1375) — line 1375.
- [Dependency mediation — "nearest wins"](java-spring-cheatsheet.md?plain=1#L1379) — line 1379.
- [Maven profile](java-spring-cheatsheet.md?plain=1#L1385) — line 1385.
- [Microservices & distributed systems](java-spring-cheatsheet.md?plain=1#L1400) — line 1400.
- [Spring Boot vs Spring Cloud](java-spring-cheatsheet.md?plain=1#L1402) — line 1402.
- [Spring Cloud](java-spring-cheatsheet.md?plain=1#L1406) — line 1406.
- [Spring Cloud Config](java-spring-cheatsheet.md?plain=1#L1410) — line 1410.
- [Spring Cloud Gateway](java-spring-cheatsheet.md?plain=1#L1413) — line 1413.
- [Spring Cloud OpenFeign](java-spring-cheatsheet.md?plain=1#L1416) — line 1416.
- [Spring Cloud LoadBalancer](java-spring-cheatsheet.md?plain=1#L1419) — line 1419.
- [Spring Cloud Kubernetes](java-spring-cheatsheet.md?plain=1#L1422) — line 1422.
- [API gateway](java-spring-cheatsheet.md?plain=1#L1425) — line 1425.
- [API gateway vs load balancer](java-spring-cheatsheet.md?plain=1#L1429) — line 1429.
- [Distributed SQL databases](java-spring-cheatsheet.md?plain=1#L1433) — line 1433.
- [Libraries & tools](java-spring-cheatsheet.md?plain=1#L1440) — line 1440.
- [Jackson](java-spring-cheatsheet.md?plain=1#L1442) — line 1442.
- [ModelMapper](java-spring-cheatsheet.md?plain=1#L1453) — line 1453.
- [MapStruct](java-spring-cheatsheet.md?plain=1#L1457) — line 1457.
- [Redis](java-spring-cheatsheet.md?plain=1#L1462) — line 1462.
- [Spring version history](java-spring-cheatsheet.md?plain=1#L1468) — line 1468.
- [Spring Framework 1.x](java-spring-cheatsheet.md?plain=1#L1470) — line 1470.
- [Spring Framework 2.x](java-spring-cheatsheet.md?plain=1#L1473) — line 1473.
- [Spring Framework 3.x ⚠️](java-spring-cheatsheet.md?plain=1#L1478) — line 1478.
- [Spring Framework 4.x / 5.x](java-spring-cheatsheet.md?plain=1#L1482) — line 1482.
- [Spring Framework 6.x](java-spring-cheatsheet.md?plain=1#L1486) — line 1486.
- [Java & Spring migrations (Spring Boot 2 → 3, Java 11 → 25)](java-spring-cheatsheet.md?plain=1#L1492) — line 1492.
- [Why the upgrade happens at all](java-spring-cheatsheet.md?plain=1#L1494) — line 1494.
- [Spring Boot 2 → 3 — the baseline](java-spring-cheatsheet.md?plain=1#L1500) — line 1500.
- [javax.* → jakarta.*](java-spring-cheatsheet.md?plain=1#L1508) — line 1508.
- [Spring Security 5 → 6 — old → new](java-spring-cheatsheet.md?plain=1#L1517) — line 1517.
- [Hibernate 5 → 6](java-spring-cheatsheet.md?plain=1#L1549) — line 1549.
- [Spring MVC & web changes (Boot 2 → 3)](java-spring-cheatsheet.md?plain=1#L1556) — line 1556.
- [Config, Actuator & observability changes](java-spring-cheatsheet.md?plain=1#L1562) — line 1562.
- [Testing changes (Boot 2 → 3)](java-spring-cheatsheet.md?plain=1#L1569) — line 1569.
- [Java 11 → 17 — strong encapsulation](java-spring-cheatsheet.md?plain=1#L1575) — line 1575.
- [Java 11 → 17 — what was removed](java-spring-cheatsheet.md?plain=1#L1582) — line 1582.
- [Java 11 → 17 — what you gain](java-spring-cheatsheet.md?plain=1#L1590) — line 1590.
- [Java 17 → 21](java-spring-cheatsheet.md?plain=1#L1593) — line 1593.
- [Java 21 → 25](java-spring-cheatsheet.md?plain=1#L1602) — line 1602.
- [Migration playbook — the order that works](java-spring-cheatsheet.md?plain=1#L1612) — line 1612.
- [Migration tooling](java-spring-cheatsheet.md?plain=1#L1623) — line 1623.
- [Migration pitfall: dependency mediation](java-spring-cheatsheet.md?plain=1#L1630) — line 1630.
- [What's next: Spring Boot 4 / Spring Framework 7](java-spring-cheatsheet.md?plain=1#L1636) — line 1636.
- [How to update this cheat sheet](java-spring-cheatsheet.md?plain=1#L1646) — line 1646.
- [The format — three rules](java-spring-cheatsheet.md?plain=1#L1650) — line 1650.
- [Extras you can use](java-spring-cheatsheet.md?plain=1#L1665) — line 1665.
- [Where to put a new term](java-spring-cheatsheet.md?plain=1#L1673) — line 1673.
- [Regenerating the HTML](java-spring-cheatsheet.md?plain=1#L1679) — line 1679.
- [One thing that is hand-maintained](java-spring-cheatsheet.md?plain=1#L1692) — line 1692.

#### F: frontend-cheatsheet.md

- [Front-end interview cheat sheet](frontend-cheatsheet.md?plain=1#L1) — line 1.
- [⚠️ Corrections — your notes vs. the fix](frontend-cheatsheet.md?plain=1#L10) — line 10.
- [The DOM & the Virtual DOM](frontend-cheatsheet.md?plain=1#L27) — line 27.
- [DOM (Document Object Model)](frontend-cheatsheet.md?plain=1#L29) — line 29.
- [Virtual DOM](frontend-cheatsheet.md?plain=1#L34) — line 34.
- [Real DOM vs Virtual DOM ⚠️](frontend-cheatsheet.md?plain=1#L39) — line 39.
- [Does React use the Virtual DOM instead of the real DOM?](frontend-cheatsheet.md?plain=1#L48) — line 48.
- [Is the Virtual DOM actually faster? ⚠️](frontend-cheatsheet.md?plain=1#L51) — line 51.
- [Reconciliation (diffing)](frontend-cheatsheet.md?plain=1#L57) — line 57.
- [JavaScript execution model](frontend-cheatsheet.md?plain=1#L64) — line 64.
- [Function invocation](frontend-cheatsheet.md?plain=1#L66) — line 66.
- [Call stack](frontend-cheatsheet.md?plain=1#L70) — line 70.
- [Stack overflow](frontend-cheatsheet.md?plain=1#L75) — line 75.
- [Execution context](frontend-cheatsheet.md?plain=1#L80) — line 80.
- [Global execution context](frontend-cheatsheet.md?plain=1#L84) — line 84.
- [Function execution context](frontend-cheatsheet.md?plain=1#L90) — line 90.
- [Environment Record (the old "Variable Object") ⚠️](frontend-cheatsheet.md?plain=1#L94) — line 94.
- [Hoisting](frontend-cheatsheet.md?plain=1#L98) — line 98.
- [Temporal Dead Zone (TDZ)](frontend-cheatsheet.md?plain=1#L105) — line 105.
- [var vs let vs const](frontend-cheatsheet.md?plain=1#L109) — line 109.
- [Scope & closures](frontend-cheatsheet.md?plain=1#L117) — line 117.
- [Scope chain](frontend-cheatsheet.md?plain=1#L119) — line 119.
- [Lexical scope](frontend-cheatsheet.md?plain=1#L124) — line 124.
- [Closure](frontend-cheatsheet.md?plain=1#L128) — line 128.
- [Lexical scope vs closure ⚠️](frontend-cheatsheet.md?plain=1#L144) — line 144.
- [Shadowing](frontend-cheatsheet.md?plain=1#L151) — line 151.
- [Why an outer function can't see inner variables](frontend-cheatsheet.md?plain=1#L155) — line 155.
- [Types, coercion & equality](frontend-cheatsheet.md?plain=1#L170) — line 170.
- [Type coercion](frontend-cheatsheet.md?plain=1#L172) — line 172.
- [== vs ===](frontend-cheatsheet.md?plain=1#L178) — line 178.
- [Modern JavaScript syntax](frontend-cheatsheet.md?plain=1#L186) — line 186.
- [Destructuring](frontend-cheatsheet.md?plain=1#L188) — line 188.
- [Spread operator (...)](frontend-cheatsheet.md?plain=1#L197) — line 197.
- [Rest vs spread](frontend-cheatsheet.md?plain=1#L209) — line 209.
- [Optional chaining (?.)](frontend-cheatsheet.md?plain=1#L214) — line 214.
- [Nullish coalescing (??)](frontend-cheatsheet.md?plain=1#L220) — line 220.
- [Async JavaScript & the event loop](frontend-cheatsheet.md?plain=1#L231) — line 231.
- [JavaScript is single-threaded](frontend-cheatsheet.md?plain=1#L233) — line 233.
- [Event loop](frontend-cheatsheet.md?plain=1#L238) — line 238.
- [Callback queue (macrotask queue)](frontend-cheatsheet.md?plain=1#L243) — line 243.
- [Microtask queue (promise jobs queue)](frontend-cheatsheet.md?plain=1#L249) — line 249.
- [Execution order — the priority rule](frontend-cheatsheet.md?plain=1#L256) — line 256.
- [Web APIs ⚠️](frontend-cheatsheet.md?plain=1#L271) — line 271.
- [Promise](frontend-cheatsheet.md?plain=1#L278) — line 278.
- [async / await](frontend-cheatsheet.md?plain=1#L284) — line 284.
- [Callback hell](frontend-cheatsheet.md?plain=1#L292) — line 292.
- [Memory & garbage collection](frontend-cheatsheet.md?plain=1#L297) — line 297.
- [Garbage collector](frontend-cheatsheet.md?plain=1#L299) — line 299.
- [Common front-end memory leaks](frontend-cheatsheet.md?plain=1#L304) — line 304.
- [TypeScript](frontend-cheatsheet.md?plain=1#L311) — line 311.
- [TypeScript](frontend-cheatsheet.md?plain=1#L313) — line 313.
- [Static typing](frontend-cheatsheet.md?plain=1#L317) — line 317.
- [Compile-time type checking & type erasure](frontend-cheatsheet.md?plain=1#L321) — line 321.
- [Does TypeScript have its own event loop?](frontend-cheatsheet.md?plain=1#L326) — line 326.
- [TypeScript & Angular](frontend-cheatsheet.md?plain=1#L330) — line 330.
- [React fundamentals](frontend-cheatsheet.md?plain=1#L335) — line 335.
- [React](frontend-cheatsheet.md?plain=1#L337) — line 337.
- [Props vs state](frontend-cheatsheet.md?plain=1#L341) — line 341.
- [Hooks](frontend-cheatsheet.md?plain=1#L346) — line 346.
- [Rules of hooks](frontend-cheatsheet.md?plain=1#L350) — line 350.
- [useState](frontend-cheatsheet.md?plain=1#L356) — line 356.
- [useEffect](frontend-cheatsheet.md?plain=1#L367) — line 367.
- [Side effect](frontend-cheatsheet.md?plain=1#L380) — line 380.
- [Pure function](frontend-cheatsheet.md?plain=1#L384) — line 384.
- [useRef](frontend-cheatsheet.md?plain=1#L389) — line 389.
- [useMemo and useCallback](frontend-cheatsheet.md?plain=1#L394) — line 394.
- [useContext](frontend-cheatsheet.md?plain=1#L400) — line 400.
- [Keys in lists](frontend-cheatsheet.md?plain=1#L404) — line 404.
- [React vs Angular](frontend-cheatsheet.md?plain=1#L410) — line 410.
- [React vs Angular — the comparison](frontend-cheatsheet.md?plain=1#L412) — line 412.
- [Angular change detection](frontend-cheatsheet.md?plain=1#L419) — line 419.
- [State management](frontend-cheatsheet.md?plain=1#L426) — line 426.
- [State management](frontend-cheatsheet.md?plain=1#L428) — line 428.
- [Why state management exists](frontend-cheatsheet.md?plain=1#L431) — line 431.
- [How state management works](frontend-cheatsheet.md?plain=1#L437) — line 437.
- [Redux](frontend-cheatsheet.md?plain=1#L443) — line 443.
- [Store ⚠️](frontend-cheatsheet.md?plain=1#L447) — line 447.
- [Action](frontend-cheatsheet.md?plain=1#L453) — line 453.
- [Dispatch](frontend-cheatsheet.md?plain=1#L456) — line 456.
- [Reducer](frontend-cheatsheet.md?plain=1#L460) — line 460.
- [Subscribing to state changes](frontend-cheatsheet.md?plain=1#L466) — line 466.
- [Immutability — why Redux insists on it](frontend-cheatsheet.md?plain=1#L470) — line 470.
- [NgRx](frontend-cheatsheet.md?plain=1#L476) — line 476.
- [Routing & navigation](frontend-cheatsheet.md?plain=1#L481) — line 481.
- [Routing](frontend-cheatsheet.md?plain=1#L483) — line 483.
- [Routing in React](frontend-cheatsheet.md?plain=1#L489) — line 489.
- [Routing in Angular](frontend-cheatsheet.md?plain=1#L500) — line 500.
- [Route guards](frontend-cheatsheet.md?plain=1#L504) — line 504.
- [Authorization component (the React equivalent of a guard)](frontend-cheatsheet.md?plain=1#L509) — line 509.
- [Auth & HTTP](frontend-cheatsheet.md?plain=1#L516) — line 516.
- [Access token ⚠️](frontend-cheatsheet.md?plain=1#L518) — line 518.
- [Refresh token](frontend-cheatsheet.md?plain=1#L523) — line 523.
- [Storing tokens ⚠️](frontend-cheatsheet.md?plain=1#L528) — line 528.
- [Interceptors](frontend-cheatsheet.md?plain=1#L534) — line 534.
- [Axios](frontend-cheatsheet.md?plain=1#L543) — line 543.
- [Forms & error handling](frontend-cheatsheet.md?plain=1#L549) — line 549.
- [Form state management](frontend-cheatsheet.md?plain=1#L551) — line 551.
- [Client-side validation](frontend-cheatsheet.md?plain=1#L556) — line 556.
- [Server-side validation](frontend-cheatsheet.md?plain=1#L560) — line 560.
- [Error handling best practices](frontend-cheatsheet.md?plain=1#L564) — line 564.
- [Real-time & reactive programming](frontend-cheatsheet.md?plain=1#L571) — line 571.
- [Sockets / WebSockets](frontend-cheatsheet.md?plain=1#L573) — line 573.
- [Reactive programming](frontend-cheatsheet.md?plain=1#L579) — line 579.
- [RxJS](frontend-cheatsheet.md?plain=1#L583) — line 583.
- [Observable](frontend-cheatsheet.md?plain=1#L588) — line 588.
- [Observer (subscriber)](frontend-cheatsheet.md?plain=1#L594) — line 594.
- [Operators](frontend-cheatsheet.md?plain=1#L599) — line 599.
- [Subscription](frontend-cheatsheet.md?plain=1#L604) — line 604.
- [Observable vs Promise](frontend-cheatsheet.md?plain=1#L611) — line 611.
- [Build tooling & performance](frontend-cheatsheet.md?plain=1#L623) — line 623.
- [package.json](frontend-cheatsheet.md?plain=1#L625) — line 625.
- [Bundling](frontend-cheatsheet.md?plain=1#L630) — line 630.
- [Code-splitting](frontend-cheatsheet.md?plain=1#L635) — line 635.
- [Lazy loading in React ⚠️](frontend-cheatsheet.md?plain=1#L640) — line 640.
- [Lazy loading in Angular](frontend-cheatsheet.md?plain=1#L652) — line 652.
- [Babel](frontend-cheatsheet.md?plain=1#L657) — line 657.
- [Linting](frontend-cheatsheet.md?plain=1#L663) — line 663.
- [Code structure & conventions](frontend-cheatsheet.md?plain=1#L670) — line 670.
- [Component-based architecture](frontend-cheatsheet.md?plain=1#L672) — line 672.
- [Single Responsibility Principle](frontend-cheatsheet.md?plain=1#L676) — line 676.
- [Modules](frontend-cheatsheet.md?plain=1#L680) — line 680.
- [Naming conventions](frontend-cheatsheet.md?plain=1#L684) — line 684.
- [How to update this cheat sheet](frontend-cheatsheet.md?plain=1#L690) — line 690.
- [The format — three rules](frontend-cheatsheet.md?plain=1#L694) — line 694.
- [Extras you can use](frontend-cheatsheet.md?plain=1#L709) — line 709.
- [Where to put a new term](frontend-cheatsheet.md?plain=1#L717) — line 717.
- [Regenerating the HTML](frontend-cheatsheet.md?plain=1#L723) — line 723.
- [One thing that is hand-maintained](frontend-cheatsheet.md?plain=1#L737) — line 737.

#### A: architecture-patterns-cheat-sheet.md

- [Architecture patterns — interview cheat sheet](architecture-patterns-cheat-sheet.md?plain=1#L1) — line 1.
- [0. Database-per-service (the root problem)](architecture-patterns-cheat-sheet.md?plain=1#L10) — line 10.
- [1. Event-driven architecture](architecture-patterns-cheat-sheet.md?plain=1#L26) — line 26.
- [What is an event bus?](architecture-patterns-cheat-sheet.md?plain=1#L40) — line 40.
- [Aggregate (DDD)](architecture-patterns-cheat-sheet.md?plain=1#L72) — line 72.
- [Example — Order aggregate](architecture-patterns-cheat-sheet.md?plain=1#L88) — line 88.
- [Connection to Event Sourcing](architecture-patterns-cheat-sheet.md?plain=1#L112) — line 112.
- [2. API composition (API Composer) — bank dashboard](architecture-patterns-cheat-sheet.md?plain=1#L124) — line 124.
- [Dashboard example from the PDF](architecture-patterns-cheat-sheet.md?plain=1#L146) — line 146.
- [3. CQRS: Command Query Responsibility Segregation. It separates operations that change data (commands) from operations that read data (queries)](architecture-patterns-cheat-sheet.md?plain=1#L182) — line 182.
- [Bank example from the PDF](architecture-patterns-cheat-sheet.md?plain=1#L200) — line 200.
- [4. Event sourcing](architecture-patterns-cheat-sheet.md?plain=1#L238) — line 238.
- [5. Snapshot](architecture-patterns-cheat-sheet.md?plain=1#L281) — line 281.
- [6. Saga — distributed business transaction](architecture-patterns-cheat-sheet.md?plain=1#L321) — line 321.
- [Example A — vacation booking (PDF)](architecture-patterns-cheat-sheet.md?plain=1#L353) — line 353.
- [Example B — bank, update mobile number (PDF)](architecture-patterns-cheat-sheet.md?plain=1#L367) — line 367.
- [Two implementations (PDF)](architecture-patterns-cheat-sheet.md?plain=1#L375) — line 375.
- [7. Two-phase commit (2PC)](architecture-patterns-cheat-sheet.md?plain=1#L391) — line 391.
- [Two-phase commit (2PC)](architecture-patterns-cheat-sheet.md?plain=1#L408) — line 408.
- [Transactional Outbox (what the course uses instead of 2PC)](architecture-patterns-cheat-sheet.md?plain=1#L441) — line 441.
- [8. Domain-driven design (DDD)](architecture-patterns-cheat-sheet.md?plain=1#L473) — line 473.
- [Interview answer — “Do you know DDD?”](architecture-patterns-cheat-sheet.md?plain=1#L487) — line 487.
- [Terms (memorize this table)](architecture-patterns-cheat-sheet.md?plain=1#L510) — line 510.
- [9. Strangler Fig](architecture-patterns-cheat-sheet.md?plain=1#L549) — line 549.
- [Interview answer — “What is the Strangler Fig pattern?”](architecture-patterns-cheat-sheet.md?plain=1#L563) — line 563.
- [E-commerce flow](architecture-patterns-cheat-sheet.md?plain=1#L569) — line 569.
- [10. Hexagonal architecture (ports and adapters)](architecture-patterns-cheat-sheet.md?plain=1#L595) — line 595.
- [Interview answer — “What is hexagonal architecture?”](architecture-patterns-cheat-sheet.md?plain=1#L609) — line 609.
- [11. Proxy (structural) — Geekific](architecture-patterns-cheat-sheet.md?plain=1#L650) — line 650.
- [What else a proxy can do](architecture-patterns-cheat-sheet.md?plain=1#L677) — line 677.
- [Not the same as — Adapter vs Proxy vs Decorator](architecture-patterns-cheat-sheet.md?plain=1#L691) — line 691.
- [Adapter — make a square peg fit a round hole](architecture-patterns-cheat-sheet.md?plain=1#L717) — line 717.
- [Decorator — add behavior, and stack it](architecture-patterns-cheat-sheet.md?plain=1#L731) — line 731.
- [Extra interview terms](architecture-patterns-cheat-sheet.md?plain=1#L763) — line 763.
- [Materialized view (in the PDF — dashboard without live fan-out)](architecture-patterns-cheat-sheet.md?plain=1#L767) — line 767.
- [BDD](architecture-patterns-cheat-sheet.md?plain=1#L779) — line 779.
- [GoF design patterns — 10 in 10 minutes (Fireship)](architecture-patterns-cheat-sheet.md?plain=1#L795) — line 795.
- [Creational](architecture-patterns-cheat-sheet.md?plain=1#L809) — line 809.
- [Singleton — only one instance](architecture-patterns-cheat-sheet.md?plain=1#L813) — line 813.
- [Prototype — clone](architecture-patterns-cheat-sheet.md?plain=1#L830) — line 830.
- [Builder — construct step by step](architecture-patterns-cheat-sheet.md?plain=1#L847) — line 847.
- [Factory — “don’t new in the client”](architecture-patterns-cheat-sheet.md?plain=1#L867) — line 867.
- [Structural](architecture-patterns-cheat-sheet.md?plain=1#L893) — line 893.
- [Facade — one simple API over many internals - الواجهة (dashboard)](architecture-patterns-cheat-sheet.md?plain=1#L897) — line 897.
- [Behavioral](architecture-patterns-cheat-sheet.md?plain=1#L943) — line 943.
- [Observer — push to many subscribers](architecture-patterns-cheat-sheet.md?plain=1#L947) — line 947.
- [Strategy — swap *how*, keep the same caller](architecture-patterns-cheat-sheet.md?plain=1#L965) — line 965.
- [30-second map](architecture-patterns-cheat-sheet.md?plain=1#L998) — line 998.
- [RabbitMQ Vs Kafka ](architecture-patterns-cheat-sheet.md?plain=1#L1023) — line 1023.
- [Deployment strategies](architecture-patterns-cheat-sheet.md?plain=1#L1029) — line 1029.
- [1) Rolling](architecture-patterns-cheat-sheet.md?plain=1#L1037) — line 1037.
- [2) Blue-Green](architecture-patterns-cheat-sheet.md?plain=1#L1067) — line 1067.
- [3) Canary](architecture-patterns-cheat-sheet.md?plain=1#L1097) — line 1097.
- [4) Recreate](architecture-patterns-cheat-sheet.md?plain=1#L1129) — line 1129.
- [5) Feature flags (release toggles)](architecture-patterns-cheat-sheet.md?plain=1#L1150) — line 1150.
- [6) Shadow / mirroring](architecture-patterns-cheat-sheet.md?plain=1#L1171) — line 1171.
- [Quick comparison](architecture-patterns-cheat-sheet.md?plain=1#L1200) — line 1200.
- [Interview glossary — if they say X, it means Y](architecture-patterns-cheat-sheet.md?plain=1#L1219) — line 1219.

#### H: habiba-interview-prep-cheatsheet.md

- [Habiba — interview prep cheat sheet](habiba-interview-prep-cheatsheet.md?plain=1#L1) — line 1.
- [1. Shield migration — your main story](habiba-interview-prep-cheatsheet.md?plain=1#L9) — line 9.
- [The path (memorize)](habiba-interview-prep-cheatsheet.md?plain=1#L11) — line 11.
- [Interview answer — “How did you migrate?”](habiba-interview-prep-cheatsheet.md?plain=1#L20) — line 20.
- [What changed in each hop](habiba-interview-prep-cheatsheet.md?plain=1#L31) — line 31.
- [“why we moved” to REST client](habiba-interview-prep-cheatsheet.md?plain=1#L48) — line 48.
- [javax → jakarta (story they love)](habiba-interview-prep-cheatsheet.md?plain=1#L55) — line 55.
- [Hibernate 6 quick swaps](habiba-interview-prep-cheatsheet.md?plain=1#L64) — line 64.
- [4. War stories (problems you solved)](habiba-interview-prep-cheatsheet.md?plain=1#L78) — line 78.
- [5. GED migration flow (business + tech)](habiba-interview-prep-cheatsheet.md?plain=1#L98) — line 98.
- [6. Tech dictionary (tool → what it is → when you used it)](habiba-interview-prep-cheatsheet.md?plain=1#L117) — line 117.
- [7. “When to use X vs Y” (lead / architect answers)](habiba-interview-prep-cheatsheet.md?plain=1#L152) — line 152.
- [Kafka vs RabbitMQ](habiba-interview-prep-cheatsheet.md?plain=1#L156) — line 156.
- [Rabbit *can* persist messages. That’s not the same as Kafka’s retained log. Don't say “Rabbit isn’t durable.” Say “Kafka keeps a replayable log; Rabbit is a work queue.”](habiba-interview-prep-cheatsheet.md?plain=1#L188) — line 188.
- [Java 8 vs 17 vs 21](habiba-interview-prep-cheatsheet.md?plain=1#L192) — line 192.
- [Spring Boot 2.3 vs 2.7 vs 3.x](habiba-interview-prep-cheatsheet.md?plain=1#L240) — line 240.
- [Go vs Java (your resume)](habiba-interview-prep-cheatsheet.md?plain=1#L253) — line 253.
- [Go vs Java vs C++ (if asked)](habiba-interview-prep-cheatsheet.md?plain=1#L267) — line 267.
- [REST vs GraphQL](habiba-interview-prep-cheatsheet.md?plain=1#L285) — line 285.
- [2PC vs Saga vs Outbox](habiba-interview-prep-cheatsheet.md?plain=1#L297) — line 297.
- [8. Testing — what to say](habiba-interview-prep-cheatsheet.md?plain=1#L319) — line 319.
- [9. Cloud / delivery (short)](habiba-interview-prep-cheatsheet.md?plain=1#L339) — line 339.
- [10. AI / RAG project (CDP) — refresh](habiba-interview-prep-cheatsheet.md?plain=1#L370) — line 370.
- [11. Go overtime platform — refresh (resume, ~2 years ago)](habiba-interview-prep-cheatsheet.md?plain=1#L438) — line 438.
- [13. Likely interview questions + short answers](habiba-interview-prep-cheatsheet.md?plain=1#L467) — line 467.
- [Migration](habiba-interview-prep-cheatsheet.md?plain=1#L471) — line 471.
- [Architecture](habiba-interview-prep-cheatsheet.md?plain=1#L482) — line 482.
- [Leadership](habiba-interview-prep-cheatsheet.md?plain=1#L493) — line 493.
- [Testing](habiba-interview-prep-cheatsheet.md?plain=1#L501) — line 501.

#### R: project-interview-reference.md

- [Habiba — project interview reference](project-interview-reference.md?plain=1#L1) — line 1.
- [How to use this document](project-interview-reference.md?plain=1#L5) — line 5.
- [Confirmed context from Habiba](project-interview-reference.md?plain=1#L11) — line 11.
- [Project map](project-interview-reference.md?plain=1#L15) — line 15.
- [1. E-commerce CDP: conversational commerce](project-interview-reference.md?plain=1#L24) — line 24.
- [Verified implementation](project-interview-reference.md?plain=1#L26) — line 26.
- [Candidate introduction](project-interview-reference.md?plain=1#L42) — line 42.
- [Technical details worth revising](project-interview-reference.md?plain=1#L48) — line 48.
- [Batch ingestion](project-interview-reference.md?plain=1#L60) — line 60.
- [Sources](project-interview-reference.md?plain=1#L71) — line 71.
- [2. Document RAG and the separate llm experiment](project-interview-reference.md?plain=1#L79) — line 79.
- [Verified implementation: commerce document module](project-interview-reference.md?plain=1#L81) — line 81.
- [Verified implementation: separate llm folder](project-interview-reference.md?plain=1#L89) — line 89.
- [Candidate answer](project-interview-reference.md?plain=1#L95) — line 95.
- [Interview follow-ups](project-interview-reference.md?plain=1#L101) — line 101.
- [Authentication topic](project-interview-reference.md?plain=1#L108) — line 108.
- [Sources](project-interview-reference.md?plain=1#L112) — line 112.
- [3. Concurrency lab: the strongest recovered debugging story](project-interview-reference.md?plain=1#L119) — line 119.
- [History evidence](project-interview-reference.md?plain=1#L121) — line 121.
- [Candidate story](project-interview-reference.md?plain=1#L127) — line 127.
- [Concrete implementation details](project-interview-reference.md?plain=1#L133) — line 133.
- [Questions you should be able to answer](project-interview-reference.md?plain=1#L141) — line 141.
- [Sources](project-interview-reference.md?plain=1#L155) — line 155.
- [4. 3-buddy: learning workspace and Shield knowledge tooling](project-interview-reference.md?plain=1#L161) — line 161.
- [Shield knowledge assistant](project-interview-reference.md?plain=1#L165) — line 165.
- [Other learning topics](project-interview-reference.md?plain=1#L173) — line 173.
- [Candidate answer](project-interview-reference.md?plain=1#L179) — line 179.
- [Sources](project-interview-reference.md?plain=1#L183) — line 183.
- [5. Jira automation: AI parsing with deterministic checks](project-interview-reference.md?plain=1#L191) — line 191.
- [Verified main Node flow](project-interview-reference.md?plain=1#L193) — line 193.
- [Candidate answer](project-interview-reference.md?plain=1#L206) — line 206.
- [Strong follow-up topics](project-interview-reference.md?plain=1#L212) — line 212.
- [Additional value: recovering work history](project-interview-reference.md?plain=1#L222) — line 222.
- [Sources](project-interview-reference.md?plain=1#L235) — line 235.
- [6. GED LDR migration and Overtime: evidence still needed](project-interview-reference.md?plain=1#L242) — line 242.
- [7. Next information to collect](project-interview-reference.md?plain=1#L250) — line 250.

#### README: README.md

- [Study](README.md?plain=1#L1) — line 1.
- [Contents](README.md?plain=1#L5) — line 5.
- [Use](README.md?plain=1#L11) — line 11.

#### G0: Gaps/README.md

- [Interview gaps and recall](Gaps/README.md?plain=1#L1) — line 1.

#### G1: Gaps/Domains/DDD.md

- [Domain-Driven Design (DDD) — domain gap](Gaps/Domains/DDD.md?plain=1#L1) — line 1.
- [Explore gradually](Gaps/Domains/DDD.md?plain=1#L7) — line 7.
- [Interview prompts (one at a time, increasing difficulty)](Gaps/Domains/DDD.md?plain=1#L16) — line 16.

#### G2: Gaps/Domains/Deployment-Strategies.md

- [Deployment strategies — domain gap](Gaps/Domains/Deployment-Strategies.md?plain=1#L1) — line 1.
- [Short prompts (ask one at a time between other subjects)](Gaps/Domains/Deployment-Strategies.md?plain=1#L18) — line 18.

#### G3: Gaps/Terminology/JWT-Parts.md

- [JWT parts and validation terms — terminology gap](Gaps/Terminology/JWT-Parts.md?plain=1#L1) — line 1.
- [Recall status](Gaps/Terminology/JWT-Parts.md?plain=1#L5) — line 5.
- [Tiny recall prompts (ask one at a time, between other topics)](Gaps/Terminology/JWT-Parts.md?plain=1#L14) — line 14.
- [Concept check for later](Gaps/Terminology/JWT-Parts.md?plain=1#L23) — line 23.

#### N: notes.md

This source has no headings. Its complete topic inventory is: String.concat and reassignment; StringBuilder.append and mutation; synchronized StringBuffer methods; interface constants; Java 8 default/static methods; Java 9 private helpers; forbidden protected interface methods; abstraction; abstract classes with zero abstract methods; concrete subclass implementation; runtime instance-method dispatch; static method hiding; return-type-only overloading prohibition; hash functions and bucket indices; collisions; separate chaining; open addressing; linked-list buckets; probing; table crowding; hash table versus HashMap. See [all practice notes](notes.md).

### Java PDF page guide

| Pages | Topics and terminology |
| --- | --- |
| [1–6](java.pdf#page=1) | Table of contents: Java structures, OOP, hardware/memory, exceptions, HTTP, Spring, ORM, testing, concurrency, Maven, security, AOP, versions, records, and SpEL. The full body adds topics not listed in this contents section. |
| [7–10](java.pdf#page=7) | Array/List/Map comparisons; access/insertion/deletion/search costs; dynamic/fixed size; fragmentation; locality; hashing; collision resolution; separate chaining; open addressing; HashMap, TreeMap, LinkedHashMap; red-black tree. |
| [11–13](java.pdf#page=11) | Pre-order, in-order, post-order and level-order/BFS traversal; recursion; collections versus streams; storage, iteration, eager/lazy operations, single use, parallelism; class/object introduction. |
| [14–18](java.pdf#page=14) | OOP principles; transient; Serializable; ObjectInputStream/ObjectOutputStream; Jackson ObjectMapper; Cloneable; clone; static members; interfaces; access modifiers; default methods; final; composition; wrapper versus primitive. |
| [19–20](java.pdf#page=19) | Enums; class versus interface; constructors and constants; early/static versus late/dynamic binding; cache friendliness; cache line; spatial locality. |
| [21–24](java.pdf#page=21) | CPU registers and caches; RAM; SSD/HDD; optical/USB/NAS storage; volatile memory; clock cycle; stack/heap; allocation; references; object-memory diagram. |
| [25–28](java.pdf#page=25) | Exception hierarchy and diagram; catch ordering; checked/unchecked exceptions; throw/throws; multi-catch; rethrow; custom exceptions; finally; resource management; HTTP/API basics; status codes. |
| [29–32](java.pdf#page=29) | Request/response headers; OPTIONS; origins; CORS/preflight and headers; PUT/PATCH/POST and idempotency; REST maturity levels; RPC/POX; resources; HTTP verbs; HATEOAS. |
| [33–35](java.pdf#page=33) | Hypermedia example continuation; IoC; dependency injection; service lookup example; XML application context; Autowired; constructor/field/setter injection; stereotypes; ORM/entity mapping. |
| [36–38](java.pdf#page=36) | Entity/Table/Id/Column/GeneratedValue; IDENTITY/SEQUENCE/TABLE/AUTO; one-to-one/one-to-many/many-to-one/many-to-many; join column/table; JPQL; JPA/provider; JpaRepository; eager/lazy fetching. |
| [39–42](java.pdf#page=39) | Lazy fetching/N+1; Spring versus Boot; JAR/WAR; embedded containers; Actuator; ControllerAdvice; ApplicationContext/BeanFactory; lifecycle; ApplicationContextAware; scopes; filters and interceptors. |
| [43–47](java.pdf#page=43) | Memory leaks; retained references; heap dump; heap histogram and allocation screenshot; thread dump/states/parking screenshot; VisualVM; profiling; GC; heap OOM; PermGen/Metaspace; native memory; Javassist ClassPool; testing introduction. |
| [48–54](java.pdf#page=48) | Mockito mocks/spies/injection/stubbing/verification; JUnit setup/teardown/assertions; TestContext; transactional tests/readOnly; Hamcrest; Rule/RunWith/ExtendWith; reflection; legacy mocking limitations; ArgumentCaptor; parallel programming. |
| [55–56](java.pdf#page=55) | ConcurrentLinkedQueue; CopyOnWriteArrayList; HashMap versus ConcurrentHashMap; concurrent modification; iteration behavior; thread example. |
| [57–62](java.pdf#page=57) | Future/CompletableFuture; get; complete; completeExceptionally; supplyAsync/runAsync; thenApply/thenAccept/thenRun and Async variants; thenCompose/thenCombine/thenAcceptBoth; allOf/anyOf; join; exceptionally/handle; parallel streams. |
| [63–67](java.pdf#page=63) | Files.lines; reduce identity/accumulator; Optional; fork/join; work stealing; common pool; parallelism setting; invalid reduction identity; benchmarks; splitting/merging costs; ArrayList/LinkedList/HashSet/TreeMap; memory locality; primitive versus boxed arrays; NQ model. |
| [68–74](java.pdf#page=68) | Sequential/parallel selection; synchronization; critical sections; method/block monitor; CPU/register/cache/RAM diagrams; per-thread stacks/shared heap; visibility; cache coherence; volatile; write buffers; reordering; mutual exclusion. |
| [75–79](java.pdf#page=75) | Final fields; atomic variables; race/lost update; CAS; get/set/lazySet/compareAndSet/addAndGet/decrementAndGet; locks; ReentrantLock; hold count; fairness; finally unlock; read/write locks; conditions; atomics versus locks. |
| [80–83](java.pdf#page=80) | Hibernate ORM/schema generation; eager/lazy/default fetch types; N+1; SQL joins; batch loading; caching and endpoint-level loading; first-level/session cache; second-level cache; providers; Cacheable/Cache; concurrency strategy; invalidation. |
| [84–87](java.pdf#page=84) | Query cache; QueryHint/QueryHints; query versus entity cache; closed/open/interface/nested/class/record/dynamic projections; proxy; SpEL; Class<T>; entity inheritance introduction. |
| [88–91](java.pdf#page=88) | Inheritance strategies; mapped superclass; table per class; schema diagrams; Version; LocalDate; polymorphic queries/associations; unions; shared mapping; superclass entity versus nonentity. |
| [92–96](java.pdf#page=92) | Single-table and joined inheritance; discriminator column/value/formula; DTYPE; null constraints; schema diagrams; generated joins/unions; shared primary key; data integrity and query cost. |
| [97–100](java.pdf#page=97) | Inheritance strategy choice; Formula/computed SQL; SQL vendor coupling; Maven dependency coordinates/scopes; optional/type/exclusion; POM; remote repository; Maven Central; Artifactory/Nexus. |
| [101–105](java.pdf#page=101) | Super/local repositories; .m2; Resilience4j circuit-breaker artifact example; dependencyManagement; BOM import; parent/aggregator modules; transitive dependency; dependency tree; mediation; exclusions; clean/default/site lifecycles. |
| [106–109](java.pdf#page=106) | Maven phases/goals/plugins; compiler source/target; Surefire discovery; JAR manifest/archive; packaging; Java modules/exports/encapsulation. |
| [110–113](java.pdf#page=110) | Spring Security; authentication/authorization/RBAC; SAML mention; JWT header/payload/signature/claims; refresh rotation/revocation; OAuth roles; consent; authorization code; token exchange; client secret; redirect/state/scope; bearer request. |
| [114–120](java.pdf#page=114) | Browser → SecurityFilter → DispatcherServlet diagram; filter chain; legacy WebSecurityConfigurerAdapter; form login/Basic auth; UserDetailsService; PasswordEncoder; AuthenticationProvider; Crowd; roles/authorities; SimpleGrantedAuthority; AuthenticationManager; URL security. |
| [121–125](java.pdf#page=121) | Security expressions; timing/cache/content-sniffing/clickjacking/XSS/CSRF attacks; iframe; defensive headers; CSRF cookie/header/session flows; same-origin policy; statelessness caveat; Thymeleaf/FreeMarker hidden-token forms. |
| [126–128](java.pdf#page=126) | Encryption/hash/salt vocabulary; bit/block/key; symmetric/public-key cryptography; DES/3DES/AES/Blowfish/RSA/SHA-1/MD5; password-storage caveats; method-security enablement. |
| [129–132](java.pdf#page=129) | Secured/RolesAllowed/PreAuthorize/PostAuthorize; returnObject; self-invocation; thread-bound SecurityContext; PreFilter/PostFilter; filterObject/filterTarget; meta-annotations; Target/Retention; class-level and combined security; Java 8 introduction. |
| [133–136](java.pdf#page=133) | Predicate/Function/Supplier/Consumer; Spring 1/2/3 history; AOP proxy versus AspectJ; weaving; aspect/pointcut/join point; Before/AfterReturning/AfterThrowing/After/Around; ProceedingJoinPoint; varargs. |
| [137–139](java.pdf#page=137) | Varargs continuation; declarative transaction attributes/advice/manager; EnableTransactionManagement; Configuration; Lombok; servlet concurrency; thread pools; hardware/OS resource limits. |
| [140–141](java.pdf#page=140) | Java 8–20 feature table: lambdas, streams, date/time, Nashorn, Jigsaw, JShell, HTTP client, var, AppCDS, Epsilon, TLS 1.3, switch, CDS, Shenandoah, text blocks, NUMA, hidden classes, records, Vector API, FFM, UTF-8, simple web server, Javadoc snippets, virtual threads, structured concurrency, record patterns, LTS. |
| [142–143](java.pdf#page=142) | JDK/JRE/JVM; javac/java/jar/jdb/javadoc; JavaFX mention; record components/constructor/accessors/equals/hashCode/toString; shallow immutability; SpEL introduction. |
| [144–145](java.pdf#page=144) | SpEL regex/operators/selection/projection/method invocation; antMatchers/security rule examples; C++ versus Java: memory, compilation, pointers, inheritance, templates/generics, portability, concurrency. |

### Principal self-assessment: all 33 competencies

The following retains each competency's detailed scope. Repeated awareness choices and form boilerplate are omitted. No rating is inferred.

1. **[Competency 1, page 1](Principal%20-%20Self-Assessment.pdf#page=1)** — Retrieval & Knowledge Integration - Sub-competency: Vector Embeddings & Search – Objective: Can implement vector embedding generation and similarity search systems – Breakdown: Generate embeddings from text or documents using embedding models; Store and index vectors in vector databases; Perform similarity search based on semantic meaning; Understand embedding dimensions and distance metrics; Optimize vector search performance

2. **[Competency 2, page 2](Principal%20-%20Self-Assessment.pdf#page=2)** — Retrieval & Knowledge Integration - Sub-competency: RAG Implementation – Objective: Can implement production-grade RAG systems with measurable retrieval quality improvements – Breakdown: Learning how to use stored data or documents to improve model answers using tools that create and search embeddings.; Understand the concept of RAG and how it grounds model responses in real data; Upload or connect files and content sources for retrieval; Use tools or APIs to generate and store embeddings from text or documents; Search and retrieve relevant information based on meaning (not keywords); Inject retrieved data from vector DB into model prompts for more accurate answers; Keep the database updated when new files are added

3. **[Competency 3, page 2](Principal%20-%20Self-Assessment.pdf#page=2)** — Agents & Orchestration - Sub-competency: Agent Concepts & Theory – Objective: Can understand when and why to use autonomous agents versus direct model calls – Breakdown: Understanding the foundations of AI agents.; Core concepts: agent, goal, action, observation, and context; Difference between stateless prompts and stateful agent loops; Agent autonomy and decision-making; When agents add value vs. when simple prompts suffice; Agent limitations and failure modes

4. **[Competency 4, page 3](Principal%20-%20Self-Assessment.pdf#page=3)** — Design Patterns - Sub-competency: Scalability Patterns – Objective: Can implement patterns to support system scalability – Breakdown: Implement queue-based load leveling; Design caching strategies (cache-aside)

5. **[Competency 5, page 3](Principal%20-%20Self-Assessment.pdf#page=3)** — Design Patterns - Sub-competency: Resilience Patterns – Objective: Can implement patterns to improve system resilience and reliability – Breakdown: Implements retry pattern with exponential backoff; Configure timeout policies

6. **[Competency 6, page 3](Principal%20-%20Self-Assessment.pdf#page=3)** — Architectural Frameworks - Sub-competency: Clean Architecture – Objective: Can design systems using Clean Architecture principles – Breakdown: Structure applications with dependency inversion; Define independent layers (entities, use cases, interfaces); Design for testability and maintainability; Isolate business logic from frameworks; Apply SOLID principles at architecture level; Design for technology independence

7. **[Competency 7, page 4](Principal%20-%20Self-Assessment.pdf#page=4)** — Distributed Systems - Sub-competency: Distributed Systems Basics – Objective: Can implement basic distributed system components – Breakdown: Differentiate between distributed system communication approaches (sync vs async)

8. **[Competency 8, page 4](Principal%20-%20Self-Assessment.pdf#page=4)** — Distributed Systems - Sub-competency: Trade-offs and Challenges – Objective: Can evaluate distributed system trade-offs and design decisions – Breakdown: Analyze latency vs throughput trade-offs; Evaluate consistency vs availability decisions; Balance complexity vs benefits

9. **[Competency 9, page 4](Principal%20-%20Self-Assessment.pdf#page=4)** — Code Design & OOP - Sub-competency: Inversion of Control (IoC) & Dependency Injection – Objective: Can architect systems using IoC principles and DI containers – Breakdown: Design for testability through DI; Understand service locator vs DI

10. **[Competency 10, page 5](Principal%20-%20Self-Assessment.pdf#page=5)** — API & Service Design - Sub-competency: API Design & Versioning – Objective: Can design scalable APIs with proper versioning strategies – Breakdown: Design consistent API contracts; Implement API versioning (URL, header, query); Handle breaking vs non-breaking changes; Design for backward compatibility; Document APIs comprehensively; Apply API design best practices

11. **[Competency 11, page 5](Principal%20-%20Self-Assessment.pdf#page=5)** — Exception Governance - Sub-competency: Advanced Exception Handling – Objective: Can implement sophisticated exception handling strategies – Breakdown: Handle async exceptions correctly; Implement exception policies; Create global exception interceptors; Design custom exception types; Log and track exceptions systematically

12. **[Competency 12, page 5](Principal%20-%20Self-Assessment.pdf#page=5)** — Exception Governance - Sub-competency: Global Exception Handling – Objective: Can implement centralized exception handling across application – Breakdown: Create global exception middleware; Handle exceptions consistently; Return appropriate error responses; Log exceptions centrally; Avoid exception leakage to clients; Map exceptions to HTTP status codes

13. **[Competency 13, page 6](Principal%20-%20Self-Assessment.pdf#page=6)** — Configuration Management - Sub-competency: Environment Configuration – Objective: Can manage application configuration across environments – Breakdown: Use environment variables effectively; Implement feature flags; Use external configuration stores; Manage secrets securely; Support multiple environments (dev, test, prod); Hot-reload configuration changes

14. **[Competency 14, page 6](Principal%20-%20Self-Assessment.pdf#page=6)** — Resilience & Performance - Sub-competency: Background Jobs – Objective: Can implement and manage background job processing – Breakdown: Create hosted services or background workers; Schedule recurring jobs; Handle long-running tasks; Manage job queues; Implement retry logic for failed jobs; Monitor job execution

15. **[Competency 15, page 7](Principal%20-%20Self-Assessment.pdf#page=7)** — Resilience & Performance - Sub-competency: Thread Pools & Worker Threads – Objective: Can optimize application performance using thread pools – Breakdown: Understand thread pool architecture; Configure thread pool settings; Use worker threads effectively; Avoid thread pool starvation; Monitor thread pool metrics; Choose between thread pool and dedicated threads

16. **[Competency 16, page 7](Principal%20-%20Self-Assessment.pdf#page=7)** — Data Access & ORM - Sub-competency: Advanced Querying – Objective: Can write complex database queries including aggregations – Breakdown: Write aggregated queries (SUM, AVG, COUNT, GROUP BY); Use subqueries effectively; Implement complex joins; Optimize query performance; Use query hints when necessary; Understand query execution plans

17. **[Competency 17, page 7](Principal%20-%20Self-Assessment.pdf#page=7)** — Data Access & ORM - Sub-competency: Transaction Management – Objective: Can implement proper transaction handling for data consistency – Breakdown: Use transactions for atomic operations; Understand ACID properties; Implement transaction scopes; Handle distributed transactions; Manage transaction isolation levels; Rollback on failures

18. **[Competency 18, page 8](Principal%20-%20Self-Assessment.pdf#page=8)** — Core Technologies & Infrastructure - Sub-competency: Cloud Storage – Objective: Can implement cloud storage solutions with appropriate blob types and data transfer strategies – Breakdown: Select appropriate storage types (block, append, page blobs); Implement blob storage operations; Configure data archiving policies; Use SDK/tools for data transfer

19. **[Competency 19, page 8](Principal%20-%20Self-Assessment.pdf#page=8)** — Core Technologies & Infrastructure - Sub-competency: Cloud Queue Storage – Objective: Can implement message queuing systems for asynchronous processing – Breakdown: Implement enqueue/dequeue operations; Configure message lifecycle and visibility timeout; Implement polling mechanisms; Handle message expiration; Monitor queue performance and health; Apply queue limitations (message size, retention, throughput)

20. **[Competency 20, page 8](Principal%20-%20Self-Assessment.pdf#page=8)** — Security & Identity Management - Sub-competency: Secrets & Key Management – Objective: Can implement secure secrets and key management for applications – Breakdown: Store and retrieve secrets programmatically; Integrate secrets management into CI/CD

21. **[Competency 21, page 9](Principal%20-%20Self-Assessment.pdf#page=9)** — Monitoring & Management - Sub-competency: Monitoring Tools (Basics) – Objective: Can configure services to send logs and metrics to cloud monitoring platforms – Breakdown: Configure log collection from services; Send metrics to monitoring platforms; Create simple dashboards; Query logs and metrics

22. **[Competency 22, page 9](Principal%20-%20Self-Assessment.pdf#page=9)** — Transactional Integrity & Storage - Sub-competency: Relational Databases & ACID Principles – Objective: Can implement systems with strong transactional guarantees – Breakdown: Apply ACID properties (Atomicity, Consistency, Isolation, Durability); Design transaction boundaries; Choose appropriate isolation levels; Handle concurrency and locking; Prevent deadlocks; Implement optimistic vs pessimistic locking; Design for data consistency

23. **[Competency 23, page 10](Principal%20-%20Self-Assessment.pdf#page=10)** — Database Programming & Objects - Sub-competency: Materialized Views vs Views – Objective: Can evaluate and implement materialized views for performance optimization – Breakdown: Compare views vs materialized views; Design materialized views for complex queries; Configure refresh strategies (immediate, scheduled); Optimize query performance with materialized views

24. **[Competency 24, page 10](Principal%20-%20Self-Assessment.pdf#page=10)** — Indexing, Optimization & Performance - Sub-competency: Execution Plans & Query Analysis – Objective: Can analyze and optimize query performance using execution plans – Breakdown: Read and interpret execution plans; Identify table scans and their impact; Analyze index scans vs index seeks; Identify missing indexes; Optimize join operations; Identify expensive operations (sorts, spools); Use query hints when appropriate; Monitor query performance metrics

25. **[Competency 25, page 10](Principal%20-%20Self-Assessment.pdf#page=10)** — Containerization - Sub-competency: Docker Images & Containers – Objective: Can build Docker images and run containers – Breakdown: Write Dockerfiles; Build Docker images; Run containers from images; Manage container lifecycle (start, stop, remove); Inspect running containers; View container logs; Execute commands in containers; Tag and version images; Push images to registries

26. **[Competency 26, page 11](Principal%20-%20Self-Assessment.pdf#page=11)** — CI/CD - Sub-competency: Build & Release Pipelines – Objective: Can create and manage automated build and release pipelines – Breakdown: Design pipeline workflows; Configure build triggers; Define build steps and tasks; Implement automated testing in pipeline; Configure artifact publishing; Create release pipelines; Implement deployment stages (dev, staging, prod)

27. **[Competency 27, page 11](Principal%20-%20Self-Assessment.pdf#page=11)** — Frontend Frameworks - Sub-competency: Dependency Injection – Objective: Can use dependency injection in frontend frameworks – Breakdown: Understand DI concepts and benefits; Configure injectors and providers; Inject services into components; Implement different injection types; Manage service lifecycle; Apply loose coupling principles; Follow framework DI patterns

28. **[Competency 28, page 11](Principal%20-%20Self-Assessment.pdf#page=11)** — Frontend Frameworks - Sub-competency: Component-Based Architecture – Objective: Can implement component-based architectures – Breakdown: Design reusable components ; Implement component communication (props/events) ; Apply component composition patterns ; Use slots/content projection ; Implement controlled vs uncontrolled components

29. **[Competency 29, page 12](Principal%20-%20Self-Assessment.pdf#page=12)** — JavaScript/TypeScript - Sub-competency: Reactive Programming (RxJS) – Objective: Can implement reactive programming patterns using RxJS – Breakdown: Apply operators for data transformation (map, filter, merge); Manage subscriptions and memory leaks; Handle streams of events; Understand event loop and async behavior; Implement reactive patterns; Debug observable chains

30. **[Competency 30, page 12](Principal%20-%20Self-Assessment.pdf#page=12)** — JavaScript/TypeScript - Sub-competency: Decorators – Objective: Can use decorators for meta-programming in TypeScript – Breakdown: Understand decorator concepts and syntax; Apply class decorators; Apply method decorators; Apply property decorators; Apply parameter decorators; Create custom decorators; Use framework-specific decorators; Combine multiple decorators

31. **[Competency 31, page 13](Principal%20-%20Self-Assessment.pdf#page=13)** — Authorization - Sub-competency: OAuth Interactive Flows – Objective: Can implement OAuth interactive authentication flows – Breakdown: Implement Authorization Code Flow; Implement PKCE for mobile/SPA apps; Implement Device Code Flow; Handle OAuth callbacks; Store and refresh access tokens; Implement OAuth error handling

32. **[Competency 32, page 13](Principal%20-%20Self-Assessment.pdf#page=13)** — Cloud Security - Sub-competency: Secrets & Key Management Objective: Can implement secure secrets and key management – Breakdown: Create and store secrets in key vaults; Retrieve secrets programmatically; Set secret expiration dates

33. **[Competency 33, page 13](Principal%20-%20Self-Assessment.pdf#page=13)** — AI Security - Sub-competency: RAG Data Access Controls – Objective: Can implement access controls for RAG document retrieval – Breakdown: Design document-level access policies; Implement user-based document filtering; Configure role-based document access; Implement metadata-based access control; Filter retrieval results by permissions; Audit document access attempts; Handle unauthorized document access; Test RAG access control enforcement

### Annotation lookup

Names below were found in the source text or code. Links point to the first occurrence in each source, including correction tables. This is a lookup, not a statement that an annotation is current. `@Before` and `@After`, for example, have different meanings in JUnit and AspectJ. `@Autowire`, `@DiscriminatorFormular`, and the sample `@IsViewer` are retained as source spellings/examples.

| Annotation | Source locations |
| --- | --- |
| `@After` | [P p. 49](java.pdf#page=49) |
| `@AfterReturning` | [P p. 135](java.pdf#page=135) |
| `@AfterThrowing` | [P p. 135](java.pdf#page=135) |
| `@Around` | [P p. 136](java.pdf#page=136) |
| `@Aspect` | [P p. 135](java.pdf#page=135) |
| `@Autowire` | [P p. 3](java.pdf#page=3) |
| `@Autowired` | [J L542](java-spring-cheatsheet.md?plain=1#L542), [P p. 3](java.pdf#page=3) |
| `@BatchSize` | [J L861](java-spring-cheatsheet.md?plain=1#L861) |
| `@Bean` | [J L631](java-spring-cheatsheet.md?plain=1#L631), [P p. 117](java.pdf#page=117) |
| `@Beans` | [P p. 116](java.pdf#page=116) |
| `@Before` | [H L329](habiba-interview-prep-cheatsheet.md?plain=1#L329), [P p. 48](java.pdf#page=48) |
| `@BeforeEach` | [H L329](habiba-interview-prep-cheatsheet.md?plain=1#L329) |
| `@Builder` | [A L854](architecture-patterns-cheat-sheet.md?plain=1#L854) |
| `@Cache` | [J L877](java-spring-cheatsheet.md?plain=1#L877), [P p. 83](java.pdf#page=83) |
| `@Cacheable` | [J L19](java-spring-cheatsheet.md?plain=1#L19), [P p. 83](java.pdf#page=83) |
| `@Column` | [P p. 36](java.pdf#page=36) |
| `@Component` | [J L595](java-spring-cheatsheet.md?plain=1#L595), [A L825](architecture-patterns-cheat-sheet.md?plain=1#L825), [P p. 3](java.pdf#page=3) |
| `@ComponentScan` | [J L751](java-spring-cheatsheet.md?plain=1#L751) |
| `@ConcurrencyLimit` | [J L1643](java-spring-cheatsheet.md?plain=1#L1643) |
| `@Conditional` | [J L644](java-spring-cheatsheet.md?plain=1#L644) |
| `@ConditionalOnClass` | [J L646](java-spring-cheatsheet.md?plain=1#L646) |
| `@ConditionalOnMissingBean` | [J L646](java-spring-cheatsheet.md?plain=1#L646) |
| `@ConditionalOnProperty` | [J L646](java-spring-cheatsheet.md?plain=1#L646) |
| `@Configuration` | [J L630](java-spring-cheatsheet.md?plain=1#L630), [P p. 6](java.pdf#page=6) |
| `@ConfigurationProperties` | [J L1563](java-spring-cheatsheet.md?plain=1#L1563) |
| `@ConstructorBinding` | [J L1563](java-spring-cheatsheet.md?plain=1#L1563) |
| `@ContextConfiguration` | [J L1246](java-spring-cheatsheet.md?plain=1#L1246), [P p. 50](java.pdf#page=50) |
| `@Controller` | [J L608](java-spring-cheatsheet.md?plain=1#L608) |
| `@ControllerAdvice` | [J L21](java-spring-cheatsheet.md?plain=1#L21), [P p. 40](java.pdf#page=40) |
| `@Controllers` | [P p. 114](java.pdf#page=114) |
| `@Data` | [P p. 83](java.pdf#page=83) |
| `@DataJpaTest` | [J L1257](java-spring-cheatsheet.md?plain=1#L1257) |
| `@DiscriminatorColumn` | [J L966](java-spring-cheatsheet.md?plain=1#L966), [P p. 92](java.pdf#page=92) |
| `@DiscriminatorFormular` | [P p. 92](java.pdf#page=92) |
| `@DiscriminatorValue` | [P p. 93](java.pdf#page=93) |
| `@EnableAutoConfiguration` | [J L751](java-spring-cheatsheet.md?plain=1#L751) |
| `@EnableGlobalMethodSecurity` | [J L25](java-spring-cheatsheet.md?plain=1#L25), [P p. 128](java.pdf#page=128) |
| `@EnableJpaRepositories` | [J L803](java-spring-cheatsheet.md?plain=1#L803) |
| `@EnableMethodSecurity` | [J L25](java-spring-cheatsheet.md?plain=1#L25) |
| `@EnableTransactionManagement` | [P p. 138](java.pdf#page=138) |
| `@EnableWebSecurity` | [J L1004](java-spring-cheatsheet.md?plain=1#L1004), [P p. 115](java.pdf#page=115) |
| `@Entity` | [J L888](java-spring-cheatsheet.md?plain=1#L888), [P p. 35](java.pdf#page=35) |
| `@EntityGraph` | [J L861](java-spring-cheatsheet.md?plain=1#L861) |
| `@Enumerated` | [J L1552](java-spring-cheatsheet.md?plain=1#L1552) |
| `@ExceptionHandler` | [J L620](java-spring-cheatsheet.md?plain=1#L620), [P p. 40](java.pdf#page=40) |
| `@ExtendWith` | [J L1221](java-spring-cheatsheet.md?plain=1#L1221), [H L328](habiba-interview-prep-cheatsheet.md?plain=1#L328), [P p. 4](java.pdf#page=4) |
| `@Formula` | [J L20](java-spring-cheatsheet.md?plain=1#L20), [P p. 97](java.pdf#page=97) |
| `@GeneratedValue` | [J L1553](java-spring-cheatsheet.md?plain=1#L1553), [H L69](habiba-interview-prep-cheatsheet.md?plain=1#L69), [P p. 35](java.pdf#page=35) |
| `@GenericGenerator` | [H L69](habiba-interview-prep-cheatsheet.md?plain=1#L69) |
| `@GetExchange` | [H L43](habiba-interview-prep-cheatsheet.md?plain=1#L43) |
| `@GetMapping` | [J L731](java-spring-cheatsheet.md?plain=1#L731), [P p. 128](java.pdf#page=128) |
| `@HttpExchange` | [J L1643](java-spring-cheatsheet.md?plain=1#L1643) |
| `@Id` | [J L1510](java-spring-cheatsheet.md?plain=1#L1510), [P p. 35](java.pdf#page=35) |
| `@Inheritance` | [P p. 90](java.pdf#page=90) |
| `@InitBinder` | [J L621](java-spring-cheatsheet.md?plain=1#L621) |
| `@InjectMocks` | [J L1186](java-spring-cheatsheet.md?plain=1#L1186), [P p. 4](java.pdf#page=4) |
| `@IsViewer` | [P p. 131](java.pdf#page=131) |
| `@JdbcTypeCode` | [H L40](habiba-interview-prep-cheatsheet.md?plain=1#L40) |
| `@JoinColumn` | [J L814](java-spring-cheatsheet.md?plain=1#L814), [P p. 36](java.pdf#page=36) |
| `@JoinTable` | [J L823](java-spring-cheatsheet.md?plain=1#L823), [P p. 37](java.pdf#page=37) |
| `@JsonFormat` | [J L1445](java-spring-cheatsheet.md?plain=1#L1445) |
| `@JsonIgnore` | [J L1445](java-spring-cheatsheet.md?plain=1#L1445) |
| `@JsonInclude` | [J L1445](java-spring-cheatsheet.md?plain=1#L1445) |
| `@JsonProperty` | [J L1445](java-spring-cheatsheet.md?plain=1#L1445) |
| `@JsonTest` | [J L1260](java-spring-cheatsheet.md?plain=1#L1260) |
| `@ManyToMany` | [J L822](java-spring-cheatsheet.md?plain=1#L822), [P p. 37](java.pdf#page=37) |
| `@ManyToOne` | [J L813](java-spring-cheatsheet.md?plain=1#L813), [P p. 36](java.pdf#page=36) |
| `@MappedSuperclass` | [J L952](java-spring-cheatsheet.md?plain=1#L952), [P p. 88](java.pdf#page=88) |
| `@Mock` | [J L1179](java-spring-cheatsheet.md?plain=1#L1179), [H L333](habiba-interview-prep-cheatsheet.md?plain=1#L333), [P p. 4](java.pdf#page=4) |
| `@MockBean` | [J L24](java-spring-cheatsheet.md?plain=1#L24), [P p. 50](java.pdf#page=50) |
| `@Mocked` | [H L333](habiba-interview-prep-cheatsheet.md?plain=1#L333) |
| `@MockitoBean` | [J L24](java-spring-cheatsheet.md?plain=1#L24) |
| `@MockitoSpyBean` | [J L24](java-spring-cheatsheet.md?plain=1#L24) |
| `@ModelAttribute` | [J L621](java-spring-cheatsheet.md?plain=1#L621) |
| `@NotNull` | [J L1512](java-spring-cheatsheet.md?plain=1#L1512) |
| `@OneToMany` | [J L818](java-spring-cheatsheet.md?plain=1#L818), [P p. 36](java.pdf#page=36) |
| `@OneToOne` | [J L855](java-spring-cheatsheet.md?plain=1#L855), [P p. 36](java.pdf#page=36) |
| `@Override` | [P p. 16](java.pdf#page=16) |
| `@PathVariable` | [J L727](java-spring-cheatsheet.md?plain=1#L727) |
| `@Pointcut` | [P p. 135](java.pdf#page=135) |
| `@PostAuthorize` | [J L1122](java-spring-cheatsheet.md?plain=1#L1122), [P p. 128](java.pdf#page=128) |
| `@PostConstruct` | [J L577](java-spring-cheatsheet.md?plain=1#L577), [P p. 41](java.pdf#page=41) |
| `@PostFilter` | [J L1163](java-spring-cheatsheet.md?plain=1#L1163), [P p. 6](java.pdf#page=6) |
| `@PostMapping` | [A L915](architecture-patterns-cheat-sheet.md?plain=1#L915) |
| `@PreAuthorize` | [J L650](java-spring-cheatsheet.md?plain=1#L650), [P p. 6](java.pdf#page=6) |
| `@PreDestroy` | [J L579](java-spring-cheatsheet.md?plain=1#L579), [P p. 41](java.pdf#page=41) |
| `@PreFilter` | [J L1153](java-spring-cheatsheet.md?plain=1#L1153), [P p. 6](java.pdf#page=6) |
| `@Primary` | [J L556](java-spring-cheatsheet.md?plain=1#L556) |
| `@Profile` | [J L640](java-spring-cheatsheet.md?plain=1#L640) |
| `@Qualifier` | [J L556](java-spring-cheatsheet.md?plain=1#L556) |
| `@Query` | [J L650](java-spring-cheatsheet.md?plain=1#L650) |
| `@QueryHint` | [P p. 84](java.pdf#page=84) |
| `@QueryHints` | [P p. 84](java.pdf#page=84) |
| `@Repository` | [J L603](java-spring-cheatsheet.md?plain=1#L603), [P p. 3](java.pdf#page=3) |
| `@RequestBody` | [J L735](java-spring-cheatsheet.md?plain=1#L735), [A L916](architecture-patterns-cheat-sheet.md?plain=1#L916), [P p. 133](java.pdf#page=133) |
| `@RequestParam` | [J L735](java-spring-cheatsheet.md?plain=1#L735) |
| `@ResponseBody` | [J L610](java-spring-cheatsheet.md?plain=1#L610), [P p. 133](java.pdf#page=133) |
| `@RestClientTest` | [J L1260](java-spring-cheatsheet.md?plain=1#L1260) |
| `@RestController` | [J L612](java-spring-cheatsheet.md?plain=1#L612), [A L912](architecture-patterns-cheat-sheet.md?plain=1#L912), [P p. 128](java.pdf#page=128) |
| `@RestControllerAdvice` | [J L21](java-spring-cheatsheet.md?plain=1#L21) |
| `@RestControllers` | [P p. 114](java.pdf#page=114) |
| `@Retention` | [P p. 131](java.pdf#page=131) |
| `@Retryable` | [J L1643](java-spring-cheatsheet.md?plain=1#L1643) |
| `@RolesAllowed` | [J L1124](java-spring-cheatsheet.md?plain=1#L1124), [P p. 6](java.pdf#page=6) |
| `@Rule` | [J L1226](java-spring-cheatsheet.md?plain=1#L1226), [P p. 4](java.pdf#page=4) |
| `@RunWith` | [J L1216](java-spring-cheatsheet.md?plain=1#L1216), [H L328](habiba-interview-prep-cheatsheet.md?plain=1#L328), [P p. 4](java.pdf#page=4) |
| `@Secured` | [J L1123](java-spring-cheatsheet.md?plain=1#L1123), [P p. 6](java.pdf#page=6) |
| `@Service` | [J L599](java-spring-cheatsheet.md?plain=1#L599), [A L972](architecture-patterns-cheat-sheet.md?plain=1#L972), [P p. 3](java.pdf#page=3) |
| `@SpringBootApplication` | [J L750](java-spring-cheatsheet.md?plain=1#L750) |
| `@SpringBootTest` | [J L1235](java-spring-cheatsheet.md?plain=1#L1235) |
| `@Spy` | [J L1182](java-spring-cheatsheet.md?plain=1#L1182), [P p. 4](java.pdf#page=4) |
| `@SpyBean` | [J L1254](java-spring-cheatsheet.md?plain=1#L1254) |
| `@Table` | [P p. 36](java.pdf#page=36) |
| `@Target` | [P p. 131](java.pdf#page=131) |
| `@Test` | [H L330](habiba-interview-prep-cheatsheet.md?plain=1#L330), [P p. 48](java.pdf#page=48) |
| `@Transactional` | [J L664](java-spring-cheatsheet.md?plain=1#L664), [A L465](architecture-patterns-cheat-sheet.md?plain=1#L465), [R L58](project-interview-reference.md?plain=1#L58), [P p. 50](java.pdf#page=50) |
| `@TypeDef` | [H L40](habiba-interview-prep-cheatsheet.md?plain=1#L40) |
| `@Valid` | [J L1512](java-spring-cheatsheet.md?plain=1#L1512) |
| `@Value` | [J L636](java-spring-cheatsheet.md?plain=1#L636), [P p. 86](java.pdf#page=86) |
| `@Version` | [P p. 89](java.pdf#page=89) |
| `@WebMvcTest` | [J L1260](java-spring-cheatsheet.md?plain=1#L1260) |

### Coverage record

- Reviewed nine substantive Markdown study files, both PDFs (159 pages), both README files, and the separate chat handoff.
- Preserved all 564 real Markdown headings across J/F/A/H/R/README/G0/G1/G2/G3 in the source inventory; headings inside fenced examples were excluded.
- Indexed every page of the Java PDF with a contiguous page guide and all 33 principal competency prompts.
- Included 121 distinct source annotation spellings in the annotation lookup.
- Reviewed all 14 embedded images in the Java PDF, including the broken-image placeholder; the principal PDF's only embedded image is its Microsoft 365 logo.
- Grouped conceptual duplicates in the main index; retained legacy spellings, comparisons, and source locations for recall and lookup.
- A subsequent terminology audit added 125 explicit API, configuration, acronym, and syntax entries with source locations; source-heading counts alone were not treated as proof of term-level completeness.
- This is an inventory of the supplied material, not a claim that it contains every possible Java interview topic or that all source explanations have been fact-checked.
