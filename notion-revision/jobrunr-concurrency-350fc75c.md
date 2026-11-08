# JobRunr Concurrency

Source: https://app.notion.com/p/350fc75cbbd9801f8b82d2ddaa750772?pvs=204

### 1. Core Idea

- JobRunr supports <b>distributed processing</b>
- Multiple pods → all share:
  - same DB (<code>jobrunr_jobs</code>)
  - same job queue

➡️ Concurrency happens <b>across pods</b>, not just threads

---

### 2. Common Misconception

❌ “each job runs in isolation (own memory/thread)”

✔ True only inside one JVM

❌ False in distributed system

---

### 3. Default Behavior

- Recurring jobs:
  - <code>maxConcurrentJobs = 1</code>
  - prevents overlap <b>for same recurring job only</b>

❌ Not a global lock

---

### 4. When Concurrency Happens

- Multiple pods processing jobs
- Same job triggered multiple times
- Jobs touching same DB data
- Manual enqueue (no restriction)

---

### 5. Where Problems Actually Occur

Mostly in <b>database layer</b>:

- duplicate inserts
- lost updates
- race conditions

---

### 6. Key Concept

- Workers = <b>stateless</b>
- DB = <b>single source of truth</b>

---

### 7. What You Must Handle

JobRunr does NOT handle business locking

You need:

<b>A. DB protection</b>

- unique constraints
- optimistic locking
- <code>SELECT FOR UPDATE</code>

<b>B. Distributed locks</b>

- Redis / DB locks

<b>C. Idempotency (best)</b>

```txt
if (alreadyProcessed(id))return;
```

---

### 8. Final Mental Model

- JobRunr = execution engine
- You = concurrency control

➡️ “Can these jobs run at the same time?” → <b>your responsibility</b>
