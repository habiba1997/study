# Keycloak

Source: https://app.notion.com/p/2bbfc75cbbd9807abb0bf879e55e4632?pvs=204

- Open-source identity and access management (IAM) solution.
- Supports <b>Single Sign-On (SSO)</b> for multiple applications.
- Provides <b>centralized user management</b> (users, roles, permissions).
- Built using <b>Java</b>.
- Offers <b>adapters</b> to integrate easily with frameworks like <b>Spring Boot</b>.

## <b>Spring Security & Thymeleaf – Notes</b>

- Spring Security provides authentication and authorization support within the Spring Framework.
- Thymeleaf is a Java-based HTML template engine used to render dynamic web pages.
- HTML templates must be placed under <code>src/main/resources/templates</code> in a Spring Boot project.
- Spring Boot auto-creates the <code>templates</code> directory when using Thymeleaf dependencies.

### Keywords:

<b>Realm</b> : is a central place to have users, crdentials, roles (your organization)

- any app wants to use Keycloak i s a client that need client id and secret to connect

### Notes:

- On creating pass, the temporary is for when user login with your temp pass, keycloak will ask him to change it on 1st login
