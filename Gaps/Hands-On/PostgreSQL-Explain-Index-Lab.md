# PostgreSQL query-plan and index lab

Status: requested 2026-10-25; not performed yet. Goal: understand what an index is, why column order matters, and what EXPLAIN shows. Use a local/development PostgreSQL connection in one session, not a production table. No application code required.

## Concepts first

A B-tree index is an ordered lookup structure containing keys and row locations. It can reduce rows examined for a selective predicate and provide the required ordering. It costs storage and write/update overhead. For `WHERE project_id = ? ORDER BY created_at DESC LIMIT 20`, test `(project_id, created_at DESC)` rather than only project_id; the equality key identifies the project and the next key supports recent-first order. The planner can still choose a scan if the table is small, many rows qualify, statistics differ, or the query needs many heap fetches.

A query plan is the database's chosen execution steps: Seq Scan (read table), Index Scan (use index), Sort, and Limit. EXPLAIN shows estimates; EXPLAIN (ANALYZE, BUFFERS) *executes* the query and shows actual time/rows/buffer use. Use SELECT for the exercise. Compare the same query and parameter before/after, with realistic data and repeated runs; caches can change times. Costs are planner estimates, not milliseconds.

## Safe local exercise, one SQL session

Run in your SQL console/pgAdmin query tool against a disposable database. This temp table is session-scoped; create and inspect it in the same connection. The SELECT queries are read-only, while table/index creation affects only the temporary table.

```sql
CREATE TEMP TABLE work_orders_practice AS
SELECT g AS id,
       (g % 100) + 1 AS project_id,
       timestamp '2026-01-01' + g * interval '1 minute' AS created_at,
       repeat('x', 100) AS payload
FROM generate_series(1, 100000) AS g;

ANALYZE work_orders_practice;

EXPLAIN (ANALYZE, BUFFERS)
SELECT * FROM work_orders_practice
WHERE project_id = 42
ORDER BY created_at DESC
LIMIT 20;

CREATE INDEX work_orders_practice_project_created_idx
ON work_orders_practice (project_id, created_at DESC);

ANALYZE work_orders_practice;

EXPLAIN (ANALYZE, BUFFERS)
SELECT * FROM work_orders_practice
WHERE project_id = 42
ORDER BY created_at DESC
LIMIT 20;
```

Observe: Seq Scan vs Index Scan, presence/absence of Sort, actual rows/loops, Rows Removed by Filter, Execution Time, Buffers shared/local hit/read (temp relations may report local). Index access plus Limit often avoids reading/sorting all candidate rows. Do not assert a speedup without the observed plan; test table size and cache matter. A real production index must be planned separately, especially write/load impact and concurrent build procedure.

Bring the two plans back to chat; explain three changes in plain English and identify whether the index actually helped. Later recall: why does project_id alone not necessarily avoid sorting by created_at?

Reference: https://www.postgresql.org/docs/current/using-explain.html
