# KV cache

Source: https://app.notion.com/p/358fc75cbbd9807f99bed0b422d013db?pvs=204

<b>KV cache = speed enabler</b> (turns O(n²) → O(n))

<b>KV cache = speed enabler</b> (turns O(n²) → O(n))

- <b>KV cache = speed enabler</b> (turns O(n²) → O(n))
- Tradeoff: <b>memory explodes with context + model size</b>
- Scaling issues:
  - long chats = huge memory
  - large models = GPU bottleneck

## 7B vs 13B vs 70B + 8K context

### What is “8K context”?

- Model can “remember” <b>8192 tokens</b>
- Includes input + generated output

### Time (with vs without KV cache)

Without cache:

- Recompute all K,V every step
- Complexity: <b>O(n²)</b>

With cache:

- Only compute new token
- Complexity: <b>O(n)</b>

👉 Example from video:

- 13B model, 100 tokens:
  - without cache: \~30s
  - with cache: \~6s

## “Large models = GPU bottleneck”

It means <b>the GPU becomes the limiting resource</b>, not your code.

Why:

- <b>Weights are huge</b> (e.g., 70B fp16 ≈ 140 GB)
- <b>KV cache is huge</b> (e.g., \~35 GB for 8K)
- GPU memory (VRAM) is limited (e.g., 16–80 GB)

So you hit:

- ❌ can’t load model fully
- ❌ can’t handle many users (each request needs KV cache)
- ❌ slow throughput (GPU busy with heavy matrix ops)

👉 Bottleneck = GPU memory + compute is saturated
