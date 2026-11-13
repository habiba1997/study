# Interview self-check: URI design and data structures

Try each question before reading the answer key.

## 1. URI design (select one or more)

Which statements describe good practices for designing resource URIs?

- A. URIs should never be changed.
- B. URIs must be constructed by the client.
- C. URIs should be short in length.
- D. URIs should be case-sensitive.
- E. HTTP verbs should be used instead of operation names in URIs.
- F. Use spaces when designing a URI.
- G. Redirection must be used if a change in URI is required.

**Answer:** A, C, E, G (as design guidelines). Keep published URIs stable where possible; make them concise; use methods such as GET, POST, PUT, PATCH, and DELETE for actions rather than paths such as `/getUsers`; and redirect old URIs when moving resources. A client should follow links supplied by the API rather than invent resource URIs. Avoid case distinctions and spaces in paths. “Never” and “must” are stronger than real-world requirements: sometimes a URI must change, and redirects are appropriate when preserving old links.

## 2. Constant-time removal at both ends (single choice)

Which data structure supports removing an element from either its beginning or its end in O(1) time?

- A. Segment tree
- B. Stack
- C. Deque
- D. Vector

**Answer:** C. Deque. Removing from either end is O(1); removing from the front of an array-backed vector requires shifting elements, O(n). A stack exposes removal at one end.
