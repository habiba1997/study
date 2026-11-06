# November 4, 2026 — System Design Interview Debrief

## Interview scenario
Designed a low-stock inventory event flow. Central Service B publishes a low-stock event to a Kafka topic. Notification Service and Order Service consume the event; Order Service may replenish stock. Because stock might not become low for a week, message count and request count are unreliable health signals when zero.

## Interview observations
- User proposed heartbeat and service health checks.
- Interviewer introduced **Kafka consumer lag**; user did not know the term.
- Interviewer asked where product images should be stored; user said S3, but did not know **object storage** as a category.
- User wants to prepare for an upcoming **specialized coding interview** and understand how it differs from generic problem-solving; actual round format needs verification.
- User is feeling progress in interview skills. Track correctness and confidence separately without assuming every unfamiliar term is a critical weakness.

## High-priority study gaps and follow-up questions
1. Kafka consumer lag: latest log offset minus consumer-group committed offset per partition; how to interpret growing lag, zero lag, idle topics, rebalance, and consumer health. Scenario: no low-stock event for 7 days — what signals are meaningful?
2. End-to-end observability for event-driven systems: producer publish success and publisher acknowledgments, consumer group membership/assignments, processing failures, DLQ, retries, processing latency when events exist, synthetic canary events, alert thresholds, tracing and business invariants. Distinguish no traffic from failure.
3. Object storage: what an object, bucket, key, metadata, and presigned URL are; S3 versus Google Cloud Storage, Azure Blob Storage, MinIO; object versus block versus file storage; why save image object key in relational DB.
4. Specialized coding interview: investigate actual employer invitation/interviewer agenda before guessing interview format. Prepare code review, debugging, Java/Spring fundamentals, concurrency, data modeling, API design and practical exercises depending on confirmation.
5. Deployment strategies: continue frequent scenario questions on Rolling, Blue-Green, Canary and Recreate, especially distinguishing Blue-Green from Recreate.

## Revision instructions
Ask realistic, contextual questions. One-word/one-sentence answers with Sure / Unsure / Guessing. Revisit uncertain concepts even when correct. User is going to sleep: do not launch a quiz now.