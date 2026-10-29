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
