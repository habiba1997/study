# Java Variable Hiding vs Method Overriding

Source: https://app.notion.com/p/3acfc75cbbd9807d890ed76d222b59bf?pvs=204

- <b>Fields (variables) cannot be overridden</b>; they are <b>hidden</b>. A subclass object contains both the parent and child fields.
- <b>Field access</b> is determined by the <b>reference type</b> (compile time).
- <b>Methods can be overridden</b>. <b>Method calls</b> are determined by the <b>actual object type</b> (runtime polymorphism).

Exactly. Let's use your example.

```txt
class A {
    int x = 10;

    public int getX() {
        return 30;
    }
}

class B extends A {
    int x = 20;

    @Override
    public int getX() {
        return 40;
    }
}
```

Now:

```txt
A obj= new B();
System.out.println(obj.x);      // 10
System.out.println(obj.getX()); // 40
```

here are <b>two things</b> to keep in mind:

- The <b>reference type</b> is <code>A</code>.
- The <b>actual object</b> is <code>B</code>.

<b>Rule to remember:</b>

<quote>
<b>Fields → Reference type</b>

<b>Methods → Actual object type</b>
</quote>
