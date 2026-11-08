# Webflux

Source: https://app.notion.com/p/276fc75cbbd980978f00caba52c72a80?pvs=204

Spring WebFlux is part of the <b>Spring 5</b> release and introduces support for <b>reactive programming</b>. It is built on <b>Project Reactor</b> and enables you to build:

1. Non-blocking APIs
2. Scalable microservices
3. Real-time applications

In short, WebFlux helps handle massive I/O-bound tasks efficiently by freeing threads to serve other requests while waiting for I/O to complete.

- Based on the <b>Reactive Streams</b> specification.
- Works with <b>Reactor</b> (Mono and Flux) and other reactive libraries like <b>RxJava</b>

Engine: <b>Netty</b> (not Tomcat or Jetty) → non-blocking HTTP server runtime

<image source="notion-file-block://276fc75c-bbd9-80c6-be0d-eb8c01e1b774/ea67b0e0-3948-4c9c-ab40-74806adc0865?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

# <b>Reactive Programming</b>

some reactive paradigms in WebFlux:

1. <b>Publisher and Subscriber</b>:

- A <code>Publisher</code> emits data asynchronously.
- A <code>Subscriber</code> consumes the emitted data.

<b>2. </b><b><u>Mono</u></b><b> and </b><b><u>Flux</u></b>:

- <b>Mono</b>: Represents 0..1 elements (single result).
- <b>Flux</b>: Represents 0..N elements (stream of results).

<b>3. Non-Blocking Nature</b>:

- Threads are not blocked when waiting for a resource (e.g., DB call). Instead, resources are released back to handle other tasks.

<p>
Note: 
</p>

<code>.cache()</code> turns the <code>Flux</code> into something like a <b>hot, memoized stream</b>:

- On the <b>first subscription</b>, it runs the pipeline and saves the results in memory.
- On <b>subsequent subscriptions</b>, it just replays the cached results instead of re-executing the save logic.

<page url="https://app.notion.com/p/277fc75cbbd980edae25d3358a0ab90e">
<b>Predicates in Spring Cloud Gateway</b>
</page>

<page url="https://app.notion.com/p/277fc75cbbd980dca441ff7b72dcba8f">
EnableR2dbcAuditing && <b>R2DBC repositories</b>
</page>
