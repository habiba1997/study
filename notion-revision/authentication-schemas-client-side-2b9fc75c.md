# Authentication schemas (client side)

Source: https://app.notion.com/p/2b9fc75cbbd980438159eac02e99af7a?pvs=204

## <b>Basic Authentication</b>

Basic authentication sends credentials as a base64-encoded string in the HTTP Authorization header.

<code>Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=</code>

The encoded string is simply <code>username:password</code> in base64. This means anyone who intercepts the request can easily decode it.

## <b>Digest Authentication</b>

Digest authentication improves on Basic by never sending the actual password over the network.

<b>How it works:</b>

1. Client requests a resource
2. Server responds with 401 and a challenge containing a nonce (random value)
3. Client creates a hash: <code>MD5(username:realm:password)</code> combined with the nonce
4. Server validates by computing the same hash

## <b>Form-Based Authentication</b>

HTML form-based login where credentials are submitted via HTTP POST.

<b>Typical implementation:</b>

```java
<form action="/login" method="POST">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="Login">
</form>
```

<b>Server-side handling:</b>

```java
// Spring Security example
@PostMapping("/login")
public String login(@RequestParam String username, 
                   @RequestParam String password) {
    // Validate credentials// Create session// Set cookie: JSESSIONID=abc123...
}
```

<b>Security considerations:</b>

- Must use HTTPS to protect credentials in transit
- Requires session management (cookies/tokens)
- Vulnerable to CSRF attacks (need CSRF tokens)
- Session fixation attacks if not properly implemented
- XSS can steal session cookies

<p />

<p />

<p />

<b>You cannot fully hide an authentication token on the client-side.</b>

Anything stored in the browser <b>(localStorage, sessionStorage, IndexedDB, memory, JS variables)</b> is visible to the user because the browser belongs to the user.

So the goal is not “hide the token.”

The goal is <b>minimize attack surface</b>.

### The correct secure approach

Use <b>HttpOnly, Secure, SameSite cookies</b> instead of localStorage.

- <b>HttpOnly</b> → JavaScript cannot read the cookie (XSS protection).
- <b>Secure</b> → cookie only sent over HTTPS.
- <b>SameSite=Lax / Strict</b> → reduces CSRF.
- The browser attaches the cookie automatically in each request.

### Why this is safer

- Token <b>never appears in </b><b><code>localStorage</code></b> → XSS cannot steal it.
- Token <b>never appears in your JS code</b> → no developer accidentally logs it.
- Cookie still appears in <b>network requests</b> (under “Cookies”) — this is normal and not a vulnerability, because only the browser shows it to its owner.

### What you <i>never</i> do

- Never store JWTs in <b>localStorage</b> → vulnerable to XSS.
- Never store sensitive info in comments, logs, inspector-visible locations.
- Never try to “encrypt” the token in the frontend → pointless, the key must also live in frontend.

<p />
