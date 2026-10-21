# Worker assignment and scheduling

Reported: 2026-10-21. Status: original requirements incomplete; reconstructed exercise below is NOT an exact transcript.

## Remembered facts

- A Workers class has email, integer cost, and List<String> trades.
- One task asks for the email of the cheapest worker capable of one trade.
- Another takes several trades and returns List<List<String>>.
- The outer list apparently represents days.
- A worker cannot perform multiple trades on the same day.
- Habiba did not finish this question and does not recall the exact objective or output mapping.

Do not label inability to reconstruct the specification as proof that she cannot solve assignment problems.

## Why days can appear without a day field

The algorithm can construct a schedule. Index 0 of the outer list represents day 1, index 1 day 2, etc. No date field is needed if only relative day groups are requested. Calendar dates, availability, task durations, and deadlines would require additional inputs.

## Missing requirements that change the answer

- Does each trade entry represent one job requiring one worker, or is a crew required?
- Do repeated trade names represent multiple jobs?
- Is cost per job, per day, or a one-time hiring fee?
- Is the objective minimum total cost, minimum days, or days first and cost second?
- Is there a fixed deadline or maximum number of days?
- May a worker be reused on later days?
- Are jobs independent, or must the input order/dependencies be respected?
- What if a trade has no qualified worker?
- Do inner strings hold emails, trades, or formatted assignments? How is each worker mapped back to a requested job?

In an interview, state the contract back and ask the highest-impact clarification before coding.

## Concrete example

| Worker email | Cost per one-day job | Trades |
| --- | ---: | --- |
| ali@example.com | 40 | plumbing, electrical |
| mona@example.com | 50 | plumbing |

Requested jobs: [plumbing, electrical].

Cheapest total cost, if unlimited days are allowed:
- Day 1: Ali does plumbing.
- Day 2: Ali does electrical.
- Cost = 80.
- Email-only result: [[ali@example.com], [ali@example.com]].

Fewest days:
- Day 1: Mona does plumbing; Ali does electrical.
- Cost = 90.
- Email-only result: [[mona@example.com, ali@example.com]].

Both obey "one job per worker per day." The optimization goal decides which is preferable.

## Reconstructed exercise A: minimize total cost with unlimited days

Assumptions:
1. Every requested trade occurrence is an independent one-day job requiring one worker.
2. Workers can return on later days and are available every day.
3. Cost is charged per assigned job, with no startup charges or daily overhead.
4. No limit on days, no dependencies, and no penalty for taking more days.
5. Inputs and fields are non-null; worker emails uniquely identify workers.
6. Costs are nonnegative; comparisons and arithmetic use the supplied cost values.
7. Unknown trades cause IllegalArgumentException. Ties use alphabetical email as an explicit practice policy.

Algorithm:
- For each requested job, independently choose its cheapest qualified worker.
- Place it on that worker's next unused day.
- A different worker can be assigned on the same day.
- Keep an email -> next day index map.

This minimizes total cost under these assumptions: every job is assigned its individual cheapest worker, and unlimited days remove cross-job capacity conflicts. It does not promise the fewest days among all minimum-cost solutions, especially when ties exist.

### Java 8 implementation

Methods go inside a containing class; import java.util.*.
Workers supplies getEmail(), getCost(), and getTrades().

```java
static List<List<String>> scheduleCheapest(
        List<Workers> workers, List<String> requestedTrades) {

    Comparator<Workers> cheapestFirst =
        Comparator.comparingInt(Workers::getCost)
                  .thenComparing(Workers::getEmail);

    Map<String, Integer> nextDayByEmail = new HashMap<>();
    List<List<String>> days = new ArrayList<>();

    for (String trade : requestedTrades) {
        Workers worker = workers.stream()
            .filter(w -> w.getTrades().contains(trade))
            .min(cheapestFirst)
            .orElseThrow(() ->
                new IllegalArgumentException("No worker for trade: " + trade));

        String email = worker.getEmail();
        int day = nextDayByEmail.getOrDefault(email, 0);

        while (days.size() <= day) {
            days.add(new ArrayList<>());
        }

        days.get(day).add(email);
        nextDayByEmail.put(email, day + 1);
    }

    return days;
}
```

With k jobs, n workers, and at most t trades per worker, selection costs O(k * n * t), treating string comparison lengths as bounded. Grouping adds expected O(k), and storing the output needs O(k) space. Repeated-trade lookups can be cached or a cheapest-worker-by-trade index can be built once.

Email-only output cannot fully describe which job each worker does, especially with repeated trades or reshuffled jobs. For a real API, an Assignment(jobIndex, trade, workerEmail) object would preserve this mapping, but do not change an interview's required return type without agreement.

## Reconstructed exercise B: fixed days or minimum completion time

Independent cheapest selection is insufficient. Workers and jobs compete for same-day capacity. This leads to assignment / bipartite matching; costs add a weighted assignment objective. For only a handful of workers, backtracking can be an understandable exact starting point, with pruning and a clearly stated objective.

A greedy "cheapest available worker for each trade" approach can fail. Add sami@example.com at cost 200 for electrical to the table above. In one day:
- Greedy plumbing first: Ali for 40, then Sami for 200 -> 240.
- Better: Mona for plumbing at 50, Ali for electrical at 40 -> 90.

This example shows why a locally cheapest decision need not minimize the total.

## Later practice

- Reconstruct requirements before solving.
- Explain why List<List<String>> can represent days.
- Walk through exercise A by hand, including repeated trades.
- Explain how cheapest total cost differs from fewest days.
- Find a counterexample to cheapest-available-first greedy assignment.
- Only then study small backtracking and matching examples.

Teach first, then retest. No scores or mastery percentage yet. Scheduled interviews remain paused.
