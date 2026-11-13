# Valeo exam follow-up: practice gaps (2026-11-13)

Source: [exam question bank](../../Interview-Exams/Valeo-Babelio-2026-11-13.md). These are **unverified study targets** because most prompts were not answered. Do not score them or mark them mastered from reading the answer key. The FizzBuzz and SQL screenshots do show attempts; use their concrete errors below, then retest independently.

## Primary interview gaps to check

1. **Algorithm complexity and data structures:** nested-loop sums, logarithmic loops, Big O upper bound, deque end operations, binary-search invariants, tree traversals and leaf-count reasoning. Ask for the reason, not only the option.
2. **REST and URI design:** client-server separation, resource URIs and HTTP methods, cache headers, HTTPS/security, redirects and URI stability. Probe the difference between a useful design convention and an absolute rule.
3. **SQL reasoning:** anti-join/`NOT EXISTS` for “never,” independent aggregation for “how many before,” `LEFT JOIN` for zero counts, `WHERE` versus `HAVING`, grouping by invoice, and temporal columns.
4. **OOP/design patterns:** distinguish Decorator from Composite, Facade and Flyweight; separate OOP concepts from platform properties.
5. **Frontend fundamentals:** HTML semantics, mailto/URL encoding, CSS direct child versus descendant, closures and range boundaries. Lower priority than algorithms and SQL for a principal backend interview unless the role expects full stack work.

## Problem-solving gaps to practice by hand

- **FizzBuzz:** The attempted code tested `n % 3` and `n % 5` within the loop, causing the same result every iteration, and repeated the divisible-by-3 check for Buzz. Retest with `n=16` and explain `i` versus `n`.
- **Sliding window:** Implement unique-character substring count in O(n); explain why each right endpoint contributes the window length and choose a safe result type.
- **Binary search:** State the invariant and correct both the left-branch bounds and base case.
- **String construction:** Derive the 30-point solution and verify minimum operations with prefix DP.
- **SQL invoice task:** The attempted join/group query filtered individual contacts and grouped by contact ID. It cannot establish that the creator **never** contacted the customer and can fragment counts. Write the `NOT EXISTS` plus earlier-contact `LEFT JOIN` query from scratch, then test no contacts, creator contact after invoice, and multiple earlier contacts.
- **JavaScript closure:** Implement the returned verifier and test below, both inclusive boundaries, and above.

## Retest protocol

Ask one item at a time without revealing the key. Record the user's answer, date, confidence, and exact correction in the existing progress log. Keep unanswered items as `unassessed`; after two independent answers, use the repository's scoring convention. The question bank is a reference for review after each attempt.
