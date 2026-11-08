# B-Tree: Branching Factor and Node Structure

Source: https://app.notion.com/p/34ffc75cbbd980e297c7faf9d84cfcb1?pvs=204

## 1. Key Difference from Binary Trees

- <b>Binary Tree</b>: each node holds 1 key and has at most 2 children.
- <b>B-Tree</b>: each node holds multiple keys and can have many children.

---

## 2. Node Structure in a B-Tree

A single node can store multiple keys:

Example:

```txt
[10 | 20 | 30]
```

This is <b>one node</b>, not three.

---

## 3. Why k keys → k + 1 children

Each key splits the value space into ranges.

Example:

```txt
(-∞,10) | (10,20) | (20,30) | (30,∞)
   C1        C2        C3        C4
```

- 3 keys create 4 ranges
- Each range maps to a child pointer

👉 Therefore:

- If a node has <b>k keys → it has k + 1 children</b>

---

## 4. Branching Factor (b)

- Defined as: <b>number of children per node</b>
- In the example:
  - keys = 3
  - children = 4
  - → <b>b = 4</b>

In real databases:

- Nodes can store hundreds of keys
- → branching factor can be <b>100–1000+</b>

---

## 5. Why This Matters (Tree Height)

Tree height determines how many disk reads are needed.

Formula:

```txt
h ≈ log_b(N)
```

Where:

- N = number of records
- b = branching factor
- h = tree height

---

## 6. Intuition

- Bigger branching factor → fewer levels
- Fewer levels → fewer disk reads
- This is why B-Trees are efficient for databases

---

## 7. Common Misconception

❌ “Each node has 2 children” → only true for binary trees

✅ In B-Trees:

- Nodes are wide (many keys)
- Children count depends on number of keys (k + 1)

---

<h2>
8\) SQL structure storage 
</h2>

most SQL databases use <b>B-Tree (or B+Tree) indexes</b> for storage and querying.

---

## Where trees are used

- <b>Indexes (primary + secondary)</b> → almost always B+Tree
- <b>Table storage (clustered index)</b> → rows stored in B+Tree order (e.g., InnoDB in MySQL)

## Example

```sql
CREATETABLE users (
  idINTPRIMARYKEY,
  nameVARCHAR(100)
);
```

### What happens internally

- The <b>PRIMARY KEY (id)</b> is stored as a <b>B+Tree</b>
- Data is organized like:

```txt
            [50]
         /        \
   [10,20,30]   [60,70,80]
```

Leaf nodes (bottom) contain actual rows:

```txt
[10 → row] [20 → row] [30 → row]
```

---

## Query example

```txt
SELECT*FROM usersWHERE id=30;
```

### Execution (simplified)

1. Start at root → compare with 50 → go left
2. In node \[10,20,30\] → find 30
3. Jump to leaf → get row

👉 Only a few steps (tree height), not full scan

---

## Why B+Tree specifically

- Data is <b>sorted</b>
- Supports:
  - <code>=</code> (exact match)
  - <code>></code>, <code><</code>, <code>BETWEEN</code> (range queries)
- Leaf nodes are linked → fast sequential scan

## Real-world note

- One node = one disk page (e.g., 16KB)
- Can hold <b>hundreds of keys</b><br />→ branching factor \~100–1000<br />→ height usually <b>2–4 levels only</b>
