# Comparable, Comparator and streams: hands-on sorting

Reported: 2026-11-06. Priority: important. Status: open — awaiting independent implementation.

## Gap and learning approach

Habiba understands the current Comparable explanation, but needs to write it herself to retain it. Creating a Comparator, using comparing/comparingInt, reversing it, and passing it to sort or stream.sorted need more hands-on practice. Understanding an explanation is not mastery.

Work through one task at a time. Write each solution yourself before requesting an example or review. Start without streams, then write the equivalent stream version. Use loops to print and check results if preferred. No completed solutions are included here.

## Setup

Create a User class with constructor and getters for int id, String email, and int age. Use these fictional users, in this input order:

| id | email | age |
|---|---|---|
| 1 | sara@example.com | 30 |
| 2 | ahmed@example.com | 25 |
| 3 | mona@example.com | 30 |
| 4 | basma@example.com | 20 |

Use a fresh mutable ArrayList for each exercise. Assume non-null users and fields, and case-sensitive email ordering.

## Task 1 — Implement Comparable yourself

- [ ] Make User implement Comparable<User>, with email ascending as its natural order.
- [ ] Before running, predict the signs of user1.compareTo(user2), user2.compareTo(user1), and user1.compareTo(user1). Explain this and other.
- [ ] Sort using Collections.sort; expected IDs: 2, 4, 3, 1.
- [ ] Reverse natural order without editing compareTo; expected IDs: 1, 3, 4, 2.
- [ ] Repeat both sorts with stream.sorted, saving the results in separate lists.

Explain why a negative comparison means “this comes before other,” rather than always “my numeric field is smaller.”

## Task 2 — Create an external Comparator

Use a second version of User that does NOT implement Comparable.

- [ ] Write an email comparator as an explicit Comparator<User> implementation with compare(a, b).
- [ ] Rewrite it as a two-argument lambda.
- [ ] Rewrite it using Comparator.comparing and a getter lambda.
- [ ] Rewrite the getter lambda as a method reference.
- [ ] Use List.sort for ascending and descending email.
- [ ] Use stream.sorted for the same two results.

Expected IDs are the same as task 1. Explain what comparing receives, what Comparator it produces, and why sorted() without a comparator cannot naturally sort these non-Comparable users.

## Task 3 — Numeric sorting and tie-breakers

- [ ] Create an age comparator using comparingInt.
- [ ] Sort age ascending, then email ascending: expected IDs 4, 2, 3, 1.
- [ ] Sort age descending, but keep email ascending for ties: expected IDs 3, 1, 2, 4.
- [ ] Implement both requirements with List.sort and stream.sorted.
- [ ] Compare reversing only the age comparator with reversing the complete age-and-email comparator. Predict the difference before running.
- [ ] Explain why Integer.compare is safer than subtraction for integer comparisons.

## Task 4 — Apply the same rules to orders

Create Order with int id, String customerEmail, int totalCents, and boolean paid.

| id | customerEmail | totalCents | paid |
|---|---|---|---|
| 101 | sara@example.com | 5000 | true |
| 102 | ahmed@example.com | 2500 | false |
| 103 | mona@example.com | 5000 | true |
| 104 | basma@example.com | 2000 | true |

- [ ] Select paid orders, sort totalCents descending and customerEmail ascending for ties, and return their IDs.
- [ ] First use a for loop to filter, List.sort to order, and another loop to collect IDs.
- [ ] Then write the equivalent filter → sorted → map → toList stream pipeline.
- [ ] Expected IDs: 103, 101, 104.
- [ ] Optional second pass: sort paid orders by email ascending, then descending.

## Task 5 — Verify mutation and repeat from memory

- [ ] Print original and resulting lists before/after List.sort and stream.sorted; explain which changes the original list.
- [ ] On Java 16+, try adding to the result of Stream.toList() and explain the outcome; create a mutable result when needed.
- [ ] Check an empty list, a one-user list, and two users with identical emails.
- [ ] Reimplement email sorting and age-descending/email-ascending sorting from a blank file after 2–3 days, without copying.

## Completion criteria

Keep this gap open until the implementations run correctly and Habiba can independently explain Comparable versus Comparator, negative/zero/positive results, ascending versus descending, reversed placement, and sort versus sorted. Track correctness and confidence separately.

Related reference: [Java comparators and complexity](../Terminology/Java-Comparators-and-Complexity.md).
