# Data Encoding

Source: https://app.notion.com/p/350fc75cbbd9803a82e3f6b46ca6e217?pvs=204

- <b>Text (JSON/XML)</b>: human-readable, large, slow
- <b>Binary (MessagePack, Protobuf, etc.)</b>: compact, fast, not human-readable

<image source="notion-file-block://350fc75c-bbd9-8084-8568-c2dc7d3772df/c1fddf4b-c3f6-4b49-b819-9d67dd43d9a8?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

## MessagePack encoding

- Schema-less (like JSON)
- Encodes structure inline (keys + values every time)
- Pros: simple, flexible
- Cons: repeated field names → slightly larger than schema-based formats
- JSON → compact <b>binary format</b>
- Each value is encoded as:
  - <b>type byte</b> (what it is: string, int, array…)
  - <b>length/count</b> (if needed)
  - <b>raw bytes</b>
- Example:
  - <code>"userName"</code> → <code>a8</code> (string length 8) + bytes of chars
  - <code>1337</code> → <code>cd</code> (uint16) + <code>05 39</code>
  - array → <code>92</code> (array of 2 items)
- Result: <b>smaller + faster to parse than JSON</b> (no text parsing)

## Schema-based formats

### 1. Protocol Buffers (Protobuf)

- Requires <b>.proto schema</b>
- Fields encoded as: <b>field\_number + type + value</b>
- Example: <code>1: "Martin"</code> instead of <code>"userName": "Martin"</code>
- Pros:
  - very compact (no field names)
  - fast
  - strongly typed
- Cons:
  - needs schema management<br />

# What is Avro / Thrift / Protobuf (simple classification)

These are all:

> “Data format + schema definition tools for communication or storage”

---

## Think of them like this:

| Tool | Purpose | Used in |
| --- | --- | --- |
| Protobuf | service communication | gRPC / microservices |
| Avro | data streaming | Kafka pipelines |
| Thrift | RPC system (old style) | legacy distributed systems |

## Quick comparison

| Feature | MessagePack | Protobuf | Thrift | Avro |
| --- | --- | --- | --- | --- |
| Schema | ❌ No | ✅ Required | ✅ Required | ✅ Required |
| Size | Medium | Small | Small | Small |
| Speed | Fast | Very fast | Very fast | Fast |
| Field names | Stored | Not stored | Not stored | Not stored |
| Best use | Simple APIs | Microservices | RPC systems | Data pipelines |

---

## 
