# Habiba — interview prep cheat sheet

Revise this before interviews. Built from your resume, Shield migration work, and repos on Desktop.

**Your headline:** Principal engineer, 5+ years, **Java/Spring Boot modernization**, distributed systems, **test strategy**, mentoring, some full-stack (React/Next.js) and AI prototypes.

---

## 1. Shield migration — your main story

### The path (memorize)

```
8 / Boot 2.3  →  17 / Boot 2.7  →  21 / Boot 3.x
     hop 1              hop 2
```

**Why two hops?** Jumping 8/2.3 → 21/3 in one go = too many breaking changes (Jakarta, Hibernate 6, tests, deps). **2.7** is last 2.x line — safe staging. **21 + Boot 3** = current Shield target. but for small services we can jump that hood normally but for big complicated logic ones its a risk so better migrate step by step for if we would liek to rollback for instance we can at least rollback to a. stable 2.7/java 17. 

### Interview answer — “How did you migrate?”

We treated it as **compatibility engineering**, not feature work:

- **Phase 1 — scan:** blockers checklist (Neo4j, Rabbit test deps, Liquibase empty IDs, Jersey v1, file storage, integration map) — create a risk document with all tools in the service that might be an issue or need extra care, especially when it is a new tool like Quartz (first-time migration).
- **Phase 2 — testing:** on the base/old version we create as many integration tests as we can (if they do not exist) for all branches of the code until we reach at least 80% JaCoCo coverage, and 90% for unit tests. For Dozer migration, if it exists, we try in unit tests specifically to test every mapping possible, because the migration of Dozer to ModelMapper is a bit tricky. Example: Dozer XML mapped nested paths (`credential.productCode` → `productCode`) and skipped nulls; ModelMapper defaults left `productCode` **null** or built an **empty nested object** instead of `null`. HTTP 200 tests still passed. We caught it only by asserting **every mapped field** on a fixture. Fix: explicit `PropertyMap` / converter, same assertions as Dozer. Collections need a `TypeToken` or you get the wrong element type.
- **Phase 3 — uplift:** Java/Spring versions first, then dependency alignment. Parchment has their own artifacts for most of this, and on Spring 3 especially some services: if we are migrating service X now and it needs service Y because they have a **client starter pattern** (also called “internal service client module” / “API client + client-starter module”), then if X depends on Y and Y is on a lower Spring version — especially when migrating to Spring 3 and Y is still 2.3 or 2.7 — we might have a problem. We often do, but not always. So it is better to either change the internal service client module to REST calls. But sometimes service X depends on Y not for the call/client but for logic inside Y; then this causes the failure immediately, and service Y needs to be upgraded first. Then Jakarta + Hibernate + OpenAPI (Swagger) + tracing.
- **Phase 4 — confidence/testing:** JUnit 4/JMockit → JUnit 5/Mockito; run integration tests and make sure they pass — local Docker image build successful and run, and dev deploy.



### What changed in each hop


| Change       | 2.3 → 2.7                                                                                             | 2.7 → 3.x                                                                                                     |
| ------------ | ----------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| Java         | 8 → 17                                                                                                | 17 → 21                                                                                                       |
| Namespace    | still `javax.*` for EE APIs                                                                           | `jakarta.*` **required**                                                                                      |
| API docs     | Swagger2 / Springfox                                                                                  | **Springdoc / OpenAPI 3**                                                                                     |
| Tracing      | Sleuth common                                                                                         | **Micrometer tracing**                                                                                        |
| ORM          | older Hibernate                                                                                       | **Hibernate 6** (`@TypeDef` gone, `@JdbcTypeCode`, UUID strategy)                                             |
| Mapping      | Dozer                                                                                                 | **ModelMapper**                                                                                               |
| Tests        | JUnit 4, JMockit                                                                                      | **JUnit 5, Mockito**                                                                                          |
| HTTP clients | Feign in places - client starter pattern (internal sevrice calls/API Client + client-starter module ) | **RestClient / HTTP interfaces** -> Declarative interface proxy (HttpServiceProxyFactory, @GetExchange, etc.) |


