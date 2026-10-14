# Java & Spring interview cheat sheet

Grouped by topic, ordered basics → advanced. Related terms sit next to each other.
Each entry is a short definition first; the small bullets underneath carry the extra context and follow-up answers.

**⚠️ = your original note needed a correction.** The fix is in that term's bullets. All of them are listed below so you can review them in one pass.

## ⚠️ Corrections — your notes vs. the fix

| Term | What you wrote | The fix |
|---|---|---|
| **`TreeMap` / `LinkedHashMap`** | "Treetop vs linkedhashmap (sorted / insertion sorted)" | The class is **`TreeMap`**, not "Treetop". And `LinkedHashMap` does **not sort** — it remembers insertion order. Add `C, A, B`: TreeMap iterates **A, B, C**; LinkedHashMap iterates **C, A, B**. |
| **Stack vs heap** | "static done in compile time while dynamic does in runtime" | Both allocate at **runtime**. Stack frame *sizes* are known at compile time and freed LIFO; heap size and lifetime are decided at runtime. |
| **Varargs** | "~ spread operator" | Opposites. **Varargs** is on the declaration (`void f(String... names)`). **Spread** is on the call (`f(...arr)`). Java has varargs, not spread. Pass an array as-is: `f(myArray)`. |
| **`record`** | "introduced in Java 14" | Say **Java 17** (previewed 14, final 16). Immutability is **shallow**. |
| **PermGen** | "after java 7 perm gen is not in heap anymore" | PermGen was **removed in Java 8**. Replacement is **Metaspace** in native memory. |
| **`ConcurrentHashMap`** | "writers only lock a tiny segment" | Segment locking was **Java 7**. Since Java 8 it's **per-bin** locking plus CAS. |
| **`CopyOnWriteArrayList`** | "all mutative operations are implemented" (cut off) | …by making a **fresh copy of the entire backing array**. |
| **`@Cacheable`** | used it for Hibernate 2nd-level cache | Two unrelated annotations. **JPA `@Cacheable`** on an **entity** (2nd-level cache). **Spring `@Cacheable`** on a **method** (return-value cache). |
| **`@Formula`** | `lower(datediff(curdate(), birth_date / 365)` | Unbalanced parens / wrong division. Correct: `datediff(curdate(), birth_date) / 365`. |
| **"Advice Controller"** | name | The annotation is **`@ControllerAdvice`** / `@RestControllerAdvice`. |
| **CSRF token storage** | "cookie named XSRF-TOKEN … header X-XSRF-TOKEN" | That's `CookieCsrfTokenRepository` (opt-in). **Default is `HttpSessionCsrfTokenRepository`** — session + `_csrf` / `X-CSRF-TOKEN`. |
| **Mockito stubbing limits** | "doesn't allow stubbing of final, private, or static" | Outdated. `mockStatic()` since Mockito 3.4; inline mock maker (Mockito 5 default) mocks `final`. Only `private` is still out. |
| **`@MockBean`** | current API | Deprecated in Boot 3.4. New: **`@MockitoBean`** / **`@MockitoSpyBean`**. |
| **`@EnableGlobalMethodSecurity`** | current API | Deprecated in Security 6. New: **`@EnableMethodSecurity`**. |
| **`antMatchers` / `WebSecurityConfigurerAdapter`** | Security 5 API | Security 6: `requestMatchers`, `authorizeHttpRequests`, and a `SecurityFilterChain` bean. Adapter is **removed**. |
| **Maven lifecycle** | "clean → validate → compile → …" | **`clean` is a separate lifecycle.** Maven has three: clean, default, site. |
| **Spring Framework 3** | Java 8 / 9 / 17 features listed under SF 3 | Spring 3 was **2009**. Java 8 was **2014**. Those Java features belong under **Java versions**. |

---

## OOP fundamentals

### Encapsulation
Bundling data and the methods that operate on it inside one class, and hiding internal state behind accessors so outside code can't corrupt it.
- Mechanism: `private` fields + `public` getters/setters, or better, immutable objects with no setters.
- Interview follow-up: "encapsulation vs abstraction?" Encapsulation hides *how the data is stored*; abstraction hides *how the work is done*.

### Abstraction
Exposing only what a caller needs to know and hiding the implementation behind an interface or abstract class.
- In Java: `interface` (contract only, multiple inheritance of type) and `abstract class` (partial implementation, single inheritance, can hold state).
- An interface can have `default` and `static` methods (Java 8+) and `private` methods (Java 9+).

### Inheritance
A subclass reuses and extends the state and behaviour of a superclass — an "is-a" relationship.
- Java has single class inheritance, multiple interface inheritance.
- Prefer composition over inheritance when you only want to reuse code, not model an "is-a".

### Polymorphism
One reference type behaving as many actual types, so the same call resolves to different implementations.
- Compile-time (static) polymorphism = **overloading**. Runtime (dynamic) polymorphism = **overriding**.

### Method overloading
Same method name, different parameter list, in the same class. Resolved by the compiler.
- Binding: **static / compile-time binding**. Return type alone is not enough to overload.

### Method overriding
A subclass replaces a superclass method with the same signature. Resolved by the JVM using the actual object type.
- Binding: **dynamic / runtime binding** (virtual method dispatch).
- Rules: can widen visibility, can't narrow it; can't throw broader *checked* exceptions; return type may be covariant.

### Overriding and visibility
When overriding, you may make the access modifier **more** visible, never less.
- Visibility order, least → most: `private` → package-private (default) → `protected` → `public`.
- So a `protected` method can be overridden as `public`, but not as `private`.

### Association
A "has-a" link between two classes that can each exist independently.
- Example: `Library` and `Book` — the library still exists without that particular book.

### Composition
A strong association where the contained object cannot exist without its owner. Owner controls its lifecycle.
- Example: `House` and `Room` — destroy the house, the rooms go with it.
- Aggregation sits between the two: "has-a" with shared ownership, parts survive the whole (`Team` and `Player`).

---

## Java language basics

### Access modifiers
Four levels controlling who can see a class member.
- `private` — same class only.
- **default (package-private)** — same package only. This is the default for classes and methods when you write no modifier.
- `protected` — same package **plus** subclasses in other packages.
- `public` — everywhere.

### `static`
Belongs to the class itself, not to any instance. One copy shared by all instances.
- **Member (instance) variable** = one per object. **Class variable (`static`)** = one per class.
- Static class variables live on the heap, inside the `Class` object.
- `static` applies to fields, methods, nested classes, and initializer blocks — never to local variables.
- Private static methods are the usual home for internal utility logic.

### `final`
Locks something down. Meaning depends on where you put it.
- On a **class** — cannot be extended.
- On a **method** — cannot be overridden.
- On a **field/variable** — cannot be reassigned after initialization (the object it points to can still mutate).

### `transient`
Marks a field to be skipped when the object is serialized. On deserialization it comes back as the type's default (`null`, `0`, `false`).
- Typical use: caches, derived values, passwords, open connections.

### Wrapper vs primitive
Primitives (`int`, `long`, `boolean`, …) are raw values on the stack; wrappers (`Integer`, `Long`, `Boolean`, …) are objects on the heap.
- Only wrappers can go in collections and generics, and only wrappers can be `null`.
- **Autoboxing/unboxing** converts between them automatically — and can throw `NullPointerException` when unboxing a `null`.
- `Integer` caches −128..127, so `Integer.valueOf(100) == Integer.valueOf(100)` is `true` but `127+1` breaks it. Always compare with `.equals()`.

### Varargs ⚠️
`Type... name` lets a method accept any number of arguments; inside the method it's an array.
- Must be the last parameter, and only one per method.
- ⚠️ The original note compared this to the **spread operator**. They're opposites, so the comparison misleads.
- **Varargs is on the declaration** — "this method accepts any number of arguments." JavaScript's equivalent is a **rest** parameter: `function f(...args)`.
- **Spread is on the call** — "take this array and hand it over as separate arguments": `f(...arr)`. **Java has no spread operator.** To pass an existing array to a varargs method, just pass the array.

```java
static void printNames(String... names) { for (String n : names) System.out.println(n); }

printNames("a", "b", "c");                 // pass separate arguments
printNames(new String[]{"a", "b", "c"});   // or pass the array directly — no spread needed
```

### Switch statement
Picks one branch by comparing an expression against constant case labels.
- `default` is optional. `break` is optional (omit it and execution falls through).
- The expression evaluates to **one value**, not a collection.
- Case labels must be compile-time constants — the compiler needs to know them all at compile time.
- Java 14+ adds **switch expressions**: arrow labels, no fall-through, returns a value, and must be exhaustive.

### Anonymous class
A class with no name, declared and instantiated in a single expression. Used for one-off implementations of an interface or subclass.
- Superseded by lambdas for single-method interfaces, but still needed when you implement multiple methods or need state.

```java
Runnable r = new Runnable() { public void run() { System.out.println("hi"); } };
```

### Marker interface
An interface with no methods or fields, used purely to tag a class with a property the runtime or a framework checks for.
- Examples: `Serializable`, `Cloneable`, `RandomAccess`.
- Annotations largely replaced this pattern, but `instanceof` checks on markers are faster than reflection.

### Serialization
Converting an object into a byte stream so it can be stored or sent over a network; deserialization rebuilds it.
- Requires `implements Serializable`. Add a `serialVersionUID` or version drift breaks deserialization.
- Skip fields with `transient`. Never deserialize untrusted input — it's a known remote-code-execution vector.

### `record` ⚠️
A compact, immutable data carrier. You declare the components and the compiler generates the rest.
- Generates: canonical constructor, accessor per component (`x()` not `getX()`), `equals()`, `hashCode()`, `toString()`.
- Fields are `final`, there are no setters, and the class itself is implicitly `final`.
- ⚠️ Version: say **Java 17** (available from 16 onward). The original note said Java 14.
- Immutability is **shallow** — a record holding a `List` can still have that list mutated. Copy defensively if it matters.

```java
record Point(int x, int y) {}
```

### Sealed class
Explicitly controls which classes are allowed to extend a class or implement an interface. Java 17.
- `public sealed class Animal permits Dog, Cat { }` — only `Dog` and `Cat` may extend it.
- Every permitted subclass must declare one of: `final` (no further extension), `sealed` (extendable only by its own permit list), or `non-sealed` (reopens it to anyone).
- Real payoff is **exhaustive pattern matching** — the compiler knows the full set, so a `switch` over it needs no `default`.

```java
switch (payment) {
    case CreditCardPayment p -> ...;
    case CashPayment p       -> ...;
}
```

### `a = x++` vs `a = ++x`
`x++` (post-increment) assigns the old value, then increments. `++x` (pre-increment) increments first, then assigns.
- `int x = 5; int a = x++;` → `a == 5`, `x == 6`.
- `int x = 5; int a = ++x;` → `a == 6`, `x == 6`.

### Reflection
Inspecting and manipulating classes, fields, methods, and constructors at runtime, without knowing them at compile time.
- Powers Spring DI, Jackson, JPA, ModelMapper, Dozer, JUnit.
- Costs: slower than direct calls, breaks compile-time safety, and can be blocked by the module system (Java 9+) or `SecurityManager`.

---

## Exceptions & error handling

### `Throwable` hierarchy
`Throwable` is the root; it splits into `Error` and `Exception`.
- `Error` — serious JVM problems you're not meant to catch: `OutOfMemoryError`, `StackOverflowError`, `NoClassDefFoundError`.
- `Exception` — application problems, split into checked and unchecked.

### Checked exception
An exception the compiler forces you to either catch or declare with `throws`. Also called a **compile-time exception**.
- Everything under `Exception` except `RuntimeException` and its subclasses.
- Examples: `SQLException`, `IOException`, `ClassNotFoundException`.

### Unchecked exception
A `RuntimeException` subclass. The compiler doesn't require handling; it surfaces at runtime.
- Examples: `NullPointerException`, `IllegalArgumentException`, `IndexOutOfBoundsException`, `ArithmeticException`.
- Rule of thumb: unchecked = programming bug, checked = recoverable external condition.

### Resource management
Close every resource you open. Use **try-with-resources**, or a `finally` block if you can't.
- try-with-resources needs `AutoCloseable`, closes in reverse order, and closes even when an exception is thrown.
- `finally` runs whether or not an exception occurred — but a `return` inside it swallows exceptions.

```java
try (var conn = ds.getConnection(); var ps = conn.prepareStatement(sql)) { ... }
```

---

