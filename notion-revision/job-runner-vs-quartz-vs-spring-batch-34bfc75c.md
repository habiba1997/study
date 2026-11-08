# Job Runner Vs Quartz Vs Spring Batch

Source: https://app.notion.com/p/34bfc75cbbd980e99a60dea0ee8285e8?pvs=204

## 🔥 Comparison (short)

| Feature | JobRunr | Spring Batch | Quartz |
| --- | --- | --- | --- |
| Purpose | Async jobs | Data pipelines | Scheduling |
| Complexity | Low | High | Medium |
| Persistence | Yes | Yes | Yes |
| Retries | Built-in | Built-in | Manual |
| Large data | ❌ | ✅ | ❌ |
| Scheduling | Basic | Limited | Advanced |

When to pick what

- <b>JobRunr</b> → “run this in background + retry”
- <b>Spring Batch</b> → “process huge dataset reliably”
- <b>Quartz</b> → “run jobs at complex schedules”

### JobRunr (background jobs, simple + async)

<b>What it is</b>

- Library to run background jobs (fire-and-forget, retries, scheduling)
- Uses DB/Redis for persistence
- Minimal setup, code-first

<b>Use when</b>

- Send emails, call APIs, small async tasks
- Retry on failure
- Simple scheduling (cron)

<b>Example</b>

```java
// config (Spring Boot starter handles most)
@Component
publicclassEmailService {
publicvoidsendEmail(Stringto) {
// logic
    }
}

// enqueue
jobScheduler.enqueue(() ->emailService.sendEmail("user@test.com"));

// delayed
jobScheduler.schedule(() ->emailService.sendEmail("user@test.com"),
Instant.now().plusSeconds(60));

// recurring
jobScheduler.scheduleRecurrently("email-job",
Cron.daily(), () ->emailService.sendEmail("user@test.com"));
```

---

### 2) Spring Batch (heavy data processing)

<b>What it is</b>

- Framework for <b>large-scale batch processing</b>
- Chunk-based, transactional, restartable

<b>Use when</b>

- Process millions of records
- ETL (read → transform → write)
- Import/export jobs, reporting

<b>Example</b>

```java
@Bean
publicJobjob(JobRepositoryjobRepo,Stepstep) {
returnnewJobBuilder("job",jobRepo)
.start(step)
.build();
}

@Bean
publicStepstep(JobRepositoryjobRepo,PlatformTransactionManagertx) {
returnnewStepBuilder("step",jobRepo)
.<Input,Output>chunk(100,tx)
.reader(reader())
.processor(processor())
.writer(writer())
.build();
}
```

---

### 3) Quartz (scheduler only)

<b>What it is</b>

- Advanced <b>scheduler</b>
- Triggers + cron + clustering

<b>Use when</b>

- Complex scheduling rules
- Enterprise scheduling (many jobs, calendars, misfires)
- You already have job logic, just need scheduling

<b>Example</b>

```java
JobDetailjob=JobBuilder.newJob(MyJob.class)
.withIdentity("job1")
.build();

Triggertrigger=TriggerBuilder.newTrigger()
.withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 * * ?"))
.build();

scheduler.scheduleJob(job,trigger);
```

---

---

---

## 💡 Real-world mapping

- Send email after user signup → <b>JobRunr</b>
- Nightly process 10M records → <b>Spring Batch</b>
- Run billing every 1st of month at 2 AM → <b>Quartz</b>

---

## ⚠️ Common confusion

- Quartz ≠ job execution framework → only schedules
- JobRunr = execution + scheduling (simpler alternative)
- Spring Batch = full processing engine (not just scheduler)

<p />

<page url="https://app.notion.com/p/34bfc75cbbd98019bed3fe3bf7bc4583">
Camunda
</page>

<page url="https://app.notion.com/p/350fc75cbbd9801f8b82d2ddaa750772">
 JobRunr Concurrency
</page>
