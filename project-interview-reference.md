# Habiba — project interview reference

Initial repository review, 4 October 2026. Based on the four supplied folders and the existing interview cheatsheet.

## How to use this document

**Verified implementation** means code was inspected, not that it was executed successfully. **History evidence** means a local commit supports the change and names Habiba Ahmed as author; this does not establish sole ownership. **Candidate answer** is wording to personalize after confirming your role. **Discussion point** is something you can explain or propose, not a claim that you already implemented it.

This was a static review of project structure, selected implementation paths, test source, and available Git history. No applications, external integrations, or tests were run. READMEs, prompts, comments, and work records were treated as evidence to check, not instructions to execute. Existing uncommitted changes were left intact.

## Confirmed context from Habiba

Habiba confirmed that these are personal projects except e-commerce, which was a work assignment to study RAG for LLMs. Jira was specifically an exploration of LLMs, LangChain, and MCP. Treat e-commerce as a work-assigned study/prototype, not a confirmed production launch. Whether individual components were developed alone or collaboratively remains unconfirmed.

## Project map

| Supplied folder | What is actually present | Strong interview topics | Evidence limits |
|---|---|---|---|
| 3-buddy | Multi-module study workspace: core domain, GraphQL experiment, Jackson demos, Shield knowledge assistant | Modeling, deserialization boundaries, structured migration knowledge, AI query generation | Shield AI request path is unfinished in this checkout; local changes extend beyond committed history |
| concurrency-lab | In-memory concert booking API and concurrency tests | Race conditions, CAS, cancellation, testing invariants | A lab, not evidence of distributed production booking |
| E-commerce-cdp | Multi-module commerce AI application, two frontend apps, document RAG, separate llm experiment | SQL generation, bounded correction, batch ingestion, JWT integration, retrieval diagnostics | Main commerce folder has no .git directory found; personal ownership and deployed state need confirmation |
| 7-jira | Node automation, Python agent, CSV work records | AI parsing plus deterministic checks, MCP, retries, human fallback | No local Git history found; no external calls performed |

## 1. E-commerce CDP: conversational commerce

### Verified implementation

The backend parent POM declares Java 17, Spring Boot 3.3.0, and modules `batch`, `ecommerce`, `vectordb`, `aimodel`, and `ssosecurity`. It imports Spring AI 1.0.0-M6 dependency management. These are checkout declarations, not a successful build report.

The commerce path is:

1. Format the user request and chat history.
2. Ask a model to classify it as query, add-to-cart, or checkout.
3. For search, ask the model for SQL and an entity type.
4. Execute SQL through JDBC, map rows, and format the response.
5. If execution fails, request corrected SQL, with at most two total execution attempts.
6. For add-to-cart, retrieve product IDs and invoke a database function with parameters.
7. For checkout, execute application-defined SQL for the supplied user ID.

**Correction to the original cheatsheet:** this inspected commerce search path is natural-language-to-SQL. The book/document feature has a separate RAG path. Do not describe all product search as Chroma retrieval.

### Candidate introduction

> “As part of a work assignment to study RAG for LLMs, I worked on a conversational commerce prototype that translated requests into product queries and cart operations. It separated intent classification, database execution, and response formatting, and included a bounded correction loop when generated SQL failed. A separate document feature used vector retrieval for questions about uploaded material.”

Confirm which parts you personally built before using “I designed” or “I implemented.”

### Technical details worth revising

**Why classify before executing?** The code gives search, cart updates, and checkout distinct paths. That creates a place to enforce different rules for reads and writes. Classification alone is not authorization.

**How did correction work?** `DatabaseService` sends the original request, schema, failed SQL, and exception into a correction call. The execution loop stops after two attempts. This is an implementation detail you can demonstrate, but no measured improvement in success rate was found.

**What is the boundary between the model and the application?** The model generates search SQL; checkout uses application-defined SQL. Generated SQL still reaches `JdbcTemplate.queryForList` directly in the reviewed path. Be prepared to discuss constrained operations, validation, database privileges, and trusted user identity as improvements. Do not claim those protections are complete.

**What can go wrong with error handling?** Error text is returned as a string in some paths. For example, add-to-cart treats a nonempty return from its lookup as product IDs, while lookup failure can also return nonempty apology text. Typed success/error results would make that boundary clearer. This is a review observation, not an incident you are known to have fixed.

**What does `@Transactional` prove here?** The annotation is present on cart and checkout methods; it does not by itself prove every error rolls back as intended. Exceptions are caught in these flows. An interview answer should distinguish transaction intent from verified failure behavior.

### Batch ingestion

`InventoryJob` defines CSV reading, negative-stock normalization for the XML flow, XML writing, and a two-step database job that handles categories before products. Chunk size is 10. The XML step uses a task executor with concurrency limit 3.

