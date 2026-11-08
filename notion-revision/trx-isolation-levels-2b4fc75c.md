# Trx Isolation Levels

Source: https://app.notion.com/p/2b4fc75cbbd9808b8bf9ebb7fa18bd9a?pvs=204

<p>
<b>Isolation</b> controls the visibility of changes made by one transaction to other concurrent transactions. 
</p>

## The 5 Isolation Levels in Spring

### 1. <b>DEFAULT</b>

- Uses the database's default isolation level
- Example: MySQL's default is <code>REPEATABLE_READ</code>
- To check your database default: <code>SHOW VARIABLES LIKE 'transaction_isolation'</code>
- To override: <code>SET SESSION TRANSACTION ISOLATION LEVEL [level_name]</code>

### 2. <b>READ\_UNCOMMITTED</b>

<b>Problem it allows:</b> Dirty Reads

- Allows reading uncommitted changes from other transactions
- <b>Real-world example:</b> Movie ticket booking where User A selects tickets but hasn't paid yet, User B sees "no tickets available" even though A might cancel
- <b>Code behavior:</b> Transaction A updates stock from 50 to 5 (uncommitted) → Transaction B reads 5 → If A rolls back, B has incorrect data
- <b>When to avoid:</b> Most real-world scenarios (causes data inconsistency)

### 3. <b>READ\_COMMITTED</b>

<b>Problems it prevents:</b> Dirty Reads<br /><b>Problem it still has:</b> Non-repeatable reads

- Only reads committed data from other transactions
- <b>Behavior:</b> Transaction B will only see the original value (50) until Transaction A commits
- <b>Issue:</b> If Transaction B reads twice, it might get different values (50 first, then 10 after commit)
- <b>Common use:</b> Default for many applications, good balance of consistency and performance

### 4. <b>REPEATABLE\_READ</b>

<b>Problems it prevents:</b> Dirty Reads + Non-repeatable Reads<br /><b>Problem it still has:</b> Phantom Reads

- Ensures consistent reads within a transaction
- <b>Behavior:</b> If Transaction B reads the same data multiple times, it sees the same value throughout its lifecycle
- <b>Example:</b> Transaction B reads stock as 40 twice, even if Transaction A updates to 5 in between
- <b>Use case:</b> When you need consistent snapshot of data during transaction processing

### 5. <b>SERIALIZABLE</b>

<b>Prevents:</b> All concurrency issues (Dirty Reads, Non-repeatable Reads, Phantom Reads)

- Forces transactions to execute sequentially (one after another)
- Applies locking mechanism - Transaction B waits until Transaction A completes
- <b>Trade-off:</b> Best consistency but worst performance
- <b>Use case:</b> Critical operations like payment processing, seat/ticket booking

## Implementation in Spring Boot

java

<code>@Transactional(isolation = Isolation.READ_COMMITTED)
public void updateStock(Long productId, int quantity) {
    </code><i><code>// Your code here</code></i><code>
}</code>

## Problem Types Explained

1. <b>Dirty Read</b>: Reading uncommitted changes that might be rolled back
2. <b>Non-repeatable Read</b>: Getting different values when reading the same data twice in a transaction
3. <b>Phantom Read</b>: New rows appearing/disappearing between reads in a transaction

## Quick Reference Table

```txt
Isolation LevelDirty ReadNon-repeatable ReadPhantom ReadPerformanceREAD_UNCOMMITTEDYesYesYesBestREAD_COMMITTEDNoYesYesGoodREPEATABLE_READNoNoYesFairSERIALIZABLENoNoNoPoor
```

## Key Takeaways for Junior Developers

1. <b>Start with READ\_COMMITTED</b> - It's a safe default for most applications
2. <b>Use REPEATABLE\_READ</b> when you need consistent data throughout a transaction
3. <b>Use SERIALIZABLE</b> only for critical operations where data integrity is paramount (e.g., financial transactions, booking systems)
4. <b>Avoid READ\_UNCOMMITTED</b> in production - it's mainly for special read-only reporting scenarios
5. <b>Test with concurrent threads</b> to understand isolation behavior in your application
6. <b>Consider performance implications</b> - Higher isolation = Better consistency but Lower performance

## Testing Tip

Create multiple threads to simulate concurrent transactions:

java

<code>Thread transactionA = new Thread(() -> updateStock(productId, 5));
Thread transactionB = new Thread(() -> checkStock(productId));</code>

## Real-World Application

- <b>E-commerce inventory</b>: READ\_COMMITTED or REPEATABLE\_READ
- <b>Banking transactions</b>: SERIALIZABLE
- <b>Flight/Movie ticket booking</b>: SERIALIZABLE
- <b>Analytics/Reporting (read-only)</b>: READ\_UNCOMMITTED (sometimes acceptable)

Remember: The choice of isolation level is a trade-off between data consistency and system performance. Always test your specific use case with concurrent transactions to ensure the chosen level meets your requirements.
