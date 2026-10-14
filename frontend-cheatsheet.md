# Front-end interview cheat sheet

JavaScript, TypeScript, React, Angular, and tooling. Grouped by topic, ordered basics → advanced. Related terms sit next to each other.
Each entry is a short definition first; the small bullets underneath carry the extra context and follow-up answers.

**⚠️ = your original note needed a correction.** The fix is in that term's bullets. All of them are listed below so you can review them in one pass. There's a **How to update this cheat sheet** section at the very end.

---

## ⚠️ Corrections — your notes vs. the fix

| Term | What you wrote | The fix |
|---|---|---|
| **Real DOM vs Virtual DOM** | real DOM is "slow to update" | Imprecise, and interviewers push on it. Writing to a DOM property is fast. What's expensive is the **layout / reflow / repaint** the browser does afterwards, and doing it repeatedly. |
| **Why React is faster** | "React diffs and updates only the changed parts instead of rebuilding the UI" | True but only half the answer. The Virtual DOM is faster than **naive** re-rendering, **not** faster than optimal hand-written DOM code — React pays for the diff *plus* the update. What it really buys you is a **declarative** model with near-optimal updates for free. Say both halves. |
| **Lexical scope vs closure** | "this behavior is also called a closure" | They're related but distinct. **Lexical scope is the rule** — what a function can see, based on where it was written. **A closure is the consequence** — the retained environment keeping those variables alive after the outer call finished. One-liner: *lexical scope is the lookup rule; a closure is the memory that keeps it working later.* |
| **"Variable Object"** | term used for where declarations are stored | ES3 wording. The modern spec calls it an **Environment Record** (or Lexical Environment). Either communicates, but say "environment record" to a precise interviewer. |
| **Web APIs → queues** | "their corresponding callbacks (event listeners or **promise callbacks**) are placed in the Callback Queue" | Promise callbacks go to the **microtask queue**, not the callback queue — that's the whole reason microtasks exist. Event listeners and timers go to the **callback (macrotask) queue**. |
| **Lazy loading in React** | "initially load and render limited data… rendered when visited or scrolled, can be images, scripts" | Two different ideas got merged. **`React.lazy` / code-splitting** defers downloading a component's **JavaScript** — that's what "lazy loading in React" means in an interview. **Lazy loading images/content on scroll** defers **data or media** (`loading="lazy"`, `IntersectionObserver`, virtualization) and isn't a React feature at all. |
| **Access token** | "represents the user's identity and permissions" | An access token represents **authorization** — what the bearer may do. **Identity** is the **ID token**'s job in OpenID Connect. Same distinction you already have on the backend sheet: a key card opens room 402, it doesn't say your name. |
| **Storing tokens** | access token "in memory or local storage" | Worth stating the trade-off. `localStorage` is readable by **any** JavaScript on the page, so one XSS bug or compromised dependency leaks it. **In-memory is the safer answer**; the cost is being logged out on refresh, which is exactly what the httpOnly refresh-token cookie solves. |
| **Redux store** | "the store itself is immutable; it cannot be directly modified" | What's immutable is the **state inside** it. The store is an object with methods — `getState()`, `dispatch()`, `subscribe()`. You can't mutate the state directly; only reducers, triggered by actions, produce a new state. |

Things your notes left blank or unanswered, now filled in: **Destructuring**, **Optional chaining**, and **Nullish coalescing** (which was just `????`) all have definitions, and the `??` vs `||` trap is written out because it's asked constantly.

---
## The DOM & the Virtual DOM

### DOM (Document Object Model)
The browser's live object representation of your HTML — a tree of nodes that JavaScript can read and change.
- It's an API the browser exposes, not part of JavaScript itself. That's why `document` doesn't exist in Node.
- Changing it is what makes a page update on screen.

### Virtual DOM
A lightweight copy of the DOM kept as a plain JavaScript object in memory. React builds a new one on every render, compares it to the previous one, and applies only the differences to the real DOM.
- One of React's biggest performance optimizations: update only the parts of the page that actually changed instead of rebuilding the whole UI.
- It exists only in memory, so creating and throwing one away is cheap.

### Real DOM vs Virtual DOM ⚠️
| Real DOM | Virtual DOM |
|---|---|
| Browser object | Plain JavaScript object |
| Changes trigger layout/repaint | Exists only in memory |
| Manipulated by the browser | Managed by React |
| Expensive to touch repeatedly | Cheap to create and compare |
- ⚠️ The original note said the real DOM is "slow to update". That's the standard interview line but it's imprecise, and interviewers push on it. Writing to a DOM property is fast. What's expensive is the **layout / reflow / repaint** the browser does afterwards, and doing it many times in a row.

### Does React use the Virtual DOM instead of the real DOM?
**No.** The browser always renders the real DOM. React uses the Virtual DOM as an **optimization layer** on top of it.

### Is the Virtual DOM actually faster? ⚠️
It's faster than **naive** re-rendering, not faster than **optimal** hand-written DOM code.
- ⚠️ The original note said "React is faster because it diffs and updates only what changed." True as far as it goes, but the honest full answer is: a developer who hand-writes the minimal DOM update will always beat React, because React has to do the diff *as well as* the update.
- What the Virtual DOM actually buys you is that you write **declarative** code — "here's what the UI should look like for this state" — and get near-optimal updates for free. You trade a little raw speed for a lot of correctness and maintainability.
- Say both halves in an interview. It shows you understand the trade-off rather than reciting the marketing line.

