# Redis

Source: https://app.notion.com/p/356fc75cbbd9801f8760fb6988bce04c?pvs=204

Redis is <b>remote, shared </b><b><u>IN-MEMORY</u></b><b> with data structures</b>

👉 It stores <b>typed data structures as values</b>

<br /><code>key → value (where value = data structure)</code><br />"queue:jobs" → LIST<br />"user:1"     → HASH<br />"leaderboard"→ SORTED SET

- Redis is <b>single-threaded</b>
- One command executes fully before next
- → ✔ Atomic by default

# Serialization overhead”

### Disk DB:

```txt
object → bytes → disk → bytes → object
```

### Redis:

```txt
object → stored in memory structure
```

👉 Less conversion → faster

# Complex locking (this is the subtle part)

## Disk-based DB (multi-threaded)

- Many threads reading/writing
- Needs:
  - row locks
  - page locks
  - transaction locks

👉 To avoid corruption

---

## Redis

- Single-threaded
- No parallel writes

👉 So:

- No locks needed
- Simpler + faster

# How Redis becomes a queue” (in plain words)

Think of Redis like this:

> You have a <b>named list stored on a server</b>

```txt
"jobs" → [ ]
```

Now operations:

```txt
LPUSH jobs A   → [A]
LPUSH jobs B   → [B, A]
RPOP jobs      → returns A, list becomes [B]
```

👉 Why is this a queue?

- You <b>add on one side</b> (left)
- You <b>remove from the other side</b> (right)
- That gives <b>FIFO (first in, first out)</b>

So:

- A was added first
- A is removed first

👉 That’s literally what a queue is.

---

# 🔹 2. What “O(1)” means here

When Redis does:

```txt
LPUSH / RPOP
```

It:

- does NOT scan the list
- does NOT move everything

It just:

- updates pointers in memory

👉 So it’s always fast, regardless of size
