# Spring Transaction Management: Deep Dive Summary

Source: https://app.notion.com/p/2a1fc75cbbd9802191c5d4a3c2dc319a?pvs=204

## Core Concept: How @Transactional Works Behind the Scenes

### 1. <b>AOP Around Advice Pattern</b>

When you add <code>@Transactional</code> to a method, Spring uses <b>AOP (Aspect-Oriented Programming)</b> with an <b>Around Advice</b> pattern:

<code>Before Method Execution → Execute Your Method → After Method Execution
(Create/Get Transaction)  (Transfer logic)      (Commit or Rollback)</code>

<image source="notion-file-block://2a1fc75c-bbd9-8027-b9ba-dcba07770daf/6551ac2c-e9c3-46e1-aaad-9ba5e137b89f?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

### 2. <b>Proxy Class Creation</b>

Spring doesn't execute your original class directly. Instead, it creates a <b>proxy class</b>:

- <b>CGLIB Proxy</b>: Created when your class is concrete (no interface, no inheritance)
  - Format: <code>AccountService$$SpringCGLIB$$<random_number></code>
  - Extends your original class
- <b>JDK Dynamic Proxy</b>: Created when your class implements an interface

The proxy overrides your transactional method and delegates to <code>TransactionInterceptor</code>.

### 3. <b>TransactionInterceptor: The Real Hero</b>

This is the class that handles all transaction magic:

```javascript
// Pseudo-code of what happens
public Object invoke(MethodInvocation invocation) {
    // 1. GET TRANSACTION (Before method execution)
    TransactionInfo txInfo = createTransactionIfNecessary(...);
    
    try {
        // 2. EXECUTE YOUR ACTUAL METHOD
        Object result = invocation.proceed();
        
        // 3. COMMIT (After method execution - success)
        commitTransactionAfterReturning(txInfo);
        return result;
        
    } catch (Throwable ex) {
        // 4. ROLLBACK (After method execution - failure)
        completeTransactionAfterThrowing(txInfo, ex);
        throw ex;
    }
}
```

### 4. <b>Key Internal Steps</b>

<b>Step 1: Get Transaction Attributes</b>

- Reads your <code>@Transactional</code> configuration (propagation, isolation)
- Example: <code>propagation=REQUIRED</code>, <code>isolation=READ_COMMITTED</code>

<b>Step 2: Determine Transaction Manager</b>

- Spring auto-configuration decides which manager to use:
  - <code>JpaTransactionManager</code> (if using JPA)
  - <code>DataSourceTransactionManager</code> (if using JDBC)
  - Location: <code>JpaBaseConfiguration</code> creates <code>JpaTransactionManager</code> bean

<b>Step 3: Identify Join Point</b>

- Determines which method needs the transaction (your <code>transfer</code> method)

<b>Step 4: Execute Within Transaction</b>

- All database operations in your method run in the <b>same transaction</b>
- Even nested repository calls share this transaction context

<b>Step 5: Commit or Rollback</b>

- <b>Success path</b>: <code>commitTransactionAfterReturning()</code>
- <b>Failure path</b>: <code>completeTransactionAfterThrowing()</code> → rollback

### 5. <b>Why All DB Operations Share One Transaction</b>

Even when your method calls multiple repository methods:

````javascript
@Transactional
public void transfer(Long from, Long to, double amount) {
    Account sender = accountRepo.findById(from);      // DB call 1
    Account receiver = accountRepo.findById(to);      // DB call 2
    accountRepo.save(sender);                         // DB call 3
    accountRepo.save(receiver);                       // DB call 4
    // If exception here → ALL 4 operations rollback
}
```

All these operations execute within the **same transaction context** created at the beginning.

### 6. **The Flow Diagram**
```
Request → Controller 
    ↓
Proxy Class (CGLIB) 
    ↓
TransactionInterceptor.invoke()
    ↓
Create/Get Transaction
    ↓
Determine Transaction Manager
    ↓
Execute target method (your actual code)
    ↓
    ├─→ Success? → Commit Transaction
    └─→ Exception? → Rollback Transaction
````

<page url="https://app.notion.com/p/2a2fc75cbbd980c5b75ce8114fe2a9a7">
Spring Transaction Managers: Types and Auto-Configuration
</page>

<page url="https://app.notion.com/p/2a2fc75cbbd98002b199fd9a4d222903">
Transaction Propagation in Spring
</page>

<page url="https://app.notion.com/p/2a2fc75cbbd980d6864ed197e68d9b81">
Spring Transaction Managers & IoC Context Behavior
</page>

<page url="https://app.notion.com/p/2b4fc75cbbd9808b8bf9ebb7fa18bd9a">
Trx Isolation Levels
</page>

<page url="https://app.notion.com/p/247fc75cbbd9800ca389d4cf344c8c77">
Spring
</page>

<page url="https://app.notion.com/p/31afc75cbbd980afae3be7526930f616">
Threading
</page>

<page url="https://app.notion.com/p/2ecfc75cbbd980baa783e6a00bd7f81d">
System Design 
</page>

<page url="https://app.notion.com/p/2b6fc75cbbd98072bc35eeec8864f4fe">
<code>Transactional: readOnly = true</code>
</page>

<page url="https://app.notion.com/p/304fc75cbbd980d4a7b0fc62f0a05d7d">
Save and flush
</page>

<page url="https://app.notion.com/p/348fc75cbbd980be9171d2360c2eb807">
<b>JTA + Atomikos + Spring Boot 3 </b>
</page>
