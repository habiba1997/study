# Threading Vs Job Execution

Source: https://app.notion.com/p/325fc75cbbd9803c97f9dc59c4611a7f?pvs=204

### Worker Threads Effectively

Use thread pools for:

- parallel processing
- background tasks
- async workflows

### Thread Pool Starvation

Starvation happens when all threads are blocked and no new tasks can run.

Common causes:

- blocking I/O inside limited pool
- long-running tasks
- tasks waiting on other tasks in same pool
