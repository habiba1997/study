# Java Interview notes

Source: https://app.notion.com/p/3b2fc75cbbd98058a31be09c8dd4baa3?pvs=204

<p>
I've had good years experience at my current company and have learned a lot but I feel I've reached a point where I'm looking for new technical challenges and opportunities to continue growing. 
</p>

## What is an Anonymous Class in Java?

An <b>anonymous class</b> is a class <b>without a name</b> that is declared and instantiated in a single expression. It's typically used when you need a one-time implementation of an interface or subclass.

### Example: Implementing an interface

```txt
Runnable task = new Runnable() { //new Runnable(){..} creates an anonymous class
    @Override
    public void run() {
        System.out.println("Running...");
    }
};

task.run();
```

- Short-lived implementations.
- Event listeners.
- commonly used before java 8

## What does <code>@ResponseBody</code> do in Spring?

<code>@ResponseBody</code> tells Spring:

> <b>"Don't look for a view (HTML/JSP). Take the return value of this method and write it directly into the HTTP response body."</b>

### Without <code>@ResponseBody</code>

```java
@Controller
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
```

Spring interprets <code>"hello"</code> as the <b>name of a view</b> (e.g., <code>hello.html</code> or <code>hello.jsp</code>).

### With <code>@ResponseBody</code>

```txt
@ControllerpublicclassUserController {

    @GetMapping("/hello")
    @ResponseBodypublicStringhello() {return"Hello World";
    }
}
// HTTP Response:
// Hello World
```

Spring writes the string directly to the response body.

---

### Returning an object

```java
@GetMapping("/user")
@ResponseBody
public User getUser() {
    return new User("Habiba", 25);
}
```

<b><u>Spring uses an </u></b><b><u><code>HttpMessageConverter</code></u></b><b><u> (typically Jackson) to convert the object to JSON.<br /></u></b>

## <code>@RestController</code> vs <code>@Controller</code>

These are equivalent:

```txt
@RestController
```

is simply shorthand for:

```txt
@Controller
@ResponseBody
```

<u>So in REST APIs, you almost always use </u><u><code>@RestController</code></u><u>, while </u><u><code>@ResponseBody</code></u><u> is useful when only specific methods in a </u><u><code>@Controller</code></u><u> should return data directly instead of rendering a view.</u>

<p />

# <b>When overriding a method, you can make the access modifier more visible, but not less visible.</b>

### Visibility order (least → most visible)

```txt
private → package-private (default for method) → protected → public
```

### ✅ Allowed (increase visibility)

```java
class Parent {
    void test() {}   // package-private
}

class Child extends Parent {
    @Override
    protected void test() {}   // ✅ OK
}
```

The compiler error is typically:

> <code>Cannot reduce the visibility of the inherited method</code>

<h3>
Switch Statement 
</h3>

The <code>default</code> case is <b>optional</b>.

The break statement, at the end of each case block, is optional.

The switch expression evaluates to <b>one value</b>, not a collection.<br />A <code>switch</code> needs to know <b>all possible case labels when the code is compiled</b>, not when it is running.

### ✅ Valid (compile-time constant)

```txt
switch (x) {
    case 1:
        break;
    case 2:
        break;
}
```

The compiler already knows the values <code>1</code> and <code>2</code>.

Or:

```java
final String s = "ABC";

switch (str) {
    case "ABC":
    case s:      // ✅ OK
}
```

Because <code>s</code> is a <b>compile-time constant</b>.

---

### ❌ Invalid (runtime value)

```txt
String s = "ABC";

switch (str) {
    case s:      // ❌ Compile error
}
```

Why?

Because <code>s</code> is a <b>variable</b>. Even though it currently contains <code>"ABC"</code>, Java treats it as something that <b>could change while the program runs</b>.

The compiler says:

> "I don't allow variables here. I need a constant."

---

### Easy rule for exams

✅ Allowed:

```txt
case 10:
case 'A':
case "Hello":
case MY_FINAL_CONSTANT:
```

## Which of the following is not a common way to configure a Spring Boot application?

Spring Boot avoids <code>web.xml</code> and favors <b><code>application.properties</code></b>, <b><code>application.yml</code></b>, and Java-based configuration (e.g., <code>@Configuration</code>).

### <code>@MockBean</code>

<b>It adds a mock implementation of a bean to the application context.</b>

It replaces the real Spring bean with a Mockito mock during tests.

### <code>application.properties</code> / <code>application.yml</code>

<b> It is used to define Spring-specific configuration properties.</b>

<i><u>It stores application configuration</u></i><i> </i>(ports, DB URL, logging, etc.).

---

### 4. <code>@SpringBootApplication</code>

Combines <code>@Configuration</code>, <code>@EnableAutoConfiguration</code>, and <code>@ComponentScan</code>.

Automatically configures the application based on dependencies (<code>@EnableAutoConfiguration</code>) → meaning <b>Spring Boot creates and configures beans for you based on the libraries (dependencies) in your project.</b>

### Example 1: Spring Web

You add this dependency:

```txt
<dependency><artifactId>spring-boot-starter-web</artifactId></dependency>
```

Spring Boot automatically:

- Starts an embedded Tomcat server.
- Configures Spring MVC.
- Sets up Jackson for JSON.

You don't have to configure them manually.

---

### <code>@Conditional</code>

<b> It allows you to conditionally include or exclude a configuration class or bean.</b>

<b>Example:</b>

```java
@Bean
@Conditional(MyCondition.class)
MyService myService() {
    return new MyService();
}
```

The bean is created <b>only if</b> <code>MyCondition</code> evaluates to <code>true</code>

---

### 7. <code>@DataJpaTest</code>

<b>It provides a test slice that focuses only on JPA components.</b>

<b>Why:</b> It loads repositories, entities, and an in-memory database by default, not the whole application.

---

### 8. <code>final</code> keyword

- Final variable → constant
- Final class → cannot be inherited
- Final method → cannot be overridden

---

### 9. <code>@PathVariable</code>

<b> It binds a method parameter to a URI template variable.</b>

Example:

```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id) { }
```

For <code>/users/10</code>, <code>id = 10</code>.

Which access modifier allows a class, method, or variable to be accessed only within the same package?

<b>Answer:</b> ✅ <b>D. default</b>
