# Design

Source: https://app.notion.com/p/2ecfc75cbbd9807ebb4cc623fb7e4a0f?pvs=204

<b>Stateless Prompts vs. Stateful Agent Loops</b><br />

<b>Stateless (Direct Model Call)</b>

<code>User → Prompt → LLM → Response → Done</code>

No memory. Each call is independent. Like asking a stranger for directions.

<b>Stateful Agent Loop</b>

<code>Goal → Observe → Think → Act → Observe → Think → Act → ... → Goal Met</code>

The agent remembers what it's tried, adjusts strategy, and persists until done (or gives up).

## When to Use What

### Use Direct Prompts When:

- Task is <b>single-step</b> (summarize, translate, classify, extract)
- Output is <b>predictable</b> and well-defined
- No need to <b>adapt</b> based on intermediate results
- Latency and cost matter more than sophistication

<b>Examples:</b> Summarize an incident summary, classify ticket severity, extract error codes from logs.

### Use Agents When:

- Task requires <b>multiple steps</b> with branching logic
- You need to <b>react</b> to intermediate results
- The path to the goal is <b>not known upfront</b>
- Task involves <b>tool use</b> and real-world interaction

<b>Examples:</b> Your incident agent that queries metrics, forms a hypothesis, searches runbooks, refines based on findings, then recommends actions.

---

## Agent Autonomy Spectrum

```txt
Low Autonomy                                          High Autonomy
     │                                                      │
     ▼                                                      ▼
[Human approves    [Agent suggests,     [Agent acts,      [Agent acts
 every action]      human confirms]      human monitors]   independently]
```

## Failure Modes to Watch For

| Failure Mode | What Happens | Mitigation |
| --- | --- | --- |
| <b>Looping</b> | Agent repeats same actions without progress | Max iterations, loop detection |
| <b>Goal drift</b> | Agent pursues tangential objectives | Clear goal definition, guardrails |
| <b>Hallucinated actions</b> | Agent "invents" tools it doesn't have | Strict action schema validation |
| <b>Context overflow</b> | Too much history, loses focus | Summarization, sliding window |
| <b>Cascading errors</b> | Bad early observation poisons reasoning | Checkpoints, human-in-the-loop |
| <b>Over-autonomy</b> | Agent takes drastic action without check | Approval gates for high-impact actions |
