# LSM Tree

Source: https://app.notion.com/p/350fc75cbbd9806d9e5ccf845dc598cc?pvs=204

LSM Tree

An <b>LSM tree = a system that stores key–value data across multiple sorted layers</b>:

- <b>RAM layer</b> → fast writes
- <b>Disk layers (files)</b> → immutable, sorted

It’s still just:

```txt
key → value
```

Example:

```txt
"user:1" → "Habiba"
"user:2" → "Ali"
```

# Where data lives

## In memory (MemTable)

Think:

```txt
TreeMap / SortedMap

{
  "user:1": "Habiba",
  "user:2": "Ali"
}
```

- Sorted by key
- Fast inserts

---

## On disk (SSTables)

Each file is:

```txt
Sorted file (immutable)

SSTable1:
"user:1" → "Habiba"
"user:3" → "Omar"

SSTable2:
"user:2" → "Ali"
"user:4" → "Mona"
```

👉 These are just <b>files</b>, not trees

👉 Internally like arrays + index

<b>SSTable = Sorted String Table</b>

Ignore the name — it simply means:

> <b>an immutable file on disk that stores sorted key–value pairs</b>

# Write flow (step by step)

### Step 1 — Write comes in

```txt
PUT("user:1", "Habiba")
```

Goes to:

```txt
MemTable
```

---

### Step 2 — More writes

```txt
PUT("user:2", "Ali")
PUT("user:3", "Omar")
```

MemTable:

```txt
{
  user:1 → Habiba
  user:2 → Ali
  user:3 → Omar
}
```

---

### Step 3 — Memory full → flush

Write to disk as <b>one sorted file</b>:

```txt
SSTable1:
user:1 → Habiba
user:2 → Ali
user:3 → Omar
```

MemTable becomes empty

---

### Step 4 — More writes

```txt
PUT("user:2", "Ali_v2")
```

MemTable:

```txt
user:2 → Ali_v2
```

Flush again →

```txt
SSTable2:
user:2 → Ali_v2
```

---

# 4) IMPORTANT: duplicate keys exist

Now disk has:

```txt
SSTable1: user:2 → Ali
SSTable2: user:2 → Ali_v2
```

👉 Both exist

👉 Latest one is correct

---

# 5) How reads work

To read:

```txt
GET("user:2")
```

System checks:

1. MemTable
2. Newest SSTable
3. Older SSTables

```txt
Find in SSTable2 → Ali_v2 → return
```

---

# 6) What is inside an SSTable (important)

It’s NOT random.

Each SSTable:

```txt
[ sorted key-value pairs ]
+ index (to jump fast)
```

Example:

```txt
Keys: [user:1, user:2, user:3]

Binary search → jump to position
```

👉 That’s why reads are still reasonable

---

# 7) What is compaction

Over time:

```txt
SST1: user:2 → Ali
SST2: user:2 → Ali_v2
SST3: user:2 → Ali_v3
```

Too many duplicates → slow reads

---

### Compaction does:

```txt
Merge → keep latest
```

Result:

```txt
SST_new:
user:2 → Ali_v3
```

Old files deleted

---

# 8) Why LSM is fast for writes

Because writes are:

```txt
Append → memory → sequential disk write
```

No:

- searching pages
- modifying existing data

<br />• LSM = popular in NoSQL + modern systems<br />B-tree = classic SQL<br />

## Used in NoSQL:

- Cassandra
- DynamoDB
- RocksDB

# Real-world analogy

### B-Tree

```txt
Library:
You go update a book directly on the shelf
```

---

### LSM

```txt
You keep writing notes in notebooks
Later → organize them into clean books (compaction)
```

# One full example (end-to-end)

### Writes:

```txt
PUT(A,1)
PUT(B,2)
→ flush → SST1

PUT(A,3)
→ flush → SST2
```

Disk:

```txt
SST1: A=1, B=2
SST2: A=3
```

---

### Read A:

```txt
Check SST2 → A=3 → done
```

---

### Compaction:

```txt
Merge →

SST_new: A=3, B=2
```