### Reconciliation (diffing)
React's process of comparing the new Virtual DOM tree with the previous one to work out the minimum set of real-DOM changes needed.
- Heuristics that make it O(n) instead of O(n³): it only compares nodes at the same level, and a different element type means "throw the subtree away and rebuild".
- This is why **`key`** matters on lists — it's how React tells "this item moved" apart from "this item was replaced".

---

## JavaScript execution model

### Function invocation
Executing or calling a function. In JavaScript this happens when you write `functionName()`.
- Each invocation creates a new execution context and pushes a frame onto the call stack.

### Call stack
Also called the execution stack. A stack that keeps track of every function currently executing.
- **LIFO** — last in, first out. The most recently called function is the one that finishes and gets popped first.
- Synchronous only. Nothing else runs while a frame is on the stack, which is why a long loop freezes the page.

### Stack overflow
The error you get when the call stack grows too deep — classically from infinite recursion.
- `RangeError: Maximum call stack size exceeded`.
- Fix by adding a base case, or by converting deep recursion into a loop.

### Execution context
The environment a piece of code runs in. It holds that code's variables, its scope chain, and its `this`.
- Created in two phases: a **creation (hoisting) phase** where declarations are collected, then an **execution phase** where the code runs line by line.

### Global execution context
The default environment where your whole script starts running. Created when the script starts, and the first context created.
- All global variables and functions — anything declared outside a function — live here.
- `var` declarations at this level become properties of the global object (`window` in a browser) and start as `undefined`.
- `let` and `const` also live in the global context but are **not** attached to the global object, and they get no default `undefined` — they're in the Temporal Dead Zone until their line runs.

### Function execution context
A new context created every time a function is called, holding that call's own arguments, local variables, and scope chain.
- Popped and discarded when the function returns — **unless** a closure still references its variables.

### Environment Record (the old "Variable Object") ⚠️
Before the code inside a function runs, JavaScript collects all its variable and function declarations into a storage area, so the function already "knows" which names exist.
- ⚠️ Terminology: the original note calls this the **Variable Object**. That's ES3 wording. The modern spec calls it an **Environment Record** (or Lexical Environment). Either gets the point across, but say "environment record" if the interviewer is precise.

### Hoisting
The mechanism where variable and function declarations are conceptually moved to the top of their scope before the code executes.
- **Function declarations** are hoisted *with their body*, so you can call them before they appear in the file.
- **`var`** is hoisted and initialized to `undefined` — the name exists, the value doesn't yet.
- **`let` / `const`** are hoisted but left uninitialized, so touching them early throws (see Temporal Dead Zone).
- JavaScript doesn't simply "read all functions first, then variables." In the creation phase it processes **declarations**, and the *kind* of declaration decides the behaviour. If a `var` and a function declaration share a name, the **function wins**.

### Temporal Dead Zone (TDZ)
The window between entering a scope and reaching a `let` or `const` declaration, during which touching that variable throws a `ReferenceError`.
- This is the deliberate difference from `var`, which would silently give you `undefined`.

### `var` vs `let` vs `const`
- **`var`** — function-scoped, hoisted to `undefined`, attaches to the global object at top level, can be redeclared. **Avoid it.**
- **`let`** — block-scoped, in the TDZ until declared, reassignable.
- **`const`** — block-scoped, in the TDZ until declared, **cannot be reassigned**. The *binding* is fixed, not the value: `const arr = []; arr.push(1)` is legal.
- Interview answer for "why avoid `var`?": function scope instead of block scope, plus confusing hoisting behaviour.

---

## Scope & closures

### Scope chain
JavaScript's mechanism for resolving variables. It looks in the current scope first; if the name isn't there it searches each enclosing (parent) scope in turn, up to the global scope. If it's still not found, it throws a `ReferenceError`.
- This lexical lookup is what lets nested functions reach variables from their outer scopes.
- The chain is built from **where the code is written**, not from who called it.

### Lexical scope
Also called static scope. A function's scope is determined by **where it's written in the code**, not by where or how it's called.
- A function can access variables from its own scope and from any outer scope (parent functions, global). Never the other way around.

### Closure
A function that remembers and can access variables from its outer lexical scope **even after the outer function has finished executing**.
- Whenever a function is defined inside another function, then even once the parent's execution context is popped off the call stack, the inner function still holds on to the parent's variable environment and scope chain.
- That ability to "remember" its birthplace is the closure.
- What it's used for in practice: private state, function factories, `useState` in React, memoization, event handlers that need captured values.

```js
function counter() {
  let count = 0;                 // counter() has returned, but count survives
  return () => ++count;
}
const next = counter();
next(); // 1
next(); // 2
```

### Lexical scope vs closure ⚠️
They're related but not the same thing, and interviewers separate them.
- ⚠️ The original note said lexical scope "is also called a closure." Not quite.
- **Lexical scope is the rule** — the language decides what a function can see based on where it was written.
- **A closure is the consequence** — the retained environment that keeps those outer variables alive after the outer call has finished.
- One-liner: *lexical scope is the lookup rule; a closure is the memory that keeps the lookup working later.*

