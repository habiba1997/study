# Manual pagination practice
Status: not attempted. Work on paper first, then optionally run in PostgreSQL.
Goal: understand OFFSET, keyset cursors, timestamp ties and composite indexes.

## Setup
Use a scratch database. TEMP table exists only in your current session.
```sql
CREATE TEMP TABLE pagination_practice (
 id int PRIMARY KEY, project_id int NOT NULL,
 created_at timestamp NOT NULL, description text
);
INSERT INTO pagination_practice VALUES
(120,7,'2026-10-29 10:20','A'),
(119,7,'2026-10-29 10:19','B'),
(118,7,'2026-10-29 10:19','C'),
(117,7,'2026-10-29 10:19','D'),
(116,7,'2026-10-29 10:16','E'),
(115,7,'2026-10-29 10:15','F'),
(114,7,'2026-10-29 10:14','G'),
(113,8,'2026-10-29 10:13','Other project');
```
Rows ordered for project7:
| ID | Time |
|---|---|
|120|10:20|
|119|10:19|
|118|10:19|
|117|10:19|
|116|10:16|
|115|10:15|
|114|10:14|

## Tasks: predict before executing
1. Page size is 3. Write the first page IDs and its last (timestamp,ID) pair.
```sql
SELECT * FROM pagination_practice WHERE project_id=7
ORDER BY created_at DESC,id DESC LIMIT 3;
```
2. A new row arrives before page2:
```sql
INSERT INTO pagination_practice VALUES
(121,7,'2026-10-29 10:21','New');
```
Predict page2 using OFFSET. Which ID repeats?
```sql
SELECT * FROM pagination_practice WHERE project_id=7
ORDER BY created_at DESC,id DESC LIMIT 3 OFFSET 3;
```
3. Fill these placeholders using the last row from your ORIGINAL page1:
```sql
SELECT * FROM pagination_practice
WHERE project_id=7 AND (created_at,id)<(TIMESTAMP '<last timestamp>',<last id>)
ORDER BY created_at DESC,id DESC LIMIT 3;
```
4. Predict page2 if you use ONLY created_at < last_timestamp. Which row is skipped?
5. Explain why the correct condition includes equality:
created_at < last_time OR (created_at = last_time AND id < last_id).
6. Use the last row of keyset page2 to request page3.
7. Optional: add the index and run EXPLAIN. A small table may still use a sequential scan.
```sql
CREATE INDEX ON pagination_practice(project_id,created_at DESC,id DESC);
```
Does this index alone remove OFFSET duplicates? Why must the query still include ORDER BY?

## Check only after attempting
- Original page1:120,119,118. Cursor:(2026-10-29 10:19,118).
- OFFSET page2 after insert:118,117,116.118 repeats.
- Keyset page2:117,116,115.
- Timestamp-only page2:116,115,114; skips117 with the same timestamp as cursor.
- Keyset page3:114.
- Index helps access/order; it cannot stop OFFSET positions shifting.
- Tuple comparison is lexicographic; an older timestamp qualifies regardless of ID.
- These examples assume stable, non-null ordering keys; keyset does not freeze all data into a snapshot.
