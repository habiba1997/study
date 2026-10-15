# Deployment strategies — domain gap

_Last reviewed: 2026-10-15_

Habiba explicitly wants to recall the strategy names. Rolling and blue-green were recalled correctly after practice. Canary and shadow/mirroring need periodic recall. Distinguish rolling and canary without using vague clues such as "gradual exposure."

| Term | Recognition cue |
| --- | --- |
| Rolling | Replace service instances in batches; old and new instances can coexist. |
| Blue-green | Two environments; switch traffic to the new one. |
| Canary | Send a controlled small share of real users/traffic to the new version, monitor, then ramp up. |
| Shadow/mirroring | Copy production requests to the candidate, but users receive the old version's response. |
| Recreate | Stop the old version before starting the new one; downtime. |
| Feature flags | Deploy code but control whether users see new behavior. |

**Key distinction:** Rolling changes instances batch by batch. Canary controls a specific small share of users or traffic. Both can expose real users gradually. Canary is not "feature by feature."

## Short prompts (ask one at a time between other subjects)

1. You replace pods a few at a time. Name it.
2. You route 5% of real traffic to the new version. Name it.
3. You prepare a second environment, then flip traffic. Name it.
4. You mirror requests but do not serve the candidate's response. Name it.
5. Code is live, but the feature is off. Name the mechanism.
6. Stop old, then start new with downtime. Name it.
7. In one sentence, distinguish rolling from canary.

After naming, occasionally ask about tradeoffs and monitoring. Retest terms later without the table.