### Shadowing
An inner scope declaring a variable with the same name as an outer one. JavaScript always uses the **closest** declaration.
- So three nested `name` variables means the innermost one wins wherever you are.

### Why an outer function can't see inner variables
Scope lookup only goes **up**, never down. A variable declared inside a function belongs only to that function, so the parent can't reach it.

```
Global
   ↑
Outer
   ↑
Inner
```
- An inner function can look up the chain. An outer function cannot look down into a nested function's local scope.
- One-way street. This is the single most reliable way to explain scope in an interview.

---

## Types, coercion & equality

### Type coercion
JavaScript automatically converting one data type into another.
- `"5" + 2` → `"52"` — because **string + anything = string** (`+` is overloaded for concatenation).
- `"5" - 2` → `3` — because subtraction only works on numbers, so the string is converted.
- That asymmetry between `+` and `-` is the classic interview question.

### `==` vs `===`
- `==` compares after **type coercion** — `"5" == 5` is `true`.
- `===` compares value **and** type, with no coercion — `"5" === 5` is `false`.
- **Always prefer `===`**, precisely because it avoids coercion.
- The one accepted use of `==` is `x == null`, which is `true` for both `null` and `undefined`.

---

## Modern JavaScript syntax

### Destructuring
Pulling values out of an object or array into standalone variables in one statement.

```js
const { name } = user;                    // object
const { name: userName = "guest" } = user; // rename + default
const [first, second] = arr;              // array
```

### Spread operator (`...`)
Expands the elements of an array or the properties of an object.
- `[...[1, 2], 3, 4]` → `[1, 2, 3, 4]`
- Common uses: copying, merging, and updating arrays and objects — which is exactly how you keep state immutable in React and Redux.
- It's a **shallow** copy. Nested objects are still shared with the original.

```js
const newArr = [...arr];                       // copy
const merged = { ...defaults, ...overrides };  // merge, later wins
const updated = { ...user, name: "Habiba" };   // update one field
```

### Rest vs spread
Same `...` token, opposite directions — worth keeping straight because they look identical.
- **Rest** is on the *receiving* side: it collects many things into one. `function f(...args)`, or `const { a, ...others } = obj`.
- **Spread** is on the *giving* side: it takes one thing and hands out its parts. `f(...arr)`, `[...arr]`.

### Optional chaining (`?.`)
Reads a nested property and short-circuits to `undefined` instead of throwing if anything along the path is `null` or `undefined`.
- `user?.address?.city` — no `TypeError: Cannot read properties of undefined`.
- Also works on calls and indexes: `fn?.()`, `arr?.[0]`.
- Only guards `null` and `undefined`. It won't save you from a missing property on an object that does exist.

### Nullish coalescing (`??`)
Returns the right-hand side only when the left is `null` or `undefined`.
- The point is the contrast with `||`, which also falls through on `0`, `""`, `false`, and `NaN`.
- `count ?? 10` keeps a legitimate `0`. `count || 10` throws it away and gives you `10`. That bug is a very common interview question.

```js
const port = config.port ?? 3000;   // 0 stays 0
const port = config.port || 3000;   // 0 becomes 3000  ← usually a bug
```
---

## Async JavaScript & the event loop

### JavaScript is single-threaded
One thread, one call stack — but with support for asynchronous operations, so it handles concurrent tasks without blocking the main execution thread.
- "Concurrent, not parallel." Work waits in queues; it doesn't run side by side.
- The only real parallelism in the browser is **Web Workers**, which run on separate threads and communicate by message passing.

### Event loop
The mechanism that explains how asynchronous tasks are handled in the JavaScript runtime. It watches the task queues and the call stack, and moves pending work onto the stack when the stack is empty.
- The loop, in order: run all synchronous code → **drain the entire microtask queue** → take **one** task from the callback queue → drain microtasks again → repeat.
- It's not part of the JavaScript language. It lives in the runtime — the browser or Node.

### Callback queue (macrotask queue)
Holds callbacks that are ready to run once their async work has finished. FIFO.
- After an async event completes — a timer expires, a network request returns — its callback is placed here.
- When the call stack becomes empty, the event loop checks this queue, takes the **first** callback, and passes it to the call stack.
- Sources: `setTimeout`, `setInterval`, DOM events, I/O.

### Microtask queue (promise jobs queue)
Another internal FIFO queue, with **higher priority** than the callback queue — microtasks go ahead of regular callbacks in the line.
- Built for promise callbacks. When a promise settles (fulfilled or rejected), its `.then` / `.catch` / `.finally` handlers are scheduled here.
- The event loop processes microtasks right after the current task completes, **before** it moves on to the next task or takes anything from the callback queue.
- It drains the queue **completely**, including microtasks added while draining. An infinite chain of microtasks starves the callback queue and freezes the page — timers never fire.
- Sources: promise handlers, `async`/`await` continuations, `queueMicrotask`, `MutationObserver`.

### Execution order — the priority rule
**Call stack → microtask queue → callback queue.**
1. Synchronous code runs first, to completion.
2. Then JavaScript drains the microtask queue (promise jobs).
3. Only when the microtask queue is empty does it take a task from the macrotask/callback queue.

