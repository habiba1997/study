# Camunda

Source: https://app.notion.com/p/34bfc75cbbd98019bed3fe3bf7bc4583?pvs=204

## What Camunda is

- <b>Workflow / BPM engine</b>
- Models <b>business processes</b> (flows, decisions, approvals)
- Uses BPMN diagrams (visual flows)

👉 Think: <i>“orchestrate multi-step business logic over time”</i>

---

## When to use Camunda

- Long-running workflows (hours/days)
- Human + system steps
- Complex branching logic

<b>Examples</b>

- Loan approval (user task + automated checks)
- Order fulfillment (inventory → payment → shipping)
- Onboarding flows

---

## Simple example

```java
@ProcessApplication
publicclassApp {}

// start process
runtimeService.startProcessInstanceByKey("order-process");
```

Delegate (step logic):

```java
@Component
publicclassChargePaymentDelegateimplementsJavaDelegate {
publicvoidexecute(DelegateExecutionexecution) {
// call payment service
    }
}
```

---

## How it compares

| Tool | Role |
| --- | --- |
| JobRunr | background jobs (simple async) |
| Spring Batch | heavy data processing |
| Quartz | scheduling |
| <b>Camunda</b> | workflow orchestration |

---

## Key difference

- JobRunr / Quartz → <b>“run a task”</b>
- Spring Batch → <b>“process data”</b>
- Camunda → <b>“manage a business flow”</b>

---

## How they work together (important)

They are <b>not mutually exclusive</b>:

- Camunda orchestrates flow
- Then calls:
  - JobRunr → async task
  - Spring Batch → heavy processing
  - Quartz → scheduling trigger

---

## Example architecture

👉 Order system:

- Camunda → defines steps
- JobRunr → send email async
- Spring Batch → nightly reconciliation
- Quartz → trigger monthly billing

---

## When NOT to use Camunda

- Simple cron job → use Quartz
- Simple async → use JobRunr
- No workflow complexity → Camunda is overkill

---

## Quick mental model

<quote>
Camunda = “brain (workflow)”

JobRunr / Batch / Quartz = “workers (execution)”
</quote>
