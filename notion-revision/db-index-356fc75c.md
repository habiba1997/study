# DB index

Source: https://app.notion.com/p/356fc75cbbd980999ee3f251cc26ecdd?pvs=204

## Clustered Index

- <b>Definition:</b> Table data is physically stored in the same order as the index.
- <b>Implication:</b> Index = actual data layout.<br />

---

## 🔹 Unclustered Index (Secondary Index)

- <b>Definition:</b> Index stores pointers → actual rows stored separately.
- <b>Implication:</b> Extra lookup step (index → row)
- <b>Yes, a non-clustered index is almost always implemented as a B-tree</b> (specifically, B+ tree in most relational databases like SQL Server and MySQL/InnoDB)

<b>Leaf Nodes:</b> Unlike a clustered index (which stores the actual data rows at the leaf nodes), the leaf nodes of a non-clustered index contain the key value and a <b>pointer</b> (row locator) to the actual data. \[[1](https://learn.microsoft.com/en-us/sql/relational-databases/indexes/clustered-and-nonclustered-indexes-described?view=sql-server-ver17), [2](https://medium.com/@mukeshreddymavurapu/b-tree-b-tree-indexing-in-sql-server-a-beginners-deep-dive-195ee4afbe0e), [3](https://tarunjain07.medium.com/clustered-vs-nonclustered-index-b5dfc0221abc), [4](https://www.linkedin.com/pulse/key-differences-between-clustered-non-clustered-indexes-sodunke-oft1f), [5](https://www.dremio.com/wiki/non-clustered-index/)\]

## Cost comparison

| Operation | Clustered | Unclustered |
| --- | --- | --- |
| Insert row | expensive | cheap |
| Maintain index | expensive | moderate |
| Page splits | heavy (data pages) | lighter (index pages) |