```js
console.log("1");
setTimeout(() => console.log("2"));        // macrotask
Promise.resolve().then(() => console.log("3"));  // microtask
console.log("4");
// 1, 4, 3, 2
```
- Being able to trace that output is one of the most common front-end interview exercises.

### Web APIs ⚠️
Functionality provided by the **browser environment**, reachable through the global `window` object. Not natively part of JavaScript, but essential for interactive apps.
- Examples: interacting with the DOM, scheduling with timers, network requests with `fetch`, handling data with `JSON`, `localStorage`, geolocation.
- **How they connect to the runtime:** Web APIs handle async work — events, network requests, timers — in the background, outside the normal JavaScript execution flow. When that work finishes, the corresponding callback is placed in a queue for the event loop to pick up.
- This is where the async work actually *happens*. JavaScript itself has no timer and no network stack; `setTimeout` is a browser feature, not a language feature.
- ⚠️ Correction to the original note, which said the finished callbacks — "event listeners **or promise callbacks**" — go to the Callback Queue. Promise callbacks go to the **microtask queue**; that's the entire reason it exists. Event listeners and timers go to the **callback (macrotask) queue**.

### Promise
An object representing a value that may be available now, in the future, or never. You attach handlers with `.then()`, `.catch()`, and `.finally()` to deal with the result.
- Three states: **pending** → **fulfilled** or **rejected**. Once settled it never changes again.
- Solves **callback hell** — deeply nested callbacks — by letting you chain flat `.then()` calls instead.
- Combinators worth knowing: `Promise.all` (all succeed or the first failure rejects), `allSettled` (never rejects, reports every outcome), `race` (first to settle either way), `any` (first to *succeed*).

### `async` / `await`
Syntactic sugar over promises that gives asynchronous code a synchronous-looking shape.
- **`async`** makes a function return a promise, and allows `await` inside it.
- **`await`** suspends that function until the promise settles, then resumes with the value (or throws on rejection).
- Important nuance: `await` pauses **the async function**, not the thread. The call stack unwinds and the browser stays responsive; the rest of the function is scheduled as a microtask.
- Error handling becomes ordinary `try` / `catch`, which is the main readability win over `.then().catch()`.
- Neither promises nor `async`/`await` are a substitute for multithreading. You're still on one core.

### Callback hell
Deeply nested callbacks-inside-callbacks, hard to read and harder to error-handle. The problem promises and `async`/`await` were created to solve.

---

## Memory & garbage collection

### Garbage collector
The mechanism responsible for identifying and freeing memory that's no longer in use. JavaScript frees memory automatically once an object is no longer **reachable** — nothing references it any more.
- Reachability, not reference counting, so a group of objects referencing only each other is still collected.
- When a function finishes, the local variables and references in its execution context are collected — **unless a closure still references them.**

### Common front-end memory leaks
Memory that stays reachable although the app no longer needs it.
- Event listeners never removed, `setInterval` never cleared, RxJS subscriptions never unsubscribed, detached DOM nodes still referenced by a variable, caches that only grow.
- In React this is what the **`useEffect` cleanup function** exists for.

---

## TypeScript

### TypeScript
A language that extends JavaScript with **static typing** and extra language features, improving maintainability and catching errors during development.
- Browsers execute JavaScript, not TypeScript — TS is compiled (transpiled) down to JS first.

### Static typing
The type of a variable is checked **before the program runs**, during compilation, rather than while it executes.
- Contrast with JavaScript's dynamic typing, where a variable's type is only known at runtime.

### Compile-time type checking & type erasure
TypeScript checks types at compile time only. All type information is **erased** in the emitted JavaScript.
- Consequence that interviewers love: there is **no runtime type checking**. A `User` typed value coming from an API might not actually be a `User`, and TypeScript can't tell you. Validate at the boundary with something like Zod if it matters.
- Also why you can't do `if (x instanceof MyInterface)` — the interface doesn't exist at runtime.

### Does TypeScript have its own event loop?
**No.** TypeScript compiles into JavaScript and uses the same JavaScript runtime and the same event loop.
- Same answer shape for anything runtime-related: TS adds no runtime behaviour, only compile-time checking.

### TypeScript & Angular
Angular applications are written primarily in TypeScript, which is transpiled into JavaScript before running in the browser.
- Angular leans on TS heavily — decorators, dependency injection, and strict templates all depend on type information.
---

## React fundamentals

### React
A **UI library** for building component-based interfaces, using a Virtual DOM to keep the real DOM in sync with your state.
- Library, not framework — it handles the view layer and leaves routing, state management, and HTTP to libraries you pick.

### Props vs state
- **Props** — data passed *into* a component from its parent. Read-only from the component's point of view.
- **State** — data the component *owns* and can change. Changing it triggers a re-render.
- Rule of thumb: if a value changes over time and the component controls it, it's state. If it comes from above, it's props.

### Hooks
Functions that let a function component use state and lifecycle features — capabilities that used to require class components.
- All start with `use`. Introduced in React 16.8.

