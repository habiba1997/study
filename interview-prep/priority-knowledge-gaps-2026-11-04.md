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
