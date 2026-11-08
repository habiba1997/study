# HttpStatus Vs HttpStatusCode

Source: https://app.notion.com/p/2ddfc75cbbd980c08303fe4de2ca512d?pvs=204

<b>Spring 2.x</b>

- <code>getStatusCode()</code> → returns <code>HttpStatus</code> (enum)
- You can safely do:
  ```java
  response.getStatusCode() == HttpStatus.OK
  ```

<b>Spring 3.x (Spring Framework 6 / Boot 3)</b>

- <code>getStatusCode()</code> → returns <code>HttpStatusCode</code> (interface)
- <code>HttpStatus</code> <b>implements</b> <code>HttpStatusCode</code>, but the runtime type is not guaranteed to be <code>HttpStatus</code>
- Direct enum comparison may fail or be invalid:
  ```java
  response.getStatusCode().equals(HttpStatus.OK)// not safe
  ```

<b>Why this change</b>

- Supports <b>non-standard / custom HTTP status codes</b>
- Decouples framework code from the <code>HttpStatus</code> enum
- Improves forward compatibility

<b>Correct approach (both versions)</b>

```java
response.getStatusCode().is2xxSuccessful()
```

<b>If you strictly need 200 only</b>

```java
response.getStatusCode().value() ==200

```
