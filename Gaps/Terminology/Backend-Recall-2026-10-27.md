# Backend recall — 27 October 2026
Status: taught or clarified, not yet independently recalled. Use MCQs interleaved with new discussion topics.
- Sentinel value: special return value representing absence; ambiguous when also valid data. OptionalInt separates presence from integer value.
- HashSet: no iteration order guarantee.
- LinkedHashSet: insertion order.
- TreeSet: sorted order; comparison equality controls duplicates.
- Comparator: external ordering rule; compare(a,b) returns negative/zero/positive.
- Comparable: type's natural ordering via compareTo.
- comparingInt: build comparator from int-valued extraction function.
- thenComparing: tie-break only when earlier comparison returns zero.
- Strategy: interchangeable behavior behind a common interface.
- Branching: conditional paths such as if/else or switch; selection need not disappear entirely.
- Lost update: one writer overwrites another's changes.
- Optimistic locking: check expected version before applying update.
- ETag / If-Match: HTTP representation version and conditional write.
- Read Uncommitted / Read Committed / Repeatable Read / Serializable: isolation levels; learn behavior with examples.
- Dirty read: reading uncommitted data.
- Nonrepeatable read: same row's value changes between reads.
- Phantom read: matching row set changes between queries.
- Presigned URL: time-limited authorization capability for a specific object operation.
- Multipart upload: upload independent parts, then complete assembly.
- Keyset / cursor pagination: continue after last ordering key rather than skip a row count.
- Composite unique constraint: uniqueness of a combination, e.g. project_id + task_number.
- Row-level lock: serialize conflicting updates to a row.
- Connection pool: reusable group of database connections; a connection is not itself a pool.
- Peak traffic / under load: concise phrasing for many concurrent requests.
- Mitigation: immediate impact reduction, distinct from root-cause fix.
- Load testing: exercising system under controlled representative demand.
- Changeset checksum: Liquibase validation fingerprint, not a rollback command.
- Evidence versus hypothesis: state observations and verified mechanisms separately.
Retest prompts live in ../Domains/Interview-Review-2026-10-27.md. Migration story in ../Domains/Migration-Ownership-Story.md.

## 29 October additions and recall status
- Q26 LinkedHashSet correctly recalled; TreeSet sorted order is new, retest.
- Q28 thenComparing when costs equal correctly answered B with doubt; explain syntax before retest.
- Q30 optimistic locking name correct, mechanism still a domain gap.
- Q32 AutoCloseable correctly selected B; retain exact spelling.
- Adapter changes an interface; Proxy controls access through the same interface; composition = has-a, inheritance = is-a.
- Transaction boundary = BEGIN to COMMIT/ROLLBACK; browser think time normally outside it.
- SELECT FOR UPDATE = pessimistic row locking; conditional version-checked UPDATE = optimistic concurrency control; UPDATE ... RETURNING returns modified values.
- Atomic increment vs stale assignment: locks serialize writes but do not know the user's original version.
- CAP = Consistency, Availability, Partition tolerance; CQRS = Command Query Responsibility Segregation.
- Replication lag; stale read; read-your-writes consistency.
- Kafka: producer, consumer, broker, topic, partition, offset, consumer group, committed offset, retention.
- RabbitMQ: exchange, binding, routing key, queue, consumer acknowledgement, publisher confirm, topic exchange.
- Presigned URL; S3 multipart upload; HTTP multipart/form-data (different concepts); bandwidth; buffering.
- Correct English: load testing (not road testing); heavy traffic / peak load; database connection pool (not poor connection).
- Resource scaling: increasing capacity. Mitigation: reduce impact now. Root-cause fix: address underlying cause. More resources are not always safe or a fix.
- Liquibase changeset: tracked database change. Changeset checksum: validation fingerprint, not rollback.
- Concise incident template (adapt only to verified facts): "I investigated connection-pool saturation under peak traffic, coordinated a temporary mitigation, and traced the underlying configuration issue." Do not claim exact forgotten wording or unverified resolution.
Spaced recall: revisit small terms every 2–3 days within existing sessions, mixed with new areas across all 52 topics; particularly Java versions, Spring Boot/beans, OOP. Teach gaps before testing harder variations. Detailed evidence: ../Domains/Interview-Review-2026-10-29.md.