## Collections & hashing

### Collection
The family of data structures that store groups of elements — `List`, `Set`, `Queue`, `Deque` (and `Map`, which sits beside `Collection` rather than under it).
- Contrast with a **Stream**: a collection stores elements, a stream processes them.

### Hash collision
Two different keys hashing to the same bucket. Every hash table needs a strategy for it — separate chaining or open addressing.

### Separate chaining
Each bucket holds a secondary structure (linked list or tree) of all entries that hashed there. Collisions append to that structure.
- This is what Java's `HashMap` does. Since Java 8, a bucket with more than 8 entries converts from a linked list to a red-black tree, so worst-case lookup is O(log n) instead of O(n).
- Handles high load factors gracefully; costs extra memory per node and loses CPU-cache locality.

### Open addressing
No secondary structure — on collision, probe for the next free slot in the same array.
- Probing strategies: **linear** (next slot), **quadratic** (i² away), **double hashing** (second hash decides the step).
- Faster and more cache-friendly than chaining because everything is one contiguous array, but degrades badly past ~70% load factor and deletion needs tombstones.

### `HashMap`
Unordered, non-synchronized map. Average O(1) get/put.
- Iteration order is not guaranteed and can change on resize.
- Non-synchronized means high throughput but no thread safety at all — concurrent writes can corrupt it or infinite-loop older versions.

### `LinkedHashMap`
A `HashMap` that also keeps a doubly-linked list of entries, so iteration follows **insertion order**.
- Can be configured for **access order** instead, which makes it a two-line LRU cache (override `removeEldestEntry`).

### `TreeMap` ⚠️
A red-black tree map that keeps keys in **sorted order** (natural ordering or a supplied `Comparator`). O(log n) operations.
- Implements `NavigableMap`: `firstKey`, `floorKey`, `ceilingKey`, `headMap`, `tailMap`, `subMap`.
- Keys must be comparable, and it rejects `null` keys.
- ⚠️ Two fixes to the original note. The class is **`TreeMap`** (written there as "Treetop"), and `LinkedHashMap` does **not sort** anything.
- The difference made concrete — add `C, A, B` to each, then iterate: **`TreeMap` gives A, B, C** (it sorted them). **`LinkedHashMap` gives C, A, B** (the order you inserted). One sorts, the other remembers.

### `TreeMap` vs `LinkedHashMap` — the one-liner
`TreeMap` = sorted by key, O(log n). `LinkedHashMap` = in the order you put things in, O(1).

---

## Streams & functional Java

### Stream
A pipeline over a sequence of elements supporting functional operations. It processes data pulled from a source; it does not store data.
- **Lazy** — intermediate ops (`filter`, `map`, `sorted`) build the pipeline and do nothing until a terminal op (`collect`, `reduce`, `forEach`, `count`) runs.
- **Single-use** — consume a stream twice and you get `IllegalStateException`.
- **Non-mutating** — it never modifies the source collection.

### `reduce`
A terminal operation that folds all elements of a stream into a single result.
- Three forms: `reduce(accumulator)` → `Optional`; `reduce(identity, accumulator)`; `reduce(identity, accumulator, combiner)` for parallel streams.
- The accumulator must be **associative** or parallel results become non-deterministic.

```java
int sum = nums.stream().reduce(0, Integer::sum);
```

### Parallel stream
A stream that splits its work across multiple CPU cores. Java 8+.
- Runs on the common **ForkJoinPool**, sized to `cores − 1` by default — so one slow parallel stream can starve every other one in the JVM.
- Worth it only for large datasets with CPU-bound, stateless, side-effect-free operations. Avoid for I/O.
- Splits well over `ArrayList` and arrays (O(1) random access makes finding the midpoint free). Splits badly over `LinkedList` (must walk the nodes to find the middle).

### Fork/Join framework
Java 7 framework for splitting a large task into subtasks, running them in parallel across cores, then joining the results. This is what parallel streams run on.
- Signature feature is **work stealing**: a worker that finishes its own queue steals unfinished tasks from a busy worker's queue instead of idling.
- API: extend `RecursiveTask<V>` (returns a value) or `RecursiveAction` (void), and split until a sensible threshold.

### `Optional`
A container that either holds a value or is explicitly empty — a typed alternative to returning `null`. Java 8.
- Use as a **return type**. Don't use it for fields or method parameters.
- `orElse` evaluates its argument eagerly; `orElseGet` takes a supplier and evaluates lazily.
---

## Hardware & memory basics

### CPU (Central Processing Unit)
Executes program instructions — arithmetic, logic, control flow, and I/O operations.

### CPU register
The smallest and fastest storage, physically inside the CPU. Holds the operands the CPU is working on right now.

### CPU cache
Small, fast memory sitting between the registers and RAM. Accessing data from cache is far faster than from RAM.
- Modern CPUs have multiple levels: L1 (smallest/fastest, per core), L2, L3 (largest/slowest, often shared).
- Why it matters for interviews: data structures with good **cache locality** (arrays, `ArrayList`) run much faster than pointer-chasing ones (`LinkedList`) even at the same big-O.

### RAM (Random Access Memory)
Volatile main memory used for temporary storage of data the CPU needs quickly.

### Memory hierarchy — fastest to slowest
CPU registers → CPU cache (L1/L2/L3) → RAM → SSD → spinning hard disk.
- Each step down is roughly an order of magnitude slower and an order of magnitude bigger/cheaper.

### Volatile memory
Memory that loses all its contents when power is cut. RAM is volatile; disk and SSD are not.
- Not the same thing as Java's `volatile` keyword — the shared word is a coincidence worth calling out if an interviewer conflates them.

### Stack memory vs heap memory ⚠️
**Stack** — one per thread. Holds method frames, local variables, and object *references*. Automatically freed when the method returns. `StackOverflowError` when it's exhausted.
**Heap** — shared across all threads. Holds every object and array. Cleaned by the garbage collector. `OutOfMemoryError` when it's exhausted.
- Static class variables also live on the heap (inside the `Class` object).
- ⚠️ The original note said stack is "static, done at compile time" and heap "dynamic, at runtime". Both are allocated at **runtime**. The real distinction: stack frame *sizes* are known at compile time and freed in strict LIFO order, while heap allocation size and lifetime are decided at runtime.

### Thread caching of shared data
Variables referenced from a thread's stack and from the heap can be cached at every level of the memory hierarchy (register ↔ CPU cache ↔ RAM).
- The visibility problem this creates: ThreadA on CPU1 reads a shared object and caches a copy in its register while modifying it. ThreadB on CPU2 reads the same object into its own cache. Each thread now has a private copy, and neither sees the other's change until its CPU flushes to main memory.
- That gap is exactly what `volatile` and `synchronized` exist to close.

---

## JVM memory, GC & diagnostics

### Garbage collection (GC)
The JVM automatically reclaiming memory by finding and disposing of objects no longer reachable from any live thread or static reference.
- Reachability, not reference counting — an island of objects pointing at each other with no external reference is still collected.
- Generational model: young generation (Eden + two survivor spaces) collected often and cheaply; old/tenured generation collected rarely and expensively.

### Memory leak
Objects still present on the heap that the application no longer uses, but which the garbage collector can't remove because something still holds a reference.
- Classic causes: static collections that only ever grow, unclosed resources, listeners never deregistered, `ThreadLocal` in a pooled thread, custom keys with broken `equals`/`hashCode` in a `HashMap`.

### Heap dump
A snapshot of a Java process's heap at a point in time — every object, its fields, and what references it.
- Used to debug memory leaks and `OutOfMemoryError`. Capture with `jmap`, or `-XX:+HeapDumpOnOutOfMemoryError`. Read with Eclipse MAT or VisualVM.

### Thread dump
A snapshot of all threads in a Java process — their names, states, and stack traces.
- Used to diagnose deadlocks, hung requests, and thread-pool starvation. Capture with `jstack` or `kill -3`.

### Profiling
Analysing a running program to find performance bottlenecks, memory usage, and other runtime characteristics — CPU time, allocation rate, method execution times.
- Tools: VisualVM, JProfiler, YourKit, Java Flight Recorder / JDK Mission Control, async-profiler.

### PermGen / Metaspace ⚠️
`OutOfMemoryError: PermGen space` meant the JVM ran out of room in the **Permanent Generation**, which stored class metadata.
- ⚠️ Version: PermGen was **removed in Java 8** (deprecated in 7), not "after Java 7 it moved". Its replacement is **Metaspace**.
- Metaspace lives in **native memory**, not the heap, and grows automatically as needed instead of being fixed at startup — so this error largely disappeared. Cap it with `-XX:MaxMetaspaceSize` if a classloader leak makes it grow forever.

---

## Concurrency & threading

### Thread-safe
Multiple threads can read and modify the same object concurrently without data corruption or inconsistent state.

### `synchronized`
Gives a block or method exclusive access plus a memory-visibility guarantee.
- Mental model: **a phone booth with one key** — only one person inside, and when they walk out everything they did is announced. (Mutual exclusion + visibility.)
- **Method-level** locks the whole method on `this` (or on the `Class` object for a static method). **Block-level** locks only the critical section, on an object you choose — narrower and usually faster.

### Intrinsic lock (monitor lock)
Every Java object carries one built-in lock. Entering a `synchronized` method or block acquires that object's intrinsic lock; leaving releases it.
- It's **reentrant** — a thread already holding the lock can re-acquire it without deadlocking itself.

### `volatile`
Marks a variable as read from and written to main memory directly, never cached in a CPU register — so changes are visible across threads immediately.
- Mental model: **a live TV broadcast** — everyone sees the same thing at the same moment, but anyone can shout over it. Visibility, no mutual exclusion.
- Does **not** make `count++` safe — that's read-modify-write, three operations. Use `AtomicInteger` or `synchronized` for that.

### Atomic variables
Classes like `AtomicInteger`, `AtomicLong`, and `AtomicReference` that give lock-free thread safety on a single variable using low-level machine instructions.
- Built on **compare-and-swap (CAS)**, which takes three inputs: the memory location `M`, the expected existing value `A`, and the new value `B`. It atomically sets `M` to `B` **only if** `M` currently equals `A`; otherwise it does nothing and returns the actual value found.
- CAS collapses get → compare → update into one machine-level operation, so no lock is needed.
- Under heavy contention CAS retries in a loop and can burn CPU — that's where a lock may win.

### `ReentrantLock`
An explicit lock class with more capability than `synchronized`.
- A thread can acquire the same lock repeatedly; a **hold count** increments per `lock()` and decrements per `unlock()`. At zero the lock is released. That's what makes recursive and nested locked calls safe rather than self-deadlocking.
- Extras `synchronized` can't do: `tryLock()` with a timeout, `lockInterruptibly()`, fairness policy, multiple `Condition` objects.
- Must be released in a `finally` block — the compiler won't do it for you.

### `ReadWriteLock`
An interface defining a pair of locks: one for reading, one for writing. `ReentrantReadWriteLock` is the standard implementation.
- Allows **many concurrent readers or one exclusive writer**. Big win on read-heavy data.
- Watch out for writer starvation under constant read load; construct it in fair mode if that's a risk.

### Atomics vs locks — comparison
| | Atomic variables | Locks (e.g. `ReentrantLock`) |
|---|---|---|
| Thread safety | One variable at a time | Complex operations across multiple variables or whole blocks |
| Performance | Generally faster under low contention | Overhead from context switching and contention |
| Blocking | Non-blocking (CAS retry) | Blocking (thread parks) |

### `ConcurrentHashMap` ⚠️
A thread-safe `HashMap` where `put` and `get` are safe without external synchronization.
- Readers never block each other; a writer locks only the single bin it's touching.
- ⚠️ The original note said writers "lock a tiny segment". Segment locking was **Java 7**. Since Java 8 it's per-bin locking on the first node plus CAS — finer-grained than segments. Say "per-bucket" in an interview.
- Compound operations still need care — use `putIfAbsent`, `computeIfAbsent`, `merge` instead of check-then-act.
- Trade-off vs `HashMap`: a plain `HashMap` is non-synchronized so any number of threads run without waiting, giving higher raw throughput. `ConcurrentHashMap` is sometimes slower because threads occasionally have to wait — you're paying for correctness.

### `ConcurrentLinkedQueue`
A thread-safe, non-blocking FIFO queue. Multiple threads can insert, remove, and peek concurrently without blocking.
- Unbounded — grows dynamically with no fixed size limit, so an unchecked producer can exhaust memory.
- `size()` is O(n) and only approximate under concurrent modification.

