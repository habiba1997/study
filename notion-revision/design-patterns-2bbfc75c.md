# Design patterns

Source: https://app.notion.com/p/2bbfc75cbbd9807ca1fbf1c051283e84?pvs=204

## Decorator Pattern

The <b>Decorator Pattern</b> is a <b>structural design pattern</b> that allows you to <b>dynamically add behavior or responsibilities to an object</b> without modifying its code. It’s often used when you want to extend functionality in a flexible and reusable way.

```java
// Component
interface Coffee {
    String getDescription();
    double getCost();
}

// ConcreteComponent
class SimpleCoffee implements Coffee {
    public String getDescription() { return "Simple Coffee"; }
    public double getCost() { return 5; }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) { this.coffee = coffee; }
}

// ConcreteDecorator
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() { return coffee.getDescription() + ", Milk"; }
    public double getCost() { return coffee.getCost() + 2; }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription()); // Simple Coffee, Milk
        System.out.println(coffee.getCost());        // 7.0
    }
}


```

✅ <b>Use case:</b> Adding features like logging, caching, or UI enhancements without changing the original object.
