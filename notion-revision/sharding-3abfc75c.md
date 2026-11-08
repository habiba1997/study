# Sharding

Source: https://app.notion.com/p/3abfc75cbbd9802db2d8c523f4674e40?pvs=204

<image source="notion-file-block://3abfc75c-bbd9-8086-9bbc-c7aa223a3872/4b84d52f-a75a-4e8b-accf-7a1f9d97e90a?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

<b>Sharding absolutely exists in SQL databases</b>, although the implementation is often more manual than in MongoDB.

The concepts are the same:

- <b>Replication</b> → copies of the same data (Primary → Replicas)
- <b>Sharding (Horizontal Partitioning)</b> → split the data across multiple servers

For example:

```txt
Shard 1: CustomerID 1 - 1,000,000
Shard 2: CustomerID 1,000,001 - 2,000,000
Shard 3: CustomerID 2,000,001 - 3,000,000
```

instead of

```txt
One huge database
```

---

# SQL sharding

Imagine an <code>Orders</code> table.

Without sharding

```txt
Orders

ID    CustomerID
1     15
2     500
3     1800
4     9000
...
```

After sharding

```txt
DB1
Orders
CustomerID < 1000

DB2
Orders
1000 <= CustomerID < 5000

DB3
Orders
CustomerID >= 5000
```

Each database only stores part of the table.

---

# Who decides which shard?

There are several possibilities.

## 1. Client/Application decides (very common)

The application contains routing logic.

```txt
if(customerId < 1000)
    query DB1
else if(customerId < 5000)
    query DB2
else
    query DB3
```

Many large companies started this way.

Examples:

- Facebook (early)
- Twitter (early)
- Shopify (early)

The application knows where the data lives.

---

## 2. Proxy/router decides

Exactly like the MongoDB diagram.

```txt
Application
      |
   Router
      |
 -----------------------
 |      |        |
DB1    DB2      DB3
```

The application always connects to

```txt
router.company.com
```

The router decides.

Examples

- MongoDB mongos
- Vitess for MySQL
- Citus for PostgreSQL

The application doesn't know the shards exist.

# Who stores where the shards are?

Someone must know.

Usually a metadata/config service.

Like MongoDB:

```txt
Application
      |
    mongos
      |
 Config Servers
      |
Shard locations
```

The config server contains information like

```txt
Users
0-1000
    -> Replica Set A

1000-5000
    -> Replica Set B

5000-max
    -> Replica Set C
```

When a query comes in

```txt
SELECT * FROM Users
WHERE UserID = 3200
```

the router asks

```txt
3200 belongs to which shard?
```

and forwards it.

---

---

# What about the primary?

Each shard is usually its own replicated cluster.

```txt
          Router
             |
------------------------------------
|               |                  |
Shard A       Shard B          Shard C

Primary       Primary          Primary
  |             |                |
Replica       Replica         Replica
Replica       Replica         Replica
```

- Every shard has <b>one primary</b> (leader) for writes.
- Reads may go to the primary or replicas, depending on consistency requirements.
- The router/database sends writes to the appropriate shard's primary and can often route read-only queries to replicas.

### Summary

| Question | Answer |
| --- | --- |
| Can SQL databases be sharded? | Yes. Many large SQL systems use sharding. |
| Who decides the shard? | The application, a routing proxy (e.g., Vitess), or the database itself (e.g., CockroachDB, Spanner). |
| Who tracks shard locations? | A metadata/config service or the distributed database's internal metadata. |
| How are joins handled? | Local joins are fast; cross-shard joins require data movement and are much more expensive. |
| How are aggregations handled? | Each shard computes partial results, and a coordinator merges them into the final result. |
| Where do writes go? | To the primary/leader of the target shard. |
| Why is shard key selection important? | It minimizes cross-shard queries by keeping related data together. |

<p />

<page url="https://app.notion.com/p/3abfc75cbbd980a08469eadf871931ad">
NoSQL systems often denormalize data—to avoid expensive joins, especially across shards:
</page>

# Resharding"

He briefly mentions <b>resharding</b>, which we didn't discuss earlier.

Suppose initially

```txt
Shard A
0-5000

Shard B
5001-10000
```

Traffic grows, so you add another server.

Now you want

```txt
Shard A
0-3000

Shard B
3001-6000

Shard C
6001-10000
```

But data is already stored on A and B.

The system must:

- move millions of rows,
- keep serving requests,
- avoid data loss,
- avoid downtime.