### `CopyOnWriteArrayList` ⚠️
A thread-safe `ArrayList` where every mutating operation (`add`, `set`, `remove`) creates a **fresh copy of the entire backing array**.
- Reads are completely lock-free and iterators never throw `ConcurrentModificationException` — they see a snapshot.
- Only sensible when reads massively outnumber writes (listener lists, config), because each write is O(n).
- ⚠️ The original note stopped at "all mutative operations are implemented" — the ending is what matters: *by copying the whole array*. That's the entire trade-off.

### `CompletableFuture`
Java 8 class representing the future result of an asynchronous computation, with a fluent API for composing them.
- **Non-blocking** — attach callbacks (`thenApply`, `thenAccept`, `thenCompose`) that fire on completion instead of blocking on `get()`.
- **Composition** — `thenCombine` (join two), `allOf` (wait for all), `anyOf` (first to finish wins).
- **Exception handling** — `exceptionally`, `handle`, `whenComplete`.
- Supports sync and async execution; pass your own `Executor` rather than relying on the common ForkJoinPool.

### Virtual threads (Java 21+)
Lightweight threads scheduled by the JVM rather than mapped one-to-one to OS threads.
- Contrast: a **platform thread** is a thin wrapper over an OS thread — expensive, ~1 MB stack, so you pool them. A virtual thread costs a few hundred bytes, so you can run millions and never pool.
- Designed for **I/O-bound** work: when a virtual thread blocks, the JVM unmounts it from its carrier thread instead of parking the OS thread. No gain for CPU-bound work.
- `synchronized` blocks could pin a virtual thread to its carrier in Java 21; prefer `ReentrantLock` in hot paths.

### Thread pool
A managed set of reusable worker threads. Incoming work is handed to an available thread instead of creating a new thread per task.
- Web servers use one to handle many concurrent requests without paying thread-creation cost each time.
- Key knobs: core size, max size, queue type, rejection policy.

### Servlet container
The runtime (Tomcat, Jetty, Undertow) that hosts a Java web application and owns request concurrency — it manages the thread pool and makes sure requests are processed concurrently.
- In Spring MVC, the container hands each request to a thread which runs through `DispatcherServlet` to your controller.

---

## JDK, JRE & Java versions

### JDK (Java Development Kit)
The software development kit for building Java applications — compiler (`javac`), debugger, `jar`, `javadoc`, plus the JRE.
- What developers install to write, compile, debug, and package.

### JRE (Java Runtime Environment)
The runtime needed to *run* Java applications — the JVM plus the core class libraries. No compiler, no debugger.
- What end users needed to execute bytecode. Since Java 11 Oracle stopped shipping a standalone JRE; you ship a trimmed runtime with `jlink` instead.

### Java 8 (2014, LTS)
- **Lambda expressions** — `x -> x * 2`
- **Stream API** — functional collection processing (`filter`, `map`, `reduce`)
- **`Optional`** — null-safe container
- Also: `default` and `static` methods on interfaces, new date/time API (`java.time`), `CompletableFuture`, PermGen removed in favour of Metaspace.

### Java 9 (2017)
- **Module system (Jigsaw)** — `module-info.java`, strong encapsulation. The JDK itself became modules (`java.base`, `java.sql`, `java.net.http`).
- **Immutable collection factories** — `List.of()`, `Set.of()`, `Map.of()`
- **Private methods in interfaces**
- Also: JShell, reactive `Flow` API.

### Java 11 (2018, LTS)
- `var` for local variables (added in 10), the standard `HttpClient`, `String` helpers (`isBlank`, `lines`, `strip`), single-file source execution.

### Java 17 (2021, LTS)
- **Sealed classes** — `permits` restricts subclassing
- **Pattern matching for `instanceof`** — `if (obj instanceof String s)`
- **Records** — `record Point(int x, int y) {}`
- Also: enhanced `switch` expressions, text blocks (`"""`), helpful `NullPointerException` messages, the new `java.util.Random` interfaces.
- This is the version Spring Boot 3 requires as a minimum.

### Java 21 (2023, LTS)
- **Virtual threads**, pattern matching for `switch`, record patterns, sequenced collections.

---

## HTTP & REST

### Status codes worth memorizing
- **200 OK** — the request succeeded.
- **201 Created** — succeeded and a new resource was created (return its URI in the `Location` header).
- **204 No Content** — succeeded, and the server is deliberately returning no body.
- **400 Bad Request** — the server couldn't understand the request; invalid syntax or failed validation.
- **401 Unauthorized** — the client must authenticate itself to get a response. (Really means *unauthenticated*.)
- **403 Forbidden** — the client is authenticated but has no access rights to this content.
- **404 Not Found** — the server can't find the requested resource.
- **405 Method Not Allowed** — the resource exists but doesn't support this HTTP verb. The response must include an `Allow` header listing what it does support.
- Useful extras: **409 Conflict** (state clash, e.g. duplicate), **422 Unprocessable Entity** (syntactically fine, semantically invalid), **429 Too Many Requests**, **500 Internal Server Error**, **503 Service Unavailable**.

### HTTP headers
Key-value pairs sent alongside a request or response carrying metadata.
- Common ones: `Content-Type` (media type of the body), `Accept` (what the client wants back), `Authorization` (credentials/token), `Cache-Control`, `ETag`.

### `OPTIONS` method
Asks the server what it supports rather than acting on a resource.
- Two typical uses: discovering which HTTP methods a resource allows, and carrying the **CORS preflight** check.

### CORS (Cross-Origin Resource Sharing)
A browser security feature that blocks a web page from making requests to a different origin than the one that served it, unless the target server opts in.
- Origin = scheme + host + port. All three must match or it's cross-origin.
- The server opts in with `Access-Control-Allow-Origin`, `-Allow-Methods`, `-Allow-Headers`, `-Allow-Credentials`.
- Enforced by the **browser**, not the server — `curl` and Postman ignore it entirely, which is why "it works in Postman but not the browser" is a CORS symptom.

### Preflight request
For requests that aren't "simple" — `PUT`, `DELETE`, `PATCH`, most `POST` bodies, or any custom header — the browser first sends an `OPTIONS` request to check permission, then sends the real request only if the server approves.
- Cache the answer with `Access-Control-Max-Age` to avoid doubling every call.

### Idempotent request
Calling it multiple times with the same data leaves the server in the same state as calling it once.
- **Idempotent:** `GET`, `HEAD`, `PUT`, `DELETE`, `OPTIONS`.
- **Not idempotent:** `POST`, `PATCH`.
- Note the difference from *safe*: `GET` is safe (no state change at all), `PUT` is idempotent but not safe.

### HATEOAS
Hypermedia As The Engine Of Application State — embedding links and available actions inside the resource representation so the client discovers what it can do next instead of hardcoding URLs.

```json
{ "id": 7, "status": "PENDING",
  "_links": { "self": {"href": "/orders/7"}, "cancel": {"href": "/orders/7/cancel"} } }
```

### MVC (Model–View–Controller)
An architectural pattern for handling web requests: the **model** holds data, the **view** renders it, the **controller** takes the request and coordinates the two.
- In a REST API the "view" is JSON rather than an HTML page. Spring MVC + Jackson gives you: Java object → Jackson → JSON response.
---

## Spring core — IoC & dependency injection

### IoC (Inversion of Control)
A design principle where control of object creation and dependency management is inverted from your application code to a container or framework.
- You stop writing `new`; the container decides what to build, when, and with what.
- In Spring, IoC is achieved through **dependency injection**.

### DI (Dependency Injection)
The specific pattern inside IoC where a component's dependencies are handed to it rather than the component creating or looking them up itself.
- Three flavours: constructor, setter, field.

### Constructor injection
Dependencies are passed through the constructor. **The recommended default.**
- The object is always in a valid, fully-initialized state — it cannot exist without its dependencies.
- Dependencies are obvious from the constructor signature.
- Supports `final` fields, so the object is immutable.
- `@Autowired` is optional on a single constructor since Spring 4.3.

### Field injection
Spring sets the field directly by reflection (`@Autowired` on the field).
- The object *can* exist without the dependency — it's `null` until Spring injects it.
- Downsides: **hidden dependencies** (the constructor tells you nothing about what the class needs), risk of `NullPointerException` if the object is created with `new` in a test, and no immutability because fields can't be `final`.

### Setter injection
Spring calls a setter after construction.
- The object can exist without the dependency until the setter is called.
- Right choice when the dependency is genuinely **optional or reconfigurable** after creation — "nice to have, but the object still works without it."

### `@Autowired`
Tells Spring to resolve and inject a matching bean automatically.
- Matches **by type** first; if several candidates match, disambiguate with `@Qualifier("beanName")` or `@Primary`.
- `@Autowired(required = false)` makes it optional.

---

## Spring core — container & beans

### Spring container
The mechanism responsible for creating beans, managing their lifecycle, injecting dependencies, and honouring bean scopes. The engine behind Spring's DI.

### `BeanFactory`
The base container interface. Instantiates, configures, and assembles beans, lazily by default.

### `ApplicationContext`
An extension of `BeanFactory` — everything `BeanFactory` does plus event publishing, internationalization, resource loading, and AOP integration.
- "Spring container vs `ApplicationContext`": the container *is* an `ApplicationContext` in practice. `ApplicationContext` is the interface you actually work with; `BeanFactory` is the bare-bones ancestor.
- `SpringApplication.run()` creates an `ApplicationContext` for you.

### Bean lifecycle
1. **Instantiation** — container constructs the bean.
2. **Populate properties** — dependencies injected.
3. **Initialization callbacks** — `@PostConstruct`, then `InitializingBean.afterPropertiesSet()`, then a custom `initMethod`.
4. **Bean ready to use.**
5. **Destruction** — `@PreDestroy`, then `DisposableBean.destroy()`, then a custom `destroyMethod`.
- Only singleton beans get destruction callbacks; Spring doesn't track prototypes after handing them over.

### Bean scopes
- **singleton** (default) — one instance created and shared across the entire application context.
- **prototype** — a new instance every time the bean is requested.
- **request** — one instance per HTTP request (web-aware contexts only).
- **session** — one instance per HTTP session (web-aware contexts only).
- **application** — one per `ServletContext`.
- **websocket** — one per WebSocket session.
- Classic trap: injecting a prototype into a singleton gives you one instance forever. Use `ObjectProvider` or a scoped proxy.

---

## Spring core — stereotype annotations

### `@Component`
Declares a class as a Spring bean. The generic stereotype.
- Makes the class a Spring bean, lets component scanning discover it, and enables dependency injection into it.

### `@Service`
`@Component` + the semantic statement "this class contains business logic." Marks the business layer.
- Functionally identical to `@Component` today; the value is architecture and readability (and it gives AOP pointcuts something to target).

### `@Repository`
`@Component` + "this represents the data access layer" + one real behaviour: **automatic persistence exception translation**.
- Spring catches database-specific exceptions (`SQLException`, `PostgreSQLException`, Hibernate exceptions) and converts them into its consistent `DataAccessException` hierarchy.
- Result: your service layer doesn't need to know which database or persistence technology you're using.

### `@Controller`
Handles web requests and integrates with Spring MVC request handling.
- The return value is treated as a **view name** by default, unless you add `@ResponseBody` to the method.

### `@RestController`
`@Controller` + `@ResponseBody` applied to every method. The REST API controller.

### `@ResponseBody`
Tells Spring: don't look for a view, take the method's return value and write it straight into the HTTP response body.
- Conversion is done by an `HttpMessageConverter` — normally Jackson, producing JSON.

### `@ControllerAdvice` / `@RestControllerAdvice` ⚠️
A class that applies cross-cutting behaviour to many controllers at once — most commonly global exception handling via `@ExceptionHandler` methods.
- Also hosts `@ModelAttribute` and `@InitBinder` methods shared across controllers.
- Can be scoped to specific packages, annotations, or controller types.
- ⚠️ Naming: the original note called it "Advice Controller". The annotation is `@ControllerAdvice` (or `@RestControllerAdvice`, which adds `@ResponseBody`).

### `@ExceptionHandler`
A method that catches a given exception type and turns it into an HTTP response, instead of letting it bubble out.
- Put it on a `@Controller` (that controller only) or on a `@ControllerAdvice` (global — the usual interview answer).
- Return a body (JSON) from `@RestControllerAdvice`, or a view name from a plain `@Controller`.

