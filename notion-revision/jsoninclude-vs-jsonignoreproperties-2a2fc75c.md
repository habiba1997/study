# @JsonInclude Vs @JsonIgnoreProperties

Source: https://app.notion.com/p/2a2fc75cbbd98024a059d4d99386fea6?pvs=204

### <code>@JsonInclude(Include.NON_NULL)</code>

<b>From:</b> <code>com.fasterxml.jackson.annotation.JsonInclude</code>

Tells Jackson (the JSON library used by Spring Boot) <b>to exclude fields with </b><b><code>null</code></b><b> values</b> when serializing an object to JSON.

<b>Example:</b>

```java
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String name;
    private String email; // can be null
}
User user = new User();
user.setName("Habiba");
```

```json
{
  "name": "Habiba"
}
```

---

### 🧩 <code>@JsonIgnoreProperties(ignoreUnknown = true)</code>

<b>From:</b> <code>com.fasterxml.jackson.annotation.JsonIgnoreProperties</code>

Instructs Jackson to <b>ignore any extra JSON properties</b> that don’t exist in the Java class during deserialization (when converting JSON → Java object).

<b>Example:</b>

```java
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
}


```

If the API receives:

```json
{
  "name": "Habiba",
  "extra": "value"
}
```

Jackson <b>won’t fail</b> even though <code>extra</code> isn’t in the class. It will just ignore it and create:

```java
User{name="Habiba"}
```
