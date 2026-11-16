# GH-600 certification knowledge gaps

These are personal recall notes for the **GitHub Certified: Agentic AI Developer (GH-600)** certification. They are **not interview gaps** and should be reviewed separately from interview preparation.

## GitHub Actions artifact

**Recall prompt:** What is an artifact in a GitHub Actions workflow, and how is it different from a workflow run?

**Answer:** An artifact is a file or collection of files produced by a workflow job and uploaded for storage with the run. Examples include test reports, coverage reports, build outputs, and logs deliberately uploaded as artifacts. The workflow run records the execution and job/check status; its artifacts hold output files you can download or inspect as evidence. An artifact is not the workflow itself.

**Context in the course:** GitHub acts as a system of record by retaining reviewable evidence such as workflow runs and artifacts. The word *artifact* can also mean a broader durable work product, such as a plan, commit, or pull request, depending on context.

**Status:** Explained on 2026-11-16; revisit with a short recall question before marking understood.

**Source:** [Foundations of Agentic AI in GitHub: GitHub as the system of record and control plane](https://learn.microsoft.com/en-gb/training/modules/foundations-agentic-ai/4-describe-github-system-record-control-plane)

## Human accountability and traceability

**Recall prompt:** If an agent performs the work, who owns the outcome, and what evidence should be kept?

**Note:** Agentic systems change who performs work, but not who owns outcomes. Human teams remain accountable. They need to guard against common anti-patterns and make the agent's work traceable through GitHub-native records such as plans, branches, commits, pull requests, review decisions, workflow runs, artifacts, and relevant logs.

**Status:** Saved for later review on 2026-11-16; not yet assessed.

## Hidden reasoning

**Recall prompt:** An agent submits a diff without its plan, assumptions, decision points, or execution context. What is the anti-pattern?

**Answer:** Hidden reasoning. Reviewers can see the output but cannot understand the approach or reconstruct why decisions were made. Ask for an inspectable plan, stated assumptions and scope, linked workflow runs, and decisions recorded in the PR. Here, the term means missing reviewable context; it does not require exposing a model's private internal reasoning.

**Status:** Asked about on 2026-11-16; revisit for recall.

**Source:** [Identify responsibilities, risks, anti-patterns, and traceability needs](https://learn.microsoft.com/en-us/training/modules/foundations-agentic-ai/5-identify-risks-traceability)

## Contributor model

**Recall prompt:** How should an agent-generated pull request be evaluated?

**Answer:** Treat it as a contribution and apply the same engineering standards used for a human PR: intended problem solved, appropriate and explained scope, passing checks, correct owners reviewing, compliance with architecture and repository policy, and a clear fallback for risky changes. Judge the work and evidence rather than accepting or rejecting it just because an agent authored it. Humans remain accountable for acceptance.

**Status:** Asked about on 2026-11-16; revisit for recall.

**Source:** [Apply the contributor model to agent-generated work](https://learn.microsoft.com/en-us/training/modules/foundations-agentic-ai/6-apply-contributor-model-agent-generated-work)
