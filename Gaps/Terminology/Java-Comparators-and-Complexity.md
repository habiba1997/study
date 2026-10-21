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

Teach forgotten terms briefly before retesting. Keep correctness separate from confidence. No automatic reminders: Java Interview Practice was paused at Habiba's request on 2026-10-21.

Explanation and code: [notes.md](../../notes.md#2026-10-21--workers-interview-follow-up).
