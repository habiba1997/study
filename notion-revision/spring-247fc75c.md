# Spring

Source: https://app.notion.com/p/247fc75cbbd9800ca389d4cf344c8c77?pvs=204

### What is a <b>proxy</b> in Spring?

- A <b>proxy</b> is a "wrapper" object that Spring generates at runtime.
- Instead of giving you the <b>real implementation</b>, Spring gives you a <b>proxy</b> that:
  - Adds extra behavior (transactions, security, lazy loading, etc.).
  - Delegates calls to the actual target object.

Example:

```java
MyService myService = applicationContext.getBean(MyService.class);
```

<code>myService</code> may not be a <code>MyServiceImpl</code> directly—it could be a <b>proxy</b> (<code>com.sun.proxy.$Proxy123</code>) that intercepts method calls and forwards them to <code>MyServiceImpl</code>.

---

### 2. Why are Spring Data repositories proxies?

- You don’t write an implementation for <code>MyRepository extends JpaRepository<...></code> yourself.
- Spring Data generates a <b>dynamic proxy implementation</b> at runtime.
- This proxy delegates queries to JPA under the hood.

So:

```java
interface MyRepo extends JpaRepository<User, Long> {}
```

At runtime, Spring gives you <b><code>com.sun.proxy.$ProxyXYZ</code></b>, not <code>MyRepoImpl</code>.

---

### 3. Why is it a <b>final proxy</b>?

- JDK dynamic proxies (<code>com.sun.proxy.$ProxyXYZ</code>) are generated classes.
- They are marked <code>final</code> by the JVM.
- Mockito cannot subclass them (which is how it normally makes mocks/spies).
  <p>
  → That’s why you get:
  </p>

  ```txt
  Mockito cannot mock/spy class com.sun.proxy.$Proxy291
  - final class
  ```

<b>Maven Dependency Order Matters</b>

Maven downloads these dependencies from a central repository and adds them to the project’s classpath. Maven handles transitive dependencies by recursively including dependencies of your dependencies. The order of inclusion in the build classpath is generally managed by Maven’s internal algorithm.

While Maven tries to manage dependencies automatically, problems arise when:

- Version conflicts: Two libraries may require different versions of the same dependency.
- Class conflicts: Multiple dependencies may contain the same class names, leading to issues at runtime.
- Shadowed dependencies: An earlier dependency may be overridden by a later one, causing unexpected behavior.

These issues can often be resolved by carefully controlling the order in which dependencies are declared. <b>For example, in a situation where two dependencies require different versions of a third-party library, Maven will use the version that appears first in the </b><b><code>pom.xml</code></b><b> file</b>, which could lead to errors if it’s not the version you intended.<br />Exclusions: You can exclude specific transitive dependencies that might be causing conflicts.

<page url="https://app.notion.com/p/256fc75cbbd9806a8f3edf29b138e652">
Plugins
</page>

- Effective POM: Running <code>mvn help:effective-pom</code> can help you view how Maven has resolved the final dependency tree for your project. This is particularly useful when debugging complex POM hierarchies or multi-module projects. For example:

<p />

<page url="https://app.notion.com/p/25dfc75cbbd980cd97ceecf92ee5c37a">
Javax Vs Jakarta
</page>

<page url="https://app.notion.com/p/276fc75cbbd980978f00caba52c72a80">
Webflux
</page>

<page url="https://app.notion.com/p/325fc75cbbd980e78ec1c4da680e224b">
Notes
</page>