That migration process is called <b>resharding</b>, and it's one of the hardest operational problems in distributed databases.

---

# 6. "Hotspots" (Celebrity Problem)

Another concept he introduces is <b>hotspots</b>.

Suppose you shard users by UserID.

Normally each shard gets similar traffic.

But imagine:

```txt
Taylor Swift
```

or

```txt
Cristiano Ronaldo
```

Their profile gets millions of requests.

If all of those requests go to one shard, that shard becomes overloaded while others are mostly idle.

That's called a <b>hotspot</b> or <b>celebrity problem</b>.

Modern systems may rebalance data or use smarter partitioning to spread that load.

# HOTSPOT

A hotspot happens when <b>one shard receives a disproportionate amount of traffic</b>. There is no single solution—the right approach depends on whether the hotspot is caused by <b>reads</b>, <b>writes</b>, or both.

### 1. Read hotspot (most common)

Example: Cristiano Ronaldo's profile is viewed 10 million times/day.

The data is on one shard, but almost all operations are reads.

Solutions:

- <b>Caching (most common)</b>
  - Put Redis, Memcached, or a CDN in front of the database.
  - Instead of hitting the database millions of times:
    ```txt
    Client
       ↓
     Redis (cache hit)
       ↓
    Database (only when cache misses)
    ```
  - This is the first solution used by companies like Facebook, Twitter/X, and Instagram.
- <b>Read replicas</b>
  - Replicate that shard to multiple read-only replicas.
  - Reads are distributed across replicas.
  - Writes still go to the primary.

```txt
          Primary
          /  |  \
     Replica Replica Replica
```

---

### 2. Write hotspot

Harder problem.

Suppose millions of people are liking Taylor Swift's latest post.

Every "like" updates the same row.

```txt
Post
Likes = 15,432,001
```

Millions of concurrent updates create contention.

Solutions:

#### A. Split the data (logical sharding)

Instead of storing one counter:

```txt
Likes = 15,432,001
```

Store many partial counters.

```txt
Counter 1
Counter 2
Counter 3
...
Counter 100
```

Each write goes to a different counter.

To get the total:

```txt
sum(counter1...counter100)
```

This spreads writes across partitions.

---

#### B. Queue writes

Instead of updating immediately:

```txt
Users
   ↓
Kafka
   ↓
Workers
   ↓
Database
```

Workers batch updates.

Instead of:

```txt
1,000,000 UPDATE statements
```

You might execute

```txt
1,000 batched updates
```

---

#### C. Denormalise

Sometimes the heavily updated piece of data is moved into another table or service that can scale independently.

---

### 3. Re-shard / Split the hot key

Sometimes one user's data becomes too large.

Instead of

```txt
Shard 5
---------
User 123
```

You split it.

```txt
Shard 5
User123-profile

Shard 12
User123-posts

Shard 21
User123-followers

Shard 30
User123-messages
```

Now one celebrity no longer lives entirely on one shard.

This is sometimes called <b>entity splitting</b> or <b>sub-sharding</b>.

---

### 4. Replicate hot data

If everyone is reading Taylor Swift's profile:

Instead of

```txt
Shard 5
Taylor
```

Create copies.

```txt
Shard 5  -> Taylor
Shard 8  -> Taylor
Shard 14 -> Taylor
```

A router chooses one replica for reads.

Writes update the primary, then replicas are synchronised.

---

### 5. Better partitioning

Sometimes the partition key is simply wrong.

Bad:

```txt
partition by country
```

All US users end up together.

Better:

```txt
hash(UserID)
```

Traffic becomes much more evenly distributed.

---

## Which solutions are used most in practice?

| Problem | Common solution |
| --- | --- |
| Read hotspot | Cache (Redis/CDN) ⭐ |
| Heavy reads | Read replicas ⭐ |
| Write hotspot | Queue + batching |
| Single row updated constantly | Distributed/sharded counters |
| One entity too large | Entity splitting (sub-sharding) |
| Poor data distribution | Better shard key / re-sharding |

### Big-picture takeaway

Notice that <b>the shard itself usually doesn't move because one record is popular</b>. Instead, systems try to <b>avoid sending every request to that shard</b>:

- <b>Reads:</b> serve them from caches or replicas.
- <b>Writes:</b> distribute, batch, or redesign how the data is stored.
- <b>If the entity itself is too large:</b> split it across multiple shards or services.

This is why "just add more shards" doesn't solve the celebrity problem—the hash function still maps that celebrity's key to one shard unless you change the architecture.