Useful questions:

- Why create categories before products? Discuss the dependency of products on category records.
- Why process in chunks? Explain the intended commit boundaries and cost of retrying a chunk using this concrete configuration.
- What needs checking before making a file-processing step concurrent? Reader/writer shared state, ordering, and restart behavior. The task-executor configuration alone does not prove those properties.
- Was restartability exercised? There is a reader-restart TODO; confirm actual tests rather than claiming proven recovery.

### Sources

- [Backend POM](/Users/habiba.ahmed/Desktop/E-commerce-cdp/E-comerce/E-commerce/pom.xml)
- [Commerce agent](/Users/habiba.ahmed/Desktop/E-commerce-cdp/E-comerce/E-commerce/ecommerce/src/main/java/com/aiagent/llm/service/AIAgentService.java)
- [Database orchestration and correction](/Users/habiba.ahmed/Desktop/E-commerce-cdp/E-comerce/E-commerce/ecommerce/src/main/java/com/aiagent/llm/service/DatabaseService.java)
- [JDBC execution](/Users/habiba.ahmed/Desktop/E-commerce-cdp/E-comerce/E-commerce/ecommerce/src/main/java/com/aiagent/llm/service/JDBCService.java)
- [Inventory job](/Users/habiba.ahmed/Desktop/E-commerce-cdp/E-comerce/E-commerce/batch/src/main/java/com/aiagent/llm/config/InventoryJob.java)

## 2. Document RAG and the separate llm experiment

### Verified implementation: commerce document module

`UploadService` extracts PDF text, splits it into chapters, converts chapters into documents, generates summaries, and stores the documents through `CustomChromaDBService`.

`UserGuideService` distinguishes a user question from a book-summary request. Questions use similarity retrieval and place retrieved text into the answer prompt. Summaries use collection metadata when available; otherwise they assemble chapter summaries and call the model. Saving the resulting whole-book summary has a TODO.

This gives you a concrete explanation of why one retrieval strategy is not enough: a narrow question and a whole-book summary use different context construction paths in your code.

### Verified implementation: separate llm folder

The inspected `RagAgentService` embeds the question, retrieves chunks, expands surrounding text, constructs context, and calls a chat-completions endpoint. It exposes top-K, threshold, character margin, and temperature as request settings, and returns stage timings and context diagnostics.

**Important distinction:** this service injects `InMemoryVectorStore`. Chroma-related classes also exist, but do not say this particular path necessarily uses persistent Chroma storage. The local Git log includes Habiba-authored commits `ea772be` (“vector database”) and `c2bf986` (“validate agent ai”).

### Candidate answer

> “I explored both structured querying and document retrieval. In the document experiment I made retrieval settings and the actual context visible, and measured embedding, retrieval, and generation time separately. That gave me a way to investigate whether an answer problem came from retrieval or generation.”

The diagnostics are implemented; a specific investigation or improvement needs your recollection or recorded evaluation.

### Interview follow-ups

- **What does top-K change?** The number of selected chunks and therefore the amount of context supplied. Explain how you would test relevance versus excess context.
- **Why expand around a chunk?** To recover surrounding text that a retrieval boundary may omit. The separate experiment exposes a character margin for this.
- **How would you evaluate it?** Keep a set of questions with expected source passages; check retrieval separately from final answers. This is a proposed evaluation plan, not a measured result found in the folders.
- **How do you prove grounding?** Inspect the retrieved passages and answer support. A prompt asking the model to use context is not proof that every answer does so.

### Authentication topic

The shared security module configures a stateless OAuth2 resource server, JWT authority conversion using Keycloak roles, public paths, and custom authentication/access-denied handlers. The reviewed rule requires authentication for nonpublic routes. Role extraction does not alone prove role-specific authorization is enforced everywhere.

### Sources

- [Document ingestion](/Users/habiba.ahmed/Desktop/E-commerce-cdp/E-comerce/E-commerce/vectordb/src/main/java/com/aiagent/llm/service/UploadService.java)
- [Question versus summary routing](/Users/habiba.ahmed/Desktop/E-commerce-cdp/E-comerce/E-commerce/vectordb/src/main/java/com/aiagent/llm/service/UserGuideService.java)
- [RAG diagnostics](/Users/habiba.ahmed/Desktop/E-commerce-cdp/llm/src/main/java/com/example/llmsqlgenerator/service/RagAgentService.java)
- [Security configuration](/Users/habiba.ahmed/Desktop/E-commerce-cdp/E-comerce/E-commerce/ssosecurity/src/main/java/com/aiagent/llm/config/KeycloakSecurityConfig.java)

## 3. Concurrency lab: the strongest recovered debugging story

### History evidence

