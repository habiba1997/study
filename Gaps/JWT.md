# JWT — Interview Gap

_Last reviewed: 2026-10-15_

## What you answered

You recognized that the backend must validate a token before trusting its user information, and that authorization checks the user's permissions for the endpoint.

## Corrections to recall

- A common signed JWT has three dot-separated Base64URL parts: **header.payload.signature**. The payload contains claims such as subject/user ID, issuer, audience, and expiry. The third part is a signature, **not the secret ID**.
- Decoding the header and payload does **not** require a secret and does not prove authenticity. Do not describe it as "unhashing" or "untokening."
- The backend **verifies the signature** with the appropriate trusted key and accepted algorithm: a shared secret for HMAC, or a public key for an asymmetric signature. A normal signed JWT is not encrypted.
- Validate relevant claims: expiry (`exp`), not-before (`nbf`) when present, expected issuer (`iss`), and intended audience (`aud`). Only then use identity or scope/role claims for authorization. Looking up the user in a database can be an application choice, not a universal JWT requirement.

## Recall prompts (ask one at a time)

1. Name the three parts of a signed JWT and say what each contains.
2. Can anyone decode the payload? Why does decoding it not mean it is trusted?
3. A user edits the `role` claim from `USER` to `ADMIN` and re-encodes the payload. What must the backend do?
4. A signature is valid, but `exp` is in the past. Accept or reject?
5. A valid token was issued for API A but sent to API B. Which claim helps API B reject it?
6. Distinguish authentication from authorization in a React + Spring Boot request.

## Follow-up status

The user's first answer showed confusion between decoding and signature verification. Retest after explanation and later through spaced recall.