Declarative interface proxy (HttpServiceProxyFactory, @GetExchange, etc.)

#### “why we moved” to REST client

- Feign: to reduce boilerplate compared to REST TEMPLATE and standardize inter-service clients.
- From Feign -> RestClient/HTTP Interface (in newer services): to align with Spring’s latest native stack and reduce dependency on older external client style.



### javax → jakarta (story they love)

- Java EE moved from Oracle → **Eclipse Foundation** → renamed **Jakarta EE**.
- Trademark: new APIs cannot stay in `javax.*` → **Jakarta EE 9** = `jakarta.`*.
- **Spring 6 / Boot 3** built on Jakarta → migration is **required**, not cosmetic.
- **Nuance:** not every `javax` moves. JDK stuff like `javax.sql.`* stays. EE APIs (`persistence`, `validation`, `servlet`, `transaction`) move.

**One line:** “Boot 3 forced a platform shift, not a rename refactor.”

### Hibernate 6 quick swaps


| Old                               | New                                               |
| --------------------------------- | ------------------------------------------------- |
| `@GenericGenerator` + custom UUID | `@GeneratedValue(strategy = GenerationType.UUID)` |
| `@TypeDef` + `JsonBinaryType`     | `@JdbcTypeCode(SqlTypes.JSON)`                    |
| `PostgreSQL94Dialect`             | `PostgreSQLDialect`                               |


---



## 4. War stories (problems you solved)


| Situation                          | Symptom                                                           | Root cause                                             | Fix                                                              | Say this                                                                                   |
| ---------------------------------- | ----------------------------------------------------------------- | ------------------------------------------------------ | ---------------------------------------------------------------- | ------------------------------------------------------------------------------------------ |
| **Connection pool spike** (resume) | Active connections **30–40 → 200+** after migration               | **Transaction manager** misconfig in multi-DB service  | Fixed TM config; pool back to **~35**                            | “I used metrics + pool logs, not guessing. Multi-datasource needs explicit TX boundaries.” |
| **IT connection refused**          | Integration tests fail after uplift                               | Missing/wrong **bootstrap-it** / test container wiring | `bootstrap-it` in test resources; correct spring-cloud-test deps | “I fixed test **context bootstrap**, not assertions.”                                      |
| **JNA / dockerPresenceMarker**     | Context won't start in tests                                      | **Dependency order** — ES transitive conflict          | Reorder deps: embedded ES before conflicting starter             | “Transitive order mattered after upgrade.”                                                 |
| **Duplicate JDBC beans**           | `namedParameterJdbcTemplate` + `dfDataNamedParameterJdbcTemplate` | Two datasources, default bean clash post-upgrade       | `BeanDefinitionRegistryPostProcessor` cleanup                    | “Targeted registry cleanup, behavior unchanged.”                                           |
| **GED migration re-runs**          | Re-processing same learners                                       | Need idempotency                                       | **migration_event** store; skip SUCCESS per jurisdiction         | “Event store + skip list = safe re-runs.”                                                  |


`BeanDefinitionRegistryPostProcessor` **(short):** Spring hook that runs **after bean definitions are loaded, before beans are created**. It can **add / remove / rename definitions** in the registry (not the live objects). Use it when auto-config registers a bean you already defined yourself.

**What the cleanup bean did:** after Boot 3, the app had two `NamedParameterJdbcTemplate` definitions (`namedParameterJdbcTemplate` + `dfDataNamedParameterJdbcTemplate`) — two datasources, default name clash, context would not start. The processor **deleted the extra default definition** so only the intended named bean remained. Same JDBC behavior; startup works.

---



## 5. GED migration flow (business + tech)

**Problem:** Legacy **LDR** data in `learner_records` must become modern **GED credential** documents in the new platform.

**Flow:**

