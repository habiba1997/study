# Database indexes and query plans

Reported 2026-10-25. Status: partial answer, explained, pending manual lab and later recall.

Scenario: `SELECT * FROM work_orders WHERE project_id = ? ORDER BY created_at DESC LIMIT 20`.

Habiba proposed an index on project_id, which may help filtering. Gap: a composite B-tree index on `(project_id, created_at DESC)` can support both the equality filter and requested ordering; verify, do not assume. Also review B-tree lookup, column order, selectivity, write/storage costs, and why small tables or low-selectivity queries can use Seq Scan.

EXPLAIN is the planner's proposed execution tree. EXPLAIN (ANALYZE, BUFFERS) executes a SELECT and reports actual time/row counts/I/O. Compare plan nodes, row estimates versus actual, Sort, scan type, buffers, and execution time before/after. Never treat estimated cost units as milliseconds.

Hands-on: [local PostgreSQL lab](../Hands-On/PostgreSQL-Explain-Index-Lab.md). After doing it, ask for one observation and a follow-up on why the planner may prefer a scan. No mastery score yet.
