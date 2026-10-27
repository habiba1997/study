# Interview gaps and recall

This folder records gaps observed in interview answers or explicitly reported by Habiba.

- [Terminology](Terminology/): Small recall gaps. Ask a one-sentence or one-word question in the middle of a different topic, without giving the answer first.
- [Domains](Domains/): Larger subjects that need explanation, scenarios, and later retesting. Interleave these with new interview topics; do not stay in one domain for too long.

In live interviews (updated 2026-10-15): send batches of 2–3 discussion questions, or 8–10 short/MCQ questions, across different topics. Evaluate briefly, explain gaps immediately, update the relevant notes, then rotate. Explain an unclear scenario before scoring it. Problem-solving practice is handled in another chat. Assess confidence separately and avoid assuming every conversational hedge signals low confidence. Revisit small terms often and larger domains periodically. Mark a gap as improved when answered correctly on a later recall; do not silently delete its history. LangChain/LangGraph are future study topics, not yet assessed.

## 2026-10-21 interview follow-up

- [Java comparators and complexity](Terminology/Java-Comparators-and-Complexity.md): syntax, ordering signs, method references, sorting versus minimum selection.
- [Worker assignment and scheduling](Domains/Worker-Assignment-and-Scheduling.md): recalled requirements, explicit reconstruction, cost versus day-count objectives, and Java 8 practice code.
- Main worked notes: [notes.md](../notes.md).
- The 2026-10-21 pause is historical; check the current schedule before referring to reminders. No new score is inferred from reading an explanation.

## 2026-10-25 follow-up

- [Hands-on gaps](Hands-On/): one manual lab at a time. [PostgreSQL EXPLAIN/index](Hands-On/PostgreSQL-Explain-Index-Lab.md) and [JVM heap diagnostics](Hands-On/JVM-Heap-Diagnostics-Lab.md).
- [Database indexes and query plans](Domains/Database-Indexes-and-Query-Plans.md): index fundamentals, composite key, planner evidence.
- [Java records and JPA projections](Domains/Java-Records-and-JPA-Projections.md): shallow immutability and count-only query shape.
- [Interview precision and retry terminology](Terminology/Interview-Precision-and-Retry.md): nbf, idempotency key, concise technical phrasing.
- Revisit object-oriented design patterns (including Strategy) and microservice patterns (Saga, outbox) through short scenario questions. Do not mark them mastered from an explanation.
- Historical checkpoint superseded by the 27 October review below. Questions 11–19 have since been discussed; explanations are not proof of independent recall.

## 2026-10-27 follow-up

- [Questions 15–24 review](Domains/Interview-Review-2026-10-27.md): answers, corrections, confidence and retests; sentinel ambiguity, sets, comparators, Strategy, negative maximum, lost updates/isolation, direct uploads, pagination and per-project numbering.
- [Migration ownership story](Domains/Migration-Ownership-Story.md): concise draft with evidence limits and technical corrections to the supplied wiki.
- [Backend terminology recall](Terminology/Backend-Recall-2026-10-27.md): small MCQ recall targets.
- Current scheduled format: four Cairo prompts daily; 08:00/16:00 MCQ recall, 12:00/20:00 discussion; morning email exam retained with more MCQs. Include new topics alongside retests. MCQ was the user's correction, not MCP.
- Correct prior assessment: Habiba's HashSet first-repeat algorithm is valid under the stated contract; ambiguity concerns using -1 both as data and absence. Her earlier JPA answer intended a native aggregate projection, not fetching all tasks.