1. Ops calls **POST** on `learner-data-api` with **jurisdiction** (`alphaschoolid`).
2. Load prior **SUCCESS** events → skip already migrated learners/tests.
3. JDBC read LDR → map to **GEDRootModel** / GEDH JSON.
4. Publish to **RabbitMQ** → `assessment-data-api` (same path as live GEDH POST).
5. → `award-workflow-api`: assessment + roster + library — **stop before fulfillment**.
6. Write **SUCCESS/FAILURE** to migration event store.

**Your line:** “Batch migration reuses the **same async pipeline** as production — we didn't fork business logic.”

---



## 6. Tech dictionary (tool → what it is → when you used it)


| Tool                                         | What it is                            | Your context                            |
| -------------------------------------------- | ------------------------------------- | --------------------------------------- |
| **Java / Spring Boot**                       | Main backend stack                    | Microservices modernization             |
| **JUnit 5**                                  | Test framework (Jupiter)              | Replaced JUnit 4                        |
| **Mockito**                                  | Mocking                               | Replaced JMockit                        |
| **WireMock**                                 | HTTP stub for tests                   | External API integration tests          |
| **Testcontainers**                           | Real DB/broker in Docker for ITs      | Postgres, etc.                          |
| **JaCoCo**                                   | Code coverage reports                 | 0–30% → 80–90%+ IT coverage             |
| **Liquibase**                                | DB schema versioning                  | Changelog per service                   |
| **Kafka**                                    | Distributed **log** / event streaming | High throughput, replay, many consumers |
| **RabbitMQ**                                 | Message **broker** (queues)           | Task/workflow messaging (GED, awards)   |
| **Redis**                                    | In-memory cache / session             | credential-account, factory project     |
| **Neo4j**                                    | Graph DB                              | Investigated in platform work           |
| **GraphQL / DGS**                            | API query layer                       | member-directory style services         |
| **PostgreSQL / SQL Server**                  | Relational DBs                        | Service-per-DB pattern                  |
| **Docker**                                   | Container images                      | Local + CI builds                       |
| **Kubernetes**                               | Orchestration                         | Runtime platform                        |
| **Argo CD**                                  | GitOps deploy                         | Sync cluster from git                   |
| **GitHub Actions**                           | CI pipelines                          | Build, test, deploy                     |
| **Consul**                                   | Service discovery / config            | Runtime config                          |
| **Micrometer / Prometheus / Grafana / OTel** | Metrics + tracing                     | Observability post-Sleuth               |
| **Spring Security**                          | AuthN/AuthZ                           | API security                            |
| **Apache Camel**                             | Integration routing                   | Shared test library for IMS             |
| **Go / Gin**                                 | Compiled language + web framework     | Overtime internal platform              |
| **React / Next.js**                          | Frontend                              | Overtime UI, CDP AI UI, learner portals |
| **Spring AI / ChromaDB / Ollama**            | LLM + embeddings + local models       | CDP RAG prototype                       |


---



## 7. “When to use X vs Y” (lead / architect answers)



### Kafka vs RabbitMQ


|                    | **Kafka**                                           | **RabbitMQ**                                       |
| ------------------ | --------------------------------------------------- | -------------------------------------------------- |
| Model              | **Log** — messages retained, replayable             | **Queue** — consume and ack                        |
| Throughput         | Very high                                           | High, usually lower than Kafka                     |
| Ordering           | Strong per partition                                | Per queue, not global                              |
| Routing            | Topics + consumer groups                            | Exchanges, bindings, routing keys                  |
| Replay             | Yes (retention window)                              | No (unless you design for it)                      |
| Best for           | Event streaming, analytics, audit, many subscribers | **Workflow commands**, job queues, RPC-style async |
| Parchment examples | Factory chain, streaming patterns                   | **GED migration**, award/assessment pipelines      |


**Short diff:** RabbitMQ **routes then deletes** (queue + ack). Kafka **stores then many groups read** (log + offset). One Rabbit message → copies into matching queues, **one consumer per queue**. One Kafka record → **every consumer group** can read it; inside a group, **one consumer per partition**.

