# Concurrency

Source: https://app.notion.com/p/378fc75cbbd9805a961dfeae9a59f767?pvs=204

- <b><code>volatile</code></b><b> = a live TV broadcast</b>: everyone sees the same thing at the same moment, but anyone can shout over it. (Visible to all, but no exclusion.)
- <b><code>synchronized</code></b><b> = a phone booth with one key</b>: only one person inside, and when they walk out everything they did is announced. (Exclusion + visibility.)

Thread Vs Process: Heap-shared/stack-unique is right. Missed: same JVM = same OS process (not same laptop). Threads also share metaspace, file descriptors, sockets. Each thread has its own PC register + native stack too.

## <b><code>Lock</code></b><b> / </b><b><code>ReentrantLock</code></b><b> — </b><b><code>synchronized</code></b><b> with superpowers</b>

<code>synchronized</code> is a hammer. <code>Lock</code> is a Swiss army knife.

```java
Lock lock = new ReentrantLock();

lock.lock();

try {

*// critical section*

} finally {

lock.unlock();  *// MUST be in finally*

}
```

<b>Why bother over </b><b><code>synchronized</code></b><b>?</b>

| <b>Feature</b> | <b><code>synchronized</code></b> | <b><code>ReentrantLock</code></b> |
| --- | --- | --- |
| Try lock without blocking | ❌ | ✅ <code>tryLock()</code> |
| Try with timeout | ❌ | ✅ <code>tryLock(5, SECONDS)</code> |
| Interruptible while waiting | ❌ | ✅ <code>lockInterruptibly()</code> |
| Fair (FIFO) ordering | ❌ | ✅ <code>new ReentrantLock(true)</code> |
| Multiple condition variables | ❌ | ✅ <code>lock.newCondition()</code> |

<b>Rule of thumb</b>: use <code>synchronized</code> by default. Reach for <code>ReentrantLock</code> only when you need one of the features above.

---

## <b>2. </b><b><code>ReadWriteLock</code></b><b> — many readers, one writer</b>

A normal lock serializes everything. But many real workloads are <b>read-heavy</b> (think: config, cache, session map). Why force readers to wait on each other?

```java
ReadWriteLock rw = new ReentrantReadWriteLock();

rw.readLock().lock();    *// many threads can hold this at once*

try { return map.get(k); } finally { rw.readLock().unlock(); }

rw.writeLock().lock();   *// exclusive — blocks all readers AND writers*

try { map.put(k, v); } finally { rw.writeLock().unlock(); }
```

<b>Metaphor</b>: a whiteboard in a meeting room. Anyone can read it together. To erase/write, you kick everyone out, write, then let them back in.

⚠️ Caveat: <code>ConcurrentHashMap</code> is usually faster than <code>HashMap + ReadWriteLock</code>. Use <code>ReadWriteLock</code> for <i>custom</i> data structures you build yourself.

## <b><code>Semaphore</code></b><b> — limit concurrent access to N</b>

A lock = "1 person at a time". A semaphore = "up to N people at a time".

Semaphore connections = new Semaphore(10); <i>// max 10 concurrent DB connections</i>

connections.acquire();   <i>// blocks if 10 already out</i>

```java
try {

db.query(...);

} finally {

connections.release();

}
```

# Virtual Threads (Java 21+)

Virtual threads are <b>lightweight threads managed mostly by the JVM</b>, not directly by the operating system.

Before Java 21:

```txt
Threadt=newThread(() ->doWork());
t.start();
```

Each Java thread typically mapped to an OS thread.

Creating thousands of threads was expensive because:

- Memory usage was high.
- OS scheduling was expensive.
- Context switching was expensive.

---

## Virtual Thread Example

```txt
Thread.startVirtualThread(() -> {
System.out.println("Hello");
});
```

<p>
Virtal threads are from java 21+ changes, and are not on by deafult when using spring boot, and tomcat. 
</p>

```java
CPU Core
   ↑
OS Thread (native thread)
   ↑
Java Platform Thread
   ↑
Java Virtual Thread (optional)
```

### Traditional Spring Boot + Tomcat

By default, Tomcat's thread pool contains <b>platform threads</b>.

Example:

```txt
HTTP Request A -> Tomcat Thread 1
HTTP Request B -> Tomcat Thread 2
HTTP Request C -> Tomcat Thread 3
```

Each Tomcat thread is:

```txt
Java Platform Thread
      ↓
OS Thread
      ↓
CPU schedules it
```

In modern Java (pre-virtual threads):

```txt
Java Thread (platform thread)
        1 : 1
OS Thread (native thread)
```

So:

> Java platform thread == OS thread (almost 1:1 mapping)

There is no “extra layer” scheduling inside Java threads themselves.

<p />

<br />• <code>ConcurrentHashMap</code> → readers don't block each other, writers only lock a tiny segment.
