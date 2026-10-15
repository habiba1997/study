# Interview coverage and progress

_Initialized 2026-10-15. Source: [37-topic index](interview-topic-index.md)._

## How scores work

- **Coverage** = topics with a scored answer / 37. An earlier discussion counts as *touched*, not as a complete assessment.
- **Knowledge %** is shown only after at least two independent scored answers in that topic. Score each response 0–4: 0 incorrect/no answer; 1 fragment; 2 core idea with material gap; 3 correct with minor omissions; 4 accurate explanation and tradeoffs. Percentage = points earned / (4 × scored answers) × 100. Always display sample size (`n`). This estimates performance on sampled questions, not mastery of the entire topic.
- **Confidence calibration** is separate: mark `underconfident` for a correct answer hedged without reason, `overconfident` for a materially incorrect answer asserted firmly, `calibrated` when confidence matches evidence. Do not infer confidence from silence.
- Record dates, question/answer evidence, specific gaps, and later retests below or in `Gaps/`. Recalculate after each live assessment or diagnostic batch. Do not treat merely receiving an unanswered reminder as assessment.
- Breadth target: at least one answered question in all 37 areas; accuracy target is separate and requires retests. Neither is promised to reach 100% on a deadline.

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

## Assessment log

- 2026-10-15, eight-question live exam: 01 overriding visibility 4/4 (sure, correct); 03 HashMap collisions 3/4 (correct equals; Java HashMap does not use open addressing and may treeify a crowded bucket); 04 toMap duplicate keys 4/4 (correct but tentative); 11 Spring self-invocation 4/4 (correct; an existing outer transaction may still be active); 14 JPA N+1 2/4 (identified problem, but eager alone does not guarantee one query; use fetch join/entity graph or suitable batching); 22 RabbitMQ redelivery 3/4 (correct idempotency concept; record processed ID and DB effect atomically); 25 bounded context 3/4 (correct term; do not equate a context automatically with a service); 29 canary 3/4 (correct though hedged; called rolling “rollback,” and feature flags are a separate release control). Individual percentages withheld at n=1. New scored breadth: 8/37 topics (~22%).


- 2026-10-15, topic 16: Habiba correctly described the role-tampering threat and need for trusted verification. Terminology gaps: the signature itself is visible; the signing key is secret, and the verb is *verify*, not *decode with the secret*. `nbf` and `aud` need recall. This is diagnostic feedback, not yet a numeric score.
- 2026-10-15, topic 25: Habiba tentatively answered *ubiquitous language* to the Payments/Support Customer scenario. Related concept, but the requested boundary is *bounded context*. Hedging was appropriate; confidence calibrated on this attempt. Recheck later.

## Rotation

Use [diagnostic set 1](interview-diagnostic-01.md) for broad coverage, then batches of 2–3 discussion questions (or 8–10 short/MCQ questions). Prioritize unanswered areas, interleave short term recalls, and revisit the larger gaps after days and weeks. Keep AI/LangChain/LangGraph toward the end as requested.

## 2026-10-15 follow-up clarification

Caching: the original question did not explicitly state cache-aside fallback. Habiba interpreted cache-entry deletion as customer deletion and thought a cache miss would mean no GET result even with a surviving DB row. Clarify DB fallback on a miss, invalidation versus entity deletion, and stale repopulation before commit; do not score a response to an ambiguous premise. HashMap: she correctly recognizes linked-list chaining and requests a visual explanation of tree bins versus open addressing. JPA: requests concrete fetch join, entity graph, and projection examples for a self-referencing parent/children User model.
