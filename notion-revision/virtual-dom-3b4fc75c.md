# Virtual DOM

Source: https://app.notion.com/p/3b4fc75cbbd980749961ebc9dd9b59c3?pvs=204

The <b>Virtual DOM</b> is one of React's biggest performance optimizations. It lets React update only the parts of the page that actually changed instead of rebuilding the entire UI.

---

## What is the DOM?

The <b>DOM (Document Object Model)</b> is the browser's representation of your HTML.

```txt
<div id="root">
  <h1>Hello</h1>
  <button>Click</button>
</div>
```

becomes a tree:

```txt
div
├── h1
│   └── "Hello"
└── button
    └── "Click"
```

Updating the real DOM is <b>slow</b> because the browser may need to:

- Recalculate layout
- Repaint elements
- Re-render the page

## What is the Virtual DOM?

The <b>Virtual DOM</b> is a lightweight JavaScript object that represents the real DOM.

Example:

```txt
<h1>Hello</h1>
```

becomes something like:

```txt
{type:"h1",props: {children:"Hello"
  }
}
```

This object exists only in memory, so creating and comparing it is very fast.

# How React updates the UI

Suppose you have:

```txt
function Counter() {
    const [count, setCount] = useState(0);

    return (
        <>
            <h1>{count}</h1>
            <button onClick={() => setCount(count + 1)}>
                Increment
            </button>
        </>
    );
}
```

Initially the browser displays:

```txt
0
[Increment]
```

---

## Step 1 — Initial Render

React creates a Virtual DOM.

```txt
Virtual DOM

Fragment
├── h1
│   └── "0"
└── button
    └── "Increment"
```

Then React builds the real DOM.

```txt
Real DOM

Fragment
├── h1
│   └── "0"
└── button
```

Both match.

---

## Step 2 — User clicks the button

```txt
setCount(count+1);
```

The state changes from

```txt
0
```

to

```txt
1
```

React <b>does not immediately change the real DOM.</b>

Instead it runs the component again.

---

## Step 3 — React creates a NEW Virtual DOM

Old Virtual DOM

```txt
Fragment
├── h1
│   └── "0"
└── button
```

New Virtual DOM

```txt
Fragment
├── h1
│   └── "1"
└── button
```

Notice only one value changed.

---

## Step 4 — Diffing

React compares:

Old

```txt
h1
└── "0"
```

New

```txt
h1
└── "1"
```

Everything else is identical.

React concludes:

```txt
Only the text inside h1 changed.
```

This comparison is called the <b>diffing algorithm</b>.

---

## Step 5 — Update the real DOM

Instead of rebuilding everything:

❌ Bad approach

```txt
Delete button
Delete h1
Create new h1
Create new button
```

React does:

```txt
Update text node

0 → 1
```

Only one DOM operation occurs.

The button is untouched.

conclusion: REACT IS FAST<br />

# Does React compare the whole tree?

Yes, React creates a new Virtual DOM tree for the updated component and compares it with the previous one.

# Real DOM vs Virtual DOM

| Real DOM | Virtual DOM |
| --- | --- |
| Browser object | JavaScript object |
| Slow to update | Fast to create and compare |
| Causes layout/repaint | Exists only in memory |
| Manipulated by browser | Managed by React |

### React vs Angular

| React | Angular |
| --- | --- |
| <b>JavaScript library</b> for building UIs | <b>Complete framework</b> for building web applications |
| Developed by Meta | Developed by Google |
| Focuses mainly on the View (UI) | Includes routing, forms, HTTP, dependency injection, testing, etc. |
| Uses Virtual DOM | Uses real DOM with efficient change detection (no Virtual DOM) |
| <u>Uses </u><b><u>JSX</u></b> | <i><b>Uses HTML templates</b></i> |
| Easier to learn | Steeper learning curve |
| Flexible—you choose libraries | Opinionated—many features built in |
| Commonly uses JavaScript or TypeScript | TypeScript-first |

React is a <b>library</b>.

You can write React using:

- JavaScript
- TypeScript

# Is Angular JavaScript or TypeScript?

Angular is built with TypeScript.

Although it compiles to JavaScript for the browser.

Interview answer:

> Angular applications are primarily written in TypeScript, which is transpiled into JavaScript before running in the browser.

# JavaScript vs TypeScript

| JavaScript | TypeScript |
| --- | --- |
| Programming language | Superset of JavaScript |
| Dynamic typing | Static typing |
| No compile-time type checking | Compile-time type checking |
| Runs directly in browser | Must be transpiled to JavaScript |
| Easier to start | Better for large applications |

Example

JavaScript

```txt
let age = 20;
age = "hello";   // allowed
```

TypeScript

```txt
let age: number = 20;
age = "hello";   // compile error
```

# Does TypeScript have an Event Loop?

No.

The <b>Event Loop belongs to the JavaScript runtime</b>, not the language.

after compilation the browser runs JavaScript.

So:

```txt
TypeScript
      ↓
Compiled
      ↓
JavaScript
      ↓
Browser
      ↓
Event Loop
```

# Microtask Queue vs Callback Queue

Higher priority:

```txt
Call Stack

↓

Microtask Queue

- Promise.then()
- queueMicrotask()
- MutationObserver

↓

Callback Queue

- setTimeout()
- setInterval()
- DOM events
```

Example

```txt
console.log(1);

setTimeout(() => console.log(2));

Promise.resolve().then(() => console.log(3));

console.log(4);
```

Output

```txt
1
4
3
2
```

Very common interview question.

# JavaScript Tips & Tricks (Interview)

Know:

### <code>==</code> vs <code>===</code>

Always prefer

```txt
===
```

because it avoids type coercion.

<code>calculateAgeYears</code> no longer returns a plain integer year count. It now returns a <code>Float</code> with a <b>sentinel</b> pattern:

<p />

| <b>Situation</b> | <b>Returns</b> |
| --- | --- |
| Today <b>is</b> their birthday (exact N years) | <code>16.0</code> |
| Past birthday but <b>before</b> next one (even by 1 day) | <code>16.1</code> |
| 16 years + 3 months | <code>16.1</code> (not <code>16.25</code> — the <code>.1</code> is a flag, not real decimal age) |

The idea is to let rules distinguish <b>“turned 16 today”</b> (<code>16.0</code>) from <b>“already past their 16th birthday”</b> (<code>16.1</code>), which supports comparisons like <code>> 16</code> or <code>>= 16.1</code>.
