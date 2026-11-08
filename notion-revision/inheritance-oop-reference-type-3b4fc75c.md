# Inheritance OOP (reference type)

Source: https://app.notion.com/p/3b4fc75cbbd980e9af4bd93824164cbd?pvs=204

Assume:

```txt
class Animal {
void eat() {}
}
class Dog extends Animal { 
voidbark() {}
}
```

### 1. <code>Dog d = new Dog();</code>

- <b>Reference type:</b> <code>Dog</code>
- <b>Object type:</b> <code>Dog</code>

You can access <b>everything</b> in <code>Dog</code> and <code>Animal</code>.

```txt
d.eat();// ✅ Inherited from Animald.bark();// ✅ Dog method
```

---

### 2. <code>Animal a = new Dog();</code>

- <b>Reference type:</b> <code>Animal</code>
- <b>Object type:</b> <code>Dog</code>

You can access <b>only what </b><b><code>Animal</code></b><b> declares</b>, even though the object is a <code>Dog</code>.

```txt
a.eat();// ✅ Animal method
a.bark();// ❌ Compile error (Animal doesn't declare bark())
```

If <code>Dog</code> overrides <code>eat()</code>:

```txt
class Dog extends Animal {
    @Override
    voideat() {
    System.out.println("Dog eating");
    }
}
```

Then:

```txt
Animal a = new Dog();
a.eat();// ✅ Calls Dog.eat() (runtime polymorphism)
```

---

### If you know it's actually a <code>Dog</code>

You can cast:

```txt
((Dog)a).bark();// ✅
```

---

## Summary

| Code | Methods you can call | Which overridden method runs? |
| --- | --- | --- |
| <code>Dog d = new Dog()</code> | <code>eat()</code>, <code>bark()</code> | <code>Dog</code> implementation |
| <code>Animal a = new Dog()</code> | Only methods declared in <code>Animal</code> | <code>Dog</code> implementation (if overridden) |

### Rule to remember

- <b>Reference type (</b><b><code>Animal</code></b><b>)</b> → determines <b>what methods you are allowed to call</b> (compile time).
- <b>Object type (</b><b><code>Dog</code></b><b>)</b> → determines <b>which implementation actually executes</b> for overridden methods (runtime).
