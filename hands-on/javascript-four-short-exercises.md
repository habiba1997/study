# JavaScript Hands-On — Four Short Exercises

**Status:** Not started. Solve these in your own time; keep the chat for MCQs and short completion questions.

## 1. Equality and type coercion
Predict the output and explain why.

```javascript
console.log(0 == false);
console.log(0 === false);
console.log("5" + 2);
console.log("5" - 2);
```

**Your answer:**

## 2. Async JavaScript — Event Loop
What is the exact output order? Explain why.

```javascript
console.log("A");

setTimeout(() => console.log("B"), 0);

Promise.resolve().then(() => console.log("C"));

console.log("D");
```

**Your answer:**

## 3. Closures — Debugging
Why does this print unexpected values? Fix it.

```javascript
for (var i = 0; i < 3; i++) {
  setTimeout(() => console.log(i), 100);
}
```

**Your answer / corrected code:**

## 4. React — State Update Bug
Why might clicking this button increase the counter by only 1 instead of 2? Fix it.

```jsx
function Counter() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(count + 1);
    setCount(count + 1);
  };

  return <button onClick={increment}>{count}</button>;
}
```

**Your answer / corrected code:**