### Rules of hooks
Two rules, and breaking either causes real bugs.
1. **Only call hooks at the top level** — never inside a condition, loop, or nested function. React matches hooks to state by call *order*, so a conditional hook shifts everything after it.
2. **Only call hooks from React function components or other custom hooks.**
- The ESLint plugin `eslint-plugin-react-hooks` enforces both. This is a very common interview question.

### `useState`
The fundamental hook for state. Lets you create and change state variables inside a function component, and track state in a function component at all.
- Enables interactivity: components update and re-render based on user actions, input, or data changes.
- Returns a pair — the current value and a setter. Calling the setter schedules a re-render; it does **not** mutate the variable in place.
- Updates are **asynchronous and batched**. Reading the state right after setting it gives you the old value. Use the functional form `setCount(c => c + 1)` when the new value depends on the old.

```js
const [count, setCount] = useState(0);
setCount(c => c + 1);   // safe with batching
```

### `useEffect`
Lets you perform **side effects** in a component — data fetching, subscriptions, timers, or manually touching the DOM.
- The **dependency array** controls when it runs: `[]` = once after mount, `[x]` = whenever `x` changes, omitted = after every render.
- The **returned function is cleanup** — it runs before the next effect and on unmount. This is where you remove listeners, clear intervals, unsubscribe, and abort fetches.
- In development, React 18+ StrictMode intentionally runs effects **twice** on mount to surface missing cleanup. It's not a bug; it's the point.

```js
useEffect(() => {
  const id = setInterval(tick, 1000);
  return () => clearInterval(id);   // cleanup
}, []);
```

### Side effect
Any operation that changes state outside its own scope, or produces an observable interaction with the outside world beyond returning a value.
- Examples: writing to the DOM, network requests, logging, writing to `localStorage`, mutating a variable from an outer scope.

### Pure function
A function whose output depends only on its inputs and which causes no side effects. The opposite of a side effect.
- Pure functions are predictable and easy to test, precisely because they don't read or alter external state.
- Two places this matters directly: **Redux reducers must be pure**, and React component render bodies should be pure (side effects belong in `useEffect`).

### `useRef`
Holds a mutable value that **survives re-renders without causing one**.
- Two uses: grabbing a DOM node (`<input ref={inputRef} />`), and storing a value you need to remember but don't want to render (a timer id, a previous value).
- Changing `ref.current` never triggers a re-render. That's the whole difference from state.

### `useMemo` and `useCallback`
Both cache something between renders so it isn't recreated every time.
- **`useMemo`** caches a computed **value** — use it for genuinely expensive calculations.
- **`useCallback`** caches a **function reference** — use it when passing a callback to a memoized child, so the child's props don't change identity every render.
- Neither is free. They add memory and comparison cost, so don't wrap everything. Measure first.

### `useContext`
Reads a value from a React Context, letting a component get shared data without it being threaded down through every intermediate component as props.
- Fixes "prop drilling". Not a full state manager — every consumer re-renders when the context value changes.

### Keys in lists
A stable, unique `key` prop on each item in a rendered list, so React's reconciliation can tell "this item moved" apart from "this item was replaced".
- Use a stable id from your data. **Don't use the array index** if the list can reorder, filter, or have items inserted — you get wrong state attached to the wrong row.

---

## React vs Angular

### React vs Angular — the comparison
React is a **UI library**; Angular is a **full-fledged front-end framework**.
- **Flexibility:** React gives you flexibility by letting you choose additional libraries (routing, state, HTTP). Angular provides most functionality out of the box.
- **Rendering:** React uses the **Virtual DOM**. Angular relies on its **change detection** mechanism.
- **Language:** Angular apps are written primarily in TypeScript. React works with either, though TypeScript is now the norm.
- **Structure:** Angular is opinionated — modules, services, DI, decorators. React leaves architecture to you.

### Angular change detection
Angular's mechanism for determining which parts of the UI need updating. **Angular does not use a Virtual DOM.**
- It tracks bindings and re-checks them when something might have changed, then updates the specific DOM bindings that differ.
- `ChangeDetectionStrategy.OnPush` limits checks to when an input reference changes — the standard Angular performance lever, roughly analogous to `React.memo`.

---

## State management

### State management
Managing the data, or state, within an application — everything from user input to data fetched from APIs, changing as users interact with the app.

### Why state management exists
Three problems it solves.
- **Keep the UI in sync with data** — the screen should always reflect the current state.
- **Enable communication across components** — state often needs to be shared and reachable by many components at once.
- **Handle complex data flow** — as an app grows, passing data between components and pages gets tangled. State libraries give structured tools and patterns for it.

### How state management works
Three steps, in a loop.
- **Storing state** — centralizing it somewhere all relevant components can reach.
- **Updating state** — triggered by actions like user interactions (a button click) or data fetching from an API.
- **Reacting to state changes** — components watching or subscribing to that state automatically re-render, keeping the UI in sync.

### Redux
A state management library for JavaScript apps, usually paired with React. Makes state and data easier to manage as an application's complexity grows.
- Modern Redux means **Redux Toolkit (RTK)** — it cuts the boilerplate dramatically and includes Immer, so you can write what looks like mutation and still get immutable updates.

