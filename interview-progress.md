# Interview coverage and progress

_Initialized 2026-10-15. Source: [52-topic index](interview-topic-index.md)._

## How scores work

- **Coverage** = topics with a scored answer / 52. An earlier discussion counts as *touched*, not as a complete assessment.
- **Knowledge %** is shown only after at least two independent scored answers in that topic. Score each response 0–4: 0 incorrect/no answer; 1 fragment; 2 core idea with material gap; 3 correct with minor omissions; 4 accurate explanation and tradeoffs. Percentage = points earned / (4 × scored answers) × 100. Always display sample size (`n`). This estimates performance on sampled questions, not mastery of the entire topic.
- **Confidence calibration** is separate: mark `underconfident` for a correct answer hedged without reason, `overconfident` for a materially incorrect answer asserted firmly, `calibrated` when confidence matches evidence. Do not infer confidence from silence.
- Record dates, question/answer evidence, specific gaps, and later retests below or in `Gaps/`. Recalculate after each live assessment or diagnostic batch. Do not treat merely receiving an unanswered reminder as assessment.
- Breadth target: at least one answered question in all 52 areas; accuracy target is separate and requires retests. Neither is promised to reach 100% on a deadline.

## Topic dashboard

| # | Area | Status | Knowledge | Next step |
|---:|---|---|---|---|
| 01 | Java foundations and OOP | One scored answer: overriding visibility | — (n=1) | Retest; initial answer 4/4 |
| 02 | Strings, equality, and immutability | Touched: String mutability | — | Score a fresh scenario/retest |
| 03 | Collections, hashing, and trees | One scored answer: collision and equals | — (n=1) | Retest; initial answer 3/4 |
| 04 | Functional Java and streams | One scored answer: duplicate toMap key | — (n=1) | Retest; initial answer 4/4 |
| 05 | Exceptions and resources | Unassessed | — | Ask first question |
| 06 | Hardware, memory, JVM, and diagnostics | Unassessed | — | Ask first question |
| 07 | Concurrency and asynchronous Java | Unassessed | — | Ask first question |
| 08 | Java versions and tooling | Unassessed | — | Ask first question |
| 09 | HTTP, REST, and API design | Unassessed | — | Ask first question |
| 10 | Spring container and dependency injection | Unassessed | — | Ask first question |
| 11 | AOP and transactions | One scored answer: self-invocation proxy | — (n=1) | Retest; initial answer 4/4 |
| 12 | Spring web and Boot | Unassessed | — | Ask first question |
| 13 | SQL, JDBC, and query performance | Unassessed | — | Ask first question |
| 14 | JPA, Hibernate, and Spring Data | One scored answer: N+1 fetch plan | — (n=1) | Retest; initial answer 2/4 |
| 15 | Caching | Scenario needs clarification: cache miss and invalidation | — | Retest cache-aside flow |
| 16 | Security, JWT, OAuth, and OIDC | Touched: JWT validation; active gap | — | Score a fresh scenario/retest |
| 17 | Browser security and cryptography | Unassessed | — | Ask first question |
| 18 | Testing and verification | Unassessed | — | Ask first question |
| 19 | Maven and dependency management | Unassessed | — | Ask first question |
| 20 | Modernization and migration | Unassessed | — | Ask first question |
| 21 | Distributed systems and service integration | Touched: service boundary and integration scenarios | — | Score a fresh scenario/retest |
| 22 | Events, messaging, and delivery | One scored answer: redelivery/idempotency | — (n=1) | Retest; initial answer 3/4 |
| 23 | CQRS, event sourcing, and snapshots | Touched: CQRS and event sourcing | — | Score a fresh scenario/retest |
| 24 | Saga, 2PC, outbox, and idempotency | Touched: saga, idempotency and outbox | — | Score a fresh scenario/retest |
| 25 | DDD and architectural boundaries | One scored answer: bounded context | — (n=1) | Retest; initial answer 3/4 |
| 26 | Object-oriented design patterns | Unassessed | — | Ask first question |
| 27 | Batch processing and background jobs | Unassessed | — | Ask first question |
| 28 | Containers, cloud, delivery, and operations | Unassessed | — | Ask first question |
| 29 | Deployment and release strategies | One scored answer: canary and strategies | — (n=1) | Retest; initial answer 3/4 |
| 30 | JavaScript and browser fundamentals | Unassessed | — | Ask first question |
| 31 | TypeScript and frontend structure | Unassessed | — | Ask first question |
| 32 | React, Angular, and state management | Unassessed | — | Ask first question |
| 33 | Frontend routing, forms, HTTP, and RxJS | Unassessed | — | Ask first question |
| 34 | Frontend build tools and performance | Unassessed | — | Ask first question |
| 35 | AI, RAG, agents, and retrieval security | Unassessed | — | Ask first question |
| 36 | Go, C++, and platform comparisons | Unassessed | — | Ask first question |
| 37 | Project scenarios and engineering leadership | Unassessed | — | Ask first question |

