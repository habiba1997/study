# Bash script + Docker

Source: https://app.notion.com/p/255fc75cbbd980cd8f0ee6e42c5da935?pvs=204

<i><code>#!/usr/bin/env sh</code></i>

<b>What it does</b>: Shebang line - tells the system to use the sh shell to execute this script

<b>Why sh not bash</b>: Alpine/minimal containers often don't have bash, but sh is always available

## <b>What is wget?</b>

<b>wget</b> is a <b>command-line utility</b> for downloading files from web servers. Think of it as a "web downloader" that can fetch content from HTTP, HTTPS, and FTP servers.

<b>Basic wget Examples:</b>

bash

```bash
# Download a file
wget https://example.com/file.zip

# Download and save with different name
wget -O myfile.zip https://example.com/file.zip

# Just check if a URL responds (like a ping for web servers)
wget --spider https://example.com/health
```

## <b>Why wget in Your Dockerfile?</b>

```bash
# Copy wget from busybox
COPY --from=busybox /bin/wget /bin/wget

# Use wget for health checking
HEALTHCHECK --start-period=240s CMD ["wget", "--server-response", "-O", "-", "http://localhost:8080/member-library-api/manage/health"]
```

<p />

- <b>-server-response</b>: Show HTTP response headers (useful for debugging)
- <b>O -</b>: Output to stdout (the - means "standard output", not a file)
- <b>http://localhost:8080/member-library-api/manage/health</b>: Your Spring Boot health endpoint

<b>What This Health Check Does:</b>

