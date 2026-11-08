# System Design

Source: https://app.notion.com/p/2ecfc75cbbd980baa783e6a00bd7f81d?pvs=204

## Scalability Patterns

1\. Queue-Based Load Leveling

Instead of services directly calling each other (which can overwhelm downstream systems during traffic spikes), you put a message queue in between.

<code>[Requests] → [Queue] → [Worker Service] → [Database]</code>

<b>Why it matters:</b> If 10,000 requests hit simultaneously, the queue absorbs the burst and workers process at a sustainable pace. Without it, your database or downstream service crashes.

<b>In your Spring context:</b> Think RabbitMQ or Kafka sitting between your member-service-api and a slow downstream processor.

### 2. Cache-Aside (Lazy Loading)

The application checks the cache first. On a miss, it fetches from the database, then populates the cache for next time.

<b>Why it matters:</b> Reduces database load dramatically for read-heavy workloads — relevant for your IPEDS data queries where institutions don't change frequently.

---

## 3. Survive Failures Gracefully

In distributed systems, failure isn't exceptional — it's normal. Services go down, networks hiccup, databases get overloaded. Resilience patterns let your system <b>absorb these shocks</b> instead of amplifying them.

### Pattern 1: Retry with Exponential Backoff

<b>The Problem</b>

A transient failure (brief network blip, momentary overload) causes your request to fail. If you just give up, the user sees an error for something that would have worked a moment later.

### The Naive Solution (Don't Do This)

<code>Immediate retry — hammers the struggling service</code>

<code>while (!success && attempts < 3) {
    result = callService();
    attempts++;
}</code>

This makes things worse. If the service is overloaded, you're adding to the pile.

<b>The Right Approach: Exponential Backoff</b>

Wait longer between each retry, giving the downstream system time to recover.

```java
@Configuration
@EnableRetry
public class RetryConfig {
    
    @Bean
    public RetryTemplate retryTemplate() {
        return RetryTemplate.builder()
            .maxAttempts(5)
            .exponentialBackoff(100, 2.0, 10000) // initial, multiplier, max
            .retryOn(TransientException.class)
            .build();
    }
}
```

<b>Add Jitter to Prevent Thundering Herd</b>

If 1,000 requests all fail at once and retry at the same intervals, they'll all hit the recovering service simultaneously. Add randomness:

<b>Without jitter:</b>

<code>10:00:00.000 — 1,000 requests fail
10:00:00.100 — all 1,000 retry simultaneously → service overwhelmed again
10:00:00.300 — all 1,000 retry simultaneously → still overwhelmed</code>

They're perfectly synchronized, hitting the recovering service in waves.

<b>With jitter:</b>

<code>10:00:00.000 — 1,000 requests fail
10:00:00.080 — 50 requests retry
10:00:00.095 — 47 requests retry
10:00:00.102 — 52 requests retry
10:00:00.110 — 49 requests retry
... spread out over time</code>

The retries are scattered, giving the service a manageable trickle instead of a flood.

````java
long backoff = (long) (baseDelay * Math.pow(multiplier, attempt));
long jitter = (long) (backoff * 0.2 * random.nextDouble()); // ±20%
Thread.sleep(backoff + jitter);

// Let's trace through attempt 2 with `baseDelay=100`, `multiplier=2`:
backoff = 100 × 2² = 400ms

