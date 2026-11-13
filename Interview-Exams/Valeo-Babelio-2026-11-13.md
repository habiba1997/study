# Valeo/Babelio exam questions and concise answers

Source: screenshots in the local `valexam` folder, reviewed 2026-11-13, plus the deque question recalled in chat. Repeated screenshots of the same prompt are combined. These are **study prompts**, not scored answers or proof of a gap. Some exam wording is imprecise; notes below distinguish a likely exam answer from a general rule.

## Algorithms and problem solving

### 1. FizzBuzz (Java)
**Question:** For each `i` from 1 through `n`, print FizzBuzz for multiples of both 3 and 5, Fizz for 3, Buzz for 5, otherwise the number.

**Answer:** Test the current `i`, with the combined case first:
```java
for (int i = 1; i <= n; i++) {
    if (i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
    else if (i % 3 == 0) System.out.println("Fizz");
    else if (i % 5 == 0) System.out.println("Buzz");
    else System.out.println(i);
}
```
**Why:** `n` is the limit; `i` changes each iteration. The screenshot checks `n` twice and repeats the 3 condition in the Buzz branch. Time O(n), extra space O(1).

### 2. Count substrings without repeated characters
**Question:** Count index-distinct substrings of a lowercase string that have unique characters; example `abac` → 8.

**Answer:** Use a sliding window. For each right endpoint, move `left` past the previous occurrence of that character, then add `right-left+1` to the total.
```text
left = 0; total = 0; last[26] = all -1
for right = 0..length-1:
    c = s[right]
    left = max(left, last[c] + 1)
    total += right - left + 1
    last[c] = right
```
**Why:** Every start within the current window forms one valid substring ending at `right`. O(n) time, O(1) space for 26 letters. The maximum count for length 100,000 exceeds a 32-bit integer; use a 64-bit result if the judge permits it.

### 3. Nested loop with doubling
**Question:** Outer loop from `n/2` to `n`; inner loop doubles `j` from 2 to `n`. Complexity?

**Answer:** O(n log n). **Why:** About n/2 outer iterations and log₂n inner iterations.

### 4. Nested loop with shrinking inner range
**Question:** For each `i=0..n-1`, decrement `j` from `n` while `j>i`. Complexity?

**Answer:** O(n²). **Why:** Iterations sum to n+(n−1)+…+1 = n(n+1)/2.

### 5. Big O
**Question:** What does Big O describe?

**Answer:** An asymptotic upper bound on growth, usually time or space. **Why:** It limits how quickly cost grows as input grows; it is not inherently a best-case guarantee.

### 6. Inorder traversal
**Question:** Find the inorder traversal of the pictured tree.

**Answer:** `ACEDBFHIG`. **Why:** Left subtree `ACEDB`, root `F`, right subtree `HIG`. None of the four displayed options matches this traversal, so the multiple-choice item appears defective.

### 7. Full binary tree leaves
**Question:** A full binary tree has `n` internal nodes. How many leaves?

**Answer:** `n+1`. **Why:** Every internal node has two children, so edges = 2n; also edges = (n+leaves)−1.

### 8. Three-node postorder
**Question:** How many binary trees with three distinct nodes have postorder `A,B,C`?

**Answer:** 5. **Why:** There are five binary-tree shapes with three nodes; each shape has exactly one assignment of these labels in that postorder.

### 9. Broken binary search
**Question:** Which line is wrong in the recursive binary search snippet?

**Answer:** The branch for `arr[mid] > x` (line 8 in the screenshot). It must search `[l, mid-1]`, not `[l, mid+1]`. **Why:** The target can only be left of `mid`. The base condition should also compare `r >= l`; the screenshot appears to use `r >= 1`, so the question may contain more than one defect.

### 10. String construction by append or suffix copy
**Question:** Append one character for 5 points, or copy a substring ending at the current right edge and append it for 5. Minimum cost for `abhihibhihi`?

**Answer:** 30 points (six operations): append `a`, `b`, `h`, `i`; copy suffix `hi`; copy suffix `bhihi`. **Why:** Each copy costs the same as one character. Use prefix dynamic programming to verify the minimum.

### 11. Deque complexity
**Question:** Which of segment tree, stack, deque, vector supports removal at both beginning and end in O(1)?

**Answer:** Deque. **Why:** A double-ended queue supports constant-time removal at both ends; a stack exposes one end, and front removal from a vector shifts elements.

## SQL and data

### 12. SQL versus NoSQL
**Question:** Which listed differences are true?

**Answer:** Choose “SQL databases are table-based, while NoSQL databases include document, key-value, graph, or wide-column stores.” The multi-row transaction/unstructured-document option is a common exam-level generalization, but is **not universal**: SQL systems can store JSON, and some NoSQL systems support transactions. Do not choose the claim that SQL is inherently horizontally scalable while NoSQL is vertically scalable. **Why:** Data model and capability vary by product; scaling direction is not a defining rule.

### 13. Contacted Customer Invoices
**Question:** Return invoice number, customer name, and count of contacts started before invoice creation, only when the invoice creator never contacted that customer. Sort by invoice number.

