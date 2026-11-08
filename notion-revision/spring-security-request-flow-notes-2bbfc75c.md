# Spring Security Request Flow — Notes

Source: https://app.notion.com/p/2bbfc75cbbd9809f87c0cd923672cedc?pvs=204

<image source="notion-file-block://2bbfc75c-bbd9-801c-b95d-dc4cd8f76ba2/28a1f7ef-60a8-4b7e-88cb-afe5aabd9ea2?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

- Every incoming HTTP request first passes through <b>Spring Security’s filter chain</b>.
- The chain contains multiple filters (Filter 1, Filter 2, … Filter N).
- Each filter performs a security step (authentication, authorization, CSRF, session checks, etc.).
- If all filters succeed, the request is forwarded to the <b>DispatcherServlet</b>.
- The DispatcherServlet acts as the <b>Front Controller</b>, routing the request to the correct <b>Controller</b>.
- Controllers then handle business logic and return the response.
