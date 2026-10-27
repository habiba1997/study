# Review of questions 15–24 — 27 October 2026

Status: explanations provided; independent recall still required. No mastery percentage assigned.
Use question numbers and a short restatement when grading. Explain unfamiliar premises before grading. Separate correctness from confidence. MCQ recall for known terms; discussion for new architecture/design scenarios.

## 15 — First repeated integer; -1 when none
Habiba's HashSet algorithm is correct for the stated contract: iterate, return first element already seen, otherwise add; return -1 after loop. Prior "partially correct" assessment conflated algorithm correctness with API contract critique.
Contract ambiguity: [-1,4,-1] returns -1 meaning a repeat; [4,5] returns -1 meaning none. Caller cannot distinguish. Use OptionalInt.of(value) vs OptionalInt.empty(), or explicit found/value result. Sentinel value is the recall term.
Confidence: confidence in algorithm justified; missing issue was result representation.

## 16 — TreeSet and ordered deduplication
HashSet: unspecified iteration order. LinkedHashSet: insertion order. TreeSet: sorted natural/comparator order, backed by TreeMap, add/remove/contains O(log n).
Example input B,A,B,C => LinkedHashSet B,A,C; TreeSet A,B,C.
TreeSet uniqueness follows comparison result zero, so a comparator comparing worker cost only can collapse distinct workers with equal cost. Keep ordering consistent with equals for normal Set semantics.
Status: new concept, teach then retest.

## 17 — Strategy and branching
Correct: branching here means if/else or switch selecting card/wallet/bank transfer behavior. Strategy encapsulates interchangeable behavior behind a common interface. Selection may still exist in a configuration/map; it does not eliminate every conditional.
NotificationSender.send(recipient,message), EmailSender, SmsSender, NotificationService constructor injection. Service delegates to sender; transport implementation belongs in concrete strategy.
Factory concerns constructing/selecting objects; Strategy concerns interchangeable behavior. Both can coexist.
Confidence: correct recognition; terminology clarification rather than failure.

## 18 — Comparator fundamentals
Needs explanation and practice writing comparator explicitly before fluent shorthand.
Comparator<Workers> c = (a,b) -> {
  int byCost = Integer.compare(a.getCost(),b.getCost());
  if (byCost != 0) return byCost;
  return a.getEmail().compareTo(b.getEmail());
};
Equivalent: Comparator.comparingInt(Workers::getCost).thenComparing(Workers::getEmail).
comparingInt takes an extraction function T -> int and builds a comparator; thenComparing only runs second comparison if first returns zero.
Negative a before b; zero tied ordering; positive a after b. Comparator returns ordering, not a worker.
Assume non-null workers, costs and emails for example; boxed Integer cost must be unboxed and null policy clarified.
workers.stream().filter(w -> w.getTrades().contains(trade)).min(c).map(Workers::getEmail) => Optional<String>.
min scans candidates retaining best, O(m) comparisons, empty Optional for no match; sorted/findFirst O(m log m) sort, plus filtering. Filtering trades membership costs also count.
Do not subtract ints; overflow can reverse sign. Cost ties need explicit policy.

## 19 — Maximum of negative delays
Question: nonempty int[] delays, max initialized0, loop max=Math.max(max,delay). Give failing input, expected result, fix.
Previously correctly identified all-negative values. Example [-8,-3,-5] => expected -3, actual0. Initialize max=delays[0], loop remaining. Requested repeat; not a new failed answer.

## 20 — Stale browser update / lost update
User unsure: suggested synchronized and Repeatable Read.
synchronized applies to methods or blocks (not a field modifier), only participants using same monitor in same JVM; not cross-instance/database protection.
Browser edits span separate requests/transactions. Higher isolation in the final update transaction cannot automatically detect a form read minutes earlier.
Use optimistic concurrency: expose version in GET, require original client version on update. JPA @Version plus proper client version validation; loading newest version and ignoring request's stale version is insufficient.
Atomic SQL illustrates: UPDATE task SET description=:d, version=version+1 WHERE id=:id AND version=:expectedVersion. Zero rows => stale or missing; distinguish as needed.
Two clients read v7; first saves ->v8; second v7 rejected. ETag/If-Match gives412; body version conflict often409. Don't silently retry stale overwrite. PATCH can reduce unrelated-field overwrites but not replace concurrency policy.
Isolation refresh (SQL standard): Read Uncommitted may dirty-read; Read Committed prevents dirty reads but repeat reads can change; Repeatable Read prevents nonrepeatable reads, standard allows phantoms; Serializable equivalent to serial committed execution, retries possible.
Postgres: Read Uncommitted acts Read Committed; Repeatable Read also prevents phantoms, can abort concurrent-update conflicts, still permits serialization anomalies; Serializable can abort/retry.
Definitions: dirty read=uncommitted data; nonrepeatable=existing row changes; phantom=matching set changes.
Status: major domain gap; uncertainty appropriate.