## Inventory concurrency clarification — 29 October
User correctly proposed enforcing sufficient stock in the database regardless of arrival order. Remaining gaps: believes single-statement operations have no transaction; mixes explicit row locking with isolation; believes optimistic checks require Repeatable Read.
- Every SQL statement executes in a transaction. Autocommit gives a single statement its own transaction. Explicit transaction needed to group SELECT FOR UPDATE + subsequent UPDATE, or stock decrement + order insert.
- Atomic conditional decrement: UPDATE inventory SET quantity=quantity-:requested WHERE product_id=:id AND :requested>0 AND quantity>=:requested RETURNING quantity. Validate positive integer quantity. At Read Committed, competing updates wait and re-evaluate condition on updated row; two requests7 and3 against10 can both succeed.7 and4 cannot both succeed.
- SELECT FOR UPDATE locks selected existing rows until commit/rollback; ordinary MVCC reads can proceed, conflicting writers wait. Lock requested in application SQL, enforced centrally by DB across pods. Not a synchronized isolation setting.
- Optimistic locking: expected version predicate works at Read Committed; increment version on success, zero matching rows conflict/missing. Testing old quantity is possible but misses changed-and-restored values (ABA); version preferable. It still takes normal write locks during UPDATE.
- Stale assignment SET quantity=7 from old10 vs relative decrement SET quantity=quantity-3: serializing stale constants still loses changes.
- UPDATE RETURNING returns resulting row values, not a concurrency mechanism by itself.
- Email exams now all MCQ revisiting gaps/terminology; next exam prioritizes these five terms, then indexes and other gaps.

## Streams, design choices and replicas — further 29 October gaps
- Correct mistaken claim: O(n log n) grows FASTER than O(n), not lower. Typical increasing growth: O(1), O(log n), O(n), O(n log n), O(n^2), O(2^n), O(n!). Asymptotic growth, not universal wall-clock ranking.
- Streams lazy: intermediate filter/map/sorted construct pipeline; terminal operations such as collect/forEach/min trigger processing. Short-circuit and optimized operations may avoid traversal; do not promise every lambda runs.
- min(comparator) O(n) vs full comparison sort O(n log n) for minimum-only task; comparator cost assumed constant. Pipeline with k survivors O(n + k log k).
- Composition/inheritance are design mechanisms, not alternative GoF pattern names; scenario MCQs should ask mechanism separately from pattern intent. Four options, exactly one answer, even though the user informally requested five possibilities.
- Composition provides replaceable collaborators, narrower exposed API, easier isolated tests and less coupling to parent internals; inheritance fits true substitutability and designed extension points (e.g. Template Method). No blanket composition always better. Java class extends one superclass; interface implementations may be multiple.
- Partition tolerance: handling network communication failure between distributed nodes; CAP does not imply remaining fully available and strongly consistent simultaneously in a partition. Not table partitioning or Kafka topic partitioning.
- CQRS = Command Query Responsibility Segregation; CQS (Command Query Separation) related but distinct acronym.
- Asynchronous replication: WAL transfer and replay take time; commit need not wait for replica to apply. No universal isUpdating boolean tells application whether its write is visible. Position (LSN) can establish catch-up for a particular write.
- Simple primary stickiness: after commit store per-user/resource primaryUntil; route affected reads primary until deadline. TTL is heuristic, not consistency guarantee; share state across pods or carry trusted token.
- Stronger read-your-writes: obtain a WAL position after commit on primary (covering that commit), require selected replica replay position >= it; use fresh read snapshot after check; bounded wait or primary fallback, don't blindly sleep. Physical topology/failover need handling.
- synchronous_commit=remote_apply with configured synchronous standbys waits for replay by required standbys; not arbitrary replicas. Added latency/availability trade-off.
MCQs should include these basics before harder variations. Explain new terms before evaluating recall.