### `@Configuration`
Marks a class as a source of bean definitions and configuration metadata rather than a regular Java class. Its `@Bean` methods produce container-managed beans.

### `@Bean`
Method-level annotation inside a `@Configuration` class; the method's return value is registered as a bean. Used when you can't annotate the class itself — third-party types, or construction that needs logic.

### `@Value`
Injects a property value (or a SpEL expression result) into a field or parameter.
- `@Value("${app.timeout:30}")` — the part after `:` is the default.

### `@Profile`
Conditionally includes or excludes a bean or configuration class based on which profile is active.
- Activate with `spring.profiles.active=dev`.

### `@Conditional`
Conditionally includes or excludes a configuration class or bean based on a programmatic condition.
- Spring Boot's variants are what make auto-configuration work: `@ConditionalOnClass`, `@ConditionalOnMissingBean`, `@ConditionalOnProperty`.

### SpEL (Spring Expression Language)
An expression language for querying and manipulating an object graph at runtime.
- Used inside `@Value`, `@PreAuthorize`, `@Query`, and projection annotations.

```java
@Value("#{beanName.property1 > 5 ? 'High' : 'Low'}")
private String level;
```

---

## Spring core — AOP & transactions

### Proxy-based AOP
Spring wraps the target bean in a proxy object at runtime. When a method is called, the proxy intercepts, applies the aspect, then delegates to the real bean.
- Uses JDK dynamic proxies when the bean implements an interface, CGLIB subclassing otherwise.
- **Limitation that shows up constantly:** self-invocation bypasses the proxy. A method calling another `@Transactional` or `@Cacheable` method on `this` gets no advice at all.
- Also can't advise `private`, `static`, or `final` methods.

### AspectJ-based AOP
Weaves aspects directly into the compiled bytecode — at compile time, load time, or runtime — so aspects become part of the class and no proxy object exists.
- More flexible and powerful: works on classes that implement no interface, and can target specific methods, constructors, **and fields** with rich pointcut expressions.
- The core difference in one line: **AspectJ modifies your class's actual bytecode (weaving); proxy-based AOP wraps your class in a runtime wrapper to intercept calls.**

### Declarative transaction management
Transactional behaviour specified through configuration metadata — annotations (`@Transactional`) or XML — instead of hand-written begin/commit/rollback code.
- **How it works:** Spring creates a **proxy** around the bean, AOP **advice** intercepts the method call, and a **transaction manager** coordinates begin/commit/rollback against the data source.
- **Transaction attributes** define behaviour: propagation, isolation level, rollback rules, timeout, read-only.
- Default rollback rule: rolls back on unchecked exceptions and `Error`, **commits** on checked exceptions unless you set `rollbackFor`.

### `@Transactional`
Marks a method or class so Spring wraps the call in a transaction via an AOP proxy.
- Class-level applies to every public method; a method-level annotation overrides it.
- Only public methods reached **through the proxy** are transactional. `this.otherMethod()` skips the proxy and has no transaction.
- Defaults: `REQUIRED` propagation, rollback on unchecked exceptions only.

### Propagation behaviour
How a method should participate in a transaction when it's called by another method that already has one.
- `REQUIRED` (default) — join the existing transaction, or start one.
- `REQUIRES_NEW` — always suspend the caller's transaction and start a fresh independent one.
- `SUPPORTS` — join if there is one, run non-transactionally if not.
- `MANDATORY` — must have a caller transaction, else throw.
- `NOT_SUPPORTED` — suspend any transaction and run without one.
- `NEVER` — throw if a transaction exists.
- `NESTED` — a savepoint inside the caller's transaction.

### Isolation level
How much one transaction is allowed to see of other transactions' uncommitted work. Set with `@Transactional(isolation = ...)`.
- `READ_UNCOMMITTED` — dirty reads allowed (almost never used).
- `READ_COMMITTED` — no dirty reads; most databases' default. Non-repeatable reads still possible.
- `REPEATABLE_READ` — same row reads the same within the transaction. MySQL InnoDB default. Phantom rows still possible.
- `SERIALIZABLE` — full isolation, slowest.
- Interview one-liner: isolation trades consistency for throughput. Leave the default unless you have a concrete anomaly to prevent.

### Transaction manager
The component that coordinates transactions with the underlying data source — responsible for beginning, committing, and rolling back.
- `JpaTransactionManager` for JPA/Hibernate, `DataSourceTransactionManager` for plain JDBC.

---

## Spring web — request pipeline

### `DispatcherServlet`
Essentially any Spring web application is one servlet: the front controller that receives every incoming HTTP request and routes it to the right `@Controller` or `@RestController` method.

### Servlet filter
Sits in front of `DispatcherServlet` and can inspect or modify requests and responses before they reach any controller, and after they leave.
- Uses: authentication, logging, compression, CORS, request/response wrapping.
- You must call `chain.doFilter(request, response)` to pass the request along — forget it and the request dies silently.
- Operates on raw `ServletRequest`/`ServletResponse`; knows nothing about controllers or handler methods.

### Interceptor
Intercepts requests *inside* Spring MVC — after `DispatcherServlet` picks a handler but before the controller runs, then after the controller returns but before the view renders.
- Implement `HandlerInterceptor` and override `preHandle`, `postHandle`, `afterCompletion`.
- Unlike a filter, it knows which handler method was matched, so it can read method annotations.

### Filter vs interceptor — the one-liner
Filter = servlet-level, outside Spring, sees raw request/response. Interceptor = Spring MVC-level, inside the dispatcher, knows the handler method.

### `@PathVariable`
Binds a controller method parameter to a URI template variable.

```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id)
```
- The parameter name matches the `{id}` by default; write `@PathVariable("id")` if they differ.
- Contrast: `@RequestParam` binds a query string (`?id=1`). `@RequestBody` binds the HTTP body (usually JSON → object).

---

## Spring Boot

### Spring vs Spring Boot — deployment
- **Spring Framework:** you build a WAR and deploy it manually to an external servlet container (Tomcat, Jetty, Undertow).
- **Spring Boot:** ships an **embedded** server, so you package a single executable JAR that runs itself.

### Spring vs Spring Boot — configuration
With plain Spring you configure most things by hand: create an `ApplicationContext`, define beans, wire a datasource, wire a transaction manager, set up test properties.
Spring Boot already knows how to configure most of that.
- Boot adds: **auto-configuration**, **starter dependencies**, built-in testing support with almost no config, and **Spring Boot Actuator** for monitoring and management out of the box.

### `@SpringBootApplication`
Combines three annotations: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
- Component scanning starts from this class's package and works downward — which is why it belongs in the root package.

### `@EnableAutoConfiguration`
Configures the application based on the dependencies on the classpath — Spring Boot creates and configures beans for you based on which libraries are present.
- Backed by `@Conditional` checks. See what it decided with `--debug` or the Actuator `conditions` endpoint.

### Starter dependency
A curated dependency bundle that pulls in a coherent set of libraries plus the auto-configuration for them, at versions known to work together.
- `spring-boot-starter-web` gives you Spring MVC, Jackson, validation, and embedded Tomcat.

### Spring Web (what the starter gives you automatically)
- Starts an embedded Tomcat server.
- Configures Spring MVC.
- Sets up Jackson for JSON.

### `application.properties` / `application.yml`
Where you define Spring-specific configuration properties — datasource URL, port, logging levels, custom app properties.
- Profile-specific variants (`application-dev.yml`) override the base file.
- Precedence, highest first: command-line args → environment variables → profile-specific file → base file → defaults.

### Spring Boot Actuator
Production-ready monitoring and management endpoints out of the box — `/health`, `/metrics`, `/info`, `/env`, `/loggers`, `/conditions`.
- Expose deliberately; several endpoints leak configuration if left open.
---

## JPA, Hibernate & Spring Data

### JPA (Java Persistence API)
A **specification** for accessing, persisting, and managing data between Java objects and relational databases. It defines a set of interfaces and annotations, not an implementation.
- Renamed **Jakarta Persistence** from version 3; the package moved `javax.persistence` → `jakarta.persistence`. That rename is the single biggest mechanical change in a Spring Boot 2 → 3 migration.

### Hibernate
A specific **implementation** of the JPA specification, plus extra features beyond the standard.
- ORM (Object-Relational Mapping): you write Java classes that represent database tables, and Hibernate maps them to the corresponding tables automatically.
- Beyond-spec extras: second-level cache, `@Formula`, filters, its own criteria API.

### Spring Data JPA
A repository abstraction layered on top of the JPA specification, using a JPA provider (normally Hibernate) underneath.
- Generates query implementations from method names (`findByLastNameAndActiveTrue`), gives you paging, sorting, and `@Query` for custom JPQL/native SQL.
- The stack, top to bottom: **Spring Data JPA → JPA (spec) → Hibernate (provider) → JDBC → database.**

### JPQL (Java Persistence Query Language)
A query language for querying **entities** rather than tables directly. Similar to SQL but operates on entity objects and their fields.

```java
List<User> users = entityManager
    .createQuery("SELECT u FROM User u", User.class)
    .getResultList();
```
- Case-sensitive on entity and field names, case-insensitive on keywords. No `SELECT *`.

### `@EnableJpaRepositories`
Registers Spring Data JPA repositories and links them to a specific JPA context (an `EntityManagerFactory` + a `TransactionManager`).
- `basePackages` — where Spring scans for repository interfaces.
- `entityManagerFactoryRef` — which `EntityManagerFactory` those repositories use.
- `transactionManagerRef` — which transaction manager to use.
- You only need this explicitly for **multiple datasources**; Boot configures a single one for you.

### Entity relationships — the annotations
```java
// Many-to-one: this side owns the FK column
@ManyToOne
@JoinColumn(name = "user_id")
private User user;

// One-to-many: inverse side, no FK column of its own
@OneToMany(mappedBy = "user")
private List<Order> orders;

// Many-to-many: a join table
@ManyToMany
@JoinTable(
    name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
)
private Set<Role> roles;
```

### `@JoinColumn` — the owning side
The side carrying `@JoinColumn` is the **owning side**; it holds the foreign key column.
- Read it as: "my table has a `user_id` column pointing at the `id` of the `User` table."
- Only the owning side's changes are written to the database.

### `mappedBy` — the inverse side
`@OneToMany(mappedBy = "user")` says: "I am **not** the owner. Look at the field named `user` in the other entity to find the mapping."
- Forget `mappedBy` on a bidirectional relationship and Hibernate creates a redundant join table.

### `@JoinTable` — many-to-many
Creates a third table (`user_role`) holding two foreign keys: `joinColumns` points back at *this* entity (`user_id`), `inverseJoinColumns` points at the other side (`role_id`).
- Use `Set` not `List` for `@ManyToMany` — `List` causes Hibernate to delete and re-insert every row on any change.

### Eager fetching
Associated entities are loaded immediately, in the same query as the primary entity.
- Safe from lazy-loading exceptions, but can pull in far more data than you asked for.

### Lazy fetching
Associated entities are loaded on demand, when you first touch the association.
- Needs an open session/transaction, or you get `LazyInitializationException`.
- Implemented with a proxy, which is why lazy fields can't be `final`.

### JPA default fetch types
- `@OneToMany` and `@ManyToMany` default to **`FetchType.LAZY`**.
- `@OneToOne` and `@ManyToOne` default to **`FetchType.EAGER`**.
- Practical advice: set the `*ToOne` sides to `LAZY` explicitly and fetch what you need with `JOIN FETCH`.

### N+1 problem
Lazy loading fires **one** query to fetch the main entities plus **N** additional queries to fetch each one's related entity. For N entities that's N+1 queries — hence the name.
- Concrete case: `Post` → `Comment` is one-to-many. You ask for a list of posts and their comments. Hibernate runs 1 query for the posts, then N queries — one per post — for its comments.
- Fixes: `JOIN FETCH` in JPQL, `@EntityGraph` on the repository method, `@BatchSize` to batch the child queries, or a projection/DTO query that fetches only the columns you need.
- Detect it by logging SQL (`spring.jpa.show-sql`) or with a query counter in tests.

### Caching (general)
Storing frequently accessed data in memory so it can be retrieved quickly without going back to the database each time.
- Improves performance and cuts latency by holding entities in memory.

