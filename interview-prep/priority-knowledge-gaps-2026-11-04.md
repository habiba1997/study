# Interview Knowledge Gaps — November 4, 2026

Do not mark a topic mastered after one correct MCQ. Retest using scenarios and follow-ups. Track accuracy and confidence separately.

## High priority: Index internals
- B-tree root, internal and leaf pages; search path, page splits, maintenance.
- Index scan vs sequential scan, PostgreSQL heap access and MVCC visibility.
- Composite indexes: column order, selectivity, range predicates, sorting.
- Covering indexes, INCLUDE columns, index-only scans, visibility map.
- EXPLAIN ANALYZE and BUFFERS, bitmap scans, planner tradeoffs.
- Write overhead, storage, redundant indexes.

## Transactions and isolation
- Dirty, non-repeatable and phantom reads, lost updates, write skew.
- READ UNCOMMITTED, READ COMMITTED, REPEATABLE READ, SERIALIZABLE and PostgreSQL specifics.
- Spring @Transactional propagation, rollback, self-invocation.
- Optimistic/pessimistic locking, deadlocks, concurrency across pods.

## SQL
- JOIN, GROUP BY/HAVING, COUNT with LEFT JOIN, window functions.
- Query plans, pagination, N+1, constraints, inventory reservation.

## CQRS
- Command Query Responsibility Segregation, separate read/write models.
- Materialized projections, replay, stale reads, eventual consistency.
- Compare CQRS with API composition, event sourcing, Saga, outbox.

## Concurrency
- Race conditions, atomicity, visibility, volatile, synchronized, CAS, AtomicInteger.
- JVM-local versus distributed locking, duplicate RabbitMQ deliveries.

## Other misconceptions
- Authentication verifies identity; authorization checks permissions.
- StringBuilder and StringBuffer are mutable; StringBuffer methods are synchronized.

## Additional terminology gaps — November 4 follow-up

Use short-answer terminology recall plus real production scenarios. Record Sure / Unsure / Guessing separately from correctness.

- CDC (Change Data Capture): transaction log, Debezium, polling versus CDC outbox.
- Publisher confirms: how a producer knows a broker accepted a message.
- Concurrent outbox claiming across pods: FOR UPDATE SKIP LOCKED, leases, locking, duplicate publication.
- Outbox retry and crash window: publish succeeds, marking published fails, duplicate delivery.
- Consumer deduplication and idempotency: event ID unique constraint, atomic business write plus processed marker.
- DLQ (dead-letter queue): poison messages, invalid payload/schema, retries exhausted, downstream outages; diagnosis and replay.
- Exponential backoff and jitter: when and why retries are delayed.
- Circuit breaker in Spring Boot: Resilience4j states, failure thresholds, fallbacks.
- Bulkhead: thread-pool or semaphore isolation and resource exhaustion.
- Backpressure: RabbitMQ prefetch, queues, producer throttling.
- Primary versus master terminology: same conventional writable database role; confirm distinction and replication architecture.
- Replication lag and read-your-writes: route consistency-sensitive reads to primary.
- Delivery guarantees: at-most-once, at-least-once, exactly-once effect; distinguish broker acceptance from actual recipient delivery.
- System design constraints: throughput, cost, reliability, infrastructure, privacy, latency, not merely field constraints.
- p99 latency, throughput and recovery time: practical interpretation in scenarios.

## Exam scope preference

Deprioritize acronym memorization for SLO, RPO and RTO. Focus on day-to-day developer terminology and practical system-design decisions. Do not create the next exam until explicitly requested.

## Future interactive interview format
- One question at a time; user answers in one word, two words, or at most one sentence.
- Scenario-based choice of Kafka versus RabbitMQ; explain why the selected broker fits the use case.
- Scenario-based selection of Saga, transactional outbox, CDC, CQRS, and database-per-service patterns.
- High-priority terminology: idempotent consumer — processing duplicate deliveries without duplicating the business effect; test event-ID deduplication and transaction/unique-constraint design.
- Ask for Sure / Unsure / Guessing with every answer; grade accuracy and confidence separately, then follow up on weak concepts.
- Do not begin until user explicitly requests the exam.

## Streams, WAL and design-pattern practice — November 4
Explicit recall gaps: intermediate operation, terminal operation, min O(n) versus sorted O(n log n), WAL (Write-Ahead Log). Repeat vocabulary every 2–3 study sessions. No automatic exam or schedule created.

Source inspected: design.md lists the first 18 patterns below and explains Observer/Strategy. Five creational patterns below supplement that document; do not claim they were verified in Design Patterns.pdf, which was not read.
Coverage: Strategy, Adapter, Proxy and Template Method discussed in visible conversation; Adapter answer previously attempted. Factory scenario sent but not proof answered. Other patterns have no confirmed assessment in the inspected records; this does not prove never asked anywhere. Queue all for assessment/retest without diagnosing ignorance from lack of assessment.

