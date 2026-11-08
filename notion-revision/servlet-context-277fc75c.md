# servlet context

Source: https://app.notion.com/p/277fc75cbbd980ed9b47d94439f68b8b?pvs=204

<image source="notion-file-block://277fc75c-bbd9-80b0-9b98-f4181d59604c/dc67dfad-5323-4826-b6ba-b2e0e581890c?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

Servlet context provides an environment for executing servlets within a servlet container — like in Apache Tomcat — as well as an access to shared resources. When developing a Spring MVC application, we usually don’t use ServletContext as is, but with Spring abstractions — controllers and annotations — @RestController, @GetMapping, @RequestParam, etc. Just because we’re not working with an implicitly declared servlet, doesn’t mean it doesn’t exist. It always comes to any REST controller, and we can address it easily.

Essentially, servlets are objects created by a servlet container, Apache Tomcat. They match the HTTP request and the response from the server. For us, as Java Spring developers, the main objects are HttpServletRequest and HttpServletResponse.

Here’s how it works: the client sends us a request in Tomcat. It generates servlets, which go down the entire chain of blocks in our Spring application — through a chain of filters and a servlet dispatcher, where the target controller for a servlet is determined. An interceptor makes the last modifications and, finally, the servlet reaches the controller, where we extract the DTO requested in the method signature. Then the response goes in reverse order.
