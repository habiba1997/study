# Transaction Propagation in Spring

Source: https://app.notion.com/p/2a2fc75cbbd98002b199fd9a4d222903?pvs=204

<b>Transaction propagation defines how transactions behave when one transactional method calls another transactional method.</b> Think of it as defining the "relationship rules" between nested method calls that both have <code>@Transactional</code>.

## The 7 Propagation Types (Real-World Understanding)

### 1. <b>REQUIRED </b><u>(Default)</u> - "Join or Create"

Joins existing transaction OR creates new one if none exists. Creates a single transaction boundary - if ANY part fails, EVERYTHING rolls back

- <b>Use Case</b>: Order processing where everything must succeed or fail together
- <b>Debug Proof</b>: Look for "participating in existing transaction" in logs

```java
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private InventoryService inventoryService;

    @Transactional // REQUIRED (default)
    public void createOrder(Order order) {
        System.out.println("=== Creating Order (REQUIRED) ===");
        
        // Save order
        orderRepository.save(order);
        System.out.println("Order saved: " + order.getId());
        
        // Process payment (joins THIS transaction)
        paymentService.processPayment(order);
        
        // Update inventory (joins THIS transaction)
        inventoryService.updateInventory(order);
        
        // If ANY of these fail, EVERYTHING rolls back
    }
}

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(propagation = Propagation.REQUIRED) // Joins outer transaction
    public void processPayment(Order order) {
        System.out.println("Processing payment (REQUIRED - joining transaction)");
        
        Payment payment = new Payment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getTotalAmount());
        paymentRepository.save(payment);
        
        if (order.getTotalAmount() > 10000) {
            throw new RuntimeException("Payment failed - amount too high!");
            // ❌ Entire transaction rolls back (Order + Payment)
        }
    }
}

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional(propagation = Propagation.REQUIRED) // Joins outer transaction
    public void updateInventory(Order order) {
        System.out.println("Updating inventory (REQUIRED - joining transaction)");
        
        Inventory inventory = inventoryRepository.findByProductId(order.getProductId());
        inventory.setQuantity(inventory.getQuantity() - order.getQuantity());
        inventoryRepository.save(inventory);
        
        // All part of SAME transaction started in createOrder()
    }
}
```

### 2. <b>REQUIRES\_NEW</b> - "Always My Own"

ALWAYS creates new transaction, suspends any existing one. Perfect for operations that must complete regardless of outer transaction outcome

- <b>Use Case</b>: Audit logging (inside main required transaction) that must save even if main transaction fails
- <b>Debug Proof</b>: Look for "suspending current transaction, creating new transaction" in logs

```java
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AuditService auditService;

    @Transactional // Outer transaction
    public void createOrder(Order order) {
        System.out.println("=== Creating Order (Outer Transaction) ===");
        
        try {
            // Save order
            orderRepository.save(order);
            System.out.println("Order saved: " + order.getId());
            
            // Log audit (REQUIRES_NEW - independent transaction)
            auditService.logAction("ORDER_CREATED", "Order " + order.getId());
            
            // Simulate failure
            if (order.getTotalAmount() > 10000) {
                throw new RuntimeException("Order validation failed!");
            }
            
            // Log success audit
            auditService.logAction("ORDER_SUCCESS", "Order " + order.getId());
            
        } catch (Exception e) {
            // Log failure audit (still saves even though outer tx rolls back)
            auditService.logAction("ORDER_FAILED", e.getMessage());
            throw e;
        }
    }
}

@Service
public class AuditService {
    @Autowired
    private AuditLogRepository auditLogRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW) // New transaction
    public void logAction(String action, String details) {
        System.out.println("Logging audit: " + action + " (REQUIRES_NEW)");
        
        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setDetails(details);
        log.setTimestamp(LocalDateTime.now());
        auditLogRepository.save(log);
        
        // This commits IMMEDIATELY in its own transaction
        System.out.println("Audit log committed independently");
    }
}
```

### 3. <b>MANDATORY</b> - "Must Have Parent"

REQUIRES existing transaction, throws exception if none found. Enforces that method is never called outside a transaction context

- <b>Use Case</b>: Payment validation that should only run within order processing

```java
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentValidationService paymentValidationService;

    @Transactional
    public void createOrder(Order order) {
        System.out.println("=== Creating Order with Transaction ===");
        
        orderRepository.save(order);
        
        // This works - called within transaction
        paymentValidationService.validatePaymentDetails(order);
    }
    
    // Method WITHOUT transaction
    public void createOrderWithoutTransaction(Order order) {
        System.out.println("=== Creating Order WITHOUT Transaction ===");
        
        orderRepository.save(order);
        
        // This will throw exception - no transaction exists
        paymentValidationService.validatePaymentDetails(order);
    }
}

@Service
public class PaymentValidationService {
    
    @Transactional(propagation = Propagation.MANDATORY) // Requires existing transaction
    public void validatePaymentDetails(Order order) {
        System.out.println("Validating payment (MANDATORY)");
        
        if (order.getTotalAmount() <= 0) {
            throw new IllegalArgumentException("Invalid payment amount");
        }
        
        // Validation logic...
        System.out.println("Payment validation passed");
    }
}
```

<p />

### 4. <b>NEVER</b> - "No Transactions Please"

Executes WITHOUT transaction, throws exception if one exists. Useful for operations that shouldn't be rolled back or retried