### First-level cache (session cache)
Hibernate's built-in, always-on cache scoped to a single `Session`/`EntityManager`. Every entity fetched is stored there; ask for the same entity again in the same session and Hibernate returns the cached copy instead of hitting the database.
- Managed automatically — nothing to configure, and you cannot turn it off.
- Accessed through the `EntityManager`.
- Cleared automatically when the session closes, and **never shared between sessions**.
- Also gives you identity guarantees: the same entity fetched twice in one session is the same Java object.

### Second-level cache
An optional Hibernate cache that stores data **across** sessions, shared by the whole `SessionFactory`.
- Enable it per entity with `@Cacheable`, and set the concurrency strategy with Hibernate's `@Cache`.
- Needs a provider on the classpath: EhCache, Infinispan, Hazelcast, Caffeine.
- When an entity is updated, Hibernate invalidates its cache entry; the next access refetches from the database and re-caches.

### `@Cacheable` — two different annotations ⚠️
Two unrelated annotations share this name. Mixing them up is a classic interview trap.
- **`jakarta.persistence.@Cacheable`** — goes on an **entity class**. Turns on Hibernate's **second-level cache** for that entity, so the entity survives across sessions.
- **`org.springframework.cache.annotation.@Cacheable`** — goes on a **method**. Caches that method's return value keyed on its arguments, in a Spring cache (Caffeine, Redis, etc.).
- Different layer, different target, different cache. Rule of thumb: **entity → JPA's. Method → Spring's.**

```java
@Entity @Cacheable                       // JPA — cache this entity (2nd-level cache)
class Product { ... }

@Cacheable("prices")                     // Spring — cache what this method returns
BigDecimal priceFor(Long productId) { ... }
```

### Second-level cache concurrency strategies
Hibernate supports three cache modes for second-level caching.
- **read-only** — for data that is not expected to change frequently. Fastest, no locking.
- **read-write** — for data that is frequently updated. Uses soft locks to keep the cache consistent.
- **transactional** — for data updated inside a transaction; the cache participates in that transaction.

### Query cache
Caches the **result sets of queries**. On execution Hibernate checks whether that query's results are already cached; if so it returns them without hitting the database, otherwise it runs the query and caches the result for next time.
- Requires the second-level cache to be enabled — the query cache stores entity **IDs**, then resolves them through the second-level cache.
- Easy to make things slower: any write to a queried table invalidates the whole query region.

### Projection
A way to query and retrieve specific columns or fields rather than whole entities. Reduces the data loaded into memory.
- Declaring a repository method with a projection interface looks exactly like declaring one with an entity class — the only difference is that the projection interface, not the entity, is the element type of the returned collection.
- Behind the scenes Spring creates a **proxy instance** of the projection interface per entity object, and forwards every call on the proxy to that object.

```java
interface PersonView { String getFirstName(); String getLastName(); }
List<PersonView> findByActiveTrue();
```

### Open projection
A projection that defines interface methods with names that don't match any entity field, computing the value at runtime with SpEL.

```java
public interface PersonView {
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
```
- Trade-off: open projections force Spring to load the **whole entity** to evaluate the expression, so you lose the performance benefit of a closed projection.

### Class-based projection (DTO projection)
Instead of a proxy generated from an interface, you supply your own class and Spring populates it via its constructor.
- No proxies, and works well with `SELECT new com.x.PersonDto(p.firstName, p.lastName) FROM Person p`.
- Records make excellent projection classes.

### `@Formula` ⚠️
Defines a computed, **read-only** property on an entity using a raw SQL expression evaluated by the database.

```java
@Formula("datediff(curdate(), birth_date) / 365")
private int age;
```
- ⚠️ The original note had `lower(datediff(curdate(), birth_date / 365)` — unbalanced parentheses, the division inside the wrong argument, and a `lower()` wrapped around a number. Corrected version above.
- Downsides: it's vendor-specific SQL inside your entity, and it's added to **every** select for that entity.

---

## Entity inheritance strategies

### Polymorphic query
A query written against a base class that can return instances of **any** subclass in the hierarchy.
- Whether you get this at all depends on which inheritance strategy you pick.

### Mapped superclass
The simplest strategy. Each concrete class maps to **its own table**, and the parent only shares state and mapping information.
- `@MappedSuperclass` — the parent is **not an entity** and has no table of its own.
- Therefore: **no polymorphic queries** (you can't `SELECT p FROM Publication p`) and no associations to the superclass.
- Right choice when you only want to share fields and mappings between otherwise unrelated entities — e.g. a base class with `id`, `createdAt`, `updatedAt`.

### Table per class
Each entity gets its own table containing a column for **every** attribute, including the inherited ones. The superclass **is** an entity.
- Gains over mapped superclass: polymorphic queries work, and you can define associations to the superclass — so `Author.getPublications()` can return books and blog posts together.
- Querying one specific subclass is easy and efficient — one table, no joins.
- The cost: polymorphic queries are ugly. Books and blog posts live in separate tables, so Hibernate joins `author` against a **subselect that UNIONs** every subclass table. Add more subclasses and it gets worse. This can become a real performance problem — the queries generated for polymorphic queries here are very complex.

### Single table
All entities in the hierarchy map to **one** database table. The default strategy.
- Best performance and the most efficient polymorphic queries — no joins at all, Hibernate just adds a comparison on the discriminator value.
- The cost: every entity's attributes share one table, so each row uses only a subset of columns and leaves the rest `null`. You therefore **cannot put `NOT NULL` constraints** on any column that isn't mapped by every entity. That's a data-integrity hole, and your DBA won't love it.
- Needs a **discriminator column** so Hibernate knows which entity class each row represents. It isn't an entity attribute. Name it with `@DiscriminatorColumn` on the superclass, or Hibernate uses `DTYPE` as the default name.
- The only thing Hibernate adds to the SQL to fetch one particular entity class is a comparison of the discriminator value — no joins at all.

### Joined table
Each class in the hierarchy gets its own table, but a subclass's data is **spread across multiple tables**.
- The abstract superclass gets a table with the shared columns. Each subclass table holds only its own specific columns and shares the primary key with the matching row in the superclass table.
- Gain: no wasted `null` columns, so you **can** use subclass-specific constraints — e.g. `NOT NULL` on `blogpost.url`. Best data integrity of the four.
- Cost: every query on a subclass needs a **join** to the superclass table. Hibernate joins `publication` and `book` on their primary keys to select all of a `Book`'s attributes. That overhead makes these queries slightly slower than single-table.

### Choosing between them — quick rule
Data integrity matters most → **joined**. Read performance matters most → **single table**. No polymorphism needed, just shared fields → **mapped superclass**. Avoid **table per class** unless polymorphic queries are rare.

---

## Spring Security

### Spring Security
A Spring project providing authentication and authorization for Spring applications. Dependency: `spring-boot-starter-security`.
- Under the hood it's really just **a chain of servlet filters** that add authentication and authorization to your web app.
- Covers: authentication, authorization, password hashing (BCrypt), JWT, OAuth2 / OpenID Connect, CSRF protection, CORS support, session management.

### Authentication
Verifying the identity of a user or system — **who are you?**
- Common methods: username/password, OAuth2, JWT.

### Authorization
Granting or denying access to resources based on the authenticated identity's permissions or roles — **what can you do?**

### RBAC (Role-Based Access Control)
Access control defined by user roles and the permissions attached to them, rather than per-user rules.
- Spring convention: an *authority* is any string; a *role* is an authority prefixed `ROLE_`. `hasRole("ADMIN")` and `hasAuthority("ROLE_ADMIN")` mean the same thing.

### Token-based authentication
Using a token (typically JWT) to carry proof of authentication with each request, rather than a server-side session. Essential for stateless APIs.

### Security filter chain ⚠️
Spring Security installs a default chain of roughly 15 filters handling different parts of authentication and authorization.
- **Spring Security 5.x and earlier:** configure by extending `WebSecurityConfigurerAdapter`.
- **Spring Security 6 / Spring Boot 3:** `WebSecurityConfigurerAdapter` is **removed**. Use `@EnableWebSecurity` on a `@Configuration` class and expose a `SecurityFilterChain` bean. This is a mandatory migration step.
- ⚠️ Also renamed in Spring Security 6: `antMatchers()` → `requestMatchers()`, and `authorizeRequests()` → `authorizeHttpRequests()`.

### `antMatchers` / `requestMatchers`
Configures which URL patterns a security rule applies to and what access they require.

```java
// Spring Security 5
http.authorizeRequests()
    .antMatchers("/public/**").permitAll()
    .antMatchers("/admin").hasAuthority("ROLE_ADMIN");

// Spring Security 6
http.authorizeHttpRequests(a -> a
    .requestMatchers("/public/**").permitAll()
    .requestMatchers("/admin").hasRole("ADMIN"));
```
- Order matters — the first matching rule wins, so put specific patterns before broad ones.

### The three authentication scenarios
1. **The default** — Spring Security can read the user's hashed password because user details live somewhere it can reach, e.g. a database table.
2. **Less common** — you cannot access the hashed password because users and passwords live in a third-party identity management product exposing REST services for authentication (e.g. Atlassian Crowd).
3. **Also popular** — OAuth2 or "Login with Google/Twitter" (OpenID Connect), often combined with JWT.

---

## JWT, OAuth2 & OIDC

### JWT (JSON Web Token)
A compact, self-contained way to securely transmit information between parties as a JSON object. Three dot-separated parts.
- **Header** — the token type (`JWT`) and the signing algorithm (`HS256`, `RS256`).
- **Payload** — the claims: statements about an entity (usually the user) plus any additional data. Standard claims: `sub`, `iss`, `aud`, `exp`, `iat`.
- **Signature** — created by taking the encoded header, the encoded payload, a secret, and the algorithm from the header, and signing them.
- **Critical point:** a JWT is signed, **not encrypted**. The payload is base64url — anyone can read it. Never put secrets in it.
- Trade-off: you can't revoke a JWT before it expires, which is exactly why access tokens are kept short-lived.

### Refresh token
A long-lived token issued alongside the access token, used to obtain a new access token once the original expires.
- Flow: user logs in → server issues both tokens. The **access token** authenticates API requests and expires quickly (e.g. 15 minutes). When it expires, the client presents the **refresh token** to get a new access token without making the user log in again.
- Store it more carefully than the access token (httpOnly cookie, not localStorage), and rotate it on use.

### OAuth2
A framework for **delegated authorization** — it answers "what is this app allowed to do?"
- The original problem: you want a fitness app to read your Google Calendar, but you don't want to hand it your Google password. OAuth2's answer is that you authenticate directly with Google, and the app receives an **access token** instead — a limited key saying "the bearer of this may read calendars", valid for one hour.
- OAuth2 by itself says **nothing about who you are**. An access token is like a hotel key card: it opens room 402, but it doesn't tell the door your name.

### OAuth2 authorization code flow
1. The client app requests authorization from the resource owner (user) to access their account data. *(User clicks "Login with Google".)*
2. The user logs into their Google account and grants permission for the requested scopes. *(Google shows a consent screen; the user clicks "Allow".)*
3. Google redirects back to the app's registered `redirect_uri` with a short-lived **authorization code**.
4. The client **backend** exchanges the authorization code for an access token by calling Google's token endpoint with its client secret.
5. Google validates the code and issues an **access token** (and optionally a **refresh token** and an ID token).
6. The client calls Google's APIs with `Authorization: Bearer <access_token>`.
- ⚠️ The original note had the **UI** doing the code exchange. That's the part to get right: the exchange must happen server-side for a confidential client, because it needs the client secret. A browser SPA is a *public* client and must use **PKCE** instead of a secret.

### OIDC (OpenID Connect)
A thin standard layer on top of OAuth2 that answers "**who is this person?**" — added because people kept abusing OAuth2 for login, which it wasn't designed for.
- Three things it changes: you add `openid` to the requested scopes, you get back an extra **ID token** describing the user (`preferred_username`, `email`, `name`, `sub`), and there's a standard `/userinfo` endpoint.
- The ID token is like the photo ID you showed at the hotel desk — it identifies you, but it doesn't open any doors.
- **OAuth2 = authorization. OIDC = authentication.** That contrast is the answer to a very common question.

### Keycloak
An open-source identity provider that implements OIDC, so it handles authentication and authorization together in one round trip.
- **Whose login page is it?** Two different pages, worth separating in your head. Your app's `/login` is a branded screen with a single button and **no username or password field**. The page where you actually type a password lives on Keycloak, at `/realms/<realm>/protocol/openid-connect/auth`. That separation is the entire point of OAuth2 — your app never sees the password.

---

## CSRF, CORS & encryption

### CSRF (Cross-Site Request Forgery)
An attack where a malicious site tricks an authenticated user's browser into performing an unwanted action on a trusted site.
- **The precise mental model:** CSRF is *not* "the attacker knows my token and makes a request." CSRF is "the attacker doesn't know my credential, but tricks my browser into automatically sending it." The browser attaches the session cookie for you — that automatic attachment is the vulnerability.
- This is why CSRF matters for **cookie/session** auth and generally not for a `Authorization: Bearer` header, which the browser never attaches automatically.

### CSRF protection in Spring Security ⚠️
By default Spring Security protects every incoming state-changing request (`POST`, `PUT`, `DELETE`, `PATCH`) with a CSRF token.
1. **Token generation** — on first access the server generates a CSRF token.
2. **Token storage** — the token is stored and sent to the client.
3. **Client retrieval** — the client reads the token and puts it in a header on every state-modifying request.
4. **Server validation** — the server compares the token from the request against the stored one. Match = valid; mismatch = rejected.
- ⚠️ The original note said the token is stored in a cookie named `XSRF-TOKEN` and sent back in `X-XSRF-TOKEN`. That's only true when you explicitly configure `CookieCsrfTokenRepository` (the pattern Angular expects). **Spring Security's default is `HttpSessionCsrfTokenRepository`** — the token lives in the HTTP session and comes back as the `_csrf` request parameter or `X-CSRF-TOKEN` header. Worth stating both, because interviewers ask which is the default.

### CSRF and session-centric applications
In traditional web apps, HTTP sessions track user state: on first access a session is created and its ID is stored in a cookie. Spring Security generates a CSRF token and associates it with that session, and the token must accompany every subsequent `POST`/`PUT`/`DELETE`/`PATCH`.
- The token proves the request originated from your own page rather than a malicious one, because a cross-site attacker can read the cookie's *existence* but not the token's *value*.

### Symmetric key encryption
One key both encrypts and decrypts. Push data through the key to scramble it, push it back to make it readable. An attacker only needs to steal that key.
- Fast. The hard part is distributing the key safely. AES is the standard.

### Public key (asymmetric) encryption
Two keys. The **public** key is available to anyone; the **private** key stays with a select few. Encode with one, and the recipient needs the other to read it.
- Encrypt with the public key → only the private key holder can read it. Sign with the private key → anyone can verify it with the public key.
- Slow, so in practice it's used to exchange a symmetric key (that's TLS).

