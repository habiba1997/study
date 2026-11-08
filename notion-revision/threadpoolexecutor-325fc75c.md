# ThreadPoolExecutor

Source: https://app.notion.com/p/325fc75cbbd980d2b874fa702572daca?pvs=204

<image source="notion-file-block://325fc75c-bbd9-809e-8a51-d525419d32db/fd83a74b-8042-43cb-a3bb-ee78a1e177f5?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

```java
ExecutorService threadPoolExecutorObject =
    new ThreadPoolExecutor(
        1,  // corePoolSize
        5,  // maximumPoolSize
        0L, // keepAliveTime
        TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>(2)
    );
```

1. <b>App</b>

- Your application submits tasks:

```txt
executor.execute(task);
```

<b>2. Executor (</b><b><code>ThreadPoolExecutor</code></b><b>)</b>

- Acts as a <b>manager</b>
- Decides:
  - whether to create a new thread
  - or queue the task
  - or reject it

<b>3. Thread Pool</b>

- Actual worker threads that execute tasks.
- In this case:
  - <b>core threads = 1</b>
  - <b>max threads = 5</b>

<b>4. Task Queue (</b><b><code>LinkedBlockingQueue</code></b><b>)</b>

- Capacity = <b>2</b>
- Stores tasks waiting to be executed.

### Execution Flow

When tasks are submitted:

1️⃣ <b>First task</b>

- No thread exists → create <b>Thread 1</b>
- Executes task immediately.

2️⃣ <b>Next tasks</b>

- Queue not full → placed into <b>LinkedBlockingQueue</b>

3️⃣ <b>Queue becomes full (2 tasks)</b>

- Executor starts creating <b>new threads</b> (up to max = 5).

4️⃣ <b>If</b>

- threads = 5
- queue = full

→ task is <b>rejected</b> (default: <code>RejectedExecutionException</code>).

<code>ThreadPoolExecutor</code> controls <b>task execution policy</b>:

- <b>Core threads</b> handle initial load
- <b>Queue</b> buffers tasks
- <b>Extra threads</b> handle spikes
- <b>Rejection policy</b> handles overload