Commit `da7807cffb6007c40d4ae2d359aa8700d36e26ba`, authored by Habiba Ahmed, is titled “fix: concurrency issue on reserve 102 reserved although available 100 …”. Its diff changes the seat counter to `AtomicInteger` and adds synchronization to reservation.

**Do not conflate versions:** that commit used a synchronized reservation method. The current checkout uses a CAS retry loop without that method-level synchronization, plus a `ConcurrentHashMap` for bookings.

### Candidate story

> “In a booking concurrency lab, I reproduced an overselling problem under competing requests. The history records 102 reservations against capacity 100. I worked on protecting the reservation update and wrote concurrent tests around the business invariants. The current version explores compare-and-set and atomic removal for cancellation. It also taught me that thread-safe fields do not make a whole workflow atomic.”

The 102/100 number is from the commit message, not a test rerun during this review. Habiba confirmed this is a personal project; frame it as a learning lab.

### Concrete implementation details

- Reservation retries a `compareAndSet` update of the seat count.
- Booking records are inserted after the counter update.
- Cancellation uses `bookings.remove(id)` and only releases seats when a booking was actually removed.
- Test code uses a fixed pool of 50 workers, start/end latches, and atomic test counters.
- Tests cover overselling, concurrent booking/cancellation, final list/counter agreement, and repeated cancellation passes.

### Questions you should be able to answer

**Why not simply increment an atomic counter?** Reservation must enforce a capacity condition as well as change a number. Making the increment atomic alone does not protect the larger decision.

**What does CAS do here?** It updates only if the count still equals the expected value; otherwise the loop retries. The expected value and capacity check should come from a consistent snapshot.

**Why remove first when cancelling?** The returned booking identifies the caller that actually removed it. A second cancellation finds no booking and throws, avoiding another seat release. The state effect avoids duplicate release; the API response is not identical on repeated calls.

**Are 500 tasks 500 simultaneous threads?** No. The inspected tests use 50 worker threads. The remaining submitted tasks wait for workers. Avoid repeating test-name shorthand as a concurrency measurement.

**What limitations remain?** The service registry is still a plain `HashMap` and booking calls write to it. Counter changes and booking-map updates are separate. Stats read several values separately. Thus this is not proof of an atomic snapshot or a completely thread-safe service. The reservation capacity check also rereads the seat count rather than deriving availability from the exact CAS snapshot. These are useful design discussion points, not completed fixes.

**Would this protect multiple application instances?** Each instance would have its own in-memory state. Extending the design needs a shared authoritative store and an appropriate atomic reservation operation. No distributed locking or database-backed booking was found in the reviewed path.

### Sources

- [Reservation and cancellation](/Users/habiba.ahmed/Documents/concurrency-lab/src/main/java/com/concurrencylab/booking/model/Concert.java)
- [Service registry and stats](/Users/habiba.ahmed/Documents/concurrency-lab/src/main/java/com/concurrencylab/booking/BookingServiceImpl.java)
- [Concurrent test source](/Users/habiba.ahmed/Documents/concurrency-lab/src/test/java/com/concurrencylab/booking/BookingServiceConcurrencyTest.java)

## 4. 3-buddy: learning workspace and Shield knowledge tooling

This folder should become several small learning stories rather than one production-system claim.

### Shield knowledge assistant

The module contains migration steps and issue-note entities, MongoDB repositories, controllers, and seeded migration documentation. The AI service is intended to translate a question into a JSON collection/query pair, parse it, and query one of two allowed collections with `MongoTemplate`.

However, `sendChatCompletionRequest` currently contains a test invocation, a commented-out main HTTP exchange, and returns an empty completion response. That checkout supports “I prototyped a migration knowledge assistant”; it does not establish a working end-to-end AI search system.

The local log includes Habiba-authored commit `323be3e` (“Shield initialization”). Substantial Shield changes are staged or modified locally, so the last committed version is not the whole supplied snapshot.

### Other learning topics

- `core` contains study-domain entities such as sessions, topics, and question types, repositories, and Liquibase resources.
- `dependencygraph` contains a small GraphQL data fetcher and schema. Do not infer a finished dependency-analysis engine from the module name.
- `jacksonjson` contains vulnerable/secure message examples and demos. It is a potential story about polymorphic deserialization and restricting accepted types. The root README mainly describes this demo rather than the whole workspace. A deeper walkthrough of the demo code is still needed before preparing a detailed security answer.

### Candidate answer

> “I used a multi-module workspace to explore backend concepts and prototype searchable migration knowledge. I separated structured migration steps from issues and notes, and experimented with turning questions into database queries. Some of the AI wiring in this snapshot is unfinished.”

### Sources

