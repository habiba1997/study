- String.concat() creates a new string, but you did not assign it to same string. A String is immutable, and you need to reassign it if you want a new value. String Builder is mutable.
StringBuilder.append() changes the builder. 
- StringBuffer's methods are synchronized, which makes it safer if multiple threads touch the same instance. But slower
- An interface can have fields, but they are constants (public static final)
- Java 8 added default and static methods with bodies; Java 9 added private helper methods. Interface methods cannot be protected.
- The fourth commonly named OOP principle is abstraction.
- An abstract class can have zero abstract methods. If it has abstract methods, a concrete subclass must implement them. it can look like a normal class, but the key difference is: you cannot instantiate an abstract class directly. Usually because the class is meant to be only a base class.You want to provide shared implementation, but you want to force developers to create a specific subtype instead of creating the generic parent.
- Animal animal = new Dog(); Instance methods are virtual in Java. So the version on the actual object runs. Whch in this case the Dog method run. This is overriding and runtime polymorphism
If makeSound() were static in both classes(Dog and Animal), It would print “Animal, Static methods are resolved at compile time based on the reference type. They are hidden, not overridden.
- You cannot you overload by only changing the return type.
- HashMap: Think an array of buckets plus a hash function, It takes the key's hashCode, turns that into an array index. suppose two different keys end up in the same bucket. That's a collision. Two collision strategies as separate chaining and open addressing.  
  - Separate chaining means the bucket can contain multiple entries. Traditionally, think of each bucket as pointing to a linked list
  - open addressing: If the calculated slot is occupied, you probe for another slot, less pointer overhead but the downside is that performance gets worse as the table becomes crowded.
- Hash table = general data-structure concept. 
- **Field access** is determined by the **reference type** (compile time).
- **Methods can be overridden**. **Method calls** are determined by the **actual object type** (runtime polymorphism).
- Vercel is a cloud platform and frontend-as-a-service (FaaS) company that lets developers build, deploy, and scale web applications quickly without managing underlying servers.
- Kubernetes vs. Traditional Code Sandboxes (For AI & Untrusted Code)

When running untrusted code—such as code generated on the fly by an AI agent—traditional containers (like standard Docker containers used in Kubernetes) share the host machine's Linux kernel. If an AI agent generates malicious code, it could break out of the container and compromise the host. Sanboxes are miliseonds to start while kuberneters takes seconds to minutes. 
- Dedicated Code Sandbox : Built for ephemeral, isolated code execution. Uses kernel-level isolation or microVMs.
- k8s: Built for stateless, long-running microservices with predictable traffic.Shares the host OS kernel; Startup Speed: Seconds to minutes (due to pulling images, scheduling, and pod initialization).
- In Java, static methods cannot be overridden. If you define a static method in a child class with the exact same signature as a static method in the parent class, it results in method hiding, not overriding.
If you attempt to use the @Override annotation on a static method, the compiler will throw a compile-time error stating that the method cannot override a static method from its superclass.

What is Method Hiding?

Unlike instance methods which rely on dynamic (runtime) binding, static methods use static (compile-time) binding. This means the Java compiler decides which method to run based on the reference type of the variable at compile time, rather than the actual object type at runtime.

Direct Comparison: Overriding vs. Hiding

| Feature | Instance method (overriding) | Static method (method hiding) |
| --- | --- | --- |
| Binding time | Runtime (dynamic binding) | Compile-time (static binding) |
| Resolution rule | Actual object type | Reference variable type |
| Polymorphism | Yes | No |


## 2026-10-21 — Workers interview follow-up

Reported from the recent interview, reconstructed from memory. The scheduling requirement is incomplete; distinguish confirmed details from the practice assumptions below. Scheduled interview reminders remain paused. Revisit these notes when Habiba resumes live practice.

### What was understood and what needs practice

- Understood: filter workers by whether their trades contain the requested trade, order matching workers by cost, and get the first worker's email.
- Reported gaps: writing Comparator lambdas and method references; understanding comparator signs and ascending/descending order; analyzing sorting complexity.
- Uncertain requirement, not a proven algorithm failure: reconstructing the multi-day assignment question. Habiba did not have time to finish and cannot recall the full contract.
- No mastery percentage assigned from this report. Naming a gap clearly is useful confidence calibration; forgetting syntax does not erase the correct high-level approach.

