# DB Storage families (internal disk storage structure)

Source: https://app.notion.com/p/34ffc75cbbd98054a40fdd5afd39036d?pvs=204

### Page-oriented (mutable) → <b>B-Tree</b>

- You <b>update data in place</b> on disk pages.
- Disk is divided into fixed-size pages (e.g., 4KB).
- Tree nodes = pages.

### Log-structured (immutable) → <b>LSM Tree</b>

- You <b>never update in place</b>.
- You <b>append writes sequentially</b> (like a log).
- every now and then you migrate logs removing old/duplicated logs
- Old data is cleaned later

### <b>B-Tree</b>

- Page-based tree (nodes = disk pages)
- Updates <b>in place</b>
- Data always <b>organized</b>
- Read path = follow tree root → leaf

---

### <b>LSM Tree</b>

- Write to <b>memory (Memtable balanced tree)→ flush to disk as SSTables</b>
- Disk = <b>multiple sorted files</b>
- Updates = <b>append new version</b>
- Cleanup later via <b>compaction</b>

---

## Complexity (simplified)

| Operation | B-Tree | LSM Tree |
| --- | --- | --- |
| <b>Search</b> | <code>O(log N)</code> | <code>O(log N)</code> (but multiple files → higher constant) |
| <b>Insert (Put)</b> | <code>O(log N)</code> | <code>O(log N)</code> amortized (but very fast in practice due to sequential writes) |

An <b>SSTable is NOT a tree. </b>It’s a <b>sorted array on disk + a small index</b>

So why is search \~ O(log N)?

Inside <b>one SSTable</b>:

- Data is <b>sorted</b>
- You can do <b>binary search</b>

```txt
Find k → binary search → O(log N)
```

But LSM has MANY SSTable

<b>So real cost is:</b>

```txt
O(log N) × number_of_files
```

👉 That’s why:

- Theoretically \~ O(log N)
- Practically slower than B-tree

---

## Why performance feels different

### B-Tree

```txt
Few levels → direct lookup
```

→ predictable

---

### LSM

```txt
Search:
MemTable + SST1 + SST2 + ...
```

→ variable cost

---

## Mapping to your image

### <b>B-Tree side</b>

- <b>Faster in reads</b><br />→ one path down tree (few disk reads)
- <b>Slower in writes</b><br />→ random disk updates
- <b>Reliable</b><br />→ simple structure, less moving parts
- <b>Stable</b><br />→ latency doesn’t fluctuate much

---

### <b>LSM Tree side</b>

- <b>Faster in writes</b><br />→ append + sequential disk I/O
- <b>Write amplification</b><br />→ data rewritten during compaction
- <b>No fragmentation</b><br />→ always sequential writes (no scattered pages)

<p />

<p />

<page url="https://app.notion.com/p/350fc75cbbd9806d9e5ccf845dc598cc">
LSM Tree
</page>

<page url="https://app.notion.com/p/34ffc75cbbd980e297c7faf9d84cfcb1">
B-Tree: Branching Factor and Node Structure
</page>

<page url="https://app.notion.com/p/350fc75cbbd9803a82e3f6b46ca6e217">
Data Encoding
</page>

<page url="https://app.notion.com/p/356fc75cbbd980999ee3f251cc26ecdd">
DB index
</page>
