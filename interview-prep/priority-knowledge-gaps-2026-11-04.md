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
