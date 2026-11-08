# Criteria Api (JPA)

Source: https://app.notion.com/p/2b8fc75cbbd9804abc1ed93ed70d0eda?pvs=204

### <b>What Is It?</b>

The <b>Criteria API</b> is Java's way of building database queries <b>programmatically</b> using objects instead of strings.

Think of it like this:

```txt
String SQL → Type-Safe Java Objects → Same SQL (but safer!)

```

### <b>The Building Blocks</b>

```java
// 1️⃣ CriteriaBuilder (cb)
// Your "SQL function toolbox" - has methods for =, <, >, LIKE, etc.
CriteriaBuilder cb = entityManager.getCriteriaBuilder();

// 2️⃣ CriteriaQuery<T>
// The SELECT statement (return object, selected object)
CriteriaQuery<School> query = cb.createQuery(School.class);

// 3️⃣ Root<T>
// The FROM clause - which table you're querying
Root<School> school = query.from(School.class);

// 4️⃣ Predicate
// The WHERE conditions
Predicate namePredicate = cb.equal(school.get("name"), "Harvard");
Predicate statePredicate = cb.equal(school.get("state"), "MA");

// 5️⃣ Combining everything
query.where(cb.and(namePredicate, statePredicate));

```

### <b>Simple Example: Find Schools by State</b>

```java
public List<School> findSchoolsByState(String state) {
    // Step 1: Get the builder
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();

    // Step 2: Create the query
    CriteriaQuery<School> query = cb.createQuery(School.class);

    // Step 3: Define the FROM clause
    Root<School> school = query.from(School.class);

    // Step 4: Add WHERE clause
    Predicate statePredicate = cb.equal(school.get("state"), state);
    query.where(statePredicate);

    // Step 5: Execute
    return entityManager.createQuery(query).getResultList();
}

```

<b>This generates:</b>

```sql
SELECT * FROM school WHERE state = 'MA';

```

### <b>Example 2: Multiple Conditions</b>

```java
public List<School> searchSchools(String name, String state, Integer minTuition) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<School> query = cb.createQuery(School.class);
    Root<School> school = query.from(School.class);

    // Collect all conditions in a list
    List<Predicate> predicates = new ArrayList<>();

    // Add name filter (partial match)
    if (name != null && !name.isEmpty()) {
        predicates.add(
            cb.like(
                cb.lower(school.get("name")),           // LOWER(name)
                "%" + name.toLowerCase() + "%"          // LIKE '%harvard%'
            )
        );
    }

    // Add state filter (exact match)
    if (state != null) {
        predicates.add(
            cb.equal(school.get("state"), state)        // state = 'MA'
        );
    }

    // Add tuition filter (greater than or equal)
    if (minTuition != null) {
        predicates.add(
            cb.ge(school.get("tuition"), minTuition)    // tuition >= 30000
        );
    }

    // Combine all with AND
    query.where(predicates.toArray(new Predicate[0]));

    return entityManager.createQuery(query).getResultList();
}

```

<b>This generates:</b>

```sql
SELECT * FROM school
WHERE LOWER(name) LIKE '%harvard%'
  AND state = 'MA'
  AND tuition >= 30000;

```

### <b>Common CriteriaBuilder Methods</b>

```java
// Comparison operators
cb.equal(x, y)              // x = y
cb.notEqual(x, y)           // x != y
cb.gt(x, y)                 // x > y  (greater than)
cb.ge(x, y)                 // x >= y (greater or equal)
cb.lt(x, y)                 // x < y  (less than)
cb.le(x, y)                 // x <= y (less or equal)

// String operations
cb.like(x, pattern)         // x LIKE pattern
cb.lower(x)                 // LOWER(x)
cb.upper(x)                 // UPPER(x)

// Logic operators
cb.and(p1, p2)              // p1 AND p2
cb.or(p1, p2)               // p1 OR p2
cb.not(p)                   // NOT p

// Null checks
cb.isNull(x)                // x IS NULL
cb.isNotNull(x)             // x IS NOT NULL

// Range
cb.between(x, min, max)     // x BETWEEN min AND max

// Math
cb.sum(x, y)                // x + y
cb.diff(x, y)               // x - y
cb.prod(x, y)               // x * y
cb.quot(x, y)               // x / y

```

### <b>Aliases (</b>Create Hibernate Aliases (JOINs))

<code>associations.forEach(association -> criteria.createAlias(association, association));</code>

<b>What it does:</b>

- For each association name found
- Creates a <b>Hibernate alias</b> = SQL JOIN

```java
-- Original: (no joins)
SELECT * FROM member_product_rule

-- After createAlias("memberProducts", "memberProducts"):
SELECT * FROM member_product_rule
LEFT JOIN member_products AS memberProducts 
    ON member_product_rule.id = memberProducts.rule_fk

-- After createAlias("productType", "productType"):
SELECT * FROM member_product_rule
LEFT JOIN member_products AS memberProducts ON ...
LEFT JOIN product_type AS productType ON ...
```