random.nextDouble() returns 0.0 to 1.0 (let's say 0.75)

jitter = 400 × 0.2 × 0.75 = 60ms

total wait = 400 + 60 = 460ms
```

Another request on the same attempt might get:
```
jitter = 400 × 0.2 × 0.3 = 24ms
total wait = 400 + 24 = 424ms
````

Now they're no longer synchronized.

### Timeout Policies

A downstream service hangs instead of failing fast. Your thread sits waiting, your connection pool fills up, and eventually your entire service becomes unresponsive — even though <i>your</i> code is fine.

### The Solution: Fail Fast with Timeouts

Set aggressive timeouts so slow calls get cut off before they poison your system.

### Where to Set Timeouts

```txt
[Your Service] --connect timeout--> [TCP Handshake]
               --read timeout-----> [Waiting for response]
               --total timeout----> [Entire operation]
```

```java
private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = 
            new HttpComponentsClientHttpRequestFactory();
        
        factory.setConnectTimeout(Duration.ofSeconds(2));  // connection establishment
        factory.setReadTimeout(Duration.ofSeconds(5));     // waiting for data
        
        return factory;
    }
```

<b>Database Timeouts (JPA/Hibernate)</b>

```java
spring:
  datasource:
    hikari:
      connection-timeout: 2000      # wait for connection from pool
      validation-timeout: 1000      # connection validation
      max-lifetime: 1800000         # connection max age
  jpa:
    properties:
      jakarta.persistence.query.timeout: 5000  # query execution timeout
```

<b>Combining Patterns: Retry + Timeout</b>

Timeouts and retries work together, but be careful about total time:

```txt
Per-request timeout: 2 seconds
Retries: 4 attempts with exponential backoff
Worst case: 2s + 2s + 2s + 2s + (100 + 200 + 400)ms backoff = ~8.7 seconds
```

```java
@Retryable(
    retryFor = TimeoutException.class,
    maxAttempts = 3,
    backoff = @Backoff(delay = 200, multiplier = 2)
)
public Data fetchWithResilience(String id) {
    return restClient.get()
        .uri("/data/{id}", id)
        .retrieve()
        .body(Data.class);
    // RestClient already has 2s timeout configured
}
```

## Distributed System Tradeoffs

### <b>Trade-off 1: Latency vs Throughput</b>

<b>Latency:</b> How long a single request takes (response time)

<b>Throughput:</b> How many requests you can handle per unit time

<b>Optimizing for latency (low response time):</b>

- <code>Process requests immediately as they arrive
Keep queues short
Dedicate resources per request
Result: Fast individual responses, but fewer total requests handled</code>

<b>Optimizing for throughput (high volume):</b>

- <code>Batch requests together
Fill queues to maximize utilization
Share resources across requests
Result: More total work done, but individual requests wait longer</code>

### Real Examples

| Scenario | Optimize For | Why |
| --- | --- | --- |
| User-facing API (your member-service-api) | Latency | Users waiting for page load |
| Nightly IPEDS data import | Throughput | Nobody's waiting, just process it all |
| Real-time incident alerts | Latency | Seconds matter during outages |
| Log aggregation pipeline | Throughput | Volume matters more than speed |

### Trade-off 2: Consistency vs Availability (The CAP Theorem)

<b>Consistency:</b> Every read gets the most recent write (or an error)

<b>Availability:</b> Every request gets a response (but maybe stale data)

### Visualizing the Trade-off

```txt
Network partition happens between Data Center A and Data Center B

Consistency choice (CP):
  User → DC-A: "Update balance to $100" ✓
  User → DC-B: "Read balance" → ERROR (can't verify latest)

Availability choice (AP):
  User → DC-A: "Update balance to $100" ✓
  User → DC-B: "Read balance" → "$75" (stale but responsive)
```

### The Hidden Cost of Distributed Systems

Every distributed pattern adds operational burden:

| Pattern | Benefit | Complexity Cost |
| --- | --- | --- |
| Microservices | Independent deployment, scaling | Service discovery, network failures, distributed tracing |
| Event sourcing | Full audit trail, replay | Eventual consistency, projection management, storage growth |
| CQRS | Optimized read/write paths | Two models to maintain, sync lag |
| Distributed cache | Reduced DB load | Cache invalidation, consistency |
| Message queues | Decoupling, load leveling | Dead letters, ordering, exactly-once delivery |

<b>CQRS</b> = <b>Command Query Responsibility Segregation</b>

- <b>Commands</b> → operations that change state (write)
- <b>Queries</b> → operations that read state (read)

### SYNCHRONOUS vs ASYNCHRONOUS

```txt
SYNCHRONOUS (HTTP)                    ASYNCHRONOUS (Queue)

User ─▶ API ─▶ Service B ─▶ DB       User ─▶ API ─▶ Queue
         │                                     │
         │ (waiting for all)                   │ (returns immediately)
         │                                     │
         ◀──────────────────                   ▼
         │                            Queue ─▶ Worker ─▶ DB
         ▼                                      (processes later)
      Response

Total latency: sum of all steps       User latency: just API + queue publish
Failure: immediate error              Failure: retry from queue later
```

## <b>Designing Consistent API Contracts</b>

Structure your API around nouns (resources), not verbs (actions).

```java
# Good — resource-oriented
GET    /institutions          # list institutions
GET    /institutions/{id}     # get one institution

# Bad — action-oriented
GET    /getInstitutions
```

<b>Consistent Naming Conventions</b><br />

```java
# Choose one — don't mix
/institutions/{institutionId}/programs      # camelCase
/institutions/{institution_id}/programs     # snake_case
/institutions/{institution-id}/programs     # kebab-case

# Pluralization — be consistent
/institutions     ✓ (plural for collections)
/institution      ✗ (mixing singular)

# Hierarchy reflects relationships
/institutions/{id}/programs                 # programs belong to institution
/institutions/{id}/programs/{programId}     # specific program
```

<b>Consistent Response Structure</b>

```java
// Every successful response follows same shape
{
    "data": { ... },           // the actual payload
    "meta": {                  // optional metadata
        "page": 1,
        "totalPages": 10,
        "totalItems": 95
    }
}
```

API Versioning Strategies

Option 1: URL Path Versioning

```txt
GET /api/v1/institutions
GET /api/v2/institutions
```

<b>Pros:</b> Obvious, easy to route, cacheable, easy to test in browser

<b>Cons:</b> Not technically RESTful (version isn't a resource), URL changes

Option 2: Header Versioning

```txt
GET /api/institutions
Accept: application/vnd.myapi.v1+json
```

<b>Pros:</b> Clean URLs, more RESTful

<b>Cons:</b> Harder to test, not visible in logs, easy to forget

Option 3: Query Parameter Versioning

```txt
GET /api/institutions?version=1
GET /api/institutions?version=2
```

<b>Pros:</b> Simple, visible

<b>Cons:</b> Pollutes query string, optional parameter can cause ambiguity

<p />

<b>Designing API for Backward Compatibility<br /></b>

<page url="https://app.notion.com/p/348fc75cbbd9800d9f97c0a8176d7460">
Hadoop
</page>

<page url="https://app.notion.com/p/348fc75cbbd980509330d399242658a7">
Kafka
</page>

<page url="https://app.notion.com/p/34bfc75cbbd980e99a60dea0ee8285e8">
Job Runner Vs Quartz Vs Spring Batch
</page>

<page url="https://app.notion.com/p/34ffc75cbbd98054a40fdd5afd39036d">
DB Storage families (internal disk storage structure)
</page>
