# GH-600 certification knowledge gaps

These are personal recall notes for the **GitHub Certified: Agentic AI Developer (GH-600)** certification. They are **not interview gaps** and should be reviewed separately from interview preparation.

## GitHub Actions artifact

**Recall prompt:** What is an artifact in a GitHub Actions workflow, and how is it different from a workflow run?

**Answer:** An artifact is a file or collection of files produced by a workflow job and uploaded for storage with the run. Examples include test reports, coverage reports, build outputs, and logs deliberately uploaded as artifacts. The workflow run records the execution and job/check status; its artifacts hold output files you can download or inspect as evidence. An artifact is not the workflow itself.

**Context in the course:** GitHub acts as a system of record by retaining reviewable evidence such as workflow runs and artifacts. The word *artifact* can also mean a broader durable work product, such as a plan, commit, or pull request, depending on context.

**Status:** Explained on 2026-11-16; revisit with a short recall question before marking understood.

**Source:** [Foundations of Agentic AI in GitHub: GitHub as the system of record and control plane](https://learn.microsoft.com/en-gb/training/modules/foundations-agentic-ai/4-describe-github-system-record-control-plane)
