# Java comparators and complexity

Reported: 2026-10-21. Status: explained in notes; awaiting independent recall.

Habiba can describe filtering workers by trade and selecting the cheapest, but reported forgetting how to write a Comparator and uncertainty about sorting time complexity.

## Terms to recall

- Comparator<T>: comparison rule for two objects.
- compare(a, b): negative = a before b, zero = equal rank, positive = a after b.
- Ascending: smaller cost first. Descending: larger cost first.
- Lambda: (a, b) -> Integer.compare(a.getCost(), b.getCost()).
- Method reference: Workers::getCost.
- Comparator.comparingInt(Workers::getCost).
- reversed(): reverse comparison order.
- thenComparing(): resolve ties by another property.
- min(): select a minimum without fully sorting.
- Time complexity / Big O: O(n), O(n log n), and costs of sequential stages.
- Optional.empty(): no matching result.

## Later short checks — do not ask all at once

1. If compare(a, b) is negative, which comes first?
2. Write a comparator for ascending worker cost without subtraction.
3. Reverse it; then add an email tie-breaker.
4. What does Workers::getCost mean here?
5. What is the ordinary worst-case time cost of sorting m matches?
6. If only the cheapest worker is needed, which stream terminal operation avoids sorting?
7. If each worker has a List of t trades, what is the filtering cost?
8. What should happen when no worker matches?

Teach forgotten terms briefly before retesting. Keep correctness separate from confidence. The old pause note was historical; use the current interview-practice schedule if it is active.

## 2026-10-25 additions: overflow, min, Optional, and sorting

- Do not implement ascending comparison with `a.getCost() - b.getCost()`. Java `int` wraps on overflow: `Integer.MAX_VALUE - (-1)` becomes `Integer.MIN_VALUE`, wrongly reporting the positive cost as smaller. Use `Integer.compare(a.getCost(), b.getCost())` or `Comparator.comparingInt(Workers::getCost)`.
- After filtering qualified workers, `.min(Comparator.comparingInt(Workers::getCost).thenComparing(Workers::getEmail))` scans candidates to select the cheapest and uses alphabetical email to resolve a cost tie. `min` returns `Optional<Workers>`; no match gives `Optional.empty()`, requiring an agreed no-match behavior (e.g., `orElseThrow`). Reported as a gap, not yet mastered.
- For m matching workers, sorting them costs ordinarily `O(m log m)` and selection by `min` costs `O(m)`. Filtering n workers with a list of t trades each can cost `O(n*t)`; the total is `O(n*t + m log m)` vs `O(n*t + m)`. `O(n log n)` and the expression `n log n` describe the same growth rate; the `O(...)` is the asymptotic-notation wrapper. Never call sorting merely `O(n)` because filtering was linear. The exact interviewer wording was not remembered, so retest this distinction without attributing a precise claim.
- Spaced recall (one at a time): (a) Find overflow in a subtraction comparator with extreme int costs and fix it. (b) Write cheapest qualified worker with `min`, alphabetical email tie, and no-match handling. (c) Give sorting vs `min` costs and distinguish n from matching m.

Explanation and code: [notes.md](../../notes.md#2026-10-21--workers-interview-follow-up).
