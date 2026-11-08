# Transactional: readOnly = true

Source: https://app.notion.com/p/2b6fc75cbbd98072bc35eeec8864f4fe?pvs=204

Here is the core idea, short and precise:

### What <code>@Transactional</code> does

It starts a database transaction around your method. Inside it, Spring controls:

- <b>readOnly</b>
- <b>isolation</b>
- <b>propagation</b>
- <b>timeout</b>
- <b>rollback rules</b>

### What <code>readOnly = true</code> means

- Tells Hibernate: “Don’t track entity changes.”
- Disables the dirty-checking process.
- Improves performance for pure read methods.
- Some databases also optimize read-only transactions.

### What “dirty checking” means

Hibernate watches managed entities.

If it sees a field changed → marks it “dirty” → updates the database automatically before commit.

With <code>readOnly = true</code>:

Hibernate <b>skips</b> this watching process → faster.
