# [ERROR] 'java.util.Set org.junit.platform.engine.TestDescriptor.getAncestors()'

Source: https://app.notion.com/p/32efc75cbbd980268ac7fc194bb04d63?pvs=204

is effectively a <b>linkage error</b> (<code>NoSuchMethodError</code>) during test engine startup.

It means:

- some code in the test runner tried to call <code>TestDescriptor#getAncestors()</code>
- but the <code>TestDescriptor</code> class actually loaded at runtime <b>didn’t have that method</b>

So test discovery breaks <b>before</b> normal test execution, which is why you saw:

- <code>Tests run: 0</code>

---

## <b>Why It Happened In Your Project</b>

You had a version mix in the test stack:

- project/test deps resolved around Spring Boot 2.7.x baseline (<code>JUnit 5.8.2</code>, Platform <code>1.8.2</code>)
- Surefire plugin was running at <code>3.5.2</code> (newer provider behavior/API expectations)

That combo can create a runtime mismatch in the launcher/provider classpath.

When the provider expects a newer JUnit Platform API than the one effectively loaded, you get exactly this style of failure.

So your test classes were discovered one-by-one in logs, but discovery/execution plumbing failed repeatedly with <code>getAncestors()</code>.

---

## <b>Why Pinning </b><b><code>maven-surefire-plugin</code></b><b> To </b><b><code>3.2.5</code></b><b> Fixed It</b>

You changed root <code>pom.xml</code> by adding:

- <code>plugin.maven-surefire-plugin.version = 3.2.5</code>

<code>3.2.5</code> is compatible with the JUnit Platform level your project is effectively using, so the provider no longer calls an unavailable API method.

Result:

- no more <code>getAncestors()</code> errors
- test discovery works
- tests execute normally

---

## <b>Why The Commands You Re-ran Proved It</b>

You verified with:

- <code>mvn -pl credential-account-api-webservice test</code>→ unit-test phase for that module now runs successfully
- <code>mvn clean install -DskipITs=true</code>→ full reactor (minus integration tests) succeeds end-to-end

That confirms the failure was in test runner compatibility, not app logic or controller mappings.

---

## <b>Long-term Recommendation (Optional)</b>

To avoid this class of issue later, keep these aligned:

- Spring Boot train
- JUnit Jupiter/Platform versions
- Surefire/Failsafe versions

If you want, I can also align <code>maven-failsafe-plugin</code> explicitly to the same compatible line for consistency across UT/IT execution.

## <b>Key point first</b>

<code>spring-boot-dependencies</code> controls <b>project dependencies</b> (things in <code><dependencies></code>).

<code>maven-surefire-plugin</code> is a <b>build plugin</b> (things in <code><build><plugins></code>), and its version is <b>not managed by Spring Boot BOM</b>.

So even if you’re on Spring Boot 2.7, Surefire can still be a different/newer version from parent POM/plugin management.

---

## <b>In your repo, versions came from different places</b>

- <b>JUnit Jupiter/Platform (</b><b><code>5.8.2</code></b><b> / </b><b><code>1.8.2</code></b><b>)</b>
  - came from Spring Boot 2.7 dependency management (via <code>spring-boot-dependencies</code>)
  - visible in dependency tree (<code>junit-jupiter:5.8.2</code>, <code>junit-platform-engine:1.8.2</code>)
- <b>Surefire (</b><b><code>3.5.2</code></b><b>)</b>
  - came from Maven plugin version property/parent plugin management (not Spring BOM)
  - your root <code>pom</code> referenced <code>${plugin.maven-surefire-plugin.version}</code>; it resolved to 3.5.2 before pinning
- You also had plugin-level JUnit engine wiring in Surefire (<code>junit-engine.version</code>), which can further drift from project test deps.

---

## <b>How I knew it was incompatibility</b>

Not by guessing from Spring version alone — from symptoms + controlled reproduction:

1. Error was method-linkage style:
   - <code>TestDescriptor.getAncestors()</code>
   - this usually means runtime API mismatch (caller expects method, loaded class doesn’t have it)
2. Same error repeated across many tests with <code>Tests run: 0</code>
   - discovery/execution infrastructure broken, not one business test failure
3. I changed only Surefire version (to <code>3.2.5</code>) and reran
   - error disappeared
   - tests/build passed

That A/B test confirms the incompatibility in your setup.

---

## <b>Why “both from Spring” assumption felt true but wasn’t</b>

Because Spring Boot <i>does</i> align many libs, but:

- it aligns dependency graph, <b>not necessarily plugin graph</b>
- Maven plugins (Surefire/Failsafe) are a separate resolution universe

So you can have:

- Spring-managed JUnit deps at one level
- plugin/provider stack at another

and they can conflict at runtime.

---

## <b>How to check this yourself next time</b>

Use these quick checks:

- Project test dependency versions:
  - <code>mvn -pl credential-account-api-webservice dependency:tree -Dincludes=org.junit.jupiter,org.junit.platform</code>
- Effective plugin versions:
  - <code>mvn -pl credential-account-api-webservice help:effective-pom</code>
- If discovery crashes, run with debug:
  - <code>mvn -X -pl credential-account-api-webservice test</code>
  - look for Surefire provider + classpath mismatch hints