**RabbitMQ:** Producer sends to an **exchange** with a **routing key**. Exchange checks **bindings**. If a binding matches, it puts a **copy** on each matching **queue**. **One consumer** from that queue gets it (then ack → gone).

**Kafka:** Producer sends a **record** to a **topic**; Kafka writes it to **one partition**. Each **consumer group** reads independently. Inside a group, the partition is **assigned** to one consumer (A2 owns P0). “Assigned” is not a permanent Rabbit binding — if A2 dies, Kafka can give P0 to A1 or A3.

**Say:** “Kafka when I need **durability + replay + scale**. Rabbit when I need **routing + task queues + simpler ops** for workflow steps.”

**Why those three words (Kafka):**

- **Durability** — append-only **disk log**, replicated across brokers. After a consumer reads, the record **stays** until retention. Kafka durability = the event is still there for other groups / a crash / an audit.
- **Rabbit ack:** consumer processes, then sends **ack**. Broker **removes** the message. Until ack, it stays unacked (if the consumer dies, it can be **requeued**). Persistence = survive **broker** restart **until ack**. After ack, gone. (`autoAck=true` acks on **delivery**, not after your code — crash then = lost. Prefer **manual ack** after success.)
- **Kafka “ack”** is an **offset commit**, not a delete. Log stays.
- **Replay** — move the **offset** back. Rabbit has nothing left to replay after ack.
- **Scale** — split a topic into **partitions**; add consumers in the same group, each owns partitions. Writes/reads grow with partitions. A Rabbit **queue** is one line of work; extra consumers compete, they don’t shard the log.



#### Rabbit *can* persist messages. That’s not the same as Kafka’s retained log. Don't say “Rabbit isn’t durable.” Say “Kafka keeps a replayable log; Rabbit is a work queue.”



### Java 8 vs 17 vs 21


|             | **8**                                 | **17**                                          | **21**                                      |
| ----------- | ------------------------------------- | ----------------------------------------------- | ------------------------------------------- |
| Role        | Legacy baseline                       | **Safe LTS hop**                                | **Current target** with Boot 3              |
| Language    | Lambdas, streams, Optional, java.time | Records, sealed classes, pattern matching start | Virtual threads, mature pattern matching    |
| Why migrate | —                                     | Enterprise stepping stone                       | Performance, long support, Boot 3 alignment |


**Record:** immutable data class. Compiler writes ctor, getters, `equals`/`hashCode`/`toString`. Java 16; you use it on 17.

```java
record Money(String currency, long cents) {}
```

**Sealed class (Java 17):** only the types you **list** may extend it. Closed family — the compiler knows every subtype.

```java
sealed interface Shape permits Circle, Rect {}
record Circle(double r) implements Shape {}
record Rect(double w, double h) implements Shape {}
// class Triangle implements Shape {}  // compile error — not permitted
```

**Pattern matching:** test the type and **bind a variable** in one step. No extra cast.

Java 16/17 (`instanceof`):

```java
if (obj instanceof String s) {
    return s.length();  // s is already String
}
```

Java 21 (`switch` — exhaustive because `Shape` is sealed):

```java
double area = switch (shape) {
    case Circle c -> Math.PI * c.r() * c.r();
    case Rect r   -> r.w() * r.h();
};
```

**Together:** sealed = finite subtypes. Pattern switch = handle each subtype without `if/else` + cast, and the compiler errors if you miss one.

**Virtual threads (21):** cheap threads for blocking I/O. “Lots of concurrent blocking calls without a huge platform-thread pool.”

### Spring Boot 2.3 vs 2.7 vs 3.x


|         | **2.3**       | **2.7**               | **3.x**              |
| ------- | ------------- | --------------------- | -------------------- |
| Java    | 8+            | up to 17/21 with care | **17+** (21 typical) |
| EE APIs | `javax`       | `javax`               | `jakarta`            |
| Docs    | Springfox era | transition            | **Springdoc**        |
| Tracing | Sleuth        | Sleuth fading         | **Micrometer**       |




