# Load Balancing

Source: https://app.notion.com/p/39cfc75cbbd9809daaf3d49ef827cd12?pvs=204

<image source="notion-file-block://3acfc75c-bbd9-8010-a479-d71efa4103f5/bcc95b71-1939-4490-b576-11b4b479463b?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

<b>A. Static Algorithms</b><br />These don't consider the current load.

### 1. Round Robin

```txt
Request 1 → Server A
Request 2 → Server B
Request 3 → Server C
Request 4 → Server A
```

Best when:

- Servers have similar CPU/RAM
- Requests are roughly equal

### 2. Weighted Round Robin

```txt
Server A Weight = 5
Server B Weight = 3
Server C Weight = 2
```

Traffic:

```txt
A
A
A
A
A
B
B
B
C
C
repeat...
```

Useful when servers have different capacities.

### 3. Random

Pick a random server.

```txt
Request → Random(Server)
```

Surprisingly effective at large scale.

---

### 4. Weighted Random

Random selection, but powerful servers have higher probability.

## B. Dynamic Algorithms

These inspect server health.

### 5. Least Connections

Choose the server with the fewest active requests.

```txt
A : 50
B : 8
C : 22

Choose B
```

Great when request durations vary.

### 6. Weighted Least Connections

Like above, but considers server capacity.

```txt
Small server
10 connections

Large server
20 connections

Large server still has more capacity.
```

---

### 7. Least Response Time

Choose the fastest server.

```txt
A 12 ms

B 8 ms

C 40 ms

Choose B
```

Excellent for latency-sensitive systems.

---

### 8. Resource-Based

Uses:

- CPU
- Memory
- Disk
- Network

Example

```txt
CPU

A 90%

B 20%

Choose B
```

Often found in cloud environments.