Sending notifications (avoid duplicate sends during retries)

```java
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private NotificationService notificationService;

    @Transactional
    public void createOrder(Order order) {
        System.out.println("=== Creating Order (Transactional) ===");
        
        orderRepository.save(order);
        
        // This will throw exception - can't call NEVER inside transaction
        try {
            notificationService.sendEmailNotification(order);
        } catch (IllegalTransactionStateException e) {
            System.out.println("Cannot send email within transaction: " + e.getMessage());
        }
    }
    
    // Non-transactional method
    public void processOrderAndNotify(Order order) {
        System.out.println("=== Processing Order (Non-transactional) ===");
        
        // First, create order in transaction
        createOrder(order);
        
        // Then send notification OUTSIDE transaction (works now)
        notificationService.sendEmailNotification(order);
    }
}

@Service
public class NotificationService {
    @Autowired
    private EmailClient emailClient;

    @Transactional(propagation = Propagation.NEVER) // Must execute without transaction
    public void sendEmailNotification(Order order) {
        System.out.println("Sending email notification (NEVER)");
        
        // Send email via external service
        emailClient.send(
            "order@example.com",
            "Order Confirmation",
            "Your order " + order.getId() + " is confirmed"
        );
        
        System.out.println("Email sent successfully");
    }
}
```

### 5. <b>NOT\_SUPPORTED</b> - "Pause and Execute"

<p>
 Suspends active transaction, executes without transaction. Temporarily escapes transaction boundary but resumes it after
</p>

- <b>Use Case</b>:Reading product recommendations (read-only, doesn't need transaction overhead).

```java
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RecommendationService recommendationService;

    @Transactional
    public Order createOrderWithRecommendations(Order order) {
        System.out.println("=== Creating Order (Transactional) ===");
        
        // Save order within transaction
        Order savedOrder = orderRepository.save(order);
        System.out.println("Order saved: " + savedOrder.getId());
        
        // Get recommendations WITHOUT transaction (suspends current tx)
        List<Product> recommendations = 
            recommendationService.getRecommendations(order.getCustomerId());
        
        System.out.println("Got " + recommendations.size() + " recommendations");
        
        // Back to transaction - update order with recommendations
        savedOrder.setRecommendedProducts(recommendations);
        orderRepository.save(savedOrder);
        
        return savedOrder;
    }
}

@Service
public class RecommendationService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation = Propagation.NOT_SUPPORTED) // Suspends transaction
    public List<Product> getRecommendations(Long customerId) {
        System.out.println("Fetching recommendations (NOT_SUPPORTED)");
        
        // Complex read-only query - doesn't need transaction
        // Suspending transaction avoids holding DB connection
        List<Product> products = productRepository
            .findTopSellingProductsForCustomer(customerId);
        
        System.out.println("Recommendations fetched without transaction");
        return products;
    }
}
```

### 6. <b>SUPPORTS</b> - "Flexible Friend"

Uses transaction if present, works without if not. Most flexible option - adapts to caller's context

- <b>Use Case</b>: Fetching customer details (works with or without transaction).

```java
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerService customerService;

    @Transactional
    public void createOrderWithCustomer(Order order) {
        System.out.println("=== Creating Order (Transactional) ===");
        
        // Fetch customer details (joins transaction if exists)
        Customer customer = customerService.getCustomerDetails(order.getCustomerId());
        order.setCustomerName(customer.getName());
        
        orderRepository.save(order);
    }
    
    // Non-transactional method
    public void viewCustomerInfo(Long customerId) {
        System.out.println("=== Viewing Customer (No Transaction) ===");
        
        // Fetch customer details (works without transaction too)
        Customer customer = customerService.getCustomerDetails(customerId);
        System.out.println("Customer: " + customer.getName());
    }
}

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(propagation = Propagation.SUPPORTS) // Flexible - uses tx if present
    public Customer getCustomerDetails(Long customerId) {
        System.out.println("Fetching customer (SUPPORTS)");
        
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
        
        System.out.println("Customer fetched: " + customer.getName());
        return customer;
    }
}
```

### 7. <b>NESTED</b> - "Save Points"

Creates nested transction with savepoints.

- <b>Limitation</b>: Not supported by JPA/Hibernate (needs JDBC)
- <b>Use Case</b>: Processing multiple order items where individual items can fail independently.

## Critical Technical Insights

### 1. <b>Transaction Boundaries Are Real</b>

java

<i><code>// This creates ONE transaction boundary:</code></i><code>
@Transactional(propagation = Propagation.REQUIRED)
public void placeOrder() {
    saveOrder();        </code><i><code>// Participates in same transaction</code></i><code>
    updateInventory();  </code><i><code>// Participates in same transaction// If EITHER fails, BOTH roll back</code></i><code>
}</code>

### 2. <b>How to Debug Transaction Behavior</b>

Add this to <code>application.properties: </code>

<code>logging.level.org.springframework.transaction=DEBUG</code>

Then look for these key phrases:

- "Creating new transaction"
- "Participating in existing transaction"
- "Suspending current transaction"
- "Resuming suspended transaction"

## Summary Table with Real Outcomes

<image source="notion-file-block://2a6fc75c-bbd9-80b9-a7d9-d01d2f58fb91/026622b9-e6fd-4cc8-aa14-1d1f40980f22?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

<p />
