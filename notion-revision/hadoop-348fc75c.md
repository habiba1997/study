# Hadoop

Source: https://app.notion.com/p/348fc75cbbd9800d9f97c0a8176d7460?pvs=204

Think of <b>Hadoop</b> as a way to handle <b>huge data that doesn’t fit on one machine</b>.

### What it actually means

Instead of:

- 1 server storing + processing data

Hadoop does:

- <b>Many cheap machines</b>
- Each stores <b>a piece of the data</b>
- Each processes <b>its own piece in parallel</b>

### Two main parts

<b>1) HDFS (storage)</b>

- Splits a big file into chunks
- Distributes chunks across many machines
- Replicates them (for fault tolerance)

Example:

1 TB file → split into blocks → spread across 100 machines

---

<b>2) MapReduce (processing)</b>

- You send a job to process data
- It runs <b>on all machines in parallel</b>

Flow:

- <b>Map</b> → each machine processes its chunk
- <b>Reduce</b> → combine results

Example:

- Count word frequency in 1 TB logs
  - Map: count per machine
  - Reduce: merge counts

Use Hadoop when:

- Data is <b>huge (TBs–PBs)</b>
- You don’t need instant results
- You run <b>analytics jobs</b>

Typical use cases:

- Log analysis (e.g., analyze 7 days of user activity)
- Data warehousing
- Generating reports (daily/weekly)
- Training ML models

### Where it fits in architecture

Example:

- App → generates logs
- Logs → stored in Hadoop (HDFS)
- Hadoop → runs jobs → produces insights/reports

### Simple mental model

- <b>Database (MySQL)</b> → fast, real-time queries
- <b>Hadoop</b> → slow but handles <b>massive data</b>
