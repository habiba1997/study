# How do MongoDB, Redis, Cassandra, and DynamoDB differ?

Source: https://app.notion.com/p/3affc75cbbd9804b9a8ae24bf4d52d71?pvs=204

| Database | Model | Best for |
| --- | --- | --- |
| <b>MongoDB</b> | Document | Flexible JSON documents |
| <b>Redis</b> | Key-Value (lives in-memory not disk - single threaded) | Cache, sessions, counters, queues |
| <b>Cassandra</b> | Wide-column | Huge write-heavy systems, global distribution |
| <b>DynamoDB</b> | Key-Value / Document | Fully managed AWS applications |

## Redis

Key value pair. Everything lives in RAM.

```txt
user:15
↓

{
 name
 age
}
```

Very fast (microseconds).

# Cassandra (Wide Column)

Suppose we're storing user orders.

Instead of this SQL table

| UserID | OrderID | Product | Price |
| --- | --- | --- | --- |
| 1 | 101 | Laptop | 1000 |
| 1 | 102 | Mouse | 30 |
| 2 | 201 | Keyboard | 50 |

Cassandra thinks about it like this:

```txt
Partition Key = UserID

User 1
-----------------------------
OrderID    Product    Price
101        Laptop     1000
102        Mouse      30

User 2
-----------------------------
OrderID    Product    Price
201        Keyboard   50
```

Notice what's happening.

Each <b>UserID</b> becomes a partition.

Inside that partition are many rows.

---

## Physically

Imagine three nodes.

```txt
Node A

User 1
Orders...

User 2
Orders...
```

```txt
Node B

User 3
Orders...

User 4
Orders...
```

```txt
Node C

User 5
Orders...

User 6
Orders...
```

A hash function decides

```txt
hash(UserID)
        ↓
Node B
```

just like sharding.

---

# Another example: Twitter

Instead of

```txt
Tweets

TweetID
UserID
TextDate
```

Cassandra stores

```txt
Partition Key

UserID = 15

---------------------------------

2026-01-01
Tweet...

2026-01-02
Tweet...

2026-01-03
Tweet...
```

All tweets for one user live together.

Getting someone's timeline becomes

```txt
Find partition 15

↓

Return rows
```

Very fast.

---

# Why is it called "wide-column"?

Unlike SQL, every partition can contain <b>thousands or millions of rows</b>.

Example

```txt
Partition

UserID = 15

-----------------------------------

Tweet1

Tweet2

Tweet3

...

Tweet1,000,000
```

One partition can be enormous.

---

# Another mental model

Think of it as

```txt
Map

Key
↓

Collection of rows
```

instead of

```txt
Map

Key
↓

Single value
```

Redis

```txt
Key
↓

One object
```

Cassandra

```txt
Key
↓

Entire table section
```

# What is DynamoDB?

DynamoDB is Amazon's managed NoSQL database.

Think of it as:

> <b>A massive distributed key-value/document database where AWS handles all the servers.</b>

You never create servers.

You never configure replication.

You never configure sharding.

AWS does everything.

# Are CockroachDB, Google Spanner, TiDB, YugabyteDB, and SingleStore NoSQL?

This is where terminology gets confusing.

Strictly speaking:

<b>No.</b>

They are usually called <b>Distributed SQL databases</b> (also called NewSQL).

They combine:

- SQL
- ACID transactions
- automatic sharding
- replication
- horizontal scaling

Think of them as:

```txt
Traditional SQL

        +

NoSQL scalability
```

---

For example,

CockroachDB lets you write

```txt
SELECT*FROM OrdersWHERE customer_id=15;
```

Exactly like PostgreSQL.

But internally

```txt
Client

↓

Cockroach

↓

Shard A
Shard B
Shard C
```

It automatically routes the query.

You don't worry about shards.

## Think of the evolution like this

```txt
1970s

MySQL
PostgreSQL
Oracle

↓

2005

MongoDB
Cassandra
Redis
DynamoDB

↓

2015+

CockroachDB
Google Spanner
TiDB
YugabyteDB
SingleStore
```

The newest generation tries to give you the <b>best of both worlds</b>:

- the familiar SQL programming model,
- with the automatic scaling and replication that made NoSQL popular.

## A quick comparison

| Database | Think of it as | Data shape |
| --- | --- | --- |
| <b>Redis</b> | Dictionary | <code>Key → Value</code> |
| <b>MongoDB</b> | Folder of JSON files | <code>Document</code> |
| <b>Cassandra</b> | Dictionary where each key points to an entire mini-table | <code>Partition Key → Many Rows</code> |
| <b>MySQL/PostgreSQL</b> | Tables with relationships | Fully relational |
