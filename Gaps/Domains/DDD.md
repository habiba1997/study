# Domain-Driven Design (DDD) — domain gap

_Last noted: 2026-10-15_

**Status:** Habiba explicitly reports this as a large gap and says the concepts and terminology do not stick. This is a self-reported study gap, not yet assessed by interview questions.

## Explore gradually

- Domain, subdomain, core domain, and why boundaries matter.
- Bounded context: a model and language with a defined boundary; the same word (for example, Customer) can mean different things in different contexts.
- Ubiquitous language with domain experts.
- Entity versus value object; aggregate and aggregate root; invariants and transaction boundaries.
- Context mapping and integration between bounded contexts.
- Relationship between DDD boundaries and service boundaries; they are not automatically one-to-one.

## Interview prompts (one at a time, increasing difficulty)

1. Why might "Customer" mean different things in Payments and Support? Name the DDD concept.
2. What is a bounded context in one sentence?
3. A Money object is identified by amount and currency, rather than an ID. Entity or value object? Why?
4. An order must never contain a negative total. Which object should enforce the invariant, and why?
5. Would you make each DDD bounded context a separate microservice? Explain the tradeoff.

After each answer, record the actual gap and a short recall cue; do not assume all items above are weak.

## 2026-10-15 interview observation

On Payments versus Support using `Customer` differently, Habiba recalled **ubiquitous language** tentatively. That is related: language is shared and precise *within* a boundary. The boundary and model scope are called a **bounded context**. This was appropriately hedged, rather than a confidently wrong answer. Recall prompt after rotating topics: “What is the DDD term for the boundary in which Customer has one specific meaning?”

## 2026-10-15 retest

Correctly recalled **bounded context** and related it to ubiquitous language. Small precision gap: a bounded context is not necessarily a separate service. Test this distinction with a new scenario later.