### Go vs Java (your resume)


|                | **Go**                                                                                                                                            | **Java**                                   |
| -------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------ |
| Typing         | Static, compiled                                                                                                                                  | Static, JVM                                |
| Concurrency    | **Goroutines** — lightweight                                                                                                                      | Threads + executors; virtual threads in 21 |
| Ecosystem      | Great for **small services, CLIs, APIs**                                                                                                          | Huge enterprise ecosystem (Spring)         |
| Your use       | Overtime platform (Gin + Postgres + React)                                                                                                        | Main career — microservices at scale       |
| Interview line | “Go for a **focused internal service** with fast compile/deploy; Java/Spring for **large integrated platform** with mature libs and team skills.” |                                            |




### Go vs Java vs C++ (if asked)


|               | Go                           | Java                | C++                                  |
| ------------- | ---------------------------- | ------------------- | ------------------------------------ |
| Memory        | GC                           | GC                  | Manual / RAII                        |
| Speed to ship | Fast                         | Fast (with Spring)  | Slower                               |
| Typical use   | Cloud microservices, tooling | Enterprise backends | Systems, games, perf-critical native |


**Ship ≠ deploy.** Deploy = put the binary on a server. **Ship** = idea → working in prod (write, compile, test, release, deploy).

- **Go fast to ship:** compiles in seconds, **one static binary**, no JVM to install. Easy for a small API/CLI (your overtime platform).
- **Java fast to ship (with Spring):** not because compile is fastest — because **libraries + team**. Boot starters, Spring Security, JPA. You don’t rebuild payments/auth from scratch. JVM + fat jar is heavier to start than Go.
- **C++ slow to ship:** long builds, manual memory, more ways to shoot yourself. You pick it when **runtime speed / native control** matters (games, engines), not when you need a CRUD service next week.

**Say:** “Go if I need a small service out the door. Java/Spring if the problem is a large platform. C++ if I need native performance and I’ll pay for longer delivery.”

### REST vs GraphQL


| REST                                         | GraphQL (DGS)                                        |
| -------------------------------------------- | ---------------------------------------------------- |
| Resource URLs, multiple calls for aggregates | Client asks for **exact fields**                     |
| Caching simpler                              | Flexible queries; **N+1 is common** unless you batch |
| Your context                                 | Most microservices                                   |


**N+1 in GraphQL — it happens a lot, not rarely.** One query `{ users { orders { id } } }` → 1 query for users, then **N** queries for each user’s orders if each field resolver hits the DB. REST has N+1 too (`GET /users` then N `GET /users/{id}/orders`), but GraphQL nested fields make it easy to hide. **Fix:** DataLoader / batch loaders (DGS supports this) — collect IDs, one `WHERE id IN (...)`.

### 2PC vs Saga vs Outbox


|               | **2PC**                 | **Saga**                       | **Transactional outbox**        |
| ------------- | ----------------------- | ------------------------------ | ------------------------------- |
| Scope         | Atomic across DBs       | Multi-service business process | **DB + publish event** reliably |
| Style         | Lock + vote             | Compensating steps             | Local TX + async relay          |
| Shield stance | Avoid for microservices | Workflow failures              | **Preferred** for DB → Kafka    |


**2PC (two-phase commit):** coordinator asks every resource (DB, Kafka, another DB) **PREPARE**, then **COMMIT** or abort all. Strong atomicity, **locks until phase 2**. Slow; coordinator crash freezes everyone. Shield: **don’t** use across microservices.

**Saga:** one business flow, many services, **no global lock**. Each service **commits locally** (T1, T2…). If T3 fails, run **compensations in reverse** (C2, C1) — refund, cancel booking. Eventual consistency. Choreography = events; orchestration = saga manager.

