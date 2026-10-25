# JVM heap and GC diagnostics lab

Status: requested 2026-10-25; not performed yet. User wants a manual exploration on an existing local/dev Java service, no new sample code.

## Terms first

- Heap: memory for Java objects. Used-heap graph typically rises as objects are allocated and falls when GC frees unreachable objects.
- GC/memory trend: compare used heap *after successive collections* over time under roughly comparable load, not merely one rising point. A steadily rising after-GC baseline can suggest retained objects, but alone does not prove a leak; workload, caches and warmup matter.
- Heap retention: objects remain reachable through references (sometimes intentionally), so GC cannot reclaim them. A static map retaining old requests is an example. GC root: starting point for reachability (e.g., live thread or static field).
- GC log: timeline of collection activity. Heap dump: snapshot of objects/references. Retained size: memory that would become reclaimable if a particular object and its exclusively reachable objects disappeared.

## Manual session

1. Start an existing local/dev Java service with predictable, non-sensitive test data. Find its Java process in VisualVM, JDK Mission Control, or `jcmd` on the same machine/user.
2. Watch a used-heap graph for several collections while making ordinary requests. Record used heap after each collection. Is its baseline stable, or rising? Do not diagnose from one event.
3. Use a tool's heap-dump action, or `jcmd <pid> GC.heap_dump filename=heapdump.hprof` if suitable. A heap dump can be large and can pause the JVM; arrange adequate disk space and do not capture/share production personal data casually.
4. Open the dump in a heap analyzer (e.g. Eclipse MAT). Inspect histogram (class counts), dominator/retained-size view, and a path to GC roots for a surprisingly retained object. Distinguish many allocated objects from objects actually retained.
5. Bring the after-GC values and a redacted observation of the largest retainer to chat. If there is no abnormal growth, report that; this exercise teaches the method without requiring a synthetic leak.

A heap-space OutOfMemoryError differs from Metaspace or native-memory failures; inspect the exact error text before assuming the Java heap is the source.

Reference: https://docs.oracle.com/en/java/javase/21/troubleshoot/troubleshooting-memory-leaks.html