### Hashing
A computer algorithm transforms your password into a fixed-length random-looking series of numbers and letters. It's **one-way** — you cannot reverse it, you can only hash a guess and compare.
- Security comes from the function being one-way and, for passwords, **deliberately slow**.
- Use a password hash (BCrypt, Argon2, scrypt, PBKDF2), never a fast general-purpose hash like MD5 or SHA-256 — fast hashes let an attacker try billions of guesses per second.

### Salting
A few random numbers or letters are appended to the password before it goes through the hashing process, so two users with the same password get different hashes.
- What it defeats: **precomputed rainbow tables**, and an attacker being able to spot that two accounts share a password.
- A **variable salt** — unique per password — is the correct approach. A **fixed salt** reused for every password loses most of the benefit.
- When a password is salted with a random value, the salt is stored alongside the hashed password. With BCrypt it's embedded inside the hash string itself.

---

## Method-level security

### Method security ⚠️
Controls access to specific methods in your controllers or services based on roles, permissions, or expressions.
- You must enable it explicitly by putting the annotation on a `@Configuration` class.
- ⚠️ Know **both** the old and the current annotation — the old one is what you'll find in any pre-Boot-3 codebase.

**Old — Spring Security 5.x (deprecated):**
```java
@EnableGlobalMethodSecurity(
  prePostEnabled = true,   // enables @PreAuthorize and @PostAuthorize
  securedEnabled = true,   // enables @Secured
  jsr250Enabled  = true)   // enables @RolesAllowed
```

**Current — Spring Security 6:**
```java
@EnableMethodSecurity     // prePostEnabled = true is the default
// add securedEnabled = true / jsr250Enabled = true only if you use those annotations
```

### `@Secured`
Spring-specific annotation (from `spring-security-core`) taking a list of role/authority strings. A user can call the method if they have at least one of them.
- Does **not** support SpEL.

### `@RolesAllowed`
The standardized equivalent of `@Secured`, from the `javax.annotation-api` (now `jakarta.annotation`) dependency. Same behaviour: a list of roles, at least one required.
- Also does **not** support SpEL. `@Secured` and `@RolesAllowed` are basically the same thing — one Spring-specific, one a standard.

### `@PreAuthorize`
Newer Spring-specific annotation that checks an expression **before** entering the method. More powerful than `@Secured`/`@RolesAllowed` because it accepts any valid SpEL expression, not just role names.

```java
@PreAuthorize("hasRole('ADMIN') or #userId == authentication.principal.id")
public User get(Long userId) { ... }
```

### `@PostAuthorize`
Verifies the expression **after** the method executes, and can therefore inspect the return value via `returnObject`.
- The method has already run and any side effects have happened — so this is for filtering what the caller sees, not for preventing work.

### `@PreFilter`
Filters a **collection argument** before the method executes, removing elements that fail the expression. `filterObject` refers to each element.

```java
@PreFilter(value = "filterObject != authentication.principal.username",
           filterTarget = "usernames")
public String joinUsernamesAndRoles(List<String> usernames, List<String> roles) { ... }
```
- `filterTarget` is required when the method has more than one collection parameter.

### `@PostFilter`
Filters the **returned collection** of a method, dropping elements the current user shouldn't see.
- Beware performance: the method still loads everything, then throws rows away in memory. Filter in the query for large result sets.
---

## Testing

### Mockito
A mocking framework for creating mock objects in unit tests. Used for **stubbing** behaviour and **verifying** interactions between objects.
- Point of it: simulate a real object's behaviour in a controlled way so the unit under test is isolated from its dependencies.

```java
when(mockedList.get(0)).thenReturn("Alice");
verify(mockedRepo).save(any(User.class));
```

### `@Mock`
Creates a mock instance of a type. Every method returns a default (`null`, `0`, `false`) until you stub it.

### `@Spy`
Creates a **partial mock** — a real object where you can selectively stub individual methods while the rest run their real implementation.
- Stub a spy with `doReturn(x).when(spy).method()`, not `when(spy.method())`, because the latter actually calls the real method.

### `@InjectMocks`
Creates an instance of the class under test and injects the mocks created with `@Mock` (or `@Spy`) into it.
- Injection order it tries: constructor → setter → field. Constructor injection is the one that behaves predictably.

### Mockito's stubbing limits ⚠️
Mockito historically could not stub `final`, `private`, or `static` methods.
- ⚠️ Update: since **Mockito 3.4** `mockStatic()` handles static methods, and the **inline mock maker** (default from Mockito 5) mocks `final` classes and methods. `private` methods are still out — and mocking them is a design smell anyway.

### `ArgumentCaptor`
Captures the arguments passed to a mock method so you can assert on them afterwards.

```java
ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
verify(repo).save(captor.capture());
assertEquals("Alice", captor.getValue().getName());
```
- Use it when the argument is built inside the method under test and you can't construct an expected value to match.

### JMockit
Another Java framework supporting stubbing and mocking, including things Mockito traditionally couldn't reach (statics, constructors) via bytecode instrumentation.

### Hamcrest
A framework for writing **matchers** — reusable conditions an object must satisfy — giving readable assertions and failure messages.

```java
assertThat(names, hasItem("Alice"));
assertThat(age, allOf(greaterThan(18), lessThan(65)));
```
- AssertJ (`assertThat(x).contains(...)`) has largely replaced it in new projects, but Spring's `MockMvc` still uses Hamcrest matchers.

### `@RunWith` (JUnit 4)
Specifies a test runner that replaces the default JUnit runner.
- **JUnit 4 allows only one runner per class** — you cannot combine several. That was the main limitation.
- With Mockito you'd use `@RunWith(MockitoJUnitRunner.class)`; with Spring, `@RunWith(SpringRunner.class)`.

### `@ExtendWith` (JUnit 5)
Registers an **extension** that adds behaviour to the test class.
- **JUnit 5 allows combining multiple extensions**, which is the flexibility `@RunWith` lacked.
- Equivalents: `@ExtendWith(MockitoExtension.class)`, `@ExtendWith(SpringExtension.class)`.

### `@Rule` (JUnit 4)
Defines a field or method that runs before or after each test method, letting you apply behaviour (timeouts, temp folders, expected exceptions) across many tests without duplicating code.
- Replaced in JUnit 5 by extensions.

### Spring TestContext Framework
Spring's integration-testing support, built on top of JUnit and TestNG.
- Adds: loading and **caching** Spring `ApplicationContext`s across test classes, transaction management (roll back after each test), and dependency injection into the test instance itself.
- The context cache is why the second test class starts much faster than the first.

### `@SpringBootTest`
Boots the full Spring application context for an integration test. With Spring Boot, no manual configuration is needed — it automatically:
- Starts the Spring application context.
- Finds your `@SpringBootApplication` class.
- Creates all beans.
- Loads `application.properties`.
- Configures the datasource, JPA/Hibernate, and transactions.
- Contrast with plain Spring, where you'd hand-configure an `ApplicationContext`, the beans, the datasource, the transaction manager, and test properties yourself.

```java
@ExtendWith(SpringExtension.class)     // JUnit 5
@ContextConfiguration(classes = AppConfig.class)
@Transactional
class MyServiceIntegrationTest { ... }
```

### `@MockBean` ⚠️
Adds a mock implementation of a bean to the application context, replacing the real Spring bean of that type with a Mockito mock during the test.
- Note: **each distinct set of `@MockBean`s creates a new application context**, so overusing it destroys the context cache and slows the suite down.
- ⚠️ Know **both** names. Old (Spring Boot ≤ 3.3, deprecated in 3.4): `@MockBean` and `@SpyBean`. Current (Spring Boot 3.4+): **`@MockitoBean`** and **`@MockitoSpyBean`**.
- Same behaviour, same purpose — the rename was to make it obvious they're Mockito-specific rather than a generic Spring feature.

### `@DataJpaTest`
A **test slice** that loads only JPA components — entities, repositories, a `TestEntityManager`, and an in-memory datasource — instead of the whole application.
- Transactional and rolls back by default.
- Sibling slices: `@WebMvcTest` (controllers only), `@JsonTest`, `@RestClientTest`.

### JaCoCo
A code-coverage tool. It needs to sit **inside the JVM that executes your tests** and watch which lines get executed.
- That's why the Maven setup is `jacoco:prepare-agent` (attaches the Java agent before tests) then `jacoco:report`.

---

## Maven

### Maven default lifecycle ⚠️
`validate` → `compile` → `test` → `package` → `verify` → `install` → `deploy`
- **validate** — check the project is correct and all necessary information is available.
- **compile** — compile source into `target/classes`.
- **test** — run unit tests.
- **package** — bundle into a JAR/WAR.
- **verify** — run checks on integration test results to confirm quality criteria are met.
- **install** — install the package into your **local** repository, so other projects on your machine can depend on it.
- **deploy** — done in the build environment; copies the final package to the **remote** repository to share with other developers and projects.
- ⚠️ `clean` is **not** part of the default lifecycle. Maven has three separate lifecycles: **clean**, **default**, and **site**. `mvn clean install` is you invoking two lifecycles in one command — that's a real interview question.

### Phase
One step in a lifecycle. Examples: `compile`, `test`, `package`, `install`.
- Running a phase runs every phase before it in that lifecycle.

### Goal
A single task provided by a plugin, bound to a phase.
- Examples: `compiler:compile` is bound to the `compile` phase; `surefire:test` is bound to the `test` phase; `jacoco:prepare-agent`.
- Each lifecycle phase is associated with one or more goals.
- Run one directly: `mvn [plugin-name]:[goal-name]`, e.g. `mvn dependency:tree`.

### `<goals>` vs `<phase>`
- `<goals>` = **what** a plugin can do.
- `<phase>` = **when** that goal runs.
- Plugins run automatically when their bound phase is reached. If no phase is declared, Maven uses the plugin's own default phase.

### Maven as a plugin execution framework
Maven itself does almost nothing — it's a framework that **executes plugins**, and every actual task is done by a plugin.
- Compiling: Compiler Plugin. Testing: Surefire Plugin. Packaging: JAR/WAR Plugin.
- Plugins are configured in `pom.xml` under `<build>`, where each can specify goals, executions, and custom settings.

