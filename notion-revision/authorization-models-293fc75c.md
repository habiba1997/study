# Authorization Models

Source: https://app.notion.com/p/293fc75cbbd98040b0edc0b6b51eb3c0?pvs=204

<p>
Authorization determines what actions a user can perform within a system once their identity is confirmed. Three main authorization models: Role-Based Access Control (RBAC), Attribute-Based Access Control (ABAC), and Access Control Lists (ACL). 
</p>

<p>
<b>RBAC</b> (Role-Based Access Control) assigns users to predefined roles (e.g., admin, editor, viewer), each with specific permissions. This model is widely used due to its simplicity and clear structure, as demonstrated with GitHub repositories where different users have different access levels like read, write, or admin control. 
</p>

<image source="notion-file-block://293fc75c-bbd9-80aa-8b7c-f6bfe073af01/2707bf15-fce1-4fa6-99ec-10cbcbf80213?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=Screenshot_2025-10-21_at_12.17.33_PM.png" />

<b>ABAC</b> (Attribute-Based Access Control) extends beyond roles by considering user attributes (e.g., department, age), resource attributes (e.g., confidentiality), and environmental conditions (e.g., time, location) to make dynamic and fine-grained authorization decisions. While ABAC offers <u>greater flexibility</u>, it is <u>more complex</u> and requires robust policy management.

<image source="notion-file-block://293fc75c-bbd9-80cd-8ecf-e8971bf21946/3e4665bd-e248-4b1f-b30c-c431747374a6?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=Screenshot_2025-10-21_at_12.18.39_PM.png" />

<b>ACLs</b> (Access Control Lists) manage access by associating permission lists directly with resources, specifying which users can perform certain actions on each resource. This model is user-specific and resource-specific, exemplified by <u>Google Drive’s</u> document sharing, where users are granted varying access levels such as read-only or editing rights. Although ACLs offer detailed control, they can be <u>harder to scale in large systems with many users and resources.</u>

<image source="notion-file-block://293fc75c-bbd9-80ca-be93-e942ceabb7ac/45a3903d-b661-4ac0-b8e8-6ee4f2c5dd66?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=Screenshot_2025-10-21_at_12.17.59_PM.png" />

## Authorization Implementations:

<p>
Authorization is enforced in practice using technologies like <b>OAuth 2.0</b> and <b>JSON Web Tokens (JWTs)</b>. 
</p>

<p>
OAuth 2.0 is a delegated authorization protocol that allows third-party applications to access user resources securely without sharing passwords, using tokens that represent specific permissions. 
</p>

<image source="notion-file-block://293fc75c-bbd9-80df-bf4b-c00b5f263b0b/241fdefc-871d-453e-8129-db92a2547e16?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=Screenshot_2025-10-21_at_12.28.43_PM.png" />

<p>
JWTs carry user identity and permission claims, enabling backend systems to validate and enforce access controls efficiently.  
</p>

<image source="notion-file-block://293fc75c-bbd9-804c-b145-f101700910f4/a1cbb799-5d9e-4d28-9460-3cbbabcb7c60?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=Screenshot_2025-10-21_at_12.29.43_PM.png" />

---

---

---

---

—

### <b>Key Insights</b>

- 👥 <b>Role-Based Access Control (RBAC) Simplifies Permission Management:</b> By grouping permissions under roles, RBAC enables easier administration in many applications. For instance, systems like GitHub use roles such as admin, editor, and viewer to quickly manage access levels. However, RBAC can be rigid and may lack flexibility to accommodate nuanced access rules.
- ⚙️ <b>Attribute-Based Access Control (ABAC) Offers Fine-Grained Flexibility:</b> ABAC’s ability to incorporate multiple user, resource, and environmental attributes allows dynamic and context-aware permission decisions. This is especially useful in complex organizations where access needs to reflect multiple factors such as department, document classification, or time of access. However, ABAC’s complexity can lead to conflicts and requires robust policy management tools.
- 📄 <b>Access Control Lists (ACLs) Provide Resource-Centric Control:</b> ACLs are highly granular and user-specific, making them ideal for scenarios where permissions vary widely per resource, like document sharing on Google Drive. The downside is scalability; managing ACLs in systems with millions of users and resources can become cumbersome without automation and efficient management strategies.
- 🔄 <b>Combining Authorization Models Enhances Security and Usability:</b> Modern systems often blend RBAC, ABAC, and ACL to balance ease of management, flexibility, and fine-grained control. For example, an application may use RBAC for broad role assignments, ABAC for conditional access, and ACLs for specific resource sharing.
- 🔑 <b>OAuth 2.0 Enables Secure Delegated Authorization:</b> OAuth 2.0 allows users to grant third-party applications controlled access to their resources without sharing sensitive credentials like passwords. By issuing access tokens that represent limited scopes and permissions, OAuth 2.0 enhances security and user trust in multi-service ecosystems.
- 🛡️ <b>JWTs Facilitate Efficient Authorization Enforcement:</b> JSON Web Tokens (JWTs) carry encoded information about the user’s identity, roles, and permitted scopes. Backend servers validate these tokens to enforce authorization rules on incoming requests. This token-based approach streamlines access control decisions and supports stateless authentication architectures common in modern web services.

Overall, the video provides a comprehensive overview of authorization fundamentals, models, and enforcement mechanisms crucial for building secure and scalable applications. Understanding these concepts enables developers and security professionals to implement robust access control strategies tailored to their system’s needs.
