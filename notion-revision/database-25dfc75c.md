# Database

Source: https://app.notion.com/p/25dfc75cbbd980c596b3cce8992cc8cb?pvs=204

### <b>Functions vs Stored Procedures</b>

| Aspect | Function | Stored Procedure |
| --- | --- | --- |
| <b>Purpose</b> | Returns a single value; used in SQL expressions | Performs tasks; may or may not return a value |
| <b>Return Value</b> | Must return a value (using <code>RETURN</code>) | Optional return (<code>RETURN</code> can signal status, but no required value) |
| <b>Usage in SQL</b> | Can be used in <code>SELECT</code>, <code>WHERE</code>, <code>JOIN</code> | Cannot be directly used in SQL expressions |
| <b>Side Effects</b> | Usually avoids side effects (read-only recommended) | Can perform inserts, updates, deletes, transactions |
| <b>Transaction Control</b> | Usually cannot commit/rollback inside function | Can include commits, rollbacks, transaction control |

---

### <b>2. Parameters vs Return Values</b>

### <b>Parameter Modes</b>

| Mode | Meaning | Direction |
| --- | --- | --- |
| <b>IN</b> | Input to procedure/function | Caller → Routine |
| <b>OUT</b> | Output from procedure/function | Routine → Caller |
| <b>INOUT</b> | Both input and output | Caller ↔ Routine |

- <b>Function:</b> Typically uses <b>IN parameters</b> only. The <b>return value</b> is the output.
- <b>Stored Procedure:</b> Can use <b>IN, OUT, INOUT parameters</b>; may also have a return value (status code).

### Example (MySQL style)

```sql
-- Function (returns a single value)
CREATE FUNCTION add_tax(amount DECIMAL(10,2)) RETURNS DECIMAL(10,2)
BEGIN
    RETURN amount * 1.1;
END;

-- Procedure with IN, OUT, INOUT
CREATE PROCEDURE update_salary(
    IN emp_id INT,
    IN increment DECIMAL(10,2),
    OUT new_salary DECIMAL(10,2),
    INOUT bonus DECIMAL(10,2)
)
BEGIN
    UPDATE employees SET salary = salary + increment WHERE id = emp_id;
    SELECT salary INTO new_salary FROM employees WHERE id = emp_id;
    SET bonus = bonus + 100; -- modifies INOUT
END;


```

- <b>IN</b> → <code>emp_id</code>, <code>increment</code> (caller provides value)
- <b>OUT</b> → <code>new_salary</code> (routine sets value for caller)
- <b>INOUT</b> → <code>bonus</code> (caller provides initial value, routine can modify it)

---

<p />

<page url="https://app.notion.com/p/3abfc75cbbd9802db2d8c523f4674e40">
\* Sharding
</page>

<page url="https://app.notion.com/p/3abfc75cbbd9808fa93cf72952299986">
New distributed databases
</page>

<page url="https://app.notion.com/p/356fc75cbbd9801f8760fb6988bce04c">
\*\* Redis
</page>

<page url="https://app.notion.com/p/3affc75cbbd9804b9a8ae24bf4d52d71">
\* How do MongoDB, Redis, Cassandra, and DynamoDB differ?
</page>

<page url="https://app.notion.com/p/3affc75cbbd980ef9a2edd9de2cdbad3">
\* Hotspot Vs Kafka Design
</page>
