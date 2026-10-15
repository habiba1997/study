# JWT parts and validation terms — terminology gap

_Last reviewed: 2026-10-15_

## Recall status

- Habiba knew the header and the general idea of a trusted secret but called the other parts "content" and "secret ID." Explicit terms to recall: **header, payload, signature** (`header.payload.signature`).
- In the forged-role scenario, Habiba correctly predicted verification would fail, but used "decode/unhash with a secret" where **verify the signature** is the accurate phrase.
- A signed, unencrypted JWT's payload can be decoded by anyone. Reading it does not prove it came from a trusted issuer.
- The signature is verified with a trusted key. HMAC uses a shared secret; asymmetric signing is verified with a public key. Restrict accepted algorithms.
- A valid signature is necessary but does not alone establish that the token is usable by this API. Check relevant claims such as `exp` (expiry), `nbf` (not before), `iss` (expected issuer), and `aud` (intended recipient/API). Then authorize the action using trusted claims or current application policy.
- A user DB lookup is application-specific; token validation does not universally require one.

## Tiny recall prompts (ask one at a time, between other topics)

1. Name the three parts of a typical signed JWT, in order.
2. What is the middle part called?
3. Is the third part a secret or a signature?
4. Can you decode the payload without a key? Does that make it trustworthy?
5. Which claim says which API the token is intended for?
6. Which verb describes checking the cryptographic signature: decode or verify?

## Concept check for later

A user changes `"role":"USER"` to `"role":"ADMIN"` without the signing key. The original signature no longer matches the changed header/payload; a correctly configured backend rejects the token. Re-encoding is not re-signing.