**Answer (MySQL):**
```sql
SELECT i.invoice_number, c.customer_name,
       COUNT(prior.id) AS invoices_count
FROM invoice AS i
JOIN customer AS c ON c.id = i.customer_id
LEFT JOIN contact AS prior
  ON prior.customer_id = i.customer_id
 AND STR_TO_DATE(prior.contact_start_time, '%c/%e/%Y %l:%i:%s %p')
     < STR_TO_DATE(i.time_issued, '%c/%e/%Y %l:%i:%s %p')
WHERE NOT EXISTS (
  SELECT 1
  FROM contact AS creator_contact
  WHERE creator_contact.customer_id = i.customer_id
    AND creator_contact.user_account_id = i.user_account_id
)
GROUP BY i.id, i.invoice_number, c.customer_name
ORDER BY i.invoice_number;
```
**Why:** `NOT EXISTS` checks “never contacted” across **all** contacts; the left join separately counts earlier contacts, including zero. Filtering a joined row to a different user does not prove the creator never contacted the customer. The screenshot stores times as `varchar`; the conversion format assumes the shown M/D/YYYY h:mm:ss AM/PM data. A real schema should use temporal types. The displayed expected alias `invoices_count` conflicts with the prose’s “number of contacts”; the query follows the prose.

## APIs, architecture, and cloud

### 14. REST basics
**Question:** Which statements about REST client/server roles, resource URI actions, and caching are true?

**Answer:** Client-server separation and using HTTP methods rather than operation names in resource URIs. **Why:** `GET /orders/42` describes a resource and method; HTTP responses can carry caching information such as `Cache-Control` and `ETag`.

### 15. Good URI design
**Question:** Which URI-design statements are true?

**Answer:** Favor short, stable URIs and HTTP methods over operation names. Redirect old URIs when they must change and compatibility matters. **Why:** Clients should follow server-provided links where possible; spaces require encoding, and deliberately case-sensitive paths are harder to use. “Never change” and “redirection must always be used” are too absolute as universal rules, although an exam may expect stability and redirects as best practices.

### 16. The truth about REST
**Question:** Is REST language independent, usable with firewalls and HTTPS, inherently secure, and always lightweight?

**Answer:** Language independent; commonly usable over HTTP(S), including through firewalls that permit it; can use HTTPS. **Why:** REST is an architectural style. Security comes from transport and application controls. “Requests and responses are lightweight” is a common comparison, not a guaranteed property.

### 17. Decorator pattern
**Question:** Which description matches Decorator?

**Answer:** Add functionality to an existing object without changing its structure. **Why:** A wrapper implements the same interface and delegates while adding behavior. The other options describe Composite, Facade, and Flyweight.

### 18. Cloud computing benefits
**Question:** Which listed benefits apply?

**Answer:** All five listed are potential benefits: reduced infrastructure management cost, scalability, collaboration/productivity, backup/storage, and managed updates. **Why:** Cloud services can provide these, but actual cost and responsibility depend on the service and workload.

## HTML, CSS, JavaScript, and OOP

### 19. HTML5 additions
**Question:** Which listed features were introduced with HTML5?

**Answer:** Drag and Drop API, canvas 2D drawing, native timed media (`audio`/`video`), and semantic elements such as `section`, `article`, `footer`. **Why:** These are HTML5-era web platform additions.

### 20. Description list with images
**Question:** Which snippet correctly renders Fruits and Vegetables with image entries?

**Answer:** The option with `<dl>`, `<dt>Fruits</dt>`, `<dd>…Apple…</dd>` and equivalent entries, then `<dt>Vegetables</dt>` and its `<dd>` entries (fourth option). **Why:** `dt` names the term/group, `dd` provides its entries. Prefer CSS for spacing and explicit image width/height; the screenshot’s options omit the stated dimensions.

### 21. `abbr` and `bdo dir="rtl"`
**Question:** Predict output from `<abbr title="Hyper Text Mark Up Language">HTML</abbr>` followed by `<bdo dir="rtl">Learning HTML5 is fun</bdo>`.

**Answer:** Visible abbreviation remains `HTML` (the title is a tooltip); the second line is displayed right-to-left. **Why:** `bdo` changes bidirectional display, not the underlying characters. The screenshot’s plain-text reversed options are an imperfect representation of browser rendering.

### 22. Mailto link
**Question:** Which snippets are valid mailto links?

**Answer:** Both `href="mailTo:..."` and `href="mailto:..."` use the valid case-insensitive `mailto:` scheme (first and third options, assuming the surrounding anchor is complete). **Why:** `mail:` is a different scheme; `<alink=...>` is not valid anchor syntax. Percent-encode query values in production.

### 23. URL and anchor claims that are not true
**Question:** Which statements about URL characters, `rel`, spaces, and `target` are false?

**Answer:** “URL can have only Unicode characters when sent” and “spaces are replaced with `%`” are false. **Why:** URLs are encoded for transport; a space becomes `%20` (or `+` in form query encoding), not a lone percent sign. `rel` describes link relationship. `target="_blank"` requests a new browsing context; `target="new"` names a reusable one.

### 24. OOP concepts
**Question:** Which is not an OOP concept: data hiding, message passing, platform independence, data binding?

**Answer:** Platform independence. **Why:** It concerns runtime portability, not object modeling. “Data binding” is also loose terminology, but platform independence is the clear intended choice.

### 25. CSS selectors
**Question:** Which snippets select child elements?

**Answer:** A direct-child selector such as `table ul > li`; `p:first-child` selects a `p` that is its parent’s first child. `div span` and `div.one span` select descendants at any depth. **Why:** `>` means direct child; a space means descendant. If the exam means any selector that can match child elements, its wording is ambiguous.

### 26. JavaScript input verifier
**Question:** `makeInputVerifier(minimum, maximum)` returns a function that classifies an integer as below, inside (inclusive), or above range.

**Answer:**
```javascript
function makeInputVerifier(minimum, maximum) {
  return function verify(inputValue) {
    if (inputValue < minimum) return "Input is less than minimum value";
    if (inputValue > maximum) return "Input is more than maximum value";
    return "Input is in range";
  };
}
```
**Why:** The returned closure retains `minimum` and `maximum`; checking the two outside cases leaves the inclusive range.