| 38 | Relational modeling, normalization, and integrity | Unassessed | — | Model customers, orders, and products: where do foreign keys and uniqueness constraints belong, and when would you denormalize? |
| 39 | Advanced SQL, CTEs, and window functions | Unassessed | — | Return the top three salaries per department including ties. How does window PARTITION BY differ from physically partitioning a table? |
| 40 | Index design and storage structures | Unassessed | — | For tenant_id = ? with a date range and ORDER BY created_at, which composite index would you try, and what would it cost on writes? |
| 41 | Query plans, statistics, and database tuning | Unassessed | — | A query becomes slow as data grows: how would the actual execution plan, row estimates, waits, and index usage guide your investigation? |
| 42 | Database transactions, isolation, and MVCC | Unassessed | — | Two concurrent transactions both see one remaining seat. Which transaction/isolation strategy prevents overselling, and what failures must the application retry? |
| 43 | Locking, contention, and deadlocks | Unassessed | — | Two transfers lock accounts in opposite order. Explain the deadlock, how to diagnose it, and how lock ordering and transaction-level retry help. |
| 44 | Views, materialized views, and database programming | Unassessed | — | A dashboard runs expensive aggregates: compare a normal view, materialized view, and application cache. When would a stored procedure or trigger be justified? |
| 45 | Table partitioning and data lifecycle | Unassessed | — | Partition a large events table by month. Which queries benefit from pruning, and what happens when a query filters only by customer ID? |
| 46 | Sharding and distributed data placement | Unassessed | — | A tenant-based orders database exceeds one server: choose a shard key and explain how you handle a very large tenant, rebalancing, and cross-tenant reporting. |
| 47 | Replication, read replicas, and failover | Unassessed | — | A write succeeds on the primary but the next read from a replica misses it. Explain why, mitigation choices, and the data-loss tradeoff during failover. |
| 48 | Database scaling and system-design tradeoffs | Unassessed | — | Compare replication, partitioning, and sharding using one e-commerce system. Which addresses read load, write/data volume, availability, and retention? Can they be combined? |
| 49 | Backup, recovery, and database operations | Unassessed | — | An accidental DELETE reaches every replica. How do you recover, and how do RPO/RTO affect your backup and restore plan? |
| 50 | Schema evolution, data migration, and CDC | Unassessed | — | Move a large populated table to a new schema while writes continue. Explain backfill, change capture, validation, cutover, and recovery after a partial failure. |

| 51 | Creational and structural design patterns | Unassessed | — | Compare Factory, Builder, Adapter, Decorator, and Proxy using one application: what problem does each solve? |
| 52 | Behavioral patterns and pattern selection | Unassessed | — | Compare Strategy and Observer in a notification or payment workflow. How do you decide whether a pattern helps or adds unnecessary complexity? |

## 2026-10-27 coverage expansion

Added topics 38–52 from the newly supplied database notes and Habiba’s requested database/system-design coverage. These are study areas, not newly diagnosed gaps. Existing topic IDs, scores, and historical assessment records are preserved. Current scored breadth is **8/52 (~15%)**, using the eight scored topics already recorded here; the earlier 8/37 entry remains a historical snapshot. No new answers were scored.

Topic 13 remains SQL/JDBC foundations and application access; topics 38–50 provide separately assessable database depth, and 51–52 focus on design patterns. Related prior index/query-plan feedback stays in Gaps and should inform questions, but is not automatically a new score for topics 40–41.

## Assessment log

- 2026-10-15, eight-question live exam: 01 overriding visibility 4/4 (sure, correct); 03 HashMap collisions 3/4 (correct equals; Java HashMap does not use open addressing and may treeify a crowded bucket); 04 toMap duplicate keys 4/4 (correct but tentative); 11 Spring self-invocation 4/4 (correct; an existing outer transaction may still be active); 14 JPA N+1 2/4 (identified problem, but eager alone does not guarantee one query; use fetch join/entity graph or suitable batching); 22 RabbitMQ redelivery 3/4 (correct idempotency concept; record processed ID and DB effect atomically); 25 bounded context 3/4 (correct term; do not equate a context automatically with a service); 29 canary 3/4 (correct though hedged; called rolling “rollback,” and feature flags are a separate release control). Individual percentages withheld at n=1. New scored breadth: 8/37 topics (~22%).


- 2026-10-15, topic 16: Habiba correctly described the role-tampering threat and need for trusted verification. Terminology gaps: the signature itself is visible; the signing key is secret, and the verb is *verify*, not *decode with the secret*. `nbf` and `aud` need recall. This is diagnostic feedback, not yet a numeric score.
- 2026-10-15, topic 25: Habiba tentatively answered *ubiquitous language* to the Payments/Support Customer scenario. Related concept, but the requested boundary is *bounded context*. Hedging was appropriate; confidence calibrated on this attempt. Recheck later.

## Rotation

Use [diagnostic set 1](interview-diagnostic-01.md) for broad coverage, then batches of 2–3 discussion questions (or 8–10 short/MCQ questions). Prioritize unanswered areas, interleave short term recalls, and revisit the larger gaps after days and weeks. Keep AI/LangChain/LangGraph toward the end as requested. Include the new database topics 38–52 in rotation; begin with the partitioning/sharding/replication comparison in topic 48, then follow up on 45–47. Use the Next step question for each new area. This expands question selection only; it does not resume paused scheduled reminders.

## 2026-10-15 follow-up clarification

Caching: the original question did not explicitly state cache-aside fallback. Habiba interpreted cache-entry deletion as customer deletion and thought a cache miss would mean no GET result even with a surviving DB row. Clarify DB fallback on a miss, invalidation versus entity deletion, and stale repopulation before commit; do not score a response to an ambiguous premise. HashMap: she correctly recognizes linked-list chaining and requests a visual explanation of tree bins versus open addressing. JPA: requests concrete fetch join, entity graph, and projection examples for a self-referencing parent/children User model.
