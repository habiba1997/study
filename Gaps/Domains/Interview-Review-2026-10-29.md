# Review by topic — 29 October 2026
Status: assess answers separately from confidence. Explanations below are taught, not mastered. Continue across all 52 topics; prioritize Java versions, Spring Boot/beans/DI/lifecycle, OOP and Procore backend/system design alongside retests.

## Observed answers
- Q25 Adapter: correct intended mechanism (wrapper with legacy client field), but unsure between Adapter/Proxy. Target wrapper implements NotificationSender; adapts send to legacy deliver. Composition preferred here; inheritance not synonymous with Strategy.
- Q26 LinkedHashSet: correct. HashSet/LinkedHashSet/TreeSet ordering stated correctly; TreeSet remains new and needs recall.
- Q27 replication lag: identified eventually copying primary writes to read replicas correctly; CAP availability/consistency labels confused. P = partition tolerance. Stale successful read is not unavailability; asynchronous replication is not automatically CQRS. Read-your-writes via primary for affected reads; cost is primary load.
- Q28 B: correct with explicit doubt. Syntax explanation requested; do not infer comparator mastery.
- Q29 worker/project/role/junction model valid. UNIQUE(worker_id, role_id, project_id) wrong for exactly one role per worker/project: must UNIQUE(worker_id, project_id); triple permits conflicting roles.
- Q30 optimistic locking name correct; concept not understood, user openly stated gap.
- Q31 transactional outbox: strong correct explanation including atomic task/outbox transaction, publisher retry and consumer dedup. Clarify relay starts after commit, not dependent on successful HTTP response; broker-success/mark-sent crash creates duplicates. Consumer dedup marker and business update same transaction, unique event ID, commit DB before Kafka offset. Database dedup alone does not make external email exactly once.
- Q32 B: correct; exact interface AutoCloseable (not AutoClose).

## Streams/comparators
n inputs, k survivors. Sequential filter O(n), map O(k), comparison sort O(k log k), assuming constant predicate/map/comparison. Total O(n + k log k), worst O(n log n), sorting O(k) buffering. Expensive contains/DB mappings/string compares add their costs. Lazy pipeline needs terminal operation. min O(k), full filtered scan O(n).
Comparator.comparingInt(Worker::getCost).thenComparing(Worker::getEmail) is equivalent:
(a,b) -> { int c = Integer.compare(a.getCost(),b.getCost()); return c != 0 ? c : a.getEmail().compareTo(b.getEmail()); }
Assume non-null workers/emails. No subtraction overflow.

## Concurrency and transaction boundaries
A database transaction starts BEGIN, ends COMMIT/ROLLBACK. Form GET transaction ends; human edits outside it; later PUT is a new transaction. Isolation cannot infer the old browser version.
synchronized serializes code using same monitor in one JVM, not pods; can protect same-instance read/modify/write when entire operation inside lock, but serialized stale assignments still overwrite.
volatile visibility/ordering, not compound atomicity or database isolation.
Optimistic locking = conditional update WHERE id AND expected version; increment version; zero rows means no match (stale/deleted, interpret API context). Client carries version read originally. HTTP If-Match may yield 412; version conflict commonly 409.
SELECT ... FOR UPDATE = pessimistic row lock held to transaction end, across app instances; plain SELECT generally does not lock row against changes in PG.
Q24 atomic UPDATE projects SET last_task_number=last_task_number+1 RETURNING... operates on current DB value, row locking at Read Committed coordinates writers. Allocate + insert task in one transaction, UNIQUE(project_id,task_number). Higher isolation can abort conflicts and require retry. Q20 stale assignment and Q24 atomic increment differ even when writes serialized.
Isolation (PG16): Read Uncommitted acts Read Committed; RC statement snapshot, RR stable transaction snapshot and may abort conflicting updates, Serializable prevents serialization anomalies among committed transactions and may abort/retry. Plain RR SELECT doesn't block writers. Transaction boundaries matter.
Dirty read: another transaction's uncommitted data. Nonrepeatable read: same row reread changed after other commit. Phantom: query's matching set changed. PostgreSQL RR prevents phantoms although standard allows them.

## S3 direct multipart upload
Presigned URL = time-limited signed permission to specific S3 operation; browser gets capability, not AWS secret. Treat as bearer URL.
Postman multipart/form-data (one HTTP body with multiple fields) differs from S3 multipart (many UploadPart requests + completion).
Frontend POST /uploads metadata; backend authorizes, chooses object key, CreateMultipartUpload. Return application upload session + part size. Frontend asks backend for signed part URLs and slices File into parts; PUT raw part bytes direct to S3; save part ETags; POST completion metadata to backend; backend verifies ownership/session, completes on S3 then records ready. CORS allows origin/method/ETag. Retrying failed part doesn't resend all file; abort abandoned sessions/lifecycle cleanup.
Backend carries small metadata only, not forwarded chunks. Bandwidth=data transfer capacity, memory=buffers in RAM; streaming proxy can bound RAM but still carries inbound/outbound bytes.

## Concrete keyset example
Project7, timestamps UTC 2026-10-29 10:20:00 through10:01:00, IDs120 through101 respectively. First LIMIT10 ORDER BY created_at DESC,id DESC =>120..111 (last10:11,id111).
New id121 at10:21 arrives. OFFSET10 LIMIT10 now returns111..102, repeating111.
Keyset second page WHERE project_id=7 AND (created_at,id)<('2026-10-29 10:11:00+00',111) ORDER BY created_at DESC,id DESC LIMIT10 =>110..101.
Tuple compares date first; same date then id. Index(project_id,created_at DESC,id DESC) helps access but doesn't fix offset row shifting; explicit ORDER BY still required. Stable non-null keys assumed; keyset is not full snapshot and arbitrary page jumps less convenient.

## Messaging dictionary
Kafka producer writes records to topic; topic partitioned retained log; partition ordered log, offset position within partition, broker server; consumer reads; consumer group divides partitions (standard consumer group protocol), independent groups each read topic; committed offset is resume position, not DB commit; retention not deletion on consumption. No total topic-wide order across partitions.
RabbitMQ producer publishes to exchange; exchange routes via bindings/routing keys into queues; consumer reads queue; topic exchange = routing-key-pattern type, not Kafka topic. ack consumer completion vs publisher confirm broker acceptance.
CAP = Consistency, Availability, Partition tolerance; partition means network disruption between nodes. Tradeoff during partition, not generic choose any two. CQRS=Command Query Responsibility Segregation; separate read/write models, not merely replica routing.

## Sources
- https://www.postgresql.org/docs/16/transaction-iso.html
- https://www.postgresql.org/docs/current/queries-limit.html
- https://docs.aws.amazon.com/AmazonS3/latest/userguide/mpuoverview.html
- https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-presigned-url.html
- https://kafka.apache.org/intro/