## 21 — Authorized large video upload
User correctly suggested S3/chunks but routed bytes through backend.
Recommended design: frontend requests upload session; backend authenticates and checks project membership, chooses unpredictable project-scoped object key, starts S3 multipart upload; returns short-lived presigned part URLs. Browser slices file and uploads parts directly to S3. Backend validates session ownership and completes upload using part numbers/ETags, verifies object/size/checksum as appropriate and records availability. Scan/process before public availability; abort abandoned multipart uploads.
Presigned URLs are bearer capabilities; never accept arbitrary client bucket/key or assume frontend project ID authorizes access. No permanent AWS keys in browser.
Tradeoff: backend bandwidth/memory reduced, but multipart completion, retries, CORS, expiry and cleanup need handling.
Status: partial useful intuition, guessing accurately expressed.

## 22 — Ownership migration story
See Migration-Ownership-Story.md. Real experience is strong; gap is concise structure, precise metrics and separating evidence from causal hypotheses. No scoring of unverified final outcome.
Terms: connection pool, active/idle/pending connections, peak traffic, latency, timeouts, mitigation, root cause, load testing, rollback compatibility, changeset checksum, dependency auto-configuration.
User-reported final dependency module removal is not directly proved by pasted wiki. Wiki demonstrates malformed SQL and configuration symptoms/fixes. Avoid asserting exact final connection reduction until verified.

## 23 — Offset versus keyset pagination
User unsure, proposed page numbers/index. Page numbers usually map to same offset, so do not solve shifting rows. One-based page3 size10 => offset20; zero-based page3=>30.
Example page size2: A,B,C,D -> page1 A,B. Insert X newest -> X,A,B,C,D. OFFSET2 page2 B,C repeats B.
Use deterministic ORDER BY created_at DESC,id DESC and cursor storing last pair. Next page WHERE project_id=:p AND (created_at,id)<(:lastTime,:lastId) ORDER BY created_at DESC,id DESC LIMIT20. Values non-null; stable immutable ordering assumed.
Index(project_id,created_at DESC,id DESC) helps but does not itself fix offset semantics. Explicit ORDER BY required regardless of physical storage.
Tradeoff: sequential next-page access good; arbitrary page jumps harder. Not full snapshot consistency if sorting keys/filter membership mutate.
Status: domain gap; uncertainty appropriate.

## 24 — Per-project task numbers with concurrent instances
Clarify before grading: ProjectA task1,2,3; ProjectB task1,2 allowed. Task row global ID separate from project-local display number. A next4 and B next3 can coexist; two requests in A must not both allocate4.
Schema: project_id and task_number NOT NULL, UNIQUE(project_id,task_number).
One simple allocator: projects.next_task_number initialized1. In same transaction:
UPDATE projects SET next_task_number=next_task_number+1 WHERE id=:projectId RETURNING next_task_number-1;
INSERT task(project_id,task_number,...) using returned value; commit.
Concurrent updates serialize on same project row; independent projects can proceed. Reject nonexistent project. Retry transaction when isolation requires. Unique constraint final guard.
Tradeoff: hot-project row contention; keep transaction short. Gapless numbering is a separate requirement; do not promise no gaps after deletes/cancellations.
Status: question not understood; not scored as wrong. Clarify and retest.

## Practice policy
Four daily Cairo sessions retained:08:00/16:00 MCQ recall,12:00/20:00 discussion; morning email exam retained, more MCQs. Mix new topics and known gaps. Do not add a new topic solely because transcription said MCP: user corrected to MCQ.
References:
- https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html
- https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
- https://www.postgresql.org/docs/16/transaction-iso.html
- https://www.postgresql.org/docs/current/queries-limit.html
- https://jakarta.ee/specifications/platform/10/apidocs/jakarta/persistence/version
- https://docs.aws.amazon.com/AmazonS3/latest/userguide/mpuoverview.html
