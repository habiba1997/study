# Why walkable IDs are a problem (architectural view)

Source: https://app.notion.com/p/2ddfc75cbbd9807c819cc16a07b63a77?pvs=204

- <b>ID enumeration</b>
  <p>
  Sequential IDs (<code>1,2,3…</code>) let attackers iterate and access other users’ data.
  </p>
- <b>Broken Object Level Authorization (BOLA)</b>
  <p>
  Even with auth, predictable IDs expose authorization gaps (OWASP API Top 10 #1).
  </p>
- <b>Data leakage amplification</b>
  <p>
  One valid ID ⇒ easy discovery of many more records.
  </p>
- <b>Correlation & scraping</b>
  <p>
  Attackers can infer volume, growth rate, and relationships.
  </p>
- <b>Caching & logging exposure</b>
  <p>
  Predictable IDs spread across logs, URLs, analytics, and become long-lived attack surfaces.
  </p>

<b>Why UUIDs fix this</b>

- Non-guessable, high entropy
- No meaningful ordering
- Safe for external exposure
- Decouple public API from internal DB design

<b>Architectural principle</b>

- <b>Internal ID ≠ External ID</b>
- Numeric IDs stay internal
- UUIDs (or opaque tokens) cross service / API boundaries

<b>Net result</b>

- Smaller attack surface
- Stronger authorization guarantees
- Safer APIs by default