### Store ⚠️
The centralized container holding the entire application state in Redux.
- **Single source of truth** — all state lives in one place, making it far easier to debug and trace changes.
- **Provides state to components** — components subscribe to it, so the UI stays in sync.
- ⚠️ Precision on the original note: it said "the store itself is immutable." What's immutable is the **state inside** it. The store is an object with methods — `getState()`, `dispatch()`, `subscribe()`. You can't mutate the state directly; only reducers, triggered by actions, produce a new state.

### Action
A plain object describing *what happened*, with a `type` and usually a `payload`. It says what occurred, never how state should change.

### Dispatch
Sending an action to the store. The view/UI component dispatches whenever an event occurs — a button click, a form submission.
- The only way to change state in Redux. That single entry point is what makes the data flow traceable.

### Reducer
A **pure function** that takes the current state and an action, and returns a **new** state. Reducers specify how the application's state changes in response to an action.
- Based on the action type, the reducer decides how state should change. Each reducer owns a specific slice of the state.
- It returns a **new state object** rather than mutating the existing one. **State is immutable.**
- Must be pure: no API calls, no random values, no dates, no mutation. Same inputs always give the same output.

### Subscribing to state changes
A component listens to the store for changes, so it re-renders automatically whenever the state it depends on updates.
- In React this is the `useSelector` hook rather than a manual `store.subscribe()`.

### Immutability — why Redux insists on it
Replacing state instead of editing it is what makes change detection cheap and history possible.
- A new object reference means a component can tell "something changed" with a `===` check instead of a deep comparison.
- It's also what enables time-travel debugging and predictable, replayable state.
- In practice: spread operators, or Redux Toolkit's Immer, which lets you write mutation-style code that produces immutable updates.

### NgRx
A state management library for **Angular**, built on Redux principles, providing a predictable state container for application data.
- Same core concepts — store, actions, reducers, selectors — plus **Effects**, which handle async work as RxJS observable streams.
---

## Routing & navigation

### Routing
A mechanism that enables navigation between different views or pages within a **single-page application (SPA)**, letting users move between components without reloading the entire page.
- The URL changes and the view changes, but the browser never does a full page load. Handled with the History API under the hood.
- Both React and Angular implement it differently with the same goal: a seamless experience where the view follows the URL.
- Both support **protected routes** (for authentication) and **lazy loading** (loading components only when needed).

### Routing in React
React has **no built-in routing**. It uses **React Router**, the standard library for it.
- Route guards aren't a built-in concept — you implement a **protected route component** instead.

```jsx
<Route element={<Authorization permissions={[PERMISSIONS.CAN_VIEW_ABOUT]} />}>
  <Route path="about" element={<About />} />
</Route>
```
- The wrapper route controls access to the nested routes based on user permissions.

### Routing in Angular
Angular has a **built-in router module** with powerful features out of the box.
- Nested routes, **route guards**, lazy loading, and parameterized routes.

### Route guards
Angular's built-in mechanism for protecting routes. A guard like `AuthGuard` allows only authenticated users to reach certain pages.
- Types: `canActivate` (can you enter?), `canDeactivate` (can you leave — unsaved changes?), `canLoad` / `canMatch` (can this lazy module even load?).
- Modern Angular uses functional guards rather than guard classes.

### Authorization component (the React equivalent of a guard)
A component that uses an auth hook to authenticate, then checks the user's permissions to authorize.
- If the user is authorized it renders the child route; if not it returns an `Unauthorized` component.
- This is the React pattern that replaces Angular's route guards — a wrapper component rather than a framework hook.

---

## Auth & HTTP

### Access token ⚠️
A **short-lived** token sent with each request to a protected API to prove the caller is allowed in.
- ⚠️ Precision on the original note, which said it "represents the user's identity and permissions." An access token represents **authorization** — what the bearer may do. **Identity** is the job of the **ID token** in OpenID Connect. An access token is a hotel key card: it opens room 402, it doesn't say your name.
- Sent as `Authorization: Bearer <token>`. Short lifetime (often 15 minutes) precisely because it can't be revoked before it expires.

### Refresh token
A **longer-lived** token used to obtain a new access token when the current one expires.
- More sensitive than the access token, and usually lasts much longer, so it must be stored more carefully.
- Rotate it on use, so a stolen refresh token has a short useful life.

### Storing tokens ⚠️
- The **access token** is typically kept **in memory** (or, less safely, in `localStorage`).
- The **refresh token** should be stored in an **httpOnly cookie** — inaccessible to JavaScript, so XSS can't read it.
- ⚠️ Worth being precise: `localStorage` is readable by **any** JavaScript on the page, so a single XSS bug or a compromised npm dependency leaks the token. In-memory is the safer answer, with the trade-off that the user is logged out on refresh — which is what the httpOnly refresh-token cookie exists to solve.
- Say the trade-off out loud in an interview: memory is safest, `localStorage` is convenient, httpOnly cookies protect the long-lived credential.

### Interceptors
Functions that let you modify HTTP requests and responses before they reach the server, or before the response reaches your code.
- **Adding tokens to requests** — attach the `Authorization` header centrally instead of in every call.
- **Handling token expiration** — the response interceptor watches for a **401 Unauthorized**. If the access token has expired, it uses the refresh token to get a new one, updates the headers, and **retries the original request**.
- **Error handling** — turn API errors into a consistent shape, log them, show a toast.
- **Request and response transformation** — reshape payloads in one place.
- Implementations: Axios interceptors in React; Angular's `HttpInterceptor`.
- Watch for the refresh loop: if the refresh call itself 401s, you must stop and log out rather than retry forever.

