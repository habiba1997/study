# Terms

Source: https://app.notion.com/p/339fc75cbbd980ac8421e3912179d82f?pvs=204

Agentic AI: \[ Perceive → Reason → Act → Observe\]

Large Reasoning Model : are models that divide their tasks into steps (they always write “thinking ….” )

### Agentic AI (AI Agents)

- Systems that act autonomously to achieve goals
- Loop: <i>perceive → reason → act → observe → repeat</i>
- Used for tasks like booking, analysis, DevOps automation

---

### 2) Large Reasoning Models (LRMs)

- Specialized LLMs trained for <b>step-by-step reasoning</b>
- Use verifiable tasks (math, code) + reinforcement learning
- Enable agents to plan and solve <b>multi-step problems</b>

---

### 3) Vector Database

- Stores data as <b>embeddings (vectors = numbers)</b> instead of raw text/images
- Enables <b>semantic search</b> via similarity (closest vectors)
- Core for finding meaning, not exact matches

---

### 4) RAG (Retrieval-Augmented Generation)

- Combines LLM + external data
- Flow:<i>query → embedding → search vector DB → retrieve → enrich prompt</i>
- Improves accuracy using <b>real, relevant context (e.g., docs, policies)</b>

---

### 5) MCP (Model Context Protocol)

- Standard for connecting AI to <b>external tools/systems</b>
- Avoids custom integrations per tool
- Lets models access DBs, APIs, email, repos via a <b>unified interface</b>

---

### 6) MoE (Mixture of Experts)

- Model split into <b>specialized sub-networks (experts)</b>
- Only <b>relevant experts activate per task</b>
- More scalable: large model power with <b><u>lower compute cost</u></b>

---

### 7) ASI (Artificial Superintelligence)

- Hypothetical AI <b>beyond human intelligence</b>
- Could self-improve recursively
- Beyond AGI (human-level intelligence) → <b>unknown impact</b>

# <b>Open LLMs</b>

Think of it like this: ChatGPT is a service, built and maintained by OpenAI. You send a query, they process it, and you get an answer. With open models, <i>you</i> host the model yourself (e.g., on your laptop). Tools like [LM Studio ](https://lmstudio.ai/)(which I highly recommend - more on that later) and [Ollama ](https://ollama.com/)provide a convenient way to browse, download, and run these models with ease.

LM Studio comes with a powerful GUI, Ollama is a CLI application but offers plenty of advanced features around model customization.