### Compiler Plugin
Compiles Java source files into `.class` files.
- `source` — the language level of your source. `target` — the version of the bytecode produced (e.g. Java 1.8).
- Modern shorthand: the `maven.compiler.release` property, which does both correctly.

### Surefire Plugin
Runs **unit** tests and generates reports from the results. Bound to the `test` phase by default.
- Picks up `*Test.java`, `Test*.java`, `*Tests.java`, `*TestCase.java` by default.

### Failsafe Plugin
The **integration** test counterpart. Bound to `integration-test` and `verify`, and — unlike Surefire — it doesn't fail the build immediately, so post-test cleanup still runs.
- Default pattern: `*IT.java`.

### `<groupId>`
The unique identifier for the group or organization responsible for the project. Reverse domain convention: `com.instructure.canvas`.

### `<artifactId>`
The unique identifier for the specific project or library within the group — usually the library's name.

### `<version>`
The artifact's version. A `-SNAPSHOT` suffix means "in development": Maven will re-check the remote repository for newer builds.

### `<scope>`
Indicates the visibility and lifecycle of a dependency in relation to the project.
- **compile** — the default; available on every classpath (compile, test, runtime) and packaged with the app.
- **test** — available only for test compilation and execution.
- **runtime** — not needed to compile, required at runtime (e.g. a JDBC driver).
- **provided** — needed to compile but supplied by the container at runtime, so it isn't packaged.
- **import** — only valid inside `<dependencyManagement>` with `<type>pom</type>`; pulls in a BOM.

### `<exclusions>`
Excludes specific **transitive** dependencies from being pulled into your project.
- The usual reason: a duplicate/conflicting implementation, e.g. excluding `spring-boot-starter-logging` to swap in Log4j2.

### `<repositories>`
The `pom.xml` tag where the URLs of remote repositories are configured.
- Famous repository managers: **JFrog Artifactory** and **Sonatype Nexus**. These host not just Maven JARs but plenty of unrelated artifacts — container (Docker) images, configuration files, and more.

### Local repository
The central place on your machine holding every Maven artifact any of your projects has used. Default: `~/.m2/repository`.

### `pom.xml`
The Project Object Model. Does a great many things, including dependency management, build lifecycle customization, and plugin configuration.

### Super POM
The implicit parent that **all** POMs inherit from. It supplies Maven's default values — the default lifecycle bindings, the standard directory layout, Maven Central as a repository.
- See yours fully resolved with `mvn help:effective-pom`.

### `<dependencyManagement>`
Declares the version Maven should use for a dependency **"in case"** a module decides to use it — it does not add the dependency itself.
- **Purpose:** avoid repeating dependency configuration and centralize it, so you don't update a version in multiple modules every time it changes.
- If a library's version is **not** declared in `<dependencyManagement>` and you use it, you must state the version yourself under `<dependencies>` or the build fails.
- You can exploit that to **override** a managed version: declare your required version directly under `<dependencies>`.

### BOM (Bill Of Materials)
A POM containing only a `<dependencyManagement>` section. It's an independent file with its own `groupId`, `artifactId`, and `version`, imported to centralize versions.
- Key contrast: a **BOM** holds something usable across several unrelated projects, while a **parent POM**'s usefulness is limited to the project it was created in.
- And: you can have only **one parent**, but you can **import multiple BOMs**.
- Example: `spring-boot-dependencies`.

### POM packaging
`<packaging>pom</packaging>` — a Maven project used solely to manage dependencies, plugins, and other modules. Produces no JAR or WAR; it defines the structure and dependencies of a multi-module build.

### JAR packaging
The default for Java projects. Produces a `.jar` containing compiled classes, resources, and metadata, which can be executed or used as a dependency elsewhere.

### Aggregator POM
Strictly **required** to orchestrate multiple modules. Sits at the root of the project and its only job is to host the `<modules>` tag pointing at each sub-module's directory, so one command builds them all.
- Must declare `<packaging>pom</packaging>`.

### Parent POM
Technically **optional**. Hosts shared properties, dependencies, and plugin management, which sub-modules inherit by explicitly referencing it with the `<parent>` tag in their own `pom.xml`.
- The two concepts are independent — one file usually plays both roles, but it doesn't have to.

### Transitive dependency
A dependency pulled in indirectly: you depend on A, A depends on B, so B lands on your classpath without you declaring it.
- Inspect the whole graph with `mvn dependency:tree`.

### Dependency mediation — "nearest wins"
If different versions of the same dependency arrive through different paths, Maven uses the one **closest to your project** in the dependency tree.
- Example: `versionB1` of `depB` came in through `depA`, while `versionB2` of `depB` is declared directly in your `pom.xml`. Your direct declaration wins, because that version is nearest in the tree.
- **Tie-break:** at equal depth, the one declared **first** wins.
- Important for Java/Spring migration and version-uplift work: this is why an unexpected old version shows up, and why declaring it directly (or managing it in `<dependencyManagement>`) is the fix. `<dependencyManagement>` beats nearest-wins entirely.

### Maven profile
A named block of build configuration you switch on or off, letting you change plugins, dependencies, and properties per environment or purpose.

```xml
<profiles>
  <profile>
    <id>coverage</id>
    <properties><lineCoverage>0.80</lineCoverage></properties>
  </profile>
</profiles>
```
- Activate with `mvn clean install -Pcoverage`. Can also activate on a property, JDK version, or OS.

---

## Microservices & distributed systems

### Spring Boot vs Spring Cloud
- **Spring Boot** = build **one** service.
- **Spring Cloud** = help **many** services work together.

### Spring Cloud
A collection of Spring projects providing infrastructure and tooling for distributed systems and microservices — API gateways, centralized configuration, declarative REST clients, load balancing, and service discovery.
- Think of the artifacts as ready-made solutions to problems you only get once you have multiple Spring Boot services.

### Spring Cloud Config
Centralized configuration. All services fetch their DB URLs and settings from one config server instead of each holding its own copy.

### Spring Cloud Gateway
API gateway. A client calls `/orders` and the gateway routes it to the Order Service.

### Spring Cloud OpenFeign
Declarative service-to-service HTTP calls. Order Service calls User Service by declaring an interface, with no HTTP boilerplate.

### Spring Cloud LoadBalancer
Distributes requests across multiple instances of a service — User Service #1, #2, #3.

### Spring Cloud Kubernetes
Integrates Spring apps with Kubernetes, discovering services and configuration through Kubernetes primitives (Services, ConfigMaps, Secrets) instead of a separate registry.

### API gateway
A single entry point between clients and your backend services.
- Does: **routing**, **authentication**, **authorization**, **load balancing**, plus rate limiting, request/response transformation, and aggregation.

### API gateway vs load balancer
- **Load balancer** answers one question: *"Which instance should receive this request?"*
- **API gateway** answers three: *"Should this request be allowed, where should it go, and what should I do with it before and after forwarding it?"*

### Distributed SQL databases
Databases that expose a SQL-like interface while internally handling routing, sharding, and distributed execution across nodes.
- Examples: CockroachDB, Google Spanner, TiDB, YugabyteDB, SingleStore.
- You write `SELECT * FROM Orders WHERE customer_id = 15;` and the engine figures out which nodes hold the data.

---

## Libraries & tools

### Jackson
A Java library for converting between Java objects and JSON — serialization (Java → JSON) and deserialization (JSON → Java).
- Spring Boot auto-configures it, which is what makes `@RestController` return JSON.
- Useful annotations: `@JsonProperty`, `@JsonIgnore`, `@JsonInclude`, `@JsonFormat`.

```java
new User("Habiba", 25)
->
{ "name": "Habiba", "age": 25 }
```

### ModelMapper
An object-mapping library using **runtime reflection**, with no code generation.
- Easier setup and more flexible, but **slower** and less explicit — mismatches surface at runtime, not compile time.

### MapStruct
An object-mapping library using **compile-time code generation**.
- No reflection, type-safe, fast, and explicit — the generated mapper is plain Java you can read and step through. Errors appear at compile time.
- The generally preferred choice for production code.

### Redis
Single-threaded, in-memory data store built on a hash-map structure. Commonly used for caching, sessions, rate limiting, and pub/sub.
- Being single-threaded is why `INCR` and `SETNX` are atomic without any locking — and why one slow command (`KEYS *`) blocks everything.

---

## Spring version history

### Spring Framework 1.x
- Introduced the **IoC container** and **AOP** — the two ideas everything else is built on.

### Spring Framework 2.x
- **Annotation-based configuration** (`@Autowired`, `@Component`, `@Service`, `@Repository`), replacing XML.
- Better integration with Hibernate and JPA.
- The **Spring TestContext Framework** for testing.

### Spring Framework 3.x ⚠️
Java-based `@Configuration` / `@Bean`, **SpEL**, and `RestTemplate` — annotation config becomes first-class, not just a 2.x extra.
- ⚠️ Your notes listed Java 8 / 9 / 17 features under "Spring Framework 3". Spring 3 shipped in **2009**; Java 8 shipped in **2014**. Those language features live under **JDK, JRE & Java versions**.

### Spring Framework 4.x / 5.x
- **4.x** — Java 8 support (lambdas, `Optional`), `@RestController`, WebSocket support, `@Autowired` optional on a single constructor.
- **5.x** — Java 8 baseline, **WebFlux** reactive stack, Kotlin support, functional bean registration, JUnit 5 support.

### Spring Framework 6.x
- Java 17 baseline, **Jakarta EE 9+** namespace (`javax.*` → `jakarta.*`), AOT processing and GraalVM native image support, Micrometer Observation API replacing Sleuth.
- 6.1 added `RestClient` and `JdbcClient`, and virtual-thread support.
- This is the version underneath Spring Boot 3 — see the **Java & Spring migrations** topic.
---

## Java & Spring migrations (Spring Boot 2 → 3, Java 11 → 25)

### Why the upgrade happens at all
Old versions stop getting security patches, and the frameworks stop supporting them.
- Java LTS releases arrive every two years: **11 (2018) → 17 (2021) → 21 (2023) → 25 (2025)**. Non-LTS releases get six months of patches only, which is why teams hop LTS to LTS.
- Spring Boot 2.x reached end of open-source support in **November 2023**; anything after that is commercial extended support. That deadline is what drives most Boot 2 → 3 projects.
- The two upgrades are coupled: **Spring Boot 3 requires Java 17 as a minimum**, so you cannot do the framework jump without doing the Java jump.

### Spring Boot 2 → 3 — the baseline
Four things change at once, and all of them are mandatory.
- **Java 17 minimum** (21 or 25 recommended, for virtual threads).
- **Spring Framework 5 → 6.**
- **Jakarta EE 9+**, meaning the `javax.*` → `jakarta.*` package rename.
- **Hibernate 5 → 6** and **Spring Security 5 → 6**.
- Do them in this order: get onto the newest Boot 2.7.x first, fix all deprecation warnings there, upgrade Java, *then* jump to Boot 3. Fixing deprecations while still on 2.7 is far cheaper than debugging them on 3.x.

### `javax.*` → `jakarta.*`
The single largest mechanical change in the whole migration. Oracle kept the `javax` trademark, so Jakarta EE renamed every package.
- `javax.persistence.*` → `jakarta.persistence.*` (entities, `@Entity`, `@Id`, `EntityManager`)
- `javax.servlet.*` → `jakarta.servlet.*` (filters, `HttpServletRequest`)
- `javax.validation.*` → `jakarta.validation.*` (`@Valid`, `@NotNull`)
- `javax.annotation.*` → `jakarta.annotation.*` (`@PostConstruct`, `@PreDestroy`, `@RolesAllowed`)
- Still `javax` and unaffected: `javax.sql`, `javax.crypto`, `javax.net`, `javax.naming` — these are JDK packages, not Jakarta EE. Blind find-and-replace on `javax.` breaks them.
- Third-party libraries must also have a Jakarta-compatible release. Any library that hasn't shipped one is a hard blocker.

### Spring Security 5 → 6 — old → new
The API rewrite that causes the most churn.

