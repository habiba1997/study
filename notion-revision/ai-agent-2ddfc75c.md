# AI Agent

Source: https://app.notion.com/p/2ddfc75cbbd9808b9cfec88efc442649?pvs=204

An <b>AI agent</b> is a program that can act autonomously to accomplish tasks using an LLM (Large Language Model) or other AI systems. Unlike a single LLM call, an agent can <b>plan, execute, and iterate</b> on multiple steps, often interacting with external tools or APIs.

### <b>Augmented Generation</b>

Augmented Generation is the process of bridging the <b>gap between a user's prompt</b> and the <b>internal structure of your system (e.g., code, schema, database)</b>. It enables an LLM to generate accurate queries or mutations that the user didn't explicitly request but are logically needed.

---

### <b>System Prompt</b>

A <b>System Prompt</b> is where you define:

- The expected output format or type (e.g., GraphQL mutation).
- Context about your schema/database (e.g., MongoDB, GraphQL types).
- The LLM’s role (e.g., query generator, command builder).
- Rules, constraints, or guidance (e.g., "always return valid JSON").

### <b>LLM Runtime Needs</b>

- <b>LLMs require a GPU</b> to work efficiently due to VRAM usage.
- <b>Macs use a unified chip (Apple Silicon)</b> where CPU and GPU are on the same die, but GPU is still crucial for large models.
- <b>\<10GB VRAM</b> is common on laptops — good for running models up to \~7B parameters.

---

### <b>Best Local Models</b>

- <b>Code LLaMA</b> → Optimized for code generation.
- <b>Gemma-3-12B</b> → Strong general-purpose model.

---

### <b>RAG Agent</b>

A <b>RAG (Retrieval-Augmented Generation) Agent</b>:

- Uses an LLM to generate commands (SQL, shell, etc.).
- Retrieves knowledge from a source (docs, DB).
- Your custom agent <b>executes</b> those commands

the <b>Retriever is a piece of code you build or configure</b>, but it can also be a ready-made library component depending on what framework you use (like LangChain).

| Component | Role |
| --- | --- |
| <b>LLM</b> | Generates instructions or outputs based on user query + retrieved context |
| <b>Retriever</b> | Fetches relevant information from external knowledge sources |
| <b>Executor / Agent</b> | Runs the LLM-generated commands and returns results |

---

### <b>Custom Agent Roles</b>

- <b>Eye Yellow</b> → Image interpretation / translation.
- <b>Shakos Blue</b> → Configures MCP to allow command execution.
- <b>MCP</b> → Middleware control point with thermal and system-level access.

---

### <b>LLM Temperature</b>

- Controls creativity or randomness:
  - <code>0.0</code> → Deterministic, no creativity ("no hary").
  - <code>0.7–1.0</code> → Creative, varied output ("hary b2a")

## Major Companies & Their Agents

| Company | Agent / Product | Key Features |
| --- | --- | --- |
| OpenAI | <b>ChatGPT / GPT-4 Turbo + Plugins / AutoGPT</b> | Plugin system, web access, memory, multi-step reasoning |
| Anthropic | <b>Claude Agents</b> | Safety-focused, can do planning & memory-enabled tasks |
| Google DeepMind | <b>Gemini / AgentSmith</b> | Agentic LLMs for multi-step reasoning and task execution |
| Microsoft | <b>Copilot / Azure OpenAI Agents</b> | Integrated with Office, can call APIs, reasoning in code & docs |
| Mistral | <b>Mistral Agents</b> | Open-weight models for building task-specific agents |
| LangChain ecosystem | Various agent templates (Zero-shot, Conversational, ReAct) | Open-source framework to orchestrate agents over LLMs, APIs, and tools |

## Models Used in Agents

- <b>GPT-based</b>: GPT-3.5, GPT-4 (OpenAI), Claude (Anthropic)
- <b>Open-weight LLMs</b>: Mistral (Meta), Llama 2/3 (Mistral AI), Falcon (Technology Innovation Institute (TII))
- <b>Task-specific models</b>: Code LLMs (Code Llama, Starcoder) for agents doing programming
- Agents often combine <b>planner + executor + tools</b> architecture.

## Open-weight LLMs

<b>“Open-weight”</b> means the <b>full model weights are publicly available</b>. This allows anyone to:

- Run the model locally.
- Fine-tune it.
- Inspect or modify it.

This is in contrast to <b>closed/proprietary models</b> like GPT-4, where only API access is given—weights are not shared.

## <b><br />Cursor</b>

<p>
The company is <b>Anysphere, Inc.</b>, founded in 2022; Cursor is their main product. 
</p>

<b>📌 What Cursor Is</b>

- <b>Cursor</b> is an <b>AI‑assisted code editor / integrated development environment (IDE)</b> focused on helping developers write, edit, and refactor code using natural language and AI. [Wikipedia](https://en.wikipedia.org/wiki/Cursor_%28code_editor%29?utm_source=chatgpt.com)
- It’s essentially a <b>fork of Visual Studio Code</b> with deep AI features baked in, created by the startup <b>Anysphere, Inc.</b> (based in San Francisco). [Wikipedia+1](https://en.wikipedia.org/wiki/Cursor_%28code_editor%29?utm_source=chatgpt.com)
- Cursor uses large language models to do things like <b>autocomplete code, rewrite multiple lines, apply multi‑file changes, and perform complex edits across a project</b> based on plain language instructions. [Cursor](https://www.cursor.com/en/features?utm_source=chatgpt.com)

<b>👨‍💻 What It </b><i><b>Isn’t</b></i>

- It isn’t <b>just a cursor position in code</b> or a <b>general AI agent framework</b> (like LangChain).
- It isn’t a generic IDE standard — it’s a <b>product/tool</b> used by developers.

## Langchain

<b>LangChain</b> is an <b>open-source framework for building applications powered by Large Language Models (LLMs)</b>. It helps developers create <b>intelligent, multi-step workflows and AI agents</b> that can reason, plan, and interact with external tools.

### <b>Key Features</b>

1. <b>Chains</b>
   - Link multiple LLM calls together to perform <b>multi-step tasks</b>.
   - Example: Question → Search API → Summarize → Output.
2. <b>Agents</b>
   - Build <b>autonomous AI agents</b> that can decide which actions to take.
   - Example: An agent that reads emails, queries a database, and writes a report.
3. <b>Memory</b>
   - Store context across interactions.
   - Example: Chatbot remembers user preferences between conversations.
4. <b>Tool Integration</b>
   - Call APIs, databases, web scraping tools, or Python code.
   - Example: Agent queries a weather API and summarizes the result.
5. <b>Prompts & Templates</b>
   - Reusable prompt templates for consistent LLM behavior.

---

### <b>Why It Matters</b>

- Makes LLMs <b>actionable and programmable</b>.
- Lets you <b>combine reasoning, API calls, and memory</b> into one application.
- Supports <b>both research prototypes and production-ready AI agents</b>.

<b>In short:</b>

LangChain is the

<b>“glue” that turns LLMs into full applications or AI agents</b>, rather than just a single response generator.

<p />

<page url="https://app.notion.com/p/339fc75cbbd980ac8421e3912179d82f">
Terms
</page>

<page url="https://app.notion.com/p/358fc75cbbd9807f99bed0b422d013db">
KV cache
</page>

<page url="https://app.notion.com/p/31dfc75cbbd9805f8700f0e99a50dedd">
Agents 
</page>

<page url="https://app.notion.com/p/237fc75cbbd98072ac4de27cde342e65">
AI
</page>