### Axios
A popular HTTP client library, widely used in React for API calls.
- Why it's chosen over native `fetch`: interceptors, automatic JSON parsing, timeouts, request cancellation, and it rejects on HTTP error statuses (`fetch` resolves on a 404, which surprises people).

---

## Forms & error handling

### Form state management
Handling form inputs — text fields, dropdowns, checkboxes — and keeping their values, errors, and touched/dirty status in sync with the UI.
- React: **controlled** inputs (value in state, the usual choice) vs **uncontrolled** (the DOM holds the value, read via a ref).
- Libraries that do the heavy lifting: React Hook Form, Formik; Angular's Reactive Forms.

### Client-side validation
Using JavaScript to check required fields, format (for example an email), or length, before submitting.
- Purpose is **user experience** — fast feedback without a round trip.

### Server-side validation
Even with client-side validation, data must also be validated on the server to ensure security.
- Client-side validation is a convenience and can be bypassed entirely with a direct API call. Server-side validation is the only one that actually protects you. Always both.

### Error handling best practices
- **Fallback mechanisms** — give the user an alternative when a request fails: retry, show cached data, or a degraded view.
- Catch errors at a boundary rather than in every component. React has **error boundaries** for render-time errors.
- Show a message the user can act on, and log the technical detail somewhere you can actually read it.

---

## Real-time & reactive programming

### Sockets / WebSockets
Enable real-time, two-way communication between client and server.
- Unlike HTTP, which is request-response, WebSockets let the **server push updates** to the client without waiting for a request.
- Use cases: chat applications, live updates, notifications, any real-time data streaming.
- Single long-lived connection over one TCP socket, so no per-message HTTP overhead.

### Reactive programming
A paradigm for handling **asynchronous data streams** and crafting responses to changes within those streams, to build more responsive applications.
- The mental shift: instead of writing *steps to take*, you **declare the application's behaviour when data changes**.

### RxJS
The library that brings reactive programming to JavaScript — the beating heart of it.
- Central to Angular (`HttpClient`, router events, NgRx Effects, forms all return observables). Rare in React, which leans on hooks instead.
- Gives a structured way to handle async operations, making complex async flows manageable without callback hell or deeply nested promises.

### Observable
A source of data that **emits values over time**.
- **Lazy** — nothing happens until something subscribes. Creating an observable does no work.
- Can emit **many** values, unlike a promise. Can also complete, or error.
- **Cold** observables start fresh per subscriber; **hot** ones share a single running source.

