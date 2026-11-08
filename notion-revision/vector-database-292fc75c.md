# Vector database

Source: https://app.notion.com/p/292fc75cbbd9809192affd687d74baa9?pvs=204

<b>chromaDB summary (short & clear):</b>

ChromaDB is an <b>open-source vector database</b> for storing and searching data using <b>embeddings (vectors)</b> — it helps apps find similar text, docs, or items using semantic similarity instead of exact matching.

---

### ⚙️ How it works

1. <b>Store data</b> → text, metadata, and its embedding (vector).
2. <b>Search/query</b> → input text → convert to vector → find most similar stored vectors.
3. <b>Each collection</b> = isolated namespace (e.g., per user or per use-case).

---

### 🧩 Example Code

```py
import chromadb
client = chromadb.Client()

# Create or get a collection
collection = client.get_or_create_collection(name="facts")

# --- Save / Upsert data ---
collection.upsert(
    ids=["1", "2", "3"],
    documents=[
        "The Colosseum is a Roman amphitheatre in Rome, Italy.",
        "Penguins can swim at speeds up to 22 miles per hour.",
        "The human body contains about 37 trillion cells."
    ],
    metadatas=[
        {"topic": "architecture"},
        {"topic": "wildlife"},
        {"topic": "biology"}
    ]
)

# --- Retrieve data ---
result = collection.get(
    ids=["1", "2", "3"],
    include=["documents", "metadatas"]
)
print(result)


```

<b>🖨️ Output (simplified):</b>

```py
{
  'ids': ['1', '2', '3'],
  'documents': [
    'The Colosseum is a Roman amphitheatre in Rome, Italy.',
    'Penguins can swim at speeds up to 22 miles per hour.',
    'The human body contains about 37 trillion cells.'
  ],
  'metadatas': [
    {'topic': 'architecture'},
    {'topic': 'wildlife'},
    {'topic': 'biology'}
  ]
}


```

---

## ✅ <b>Key point:</b>

Use <b>one collection per user or per use case</b> to keep embeddings and queries separated logically.

## Similarity Search vs. Metadata Filtering in ChromaDB

This section documents a hands-on experiment demonstrating how <b>vector similarity search</b> differs from <b>metadata filtering</b> in ChromaDB.

---

### 1️⃣ Inserting Initial Data

```py
collection.add(
  ids=["macbook_m3", "iphone_15", "ipad_air"],
  documents=[
    "MacBook Air M3 is fast and efficient.",
    "iPhone 15 has a dynamic island and improved camera.",
    "iPad Air 2024 supports Apple Pencil 2."
  ],
  metadatas=[
    {"type": "Laptop"},
    {"type": "Phone"},
    {"type": "Tablet"}
  ]
)


```

These documents represent three products with minimal metadata describing their device type.

---

### 2️⃣ Running a Similarity Query

```py
results = collection.query(
    query_texts=["lightweight laptop for students"],
    n_results=2
)


```

<b>Expected Output:</b>

```txt
🔍 Similarity Search Results:
- Laptop: MacBook Air M3 is fast and efficient.
- Tablet: iPad Air 2024 supports Apple Pencil 2.


```

✅ <b>Explanation:</b>

The search vector derived from “lightweight laptop for students” semantically matched the MacBook Air (laptop) and iPad Air (tablet) texts.

Similarity search works purely on <b>text embeddings</b> of document content.

---

### 3️⃣ Adding Metadata-Only Keywords

```py
collection.add(
  ids=["samsung_tv", "bose_headphones", "nike_shoes"],
  documents=[
    "A 4K smart TV with HDR.",
    "Noise-cancelling headphones.",
    "Running shoes for comfort."
  ],
  metadatas=[
    {"keyword": "ultracolor"},
    {"keyword": "deepbass"},
    {"keyword": "airzoom"}
  ]
)


```

These metadata fields (<code>ultracolor</code>, <code>deepbass</code>, <code>airzoom</code>) do <b>not appear in the document text</b>.

---

### 4️⃣ Test 1 — Query Using Metadata-Only Word

```py
results = collection.query(
    query_texts=["deepbass"],
    n_results=3
)


```

❌ <b>Result:</b> No relevant document retrieved.

<b>Reason:</b> The query vector for “deepbass” was compared only against the <b>document embeddings</b>, not metadata.

ChromaDB does <b>not</b> include metadata fields in the vector space.

---

### 5️⃣ Test 2 — Metadata Filtering

```py
results = collection.query(
    query_texts=["anything"],
    where={"keyword": "deepbass"},
    n_results=3
)


```

✅ <b>Result:</b> Returns the <i>Bose headphones</i> document.

<b>Reason:</b> The metadata filter <code>where={"keyword":"deepbass"}</code> explicitly restricts the search to items whose metadata match the condition.

<b>→ Filtering is boolean-based, not similarity-based.</b>

<page url="https://app.notion.com/p/29ffc75cbbd9809590a0d0beb72be959">
Spring with Vectordatabase
</page>

<p />
