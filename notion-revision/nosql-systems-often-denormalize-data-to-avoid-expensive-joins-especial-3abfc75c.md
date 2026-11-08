# NoSQL systems often denormalize data—to avoid expensive joins, especially across shards:

Source: https://app.notion.com/p/3abfc75cbbd980a08469eadf871931ad?pvs=204

## Normalized

Customer table

| CustomerID | Name |
| --- | --- |
| 5 | Habiba |

Reservation table

| ReservationID | CustomerID |
| --- | --- |
| 10 | 5 |

To show the reservation

```txt
Reservation 10
Customer: Habiba
```

the database performs

```txt
SELECT*FROM Reservation rJOIN Customer cON r.CustomerID=c.CustomerID
```

Advantages:

✅ No duplicate data

If Habiba changes her name

```txt
Habiba
↓

Habiba Ahmed
```

Only one row changes.

The instructor explains these benefits.

---

## Denormalized

Instead store

Reservation

| ReservationID | CustomerName |
| --- | --- |
| 10 | Habiba |

Now one query

```txt
SELECT*FROM ReservationWHERE ReservationID=10
```

returns everything.

→ denormalization makes writes harder and increases storage.

→ Suppose Habiba changes her phone number. Instead of updating one table row , you will update may be thousands of reservations

→ suppose customers are in Shard 1 and Reservations in Shard 3. Now a JOIN needs Shard 1 \| \| Shard 3 → Network communication. Instead Reservation CustomerName Phone Email Time when all in one shard →  Everything is already together. One shard. One lookup. That's much faster.

→ "Fake a join”:  Instead of <code>SELECT*FROM OrdersJOIN Customers</code> your application does:  <code>Get Order 123</code>  → CustomerID = 55 → then <code>Get Customer 55</code>

The application combines them.So instead of one SQL JOIN, you perform two simple key-value lookups.

Distributed databases optimize for this pattern because key lookups are much easier to route to a single shard.