### Observer (subscriber)
An object that listens to the values emitted by an observable, defining what should happen when data arrives — updating the UI, doing a calculation, triggering another action.
- Three optional handlers: `next` (a value arrived), `error` (it failed), `complete` (it's done).
- Observers are essential to reactive programming because they define how to handle data emitted over time.

### Operators
Functions that transform, filter, combine, and manipulate observables, letting you process data streams declaratively.
- Everyday ones: `map`, `filter`, `switchMap` (cancel the previous inner stream — the right choice for typeahead search), `mergeMap`, `debounceTime`, `catchError`, `takeUntil`, `combineLatest`.
- Chained inside `.pipe()`.

### Subscription
The connection between an observer and an observable. Once you subscribe you keep receiving values until one of these happens.
- The observable **completes** (calls `complete()`), meaning it finished emitting.
- The observer hits an **error** (`error()`), which stops further emissions.
- You explicitly **unsubscribe**.
- Forgetting to unsubscribe is the classic Angular memory leak. Standard fixes: the `takeUntil(destroy$)` pattern, the `async` pipe (which unsubscribes for you), or `takeUntilDestroyed()`.

### Observable vs Promise
The comparison interviewers ask for whenever RxJS comes up.
| Promise | Observable |
|---|---|
| One value | Many values over time |
| Eager — runs on creation | Lazy — runs on subscribe |
| Cannot be cancelled | Cancellable via unsubscribe |
| `.then` / `.catch` | Operators in `.pipe()` |
| Built into the language | Needs RxJS |

---

## Build tooling & performance

### `package.json`
The file holding metadata about your project — dependencies, scripts, and other configuration settings.
- `dependencies` ship to production; `devDependencies` are build-time only.
- `package-lock.json` is what actually pins exact versions. Commit it.

### Bundling
Taking all the various JavaScript files (modules) in a project and combining them into a single file, or a few. That output is called a **bundle**.
- Why: fewer network requests, and browsers historically couldn't handle bare module imports.
- Tools: Vite (the current default), webpack, Rollup, esbuild, Parcel.

### Code-splitting
Dividing an application's JavaScript into smaller chunks (bundles) loaded separately, so instead of one large file for the whole app, only the parts needed for the current view are loaded.
- Improves **initial load time** by cutting how much JavaScript has to be downloaded and parsed up front.
- Natural split points: per route, and heavy libraries used on one screen only.

### Lazy loading in React ⚠️
Loading a component's **code** only when that component is first rendered, using `React.lazy` and `<Suspense>`. It optimizes performance by keeping the initial bundle small.
- ⚠️ Correction to the original note, which described it as "initially load and render limited data on the webpage… rendered when visited or scrolled." That describes something different. Two separate ideas got merged:
- **`React.lazy` / code-splitting** — defers downloading the **JavaScript for a component**. This is what "lazy loading in React" means in an interview.
- **Lazy loading content or images on scroll** — defers loading **data or media** until it's in view, done with `loading="lazy"` on images, `IntersectionObserver`, virtualization, or infinite scroll. Not a React feature at all.
- Know both, and name which one you mean.

```jsx
const Settings = React.lazy(() => import("./Settings"));
<Suspense fallback={<Spinner />}><Settings /></Suspense>
```

### Lazy loading in Angular
Primarily **module-based** and tightly integrated into the routing system.
- Angular's architecture lets you split the app into feature modules and load them on demand, only when needed.
- Wired up with `loadChildren` on a route. Modern Angular can also lazy-load **standalone components** with `loadComponent`, so it's no longer strictly module-based.

### Babel
A JavaScript **transpiler**. It lets you write modern JavaScript (ES6+, or even experimental syntax) and transforms it into older versions (like ES5) that a wider range of browsers understands.
- Keeps code compatible across environments, especially older browsers without support for the newest features.
- Transpiling ≠ compiling to a different language: JavaScript in, JavaScript out, just an older dialect.
- Also what handles JSX and TypeScript syntax stripping in many build setups.

### Linting
Analysing code to flag programming errors, bugs, stylistic problems, and suspicious constructs. A way to enforce coding standards across a team and keep code quality up.
- ESLint for correctness rules, Prettier for formatting. Keep them separate — Prettier decides how it looks, ESLint decides whether it's sane.
- Run it in CI, not just in the editor, or it gets ignored.

---

## Code structure & conventions

### Component-based architecture
Breaking the app into small, reusable components. A component should ideally **do one thing and do it well**.
- Payoff: reuse, isolated testing, and a change in one place not rippling outward.

### Single Responsibility Principle
Each component, function, or file should handle **one** responsibility.
- The practical test: if you struggle to name a component without using "and", it's doing too much.

### Modules
Modules help organize code by dividing it into separate, reusable pieces. Each module exports specific functionality that can be imported and used elsewhere in the application.
- ES modules (`import` / `export`) are the standard. Prefer named exports for anything you'll want to search for later.

### Naming conventions
Follow consistent naming across the project.
- **PascalCase** for components, **camelCase** for variables and functions, **UPPER_SNAKE_CASE** for constants, and often **kebab-case** for file names in Angular.
- The value isn't the specific choice — it's that everyone makes the same one.
---

## How to update this cheat sheet

**The `.md` file is the master. The `.html` is generated from it.** So you always edit the markdown, then regenerate the HTML if you want the searchable version updated.

### The format — three rules

1. **`##` starts a topic.** It becomes a section, a filter chip, and a Contents entry.
2. **`###` starts a term.** It becomes one card.
3. **Inside a term, the split is the first bullet.** Everything before the first `- ` line is the definition (big text). Everything from the first `- ` onward becomes the notes (small bulleted text).

That's the whole system. Copy this template:

~~~markdown
### My new term
The short definition goes here. One or two sentences, the thing you want to say out loud in an interview.
- First extra note — a caveat, a follow-up answer, a gotcha.
- Second extra note. These render smaller and greyer than the definition.
~~~

### Extras you can use

- **Flag a term** by putting `⚠️` at the end of the `###` heading: `### My term ⚠️`. It gets a warning stripe and shows up under the "⚠️ Corrections only" filter.
- **Inline code** with backticks and **bold** with `**asterisks**` — both work in the heading and the body.
- **Code blocks** — fence them with triple backticks and a language (` ```js `). Leave a blank line before the fence.
- **Tables** — normal markdown pipe tables work, header row and all.
- Blank line between the definition and the first bullet is optional; either way parses the same.

### Where to put a new term

- Put it inside the topic it belongs to. Topics and terms render in **file order**, so position matters — drop the term where it makes sense next to its relatives, not at the bottom.
- To add a whole new topic, add a `## Topic name` heading. Place it in the file according to the basics → advanced ordering, since that's the reading order.
- Don't renumber or re-slug anything; anchors are generated from the names automatically.

### Regenerating the HTML

`build_html.py` builds either cheat sheet. Pass it the markdown file you want to rebuild.

~~~bash
pip install markdown                              # once
python3 build_html.py frontend-cheatsheet.md       # this sheet
python3 build_html.py java-spring-cheatsheet.md    # the backend sheet
~~~

- It writes an `.html` file with the same base name, next to the markdown. No other input, no network.
- Term counts, topic chips, and the Contents panel are all recalculated automatically — nothing to update by hand.
- If you'd rather not run the script, just keep editing the markdown and use that. The content is identical.

### One thing that is hand-maintained

The **⚠️ Corrections** table at the top of the file is written by hand. If you flag a new term with `⚠️`, add a matching row there too — or don't, if you only want the inline flag. Everything else generates itself.
