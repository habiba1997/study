# Dependencies inside <plugin>

Source: https://app.notion.com/p/2d0fc75cbbd9809bb496d6ee83c38781?pvs=204

These are <b>NOT project dependencies</b>.

### What they are

- Dependencies <b>used by the plugin itself</b>
- Added to the <b>plugin’s classpath</b>
- Do <b>not</b> go into your app jar

---

### Why they exist

- <u>Extend plugin behavior</u>
- <u>Fix plugin compatibility</u>
  - Force a specific tool version

---

### Example

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-surefire-plugin</artifactId>
		<dependencies>
			<dependency>
				<groupId>org.junit.platform</groupId>
				<artifactId>junit-platform-launcher</artifactId>
				<version>1.10.0</version>
			</dependency>
		</dependencies>
</plugin>
```

- Affects <b>only Surefire</b>
- Does <b>not</b> add JUnit to your app

---

## <b>What are Maven profiles</b>

Profiles = <b>conditional configuration</b>.

They let you change:

- Plugins
- Dependencies
- Properties

Based on:

- Environment
- Command line
- OS
- Java version

---

## 4. Simple profile example

```xml
<profiles>
	<profile>
		<id>coverage</id>
		<properties>
			<lineCoverage>0.80</lineCoverage>
		</properties>
	</profile>
</profiles>


```

Activate with:

```txt
mvn clean install -Pcoverage

```

---

## 5. Why profiles are used (real cases)

### a) CI vs local

- Local: no coverage check
- CI: strict coverage

### b) Dev vs prod

- Extra logging in dev
- Optimized build in prod

### c) Optional tools

- Run Sonar only sometimes
- Run JaCoCo only in C

<p />
