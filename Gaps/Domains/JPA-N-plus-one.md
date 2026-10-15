# JPA N+1 fetching — domain gap

_Observed 2026-10-15._

Habiba correctly recognized ~101 queries for 100 orders as N+1, but proposed making the association eager and assumed this guarantees a single query. Eager fetching controls when related data is loaded, not necessarily how many SQL statements are issued. For a specific endpoint, select a fetch join, entity graph, DTO projection, or batching according to the data shape and pagination needs; inspect generated SQL.

Retest later: For a paginated order list needing customer names, how would you avoid N+1 without fetching every relationship everywhere?
