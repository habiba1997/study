# Migration ownership story — 27 October 2026
Status: interview draft based on Habiba's account and pasted wiki; exact metric and final outcome pending verification. Internal code identifiers omitted intentionally; source wiki remains in user's attachment.

## Evidence and claim boundaries
- User reports owning order-service migration Java17->21 and Spring Boot2.7->3; these are separate upgrades, not equivalent version changes.
- Reported database connections increased from roughly30–40 to100–200 during peak traffic, with latency/timeouts. Confirm metric: active connections, total pooled connections, or aggregate across instances? Do not call each connection a "pool."
- Team temporarily increased pool size because rollback was judged risky due to unvalidated database/Liquibase compatibility. This is mitigation, not general advice or proven root cause. Increasing pools can overwhelm database; should be bounded and monitored.
- User reports code/config changes helped partially; exact numbers unclear. Do not fabricate reduction or restored baseline.
- User reports tracing an extra persistence/transaction configuration to shared dependency and retaining only needed integration artifact, defining necessary beans explicitly. Pasted wiki does not establish final causal chain; phrase as user's finding, not independently proven.
- Client did not permit representative load testing in QA. State validation limitation; do not claim load-tested fix.

## Wiki findings and corrections
1. SQL example uses same table twice without linking roots; predicate filters only second alias. This can multiply rows; first alias is unfiltered. Reuse one Criteria root for selection/predicate. Check createCriteria() helper doesn't already create a root.
2. Workaround HQL maxResults1 does not preserve uniqueResult semantics if multiple legitimate matches exist; define/enforce cardinality.
3. @Primary gives preference in single-bean injection. It does not directly change entity scanning. Investigate which EntityManagerFactory/datasource/transaction manager each repository uses and each factory's managed packages.
4. NonUniqueObjectException means two different Java entity instances of same entity identity in one Hibernate Session; it is not by itself evidence Liquibase or @Primary caused the conflict.
5. HikariDataSource owns/configures pool; EntityManagerFactory manages persistence units; transaction manager coordinates boundaries. Multiple transaction managers alone do not prove connection leakage.
6. Duplicate pool names can cause observability/metric registration problems in some setups; renaming is not evidence a connection leak was fixed.
7. An escaping unchecked exception normally causes Spring transactional rollback; "uncaught exception leaves transaction open" requires actual lifecycle/cleanup evidence.
8. Liquibase term: changeset checksum. Checksum mismatch is a validation problem, not proof rollback would delete data. Application rollback and schema rollback are separate. Cite actual backwards-incompatible migration or tested failure when available.
9. ChainedTransactionManager is not a guarantee of atomic distributed commit; do not rely on it as proof all resources commit together.

## Draft spoken answer (roughly90 seconds)
I owned the migration of a critical order service from Java17 and Spring Boot2.7 to Java21 and Spring Boot3. After deployment, we observed increased database connection usage during peak traffic, along with slower and failed requests.

I joined the client investigation. We considered rollback, but database-migration compatibility had not been sufficiently validated. The team temporarily increased connection-pool capacity to stabilize the service while I investigated.

I reviewed the persistence configuration and shared-library integration. I documented a malformed Criteria query that generated a Cartesian product, as well as configuration problems involving multiple persistence components. In my investigation I also identified unnecessary configuration from a shared dependency, and simplified the integration so that the application retained only the modules and beans it needed.

The intermediate changes reduced connection pressure, but I would verify the final production metrics before claiming full recovery. Because representative QA load testing was not permitted, I was explicit about that validation limitation. The main lesson was to verify rollback compatibility, inspect shared-library auto-configuration, and test multi-datasource behavior before subsequent migrations.

## Improve before interview
- Replace broad "connection usage" with measured metric and scope after checking monitoring.
- Confirm which actions were personally implemented versus team decisions.
- Confirm final dependency change, deployment outcome and comparable-load metrics.
- State prevention actually adopted, not merely suggested. User reports later rollback checks in dev/QA; verify details.
- Keep deep technical details for follow-up; lead with impact, ownership, decision, action, evidence and learning.
- Do not invent an exact before/after figure or claim the wiki proves an unidentified leak.

## Vocabulary
Under heavy load / peak traffic; database connection pool; connection-pool exhaustion; connection acquisition timeout; latency regression; incident mitigation; root-cause investigation; dependency auto-configuration; persistence unit; EntityManagerFactory; transaction manager; changeset checksum; rollback compatibility; load testing; regression prevention.

## Sources
https://docs.spring.io/spring/reference/core/beans/annotation-config/autowired-primary.html
https://docs.hibernate.org/stable/core/javadocs/org/hibernate/NonUniqueObjectException.html
https://support.liquibase.com/hc/en-us/articles/43904501295643-Troubleshooting-rollback-issues