| Spring Security 5 | Spring Security 6 |
|---|---|
| `extends WebSecurityConfigurerAdapter` | **removed** — expose a `SecurityFilterChain` bean instead |
| `configure(HttpSecurity http)` override | a `@Bean` method returning `SecurityFilterChain` |
| `authorizeRequests()` | `authorizeHttpRequests()` |
| `antMatchers()` / `mvcMatchers()` / `regexMatchers()` | `requestMatchers()` (one method, it infers the type) |
| `@EnableGlobalMethodSecurity(prePostEnabled = true)` | `@EnableMethodSecurity` (`prePostEnabled` on by default) |
| `WebSecurityConfigurerAdapter.authenticationManagerBean()` | an `AuthenticationManager` bean |
| `and()` chaining | lambda DSL (`http.csrf(c -> c.disable())`) |

```java
// Spring Security 6
@Configuration
@EnableWebSecurity
class SecurityConfig {
  @Bean
  SecurityFilterChain chain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(a -> a
        .requestMatchers("/public/**").permitAll()
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated())
      .oauth2ResourceServer(o -> o.jwt(Customizer.withDefaults()))
      .build();
  }
}
```
- Behaviour change to watch: roles are matched more strictly, and the default `ROLE_` prefixing trips people up during the rewrite.

### Hibernate 5 → 6
Runs underneath the JPA rename and quietly changes runtime behaviour, so this is where the surprises live.
- **Generated SQL changes.** Hibernate 6 rewrote its query engine, so native SQL assertions and hand-tuned queries can break.
- **Stricter type handling.** Implicit conversions Hibernate 5 tolerated now fail; `@Enumerated`, `Boolean`, and UUID mappings are the usual offenders.
- **`@GeneratedValue(strategy = AUTO)` changed default** for some databases — sequence-per-entity instead of a single shared one. Check your ID generation or you get duplicate keys.
- Legacy `hibernate.` properties were renamed; several `spring.jpa.properties.*` entries need updating.

### Spring MVC & web changes (Boot 2 → 3)
- **Trailing-slash matching is off by default.** `/orders` and `/orders/` are now different paths. Previously they matched. This silently 404s existing clients — the most common post-migration production bug.
- **`PathPatternParser` is the default** path matcher, replacing `AntPathMatcher`. `**` is only allowed at the end of a pattern now.
- `spring.mvc.pathmatch.matching-strategy` no longer accepts the old value in the same way.
- `RestTemplate` still works but is legacy — **`RestClient`** (Spring Framework 6.1 / Boot 3.2) is the modern synchronous client.

### Config, Actuator & observability changes
- **`@ConstructorBinding`** is no longer needed on a `@ConfigurationProperties` class with a single constructor, and it's now only valid on constructors, not types.
- **Actuator endpoints** changed shape: `/actuator/health` details are hidden by default, and several endpoint IDs and response fields moved.
- **Spring Cloud Sleuth is gone.** Tracing moved to **Micrometer Tracing** plus the Micrometer Observation API. This is a real rewrite if you had custom spans.
- Logging: the default log format changed, and Boot 3.4 added structured (JSON) logging out of the box.
- Run `spring-boot-properties-migrator` as a temporary dependency — it logs every renamed property at startup and tells you the new name. Remove it once you're clean.

### Testing changes (Boot 2 → 3)
- **JUnit 4 support removed from the starter.** `spring-boot-starter-test` no longer brings the vintage engine — add it explicitly or migrate the tests to JUnit 5.
- `@RunWith(SpringRunner.class)` → `@ExtendWith(SpringExtension.class)`, or just `@SpringBootTest` on its own.
- `@MockBean` / `@SpyBean` → **`@MockitoBean` / `@MockitoSpyBean`** (deprecated in Boot 3.4).
- Mockito 5 changed the default mock maker to **inline**, which means `final` classes now mock successfully — and some tests that relied on the old failure behaviour change.

### Java 11 → 17 — strong encapsulation
The change most likely to break your build, and it fails at runtime rather than compile time.
- Since Java 16, JDK internals are **strongly encapsulated by default** (JEP 396). Reflective access into `sun.*` or non-exported `jdk.internal.*` throws **`InaccessibleObjectException`**.
- The `--illegal-access=permit` escape hatch that worked on Java 11 is **no longer valid** on 17.
- Fixes, best first: switch to a standard API; upgrade the offending library to a version that doesn't reach into internals; as a last resort add `--add-opens` / `--add-exports` flags (which reopens the hole you just closed).
- Find them before they bite: **`jdeps --jdk-internals`** on your jars.

### Java 11 → 17 — what was removed
Removed outright, so these are compile or startup failures.
- **Applet API**, **RMI Activation**, **Pack200**, and the **Nashorn JavaScript engine** (removed in 15 — if you scripted anything, move to GraalVM JS).
- **CMS garbage collector** removed. Any `-XX:+UseConcMarkSweepGC` in your startup script must go — switch to **G1** (default), **ZGC**, or **Shenandoah**.
- **Invalid JVM flags now abort startup** instead of just warning. Audit every `-XX:` flag.
- **Security Manager deprecated for removal** (JEP 411).
- Scan for removed APIs with **`jdeprscan`**.

### Java 11 → 17 — what you gain
- **Records**, **sealed classes**, **pattern matching for `instanceof`**, **text blocks** (`"""`), **switch expressions**, **helpful `NullPointerException` messages** that name the exact null variable.

### Java 17 → 21
Mostly additive — this is the easy leg of the journey.
- **Virtual threads** (JEP 444). In Spring Boot 3.2+ turn them on with `spring.threads.virtual.enabled=true`. Biggest single win for an I/O-bound web service.
- **Sequenced collections** — `getFirst()`, `getLast()`, `reversed()` on `List`, `Set`, `Map`.
- **Pattern matching for `switch`** and **record patterns**, both final.
- **Generational ZGC.**
- Watch for: `synchronized` blocks **pin** a virtual thread to its carrier in 21, so hot paths should use `ReentrantLock`. Dynamic agent loading now warns (JEP 451) — affects some profilers and mocking libraries.
- Finalization is deprecated for removal; anything relying on `finalize()` needs replacing with `Cleaner` or try-with-resources.

### Java 21 → 25
Java 25 is the current LTS (September 2025). Mostly additive again, with two removals worth checking.
- **Security Manager permanently disabled** (JEP 486, Java 24). Calling `System.setSecurityManager` now throws. If anything still used it, this is a hard stop — replace with OS/container-level sandboxing.
- **`sun.misc.Unsafe` memory-access methods** deprecated for removal (23) and warn on use (24). Old libraries that use them log noisy warnings and will eventually break.
- **32-bit x86 port removed** (JEP 503) — only matters if you still build for 32-bit.
- **ZGC's non-generational mode removed** (Java 24); generational is now the only mode.
- New and final in 25: **module import declarations** (`import module java.base;` — one line instead of many), **compact source files and instance `main` methods** (no boilerplate class for small programs), **flexible constructor bodies** (statements allowed *before* `super()`), **scoped values** (a safer `ThreadLocal` for virtual threads), **compact object headers** (real heap savings), and a **Key Derivation Function API**.
- Still preview in 25, so don't rely on them: **structured concurrency**, **primitive types in patterns**, **stable values**.
- Also worth knowing across 22–24: **Foreign Function & Memory API** final (22), **unnamed variables** `_` (22), **stream gatherers** final (24), **class-file API** final (24), **AOT class loading and linking** (24) plus AOT ergonomics and method profiling (25) — meaningful JVM startup improvements.

### Migration playbook — the order that works
1. **Get to the latest patch of your current versions first** (Boot 2.7.x, Java 11 latest). Clean the build.
2. **Fix every deprecation warning while still on the old version.** Cheapest possible time to do it.
3. **Upgrade Java first, framework second.** Boot 2.7 runs fine on Java 17, so you isolate JVM problems from framework problems.
4. **Run `jdeps --jdk-internals` and `jdeprscan`**; fix or replace what they flag.
5. **Do `javax` → `jakarta`** with an automated tool, then review by hand — especially anything matching `javax.sql`, `javax.crypto`, `javax.net`.
6. **Upgrade Spring Boot**, add `spring-boot-properties-migrator`, and read every warning at startup.
7. **Rewrite the security config** — this is a rewrite, not a rename.
8. **Test the database layer hardest.** Hibernate 6 is where silent behaviour changes hide.
9. **Check trailing slashes** against every existing client before release.

### Migration tooling
- **OpenRewrite** (`rewrite-spring`, `rewrite-migrate-java`) — automated recipes that do most of the `javax` → `jakarta` rename, JUnit 4 → 5, and many Boot 3 upgrades. Run `mvn rewrite:run` with the recipe, review the diff.
- **`jdeps --jdk-internals`** — finds reflective access into JDK internals.
- **`jdeprscan`** — finds usage of removed and deprecated APIs.
- **`spring-boot-properties-migrator`** — logs renamed configuration properties at startup.
- **Maven Versions Plugin** (`mvn versions:display-dependency-updates`) — surfaces which dependencies still lack a Jakarta-compatible release.

### Migration pitfall: dependency mediation
The version that silently wins is the one **nearest** in the dependency tree, not the newest.
- During an uplift, an old transitive copy of a library can override the new one you thought you'd upgraded — and nothing warns you.
- Diagnose with `mvn dependency:tree`. Fix by declaring the version directly in `<dependencies>` or pinning it in `<dependencyManagement>`, which overrides nearest-wins entirely.
- Import the Spring Boot BOM rather than pinning Spring versions by hand; that's what keeps the whole stack consistent.

### What's next: Spring Boot 4 / Spring Framework 7
Released November 2025. Useful to know as the next hop, and it shows you're current.
- **Java 17 still the minimum**, but 21 or 25 strongly recommended.
- **Jakarta EE 11** — Servlet 6.1, JPA 3.2, Bean Validation 3.1.
- **Jackson 3 only** — Jackson 2 support dropped. This is the biggest mechanical change, much like `javax` → `jakarta` was for Boot 3.
- **JUnit 4 support removed entirely**; JUnit Jupiter 6 required.
- **Modules split up** — auto-configurations moved into smaller focused artifacts, so classpath scanning and native-image size shrink.
- New: built-in **API versioning**, **`@Retryable`** and **`@ConcurrencyLimit`** resilience annotations, declarative HTTP clients via **`@HttpExchange`**, **`RestTestClient`**, and **JSpecify** nullability annotations.
---

## How to update this cheat sheet

**The `.md` file is the master. The `.html` is generated from it.** So you always edit the markdown, then regenerate the HTML if you want the searchable version updated.

### The format — three rules

1. **`##` starts a topic.** It becomes a section, a filter chip, and a Contents entry.
2. **`###` starts a term.** It becomes one card.
3. **Inside a term, the split is the first bullet.** Everything before the first `- ` line is the definition (big text). Everything from the first `- ` onward becomes the notes (small bulleted text).

That's the whole system. Copy this template:

~~~markdown
### My new term
The short definition goes here. One or two sentences, the thing you want to say out loud in an interview.
- First extra note — a caveat, a follow-up answer, a gotcha.
- Second extra note. These render smaller and greyer than the definition.
~~~

### Extras you can use

- **Flag a term** by putting `⚠️` at the end of the `###` heading: `### My term ⚠️`. It gets a warning stripe and shows up under the "⚠️ Corrections only" filter.
- **Inline code** with backticks and **bold** with `**asterisks**` — both work in the heading and the body.
- **Code blocks** — fence them with triple backticks and a language (` ```java `). Leave a blank line before the fence.
- **Tables** — normal markdown pipe tables work, header row and all.
- Blank line between the definition and the first bullet is optional; either way parses the same.

### Where to put a new term

- Put it inside the topic it belongs to. Topics and terms render in **file order**, so position matters — drop the term where it makes sense next to its relatives, not at the bottom.
- To add a whole new topic, add a `## Topic name` heading. Place it in the file according to the basics → advanced ordering, since that's the reading order.
- Don't renumber or re-slug anything; anchors are generated from the names automatically.

### Regenerating the HTML

The HTML is built by `build_html.py`, which sits next to the markdown file.

~~~bash
pip install markdown        # once
python3 build_html.py       # rebuilds java-spring-cheatsheet.html
~~~

- It reads `java-spring-cheatsheet.md` and writes `java-spring-cheatsheet.html`. No other input, no network.
- Term counts, topic chips, and the Contents panel are all recalculated automatically — nothing to update by hand.
- If you'd rather not run the script, just keep editing the markdown and use that. The content is identical.

### One thing that is hand-maintained

The **⚠️ Corrections** table at the top of the file is written by hand. If you flag a new term with `⚠️`, add a matching row there too — or don't, if you only want the inline flag. Everything else generates itself.
