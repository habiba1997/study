
- Design Patterns
    - 4 Behavioral Patterns (Command, Iterator, State, Chain of Responsibility, Interpreter, Mediator, Memento, Template Method and Visitor).
    - 4 Structural Patterns (e.g., Adapter, Bridge, Composite, Decorator, Façade, Flyweight and Proxy)
    - Scalability Patterns (Queue and Caching)
    - Resilience Patterns (Retry and Timeouts)
- Algorithms & Data Structures
  - Advanced data structrure (Hash Tables)
  - Concurrent Data structures (e.g., Concurrent Collections (in .NET) - System.Collections.Concurrent, ConcurrentQueue, ConcurrentStack, ConcurrentDictionary, ReadWriteLock, Concurrent Bag).
  - 1 Searching Algorithms (Linear Search, Binary Search)
  - Graph Traversal Algorithms (Depth-First Search DFS, Breadth-First Search BFS)
  - Divide and Conquer

# Design Patterns
Design patterns are typical solutions to common problems
in software design. Each pattern is like a blueprint
that you can customize to solve a particular
design problem in your code.

## Behavioral Patterns 
Behavioral design patterns are concerned with algorithms and the assignment of responsibilities between objects.
- Observer
- Strategy
- Command
- Iterator
- State
- Chain of Responsibility
- Interpreter
- Mediator
- Memento
- Template Method and Visitor

### Observer
Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

#### Problem
Imagine that you have two types of objects: a Customer and a Store. The customer is very interested in a particular brand of product (say, it’s a new model of the iPhone) which should become available in the store very soon.

The customer could visit the store every day and check product availability. But while the product is still en route, most of these trips would be pointless.

On the other hand, the store could send tons of emails (which might be considered spam) to all customers each time a new product becomes available. This would save some customers from endless trips to the store. At the same time, it’d upset other customers who aren’t interested in new products.

It looks like we’ve got a conflict. Either the customer wastes time checking product availability or the store wastes resources notifying the wrong customers.

#### Solution
The object that has some interesting state is often called subject, but since it’s also going to notify other objects about the changes to its state, we’ll call it publisher. All other objects that want to track changes to the publisher’s state are called subscribers.

The Observer pattern suggests that you add a subscription mechanism to the publisher class so individual objects can subscribe to or unsubscribe from a stream of events coming from that publisher. Fear not! Everything isn’t as complicated as it sounds. In reality, this mechanism consists of 1) an array field for storing a list of references to subscriber objects and 2) several public methods which allow adding subscribers to and removing them from that list.

Subscription mechanism
A subscription mechanism lets individual objects subscribe to event notifications.

Now, whenever an important event happens to the publisher, it goes over its subscribers and calls the specific notification method on their objects.

#### Components of Observer Design Pattern
1. Subject
   - The subject maintains a list of observers (subscribers or listeners). It Provides methods to register and unregister observers dynamically and defines a method to notify observers of changes in its state.

2. Observer
    - Observer defines an interface with an update method that concrete observers must implement and ensures a common or consistent way for concrete observers to receive updates from the subject. Concrete observers implement this interface, allowing them to react to changes in the subject’s state.

1. ConcreteSubject
    - ConcreteSubjects are specific implementations of the subject. They hold the actual state or data that observers want to track. When this state changes, concrete subjects notify their observers. For instance, if a weather station is the subject, specific weather stations in different locations would be concrete subjects.

1. ConcreteObserver
    - Concrete Observer implements the observer interface. They register with a concrete subject and react when notified of a state change. When the subject’s state changes, the concrete observer’s update() method is invoked, allowing it to take appropriate actions. In a practical example, a weather app on your smartphone is a concrete observer that reacts to changes from a weather station.

![alt text](./images/observer.png)

### Strategy
Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

#### Problem
One day you decided to create a navigation app for casual travelers. The app was centered around a beautiful map which helped users quickly orient themselves in any city.

One of the most requested features for the app was automatic route planning. A user should be able to enter an address and see the fastest route to that destination displayed on the map.

The first version of the app could only build the routes over roads. People who traveled by car were bursting with joy. But apparently, not everybody likes to drive on their vacation. So with the next update, you added an option to build walking routes. Right after that, you added another option to let people use public transport in their routes.

However, that was only the beginning. Later you planned to add route building for cyclists. And even later, another option for building routes through all of a city’s tourist attractions.

The code of the navigator became very bloated
The code of the navigator became bloated.

While from a business perspective the app was a success, the technical part caused you many headaches. Each time you added a new routing algorithm, the main class of the navigator doubled in size. At some point, the beast became too hard to maintain.

Any change to one of the algorithms, whether it was a simple bug fix or a slight adjustment of the street score, affected the whole class, increasing the chance of creating an error in already-working code.

In addition, teamwork became inefficient. Your teammates, who had been hired right after the successful release, complain that they spend too much time resolving merge conflicts. Implementing a new feature requires you to change the same huge class, conflicting with the code produced by other people.

#### Solution
The Strategy pattern suggests that you take a class that does something specific in a lot of different ways and extract all of these algorithms into separate classes called strategies.

The original class, called context, must have a field for storing a reference to one of the strategies. The context delegates the work to a linked strategy object instead of executing it on its own.

The context isn’t responsible for selecting an appropriate algorithm for the job. Instead, the client passes the desired strategy to the context. In fact, the context doesn’t know much about strategies. It works with all strategies through the same generic interface, which only exposes a single method for triggering the algorithm encapsulated within the selected strategy.

This way the context becomes independent of concrete strategies, so you can add new algorithms or modify existing ones without changing the code of the context or other strategies.

![alt text](./images/strategy.png)

#### Components of the Strategy Design Pattern

1. Context
   - The Context is a class or object that holds a reference to a strategy object and delegates the task to it.

It acts as the interface between the client and the strategy, providing a unified way to execute the task without knowing the details of how it’s done.
The Context maintains a reference to a strategy object and calls its methods to perform the task, allowing for interchangeable strategies to be used.
1. Strategy Interface
The Strategy Interface is an interface or abstract class that defines a set of methods that all concrete strategies must implement.

It serves as a contract, ensuring that all strategies adhere to the same set of rules and can be used interchangeably by the Context.
By defining a common interface, the Strategy Interface allows for decoupling between the Context and the concrete strategies, promoting flexibility and modularity in the design.
3. Concrete Strategies
Concrete Strategies are the various implementations of the Strategy Interface. Each concrete strategy provides a specific algorithm or behavior for performing the task defined by the Strategy Interface.

Concrete strategies encapsulate the details of their respective algorithms and provide a method for executing the task.
They are interchangeable and can be selected and configured by the client based on the requirements of the task.
4. Client
The Client is responsible for selecting and configuring the appropriate strategy and providing it to the Context.

It knows the requirements of the task and decides which strategy to use based on those requirements.
The client creates an instance of the desired concrete strategy and passes it to the Context, enabling the Context to use the selected strategy to perform the task.
