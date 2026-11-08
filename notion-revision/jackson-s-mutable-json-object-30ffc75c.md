# Jackson's mutable JSON object

Source: https://app.notion.com/p/30ffc75cbbd9803298fddef9ad3248f3?pvs=204

<br /><br /><code>ObjectNode = Jackson's mutable JSON object; we convert the DTO to JSON so we can read/write fields generically</code>

<p />

<br /><br /><code>objectNode.set(memberProductIdsField, objectMapper.valueToTree(ids));</code>

valueToTree is a Jackson ObjectMapper method that turns a Java object into a JsonNode tree without writing JSON bytes.

- <b>Input</b>: any Java object (here Set\<Integer> ids, e.g. \[1, 2, 3\])
- <b>Output</b>: a JsonNode tree (here an ArrayNode, which represents a JSON array)
- <b>Effect</b>: it serializes the Java value to an in-memory tree representation

<b>Why it’s used here</b>

objectNode.set(field, value) expects the value to be a JsonNode. ids is a Set\<Integer>, so it must be converted first:

- objectMapper.valueToTree(ids) converts Set\<Integer> → ArrayNode (e.g. \[1, 2, 3\])
- objectNode.set("memberProductIds", thatArrayNode) then writes that array into the JSON object at that field

<b>In short</b>

valueToTree means: “turn this Java object into a JSON tree (JsonNode) in memory to be saved in object node
