# Hotspot Vs Kafka Design

Source: https://app.notion.com/p/3affc75cbbd980ef9a2edd9de2cdbad3?pvs=204

that is exactly one of the patterns large systems use. The important distinction is that <b>the database is no longer on the critical path for every event</b>.

For a viral YouTube video, imagine 10 million people watching in an hour.

If every view did this:

```txt
User
  ↓
UPDATE videos
SET views = views + 1
WHERE id = 123;
```

then millions of users would be trying to update the <b>same row</b>, causing a write hotspot.

Instead, the architecture is more like this:

```txt
                 +----------------------+
User watches --->| API Server           |
                 +----------+-----------+
                            |
                            | Publish event
                            v
                      Kafka Topic
                    (video-events)
                            |
          +-----------------+-----------------+
          |                 |                 |
          v                 v                 v
     Analytics         Recommendation     Counter Service
       Service             Service
                                |
                                | Aggregate events
                                v
                           Database
```

### The Counter Service

Instead of updating the database for every view:

```txt
View 1  ---> Kafka
View 2  ---> Kafka
View 3  ---> Kafka
...
View 1000 ---> Kafka
```

The consumer keeps track:

```txt
video123 += 1000 views
```

Then every second (or every few seconds):

```txt
UPDATE videosSET views= views+1000WHERE id=123;
```

Now you've reduced:

- ❌ 1000 database writes
- ✅ 1 database write

---

### Even better: Redis + Kafka

Many companies use something like:

```txt
User
   ↓
Kafka
   ↓
Counter Consumer
   ↓
Redis Counter
```

Redis becomes:

```txt
video123 = 12,345,678 views
```

Every few seconds or minute:

```txt
Redis
   ↓
Flush
   ↓
MySQL/Cassandra
```

The user sees the Redis count immediately, while the database is updated asynchronously.

---

### What about likes?

Exactly the same idea.

```txt
Like button
      ↓
API
      ↓
Kafka
      ↓
Like Consumer
      ↓
Redis Counter
      ↓
Database (periodically)
```

---

### But what if the app crashes before writing to the database?

That's why Kafka is used.

Kafka <b>durably stores every event</b>:

```txt
View Event 1
View Event 2
View Event 3
...
```

If the consumer crashes after processing only 500 events, when it restarts it resumes from the last committed offset and continues processing the remaining events. The events aren't lost.

---

### In reality (YouTube, TikTok, Instagram)

A view event usually doesn't go only to a counter. It fans out to multiple consumers:

```txt
             View Event
                 |
              Kafka
   +--------+--------+--------+--------+
   |        |        |        |
Counter  Analytics  ML Rec.  Fraud Detection
Service   Service    Service      Service
```

The <b>Counter Service</b> updates view/like counts, while the other services use the same event for analytics, recommendations, and spam detection.

This event-driven approach both <b>eliminates the write hotspot</b> and lets many independent services react to the same user action without the API needing to call each one synchronously.
