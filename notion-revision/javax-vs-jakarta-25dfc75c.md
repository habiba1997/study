# Javax Vs Jakarta

Source: https://app.notion.com/p/25dfc75cbbd980cd97ceecf92ee5c37a?pvs=204

If you’re using <b>Spring OXM</b> (<code>spring-oxm</code>), the <code>@XmlRootElement</code> annotation is <b>not provided by Spring</b>. It comes from <b>Jakarta XML Binding (JAXB)</b>.

### Why You Don’t Find It

- In <b>Java 8 (and earlier)</b> → <code>@XmlRootElement</code> was bundled in JDK (<code>javax.xml.bind.annotation.XmlRootElement</code>).
- Starting <b>Java 11+</b> → JAXB was <b>removed from the JDK</b>, so you must add it manually.
- In <b>Spring Boot 3 / Spring 6</b> → all <code>javax.*</code> packages were migrated to <code>jakarta.*</code>.
  <p>
  So you now need <code>jakarta.xml.bind.annotation.XmlRootElement</code>.
  </p>

### Fix

Add the correct dependency for JAXB.

For <b>Spring Boot 3 / Jakarta</b>:

```xml
<dependency>
    <groupId>jakarta.xml.bind</groupId>
    <artifactId>jakarta.xml.bind-api</artifactId>
</dependency>
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
</dependency>


```

For <b>Spring Boot 2 / Javax</b>:

```xml
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
    <version>2.3.1</version>
</dependency>


```

### 

## <b>Java EE and </b><b><code>javax</code></b>

- Originally, <b>Java EE (Enterprise Edition)</b> was developed and owned by <b>Sun Microsystems</b> (later Oracle).
- It included APIs like <b>JAX-RS, JPA, JAXB</b> etc., all under the <code>javax.*</code> namespace.
- Example:
  ```java
  import javax.xml.bind.annotation.XmlRootElement;


  ```

---

## 2. <b>Oracle Transfers Java EE to Eclipse Foundation (2017)</b>

- Oracle decided not to continue evolving Java EE itself.
- They donated it to the <b>Eclipse Foundation</b> under the new name <b>Jakarta EE</b>.
- BUT Oracle did <b>not allow Eclipse to keep using the </b><b><code>javax.*</code></b><b> package names</b> (trademark restrictions).
- So Eclipse had to rename everything to <b><code>jakarta.*</code></b>.

➡️ <code>javax.xml.bind</code> → <code>jakarta.xml.bind</code>

---

## 3. <b>Jakarta EE (Successor of Java EE)</b>

- Eclipse Foundation now leads the development.
- Jakarta EE is essentially Java EE’s continuation, but with a different namespace.
- Current versions of Spring (6.x / Boot 3.x) are based on <b>Jakarta EE 9+</b>, which uses <code>jakarta.*</code>.

---

## 4. <b>What about GlassFish?</b>

- <b>GlassFish</b> was originally the <b>reference implementation</b> of Java EE.
  - A <i>reference implementation (RI)</i> = a working implementation that proves the spec is usable.
- After the move to Eclipse, <b>GlassFish became the reference implementation for Jakarta EE</b>.
- Alongside GlassFish, Eclipse also provides implementations for individual APIs (like JAXB, JSON-B, etc.).

<b>JAXB Example:</b>

- API: <code>jakarta.xml.bind:jakarta.xml.bind-api</code> (the interface/annotations).
- Implementation (RI): <code>org.glassfish.jaxb:jaxb-runtime</code> (actual code to run).

---

## 5. <b>Putting It All Together</b>

- <b><code>javax</code></b> = old Java EE namespace (now frozen, no new versions).
- <b><code>jakarta</code></b> = new namespace under Eclipse (active development, used in Spring 6 / Boot 3).
- <b>GlassFish</b> = open-source implementation + reference for Jakarta EE specs (including JAXB runtime).

So when you add dependencies today:

- <b>API</b> = <code>jakarta.xml.bind-api</code> (the spec/annotations).
- <b>GlassFish runtime</b> = <code>jaxb-runtime</code> (implementation).

---
