# Hibernate Dialect

Source: https://app.notion.com/p/2ddfc75cbbd980d89c78c6a86c71d827?pvs=204

A <b>Hibernate Dialect</b> is basically Hibernate’s <b>translation layer</b> between <b>its SQL generation</b> and the <b>specific database you are using</b>.

<b>Purpose</b>

- Hibernate is database-agnostic, but different databases have different SQL syntax, functions, and features.
- The <b>dialect tells Hibernate</b> how to generate SQL that your DB understands.

<b>What it does</b>

1. Knows <b>SQL differences</b>:
   - Postgres: <code>SERIAL</code>, <code>ILIKE</code>, <code>LIMIT/OFFSET</code>
   - MySQL: <code>AUTO_INCREMENT</code>, <code>LIKE</code>, <code>LIMIT</code>
   - Oracle: <code>ROWNUM</code>, sequences
2. Knows <b>functions</b> your DB supports:
   - <code>concat()</code>, <code>current_date</code>, <code>substring()</code>, etc.
   - You can register <b>custom functions</b> like <code>fts_match</code>.
3. Knows <b>types mapping</b>:
   - Java types → SQL types (<code>String</code> → <code>VARCHAR</code>, <code>boolean</code> → <code>BOOLEAN</code>)

<b>Example</b>

```java
PostgreSQLDialectdialect=newPostgreSQLDialect();
dialect.registerFunction("fts_match","?1 @@ plainto_tsquery(?2)", StandardBasicTypes.BOOLEAN);


```

- Tells Hibernate: “When someone calls <code>fts_match(col, val)</code>, generate this Postgres SQL.”

<b>Why it matters</b>

- Without the correct dialect, Hibernate may:
  - Generate invalid SQL
  - Fail to recognize DB-specific functions
  - Misinterpret types

<b>Analogy:</b>

Hibernate = <b>translator</b>, Dialect = <b>language guide</b> for a specific database.