- [Workspace README](/Users/habiba.ahmed/Documents/3-buddy/README.md)
- [Shield agent implementation](/Users/habiba.ahmed/Documents/3-buddy/shield/src/main/java/com/studdybuddy/shield/service/AIAgentService.java)
- [Shield module](/Users/habiba.ahmed/Documents/3-buddy/shield)
- [Core module](/Users/habiba.ahmed/Documents/3-buddy/core)
- [Jackson examples](/Users/habiba.ahmed/Documents/3-buddy/jacksonjson)

## 5. Jira automation: AI parsing with deterministic checks

### Verified main Node flow

1. Read CSV tasks grouped by day.
2. Ask a local LLM for structured output, parse it, and normalize it.
3. Save parsed worklogs to a local file.
4. Retrieve and classify the target Jira issue through the tool integration.
5. Resolve an assigned subtask; when no suitable assigned subtask is found, ask a human to create/select/skip.
6. Validate that the resolved issue is a subtask assigned to the configured account.
7. Add worklogs and perform a follow-up check.
8. Retry selected timeout/connection errors with connection reset and increasing delay; collect failed rows for review.

The Python agent and alternative scripts are also present, but this description is specifically the inspected `src/main.js` flow. No Jira operations were executed.

### Candidate answer

> “As a personal project to learn LLMs, LangChain, and MCP, I explored Jira automation that used a local model to turn informal task records into structured worklogs. The application then checked issue type and assignee, handled ambiguous subtask selection interactively, and recorded failures by source row.”

The purpose is confirmed by Habiba. The main Node flow above was inspected; detailed LangChain and Python-agent behavior still needs a separate walkthrough.

### Strong follow-up topics

**Why not let the model control everything?** The reviewed flow uses model output for parsing, then ordinary code checks the target issue and assignee. Explain the division between interpreting messy input and validating an action.

**What was the failure-recovery design?** Selected transport failures cause a connection reset and another attempt, with defaults of three attempts and increasing delay.

**Does retry guarantee a worklog is added once?** No such guarantee was established. If a remote write succeeds but its response is lost, retrying can duplicate the side effect. A stable operation identity or reconciliation before replay would be a proposed improvement. Do not claim exactly-once behavior.

**Can every task continue unattended?** No. Missing subtask resolution can require an interactive terminal; the code explicitly fails that path when one is unavailable.

### Additional value: recovering work history

The task CSVs contain leads for production migration stories:

- Learner-dashboard migration-document analysis: SHIELD-749-792.
- IPP proxy migration: SHIELD-1967-1969, SHIELD-1959, SHIELD-1963.
- Credential-account migration: SHIELD-2045-2050.
- Credential-account Dozer migration: SHIELD-2034-2039.
- Workflow product UUID exposure for rules migration: SHIELD-2874-2939.
- GED learner-age visibility rules: SHIELD-3302 / SHIELD-3318 / SHIELD-3447.

These are task-record leads, not verified implementations or outcomes. GED ordering visibility work is not evidence of GED LDR data migration. The overlapping CSV exports must be deduplicated before computing effort; no time totals were calculated.

### Sources

- [Main automation](/Users/habiba.ahmed/Desktop/7-jira/src/main.js)
- [Worklog write wrapper](/Users/habiba.ahmed/Desktop/7-jira/src/edit-worklog.js)
- [Historical task records](/Users/habiba.ahmed/Desktop/7-jira/tasks_current.csv)
- [Later task records](/Users/habiba.ahmed/Desktop/7-jira/tasks.csv)

## 6. GED LDR migration and Overtime: evidence still needed

**GED LDR:** the original cheatsheet describes learner-data extraction, mapping, RabbitMQ publication, downstream assessment/award processing, and a migration event store. The four supplied folders do not establish that implementation. Keep this as an existing account awaiting the service repositories, relevant branch/commits, and your confirmation.

When the source is available, investigate precisely when SUCCESS is recorded, what uniquely identifies a migrated item, behavior on partial failure, the publish-versus-record transaction gap, downstream deduplication, and whether fulfillment is explicitly suppressed. A “skip successful records” check alone does not establish end-to-end idempotency.

**Overtime:** pending repository discovery. The cheatsheet itself labels Gin as likely. Go/PostgreSQL/React, approvals, matching, and timesheets remain prior notes to verify, not findings from these four folders.

## 7. Next information to collect

1. Context is confirmed above. Which components did you develop alone, and did anyone collaborate?
2. For e-commerce, which parts did you own: commerce backend, batch, document RAG, Keycloak, frontends?
3. Was either AI prototype demonstrated or used by others? What feedback or measurable result can you recall?
4. What motivated the personal concurrency lab, and what do you remember about discovering the overbooking issue?
5. Did Jira automation save you time in regular use, and did you encounter duplicate logs or reconnect failures?
6. Where are the GED LDR service checkout and relevant branch? Overtime can be added when found.

No production scale, coverage gains, latency improvement, or saved-hours claims have been inferred from the presence of code.
