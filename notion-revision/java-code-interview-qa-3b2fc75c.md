# Java code interview QA

Source: https://app.notion.com/p/3b2fc75cbbd980c5849aedfe4beb2546?pvs=204

```java
void readCard(int cardNo) throws Exception {
    System.out.println("Reading Card");
}

void checkCard(int cardNo) throws RuntimeException { // line n1
    System.out.println("Checking Card");
}

public static void main(String[] args) {
    Test ex = new Test();
    int cardNo = 12344;

    ex.readCard(cardNo);   // line n2
    ex.checkCard(cardNo);  // line n3
}
```

<u>Compilation fails only at line n2.</u>

## Line n1

This is <b>perfectly legal</b>. <code>RuntimeException</code> is an <b>unchecked exception</b>, so you may declare it with <code>throws</code> or not.

## Line n2<br />

<code>readCard()</code> declares throwsException

- <code>Exception</code> is <b>checked</b> → must be caught or declared.
- <code>RuntimeException</code> is <b>unchecked</b> → no handling required.

```java
String ta = "A ";
ta = ta.concat("B ");      // "A B "

String tb = "C ";

ta = ta.concat(tb);        // "A B C "

ta.replace('C', 'D');      // Ignored!

ta = ta.concat(tb);        // "A B C C "

System.out.println(ta);
```

### Output

```txt
A B C C
```

<code>String</code> is <b>immutable</b>.

Methods like:

- <code>concat()</code>
- <code>replace()</code>
- <code>substring()</code>
- <code>toUpperCase()</code>

<b>do not modify the original string</b>. They return a <b>new</b> <code>String</code>.

<p />

```java
int x = 100;
int a = x++; a= 100 x=101
int b = ++x; b= 102 x=
int c = x++; 
int d = (a < b) ? (a < c) ? a : (b < c) ? b : c : x;
System.out.println(d);
```

### ✅ Answer: <b>A. 100</b>

### Explanation

```java
x = 100

a = x++;   // a = 100, x = 101
b = ++x;   // x = 102, b = 102
c = x++;   // c = 102, x = 103
```

Evaluate ternary:

```txt
(a<b)? (a<c)?a : ... :x
```

- <code>100 < 102</code> → true
- <code>100 < 102</code> → true

So <code>d = a = 100</code>.

---

## Question 13

<b>Question:</b> What is the output?

```java
int num = 5;
do {
    System.out.print(num-- + " ");
} while (num == 0);
```

### ✅ Answer: <b>D. 5</b>

---

---

<p />

```java
Short s1 = 200;
Integer s2 = 400;
Long s3 = (long) s1 + s2;
String s4 = (String) (s3 * s2); // fail here You cannot cast a numeric value to String.
```

```txt
you can add a long with an int, and you can add an int with a short in Java. When you do this, Java automatically changes the smaller data type to match the bigger data type
```

---

```java
String ta = "A ";
ta = ta.concat("B ");
String tb = "C ";
ta = ta.concat(tb);
ta.replace('C', 'D');
ta = ta.concat(tb);
System.out.println(ta);
```

### ✅ Answer: <b>ABCC</b>

### Explanation

```txt
ta="A "ta="A B "ta="A B C "ta.replace(...)// ignored (String is immutable)ta="A B C C "
```

Output:

```txt
A B C C
```

(<code>replace()</code> returns a new String; it does <b>not</b> modify the original.)
