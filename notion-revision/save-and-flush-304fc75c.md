# Save and flush

Source: https://app.notion.com/p/304fc75cbbd980d4a7b0fc62f0a05d7d?pvs=204

Difference is about <b>DB synchronization timing</b>.

### <code>saveOrUpdate(...)</code>

- Attaches entity to Hibernate session
- Executes SQL <b>later</b> (on transaction commit or auto-flush)
- Doesn’t immediately hit the DB

### <code>saveOrUpdateAndFlush(...)</code>

```java
saveOrUpdate(productType);
getCurrentSession().flush();
```

- Persists entity
- <b>Forces immediate SQL execution</b>
- Synchronizes session → DB right away
