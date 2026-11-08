# Auth Security

Source: https://app.notion.com/p/25cfc75cbbd98083a98ed74ce636d1d6?pvs=204

### Spring starts its <b>security machinery for HTTP requests</b>

- Spring Security hooks into your web application (servlets, controllers, filters).
- Every incoming HTTP request passes through a <b>filter chain</b> before it reaches your controllers.
- These filters can handle things like:
  - Authentication (is the user logged in?)
  - Authorization (is the user allowed to access this URL?)
  - CSRF protection
  - Security headers (like frame options, XSS protection, etc.)

<b><code>@EnableWebSecurity</code></b><br />• This enables Spring Security’s web security support.

In Spring Boot 3, this is <b>optional</b> because Spring Boot auto-configures it.

With <code>@EnableWebSecurity</code>, Spring <b>activates its web security module</b> and looks for beans like your <code>SecurityFilterChain</code>.

<p>
 Without this, Spring Security wouldn’t apply your rules to web requests.
</p>

<b>Analogy:</b> Think of it like turning on a security system in a building.

- <code>@EnableWebSecurity</code> → <b>switches on the alarm system</b>.
- <code>SecurityFilterChain</code> → <b>tells the system which doors are locked or open</b>.
- Incoming requests → <b>people trying to enter the building</b>.

```java
@Bean public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
{ 
		http.csrf(AbstractHttpConfigurer::disable) 
			.headers(headers -> headers.frameOptions(FrameOptionsConfig::disable)
			.disable()) 
			.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); 
			return http.build(); 
}
```

<code>.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())</code> → <b>allow all requests without authentication</b>.   ◦ Every endpoint is accessible to anyone.

### <b>CSRF = Cross-Site Request Forgery</b>

It’s an attack where a <b>malicious website tricks a logged-in user</b> into making an unwanted request to another site <b>where they are already authenticated</b>.

### Example scenario without protection:

1. You are logged in to your bank website (<code>bank.com</code>) in one browser tab.
2. Your session is active — you have a valid authentication cookie.
3. At the same time, you visit a malicious site (<code>evil.com</code>).
4. <code>evil.com</code> has hidden code like:

```html
<form action="https://bank.com/transfer" method="POST">
  <input type="hidden" name="amount" value="1000">
  <input type="hidden" name="toAccount" value="hacker123">
  <input type="submit">
</form>
<script>document.forms[0].submit();</script>


```

1. Since your browser automatically <b>sends cookies</b> with requests, <code>bank.com</code> thinks <i>you</i> submitted this transfer request.
2. Money gets transferred without your consent. 💸

<p />

<h2>
@EnableAuthorizationServer  
</h2>

```java
@Configuration
@EnableAuthorizationServer  // ❌ This doesn't exist in Spring Security 6
protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
            .authenticationManager(authenticationManager)
            .pathMapping("/oauth/token", tokenEndpoint)
            .tokenServices(tokenServices());
    }
}
```

<b>This configured endpoints:</b>

- <code>POST /oauth/token</code> - Get a new access token
- <code>POST /oauth/authorize</code> - Authorization code flow
- <code>GET /oauth/check_token</code> - Validate a token

<p />

<page url="https://app.notion.com/p/283fc75cbbd980c09ac7df28e00cbb68">
Authentication Steps/Methods
</page>

<page url="https://app.notion.com/p/293fc75cbbd98040b0edc0b6b51eb3c0">
Authorization Models
</page>

<page url="https://app.notion.com/p/260fc75cbbd9807e877ed25409849c71">
OAuth Vs SSO
</page>

<p />

<page url="https://app.notion.com/p/283fc75cbbd980fdaf65d16a7f2746d8">
Cookie Vs JWT 
</page>

<page url="https://app.notion.com/p/2b6fc75cbbd98038b1dbed0b0a319370">
API security
</page>

<page url="https://app.notion.com/p/2bbfc75cbbd9807abb0bf879e55e4632">
Keycloak
</page>

<page url="https://app.notion.com/p/2bbfc75cbbd9809f87c0cd923672cedc">
<b>Spring Security Request Flow — Notes</b>
</page>