Implementation descriptions are typical, not exclusive requirements. Java implements-interface polymorphism is distinct from inheriting implementation via extends. Here composition is used broadly for has-a/delegation, not strict UML lifetime ownership.

| Pattern | Purpose | Typical mechanism |
|---|---|---|
|Strategy|Swap algorithms, e.g. hourly/fixed pricing|Composition: context holds a strategy|
|Observer|Notify subscribed listeners|Object references: publisher holds listeners|
|Command|Represent an action as an object|Composition: invoker holds command; command often holds receiver|
|Iterator|Traverse without exposing collection internals|Object references: iterator tracks collection and position|
|State|Change behavior with current state|Composition: context holds state|
|Chain of Responsibility|Pass a request through handlers|Composition: handlers reference next handler|
|Interpreter|Evaluate a small language|Composition: expression objects form a tree|
|Mediator|Coordinate cooperating objects|Object references through a mediator|
|Memento|Save/restore an object's state|Composition: stores snapshot objects|
|Template Method|Fixed workflow with customizable steps|Inheritance: subclasses override steps|
|Visitor|Add operations across element types|Interface polymorphism and double dispatch; not primarily class inheritance|
|Adapter|Translate an incompatible interface|Usually composition; class-adapter variant uses inheritance|
|Bridge|Vary abstraction and implementation independently|Composition between two type hierarchies|
|Composite|Treat single items and groups uniformly|Composition tree plus common interface|
|Decorator|Add behavior by wrapping an object|Composition plus same interface|
|Facade|Offer a simple interface to a subsystem|Delegation to subsystem objects|
|Flyweight|Share reusable immutable state|Shared object references|
|Proxy|Control access through the same interface|Composition/delegation to target|
|Factory Method|Let subclasses choose which product to create|Classic form uses inheritance|
|Abstract Factory|Create compatible families of objects|Client holds/receives factory; interface polymorphism|
|Builder|Construct complex objects step by step|Usually composition; inheritance optional|
|Prototype|Create objects by copying existing objects|Copying; neither mechanism defines it|
|Singleton|Control access to one instance|Neither composition nor inheritance defines it|

Practice: first explain each pattern with a small Java scenario; later ask one short scenario at a time to identify the pattern, then composition/inheritance role, then tradeoff. Contrast Adapter/Proxy/Decorator, Strategy/State/Template Method, Factory Method/Abstract Factory/Builder, Observer/Mediator. 'Abstract Strategy' is not a separate GoF pattern: clarify Abstract Factory versus a Strategy abstract class. Do not start an exam until explicitly requested.

## Bridge learning preference
- Bridge remains a learning gap: user requests a video explanation plus a concrete worked example before assessment. Use two independent dimensions (report type and renderer), then contrast Bridge with Strategy. Video not yet selected or watched; do not mark understood from prior explanation alone.

## Revised interview scope and question style

Only test these GoF design patterns: Strategy, Adapter, Proxy, Decorator, Facade, Observer, Command, Factory, Abstract Factory, Builder, Prototype, Singleton. Exclude Template Method, Composite, State, and other unrequested patterns from exams.

High-priority terms to know and apply: Saga, Strangler Fig, publisher acknowledgment/publisher confirms, exponential backoff and jitter, backpressure, transactional outbox, cache-aside versus invalidation, Kafka versus RabbitMQ, deployment strategies, database indexes, Spring transactions.

Teach in context, then test by scenario rather than acronym recall: CDC/change data capture, concurrent outbox processing, bulkhead, cache stampede. Clarify publisher confirmation is broker acceptance, not consumer processing. Explain two pods claiming the same outbox event; exponential retry intervals plus random jitter; cache stampede from many simultaneous misses after expiry.

Future design-pattern questions must include concrete Java/business scenario, requirements and tradeoffs; avoid vague one-line clues. Start revision with Strategy, then compare Factory, Abstract Factory, Adapter, Proxy and Decorator. User prefers concise teaching and one short question at a time for revision, not a new full exam unless requested.


## Java numeric types and conversions — added Nov 6, 2026
- HIGH PRIORITY: int vs long (32-bit vs 64-bit), widening int->long automatic, narrowing long->int explicit cast and overflow risk.
- Primitive vs wrappers: int/Integer, long/Long, boxing/unboxing, null-unboxing NPE, Integer cannot directly be assigned to Long; use longValue() or explicit conversion.
- double/float vs BigDecimal; precision, immutable BigDecimal, add() returns a new value, compareTo() vs equals(), converting BigDecimal to primitive with longValueExact()/intValueExact().
- Practice compilation and runtime outcomes of mixed primitive/wrapper conversions, method overloads, numeric literals, and collection generics.
- Java Streams gap: groupingBy, reducing, mapping, sum BigDecimal by customer; contrast with correct HashMap for-loop solution.
- Interview practice Nov 6: correctly proposed one-pass HashMap aggregation of customer order BigDecimal totals; O(n) average time and O(k) space. Confidence not stated; don't infer.
