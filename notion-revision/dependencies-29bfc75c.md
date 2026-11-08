# Dependencies

Source: https://app.notion.com/p/29bfc75cbbd980c9a54de62978c829b8?pvs=204

### <b>Apache Velocity</b>, a <b>Java-based template engine</b>

```javascript
<dependency>
   <groupId>org.apache.velocity</groupId>
   <artifactId>velocity</artifactId>
</dependency>
```

<b>Purpose:</b> It lets you generate text (HTML, emails, source code, configs, etc.) by merging a <b>template</b> with <b>data (context variables)</b>.

```javascript
VelocityContext context = new VelocityContext();
context.put("name", "Habiba");
StringWriter writer = new StringWriter();
Velocity.evaluate(context, writer, "templateName", "Hello $name!");
System.out.println(writer.toString()); // → "Hello Habiba!"
```

✅ Common uses:

- Rendering dynamic emails or reports
- Generating files or documentation
- Template-based code generation
