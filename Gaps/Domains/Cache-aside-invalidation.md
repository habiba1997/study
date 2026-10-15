# Cache-aside and invalidation timing

_2026-10-15: clarification needed; no score assigned._

Initial question omitted the cache-aside assumption. Habiba interpreted invalidating a cache entry as deleting the customer and assumed a GET could not return a customer still in DB. Explain: a cache miss triggers a DB read, then caches the result. Invalidation removes only the cached copy.

Race to revisit: Redis deleted before DB commit; GET reads old committed DB data and caches it; writer commits new data; cache remains old. Invalidation after commit closes this particular race, but is not a universal guarantee: in-flight stale readers and failed invalidations still need handling (e.g. versions, reliable event delivery, TTL according to freshness requirements).

Recall later: what does a cache-aside GET do on a cache miss?
