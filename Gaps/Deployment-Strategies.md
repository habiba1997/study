# Deployment Strategies — Interview Gap

_Last reviewed: 2026-10-15_

## Current recall

- **Rolling deployment:** You described replacing service instances in batches correctly and recalled the name on a later question.
- **Blue-green deployment:** You remember the two-environment switch and proposed it reasonably for a low-risk release.
- **Canary release:** Revisit the name and distinguishing feature. A small, controlled share of real users or traffic receives the new version first; increase that share while monitoring results. It is not "feature by feature."
- **Shadow / traffic mirroring:** Revisit the term. Copy production requests to the new version for observation; users receive responses from the old version.
- **Feature flags:** Deployed code can remain disabled and be enabled for selected users or groups.
- **Recreate:** Stop the old version, then start the new version; downtime is expected.

## Distinction to practice

**Rolling** replaces instances in batches; **canary** explicitly controls a small share of users or traffic. Both can expose real users gradually, so a question saying only "gradual exposure" is ambiguous. **Blue-green** switches between two environments. **Shadow** does not serve the new version's response to users.

## Short recall prompts

Ask these one at a time, mixed with questions from other topics:

1. Old and new pods run together while you replace instances in batches. Name the strategy.
2. You direct 5% of real users to a new version, watch metrics, then increase to 25%. Name it.
3. You prepare a complete second environment and switch production traffic to it. Name it.
4. You copy production requests to a candidate version but never return its responses to users. Name it.
5. Code is deployed, but a new feature is disabled until you enable it for a group. Name the mechanism.
6. You stop the old service before starting the replacement and accept downtime. Name the strategy.
7. Explain the difference between rolling and canary in one sentence.

## Interview practice rule

First ask for the name from a scenario, then ask for a tradeoff or failure mode. Retest the names later without showing this list first.
