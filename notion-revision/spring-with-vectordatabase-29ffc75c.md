# Spring with Vectordatabase

Source: https://app.notion.com/p/29ffc75cbbd9809590a0d0beb72be959?pvs=204

<table header-row="true">
<colgroup>
<col width="152" />
<col width="591" />
</colgroup>
<tr>
<td>
Bean
</td>
<td>
Role
</td>
</tr>
<tr>
<td>
<code>EmbeddingModel</code>
</td>
<td>
Converts plain text → vector (numeric embedding).
</td>
</tr>
<tr>
<td>
<code>VectorStore</code>
</td>
<td>
Saves and retrieves those vectors (documents + embeddings) in ChromaDB or another vector DB.
</td>
</tr>
</table>

## What <code>EmbeddingModel</code> Does

It represents your <b>embedding generator</b> — i.e., the model that transforms text into numerical vectors (semantic meaning representation).

```javascript
@Autowired
private EmbeddingModel embeddingModel;

public void embedText() {
    EmbeddingResponse response = embeddingModel.embed("The quick brown fox jumps over the lazy dog");
    List<Double> vector = response.getEmbeddings().get(0);
    System.out.println(vector.size()); // e.g. 768 or 1024 floats
}

```

The vector is just a long list of numbers like <code>[0.134, -0.892, 0.451, ...]</code>, which represents the <i>meaning</i> of your text.

## 📦 3️⃣ What <code>Document</code> Does

<code>org.springframework.ai.document.Document</code> is a wrapper class that represents <b>one data record</b> to be stored in the vector database.

It contains:

```java
new Document(
    "Poem text or paragraph",      // actual content
    Map.of("title", "Sonnet 18")   // optional metadata
);
```

Each <code>Document</code> will:

- Be <b>embedded automatically</b> using the <code>EmbeddingModel</code>.
- Be <b>stored</b> in the configured vector store (e.g., ChromaDB) as both:
  - The raw text.
  - Its vector representation.
  - Optional metadata.

You don’t manually call the embedding service — Spring AI does that for you.

---

## 💾 4️⃣ How the Saving Actually Works Internally

When you call:

```java
vectorStore.add(documents);
```

This happens under the hood:

1. Spring AI loops through each <code>Document</code>.
2. It sends the document’s text to the active <code>EmbeddingModel</code> (e.g., Ollama model <code>nomic-embed-text</code>).
3. The model returns a vector (a list of floats).
4. <u>Spring AI sends:</u>
   - <u>the text,</u>
   - <u>the metadata,</u>
   - <u>and the vector</u>
     <p>
     to <b>ChromaDB</b> through the <code>VectorStore</code> abstraction.
     </p>

So, in practice, your Java app doesn’t talk to ChromaDB directly — <code>VectorStore</code> does, after using the <code>EmbeddingModel</code>.

---

## 🔄 5️⃣ Example Flow (End-to-End)

```java
@Component
public class VectorStoreInitializer implements ApplicationRunner {

    private final VectorStore vectorStore;
    public VectorStoreInitializer(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<Document> docs = List.of(
            new Document("Spring AI integrates seamlessly with ChromaDB.", Map.of("topic", "AI")),
            new Document("Ollama can run embedding models locally.", Map.of("topic", "LLM"))
        );

        vectorStore.add(docs);
    }
}
```

---

<h2>
Notes: 
</h2>

ChromaDB (and all vector stores) store embeddings of the

<b><code>content</code></b><b> field</b>

— not metadata.

When you run a search like

```txt
"reviews for MacBook Air M3"
```

, ChromaDB compares your query’s vector embedding to the embeddings of each document’s content.

Metadata is just used for filtering after retrieval, not for similarity matching.

<p />