### Comparator: two objects in, an ordering result out

For compare(a, b):

| Result | Meaning |
| --- | --- |
| Negative | a comes before b |
| Zero | Same rank under this comparator |
| Positive | a comes after b |

For ascending cost:

```java
Comparator<Workers> byCost =
    (a, b) -> Integer.compare(a.getCost(), b.getCost());

// Equivalent, shorter:
Comparator<Workers> byCostShort =
    Comparator.comparingInt(Workers::getCost);
```

Integer.compare(40, 70) is negative, so the worker costing 40 goes first.
Integer.compare(70, 40) is positive, so the worker costing 70 goes after the worker costing 40.
Integer.compare(40, 40) is zero. Equal comparison rank does not mean two workers are the same object.

Workers::getCost means "given a worker, call its getCost() method." Here it is equivalent to w -> w.getCost(). comparingInt builds the two-worker comparison for you.

Avoid a.getCost() - b.getCost(): subtraction can overflow for general int values.
Use byCost.reversed() for highest cost first.
Use byCost.thenComparing(Workers::getEmail) if the agreed tie-breaker is alphabetical email; that is a chosen policy, not an original requirement remembered from the interview.

Examples assume non-null workers, emails, trades lists, trade strings, and costs; unique worker emails identify workers. Integer cost is unboxed for comparingInt. A nullable cost requires an explicit validation or null-ordering policy.

### Cheapest worker for one trade

Methods below go inside a containing class; imports are java.util.*.
Workers provides getEmail(), getCost(), and getTrades().

The originally proposed approach is valid:

```java
static Optional<String> cheapestEmailBySorting(
        List<Workers> workers, String trade) {
    return workers.stream()
        .filter(w -> w.getTrades().contains(trade))
        .sorted(Comparator.comparingInt(Workers::getCost))
        .findFirst()
        .map(Workers::getEmail);
}
```

If only one cheapest worker is required, avoid sorting all matches:

```java
static Optional<String> cheapestEmail(
        List<Workers> workers, String trade) {
    return workers.stream()
        .filter(w -> w.getTrades().contains(trade))
        .min(Comparator.comparingInt(Workers::getCost))
        .map(Workers::getEmail);
}
```

Optional.empty() means no worker matches. If an existing skeleton requires String rather than Optional<String>, agree whether to return a sentinel, null, or throw an exception instead. Do not call get() without handling absence. If ties matter, agree the policy and add a tie-breaker; do not assume min promises the same first-tie behavior as stable sorting.

### Time complexity

Let n = all workers, m = matching workers, and t = maximum number of trades in a worker's List<String>. Treat string equality and numeric comparison as constant-time for this discussion.

| Step | Cost |
| --- | --- |
| Filter using List.contains | O(n * t) worst case |
| Sort m matching workers | O(m log m) worst case for the standard Java object sorting implementation |
| Find minimum among m matches | O(m) |
| Whole filter + sort + first pipeline | O(n * t + m log m) |
| Whole filter + min pipeline | O(n * t + m) |

For bounded trade lists, these simplify to O(n + m log m) versus O(n); with m approximately n, sorting is O(n log n). Sequential stages add; the sorting step itself is n log n, not n + log n.

The normal sorting pipeline must collect and order the matches before yielding the first result. findFirst does not turn that pipeline into a linear minimum search. Stream.sorted specifies ordering semantics rather than a universal Big-O guarantee across every possible source/implementation; these interview bounds describe the ordinary unsorted List stream with the standard JDK implementation.

Sorting buffers O(m) workers; sequential min needs O(1) additional selection state. Turning trades into sets can make repeated membership checks expected O(1), but building/storing those sets also costs time and space.

### Scheduling and later recall

See [worker assignment and scheduling](Gaps/Domains/Worker-Assignment-and-Scheduling.md) for the assumptions, example, and Java 8 solution to one explicitly reconstructed version.

Terminology and short recall prompts: [comparators and complexity](Gaps/Terminology/Java-Comparators-and-Complexity.md).

Primary references:
- https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
- https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
- https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html
