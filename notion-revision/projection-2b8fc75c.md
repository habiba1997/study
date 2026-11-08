# Projection

Source: https://app.notion.com/p/2b8fc75cbbd9800b8cb9d098a5fa7000?pvs=204

### <b>The Problem: Loading Too Much Data</b>

```java
@Entity
public class School {
    private Long id;
    private String name;
    private String state;
    private Integer tuition;
    private String description;      // Large text
    private byte[] logo;             // Large binary
    private String courses;          // Large text
    private String faculty;          // Large text
    // ... 30 more fields
}

// ❌ This loads ALL fields (expensive!)
List<School> schools = repository.findAll();

```

### <b>Solution: Projections</b>

<b>Projection</b> = Selecting only the fields you need

```txt
SELECT * FROM school              ❌ Loads everything
SELECT name, state FROM school    ✅ Only what you need

```

### <b>Type 1: Interface-Based Projection</b>

```java
// Define what you want
public interface SchoolSummary {
    String getName();
    String getState();
    Integer getTuition();
}

// Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    List<SchoolSummary> findAllBy();
}

// Usage
List<SchoolSummary> summaries = repository.findAllBy();
for (SchoolSummary summary : summaries) {
    System.out.println(summary.getName());  // Only name, state, tuition loaded!
}

```

<b>Generated SQL:</b>

```sql
SELECT name, state, tuition FROM school;  -- Not SELECT *

```

### <b>Type 2: Class-Based Projection (DTO)</b>

```java
// Define a DTO class
public class SchoolDTO {
    private String name;
    private String state;
    private Integer tuition;

    // Constructor matching the fields
    public SchoolDTO(String name, String state, Integer tuition) {
        this.name = name;
        this.state = state;
        this.tuition = tuition;
    }

    // Getters...
}

// Repository with @Query
public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query("SELECT new com.example.SchoolDTO(s.name, s.state, s.tuition) FROM School s")
    List<SchoolDTO> findAllSummaries();
}

```

### <b>Type 3: Dynamic Projection</b>

```java
// Repository with generic type
public interface SchoolRepository extends JpaRepository<School, Long> {
    <T> List<T> findByState(String state, Class<T> type);
}

// Usage - choose projection at runtime!
List<SchoolSummary> summaries = repository.findByState("MA", SchoolSummary.class);
List<School> fullEntities = repository.findByState("MA", School.class);

```

### <b>Projection with Criteria API</b>

```java
public List<SchoolDTO> getSchoolSummaries() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<SchoolDTO> query = cb.createQuery(SchoolDTO.class);
    Root<School> root = query.from(School.class);

    // ✅ SELECT only what you need and map to DTO
    query.select(
        cb.construct(
            SchoolDTO.class,
            root.get("name"),
            root.get("state"),
            root.get("tuition")
        )
    );

    return em.createQuery(query).getResultList();
}

```

### <b>When to Use Projections</b>

```java
// ❌ Don't need projection - using all fields
public School getSchoolDetails(Long id) {
    return repository.findById(id).orElse(null);
}

// ✅ Use projection - only need summary
public List<SchoolSummary> getSchoolList() {
    return repository.findAllBy();  // Only loads name, state, tuition
}

// ✅ Use projection - list view doesn't need full entity
public Page<SchoolSummary> searchSchools(String name, Pageable pageable) {
    return repository.findByNameContaining(name, SchoolSummary.class, pageable);
}

```
