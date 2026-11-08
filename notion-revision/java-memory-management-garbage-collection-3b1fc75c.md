# Java Memory Management & Garbage Collection

Source: https://app.notion.com/p/3b1fc75cbbd980e097ccf91e56ae5f7d?pvs=204

---

JVM manages memory by dividing it into:

- <b>Stack Memory</b>
- <b>Heap Memory</b>

```txt
JVM
├── Stack (per thread)
└── Heap (shared)
```

---

# Stack Memory

### Stores

- Primitive variables (<code>int</code>, <code>double</code>, etc.)
- Method stack frames
- References to heap objects
- <b>Local variables</b> → variables declared inside methods (scope/lifetime — primitive and reference).

### Characteristics

- Works in <b>LIFO (Last In First Out)</b> order
- Variables exist <b>only within their scope (method scope)</b>
- Fast allocation/deallocation
- Overflow ⇒ <b>StackOverflowError</b>

---

## Example

```txt
public static void main(String[] args) {
    int age = 25;

    Person p = new Person();

    test(p);
}

void test(Person p) {
    String name = "John";
}
```

### Stack

```txt
Main Frame
-----------
age = 25
p ---> Person Object

Test Frame
-----------
p ---> Person Object
name ---> "John"
```

When <code>test()</code> finishes:

- Test frame removed
- <code>name</code> removed
- reference <code>p</code> inside test removed

When <code>main()</code> finishes:

- Main frame removed
- Remaining references disappear

---

# Heap Memory

### Stores

- Objects, Arrays, String Pool, Instance variables (= new xxx())
  ## String Literal

  <p>
  Created <b>without </b><b><code>new</code></b>.
  </p>

  ```txt
  Strings1="Hello";Strings2="Hello";
  ```

  <p>
  Java first checks the <b>String Pool</b> (which lives in the Heap).
  </p>

  <p>
  If <code>"Hello"</code> already exists, it <b>reuses the same object</b>.
  </p>

  ```txt
  Stack                 Heap (String Pool)

  s1 ───────────────► "Hello"
  s2 ───────────────► "Hello"
  ```

  <p>
  ✅ Only <b>one</b> <code>"Hello"</code> object exists.
  </p>

  ---

  ## String Object

  <p>
  Created using <code>new</code>.
  </p>

  ```txt
  Strings1=newString("Hello");Strings2=newString("Hello");
  ```

  <p>
  Java creates a <b>new object every time</b>.
  </p>

  ```txt
  Stack                     Heap

  s1 ─────────► String Object #1 ("Hello")

  s2 ─────────► String Object #2 ("Hello")
  ```

  <p>
  Even if <code>"Hello"</code> already exists in the String Pool, the <code>new</code> keyword forces another object to be created.
  </p>

Heap is:

- Shared by all threads
- Larger than Stack
- <b>Managed by Garbage Collector</b>

---

# Stack vs Heap

### How does Stack clean itself automatically?

The key idea is:

> <b>You never manually free stack memory.</b>

The JVM manages it using <b>method stack frames</b>.

| Stack | Heap |
| --- | --- |
| Primitive values | Objects |
| References | Actual objects |
| Per thread | Shared |
| <u>Automatic cleanup</u> | <u>Garbage Collector cleans</u> |
| Fast | Slower |

---

# Object References

## Strong Reference (default)

```txt
Person p = new Person();
```

Object <b>cannot</b> be collected while referenced.

---

## Weak Reference

```txt
WeakReference<Person>p=newWeakReference<>(newPerson());
```

GC may delete it anytime.

```txt
p.get();// may return null
```

---

## Soft Reference

```txt
SoftReference<Person>p=newSoftReference<>(newPerson());
```

GC removes it <b>only when memory is low (no space full capacity is about to happen)</b>.

Useful for caches.

---

# Making Objects Eligible for GC

### Assign null

```txt
Person p = new Person();

p = null;
```

---

### Lose the reference

```txt
PerPerson p1 = new Person();
Person p2 = new Person();

p1 = p2;
```

Original object becomes unreachable.

---

# Garbage Collector (GC)

GC removes <b>unreferenced objects</b> from Heap.

Developer <b>cannot explicitly force GC</b>.

```txt
System.gc();
```

Only <b>requests</b> GC.

<u>JVM decides </u><b><u>whether and when</u></b><u> to run it.</u>

---

# Heap Structure

```txt
Heap
│
├── Young Generation
│     ├── Eden
│     ├── Survivor S0
│     └── Survivor S1
│
└── Old Generation
```

Outside Heap:

```txt
Metaspace
```

---

# Young Generation Lifecycle

New objects always start in <b>Eden</b>.

```txt
New Object
     ↓
   Eden
```

Minor GC:

→ Mark an sweep algorithm of GC runs

1. Mark live objects
2. Delete dead objects (sweep)
3. Move survivors to Survivor space with age incremented (step 4)
4. Increase object age

```txt
Eden
 ↓
S0
 ↓
S1
 ↓
S0
```

After reaching an <b>age threshold</b>, object moves to Old Generation.

---

# Minor vs Major GC

### Minor GC

- Young Generation
- Fast
- Runs frequently

### Major GC

- Old Generation
- Slower
- Runs less often

---

# Metaspace

Stores:

- Class metadata
- Static variables
- Constants
- Class definitions

Notes:

- Replaced <u>PermGen</u> in newer Java versions
- <u>Can expand dynamically</u>

---

<h1>
Garbage collector algorithms 
</h1>

### Mark & Sweep Algorithm

### Step 1 — Mark

Find reachable objects.

### Step 2 — Sweep

Delete unreachable objects.

---

## Mark-Sweep-Compact

After deleting:

```txt
[Obj][ ][Obj][ ][Obj]
```

Compaction becomes:

```txt
[Obj][Obj][Obj][Free Space]
```

Reduces memory fragmentation.

---

# Garbage Collector Types

## 1. Serial GC

- One GC thread
- Stop-The-World
- Slowest

---

## 2. Parallel GC

- Multiple GC threads
- Faster cleanup
- Still pauses application

---

## 3. CMS (Concurrent Mark Sweep)

- Runs mostly alongside application
- Reduces pause time
- not 100% concurrent
- No memory compaction

---

## 4. G1 GC

Modern collector.

Benefits:

- Minimal pauses
- Compaction included
- Better throughput more requests to be reached to app as there are no pause time
- Lower latency
