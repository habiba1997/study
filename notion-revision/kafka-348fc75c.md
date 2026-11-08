# Kafka

Source: https://app.notion.com/p/348fc75cbbd980509330d399242658a7?pvs=204

### 1) High throughput (simple)

It means: <b>how much data the system can handle per second</b>

- Low throughput → 100 messages/sec
- High throughput → <b>millions of messages/sec</b>

<b>Kafka is built to handle huge volumes continuously</b> without slowing down.

---

### 2) Immutable log (key idea you’re missing)

Kafka is not really a “queue” internally.

Think of it like:

```txt
[ msg1 ][ msg2 ][ msg3 ][ msg4 ] ...
```

- Messages are <b>only appended (added at the end)</b>
- <b>Never updated or deleted immediately</b>
- Each message has a <b>position (offset)</b>

So:

- Consumers don’t “take” messages
- They just say: <i>“I am at offset 120, give me next”</i>

👉 That’s why:

- You can <b>re-read messages</b>
- Multiple consumers can read the same data independently

### 3) Real difference Kafka VS MessageQ(usage mindset)

### RabbitMQ (Queue mindset)

- Message = <b>task</b>
- Once processed → gone
- Goal: <b>do work reliably</b>

### Kafka (Stream mindset)

- Message = <b>event/history</b>
- Stored for some time
- Goal: <b>track and process data streams</b>

### When to use each (real examples)

### ✅ Use RabbitMQ when:

You have <b>tasks/jobs</b>

Examples:

- Send email after signup
- Process payment
- Generate PDF
- Resize image after upload

Flow:

```txt
User action → send message → worker picks it → done → message gone
```

👉 You care about:

- Reliability
- Task execution
- Not reprocessing

---

### ✅ Use Kafka when:

You have <b>continuous data streams</b>

Examples:

- User activity tracking (clicks, views)
- Logs collection
- Real-time analytics
- Event-driven systems (microservices)

Flow:

```txt
Service → publish event → many systems consume it
```

Example:

- User clicks button
  - Analytics service reads it
  - Recommendation system reads it
  - Logging system reads it

👉 Same event → <b>multiple consumers</b>
