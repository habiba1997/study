# Example Matcher

Source: https://app.notion.com/p/2b8fc75cbbd980988d5bf02802c34f19?pvs=204

An <b>ExampleMatcher</b> is used with <b>Query by Example (QBE)</b> to define how objects should be matched when querying a database. It specifies <b>matching rules</b> for fields of an example object.

## <b>What is Query by Example (QBE)?</b>

- QBE allows you to <b>search for entities in the database using an example object</b>, without writing explicit queries.
- You provide a <b>“probe” object</b> (an instance with fields set) and a <b>matcher</b> to define how fields are compared.
- Spring Data translates this into a query automatically.

<p />

<code>ExampleMatcher</code> is a configuration object that defines <b>rules for matching each property of the probe object</b>:

<b>Key Features:</b>

- <b>Exact match</b> (default)
- <b>Ignore case</b> (<code>ignoreCase</code>)
- <b>String matching modes</b>:
  - <code>startsWith</code> – value starts with given string
  - <code>endsWith</code> – value ends with given string
  - <code>contains</code> – value contains given string
- <b>Ignore specific fields</b> (<code>withIgnorePaths</code>)
- <b>Include nulls</b> or ignore them

<b>Example usage (Spring Data JPA):</b>

```java
ExampleMatcher matcher = ExampleMatcher.matching()
    .withIgnorePaths("id")               // ignore id field
    .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
    .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.startsWith());

// ignore id in matching.
// name should contain "habiba", case-insensitive.
// email should start with the given value if set.
// All other fields are matched exactly by default.

User probe = new User();
probe.setName("habiba");
probe.setAge(25);


Example<User> example = Example.of(probe, matcher);

List<User> users = userRepository.findAll(example);
```

| id | name | email | age |
| --- | --- | --- | --- |
| 1 | Habiba | [habiba@example.com](mailto:habiba@example.com) | 25 |
| 2 | Habiba | [h@example.com](mailto:h@example.com) | 25 |
| 3 | Ahmed | [ahmed@example.com](mailto:ahmed@example.com) | 25 |

<p>
 Returns both id 1 and 2 because <code>name</code> contains "habiba" (case-insensitive).
</p>

<p />