**Outbox:** not a multi-service workflow. Problem = **dual write** (save DB **and** publish Kafka). Crash after DB / before Kafka = lost event. Fix: same **local TX** writes business row + **outbox row**. Poller/CDC later sends outbox → Kafka. Event publishes only if DB commit succeeded.

**Pick:** DB + Kafka in one service → **outbox**. Car+hotel+flight / mobile in 4 DBs → **saga**. “All or nothing across two databases with locks” → **2PC** (avoid).

---



## 8. Testing — what to say

**Stack:** JUnit 5 + Mockito + WireMock + Testcontainers + JaCoCo.

**JUnit 4 → 5:**


| JUnit 4             | JUnit 5        |
| ------------------- | -------------- |
| `@RunWith`          | `@ExtendWith`  |
| `@Before`           | `@BeforeEach`  |
| `@Test(expected=…)` | `assertThrows` |


**JMockit → Mockito:** `@Mocked` → `@Mock`; expectations → `when/verify`.

---



## 9. Cloud / delivery (short)

**Pipeline:** GitHub Actions **builds** → image in a registry → git (manifests) is the desired state → **Argo CD** syncs the cluster → **Kubernetes** runs pods → **Consul** (if used) for discovery/config at runtime.


| Tool               | Role                                                                                                                                                   |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Docker**         | Pack app + runtime into an **image**. Same artifact local / CI / cluster.                                                                              |
| **Kubernetes**     | **Orchestrates** containers: schedule, restart, scale, Service DNS, rolling deploy.                                                                    |
| **Argo CD**        | Argo CD is a declarative, GitOps continuous delivery tool for Kubernetes. **GitOps CD.** Cluster must match git. You merge YAML/Helm; Argo applies it. |
| **GitHub Actions** | **CI.** On push/PR: test, `mvn`, docker build, push image, maybe bump a tag.                                                                           |


**Docker:** Dockerfile = base JRE (17 then 21 in Shield) + your jar. `docker build` → image. You don’t install Java on the server by hand. After uplift: **new base image**, local run, then **dev deploy** — proves the container boots, not only `mvn test`.

**Kubernetes:** desired state. **Deployment** (replicas, rolling update), **Pod** (running container), **Service** (stable name/IP in front of pods). K8s restarts crashed pods, spreads them on nodes. Scale = replica count. Default deploy = **RollingUpdate** (see architecture cheat sheet).

**GitHub Actions vs Argo CD:**

- Actions = **CI** (build/test/publish **image**). Runs in GitHub’s runners when you push.
- Argo = **CD** (make **cluster** look like git). Does not compile Java. It applies k8s manifests that **point at** the image Actions already pushed.
- Don’t say “Argo builds my jar.” Say “Actions builds; Argo deploys what’s declared in git.”

**Argo CD (GitOps):** git is source of truth. Argo **watches** the repo, diffs live cluster vs git, **syncs**. Rollback = revert the git commit (or pin previous image tag). Better audit than `kubectl apply` from a laptop.

**Say:** “I wasn't only upgrading code — we changed the **Java Docker base**, CI built the image, Argo/K8s ran it on **dev**, then smoke-tested. CI builds; GitOps deploys.”

---



## 10. AI / RAG project (CDP) — refresh

**Project:** A work-assigned e-commerce study: conversational product search, cart/checkout actions, PDF/book upload, and document question answering. The repo is a prototype, not a production ML platform.


| Term                     | Meaning                                                                                |
| ------------------------ | -------------------------------------------------------------------------------------- |
| **RAG**                  | Retrieve relevant document chunks first, then give them to the LLM as grounded context |
| **Embeddings**           | Numbers representing meaning; similar questions and passages have nearby vectors       |
| **Vector DB (ChromaDB)** | Stores vectors plus metadata and returns nearest chunks for a query                    |
| **Chunking**             | Splits a PDF into searchable pieces; chunk size and overlap affect recall and context  |
| **Similarity threshold** | Rejects weak matches so unrelated text is not sent to the model                        |
| **Top-K**                | Number of best matching chunks included in the prompt                                  |
| **Spring AI**            | Spring abstractions for model, embedding, prompt, and vector-store integrations        |
| **Ollama / LM Studio**   | Local model servers used for private, repeatable development                           |


