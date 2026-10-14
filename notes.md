- String.concat() creates a new string, but you did not assign it to same string. A String is immutable, and you need to reassign it if you want a new value. String Builder is mutable.
StringBuilder.append() changes the builder. 
- StringBuffer's methods are synchronized, which makes it safer if multiple threads touch the same instance. But slower
- An interface can have fields, but they are constants (public static final)
- Java 8 added default and static methods with bodies; Java 9 added private helper methods. Interface methods cannot be protected.
- The fourth commonly named OOP principle is abstraction.
- An abstract class can have zero abstract methods. If it has abstract methods, a concrete subclass must implement them. it can look like a normal class, but the key difference is: you cannot instantiate an abstract class directly. Usually because the class is meant to be only a base class.You want to provide shared implementation, but you want to force developers to create a specific subtype instead of creating the generic parent.
- Animal animal = new Dog(); Instance methods are virtual in Java. So the version on the actual object runs. Whch in this case the Dog method run. This is overriding and runtime polymorphism
If makeSound() were static in both classes(Dog and Animal), It would print “Animal, Static methods are resolved at compile time based on the reference type. They are hidden, not overridden.
- You cannot you overload by only changing the return type.
- HashMap: Think an array of buckets plus a hash function, It takes the key's hashCode, turns that into an array index. suppose two different keys end up in the same bucket. That's a collision. Two collision strategies as separate chaining and open addressing.  
  - Separate chaining means the bucket can contain multiple entries. Traditionally, think of each bucket as pointing to a linked list
  - open addressing: If the calculated slot is occupied, you probe for another slot, less pointer overhead but the downside is that performance gets worse as the table becomes crowded.
- Hash table = general data-structure concept. 