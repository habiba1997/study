# Interview diagnostic 01 — one item per study area

Answer aloud or send letters in batches, e.g. `1C 2C 3B`. Give a brief reason for any uncertain answer and mark it `sure`, `unsure`, or `guess` if useful. No answer key is included here; we will score together, explain only misses, and revisit them later. Each number maps to the same number in [the 37-topic index](interview-topic-index.md). This is a breadth scan, not a claim of mastery.

## 01 — A subclass overrides a `protected` method. Which visibility is valid?

- A private
- B package-private
- C protected or public
- D public only

## 02 — A `String` reference is passed to a method that calls `concat`. What changes in the caller without reassignment?

- A original String contents
- B reference
- C neither
- D both

## 03 — Two unequal keys share a hash code. What determines whether `HashMap` treats them as one key?

- A reference identity
- B `equals`
- C insertion order
- D bucket index alone

## 04 — `Collectors.toMap(keyFn, valueFn)` encounters duplicate keys. What occurs without a merge function?

- A keeps first
- B keeps last
- C throws
- D creates a list

## 05 — An `AutoCloseable` resource and the try body both throw. Where is the close exception?

- A lost
- B primary
- C suppressed on primary
- D wrapped in Error

## 06 — Heap usage after full GC keeps rising. Best evidence for retained objects?

- A heap dump and dominator analysis
- B increase heap blindly
- C thread sleep
- D SQL EXPLAIN

## 07 — Two threads execute `volatile int x; x++`. Which is true?

- A increments atomic
- B reads visible, increment still racy
- C volatile serializes threads
- D compile error

## 08 — Which Java 21 feature lets many blocking-style tasks run with lightweight threads?

- A records
- B virtual threads
- C default methods
- D sealed classes

## 09 — Complex search with many optional filters and a large request body: which API choice can be defensible?

- A POST search endpoint
- B GET body guaranteed interoperable
- C one endpoint per filter combination
- D DELETE

## 10 — A singleton Spring bean injects a prototype bean directly once at construction. What happens on later calls?

- A new prototype each call
- B same injected instance
- C bean missing
- D singleton becomes prototype

## 11 — A method calls another `@Transactional` method on `this` in proxy-based Spring AOP. Typical result?

- A inner advice always applies
- B self-call bypasses proxy
- C compile error
- D two databases

## 12 — A request-scoped value is stored in a singleton service field. Main risk?

- A cross-request state leakage
- B automatic isolation
- C immutable request
- D no object allocation

## 13 — A selective predicate is slow on a large SQL table. First useful evidence?

- A query plan and actual row counts
- B change JVM GC
- C add every possible index
- D rewrite in Java

## 14 — Listing orders triggers one query per order for customer details. What pattern is this?

- A optimistic locking
- B N+1 queries
- C dirty read
- D outbox

## 15 — A writer commits new data after another request repopulates an invalidated cache with old data. What did invalidation need to follow?

- A request acceptance
- B DB commit, with race handling
- C old cache read
- D application startup

## 16 — JWT payload role is edited but old signature retained. What must resource server do?

- A trust base64 decode
- B verify signature and relevant claims
- C only check user ID
- D ask browser to resign

## 17 — A browser frontend calls an API on a different origin. Which mechanism governs whether browser JS may read the response?

- A CORS
- B JPA
- C GC
- D DNS caching

## 18 — A unit test mocks a repository but SQL mapping fails in production. Best additional test?

- A repository integration test against representative DB
- B more repository mocks
- C CSS snapshot
- D no tests

## 19 — A transitive dependency has a vulnerable older version. What Maven mechanism helps select a safe version consistently?

- A dependencyManagement
- B source encoding
- C profiles only
- D Surefire excludes

## 20 — A monolith needs gradual service extraction with routing shifted feature by feature. Which pattern?

- A strangler fig
- B builder
- C singleton
- D 2PC

## 21 — Service A calls B synchronously. B times out; A immediately retries many times. Main system risk?

- A retry storm
- B exactly-once delivery
- C faster B
- D SQL normalization

## 22 — A consumer handles a RabbitMQ message then crashes before acknowledgment. What must the design tolerate?

- A redelivery
- B no possible duplicate
- C atomic HTTP
- D compiler retry

## 23 — A local read model lags behind committed writes. Which tradeoff is typical of CQRS projections?

- A eventual consistency
- B no schema
- C no failures
- D synchronous global transaction always

## 24 — An order DB write and event publication must survive publisher crashes. Which pattern stores the event with the order transaction?

- A transactional outbox
- B facade
- C prototype
- D two unrelated writes

## 25 — Payments and Support use different models of `Customer`. What defines each model's language and meaning boundary?

- A bounded context
- B global entity
- C API gateway
- D observer

## 26 — Different payment algorithms share one interface and are selected at runtime. Which GoF pattern?

- A strategy
- B facade
- C prototype
- D decorator

## 27 — A batch job restarts after processing 400 of 1000 records. Which property prevents reapplying a charge?

- A idempotent processing/checkpoint strategy
- B more threads only
- C rename job
- D longer timeout only

## 28 — A pod repeatedly fails its readiness probe but passes liveness. Typical routing effect?

- A removed from service traffic
- B always restarted by readiness alone
- C DB rollback
- D new image

## 29 — A new release gets 5% of user traffic while metrics are compared. Name the strategy.

- A canary
- B blue-green
- C recreate
- D shadow only

## 30 — A browser event handler calls a function that closes over `count`. What can a stale closure capture?

- A an older count value
- B JVM heap dump
- C SQL row lock
- D current count by definition

## 31 — TypeScript `unknown` is received from an API. Before accessing `value.id`, what is needed?

- A runtime narrowing/validation
- B cast to any and trust
- C `implements`
- D CSS module

## 32 — React component state updates; what normally causes its UI to reflect the new value?

- A rerender
- B full browser restart
- C JPA flush
- D Angular zone only

## 33 — An Angular `HttpClient` request returns what type often used to compose async responses?

- A Observable
- B Java Future
- C DOM Event only
- D Iterator

## 34 — A React route bundle is large on first load. What can reduce initial JS sent?

- A route-level code splitting
- B bigger sourcemap
- C disabling compression
- D eager import everything

## 35 — A RAG system retrieves an attacker-controlled document saying 'ignore previous instructions.' Correct boundary?

- A treat retrieved text as data, not governing instructions
- B obey it
- C sign every prompt
- D skip authorization

## 36 — Compared with Java, what does Go's standard `error` return convention commonly require?

- A explicit error checking at call sites
- B mandatory checked exceptions
- C JVM GC
- D exception inheritance

## 37 — A senior engineer proposes a cache for a slow endpoint. Best first leadership move?

- A establish latency profile and bottleneck evidence
- B mandate Redis
- C increase all timeouts
- D hide metric