**Models and tools — configured in this checkout:**


| Role                                                                                  | What I used                                                                                                                                                                                                                                       |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Text generation: summaries, answers, intent classification, SQL generation/correction | `google/gemma-3-12b-it`, served locally by **LM Studio** at `localhost:1234/v1/chat/completions`; temperature `0.3` in both modules                                                                                                               |
| Embeddings: documents and questions                                                   | `nomic-embed-text`, served locally by **Ollama** (documented port `11434`). `nomic-embed-text` is an AI **embedding model**: it converts text into a list of numbers—a vector—that represents its meaning. It doesn’t write answers or summaries. |
| Document storage                                                                      | **ChromaDB**, configured at `localhost:8005`; a collection named from each PDF filename                                                                                                                                                           |
| Commerce data                                                                         | **PostgreSQL** via Spring **JdbcTemplate**; products, categories, carts, orders. This commerce path uses SQL, not MongoDB                                                                                                                         |
| Java integration                                                                      | **PDFBox** extracts PDF text; **Spring AI** supplies Document/embedding/Chroma APIs; custom **RestTemplate** calls send system + user prompts to Gemma                                                                                            |


Temperature controls how randomly the text-generating model chooses its next token:

- Close to 0	-> More predictable; strongly favors likely tokens. Typical use:	SQL generation, classification, factual summaries
- Close to 1	More varied wording and choices; greater chance of unexpected output. Typical use:	Brainstorming, creative writing

**PDF upload — what happens:** `UploadService` → PDFBox extracts text (**Apache PDFBox is an open-source Java library** for reading, creating, and manipulating PDF files) → `FileProcessor` tries chapter headings, then page-break groups, then roughly **15,000-character** chunks. Oversized chapters are split around paragraphs/sentences using a **20,000-character target**. These are character counts, not token counts. Each resulting chunk is sent to Gemma for a summary, then passed through the embedding integration and upserted into Chroma.

**What is saved? Both text and summary, plus the vector:** each Chroma record contains an 

- **ID**
- **original chunk text** (`documents`)
- **embedding** (`embeddings`)
- **metadata**: `summary`, chapter ID/title/order
- collection name

The summary is a metadata field attached to its chunk, not a separate summary-only document. This upload path does not save the original PDF binary. A failed summary can be empty while its chunk still gets stored.

**Normal question:** Gemma classifies the request and can produce a search query → Ollama embeds that query → Chroma retrieves **Top-K = 3** chunks → the **original retrieved chunk text** goes into Gemma's answer prompt. Code caveat: threshold `0.2` is configured, but `convertQueryResponse` only logs the score comparison and adds every returned result; filtering is unfinished.

**Full-book summary:** fetch **all documents** in the book collection → sort by chapter/part order → concatenate nonempty **metadata summaries** → ask Gemma for one overall summary. This is a “summary of summaries,” not Top-K retrieval. If collection-level `summary` metadata already exists, return it; saving a newly generated overall summary there is still a **TODO**, so it may be regenerated on the next request.

**E-commerce — which parts does AI generate?**


| Request       | Model's job                                                                                 | Application/database job                                                                                                                                                                                               |
| ------------- | ------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Find products | Classify intent; use chat history + supplied table schema to generate **SQL + entity type** | Execute SQL through JdbcTemplate, map rows, format response; on SQL failure allow **one correction** (two execution attempts total)                                                                                    |
| Add to cart   | Generate the **product-ID lookup SQL**                                                      | Execute lookup, then call the fixed PostgreSQL function `add_products_to_cart(userId, productIds)` with parameters. The function creates/finds a cart, checks product existence/stock, and inserts or increments items |
| Checkout      | Classify the request as checkout                                                            | Execute fixed `CHECKOUT_TRANSACTION` SQL: validate cart/stock, create order + order items, reduce stock, clear cart, return receipt data. Checkout SQL is **not generated by the model**                               |


