# Sampling

Source: https://app.notion.com/p/31ffc75cbbd9808f86bbef3092e61fca?pvs=204

<b>Sampling</b> = how the model <b>chooses the next token (word)</b> from possible tokens.

The model does not deterministically pick one word.

Instead it assigns <b>probabilities</b> and then <b>samples</b>.

Example probabilities:

```txt
"The weather is"

sunny   → 0.45
hot     → 0.30
nice    → 0.15
cloudy  → 0.10
```

Sampling decides <b>which one to pick</b>.

Common sampling controls:

| Parameter | What it does |
| --- | --- |
| temperature | randomness level |
| top-k | choose from top K tokens |
| top-p (nucleus) | choose from tokens whose probability sum ≤ p |
| greedy | always pick highest probability |

Example:

<b>Greedy</b>

```txt
"The weather is sunny"
```

<b>High temperature</b>

```txt
"The weather is beautifully chaotic"
```

Sampling = <b>controlled randomness in token selection</b>.

<p />