1. <b>Every 30 seconds</b> (Docker's default), Docker runs this command
2. <b>wget hits your health endpoint</b> to see if the app is responding
3. <b>If successful</b> (HTTP 200): Container marked as "healthy"
4. <b>If it fails</b> multiple times: Container marked as "unhealthy"
5. <b>Orchestrators</b> (like Kubernetes) can restart unhealthy containers

<p />

<b>Real-World Impact (architecture-wise):</b>

<b>In Production:</b>

- <b>Load balancers</b> route traffic only to healthy containers
- <b>Kubernetes</b> restarts containers that fail health checks
- <b>Monitoring tools</b> alert when containers become unhealthy
- <b>Auto-scaling</b> decisions based on healthy instance count

## <b>🤔 Why Copy wget from BusyBox?</b>

<b>Eclipse Temurin JRE images are MINIMAL</b>

\- they only contain:

- Java Runtime Environment
- Basic Linux utilities
- <b>NO wget, curl, or other network tools</b>

<code>FROM busybox as busybox                    # Busybox has wget
FROM eclipse-temurin:17.0.10_7-jre       # Main image doesn't have wget
COPY --from=busybox /bin/wget /bin/wget   # Copy just the wget binary</code>

<b>Why This Approach?</b>

- <b>Small image size</b>: Don't install entire package managers (\~300KB), well-tested
- <b>Security</b>: Fewer tools = smaller attack surface
- <b>Simple syntax</b> for HTTP requests and <b>Good error codes</b> for Docker to interpret

<b>❌ Alternative (worse) approach:</b>

```bash
# DON'T do this - installs lots of unnecessary packages
RUN apt-get update && apt-get install -y wget
```

<b>Memory Management (devops-wise)</b>

<code>ENV JAVA_OPTS_HEAP="-Xms500m -Xmx500m"</code>

<b>What this does:</b>

- <b>Xms500m</b>: <b>Initial heap size</b> = 500 megabytes
- <b>Xmx500m</b>: <b>Maximum heap size</b> = 500 megabytes

<b>Why this matters:</b>

- <b>Heap</b> = memory where Java objects live
- <b>Setting them equal</b> prevents memory resizing during runtime
- <b>500MB</b> is allocated immediately, no growing/shrinking
- <b>Predictable performance</b> - no pauses for memory allocation

<b>Thread-Local Allocation Buffers (TLAB)</b>

<code>JAVA_OPTS_TLAB="-XX:+UseTLAB -XX:TLABSize=256k -XX:+ResizeTLAB"</code>

<b>Breaking it down:</b>

- <b>XX:+UseTLAB</b>: Enable Thread-Local Allocation Buffers
- <b>XX:TLABSize=256k</b>: Each thread gets 256KB private allocation space
- <b>XX:+ResizeTLAB</b>: Allow TLAB size to adjust automatically

<b>What TLAB does:</b>

- <b>Each thread</b> gets its own private memory area
- <b>New objects</b> are allocated in thread's private space first
- <b>Reduces contention</b> between threads fighting for memory
- <b>Faster allocation</b> - no synchronization needed

<b>Real-world analogy:</b> Instead of one shared cash register, each thread gets its own mini-cash register.

<b>Garbage Collection & Performance (devops-wise)</b>

<code>JAVA_OPTS_OTHER="-XX:+UseG1GC -XX:+UseNUMA -XX:+HeapDumpOnOutOfMemoryError -XX:+UseCompressedOops"</code>

### <b>XX:+UseG1GC</b> (Garbage Collector Choice)

- <b>Enables G1 (Garbage First) collector</b>
- <b>Low-latency</b> garbage collection, try to keep these pauses as short as possible ⇒ Predictable pause times (usually \<10ms)

### <b>XX:+UseNUMA</b> (NUMA Awareness) \[ Non-Uniform Memory Access\]

- <b>Modern servers</b> have multiple CPU sockets
- <b>Each CPU</b> has closer/faster access to certain memory
- <b>This flag</b> helps Java place objects near the CPU that uses them

### <b>XX:+HeapDumpOnOutOfMemoryError</b> (Debugging)

- <b>When app runs out of memory</b>, create a heap dump file
- <b>Heap dump</b> = snapshot of all objects in memory
- <b>Essential for debugging</b> memory leaks
- <b>File saved automatically</b> when crash happens

### <b>XX:+UseCompressedOops</b> \[Ordinary Object Pointer\] (Memory Optimization)

- <b>Compresses pointers</b> from 64-bit to 32-bit when possible which saves memory on 64-bit JVMs

<b>🚀 Why Docker Layering is BRILLIANT (devops-wise)</b>

```docker
FROM eclipse-temurin:17.0.10_7-jre AS layered-jar
WORKDIR /layers
RUN java -Djarmode=layertools -jar /app.jar extract
```

<b>🔴 Without Layering (Old Way):</b>

Code change → Rebuild entire 200MB JAR → Upload entire layer

Build time: 5 minutes

<b>🟢 With Layering (Your New Way):</b>

Code change → Only rebuild 25MB application layer → Upload just that layer

Build time: 30 seconds

<b>Step by step:</b>

1. <b>java</b>: Start Java runtime
2. <b>Djarmode=layertools</b>: Special Spring Boot mode for layer extraction
3. <b>jar /app.jar</b>: Run your application JAR
4. <b>extract</b>: Command to layertools to extract layers

The folders are created in the <b>current working directory</b>, which is /layers (set by WORKDIR /layers):

/layers/<br />├── dependencies/           # External libraries (Spring, Jackson, etc.)<br />├── snapshot-dependencies/ # Your company's SNAPSHOT jars

├── spring-boot-loader/    # Spring Boot framework classes<br />└── application/           # YOUR business code

## <b>Why Your Docker Container is Headless</b>

Your Dockerfile includes this line:

<code>Djava.awt.headless=true</code>

<b>Without this flag</b>

, Java applications can try to:

- Open dialog boxes
- Create GUI windows
- Access graphics libraries
- Initialize display drivers

### <b>Container Environments Are Always Headless: (devops-wise)</b>

- <b>Docker containers</b> don't have displays
- <b>Kubernetes pods</b> run without GUI
- <b>Cloud servers</b> (AWS, Azure, GCP) are headless
- <b>CI/CD pipelines</b> run in headless environments

<p />