**Say:** “I studied RAG by building the path from document ingestion to retrieval and answer generation. I learned that answer quality depends first on chunking, metadata, and retrieval thresholds; the LLM cannot recover context that retrieval never supplied.”

**Interview distinction:** “This was a prototype. It demonstrated semantic search and a conversational UI; it did not prove production accuracy, security, cost, or scale.”

---



## 11. Go overtime platform — refresh (resume, ~2 years ago)

**Project:** An internal platform for organizing extra work: teams post jobs/tasks and the skills needed, employees can be matched to suitable work, and timesheets record the hours worked. An approval workflow lets the responsible people review an overtime request or recorded hours before it is finalized. 

**What does “routing approvals” mean?** Sending a submitted request to the next person responsible for reviewing it. In the **lead → finance** flow from your notes, the lead reviews the work/hours, then finance reviews the financial approval. Example: **submitted → waiting for lead → waiting for finance → approved**. This explains the workflow; exact states, rejection rules, and whether approval happened before work or after timesheet submission still need confirmation.

**Stack:** **Gin** router, **PostgreSQL**, **React** frontend. 


| Concept   | Go reminder                                                           |
| --------- | --------------------------------------------------------------------- |
| `go mod`  | Declares and resolves Go dependencies; `go.sum` records checksums     |
| Goroutine | Lightweight concurrent function; coordinate shared work safely        |
| Handler   | `func(c *gin.Context)` reads the request and writes the response      |
| JSON      | `c.JSON(200, obj)` serializes an HTTP response                        |
| DB        | `database/sql` gives explicit SQL; an ORM reduces mapping code        |
| Approval  | State transition such as submitted → lead approved → finance approved |


**Features:** job posting, skill matching, **approval workflow** (lead → finance), and timesheets.

**Interesting design questions:** Keep approval transitions explicit and auditable; validate that only the right role can perform each transition; use database transactions when an approval changes both status and related records; prevent overlapping or duplicate time entries.

**Say:** “It was a small bounded internal service. Go was a good fit because the API was focused, the binary was easy to deploy, and goroutines gave us a simple concurrency model; PostgreSQL held the workflow and timesheet state.”

---



## 13. Likely interview questions + short answers



### Migration

**Q: Biggest challenge in Boot 3 migration?**  
A: **Jakarta namespace** + **Hibernate 6** + **test stack** at once. We staged via 2.7 and migrated in small PR batches.

**Q: How do you know migration succeeded?**  
A: Full `mvn clean install`, ITs green, Docker image on dev, smoke tests, **same behavior** — coverage up, not assertions down.

**Q: javax vs jakarta?**  
A: Eclipse took Java EE → Jakarta EE; Boot 3 requires `jakarta.*` for EE APIs.

### Architecture

**Q: Microservices vs monolith?**  
A: Parchment = **database-per-service**, async events, API composition for reads. Trade-off: **distributed transactions** → saga/outbox, not 2PC.

**Q: How do you choose messaging?**  
A: See Kafka vs Rabbit table above.

**Q: Connection pool issue?**  
A: Multi-datasource + wrong **transaction manager** binding → pools not released. Fixed config; monitored Hikari metrics.

### Leadership

**Q: Principal vs senior?**  
A: Beyond coding — **migration standards**, PR review, **mentoring**, cross-team alignment, risk scans before uplift, test strategy.

**Q: How do you mentor?**  
A: Onboarding on **domain flows + architecture**, pair on first migration PR, share Shield playbook/checklists.

### Testing

**Q: WireMock vs Mockito?**  
A: Mockito = **in-process** mocks. WireMock = **HTTP** stub for external services.

**Q: Testcontainers?**  
A: Real Postgres/Rabbit in Docker for ITs — catches Liquibase + driver + dialect issues unit tests miss.

---

---

