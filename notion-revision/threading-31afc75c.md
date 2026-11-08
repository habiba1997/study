# Threading

Source: https://app.notion.com/p/31afc75cbbd980afae3be7526930f616?pvs=204

<image source="notion-file-block://31afc75c-bbd9-803b-bc73-e27491a09efa/36c3a155-c3da-4f76-9cfb-153dc2b77adb?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

The relationship between <b>JVM memory, threads, and the underlying hardware memory model (CPU caches and RAM)</b> in a multithreaded system.

- Each <b>thread has its own stack</b>, which contains <b>local variables and object references</b>. These stacks are <b>not shared</b> between threads.
- <b>Objects themselves live in the shared heap</b>, which is accessible by all threads. Multiple threads can hold references to the same heap objects.
- At the hardware level, each <b>CPU core has its own registers and caches</b>, which temporarily store copies of data from <b>main memory (RAM)</b> for performance.
- When threads run on different CPUs, they may operate on <b>cached copies of shared data</b>, which can lead to <b>visibility and ordering issues</b> if updates are not synchronized.
- Concurrency constructs (e.g., synchronization, volatile) ensure that <b>changes made by one thread become visible to others by coordinating cache and main memory interactions</b>.

### Visibility Problem

Occurs when <b>one thread updates a variable but other threads do not see the updated value</b> because they read a <b>cached/stale value</b>.

### Race Condition

Occurs when <b>multiple threads modify shared data concurrently</b>, and the <b>final result depends on execution order</b>.

<b>Example</b>

```java
count++;// read -> modify -> write
```

Two threads can produce the <b>wrong result</b>.

Fix: <code>synchronized</code>, <code>AtomicInteger</code>, locks.

### <code>volatile</code>

<b>What it does</b>

- Guarantees <b>visibility</b> between threads.
- A write by one thread is <b>immediately visible</b> to other threads.
- <b>No locking</b> and <b>no atomicity</b> for compound operations.

<b>Atomicity</b> means an operation is <b>executed completely as a single indivisible step</b> — no other thread can see it <b>half-done</b>.

### <code>synchronized</code>

<b>What it does</b>

- Provides <b>mutual exclusion (locking)</b>.
- Ensures <b>only one thread executes the block at a time</b>.
- Also guarantees <b>visibility</b> of shared variables.

```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;   // atomic because of lock
    }

    public synchronized int get() {
        return count;
    }
}
```

Multiple threads calling <code>increment()</code> cannot run it simultaneously, preventing <b>race conditions</b>.

- Use <b><code>volatile</code></b> for <b>simple flags / state indicators</b>.
- Use <b><code>synchronized</code></b> when <b>multiple operations must be atomic</b>. ⚙️
  ### Atomicity (What it means)

<b>Atomicity</b> means an operation is <b>executed completely as a single indivisible step</b> — no other thread can see it <b>half-done</b>.

Example:

```txt
count++;
```

This <b>looks like one operation</b>, but it is actually <b>3 steps</b>:

1. Read <code>count</code>
2. Add <code>1</code>
3. Write the new value

If two threads interleave these steps → <b>race condition</b>.

Atomic operation example:

```java
Atomic Integercount = new AtomicInteger(0);
count.incrementAndGet();
```

Here the JVM uses <b>CAS (Compare-And-Swap)</b> so the whole operation happens <b>as one atomic step</b>.

---

### Why <code>volatile</code> has <b>no atomicity</b>

<code>volatile</code> only guarantees <b>visibility</b>, meaning threads always read the <b>latest value from memory</b>.

Example:

```java
volatile int count=0;

count++;// still not atomic
```

Two threads can still interleave the <b>read → modify → write</b> steps.

So <code>volatile</code> <b>does not prevent race conditions</b>.

Threads can <b>read/write simultaneously</b>.

No lock → <b>no blocking</b>, but also <b>no protection from concurrent modification</b>.

### Example

```java
class Counter {
intcount=0;

void increment() {
count++; // not atomic
    }
}
```

Two threads call <code>increment()</code> when <code>count = 0</code>.

Actual steps of <code>count++</code>:

1. Read <code>count</code>
2. Add 1
3. Write back

Possible execution:

```txt
Thread1 reads 0
Thread2 reads 0
Thread1 writes 1
Thread2 writes 1
```

<b>Final value = 1 (incorrect)</b>

Expected value = <b>2</b>

### Fix

Use <b>synchronization</b> to make it atomic.

### <code>volatile</code> vs <code>synchronized</code> vs <code>Atomic</code> (Java)

| Feature | <code>volatile</code> | <code>synchronized</code> | <code>Atomic</code> classes |
| --- | --- | --- | --- |
| Visibility between threads | ✅ | ✅ | ✅ |
| Atomic operations | ❌ | ✅ | ✅ |
| Locking | ❌ | ✅ | ❌ |
| Performance | Fast | Slowest | Fast |
| Use case | Flags/state | Critical sections | Lock-free counters |

### <code>Atomic</code> Classes (<code>AtomicInteger</code>, etc.)

Provide <b>lock-free atomic operations using CAS (Compare-And-Swap)</b>.

```java
import java.util.concurrent.atomic.AtomicInteger;

AtomicInteger count=new AtomicInteger(0);

count.incrementAndGet();
```

✅ <b>Thread-safe without locking</b>

✅ Faster than <code>synchronized</code> for simple operations.

Atomic classes avoid locks by using <b>CAS (Compare-And-Swap)</b>, a <b>hardware CPU instruction</b> that makes the operation <b>atomic</b>.

<image source="notion-file-block://325fc75c-bbd9-8096-ad91-e2e34ed15599/211dccbd-7c4b-4675-a91b-e9902cdf4223?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

Internally it works like this:

```txt
1. Read current value
2. Compute new value
3. CAS(expectedValue, newValue)
```

CAS means: → Try to update it <b>only if it hasn’t changed</b>

If another thread changed it → <b>operation fails</b><br /> Retry with the new value

```txt
if (currentValue == expectedValue)
    update to newValue
else
    retry
```

So if two threads try:

```txt
Thread1 reads 0
Thread2 reads 0
Thread1 CAS(0 → 1) ✓ success
Thread2 CAS(0 → 1) ✗ fails because value is now 1
Thread2 retries with new value
```

Final result becomes <b>2</b>, not <b>1</b>.

it uses <b>optimistic concurrency</b>:

- Try update
- If conflict → retry

No waiting for locks → <b>better performance under contention</b>.

<page url="https://app.notion.com/p/325fc75cbbd980d2b874fa702572daca">
ThreadPoolExecutor
</page>

<page url="https://app.notion.com/p/325fc75cbbd9803c97f9dc59c4611a7f">
Threading Vs Job Execution
</page>
