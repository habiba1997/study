# java-spring-cheatsheet

Source: https://app.notion.com/p/3c1fc75cbbd98067aa2bd1232d3c09a6?pvs=204

▾ Contents<br />28 topics · 259 terms

Topics<br /><br />All terms

[OOP fundamentals9](about:blank#sec-oop-fundamentals)

- [Encapsulation](about:blank#t-encapsulation)
- [Abstraction](about:blank#t-abstraction)
- [Inheritance](about:blank#t-inheritance)
- [Polymorphism](about:blank#t-polymorphism)
- [Method overloading](about:blank#t-method-overloading)
- [Method overriding](about:blank#t-method-overriding)
- [Overriding and visibility](about:blank#t-overriding-and-visibility)
- [Association](about:blank#t-association)
- [Composition](about:blank#t-composition)

[Java language basics14](about:blank#sec-java-language-basics)

- [Access modifiers](about:blank#t-access-modifiers)
- [<code>static</code>](about:blank#t-static)
- [<code>final</code>](about:blank#t-final)
- [<code>transient</code>](about:blank#t-transient)
- [Wrapper vs primitive](about:blank#t-wrapper-vs-primitive)
- [Varargs ⚠️](about:blank#t-varargs)
- [Switch statement](about:blank#t-switch-statement)
- [Anonymous class](about:blank#t-anonymous-class)
- [Marker interface](about:blank#t-marker-interface)
- [Serialization](about:blank#t-serialization)
- [<code>record</code>](about:blank#t-record)[ ⚠️](about:blank#t-record)
- [Sealed class](about:blank#t-sealed-class)
- [<code>a = x++</code>](about:blank#t-a-x-vs-a-x)[ vs ](about:blank#t-a-x-vs-a-x)[<code>a = ++x</code>](about:blank#t-a-x-vs-a-x)
- [Reflection](about:blank#t-reflection)

[Exceptions & error handling4](about:blank#sec-exceptions-error-handling)

- [<code>Throwable</code>](about:blank#t-throwable-hierarchy)[ hierarchy](about:blank#t-throwable-hierarchy)
- [Checked exception](about:blank#t-checked-exception)
- [Unchecked exception](about:blank#t-unchecked-exception)
- [Resource management](about:blank#t-resource-management)

[Collections & hashing8](about:blank#sec-collections-hashing)

- [Collection](about:blank#t-collection)
- [Hash collision](about:blank#t-hash-collision)
- [Separate chaining](about:blank#t-separate-chaining)
- [Open addressing](about:blank#t-open-addressing)
- [<code>HashMap</code>](about:blank#t-hashmap)
- [<code>LinkedHashMap</code>](about:blank#t-linkedhashmap)
- [<code>TreeMap</code>](about:blank#t-treemap)[ ⚠️](about:blank#t-treemap)
- [<code>TreeMap</code>](about:blank#t-treemap-vs-linkedhashmap-the-one-liner)[ vs ](about:blank#t-treemap-vs-linkedhashmap-the-one-liner)[<code>LinkedHashMap</code>](about:blank#t-treemap-vs-linkedhashmap-the-one-liner)[ — the one-liner](about:blank#t-treemap-vs-linkedhashmap-the-one-liner)

[Streams & functional Java5](about:blank#sec-streams-functional-java)

- [Stream](about:blank#t-stream)
- [<code>reduce</code>](about:blank#t-reduce)
- [Parallel stream](about:blank#t-parallel-stream)
- [Fork/Join framework](about:blank#t-forkjoin-framework)
- [<code>Optional</code>](about:blank#t-optional)

[Hardware & memory basics8](about:blank#sec-hardware-memory-basics)

- [CPU (Central Processing Unit)](about:blank#t-cpu-central-processing-unit)
- [CPU register](about:blank#t-cpu-register)
- [CPU cache](about:blank#t-cpu-cache)
- [RAM (Random Access Memory)](about:blank#t-ram-random-access-memory)
- [Memory hierarchy — fastest to slowest](about:blank#t-memory-hierarchy-fastest-to-slowest)
- [Volatile memory](about:blank#t-volatile-memory)
- [Stack memory vs heap memory ⚠️](about:blank#t-stack-memory-vs-heap-memory)
- [Thread caching of shared data](about:blank#t-thread-caching-of-shared-data)

[JVM memory, GC & diagnostics6](about:blank#sec-jvm-memory-gc-diagnostics)

- [Garbage collection (GC)](about:blank#t-garbage-collection-gc)
- [Memory leak](about:blank#t-memory-leak)
- [Heap dump](about:blank#t-heap-dump)
- [Thread dump](about:blank#t-thread-dump)
- [Profiling](about:blank#t-profiling)
- [PermGen / Metaspace ⚠️](about:blank#t-permgen-metaspace)

[Concurrency & threading15](about:blank#sec-concurrency-threading)

- [Thread-safe](about:blank#t-thread-safe)
- [<code>synchronized</code>](about:blank#t-synchronized)
- [Intrinsic lock (monitor lock)](about:blank#t-intrinsic-lock-monitor-lock)
- [<code>volatile</code>](about:blank#t-volatile)
- [Atomic variables](about:blank#t-atomic-variables)
- [<code>ReentrantLock</code>](about:blank#t-reentrantlock)
- [<code>ReadWriteLock</code>](about:blank#t-readwritelock)
- [Atomics vs locks — comparison](about:blank#t-atomics-vs-locks-comparison)
- [<code>ConcurrentHashMap</code>](about:blank#t-concurrenthashmap)[ ⚠️](about:blank#t-concurrenthashmap)
- [<code>ConcurrentLinkedQueue</code>](about:blank#t-concurrentlinkedqueue)
- [<code>CopyOnWriteArrayList</code>](about:blank#t-copyonwritearraylist)[ ⚠️](about:blank#t-copyonwritearraylist)
- [<code>CompletableFuture</code>](about:blank#t-completablefuture)
- [Virtual threads (Java 21+)](about:blank#t-virtual-threads-java-21)
- [Thread pool](about:blank#t-thread-pool)
- [Servlet container](about:blank#t-servlet-container)

[JDK, JRE & Java versions7](about:blank#sec-jdk-jre-java-versions)

- [JDK (Java Development Kit)](about:blank#t-jdk-java-development-kit)
- [JRE (Java Runtime Environment)](about:blank#t-jre-java-runtime-environment)
- [Java 8 (2014, LTS)](about:blank#t-java-8-2014-lts)
- [Java 9 (2017)](about:blank#t-java-9-2017)
- [Java 11 (2018, LTS)](about:blank#t-java-11-2018-lts)
- [Java 17 (2021, LTS)](about:blank#t-java-17-2021-lts)
- [Java 21 (2023, LTS)](about:blank#t-java-21-2023-lts)

[HTTP & REST8](about:blank#sec-http-rest)

- [Status codes worth memorizing](about:blank#t-status-codes-worth-memorizing)
- [HTTP headers](about:blank#t-http-headers)
- [<code>OPTIONS</code>](about:blank#t-options-method)[ method](about:blank#t-options-method)
- [CORS (Cross-Origin Resource Sharing)](about:blank#t-cors-cross-origin-resource-sharing)
- [Preflight request](about:blank#t-preflight-request)
- [Idempotent request](about:blank#t-idempotent-request)
- [HATEOAS](about:blank#t-hateoas)
- [MVC (Model–View–Controller)](about:blank#t-mvc-modelviewcontroller)

[Spring core — IoC & dependency injection6](about:blank#sec-spring-core-ioc-dependency-injection)

- [IoC (Inversion of Control)](about:blank#t-ioc-inversion-of-control)
- [DI (Dependency Injection)](about:blank#t-di-dependency-injection)
- [Constructor injection](about:blank#t-constructor-injection)
- [Field injection](about:blank#t-field-injection)
- [Setter injection](about:blank#t-setter-injection)
- [<code>@Autowired</code>](about:blank#t-autowired)

[Spring core — container & beans5](about:blank#sec-spring-core-container-beans)

- [Spring container](about:blank#t-spring-container)
- [<code>BeanFactory</code>](about:blank#t-beanfactory)
- [<code>ApplicationContext</code>](about:blank#t-applicationcontext)
- [Bean lifecycle](about:blank#t-bean-lifecycle)
- [Bean scopes](about:blank#t-bean-scopes)

[Spring core — stereotype annotations13](about:blank#sec-spring-core-stereotype-annotations)

- [<code>@Component</code>](about:blank#t-component)
- [<code>@Service</code>](about:blank#t-service)
- [<code>@Repository</code>](about:blank#t-repository)
- [<code>@Controller</code>](about:blank#t-controller)
- [<code>@RestController</code>](about:blank#t-restcontroller)
- [<code>@ResponseBody</code>](about:blank#t-responsebody)
- [<code>@ControllerAdvice</code>](about:blank#t-controlleradvice-restcontrolleradvice)[ / ](about:blank#t-controlleradvice-restcontrolleradvice)[<code>@RestControllerAdvice</code>](about:blank#t-controlleradvice-restcontrolleradvice)[ ⚠️](about:blank#t-controlleradvice-restcontrolleradvice)
- [<code>@Configuration</code>](about:blank#t-configuration)
- [<code>@Bean</code>](about:blank#t-bean)
- [<code>@Value</code>](about:blank#t-value)
- [<code>@Profile</code>](about:blank#t-profile)
- [<code>@Conditional</code>](about:blank#t-conditional)
- [SpEL (Spring Expression Language)](about:blank#t-spel-spring-expression-language)

[Spring core — AOP & transactions5](about:blank#sec-spring-core-aop-transactions)

- [Proxy-based AOP](about:blank#t-proxy-based-aop)
- [AspectJ-based AOP](about:blank#t-aspectj-based-aop)
- [Declarative transaction management](about:blank#t-declarative-transaction-management)
- [Propagation behaviour](about:blank#t-propagation-behaviour)
- [Transaction manager](about:blank#t-transaction-manager)

[Spring web — request pipeline4](about:blank#sec-spring-web-request-pipeline)

- [<code>DispatcherServlet</code>](about:blank#t-dispatcherservlet)
- [Servlet filter](about:blank#t-servlet-filter)
- [Interceptor](about:blank#t-interceptor)
- [Filter vs interceptor — the one-liner](about:blank#t-filter-vs-interceptor-the-one-liner)

[Spring Boot8](about:blank#sec-spring-boot)

- [Spring vs Spring Boot — deployment](about:blank#t-spring-vs-spring-boot-deployment)
- [Spring vs Spring Boot — configuration](about:blank#t-spring-vs-spring-boot-configuration)
- [<code>@SpringBootApplication</code>](about:blank#t-springbootapplication)
- [<code>@EnableAutoConfiguration</code>](about:blank#t-enableautoconfiguration)
- [Starter dependency](about:blank#t-starter-dependency)
- [Spring Web (what the starter gives you automatically)](about:blank#t-spring-web-what-the-starter-gives-you-automatically)
- [<code>application.properties</code>](about:blank#t-applicationproperties-applicationyml)[ / ](about:blank#t-applicationproperties-applicationyml)[<code>application.yml</code>](about:blank#t-applicationproperties-applicationyml)
- [Spring Boot Actuator](about:blank#t-spring-boot-actuator)

[JPA, Hibernate & Spring Data23](about:blank#sec-jpa-hibernate-spring-data)

- [JPA (Java Persistence API)](about:blank#t-jpa-java-persistence-api)
- [Hibernate](about:blank#t-hibernate)
- [Spring Data JPA](about:blank#t-spring-data-jpa)
- [JPQL (Java Persistence Query Language)](about:blank#t-jpql-java-persistence-query-language)
- [<code>@EnableJpaRepositories</code>](about:blank#t-enablejparepositories)
- [Entity relationships — the annotations](about:blank#t-entity-relationships-the-annotations)
- [<code>@JoinColumn</code>](about:blank#t-joincolumn-the-owning-side)[ — the owning side](about:blank#t-joincolumn-the-owning-side)
- [<code>mappedBy</code>](about:blank#t-mappedby-the-inverse-side)[ — the inverse side](about:blank#t-mappedby-the-inverse-side)
- [<code>@JoinTable</code>](about:blank#t-jointable-many-to-many)[ — many-to-many](about:blank#t-jointable-many-to-many)
- [Eager fetching](about:blank#t-eager-fetching)
- [Lazy fetching](about:blank#t-lazy-fetching)
- [JPA default fetch types](about:blank#t-jpa-default-fetch-types)
- [N+1 problem](about:blank#t-n1-problem)
- [Caching (general)](about:blank#t-caching-general)
- [First-level cache (session cache)](about:blank#t-first-level-cache-session-cache)
- [Second-level cache](about:blank#t-second-level-cache)
- [<code>@Cacheable</code>](about:blank#t-cacheable-two-different-annotations)[ — two different annotations ⚠️](about:blank#t-cacheable-two-different-annotations)
- [Second-level cache concurrency strategies](about:blank#t-second-level-cache-concurrency-strategies)
- [Query cache](about:blank#t-query-cache)
- [Projection](about:blank#t-projection)
- [Open projection](about:blank#t-open-projection)
- [Class-based projection (DTO projection)](about:blank#t-class-based-projection-dto-projection)
- [<code>@Formula</code>](about:blank#t-formula)[ ⚠️](about:blank#t-formula)

[Entity inheritance strategies6](about:blank#sec-entity-inheritance-strategies)

- [Polymorphic query](about:blank#t-polymorphic-query)
- [Mapped superclass](about:blank#t-mapped-superclass)
- [Table per class](about:blank#t-table-per-class)
- [Single table](about:blank#t-single-table)
- [Joined table](about:blank#t-joined-table)
- [Choosing between them — quick rule](about:blank#t-choosing-between-them-quick-rule)

[Spring Security8](about:blank#sec-spring-security)

- [Spring Security](about:blank#t-spring-security)
- [Authentication](about:blank#t-authentication)
- [Authorization](about:blank#t-authorization)
- [RBAC (Role-Based Access Control)](about:blank#t-rbac-role-based-access-control)
- [Token-based authentication](about:blank#t-token-based-authentication)
- [Security filter chain ⚠️](about:blank#t-security-filter-chain)
- [<code>antMatchers</code>](about:blank#t-antmatchers-requestmatchers)[ / ](about:blank#t-antmatchers-requestmatchers)[<code>requestMatchers</code>](about:blank#t-antmatchers-requestmatchers)
- [The three authentication scenarios](about:blank#t-the-three-authentication-scenarios)

[JWT, OAuth2 & OIDC6](about:blank#sec-jwt-oauth2-oidc)

- [JWT (JSON Web Token)](about:blank#t-jwt-json-web-token)
- [Refresh token](about:blank#t-refresh-token)
- [OAuth2](about:blank#t-oauth2)
- [OAuth2 authorization code flow](about:blank#t-oauth2-authorization-code-flow)
- [OIDC (OpenID Connect)](about:blank#t-oidc-openid-connect)
- [Keycloak](about:blank#t-keycloak)

[CSRF, CORS & encryption7](about:blank#sec-csrf-cors-encryption)

- [CSRF (Cross-Site Request Forgery)](about:blank#t-csrf-cross-site-request-forgery)
- [CSRF protection in Spring Security ⚠️](about:blank#t-csrf-protection-in-spring-security)
- [CSRF and session-centric applications](about:blank#t-csrf-and-session-centric-applications)
- [Symmetric key encryption](about:blank#t-symmetric-key-encryption)
- [Public key (asymmetric) encryption](about:blank#t-public-key-asymmetric-encryption)
- [Hashing](about:blank#t-hashing)
- [Salting](about:blank#t-salting)

[Method-level security7](about:blank#sec-method-level-security)

- [Method security ⚠️](about:blank#t-method-security)
- [<code>@Secured</code>](about:blank#t-secured)
- [<code>@RolesAllowed</code>](about:blank#t-rolesallowed)
- [<code>@PreAuthorize</code>](about:blank#t-preauthorize)
- [<code>@PostAuthorize</code>](about:blank#t-postauthorize)
- [<code>@PreFilter</code>](about:blank#t-prefilter)
- [<code>@PostFilter</code>](about:blank#t-postfilter)

[Testing16](about:blank#sec-testing)

- [Mockito](about:blank#t-mockito)
- [<code>@Mock</code>](about:blank#t-mock)
- [<code>@Spy</code>](about:blank#t-spy)
- [<code>@InjectMocks</code>](about:blank#t-injectmocks)
- [Mockito's stubbing limits ⚠️](about:blank#t-mockitos-stubbing-limits)
- [<code>ArgumentCaptor</code>](about:blank#t-argumentcaptor)
- [JMockit](about:blank#t-jmockit)
- [Hamcrest](about:blank#t-hamcrest)
- [<code>@RunWith</code>](about:blank#t-runwith-junit-4)[ (JUnit 4)](about:blank#t-runwith-junit-4)
- [<code>@ExtendWith</code>](about:blank#t-extendwith-junit-5)[ (JUnit 5)](about:blank#t-extendwith-junit-5)
- [<code>@Rule</code>](about:blank#t-rule-junit-4)[ (JUnit 4)](about:blank#t-rule-junit-4)
- [Spring TestContext Framework](about:blank#t-spring-testcontext-framework)
- [<code>@SpringBootTest</code>](about:blank#t-springboottest)
- [<code>@MockBean</code>](about:blank#t-mockbean)[ ⚠️](about:blank#t-mockbean)
- [<code>@DataJpaTest</code>](about:blank#t-datajpatest)
- [JaCoCo](about:blank#t-jacoco)

[Maven26](about:blank#sec-maven)

- [Maven default lifecycle ⚠️](about:blank#t-maven-default-lifecycle)
- [Phase](about:blank#t-phase)
- [Goal](about:blank#t-goal)
- [<code><goals></code>](about:blank#t-goals-vs-phase)[ vs ](about:blank#t-goals-vs-phase)[<code><phase></code>](about:blank#t-goals-vs-phase)
- [Maven as a plugin execution framework](about:blank#t-maven-as-a-plugin-execution-framework)
- [Compiler Plugin](about:blank#t-compiler-plugin)
- [Surefire Plugin](about:blank#t-surefire-plugin)
- [Failsafe Plugin](about:blank#t-failsafe-plugin)
- [<code><groupId></code>](about:blank#t-groupid)
- [<code><artifactId></code>](about:blank#t-artifactid)
- [<code><version></code>](about:blank#t-version)
- [<code><scope></code>](about:blank#t-scope)
- [<code><exclusions></code>](about:blank#t-exclusions)
- [<code><repositories></code>](about:blank#t-repositories)
- [Local repository](about:blank#t-local-repository)
- [<code>pom.xml</code>](about:blank#t-pomxml)
- [Super POM](about:blank#t-super-pom)
- [<code><dependencyManagement></code>](about:blank#t-dependencymanagement)
- [BOM (Bill Of Materials)](about:blank#t-bom-bill-of-materials)
- [POM packaging](about:blank#t-pom-packaging)
- [JAR packaging](about:blank#t-jar-packaging)
- [Aggregator POM](about:blank#t-aggregator-pom)
- [Parent POM](about:blank#t-parent-pom)
- [Transitive dependency](about:blank#t-transitive-dependency)
- [Dependency mediation — "nearest wins"](about:blank#t-dependency-mediation-nearest-wins)
- [Maven profile](about:blank#t-maven-profile)

[Microservices & distributed systems10](about:blank#sec-microservices-distributed-systems)

- [Spring Boot vs Spring Cloud](about:blank#t-spring-boot-vs-spring-cloud)
- [Spring Cloud](about:blank#t-spring-cloud)
- [Spring Cloud Config](about:blank#t-spring-cloud-config)
- [Spring Cloud Gateway](about:blank#t-spring-cloud-gateway)
- [Spring Cloud OpenFeign](about:blank#t-spring-cloud-openfeign)
- [Spring Cloud LoadBalancer](about:blank#t-spring-cloud-loadbalancer)
- [Spring Cloud Kubernetes](about:blank#t-spring-cloud-kubernetes)
- [API gateway](about:blank#t-api-gateway)
- [API gateway vs load balancer](about:blank#t-api-gateway-vs-load-balancer)
- [Distributed SQL databases](about:blank#t-distributed-sql-databases)

[Libraries & tools4](about:blank#sec-libraries-tools)

- [Jackson](about:blank#t-jackson)
- [ModelMapper](about:blank#t-modelmapper)
- [MapStruct](about:blank#t-mapstruct)
- [Redis](about:blank#t-redis)

[Spring version history4](about:blank#sec-spring-version-history)

- [Spring Framework 1.x](about:blank#t-spring-framework-1x)
- [Spring Framework 2.x](about:blank#t-spring-framework-2x)
- [Spring Framework 4.x / 5.x](about:blank#t-spring-framework-4x-5x)
- [Spring Framework 6.x](about:blank#t-spring-framework-6x)

[Java & Spring migrations (Spring Boot 2 → 3, Java 11 → 25)17](about:blank#sec-java-spring-migrations-spring-boot-2-3-java-11-25)

- [Why the upgrade happens at all](about:blank#t-why-the-upgrade-happens-at-all)
- [Spring Boot 2 → 3 — the baseline](about:blank#t-spring-boot-2-3-the-baseline)
- [<code>javax.*</code>](about:blank#t-javax-jakarta)[ → ](about:blank#t-javax-jakarta)[<code>jakarta.*</code>](about:blank#t-javax-jakarta)
- [Spring Security 5 → 6 — old → new](about:blank#t-spring-security-5-6-old-new)
- [Hibernate 5 → 6](about:blank#t-hibernate-5-6)
- [Spring MVC & web changes (Boot 2 → 3)](about:blank#t-spring-mvc-web-changes-boot-2-3)
- [Config, Actuator & observability changes](about:blank#t-config-actuator-observability-changes)
- [Testing changes (Boot 2 → 3)](about:blank#t-testing-changes-boot-2-3)
- [Java 11 → 17 — strong encapsulation](about:blank#t-java-11-17-strong-encapsulation)
- [Java 11 → 17 — what was removed](about:blank#t-java-11-17-what-was-removed)
- [Java 11 → 17 — what you gain](about:blank#t-java-11-17-what-you-gain)
- [Java 17 → 21](about:blank#t-java-17-21)
- [Java 21 → 25](about:blank#t-java-21-25)
- [Migration playbook — the order that works](about:blank#t-migration-playbook-the-order-that-works)
- [Migration tooling](about:blank#t-migration-tooling)
- [Migration pitfall: dependency mediation](about:blank#t-migration-pitfall-dependency-mediation)
- [What's next: Spring Boot 4 / Spring Framework 7](about:blank#t-whats-next-spring-boot-4-spring-framework-7)

▾ How to update this cheat sheet<br />how to add your own terms

<b>The </b><b><code>.md</code></b><b> file is the master. The </b><b><code>.html</code></b><b> is generated from it.</b> So you always edit the markdown, then regenerate the HTML if you want the searchable version updated.

### The format — three rules

1. <b><code>##</code></b><b> starts a topic.</b> It becomes a section, a filter chip, and a Contents entry.
2. <b><code>###</code></b><b> starts a term.</b> It becomes one card.
3. <b>Inside a term, the split is the first bullet.</b> Everything before the first  line is the definition (big text). Everything from the first  onward becomes the notes (small bulleted text).

That's the whole system. Copy this template:

```markdown
### My new term
The short definition goes here. One or two sentences, the thing you want to say out loud in an interview.
-First extra note — a caveat, a follow-up answer, a gotcha.
-Second extra note. These render smaller and greyer than the definition.
```

### Extras you can use

- <b>Flag a term</b> by putting <code>⚠️</code> at the end of the <code>###</code> heading: <code>### My term ⚠️</code>. It gets a warning stripe and shows up under the "⚠️ Corrections only" filter.
- <b>Inline code</b> with backticks and <b>bold</b> with <code>*asterisks**</code> — both work in the heading and the body.
- <b>Code blocks</b> — fence them with triple backticks and a language (<code>```java</code>). Leave a blank line before the fence.
- <b>Tables</b> — normal markdown pipe tables work, header row and all.
- Blank line between the definition and the first bullet is optional; either way parses the same.

### Where to put a new term

- Put it inside the topic it belongs to. Topics and terms render in <b>file order</b>, so position matters — drop the term where it makes sense next to its relatives, not at the bottom.
- To add a whole new topic, add a <code>## Topic name</code> heading. Place it in the file according to the basics → advanced ordering, since that's the reading order.
- Don't renumber or re-slug anything; anchors are generated from the names automatically.

### Regenerating the HTML

The HTML is built by <code>build_html.py</code>, which sits next to the markdown file.

```bash
pip install markdown        # once
python3 build_html.py       # rebuilds java-spring-cheatsheet.html
```

- It reads <code>java-spring-cheatsheet.md</code> and writes <code>java-spring-cheatsheet.html</code>. No other input, no network.
- Term counts, topic chips, and the Contents panel are all recalculated automatically — nothing to update by hand.
- If you'd rather not run the script, just keep editing the markdown and use that. The content is identical.

### One thing that is hand-maintained

The <b>⚠️ Corrections</b> table at the top of the file is written by hand. If you flag a new term with <code>⚠️</code>, add a matching row there too — or don't, if you only want the inline flag. Everything else generates itself.

Grouped by topic, ordered basics → advanced. Related terms sit next to each other.<br />Each entry is a short definition first; the small bullets underneath carry the extra context and follow-up answers.

<b>⚠️ = your original note needed a correction.</b> The fix is in that term's bullets. All of them are listed below so you can review them in one pass. There's a <b>How to update this cheat sheet</b> section at the very end.

## ⚠️ Corrections — your notes vs. the fix

| Term | What you wrote | The fix |
| --- | --- | --- |
| <b><code>TreeMap</code></b><b> / </b><b><code>LinkedHashMap</code></b> | "Treetop vs linkedhashmap (sorted / insertion sorted)" | Two things. The class is <b><code>TreeMap</code></b>, not "Treetop". And <code>LinkedHashMap</code> does <b>not sort</b> — it just remembers the order you added things. Concretely: add <code>C, A, B</code> to a <code>TreeMap</code> and iterating gives <b>A, B, C</b> (it sorted them). Add <code>C, A, B</code> to a <code>LinkedHashMap</code> and iterating gives <b>C, A, B</b> (the order you inserted). So: <i><code>TreeMap</code></i><i> = sorted by key. </i><i><code>LinkedHashMap</code></i><i> = in the order you put them in.</i> |
| <b>Stack vs heap</b> | "static done in compile time while dynamic does in runtime" | Both allocate at <b>runtime</b>. The real difference: stack frame <i>sizes</i> are known at compile time and freed in LIFO order; heap size and lifetime are decided at runtime. |
| <b>Varargs</b> | "\~ spread operator" | These are <b>opposites</b>, so the comparison misleads. <b>Varargs</b> lives on the method <i>declaration</i>: "I accept any number of arguments" — <code>void f(String... names)</code>. JavaScript calls that a <b>rest</b> parameter: <code>function f(...args)</code>. A <b>spread</b> operator lives on the <i>call</i>: "take this array and hand it over as separate arguments" — <code>f(...arr)</code>. Java has the first, not the second. To pass an existing array to a varargs method you just pass the array: <code>f(myArray)</code>. |
| <b><code>record</code></b> | "introduced in Java 14" | Say <b>Java 17</b> (available from 16 onward). Also worth knowing: the immutability is <b>shallow</b> — a record holding a <code>List</code> can still have that list mutated. |
| <b>PermGen</b> | "after java 7 perm gen is not in heap anymore" | PermGen was <b>removed in Java 8</b>. Its replacement, <b>Metaspace</b>, lives in <b>native memory</b> (it never was heap) and grows automatically. |
| <b><code>ConcurrentHashMap</code></b> | "writers only lock a tiny segment" | Segment locking was <b>Java 7</b>. Since Java 8 it's <b>per-bin</b> locking on the first node plus CAS — finer-grained than segments. |
| <b><code>CopyOnWriteArrayList</code></b> | "all mutative operations are implemented" (sentence cut off) | …are implemented by making a <b>fresh copy of the entire backing array</b>. That's the whole trade-off. |
| <b><code>@Cacheable</code></b><b> — two different annotations</b> | used it for the Hibernate 2nd-level cache | Correct, but there are <b>two unrelated annotations with the same name</b>, and mixing them up is a classic interview trap. <b><code>jakarta.persistence.@Cacheable</code></b> goes on an <b>entity</b> and turns on Hibernate's second-level cache for it. <b><code>org.springframework.cache.annotation.@Cacheable</code></b> goes on a <b>method</b> and caches that method's return value against its arguments. Different layer, different target, different cache. Rule of thumb: <i>entity → JPA's. Method → Spring's.</i> |
| <b><code>@Formula</code></b> | <code>lower(datediff(curdate(), birth_date / 365)</code> | Unbalanced parens, division in the wrong argument, and <code>lower()</code> on a number. Correct: <code>datediff(curdate(), birth_date) / 365</code>. |
| <b>"Advice Controller"</b> | name | The annotation is <b><code>@ControllerAdvice</code></b> / <code>@RestControllerAdvice</code>. |
| <b>CSRF token storage</b> | "stored in a cookie named XSRF-TOKEN … header X-XSRF-TOKEN" | That's <code>CookieCsrfTokenRepository</code>, which you have to configure yourself. <b>Spring Security's default is </b><b><code>HttpSessionCsrfTokenRepository</code></b> — the token lives in the HTTP session and comes back as the <code>_csrf</code> parameter or the <code>X-CSRF-TOKEN</code> header. Know both; interviewers ask which is the default. |
| <b>Mockito stubbing limits</b> | "doesn't allow stubbing of final, private, or static" | Outdated. <code>mockStatic()</code> since <b>Mockito 3.4</b>; the <b>inline mock maker</b> (default in Mockito 5) mocks <code>final</code> classes and methods. Only <code>private</code> is still out — and mocking a private method is a design smell anyway. |
| <b><code>@MockBean</code></b> | current API | <b>Deprecated in Spring Boot 3.4.</b> Old → new: <code>@MockBean</code> → <b><code>@MockitoBean</code></b>, <code>@SpyBean</code> → <b><code>@MockitoSpyBean</code></b>. |
| <b><code>@EnableGlobalMethodSecurity</code></b> | current API | <b>Deprecated in Spring Security 6.</b> Old → new: <code>@EnableGlobalMethodSecurity(prePostEnabled = true)</code> → <b><code>@EnableMethodSecurity</code></b> (<code>prePostEnabled</code> is on by default, so usually just the bare annotation). |
| <b><code>antMatchers</code></b><b> / </b><b><code>WebSecurityConfigurerAdapter</code></b> | Spring Security 5 API | In Spring Security 6: <code>antMatchers</code> → <b><code>requestMatchers</code></b>, <code>authorizeRequests</code> → <b><code>authorizeHttpRequests</code></b>, and <code>WebSecurityConfigurerAdapter</code> is <b>removed</b> in favour of a <code>SecurityFilterChain</code> bean. Full old → new table in the <b>Java & Spring migrations</b> topic. |
| <b>Maven lifecycle</b> | "clean → validate → compile → …" | <b><code>clean</code></b><b> is a separate lifecycle</b>, not part of the default one. Maven has three: <b>clean</b>, <b>default</b>, and <b>site</b>. <code>mvn clean install</code> is you invoking two lifecycles in one command. |

Two things your notes left as open questions, now answered in place: <b>"Spring container vs ApplicationContext"</b> (see <i>ApplicationContext</i>) and <b>"visibility order least → most"</b> (see <i>Overriding and visibility</i>).

## OOP fundamentals9

### Encapsulation

Bundling data and the methods that operate on it inside one class, and hiding internal state behind accessors so outside code can't corrupt it.

- Mechanism: <code>private</code> fields + <code>public</code> getters/setters, or better, immutable objects with no setters.
- Interview follow-up: "encapsulation vs abstraction?" Encapsulation hides <i>how the data is stored</i>; abstraction hides <i>how the work is done</i>.

### Abstraction

Exposing only what a caller needs to know and hiding the implementation behind an interface or abstract class.

- In Java: <code>interface</code> (contract only, multiple inheritance of type) and <code>abstract class</code> (partial implementation, single inheritance, can hold state).
- An interface can have <code>default</code> and <code>static</code> methods (Java 8+) and <code>private</code> methods (Java 9+).

### Inheritance

A subclass reuses and extends the state and behaviour of a superclass — an "is-a" relationship.

- Java has single class inheritance, multiple interface inheritance.
- Prefer composition over inheritance when you only want to reuse code, not model an "is-a".

### Polymorphism

One reference type behaving as many actual types, so the same call resolves to different implementations.

- Compile-time (static) polymorphism = <b>overloading</b>. Runtime (dynamic) polymorphism = <b>overriding</b>.

### Method overloading

Same method name, different parameter list, in the same class. Resolved by the compiler.

- Binding: <b>static / compile-time binding</b>. Return type alone is not enough to overload.

### Method overriding

A subclass replaces a superclass method with the same signature. Resolved by the JVM using the actual object type.

- Binding: <b>dynamic / runtime binding</b> (virtual method dispatch).
- Rules: can widen visibility, can't narrow it; can't throw broader <i>checked</i> exceptions; return type may be covariant.

### Overriding and visibility

When overriding, you may make the access modifier <b>more</b> visible, never less.

- Visibility order, least → most: <code>private</code> → package-private (default) → <code>protected</code> → <code>public</code>.
- So a <code>protected</code> method can be overridden as <code>public</code>, but not as <code>private</code>.

### Association

A "has-a" link between two classes that can each exist independently.

- Example: <code>Library</code> and <code>Book</code> — the library still exists without that particular book.

### Composition

A strong association where the contained object cannot exist without its owner. Owner controls its lifecycle.

- Example: <code>House</code> and <code>Room</code> — destroy the house, the rooms go with it.
- Aggregation sits between the two: "has-a" with shared ownership, parts survive the whole (<code>Team</code> and <code>Player</code>).

## Java language basics14

### Access modifiers

Four levels controlling who can see a class member.

- <code>private</code> — same class only.
- <b>default (package-private)</b> — same package only. This is the default for classes and methods when you write no modifier.
- <code>protected</code> — same package <b>plus</b> subclasses in other packages.
- <code>public</code> — everywhere.

### <code>static</code>

Belongs to the class itself, not to any instance. One copy shared by all instances.

- <b>Member (instance) variable</b> = one per object. <b>Class variable (</b><b><code>static</code></b><b>)</b> = one per class.
- Static class variables live on the heap, inside the <code>Class</code> object.
- <code>static</code> applies to fields, methods, nested classes, and initializer blocks — never to local variables.
- Private static methods are the usual home for internal utility logic.

### <code>final</code>

Locks something down. Meaning depends on where you put it.

- On a <b>class</b> — cannot be extended.
- On a <b>method</b> — cannot be overridden.
- On a <b>field/variable</b> — cannot be reassigned after initialization (the object it points to can still mutate).

### <code>transient</code>

Marks a field to be skipped when the object is serialized. On deserialization it comes back as the type's default (<code>null</code>, <code>0</code>, <code>false</code>).

- Typical use: caches, derived values, passwords, open connections.

### Wrapper vs primitive

Primitives (<code>int</code>, <code>long</code>, <code>boolean</code>, …) are raw values on the stack; wrappers (<code>Integer</code>, <code>Long</code>, <code>Boolean</code>, …) are objects on the heap.

- Only wrappers can go in collections and generics, and only wrappers can be <code>null</code>.
- <b>Autoboxing/unboxing</b> converts between them automatically — and can throw <code>NullPointerException</code> when unboxing a <code>null</code>.
- <code>Integer</code> caches −128..127, so <code>Integer.valueOf(100) == Integer.valueOf(100)</code> is <code>true</code> but <code>127+1</code> breaks it. Always compare with <code>.equals()</code>.

### Varargs⚠️

<code>Type... name</code> lets a method accept any number of arguments; inside the method it's an array.

- Must be the last parameter, and only one per method.
- ⚠️ The original note compared this to the <b>spread operator</b>. They're opposites, so the comparison misleads.
- <b>Varargs is on the declaration</b> — "this method accepts any number of arguments." JavaScript's equivalent is a <b>rest</b> parameter: <code>function f(...args)</code>.
- <b>Spread is on the call</b> — "take this array and hand it over as separate arguments": <code>f(...arr)</code>. <b>Java has no spread operator.</b> To pass an existing array to a varargs method, just pass the array.

```java
static void printNames(String... names) { for (String n : names) System.out.println(n); }

printNames("a", "b", "c");                 // pass separate arguments
printNames(new String[]{"a", "b", "c"});   // or pass the array directly — no spread needed
```

### Switch statement

Picks one branch by comparing an expression against constant case labels.

- <code>default</code> is optional. <code>break</code> is optional (omit it and execution falls through).
- The expression evaluates to <b>one value</b>, not a collection.
- Case labels must be compile-time constants — the compiler needs to know them all at compile time.
- Java 14+ adds <b>switch expressions</b>: arrow labels, no fall-through, returns a value, and must be exhaustive.

### Anonymous class

A class with no name, declared and instantiated in a single expression. Used for one-off implementations of an interface or subclass.

- Superseded by lambdas for single-method interfaces, but still needed when you implement multiple methods or need state.

```java
Runnable r = new Runnable() { public void run() { System.out.println("hi"); } };
```

### Marker interface

An interface with no methods or fields, used purely to tag a class with a property the runtime or a framework checks for.

- Examples: <code>Serializable</code>, <code>Cloneable</code>, <code>RandomAccess</code>.
- Annotations largely replaced this pattern, but <code>instanceof</code> checks on markers are faster than reflection.

### Serialization

Converting an object into a byte stream so it can be stored or sent over a network; deserialization rebuilds it.

- Requires <code>implements Serializable</code>. Add a <code>serialVersionUID</code> or version drift breaks deserialization.
- Skip fields with <code>transient</code>. Never deserialize untrusted input — it's a known remote-code-execution vector.

### <code>record</code>⚠️

A compact, immutable data carrier. You declare the components and the compiler generates the rest.

- Generates: canonical constructor, accessor per component (<code>x()</code> not <code>getX()</code>), <code>equals()</code>, <code>hashCode()</code>, <code>toString()</code>.
- Fields are <code>final</code>, there are no setters, and the class itself is implicitly <code>final</code>.
- ⚠️ Version: say <b>Java 17</b> (available from 16 onward). The original note said Java 14.
- Immutability is <b>shallow</b> — a record holding a <code>List</code> can still have that list mutated. Copy defensively if it matters.

```java
record Point(int x, int y) {}
```

### Sealed class

Explicitly controls which classes are allowed to extend a class or implement an interface. Java 17.

- <code>public sealed class Animal permits Dog, Cat { }</code> — only <code>Dog</code> and <code>Cat</code> may extend it.
- Every permitted subclass must declare one of: <code>final</code> (no further extension), <code>sealed</code> (extendable only by its own permit list), or <code>non-sealed</code> (reopens it to anyone).
- Real payoff is <b>exhaustive pattern matching</b> — the compiler knows the full set, so a <code>switch</code> over it needs no <code>default</code>.

```java
switch (payment) {
    case CreditCardPayment p -> ...;
    case CashPayment p       -> ...;
}
```

### <code>a = x++</code> vs <code>a = ++x</code>

<code>x++</code> (post-increment) assigns the old value, then increments. <code>++x</code> (pre-increment) increments first, then assigns.

- <code>int x = 5; int a = x++;</code> → <code>a == 5</code>, <code>x == 6</code>.
- <code>int x = 5; int a = ++x;</code> → <code>a == 6</code>, <code>x == 6</code>.

### Reflection

Inspecting and manipulating classes, fields, methods, and constructors at runtime, without knowing them at compile time.

- Powers Spring DI, Jackson, JPA, ModelMapper, Dozer, JUnit.
- Costs: slower than direct calls, breaks compile-time safety, and can be blocked by the module system (Java 9+) or <code>SecurityManager</code>.

## Exceptions & error handling4

### <code>Throwable</code> hierarchy

<code>Throwable</code> is the root; it splits into <code>Error</code> and <code>Exception</code>.

- <code>Error</code> — serious JVM problems you're not meant to catch: <code>OutOfMemoryError</code>, <code>StackOverflowError</code>, <code>NoClassDefFoundError</code>.
- <code>Exception</code> — application problems, split into checked and unchecked.

### Checked exception

An exception the compiler forces you to either catch or declare with <code>throws</code>. Also called a <b>compile-time exception</b>.

- Everything under <code>Exception</code> except <code>RuntimeException</code> and its subclasses.
- Examples: <code>SQLException</code>, <code>IOException</code>, <code>ClassNotFoundException</code>.

### Unchecked exception

A <code>RuntimeException</code> subclass. The compiler doesn't require handling; it surfaces at runtime.

- Examples: <code>NullPointerException</code>, <code>IllegalArgumentException</code>, <code>IndexOutOfBoundsException</code>, <code>ArithmeticException</code>.
- Rule of thumb: unchecked = programming bug, checked = recoverable external condition.

### Resource management

Close every resource you open. Use <b>try-with-resources</b>, or a <code>finally</code> block if you can't.

- try-with-resources needs <code>AutoCloseable</code>, closes in reverse order, and closes even when an exception is thrown.
- <code>finally</code> runs whether or not an exception occurred — but a <code>return</code> inside it swallows exceptions.

```java
try (var conn = ds.getConnection(); var ps = conn.prepareStatement(sql)) { ... }
```

## Collections & hashing8

### Collection

The family of data structures that store groups of elements — <code>List</code>, <code>Set</code>, <code>Queue</code>, <code>Deque</code> (and <code>Map</code>, which sits beside <code>Collection</code> rather than under it).

- Contrast with a <b>Stream</b>: a collection stores elements, a stream processes them.

### Hash collision

Two different keys hashing to the same bucket. Every hash table needs a strategy for it — separate chaining or open addressing.

### Separate chaining

Each bucket holds a secondary structure (linked list or tree) of all entries that hashed there. Collisions append to that structure.

- This is what Java's <code>HashMap</code> does. Since Java 8, a bucket with more than 8 entries converts from a linked list to a red-black tree, so worst-case lookup is O(log n) instead of O(n).
- Handles high load factors gracefully; costs extra memory per node and loses CPU-cache locality.

### Open addressing

No secondary structure — on collision, probe for the next free slot in the same array.

- Probing strategies: <b>linear</b> (next slot), <b>quadratic</b> (i² away), <b>double hashing</b> (second hash decides the step).
- Faster and more cache-friendly than chaining because everything is one contiguous array, but degrades badly past \~70% load factor and deletion needs tombstones.

### <code>HashMap</code>

Unordered, non-synchronized map. Average O(1) get/put.

- Iteration order is not guaranteed and can change on resize.
- Non-synchronized means high throughput but no thread safety at all — concurrent writes can corrupt it or infinite-loop older versions.

### <code>LinkedHashMap</code>

A <code>HashMap</code> that also keeps a doubly-linked list of entries, so iteration follows <b>insertion order</b>.

- Can be configured for <b>access order</b> instead, which makes it a two-line LRU cache (override <code>removeEldestEntry</code>).

### <code>TreeMap</code>⚠️

A red-black tree map that keeps keys in <b>sorted order</b> (natural ordering or a supplied <code>Comparator</code>). O(log n) operations.

- Implements <code>NavigableMap</code>: <code>firstKey</code>, <code>floorKey</code>, <code>ceilingKey</code>, <code>headMap</code>, <code>tailMap</code>, <code>subMap</code>.
- Keys must be comparable, and it rejects <code>null</code> keys.
- ⚠️ Two fixes to the original note. The class is <b><code>TreeMap</code></b> (written there as "Treetop"), and <code>LinkedHashMap</code> does <b>not sort</b> anything.
- The difference made concrete — add <code>C, A, B</code> to each, then iterate: <b><code>TreeMap</code></b><b> gives A, B, C</b> (it sorted them). <b><code>LinkedHashMap</code></b><b> gives C, A, B</b> (the order you inserted). One sorts, the other remembers.

### <code>TreeMap</code> vs <code>LinkedHashMap</code> — the one-liner

<code>TreeMap</code> = sorted by key, O(log n). <code>LinkedHashMap</code> = in the order you put things in, O(1).

## Streams & functional Java5

### Stream

A pipeline over a sequence of elements supporting functional operations. It processes data pulled from a source; it does not store data.

- <b>Lazy</b> — intermediate ops (<code>filter</code>, <code>map</code>, <code>sorted</code>) build the pipeline and do nothing until a terminal op (<code>collect</code>, <code>reduce</code>, <code>forEach</code>, <code>count</code>) runs.
- <b>Single-use</b> — consume a stream twice and you get <code>IllegalStateException</code>.
- <b>Non-mutating</b> — it never modifies the source collection.

### <code>reduce</code>

A terminal operation that folds all elements of a stream into a single result.

- Three forms: <code>reduce(accumulator)</code> → <code>Optional</code>; <code>reduce(identity, accumulator)</code>; <code>reduce(identity, accumulator, combiner)</code> for parallel streams.
- The accumulator must be <b>associative</b> or parallel results become non-deterministic.

```java
int sum = nums.stream().reduce(0, Integer::sum);
```

### Parallel stream

A stream that splits its work across multiple CPU cores. Java 8+.

- Runs on the common <b>ForkJoinPool</b>, sized to <code>cores − 1</code> by default — so one slow parallel stream can starve every other one in the JVM.
- Worth it only for large datasets with CPU-bound, stateless, side-effect-free operations. Avoid for I/O.
- Splits well over <code>ArrayList</code> and arrays (O(1) random access makes finding the midpoint free). Splits badly over <code>LinkedList</code> (must walk the nodes to find the middle).

### Fork/Join framework

Java 7 framework for splitting a large task into subtasks, running them in parallel across cores, then joining the results. This is what parallel streams run on.

- Signature feature is <b>work stealing</b>: a worker that finishes its own queue steals unfinished tasks from a busy worker's queue instead of idling.
- API: extend <code>RecursiveTask<V></code> (returns a value) or <code>RecursiveAction</code> (void), and split until a sensible threshold.

### <code>Optional</code>

A container that either holds a value or is explicitly empty — a typed alternative to returning <code>null</code>. Java 8.

- Use as a <b>return type</b>. Don't use it for fields or method parameters.
- <code>orElse</code> evaluates its argument eagerly; <code>orElseGet</code> takes a supplier and evaluates lazily.

## Hardware & memory basics8

### CPU (Central Processing Unit)

Executes program instructions — arithmetic, logic, control flow, and I/O operations.

### CPU register

The smallest and fastest storage, physically inside the CPU. Holds the operands the CPU is working on right now.

### CPU cache

Small, fast memory sitting between the registers and RAM. Accessing data from cache is far faster than from RAM.

- Modern CPUs have multiple levels: L1 (smallest/fastest, per core), L2, L3 (largest/slowest, often shared).
- Why it matters for interviews: data structures with good <b>cache locality</b> (arrays, <code>ArrayList</code>) run much faster than pointer-chasing ones (<code>LinkedList</code>) even at the same big-O.

### RAM (Random Access Memory)

Volatile main memory used for temporary storage of data the CPU needs quickly.

### Memory hierarchy — fastest to slowest

CPU registers → CPU cache (L1/L2/L3) → RAM → SSD → spinning hard disk.

- Each step down is roughly an order of magnitude slower and an order of magnitude bigger/cheaper.

### Volatile memory

Memory that loses all its contents when power is cut. RAM is volatile; disk and SSD are not.

- Not the same thing as Java's <code>volatile</code> keyword — the shared word is a coincidence worth calling out if an interviewer conflates them.

### Stack memory vs heap memory⚠️

<b>Stack</b> — one per thread. Holds method frames, local variables, and object <i>references</i>. Automatically freed when the method returns. <code>StackOverflowError</code> when it's exhausted.<br /><b>Heap</b> — shared across all threads. Holds every object and array. Cleaned by the garbage collector. <code>OutOfMemoryError</code> when it's exhausted.

- Static class variables also live on the heap (inside the <code>Class</code> object).
- ⚠️ The original note said stack is "static, done at compile time" and heap "dynamic, at runtime". Both are allocated at <b>runtime</b>. The real distinction: stack frame <i>sizes</i> are known at compile time and freed in strict LIFO order, while heap allocation size and lifetime are decided at runtime.

### Thread caching of shared data

Variables referenced from a thread's stack and from the heap can be cached at every level of the memory hierarchy (register ↔︎ CPU cache ↔︎ RAM).

- The visibility problem this creates: ThreadA on CPU1 reads a shared object and caches a copy in its register while modifying it. ThreadB on CPU2 reads the same object into its own cache. Each thread now has a private copy, and neither sees the other's change until its CPU flushes to main memory.
- That gap is exactly what <code>volatile</code> and <code>synchronized</code> exist to close.

## JVM memory, GC & diagnostics6

### Garbage collection (GC)

The JVM automatically reclaiming memory by finding and disposing of objects no longer reachable from any live thread or static reference.

- Reachability, not reference counting — an island of objects pointing at each other with no external reference is still collected.
- Generational model: young generation (Eden + two survivor spaces) collected often and cheaply; old/tenured generation collected rarely and expensively.

### Memory leak

Objects still present on the heap that the application no longer uses, but which the garbage collector can't remove because something still holds a reference.

- Classic causes: static collections that only ever grow, unclosed resources, listeners never deregistered, <code>ThreadLocal</code> in a pooled thread, custom keys with broken <code>equals</code>/<code>hashCode</code> in a <code>HashMap</code>.

### Heap dump

A snapshot of a Java process's heap at a point in time — every object, its fields, and what references it.

- Used to debug memory leaks and <code>OutOfMemoryError</code>. Capture with <code>jmap</code>, or <code>XX:+HeapDumpOnOutOfMemoryError</code>. Read with Eclipse MAT or VisualVM.

### Thread dump

A snapshot of all threads in a Java process — their names, states, and stack traces.

- Used to diagnose deadlocks, hung requests, and thread-pool starvation. Capture with <code>jstack</code> or <code>kill -3</code>.

### Profiling

Analysing a running program to find performance bottlenecks, memory usage, and other runtime characteristics — CPU time, allocation rate, method execution times.

- Tools: VisualVM, JProfiler, YourKit, Java Flight Recorder / JDK Mission Control, async-profiler.

### PermGen / Metaspace⚠️

<code>OutOfMemoryError: PermGen space</code> meant the JVM ran out of room in the <b>Permanent Generation</b>, which stored class metadata.

- ⚠️ Version: PermGen was <b>removed in Java 8</b> (deprecated in 7), not "after Java 7 it moved". Its replacement is <b>Metaspace</b>.
- Metaspace lives in <b>native memory</b>, not the heap, and grows automatically as needed instead of being fixed at startup — so this error largely disappeared. Cap it with <code>XX:MaxMetaspaceSize</code> if a classloader leak makes it grow forever.

## Concurrency & threading15

### Thread-safe

Multiple threads can read and modify the same object concurrently without data corruption or inconsistent state.

### <code>synchronized</code>

Gives a block or method exclusive access plus a memory-visibility guarantee.

- Mental model: <b>a phone booth with one key</b> — only one person inside, and when they walk out everything they did is announced. (Mutual exclusion + visibility.)
- <b>Method-level</b> locks the whole method on <code>this</code> (or on the <code>Class</code> object for a static method). <b>Block-level</b> locks only the critical section, on an object you choose — narrower and usually faster.

### Intrinsic lock (monitor lock)

Every Java object carries one built-in lock. Entering a <code>synchronized</code> method or block acquires that object's intrinsic lock; leaving releases it.

- It's <b>reentrant</b> — a thread already holding the lock can re-acquire it without deadlocking itself.

### <code>volatile</code>

Marks a variable as read from and written to main memory directly, never cached in a CPU register — so changes are visible across threads immediately.

- Mental model: <b>a live TV broadcast</b> — everyone sees the same thing at the same moment, but anyone can shout over it. Visibility, no mutual exclusion.
- Does <b>not</b> make <code>count++</code> safe — that's read-modify-write, three operations. Use <code>AtomicInteger</code> or <code>synchronized</code> for that.

### Atomic variables

Classes like <code>AtomicInteger</code>, <code>AtomicLong</code>, and <code>AtomicReference</code> that give lock-free thread safety on a single variable using low-level machine instructions.

- Built on <b>compare-and-swap (CAS)</b>, which takes three inputs: the memory location <code>M</code>, the expected existing value <code>A</code>, and the new value <code>B</code>. It atomically sets <code>M</code> to <code>B</code> <b>only if</b> <code>M</code> currently equals <code>A</code>; otherwise it does nothing and returns the actual value found.
- CAS collapses get → compare → update into one machine-level operation, so no lock is needed.
- Under heavy contention CAS retries in a loop and can burn CPU — that's where a lock may win.

### <code>ReentrantLock</code>

An explicit lock class with more capability than <code>synchronized</code>.

- A thread can acquire the same lock repeatedly; a <b>hold count</b> increments per <code>lock()</code> and decrements per <code>unlock()</code>. At zero the lock is released. That's what makes recursive and nested locked calls safe rather than self-deadlocking.
- Extras <code>synchronized</code> can't do: <code>tryLock()</code> with a timeout, <code>lockInterruptibly()</code>, fairness policy, multiple <code>Condition</code> objects.
- Must be released in a <code>finally</code> block — the compiler won't do it for you.

### <code>ReadWriteLock</code>

An interface defining a pair of locks: one for reading, one for writing. <code>ReentrantReadWriteLock</code> is the standard implementation.

- Allows <b>many concurrent readers or one exclusive writer</b>. Big win on read-heavy data.
- Watch out for writer starvation under constant read load; construct it in fair mode if that's a risk.

### Atomics vs locks — comparison

|  | Atomic variables | Locks (e.g. <code>ReentrantLock</code>) |
| --- | --- | --- |
| Thread safety | One variable at a time | Complex operations across multiple variables or whole blocks |
| Performance | Generally faster under low contention | Overhead from context switching and contention |
| Blocking | Non-blocking (CAS retry) | Blocking (thread parks) |

### <code>ConcurrentHashMap</code>⚠️

A thread-safe <code>HashMap</code> where <code>put</code> and <code>get</code> are safe without external synchronization.

- Readers never block each other; a writer locks only the single bin it's touching.
- ⚠️ The original note said writers "lock a tiny segment". Segment locking was <b>Java 7</b>. Since Java 8 it's per-bin locking on the first node plus CAS — finer-grained than segments. Say "per-bucket" in an interview.
- Compound operations still need care — use <code>putIfAbsent</code>, <code>computeIfAbsent</code>, <code>merge</code> instead of check-then-act.
- Trade-off vs <code>HashMap</code>: a plain <code>HashMap</code> is non-synchronized so any number of threads run without waiting, giving higher raw throughput. <code>ConcurrentHashMap</code> is sometimes slower because threads occasionally have to wait — you're paying for correctness.

### <code>ConcurrentLinkedQueue</code>

A thread-safe, non-blocking FIFO queue. Multiple threads can insert, remove, and peek concurrently without blocking.

- Unbounded — grows dynamically with no fixed size limit, so an unchecked producer can exhaust memory.
- <code>size()</code> is O(n) and only approximate under concurrent modification.

### <code>CopyOnWriteArrayList</code>⚠️

A thread-safe <code>ArrayList</code> where every mutating operation (<code>add</code>, <code>set</code>, <code>remove</code>) creates a <b>fresh copy of the entire backing array</b>.

- Reads are completely lock-free and iterators never throw <code>ConcurrentModificationException</code> — they see a snapshot.
- Only sensible when reads massively outnumber writes (listener lists, config), because each write is O(n).
- ⚠️ The original note stopped at "all mutative operations are implemented" — the ending is what matters: <i>by copying the whole array</i>. That's the entire trade-off.

### <code>CompletableFuture</code>

Java 8 class representing the future result of an asynchronous computation, with a fluent API for composing them.

- <b>Non-blocking</b> — attach callbacks (<code>thenApply</code>, <code>thenAccept</code>, <code>thenCompose</code>) that fire on completion instead of blocking on <code>get()</code>.
- <b>Composition</b> — <code>thenCombine</code> (join two), <code>allOf</code> (wait for all), <code>anyOf</code> (first to finish wins).
- <b>Exception handling</b> — <code>exceptionally</code>, <code>handle</code>, <code>whenComplete</code>.
- Supports sync and async execution; pass your own <code>Executor</code> rather than relying on the common ForkJoinPool.

### Virtual threads (Java 21+)

Lightweight threads scheduled by the JVM rather than mapped one-to-one to OS threads.

- Contrast: a <b>platform thread</b> is a thin wrapper over an OS thread — expensive, \~1 MB stack, so you pool them. A virtual thread costs a few hundred bytes, so you can run millions and never pool.
- Designed for <b>I/O-bound</b> work: when a virtual thread blocks, the JVM unmounts it from its carrier thread instead of parking the OS thread. No gain for CPU-bound work.
- <code>synchronized</code> blocks could pin a virtual thread to its carrier in Java 21; prefer <code>ReentrantLock</code> in hot paths.

### Thread pool

A managed set of reusable worker threads. Incoming work is handed to an available thread instead of creating a new thread per task.

- Web servers use one to handle many concurrent requests without paying thread-creation cost each time.
- Key knobs: core size, max size, queue type, rejection policy.

### Servlet container

The runtime (Tomcat, Jetty, Undertow) that hosts a Java web application and owns request concurrency — it manages the thread pool and makes sure requests are processed concurrently.

- In Spring MVC, the container hands each request to a thread which runs through <code>DispatcherServlet</code> to your controller.

## JDK, JRE & Java versions7

### JDK (Java Development Kit)

The software development kit for building Java applications — compiler (<code>javac</code>), debugger, <code>jar</code>, <code>javadoc</code>, plus the JRE.

- What developers install to write, compile, debug, and package.

### JRE (Java Runtime Environment)

The runtime needed to <i>run</i> Java applications — the JVM plus the core class libraries. No compiler, no debugger.

- What end users needed to execute bytecode. Since Java 11 Oracle stopped shipping a standalone JRE; you ship a trimmed runtime with <code>jlink</code> instead.

### Java 8 (2014, LTS)

- <b>Lambda expressions</b> — <code>x -> x * 2</code>
- <b>Stream API</b> — functional collection processing (<code>filter</code>, <code>map</code>, <code>reduce</code>)
- <b><code>Optional</code></b> — null-safe container
- Also: <code>default</code> and <code>static</code> methods on interfaces, new date/time API (<code>java.time</code>), <code>CompletableFuture</code>, PermGen removed in favour of Metaspace.

### Java 9 (2017)

- <b>Module system (Jigsaw)</b> — <code>module-info.java</code>, strong encapsulation. The JDK itself became modules (<code>java.base</code>, <code>java.sql</code>, <code>java.net.http</code>).
- <b>Immutable collection factories</b> — <code>List.of()</code>, <code>Set.of()</code>, <code>Map.of()</code>
- <b>Private methods in interfaces</b>
- Also: JShell, reactive <code>Flow</code> API.

### Java 11 (2018, LTS)

- <code>var</code> for local variables (added in 10), the standard <code>HttpClient</code>, <code>String</code> helpers (<code>isBlank</code>, <code>lines</code>, <code>strip</code>), single-file source execution.

### Java 17 (2021, LTS)

- <b>Sealed classes</b> — <code>permits</code> restricts subclassing
- <b>Pattern matching for </b><b><code>instanceof</code></b> — <code>if (obj instanceof String s)</code>
- <b>Records</b> — <code>record Point(int x, int y) {}</code>
- Also: enhanced <code>switch</code> expressions, text blocks (<code>"""</code>), helpful <code>NullPointerException</code> messages, the new <code>java.util.Random</code> interfaces.
- This is the version Spring Boot 3 requires as a minimum.

### Java 21 (2023, LTS)

- <b>Virtual threads</b>, pattern matching for <code>switch</code>, record patterns, sequenced collections.

## HTTP & REST8

### Status codes worth memorizing

- <b>200 OK</b> — the request succeeded.
- <b>201 Created</b> — succeeded and a new resource was created (return its URI in the <code>Location</code> header).
- <b>204 No Content</b> — succeeded, and the server is deliberately returning no body.
- <b>400 Bad Request</b> — the server couldn't understand the request; invalid syntax or failed validation.
- <b>401 Unauthorized</b> — the client must authenticate itself to get a response. (Really means <i>unauthenticated</i>.)
- <b>403 Forbidden</b> — the client is authenticated but has no access rights to this content.
- <b>404 Not Found</b> — the server can't find the requested resource.
- <b>405 Method Not Allowed</b> — the resource exists but doesn't support this HTTP verb. The response must include an <code>Allow</code> header listing what it does support.
- Useful extras: <b>409 Conflict</b> (state clash, e.g. duplicate), <b>422 Unprocessable Entity</b> (syntactically fine, semantically invalid), <b>429 Too Many Requests</b>, <b>500 Internal Server Error</b>, <b>503 Service Unavailable</b>.

### HTTP headers

Key-value pairs sent alongside a request or response carrying metadata.

- Common ones: <code>Content-Type</code> (media type of the body), <code>Accept</code> (what the client wants back), <code>Authorization</code> (credentials/token), <code>Cache-Control</code>, <code>ETag</code>.

### <code>OPTIONS</code> method

Asks the server what it supports rather than acting on a resource.

- Two typical uses: discovering which HTTP methods a resource allows, and carrying the <b>CORS preflight</b> check.

### CORS (Cross-Origin Resource Sharing)

A browser security feature that blocks a web page from making requests to a different origin than the one that served it, unless the target server opts in.

- Origin = scheme + host + port. All three must match or it's cross-origin.
- The server opts in with <code>Access-Control-Allow-Origin</code>, <code>Allow-Methods</code>, <code>Allow-Headers</code>, <code>Allow-Credentials</code>.
- Enforced by the <b>browser</b>, not the server — <code>curl</code> and Postman ignore it entirely, which is why "it works in Postman but not the browser" is a CORS symptom.

### Preflight request

For requests that aren't "simple" — <code>PUT</code>, <code>DELETE</code>, <code>PATCH</code>, most <code>POST</code> bodies, or any custom header — the browser first sends an <code>OPTIONS</code> request to check permission, then sends the real request only if the server approves.

- Cache the answer with <code>Access-Control-Max-Age</code> to avoid doubling every call.

### Idempotent request

Calling it multiple times with the same data leaves the server in the same state as calling it once.

- <b>Idempotent:</b> <code>GET</code>, <code>HEAD</code>, <code>PUT</code>, <code>DELETE</code>, <code>OPTIONS</code>.
- <b>Not idempotent:</b> <code>POST</code>, <code>PATCH</code>.
- Note the difference from <i>safe</i>: <code>GET</code> is safe (no state change at all), <code>PUT</code> is idempotent but not safe.

### HATEOAS

Hypermedia As The Engine Of Application State — embedding links and available actions inside the resource representation so the client discovers what it can do next instead of hardcoding URLs.

```json
{ "id": 7, "status": "PENDING",
  "_links": { "self": {"href": "/orders/7"}, "cancel": {"href": "/orders/7/cancel"} } }
```

### MVC (Model–View–Controller)

An architectural pattern for handling web requests: the <b>model</b> holds data, the <b>view</b> renders it, the <b>controller</b> takes the request and coordinates the two.

- In a REST API the "view" is JSON rather than an HTML page. Spring MVC + Jackson gives you: Java object → Jackson → JSON response.

## Spring core — IoC & dependency injection6

### IoC (Inversion of Control)

A design principle where control of object creation and dependency management is inverted from your application code to a container or framework.

- You stop writing <code>new</code>; the container decides what to build, when, and with what.
- In Spring, IoC is achieved through <b>dependency injection</b>.

### DI (Dependency Injection)

The specific pattern inside IoC where a component's dependencies are handed to it rather than the component creating or looking them up itself.

- Three flavours: constructor, setter, field.

### Constructor injection

Dependencies are passed through the constructor. <b>The recommended default.</b>

- The object is always in a valid, fully-initialized state — it cannot exist without its dependencies.
- Dependencies are obvious from the constructor signature.
- Supports <code>final</code> fields, so the object is immutable.
- <code>@Autowired</code> is optional on a single constructor since Spring 4.3.

### Field injection

Spring sets the field directly by reflection (<code>@Autowired</code> on the field).

- The object <i>can</i> exist without the dependency — it's <code>null</code> until Spring injects it.
- Downsides: <b>hidden dependencies</b> (the constructor tells you nothing about what the class needs), risk of <code>NullPointerException</code> if the object is created with <code>new</code> in a test, and no immutability because fields can't be <code>final</code>.

### Setter injection

Spring calls a setter after construction.

- The object can exist without the dependency until the setter is called.
- Right choice when the dependency is genuinely <b>optional or reconfigurable</b> after creation — "nice to have, but the object still works without it."

### <code>@Autowired</code>

Tells Spring to resolve and inject a matching bean automatically.

- Matches <b>by type</b> first; if several candidates match, disambiguate with <code>@Qualifier("beanName")</code> or <code>@Primary</code>.
- <code>@Autowired(required = false)</code> makes it optional.

## Spring core — container & beans5

### Spring container

The mechanism responsible for creating beans, managing their lifecycle, injecting dependencies, and honouring bean scopes. The engine behind Spring's DI.

### <code>BeanFactory</code>

The base container interface. Instantiates, configures, and assembles beans, lazily by default.

### <code>ApplicationContext</code>

An extension of <code>BeanFactory</code> — everything <code>BeanFactory</code> does plus event publishing, internationalization, resource loading, and AOP integration.

- "Spring container vs <code>ApplicationContext</code>": the container <i>is</i> an <code>ApplicationContext</code> in practice. <code>ApplicationContext</code> is the interface you actually work with; <code>BeanFactory</code> is the bare-bones ancestor.
- <code>SpringApplication.run()</code> creates an <code>ApplicationContext</code> for you.

### Bean lifecycle

1. <b>Instantiation</b> — container constructs the bean.
2. <b>Populate properties</b> — dependencies injected.
3. <b>Initialization callbacks</b> — <code>@PostConstruct</code>, then <code>InitializingBean.afterPropertiesSet()</code>, then a custom <code>initMethod</code>.
4. <b>Bean ready to use.</b>
5. <b>Destruction</b> — <code>@PreDestroy</code>, then <code>DisposableBean.destroy()</code>, then a custom <code>destroyMethod</code>.

- Only singleton beans get destruction callbacks; Spring doesn't track prototypes after handing them over.

### Bean scopes

- <b>singleton</b> (default) — one instance created and shared across the entire application context.
- <b>prototype</b> — a new instance every time the bean is requested.
- <b>request</b> — one instance per HTTP request (web-aware contexts only).
- <b>session</b> — one instance per HTTP session (web-aware contexts only).
- <b>application</b> — one per <code>ServletContext</code>.
- <b>websocket</b> — one per WebSocket session.
- Classic trap: injecting a prototype into a singleton gives you one instance forever. Use <code>ObjectProvider</code> or a scoped proxy.

## Spring core — stereotype annotations13

### <code>@Component</code>

Declares a class as a Spring bean. The generic stereotype.

- Makes the class a Spring bean, lets component scanning discover it, and enables dependency injection into it.

### <code>@Service</code>

<code>@Component</code> + the semantic statement "this class contains business logic." Marks the business layer.

- Functionally identical to <code>@Component</code> today; the value is architecture and readability (and it gives AOP pointcuts something to target).

### <code>@Repository</code>

<code>@Component</code> + "this represents the data access layer" + one real behaviour: <b>automatic persistence exception translation</b>.

- Spring catches database-specific exceptions (<code>SQLException</code>, <code>PostgreSQLException</code>, Hibernate exceptions) and converts them into its consistent <code>DataAccessException</code> hierarchy.
- Result: your service layer doesn't need to know which database or persistence technology you're using.

### <code>@Controller</code>

Handles web requests and integrates with Spring MVC request handling.

- The return value is treated as a <b>view name</b> by default, unless you add <code>@ResponseBody</code> to the method.

### <code>@RestController</code>

<code>@Controller</code> + <code>@ResponseBody</code> applied to every method. The REST API controller.

### <code>@ResponseBody</code>

Tells Spring: don't look for a view, take the method's return value and write it straight into the HTTP response body.

- Conversion is done by an <code>HttpMessageConverter</code> — normally Jackson, producing JSON.

### <code>@ControllerAdvice</code> / <code>@RestControllerAdvice</code>⚠️

A class that applies cross-cutting behaviour to many controllers at once — most commonly global exception handling via <code>@ExceptionHandler</code> methods.

- Also hosts <code>@ModelAttribute</code> and <code>@InitBinder</code> methods shared across controllers.
- Can be scoped to specific packages, annotations, or controller types.
- ⚠️ Naming: the original note called it "Advice Controller". The annotation is <code>@ControllerAdvice</code> (or <code>@RestControllerAdvice</code>, which adds <code>@ResponseBody</code>).

### <code>@Configuration</code>

Marks a class as a source of bean definitions and configuration metadata rather than a regular Java class. Its <code>@Bean</code> methods produce container-managed beans.

### <code>@Bean</code>

Method-level annotation inside a <code>@Configuration</code> class; the method's return value is registered as a bean. Used when you can't annotate the class itself — third-party types, or construction that needs logic.

### <code>@Value</code>

Injects a property value (or a SpEL expression result) into a field or parameter.

- <code>@Value("${app.timeout:30}")</code> — the part after <code>:</code> is the default.

### <code>@Profile</code>

Conditionally includes or excludes a bean or configuration class based on which profile is active.

- Activate with <code>spring.profiles.active=dev</code>.

### <code>@Conditional</code>

Conditionally includes or excludes a configuration class or bean based on a programmatic condition.

- Spring Boot's variants are what make auto-configuration work: <code>@ConditionalOnClass</code>, <code>@ConditionalOnMissingBean</code>, <code>@ConditionalOnProperty</code>.

### SpEL (Spring Expression Language)

An expression language for querying and manipulating an object graph at runtime.

- Used inside <code>@Value</code>, <code>@PreAuthorize</code>, <code>@Query</code>, and projection annotations.

```java
@Value("#{beanName.property1 > 5 ? 'High' : 'Low'}")
private String level;
```

## Spring core — AOP & transactions5

### Proxy-based AOP

Spring wraps the target bean in a proxy object at runtime. When a method is called, the proxy intercepts, applies the aspect, then delegates to the real bean.

- Uses JDK dynamic proxies when the bean implements an interface, CGLIB subclassing otherwise.
- <b>Limitation that shows up constantly:</b> self-invocation bypasses the proxy. A method calling another <code>@Transactional</code> or <code>@Cacheable</code> method on <code>this</code> gets no advice at all.
- Also can't advise <code>private</code>, <code>static</code>, or <code>final</code> methods.

### AspectJ-based AOP

Weaves aspects directly into the compiled bytecode — at compile time, load time, or runtime — so aspects become part of the class and no proxy object exists.

- More flexible and powerful: works on classes that implement no interface, and can target specific methods, constructors, <b>and fields</b> with rich pointcut expressions.
- The core difference in one line: <b>AspectJ modifies your class's actual bytecode (weaving); proxy-based AOP wraps your class in a runtime wrapper to intercept calls.</b>

### Declarative transaction management

Transactional behaviour specified through configuration metadata — annotations (<code>@Transactional</code>) or XML — instead of hand-written begin/commit/rollback code.

- <b>How it works:</b> Spring creates a <b>proxy</b> around the bean, AOP <b>advice</b> intercepts the method call, and a <b>transaction manager</b> coordinates begin/commit/rollback against the data source.
- <b>Transaction attributes</b> define behaviour: propagation, isolation level, rollback rules, timeout, read-only.
- Default rollback rule: rolls back on unchecked exceptions and <code>Error</code>, <b>commits</b> on checked exceptions unless you set <code>rollbackFor</code>.

### Propagation behaviour

How a method should participate in a transaction when it's called by another method that already has one.

- <code>REQUIRED</code> (default) — join the existing transaction, or start one.
- <code>REQUIRES_NEW</code> — always suspend the caller's transaction and start a fresh independent one.
- <code>SUPPORTS</code> — join if there is one, run non-transactionally if not.
- <code>MANDATORY</code> — must have a caller transaction, else throw.
- <code>NOT_SUPPORTED</code> — suspend any transaction and run without one.
- <code>NEVER</code> — throw if a transaction exists.
- <code>NESTED</code> — a savepoint inside the caller's transaction.

### Transaction manager

The component that coordinates transactions with the underlying data source — responsible for beginning, committing, and rolling back.

- <code>JpaTransactionManager</code> for JPA/Hibernate, <code>DataSourceTransactionManager</code> for plain JDBC.

## Spring web — request pipeline4

### <code>DispatcherServlet</code>

Essentially any Spring web application is one servlet: the front controller that receives every incoming HTTP request and routes it to the right <code>@Controller</code> or <code>@RestController</code> method.

### Servlet filter

Sits in front of <code>DispatcherServlet</code> and can inspect or modify requests and responses before they reach any controller, and after they leave.

- Uses: authentication, logging, compression, CORS, request/response wrapping.
- You must call <code>chain.doFilter(request, response)</code> to pass the request along — forget it and the request dies silently.
- Operates on raw <code>ServletRequest</code>/<code>ServletResponse</code>; knows nothing about controllers or handler methods.

### Interceptor

Intercepts requests <i>inside</i> Spring MVC — after <code>DispatcherServlet</code> picks a handler but before the controller runs, then after the controller returns but before the view renders.

- Implement <code>HandlerInterceptor</code> and override <code>preHandle</code>, <code>postHandle</code>, <code>afterCompletion</code>.
- Unlike a filter, it knows which handler method was matched, so it can read method annotations.

### Filter vs interceptor — the one-liner

Filter = servlet-level, outside Spring, sees raw request/response. Interceptor = Spring MVC-level, inside the dispatcher, knows the handler method.

## Spring Boot8

### Spring vs Spring Boot — deployment

- <b>Spring Framework:</b> you build a WAR and deploy it manually to an external servlet container (Tomcat, Jetty, Undertow).
- <b>Spring Boot:</b> ships an <b>embedded</b> server, so you package a single executable JAR that runs itself.

### Spring vs Spring Boot — configuration

With plain Spring you configure most things by hand: create an <code>ApplicationContext</code>, define beans, wire a datasource, wire a transaction manager, set up test properties.<br />Spring Boot already knows how to configure most of that.

- Boot adds: <b>auto-configuration</b>, <b>starter dependencies</b>, built-in testing support with almost no config, and <b>Spring Boot Actuator</b> for monitoring and management out of the box.

### <code>@SpringBootApplication</code>

Combines three annotations: <code>@Configuration</code>, <code>@EnableAutoConfiguration</code>, and <code>@ComponentScan</code>.

- Component scanning starts from this class's package and works downward — which is why it belongs in the root package.

### <code>@EnableAutoConfiguration</code>

Configures the application based on the dependencies on the classpath — Spring Boot creates and configures beans for you based on which libraries are present.

- Backed by <code>@Conditional</code> checks. See what it decided with <code>-debug</code> or the Actuator <code>conditions</code> endpoint.

### Starter dependency

A curated dependency bundle that pulls in a coherent set of libraries plus the auto-configuration for them, at versions known to work together.

- <code>spring-boot-starter-web</code> gives you Spring MVC, Jackson, validation, and embedded Tomcat.

### Spring Web (what the starter gives you automatically)

- Starts an embedded Tomcat server.
- Configures Spring MVC.
- Sets up Jackson for JSON.

### <code>application.properties</code> / <code>application.yml</code>

Where you define Spring-specific configuration properties — datasource URL, port, logging levels, custom app properties.

- Profile-specific variants (<code>application-dev.yml</code>) override the base file.
- Precedence, highest first: command-line args → environment variables → profile-specific file → base file → defaults.

### Spring Boot Actuator

Production-ready monitoring and management endpoints out of the box — <code>/health</code>, <code>/metrics</code>, <code>/info</code>, <code>/env</code>, <code>/loggers</code>, <code>/conditions</code>.

- Expose deliberately; several endpoints leak configuration if left open.

## JPA, Hibernate & Spring Data23

### JPA (Java Persistence API)

A <b>specification</b> for accessing, persisting, and managing data between Java objects and relational databases. It defines a set of interfaces and annotations, not an implementation.

- Renamed <b>Jakarta Persistence</b> from version 3; the package moved <code>javax.persistence</code> → <code>jakarta.persistence</code>. That rename is the single biggest mechanical change in a Spring Boot 2 → 3 migration.

### Hibernate

A specific <b>implementation</b> of the JPA specification, plus extra features beyond the standard.

- ORM (Object-Relational Mapping): you write Java classes that represent database tables, and Hibernate maps them to the corresponding tables automatically.
- Beyond-spec extras: second-level cache, <code>@Formula</code>, filters, its own criteria API.

### Spring Data JPA

A repository abstraction layered on top of the JPA specification, using a JPA provider (normally Hibernate) underneath.

- Generates query implementations from method names (<code>findByLastNameAndActiveTrue</code>), gives you paging, sorting, and <code>@Query</code> for custom JPQL/native SQL.
- The stack, top to bottom: <b>Spring Data JPA → JPA (spec) → Hibernate (provider) → JDBC → database.</b>

### JPQL (Java Persistence Query Language)

A query language for querying <b>entities</b> rather than tables directly. Similar to SQL but operates on entity objects and their fields.

```java
List<User> users = entityManager
    .createQuery("SELECT u FROM User u", User.class)
    .getResultList();
```

- Case-sensitive on entity and field names, case-insensitive on keywords. No <code>SELECT *</code>.

### <code>@EnableJpaRepositories</code>

Registers Spring Data JPA repositories and links them to a specific JPA context (an <code>EntityManagerFactory</code> + a <code>TransactionManager</code>).

- <code>basePackages</code> — where Spring scans for repository interfaces.
- <code>entityManagerFactoryRef</code> — which <code>EntityManagerFactory</code> those repositories use.
- <code>transactionManagerRef</code> — which transaction manager to use.
- You only need this explicitly for <b>multiple datasources</b>; Boot configures a single one for you.

### Entity relationships — the annotations

```java
// Many-to-one: this side owns the FK column
@ManyToOne
@JoinColumn(name = "user_id")
private User user;

// One-to-many: inverse side, no FK column of its own
@OneToMany(mappedBy = "user")
private List<Order> orders;

// Many-to-many: a join table
@ManyToMany
@JoinTable(
    name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
)
private Set<Role> roles;
```

### <code>@JoinColumn</code> — the owning side

The side carrying <code>@JoinColumn</code> is the <b>owning side</b>; it holds the foreign key column.

- Read it as: "my table has a <code>user_id</code> column pointing at the <code>id</code> of the <code>User</code> table."
- Only the owning side's changes are written to the database.

### <code>mappedBy</code> — the inverse side

<code>@OneToMany(mappedBy = "user")</code> says: "I am <b>not</b> the owner. Look at the field named <code>user</code> in the other entity to find the mapping."

- Forget <code>mappedBy</code> on a bidirectional relationship and Hibernate creates a redundant join table.

### <code>@JoinTable</code> — many-to-many

Creates a third table (<code>user_role</code>) holding two foreign keys: <code>joinColumns</code> points back at <i>this</i> entity (<code>user_id</code>), <code>inverseJoinColumns</code> points at the other side (<code>role_id</code>).

- Use <code>Set</code> not <code>List</code> for <code>@ManyToMany</code> — <code>List</code> causes Hibernate to delete and re-insert every row on any change.

### Eager fetching

Associated entities are loaded immediately, in the same query as the primary entity.

- Safe from lazy-loading exceptions, but can pull in far more data than you asked for.

### Lazy fetching

Associated entities are loaded on demand, when you first touch the association.

- Needs an open session/transaction, or you get <code>LazyInitializationException</code>.
- Implemented with a proxy, which is why lazy fields can't be <code>final</code>.

### JPA default fetch types

- <code>@OneToMany</code> and <code>@ManyToMany</code> default to <b><code>FetchType.LAZY</code></b>.
- <code>@OneToOne</code> and <code>@ManyToOne</code> default to <b><code>FetchType.EAGER</code></b>.
- Practical advice: set the <code>ToOne</code> sides to <code>LAZY</code> explicitly and fetch what you need with <code>JOIN FETCH</code>.

### N+1 problem

Lazy loading fires <b>one</b> query to fetch the main entities plus <b>N</b> additional queries to fetch each one's related entity. For N entities that's N+1 queries — hence the name.

- Concrete case: <code>Post</code> → <code>Comment</code> is one-to-many. You ask for a list of posts and their comments. Hibernate runs 1 query for the posts, then N queries — one per post — for its comments.
- Fixes: <code>JOIN FETCH</code> in JPQL, <code>@EntityGraph</code> on the repository method, <code>@BatchSize</code> to batch the child queries, or a projection/DTO query that fetches only the columns you need.
- Detect it by logging SQL (<code>spring.jpa.show-sql</code>) or with a query counter in tests.

### Caching (general)

Storing frequently accessed data in memory so it can be retrieved quickly without going back to the database each time.

- Improves performance and cuts latency by holding entities in memory.

### First-level cache (session cache)

Hibernate's built-in, always-on cache scoped to a single <code>Session</code>/<code>EntityManager</code>. Every entity fetched is stored there; ask for the same entity again in the same session and Hibernate returns the cached copy instead of hitting the database.

- Managed automatically — nothing to configure, and you cannot turn it off.
- Accessed through the <code>EntityManager</code>.
- Cleared automatically when the session closes, and <b>never shared between sessions</b>.
- Also gives you identity guarantees: the same entity fetched twice in one session is the same Java object.

### Second-level cache

An optional Hibernate cache that stores data <b>across</b> sessions, shared by the whole <code>SessionFactory</code>.

- Enable it per entity with <code>@Cacheable</code>, and set the concurrency strategy with Hibernate's <code>@Cache</code>.
- Needs a provider on the classpath: EhCache, Infinispan, Hazelcast, Caffeine.
- When an entity is updated, Hibernate invalidates its cache entry; the next access refetches from the database and re-caches.

### <code>@Cacheable</code> — two different annotations⚠️

Two unrelated annotations share this name. Mixing them up is a classic interview trap.

- <b><code>jakarta.persistence.@Cacheable</code></b> — goes on an <b>entity class</b>. Turns on Hibernate's <b>second-level cache</b> for that entity, so the entity survives across sessions.
- <b><code>org.springframework.cache.annotation.@Cacheable</code></b> — goes on a <b>method</b>. Caches that method's return value keyed on its arguments, in a Spring cache (Caffeine, Redis, etc.).
- Different layer, different target, different cache. Rule of thumb: <b>entity → JPA's. Method → Spring's.</b>

```java
@Entity @Cacheable                       // JPA — cache this entity (2nd-level cache)
class Product { ... }

@Cacheable("prices")                     // Spring — cache what this method returns
BigDecimal priceFor(Long productId) { ... }
```

### Second-level cache concurrency strategies

Hibernate supports three cache modes for second-level caching.

- <b>read-only</b> — for data that is not expected to change frequently. Fastest, no locking.
- <b>read-write</b> — for data that is frequently updated. Uses soft locks to keep the cache consistent.
- <b>transactional</b> — for data updated inside a transaction; the cache participates in that transaction.

### Query cache

Caches the <b>result sets of queries</b>. On execution Hibernate checks whether that query's results are already cached; if so it returns them without hitting the database, otherwise it runs the query and caches the result for next time.

- Requires the second-level cache to be enabled — the query cache stores entity <b>IDs</b>, then resolves them through the second-level cache.
- Easy to make things slower: any write to a queried table invalidates the whole query region.

### Projection

A way to query and retrieve specific columns or fields rather than whole entities. Reduces the data loaded into memory.

- Declaring a repository method with a projection interface looks exactly like declaring one with an entity class — the only difference is that the projection interface, not the entity, is the element type of the returned collection.
- Behind the scenes Spring creates a <b>proxy instance</b> of the projection interface per entity object, and forwards every call on the proxy to that object.

```java
interface PersonView { String getFirstName(); String getLastName(); }
List<PersonView> findByActiveTrue();
```

### Open projection

A projection that defines interface methods with names that don't match any entity field, computing the value at runtime with SpEL.

```java
public interface PersonView {
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
```

- Trade-off: open projections force Spring to load the <b>whole entity</b> to evaluate the expression, so you lose the performance benefit of a closed projection.

### Class-based projection (DTO projection)

Instead of a proxy generated from an interface, you supply your own class and Spring populates it via its constructor.

- No proxies, and works well with <code>SELECT new com.x.PersonDto(p.firstName, p.lastName) FROM Person p</code>.
- Records make excellent projection classes.

### <code>@Formula</code>⚠️

Defines a computed, <b>read-only</b> property on an entity using a raw SQL expression evaluated by the database.

```java
@Formula("datediff(curdate(), birth_date) / 365")
private int age;
```

- ⚠️ The original note had <code>lower(datediff(curdate(), birth_date / 365)</code> — unbalanced parentheses, the division inside the wrong argument, and a <code>lower()</code> wrapped around a number. Corrected version above.
- Downsides: it's vendor-specific SQL inside your entity, and it's added to <b>every</b> select for that entity.

## Entity inheritance strategies6

### Polymorphic query

A query written against a base class that can return instances of <b>any</b> subclass in the hierarchy.

- Whether you get this at all depends on which inheritance strategy you pick.

### Mapped superclass

The simplest strategy. Each concrete class maps to <b>its own table</b>, and the parent only shares state and mapping information.

- <code>@MappedSuperclass</code> — the parent is <b>not an entity</b> and has no table of its own.
- Therefore: <b>no polymorphic queries</b> (you can't <code>SELECT p FROM Publication p</code>) and no associations to the superclass.
- Right choice when you only want to share fields and mappings between otherwise unrelated entities — e.g. a base class with <code>id</code>, <code>createdAt</code>, <code>updatedAt</code>.

### Table per class

Each entity gets its own table containing a column for <b>every</b> attribute, including the inherited ones. The superclass <b>is</b> an entity.

- Gains over mapped superclass: polymorphic queries work, and you can define associations to the superclass — so <code>Author.getPublications()</code> can return books and blog posts together.
- Querying one specific subclass is easy and efficient — one table, no joins.
- The cost: polymorphic queries are ugly. Books and blog posts live in separate tables, so Hibernate joins <code>author</code> against a <b>subselect that UNIONs</b> every subclass table. Add more subclasses and it gets worse. This can become a real performance problem — the queries generated for polymorphic queries here are very complex.

### Single table

All entities in the hierarchy map to <b>one</b> database table. The default strategy.

- Best performance and the most efficient polymorphic queries — no joins at all, Hibernate just adds a comparison on the discriminator value.
- The cost: every entity's attributes share one table, so each row uses only a subset of columns and leaves the rest <code>null</code>. You therefore <b>cannot put </b><b><code>NOT NULL</code></b><b> constraints</b> on any column that isn't mapped by every entity. That's a data-integrity hole, and your DBA won't love it.
- Needs a <b>discriminator column</b> so Hibernate knows which entity class each row represents. It isn't an entity attribute. Name it with <code>@DiscriminatorColumn</code> on the superclass, or Hibernate uses <code>DTYPE</code> as the default name.
- The only thing Hibernate adds to the SQL to fetch one particular entity class is a comparison of the discriminator value — no joins at all.

### Joined table

Each class in the hierarchy gets its own table, but a subclass's data is <b>spread across multiple tables</b>.

- The abstract superclass gets a table with the shared columns. Each subclass table holds only its own specific columns and shares the primary key with the matching row in the superclass table.
- Gain: no wasted <code>null</code> columns, so you <b>can</b> use subclass-specific constraints — e.g. <code>NOT NULL</code> on <code>blogpost.url</code>. Best data integrity of the four.
- Cost: every query on a subclass needs a <b>join</b> to the superclass table. Hibernate joins <code>publication</code> and <code>book</code> on their primary keys to select all of a <code>Book</code>'s attributes. That overhead makes these queries slightly slower than single-table.

### Choosing between them — quick rule

Data integrity matters most → <b>joined</b>. Read performance matters most → <b>single table</b>. No polymorphism needed, just shared fields → <b>mapped superclass</b>. Avoid <b>table per class</b> unless polymorphic queries are rare.

## Spring Security8

### Spring Security

A Spring project providing authentication and authorization for Spring applications. Dependency: <code>spring-boot-starter-security</code>.

- Under the hood it's really just <b>a chain of servlet filters</b> that add authentication and authorization to your web app.
- Covers: authentication, authorization, password hashing (BCrypt), JWT, OAuth2 / OpenID Connect, CSRF protection, CORS support, session management.

### Authentication

Verifying the identity of a user or system — <b>who are you?</b>

- Common methods: username/password, OAuth2, JWT.

### Authorization

Granting or denying access to resources based on the authenticated identity's permissions or roles — <b>what can you do?</b>

### RBAC (Role-Based Access Control)

Access control defined by user roles and the permissions attached to them, rather than per-user rules.

- Spring convention: an <i>authority</i> is any string; a <i>role</i> is an authority prefixed <code>ROLE_</code>. <code>hasRole("ADMIN")</code> and <code>hasAuthority("ROLE_ADMIN")</code> mean the same thing.

### Token-based authentication

Using a token (typically JWT) to carry proof of authentication with each request, rather than a server-side session. Essential for stateless APIs.

### Security filter chain⚠️

Spring Security installs a default chain of roughly 15 filters handling different parts of authentication and authorization.

- <b>Spring Security 5.x and earlier:</b> configure by extending <code>WebSecurityConfigurerAdapter</code>.
- <b>Spring Security 6 / Spring Boot 3:</b> <code>WebSecurityConfigurerAdapter</code> is <b>removed</b>. Use <code>@EnableWebSecurity</code> on a <code>@Configuration</code> class and expose a <code>SecurityFilterChain</code> bean. This is a mandatory migration step.
- ⚠️ Also renamed in Spring Security 6: <code>antMatchers()</code> → <code>requestMatchers()</code>, and <code>authorizeRequests()</code> → <code>authorizeHttpRequests()</code>.

### <code>antMatchers</code> / <code>requestMatchers</code>

Configures which URL patterns a security rule applies to and what access they require.

```java
// Spring Security 5
http.authorizeRequests()
    .antMatchers("/public/**").permitAll()
    .antMatchers("/admin").hasAuthority("ROLE_ADMIN");

// Spring Security 6
http.authorizeHttpRequests(a -> a
    .requestMatchers("/public/**").permitAll()
    .requestMatchers("/admin").hasRole("ADMIN"));
```

- Order matters — the first matching rule wins, so put specific patterns before broad ones.

### The three authentication scenarios

1. <b>The default</b> — Spring Security can read the user's hashed password because user details live somewhere it can reach, e.g. a database table.
2. <b>Less common</b> — you cannot access the hashed password because users and passwords live in a third-party identity management product exposing REST services for authentication (e.g. Atlassian Crowd).
3. <b>Also popular</b> — OAuth2 or "Login with Google/Twitter" (OpenID Connect), often combined with JWT.

## JWT, OAuth2 & OIDC6

### JWT (JSON Web Token)

A compact, self-contained way to securely transmit information between parties as a JSON object. Three dot-separated parts.

- <b>Header</b> — the token type (<code>JWT</code>) and the signing algorithm (<code>HS256</code>, <code>RS256</code>).
- <b>Payload</b> — the claims: statements about an entity (usually the user) plus any additional data. Standard claims: <code>sub</code>, <code>iss</code>, <code>aud</code>, <code>exp</code>, <code>iat</code>.
- <b>Signature</b> — created by taking the encoded header, the encoded payload, a secret, and the algorithm from the header, and signing them.
- <b>Critical point:</b> a JWT is signed, <b>not encrypted</b>. The payload is base64url — anyone can read it. Never put secrets in it.
- Trade-off: you can't revoke a JWT before it expires, which is exactly why access tokens are kept short-lived.

### Refresh token

A long-lived token issued alongside the access token, used to obtain a new access token once the original expires.

- Flow: user logs in → server issues both tokens. The <b>access token</b> authenticates API requests and expires quickly (e.g. 15 minutes). When it expires, the client presents the <b>refresh token</b> to get a new access token without making the user log in again.
- Store it more carefully than the access token (httpOnly cookie, not localStorage), and rotate it on use.

### OAuth2

A framework for <b>delegated authorization</b> — it answers "what is this app allowed to do?"

- The original problem: you want a fitness app to read your Google Calendar, but you don't want to hand it your Google password. OAuth2's answer is that you authenticate directly with Google, and the app receives an <b>access token</b> instead — a limited key saying "the bearer of this may read calendars", valid for one hour.
- OAuth2 by itself says <b>nothing about who you are</b>. An access token is like a hotel key card: it opens room 402, but it doesn't tell the door your name.

### OAuth2 authorization code flow

1. The client app requests authorization from the resource owner (user) to access their account data. <i>(User clicks "Login with Google".)</i>
2. The user logs into their Google account and grants permission for the requested scopes. <i>(Google shows a consent screen; the user clicks "Allow".)</i>
3. Google redirects back to the app's registered <code>redirect_uri</code> with a short-lived <b>authorization code</b>.
4. The client <b>backend</b> exchanges the authorization code for an access token by calling Google's token endpoint with its client secret.
5. Google validates the code and issues an <b>access token</b> (and optionally a <b>refresh token</b> and an ID token).
6. The client calls Google's APIs with <code>Authorization: Bearer <access_token></code>.

- ⚠️ The original note had the <b>UI</b> doing the code exchange. That's the part to get right: the exchange must happen server-side for a confidential client, because it needs the client secret. A browser SPA is a <i>public</i> client and must use <b>PKCE</b> instead of a secret.

### OIDC (OpenID Connect)

A thin standard layer on top of OAuth2 that answers "<b>who is this person?</b>" — added because people kept abusing OAuth2 for login, which it wasn't designed for.

- Three things it changes: you add <code>openid</code> to the requested scopes, you get back an extra <b>ID token</b> describing the user (<code>preferred_username</code>, <code>email</code>, <code>name</code>, <code>sub</code>), and there's a standard <code>/userinfo</code> endpoint.
- The ID token is like the photo ID you showed at the hotel desk — it identifies you, but it doesn't open any doors.
- <b>OAuth2 = authorization. OIDC = authentication.</b> That contrast is the answer to a very common question.

### Keycloak

An open-source identity provider that implements OIDC, so it handles authentication and authorization together in one round trip.

- <b>Whose login page is it?</b> Two different pages, worth separating in your head. Your app's <code>/login</code> is a branded screen with a single button and <b>no username or password field</b>. The page where you actually type a password lives on Keycloak, at <code>/realms/<realm>/protocol/openid-connect/auth</code>. That separation is the entire point of OAuth2 — your app never sees the password.

## CSRF, CORS & encryption7

### CSRF (Cross-Site Request Forgery)

An attack where a malicious site tricks an authenticated user's browser into performing an unwanted action on a trusted site.

- <b>The precise mental model:</b> CSRF is <i>not</i> "the attacker knows my token and makes a request." CSRF is "the attacker doesn't know my credential, but tricks my browser into automatically sending it." The browser attaches the session cookie for you — that automatic attachment is the vulnerability.
- This is why CSRF matters for <b>cookie/session</b> auth and generally not for a <code>Authorization: Bearer</code> header, which the browser never attaches automatically.

### CSRF protection in Spring Security⚠️

By default Spring Security protects every incoming state-changing request (<code>POST</code>, <code>PUT</code>, <code>DELETE</code>, <code>PATCH</code>) with a CSRF token.<br />1. <b>Token generation</b> — on first access the server generates a CSRF token.<br />2. <b>Token storage</b> — the token is stored and sent to the client.<br />3. <b>Client retrieval</b> — the client reads the token and puts it in a header on every state-modifying request.<br />4. <b>Server validation</b> — the server compares the token from the request against the stored one. Match = valid; mismatch = rejected.

- ⚠️ The original note said the token is stored in a cookie named <code>XSRF-TOKEN</code> and sent back in <code>X-XSRF-TOKEN</code>. That's only true when you explicitly configure <code>CookieCsrfTokenRepository</code> (the pattern Angular expects). <b>Spring Security's default is </b><b><code>HttpSessionCsrfTokenRepository</code></b> — the token lives in the HTTP session and comes back as the <code>_csrf</code> request parameter or <code>X-CSRF-TOKEN</code> header. Worth stating both, because interviewers ask which is the default.

### CSRF and session-centric applications

In traditional web apps, HTTP sessions track user state: on first access a session is created and its ID is stored in a cookie. Spring Security generates a CSRF token and associates it with that session, and the token must accompany every subsequent <code>POST</code>/<code>PUT</code>/<code>DELETE</code>/<code>PATCH</code>.

- The token proves the request originated from your own page rather than a malicious one, because a cross-site attacker can read the cookie's <i>existence</i> but not the token's <i>value</i>.

### Symmetric key encryption

One key both encrypts and decrypts. Push data through the key to scramble it, push it back to make it readable. An attacker only needs to steal that key.

- Fast. The hard part is distributing the key safely. AES is the standard.

### Public key (asymmetric) encryption

Two keys. The <b>public</b> key is available to anyone; the <b>private</b> key stays with a select few. Encode with one, and the recipient needs the other to read it.

- Encrypt with the public key → only the private key holder can read it. Sign with the private key → anyone can verify it with the public key.
- Slow, so in practice it's used to exchange a symmetric key (that's TLS).

### Hashing

A computer algorithm transforms your password into a fixed-length random-looking series of numbers and letters. It's <b>one-way</b> — you cannot reverse it, you can only hash a guess and compare.

- Security comes from the function being one-way and, for passwords, <b>deliberately slow</b>.
- Use a password hash (BCrypt, Argon2, scrypt, PBKDF2), never a fast general-purpose hash like MD5 or SHA-256 — fast hashes let an attacker try billions of guesses per second.

### Salting

A few random numbers or letters are appended to the password before it goes through the hashing process, so two users with the same password get different hashes.

- What it defeats: <b>precomputed rainbow tables</b>, and an attacker being able to spot that two accounts share a password.
- A <b>variable salt</b> — unique per password — is the correct approach. A <b>fixed salt</b> reused for every password loses most of the benefit.
- When a password is salted with a random value, the salt is stored alongside the hashed password. With BCrypt it's embedded inside the hash string itself.

## Method-level security7

### Method security⚠️

Controls access to specific methods in your controllers or services based on roles, permissions, or expressions.

- You must enable it explicitly by putting the annotation on a <code>@Configuration</code> class.
- ⚠️ Know <b>both</b> the old and the current annotation — the old one is what you'll find in any pre-Boot-3 codebase.

<b>Old — Spring Security 5.x (deprecated):</b>

```java
@EnableGlobalMethodSecurity(
  prePostEnabled = true,   // enables @PreAuthorize and @PostAuthorize
  securedEnabled = true,   // enables @Secured
  jsr250Enabled  = true)   // enables @RolesAllowed
```

<b>Current — Spring Security 6:</b>

```java
@EnableMethodSecurity     // prePostEnabled = true is the default
// add securedEnabled = true / jsr250Enabled = true only if you use those annotations
```

### <code>@Secured</code>

Spring-specific annotation (from <code>spring-security-core</code>) taking a list of role/authority strings. A user can call the method if they have at least one of them.

- Does <b>not</b> support SpEL.

### <code>@RolesAllowed</code>

The standardized equivalent of <code>@Secured</code>, from the <code>javax.annotation-api</code> (now <code>jakarta.annotation</code>) dependency. Same behaviour: a list of roles, at least one required.

- Also does <b>not</b> support SpEL. <code>@Secured</code> and <code>@RolesAllowed</code> are basically the same thing — one Spring-specific, one a standard.

### <code>@PreAuthorize</code>

Newer Spring-specific annotation that checks an expression <b>before</b> entering the method. More powerful than <code>@Secured</code>/<code>@RolesAllowed</code> because it accepts any valid SpEL expression, not just role names.

```java
@PreAuthorize("hasRole('ADMIN') or #userId == authentication.principal.id")
public User get(Long userId) { ... }
```

### <code>@PostAuthorize</code>

Verifies the expression <b>after</b> the method executes, and can therefore inspect the return value via <code>returnObject</code>.

- The method has already run and any side effects have happened — so this is for filtering what the caller sees, not for preventing work.

### <code>@PreFilter</code>

Filters a <b>collection argument</b> before the method executes, removing elements that fail the expression. <code>filterObject</code> refers to each element.

```java
@PreFilter(value = "filterObject != authentication.principal.username",
           filterTarget = "usernames")
public String joinUsernamesAndRoles(List<String> usernames, List<String> roles) { ... }
```

- <code>filterTarget</code> is required when the method has more than one collection parameter.

### <code>@PostFilter</code>

Filters the <b>returned collection</b> of a method, dropping elements the current user shouldn't see.

- Beware performance: the method still loads everything, then throws rows away in memory. Filter in the query for large result sets.

## Testing16

### Mockito

A mocking framework for creating mock objects in unit tests. Used for <b>stubbing</b> behaviour and <b>verifying</b> interactions between objects.

- Point of it: simulate a real object's behaviour in a controlled way so the unit under test is isolated from its dependencies.

```java
when(mockedList.get(0)).thenReturn("Alice");
verify(mockedRepo).save(any(User.class));
```

### <code>@Mock</code>

Creates a mock instance of a type. Every method returns a default (<code>null</code>, <code>0</code>, <code>false</code>) until you stub it.

### <code>@Spy</code>

Creates a <b>partial mock</b> — a real object where you can selectively stub individual methods while the rest run their real implementation.

- Stub a spy with <code>doReturn(x).when(spy).method()</code>, not <code>when(spy.method())</code>, because the latter actually calls the real method.

### <code>@InjectMocks</code>

Creates an instance of the class under test and injects the mocks created with <code>@Mock</code> (or <code>@Spy</code>) into it.

- Injection order it tries: constructor → setter → field. Constructor injection is the one that behaves predictably.

### Mockito's stubbing limits⚠️

Mockito historically could not stub <code>final</code>, <code>private</code>, or <code>static</code> methods.

- ⚠️ Update: since <b>Mockito 3.4</b> <code>mockStatic()</code> handles static methods, and the <b>inline mock maker</b> (default from Mockito 5) mocks <code>final</code> classes and methods. <code>private</code> methods are still out — and mocking them is a design smell anyway.

### <code>ArgumentCaptor</code>

Captures the arguments passed to a mock method so you can assert on them afterwards.

```java
ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
verify(repo).save(captor.capture());
assertEquals("Alice", captor.getValue().getName());
```

- Use it when the argument is built inside the method under test and you can't construct an expected value to match.

### JMockit

Another Java framework supporting stubbing and mocking, including things Mockito traditionally couldn't reach (statics, constructors) via bytecode instrumentation.

### Hamcrest

A framework for writing <b>matchers</b> — reusable conditions an object must satisfy — giving readable assertions and failure messages.

```java
assertThat(names, hasItem("Alice"));
assertThat(age, allOf(greaterThan(18), lessThan(65)));
```

- AssertJ (<code>assertThat(x).contains(...)</code>) has largely replaced it in new projects, but Spring's <code>MockMvc</code> still uses Hamcrest matchers.

### <code>@RunWith</code> (JUnit 4)

Specifies a test runner that replaces the default JUnit runner.

- <b>JUnit 4 allows only one runner per class</b> — you cannot combine several. That was the main limitation.
- With Mockito you'd use <code>@RunWith(MockitoJUnitRunner.class)</code>; with Spring, <code>@RunWith(SpringRunner.class)</code>.

### <code>@ExtendWith</code> (JUnit 5)

Registers an <b>extension</b> that adds behaviour to the test class.

- <b>JUnit 5 allows combining multiple extensions</b>, which is the flexibility <code>@RunWith</code> lacked.
- Equivalents: <code>@ExtendWith(MockitoExtension.class)</code>, <code>@ExtendWith(SpringExtension.class)</code>.

### <code>@Rule</code> (JUnit 4)

Defines a field or method that runs before or after each test method, letting you apply behaviour (timeouts, temp folders, expected exceptions) across many tests without duplicating code.

- Replaced in JUnit 5 by extensions.

### Spring TestContext Framework

Spring's integration-testing support, built on top of JUnit and TestNG.

- Adds: loading and <b>caching</b> Spring <code>ApplicationContext</code>s across test classes, transaction management (roll back after each test), and dependency injection into the test instance itself.
- The context cache is why the second test class starts much faster than the first.

### <code>@SpringBootTest</code>

Boots the full Spring application context for an integration test. With Spring Boot, no manual configuration is needed — it automatically:

- Starts the Spring application context.
- Finds your <code>@SpringBootApplication</code> class.
- Creates all beans.
- Loads <code>application.properties</code>.
- Configures the datasource, JPA/Hibernate, and transactions.
- Contrast with plain Spring, where you'd hand-configure an <code>ApplicationContext</code>, the beans, the datasource, the transaction manager, and test properties yourself.

```java
@ExtendWith(SpringExtension.class)     // JUnit 5
@ContextConfiguration(classes = AppConfig.class)
@Transactional
class MyServiceIntegrationTest { ... }
```

### <code>@MockBean</code>⚠️

Adds a mock implementation of a bean to the application context, replacing the real Spring bean of that type with a Mockito mock during the test.

- Note: <b>each distinct set of </b><b><code>@MockBean</code></b><b>s creates a new application context</b>, so overusing it destroys the context cache and slows the suite down.
- ⚠️ Know <b>both</b> names. Old (Spring Boot ≤ 3.3, deprecated in 3.4): <code>@MockBean</code> and <code>@SpyBean</code>. Current (Spring Boot 3.4+): <b><code>@MockitoBean</code></b> and <b><code>@MockitoSpyBean</code></b>.
- Same behaviour, same purpose — the rename was to make it obvious they're Mockito-specific rather than a generic Spring feature.

### <code>@DataJpaTest</code>

A <b>test slice</b> that loads only JPA components — entities, repositories, a <code>TestEntityManager</code>, and an in-memory datasource — instead of the whole application.

- Transactional and rolls back by default.
- Sibling slices: <code>@WebMvcTest</code> (controllers only), <code>@JsonTest</code>, <code>@RestClientTest</code>.

### JaCoCo

A code-coverage tool. It needs to sit <b>inside the JVM that executes your tests</b> and watch which lines get executed.

- That's why the Maven setup is <code>jacoco:prepare-agent</code> (attaches the Java agent before tests) then <code>jacoco:report</code>.

## Maven26

### Maven default lifecycle⚠️

<code>validate</code> → <code>compile</code> → <code>test</code> → <code>package</code> → <code>verify</code> → <code>install</code> → <code>deploy</code>

- <b>validate</b> — check the project is correct and all necessary information is available.
- <b>compile</b> — compile source into <code>target/classes</code>.
- <b>test</b> — run unit tests.
- <b>package</b> — bundle into a JAR/WAR.
- <b>verify</b> — run checks on integration test results to confirm quality criteria are met.
- <b>install</b> — install the package into your <b>local</b> repository, so other projects on your machine can depend on it.
- <b>deploy</b> — done in the build environment; copies the final package to the <b>remote</b> repository to share with other developers and projects.
- ⚠️ <code>clean</code> is <b>not</b> part of the default lifecycle. Maven has three separate lifecycles: <b>clean</b>, <b>default</b>, and <b>site</b>. <code>mvn clean install</code> is you invoking two lifecycles in one command — that's a real interview question.

### Phase

One step in a lifecycle. Examples: <code>compile</code>, <code>test</code>, <code>package</code>, <code>install</code>.

- Running a phase runs every phase before it in that lifecycle.

### Goal

A single task provided by a plugin, bound to a phase.

- Examples: <code>compiler:compile</code> is bound to the <code>compile</code> phase; <code>surefire:test</code> is bound to the <code>test</code> phase; <code>jacoco:prepare-agent</code>.
- Each lifecycle phase is associated with one or more goals.
- Run one directly: <code>mvn [plugin-name]:[goal-name]</code>, e.g. <code>mvn dependency:tree</code>.

### <code><goals></code> vs <code><phase></code>

- <code><goals></code> = <b>what</b> a plugin can do.
- <code><phase></code> = <b>when</b> that goal runs.
- Plugins run automatically when their bound phase is reached. If no phase is declared, Maven uses the plugin's own default phase.

### Maven as a plugin execution framework

Maven itself does almost nothing — it's a framework that <b>executes plugins</b>, and every actual task is done by a plugin.

- Compiling: Compiler Plugin. Testing: Surefire Plugin. Packaging: JAR/WAR Plugin.
- Plugins are configured in <code>pom.xml</code> under <code><build></code>, where each can specify goals, executions, and custom settings.

### Compiler Plugin

Compiles Java source files into <code>.class</code> files.

- <code>source</code> — the language level of your source. <code>target</code> — the version of the bytecode produced (e.g. Java 1.8).
- Modern shorthand: the <code>maven.compiler.release</code> property, which does both correctly.

### Surefire Plugin

Runs <b>unit</b> tests and generates reports from the results. Bound to the <code>test</code> phase by default.

- Picks up <code>Test.java</code>, <code>Test*.java</code>, <code>Tests.java</code>, <code>TestCase.java</code> by default.

### Failsafe Plugin

The <b>integration</b> test counterpart. Bound to <code>integration-test</code> and <code>verify</code>, and — unlike Surefire — it doesn't fail the build immediately, so post-test cleanup still runs.

- Default pattern: <code>IT.java</code>.

### <code><groupId></code>

The unique identifier for the group or organization responsible for the project. Reverse domain convention: <code>com.instructure.canvas</code>.

### <code><artifactId></code>

The unique identifier for the specific project or library within the group — usually the library's name.

### <code><version></code>

The artifact's version. A <code>-SNAPSHOT</code> suffix means "in development": Maven will re-check the remote repository for newer builds.

### <code><scope></code>

Indicates the visibility and lifecycle of a dependency in relation to the project.

- <b>compile</b> — the default; available on every classpath (compile, test, runtime) and packaged with the app.
- <b>test</b> — available only for test compilation and execution.
- <b>runtime</b> — not needed to compile, required at runtime (e.g. a JDBC driver).
- <b>provided</b> — needed to compile but supplied by the container at runtime, so it isn't packaged.
- <b>import</b> — only valid inside <code><dependencyManagement></code> with <code><type>pom</type></code>; pulls in a BOM.

### <code><exclusions></code>

Excludes specific <b>transitive</b> dependencies from being pulled into your project.

- The usual reason: a duplicate/conflicting implementation, e.g. excluding <code>spring-boot-starter-logging</code> to swap in Log4j2.

### <code><repositories></code>

The <code>pom.xml</code> tag where the URLs of remote repositories are configured.

- Famous repository managers: <b>JFrog Artifactory</b> and <b>Sonatype Nexus</b>. These host not just Maven JARs but plenty of unrelated artifacts — container (Docker) images, configuration files, and more.

### Local repository

The central place on your machine holding every Maven artifact any of your projects has used. Default: <code>~/.m2/repository</code>.

### <code>pom.xml</code>

The Project Object Model. Does a great many things, including dependency management, build lifecycle customization, and plugin configuration.

### Super POM

The implicit parent that <b>all</b> POMs inherit from. It supplies Maven's default values — the default lifecycle bindings, the standard directory layout, Maven Central as a repository.

- See yours fully resolved with <code>mvn help:effective-pom</code>.

### <code><dependencyManagement></code>

Declares the version Maven should use for a dependency <b>"in case"</b> a module decides to use it — it does not add the dependency itself.

- <b>Purpose:</b> avoid repeating dependency configuration and centralize it, so you don't update a version in multiple modules every time it changes.
- If a library's version is <b>not</b> declared in <code><dependencyManagement></code> and you use it, you must state the version yourself under <code><dependencies></code> or the build fails.
- You can exploit that to <b>override</b> a managed version: declare your required version directly under <code><dependencies></code>.

### BOM (Bill Of Materials)

A POM containing only a <code><dependencyManagement></code> section. It's an independent file with its own <code>groupId</code>, <code>artifactId</code>, and <code>version</code>, imported to centralize versions.

- Key contrast: a <b>BOM</b> holds something usable across several unrelated projects, while a <b>parent POM</b>'s usefulness is limited to the project it was created in.
- And: you can have only <b>one parent</b>, but you can <b>import multiple BOMs</b>.
- Example: <code>spring-boot-dependencies</code>.

### POM packaging

<code><packaging>pom</packaging></code> — a Maven project used solely to manage dependencies, plugins, and other modules. Produces no JAR or WAR; it defines the structure and dependencies of a multi-module build.

### JAR packaging

The default for Java projects. Produces a <code>.jar</code> containing compiled classes, resources, and metadata, which can be executed or used as a dependency elsewhere.

### Aggregator POM

Strictly <b>required</b> to orchestrate multiple modules. Sits at the root of the project and its only job is to host the <code><modules></code> tag pointing at each sub-module's directory, so one command builds them all.

- Must declare <code><packaging>pom</packaging></code>.

### Parent POM

Technically <b>optional</b>. Hosts shared properties, dependencies, and plugin management, which sub-modules inherit by explicitly referencing it with the <code><parent></code> tag in their own <code>pom.xml</code>.

- The two concepts are independent — one file usually plays both roles, but it doesn't have to.

### Transitive dependency

A dependency pulled in indirectly: you depend on A, A depends on B, so B lands on your classpath without you declaring it.

- Inspect the whole graph with <code>mvn dependency:tree</code>.

### Dependency mediation — "nearest wins"

If different versions of the same dependency arrive through different paths, Maven uses the one <b>closest to your project</b> in the dependency tree.

- Example: <code>versionB1</code> of <code>depB</code> came in through <code>depA</code>, while <code>versionB2</code> of <code>depB</code> is declared directly in your <code>pom.xml</code>. Your direct declaration wins, because that version is nearest in the tree.
- <b>Tie-break:</b> at equal depth, the one declared <b>first</b> wins.
- Important for Java/Spring migration and version-uplift work: this is why an unexpected old version shows up, and why declaring it directly (or managing it in <code><dependencyManagement></code>) is the fix. <code><dependencyManagement></code> beats nearest-wins entirely.

### Maven profile

A named block of build configuration you switch on or off, letting you change plugins, dependencies, and properties per environment or purpose.

```xml
<profiles>
  <profile>
    <id>coverage</id>
    <properties><lineCoverage>0.80</lineCoverage></properties>
  </profile>
</profiles>
```

- Activate with <code>mvn clean install -Pcoverage</code>. Can also activate on a property, JDK version, or OS.

## Microservices & distributed systems10

### Spring Boot vs Spring Cloud

- <b>Spring Boot</b> = build <b>one</b> service.
- <b>Spring Cloud</b> = help <b>many</b> services work together.

### Spring Cloud

A collection of Spring projects providing infrastructure and tooling for distributed systems and microservices — API gateways, centralized configuration, declarative REST clients, load balancing, and service discovery.

- Think of the artifacts as ready-made solutions to problems you only get once you have multiple Spring Boot services.

### Spring Cloud Config

Centralized configuration. All services fetch their DB URLs and settings from one config server instead of each holding its own copy.

### Spring Cloud Gateway

API gateway. A client calls <code>/orders</code> and the gateway routes it to the Order Service.

### Spring Cloud OpenFeign

Declarative service-to-service HTTP calls. Order Service calls User Service by declaring an interface, with no HTTP boilerplate.

### Spring Cloud LoadBalancer

Distributes requests across multiple instances of a service — User Service #1, #2, #3.

### Spring Cloud Kubernetes

Integrates Spring apps with Kubernetes, discovering services and configuration through Kubernetes primitives (Services, ConfigMaps, Secrets) instead of a separate registry.

### API gateway

A single entry point between clients and your backend services.

- Does: <b>routing</b>, <b>authentication</b>, <b>authorization</b>, <b>load balancing</b>, plus rate limiting, request/response transformation, and aggregation.

### API gateway vs load balancer

- <b>Load balancer</b> answers one question: <i>"Which instance should receive this request?"</i>
- <b>API gateway</b> answers three: <i>"Should this request be allowed, where should it go, and what should I do with it before and after forwarding it?"</i>

### Distributed SQL databases

Databases that expose a SQL-like interface while internally handling routing, sharding, and distributed execution across nodes.

- Examples: CockroachDB, Google Spanner, TiDB, YugabyteDB, SingleStore.
- You write <code>SELECT * FROM Orders WHERE customer_id = 15;</code> and the engine figures out which nodes hold the data.

## Libraries & tools4

### Jackson

A Java library for converting between Java objects and JSON — serialization (Java → JSON) and deserialization (JSON → Java).

- Spring Boot auto-configures it, which is what makes <code>@RestController</code> return JSON.
- Useful annotations: <code>@JsonProperty</code>, <code>@JsonIgnore</code>, <code>@JsonInclude</code>, <code>@JsonFormat</code>.

```java
new User("Habiba", 25)
->
{ "name": "Habiba", "age": 25 }
```

### ModelMapper

An object-mapping library using <b>runtime reflection</b>, with no code generation.

- Easier setup and more flexible, but <b>slower</b> and less explicit — mismatches surface at runtime, not compile time.

### MapStruct

An object-mapping library using <b>compile-time code generation</b>.

- No reflection, type-safe, fast, and explicit — the generated mapper is plain Java you can read and step through. Errors appear at compile time.
- The generally preferred choice for production code.

### Redis

Single-threaded, in-memory data store built on a hash-map structure. Commonly used for caching, sessions, rate limiting, and pub/sub.

- Being single-threaded is why <code>INCR</code> and <code>SETNX</code> are atomic without any locking — and why one slow command (<code>KEYS *</code>) blocks everything.

## Spring version history4

### Spring Framework 1.x

- Introduced the <b>IoC container</b> and <b>AOP</b> — the two ideas everything else is built on.

### Spring Framework 2.x

- <b>Annotation-based configuration</b> (<code>@Autowired</code>, <code>@Component</code>, <code>@Service</code>, <code>@Repository</code>), replacing XML.
- Better integration with Hibernate and JPA.
- The <b>Spring TestContext Framework</b> for testing.

### Spring Framework 4.x / 5.x

- <b>4.x</b> — Java 8 support (lambdas, <code>Optional</code>), <code>@RestController</code>, WebSocket support, <code>@Autowired</code> optional on a single constructor.
- <b>5.x</b> — Java 8 baseline, <b>WebFlux</b> reactive stack, Kotlin support, functional bean registration, JUnit 5 support.

### Spring Framework 6.x

- Java 17 baseline, <b>Jakarta EE 9+</b> namespace (<code>javax.*</code> → <code>jakarta.*</code>), AOT processing and GraalVM native image support, Micrometer Observation API replacing Sleuth.
- 6.1 added <code>RestClient</code> and <code>JdbcClient</code>, and virtual-thread support.
- This is the version underneath Spring Boot 3 — see the <b>Java & Spring migrations</b> topic.

## Java & Spring migrations (Spring Boot 2 → 3, Java 11 → 25)17

### Why the upgrade happens at all

Old versions stop getting security patches, and the frameworks stop supporting them.

- Java LTS releases arrive every two years: <b>11 (2018) → 17 (2021) → 21 (2023) → 25 (2025)</b>. Non-LTS releases get six months of patches only, which is why teams hop LTS to LTS.
- Spring Boot 2.x reached end of open-source support in <b>November 2023</b>; anything after that is commercial extended support. That deadline is what drives most Boot 2 → 3 projects.
- The two upgrades are coupled: <b>Spring Boot 3 requires Java 17 as a minimum</b>, so you cannot do the framework jump without doing the Java jump.

### Spring Boot 2 → 3 — the baseline

Four things change at once, and all of them are mandatory.

- <b>Java 17 minimum</b> (21 or 25 recommended, for virtual threads).
- <b>Spring Framework 5 → 6.</b>
- <b>Jakarta EE 9+</b>, meaning the <code>javax.*</code> → <code>jakarta.*</code> package rename.
- <b>Hibernate 5 → 6</b> and <b>Spring Security 5 → 6</b>.
- Do them in this order: get onto the newest Boot 2.7.x first, fix all deprecation warnings there, upgrade Java, <i>then</i> jump to Boot 3. Fixing deprecations while still on 2.7 is far cheaper than debugging them on 3.x.

### <code>javax.*</code> → <code>jakarta.*</code>

The single largest mechanical change in the whole migration. Oracle kept the <code>javax</code> trademark, so Jakarta EE renamed every package.

- <code>javax.persistence.*</code> → <code>jakarta.persistence.*</code> (entities, <code>@Entity</code>, <code>@Id</code>, <code>EntityManager</code>)
- <code>javax.servlet.*</code> → <code>jakarta.servlet.*</code> (filters, <code>HttpServletRequest</code>)
- <code>javax.validation.*</code> → <code>jakarta.validation.*</code> (<code>@Valid</code>, <code>@NotNull</code>)
- <code>javax.annotation.*</code> → <code>jakarta.annotation.*</code> (<code>@PostConstruct</code>, <code>@PreDestroy</code>, <code>@RolesAllowed</code>)
- Still <code>javax</code> and unaffected: <code>javax.sql</code>, <code>javax.crypto</code>, <code>javax.net</code>, <code>javax.naming</code> — these are JDK packages, not Jakarta EE. Blind find-and-replace on <code>javax.</code> breaks them.
- Third-party libraries must also have a Jakarta-compatible release. Any library that hasn't shipped one is a hard blocker.

### Spring Security 5 → 6 — old → new

The API rewrite that causes the most churn.

| Spring Security 5 | Spring Security 6 |
| --- | --- |
| <code>extends WebSecurityConfigurerAdapter</code> | <b>removed</b> — expose a <code>SecurityFilterChain</code> bean instead |
| <code>configure(HttpSecurity http)</code> override | a <code>@Bean</code> method returning <code>SecurityFilterChain</code> |
| <code>authorizeRequests()</code> | <code>authorizeHttpRequests()</code> |
| <code>antMatchers()</code> / <code>mvcMatchers()</code> / <code>regexMatchers()</code> | <code>requestMatchers()</code> (one method, it infers the type) |
| <code>@EnableGlobalMethodSecurity(prePostEnabled = true)</code> | <code>@EnableMethodSecurity</code> (<code>prePostEnabled</code> on by default) |
| <code>WebSecurityConfigurerAdapter.authenticationManagerBean()</code> | an <code>AuthenticationManager</code> bean |
| <code>and()</code> chaining | lambda DSL (<code>http.csrf(c -> c.disable())</code>) |

```java
// Spring Security 6
@Configuration
@EnableWebSecurity
class SecurityConfig {
  @Bean
  SecurityFilterChain chain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(a -> a
        .requestMatchers("/public/**").permitAll()
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated())
      .oauth2ResourceServer(o -> o.jwt(Customizer.withDefaults()))
      .build();
  }
}
```

- Behaviour change to watch: roles are matched more strictly, and the default <code>ROLE_</code> prefixing trips people up during the rewrite.

### Hibernate 5 → 6

Runs underneath the JPA rename and quietly changes runtime behaviour, so this is where the surprises live.

- <b>Generated SQL changes.</b> Hibernate 6 rewrote its query engine, so native SQL assertions and hand-tuned queries can break.
- <b>Stricter type handling.</b> Implicit conversions Hibernate 5 tolerated now fail; <code>@Enumerated</code>, <code>Boolean</code>, and UUID mappings are the usual offenders.
- <b><code>@GeneratedValue(strategy = AUTO)</code></b><b> changed default</b> for some databases — sequence-per-entity instead of a single shared one. Check your ID generation or you get duplicate keys.
- Legacy <code>hibernate.</code> properties were renamed; several <code>spring.jpa.properties.*</code> entries need updating.

### Spring MVC & web changes (Boot 2 → 3)

- <b>Trailing-slash matching is off by default.</b> <code>/orders</code> and <code>/orders/</code> are now different paths. Previously they matched. This silently 404s existing clients — the most common post-migration production bug.
- <b><code>PathPatternParser</code></b><b> is the default</b> path matcher, replacing <code>AntPathMatcher</code>. <code>*</code> is only allowed at the end of a pattern now.
- <code>spring.mvc.pathmatch.matching-strategy</code> no longer accepts the old value in the same way.
- <code>RestTemplate</code> still works but is legacy — <b><code>RestClient</code></b> (Spring Framework 6.1 / Boot 3.2) is the modern synchronous client.

### Config, Actuator & observability changes

- <b><code>@ConstructorBinding</code></b> is no longer needed on a <code>@ConfigurationProperties</code> class with a single constructor, and it's now only valid on constructors, not types.
- <b>Actuator endpoints</b> changed shape: <code>/actuator/health</code> details are hidden by default, and several endpoint IDs and response fields moved.
- <b>Spring Cloud Sleuth is gone.</b> Tracing moved to <b>Micrometer Tracing</b> plus the Micrometer Observation API. This is a real rewrite if you had custom spans.
- Logging: the default log format changed, and Boot 3.4 added structured (JSON) logging out of the box.
- Run <code>spring-boot-properties-migrator</code> as a temporary dependency — it logs every renamed property at startup and tells you the new name. Remove it once you're clean.

### Testing changes (Boot 2 → 3)

- <b>JUnit 4 support removed from the starter.</b> <code>spring-boot-starter-test</code> no longer brings the vintage engine — add it explicitly or migrate the tests to JUnit 5.
- <code>@RunWith(SpringRunner.class)</code> → <code>@ExtendWith(SpringExtension.class)</code>, or just <code>@SpringBootTest</code> on its own.
- <code>@MockBean</code> / <code>@SpyBean</code> → <b><code>@MockitoBean</code></b><b> / </b><b><code>@MockitoSpyBean</code></b> (deprecated in Boot 3.4).
- Mockito 5 changed the default mock maker to <b>inline</b>, which means <code>final</code> classes now mock successfully — and some tests that relied on the old failure behaviour change.

### Java 11 → 17 — strong encapsulation

The change most likely to break your build, and it fails at runtime rather than compile time.

- Since Java 16, JDK internals are <b>strongly encapsulated by default</b> (JEP 396). Reflective access into <code>sun.*</code> or non-exported <code>jdk.internal.*</code> throws <b><code>InaccessibleObjectException</code></b>.
- The <code>-illegal-access=permit</code> escape hatch that worked on Java 11 is <b>no longer valid</b> on 17.
- Fixes, best first: switch to a standard API; upgrade the offending library to a version that doesn't reach into internals; as a last resort add <code>-add-opens</code> / <code>-add-exports</code> flags (which reopens the hole you just closed).
- Find them before they bite: <b><code>jdeps --jdk-internals</code></b> on your jars.

### Java 11 → 17 — what was removed

Removed outright, so these are compile or startup failures.

- <b>Applet API</b>, <b>RMI Activation</b>, <b>Pack200</b>, and the <b>Nashorn JavaScript engine</b> (removed in 15 — if you scripted anything, move to GraalVM JS).
- <b>CMS garbage collector</b> removed. Any <code>XX:+UseConcMarkSweepGC</code> in your startup script must go — switch to <b>G1</b> (default), <b>ZGC</b>, or <b>Shenandoah</b>.
- <b>Invalid JVM flags now abort startup</b> instead of just warning. Audit every <code>XX:</code> flag.
- <b>Security Manager deprecated for removal</b> (JEP 411).
- Scan for removed APIs with <b><code>jdeprscan</code></b>.

### Java 11 → 17 — what you gain

- <b>Records</b>, <b>sealed classes</b>, <b>pattern matching for </b><b><code>instanceof</code></b>, <b>text blocks</b> (<code>"""</code>), <b>switch expressions</b>, <b>helpful </b><b><code>NullPointerException</code></b><b> messages</b> that name the exact null variable.

### Java 17 → 21

Mostly additive — this is the easy leg of the journey.

- <b>Virtual threads</b> (JEP 444). In Spring Boot 3.2+ turn them on with <code>spring.threads.virtual.enabled=true</code>. Biggest single win for an I/O-bound web service.
- <b>Sequenced collections</b> — <code>getFirst()</code>, <code>getLast()</code>, <code>reversed()</code> on <code>List</code>, <code>Set</code>, <code>Map</code>.
- <b>Pattern matching for </b><b><code>switch</code></b> and <b>record patterns</b>, both final.
- <b>Generational ZGC.</b>
- Watch for: <code>synchronized</code> blocks <b>pin</b> a virtual thread to its carrier in 21, so hot paths should use <code>ReentrantLock</code>. Dynamic agent loading now warns (JEP 451) — affects some profilers and mocking libraries.
- Finalization is deprecated for removal; anything relying on <code>finalize()</code> needs replacing with <code>Cleaner</code> or try-with-resources.

### Java 21 → 25

Java 25 is the current LTS (September 2025). Mostly additive again, with two removals worth checking.

- <b>Security Manager permanently disabled</b> (JEP 486, Java 24). Calling <code>System.setSecurityManager</code> now throws. If anything still used it, this is a hard stop — replace with OS/container-level sandboxing.
- <b><code>sun.misc.Unsafe</code></b><b> memory-access methods</b> deprecated for removal (23) and warn on use (24). Old libraries that use them log noisy warnings and will eventually break.
- <b>32-bit x86 port removed</b> (JEP 503) — only matters if you still build for 32-bit.
- <b>ZGC's non-generational mode removed</b> (Java 24); generational is now the only mode.
- New and final in 25: <b>module import declarations</b> (<code>import module java.base;</code> — one line instead of many), <b>compact source files and instance </b><b><code>main</code></b><b> methods</b> (no boilerplate class for small programs), <b>flexible constructor bodies</b> (statements allowed <i>before</i> <code>super()</code>), <b>scoped values</b> (a safer <code>ThreadLocal</code> for virtual threads), <b>compact object headers</b> (real heap savings), and a <b>Key Derivation Function API</b>.
- Still preview in 25, so don't rely on them: <b>structured concurrency</b>, <b>primitive types in patterns</b>, <b>stable values</b>.
- Also worth knowing across 22–24: <b>Foreign Function & Memory API</b> final (22), <b>unnamed variables</b> <code>_</code> (22), <b>stream gatherers</b> final (24), <b>class-file API</b> final (24), <b>AOT class loading and linking</b> (24) plus AOT ergonomics and method profiling (25) — meaningful JVM startup improvements.

### Migration playbook — the order that works

1. <b>Get to the latest patch of your current versions first</b> (Boot 2.7.x, Java 11 latest). Clean the build.
2. <b>Fix every deprecation warning while still on the old version.</b> Cheapest possible time to do it.
3. <b>Upgrade Java first, framework second.</b> Boot 2.7 runs fine on Java 17, so you isolate JVM problems from framework problems.
4. <b>Run </b><b><code>jdeps --jdk-internals</code></b><b> and </b><b><code>jdeprscan</code></b>; fix or replace what they flag.
5. <b>Do </b><b><code>javax</code></b><b> → </b><b><code>jakarta</code></b> with an automated tool, then review by hand — especially anything matching <code>javax.sql</code>, <code>javax.crypto</code>, <code>javax.net</code>.
6. <b>Upgrade Spring Boot</b>, add <code>spring-boot-properties-migrator</code>, and read every warning at startup.
7. <b>Rewrite the security config</b> — this is a rewrite, not a rename.
8. <b>Test the database layer hardest.</b> Hibernate 6 is where silent behaviour changes hide.
9. <b>Check trailing slashes</b> against every existing client before release.

### Migration tooling

- <b>OpenRewrite</b> (<code>rewrite-spring</code>, <code>rewrite-migrate-java</code>) — automated recipes that do most of the <code>javax</code> → <code>jakarta</code> rename, JUnit 4 → 5, and many Boot 3 upgrades. Run <code>mvn rewrite:run</code> with the recipe, review the diff.
- <b><code>jdeps --jdk-internals</code></b> — finds reflective access into JDK internals.
- <b><code>jdeprscan</code></b> — finds usage of removed and deprecated APIs.
- <b><code>spring-boot-properties-migrator</code></b> — logs renamed configuration properties at startup.
- <b>Maven Versions Plugin</b> (<code>mvn versions:display-dependency-updates</code>) — surfaces which dependencies still lack a Jakarta-compatible release.

### Migration pitfall: dependency mediation

The version that silently wins is the one <b>nearest</b> in the dependency tree, not the newest.

- During an uplift, an old transitive copy of a library can override the new one you thought you'd upgraded — and nothing warns you.
- Diagnose with <code>mvn dependency:tree</code>. Fix by declaring the version directly in <code><dependencies></code> or pinning it in <code><dependencyManagement></code>, which overrides nearest-wins entirely.
- Import the Spring Boot BOM rather than pinning Spring versions by hand; that's what keeps the whole stack consistent.

### What's next: Spring Boot 4 / Spring Framework 7

Released November 2025. Useful to know as the next hop, and it shows you're current.

- <b>Java 17 still the minimum</b>, but 21 or 25 strongly recommended.
- <b>Jakarta EE 11</b> — Servlet 6.1, JPA 3.2, Bean Validation 3.1.
- <b>Jackson 3 only</b> — Jackson 2 support dropped. This is the biggest mechanical change, much like <code>javax</code> → <code>jakarta</code> was for Boot 3.
- <b>JUnit 4 support removed entirely</b>; JUnit Jupiter 6 required.
- <b>Modules split up</b> — auto-configurations moved into smaller focused artifacts, so classpath scanning and native-image size shrink.
- New: built-in <b>API versioning</b>, <b><code>@Retryable</code></b> and <b><code>@ConcurrencyLimit</code></b> resilience annotations, declarative HTTP clients via <b><code>@HttpExchange</code></b>, <b><code>RestTestClient</code></b>, and <b>JSpecify</b> nullability annotations.

No match. Try a shorter word.
