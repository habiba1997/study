# ModelMapper Vs MapStruct Vs Dozer

Source: https://app.notion.com/p/352fc75cbbd980579cb6ef0f4df63ead?pvs=204

### <b>ModelMapper</b>

- <b>Runtime reflection</b>
- Automatically maps based on naming conventions
- No code generation

👉 dynamic, flexible, but slower + less explicit

---

### <b>MapStruct</b>

- <b>Compile-time code generation</b>
- Generates plain Java mapping code
- No reflection at runtime

👉 fast, type-safe, explicit

---

### <b>Dozer</b>

- <b>Runtime reflection + XML config</b>
- Heavy use of configuration files

👉 older, flexible, but slow and complex

---

## Defaults & behavior

### ModelMapper

- Convention-based (same field names)
- Deep mapping supported automatically
- Loose matching (can guess mappings)

⚠️ Can map things you didn’t intend

---

### MapStruct

- Requires explicit mappings (or strict matching)
- Fails at compile time if something is wrong
- No surprises

⚠️ More setup upfront

---

### Dozer

- XML or annotation-driven
- Supports deep mapping, conversions
- Very permissive

⚠️ Hard to trace/debug

---

## Performance

- <b>MapStruct → fastest</b> (plain Java code)
- <b>ModelMapper → medium</b>
- <b>Dozer → slowest</b>

---

## Vulnerabilities / risks

Not “security vulnerabilities” in the CVE sense mostly — more <b>design risks</b>:

### ModelMapper risks

- Over-mapping sensitive fields unintentionally
- Runtime errors (no compile-time safety)
- Reflection → harder to control + debug

---

### MapStruct risks

- Very low
- Main risk = developer mistakes in mapping logic
- No reflection → smaller attack surface

---

### Dozer risks

- Reflection + XML = harder to audit
- Misconfiguration can expose or map sensitive data
- Historically had maintenance/security concerns
- Less active project → riskier long-term
