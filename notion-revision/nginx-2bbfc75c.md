# NGINX

Source: https://app.notion.com/p/2bbfc75cbbd980d6a983e3990a829aa8?pvs=204

<image source="notion-file-block://2bbfc75c-bbd9-8065-a9f9-fbd2d807add0/78fd1607-2a4d-4d92-83a0-fbbc8f3f9f8c?space_id=4a3fc75c-bbd9-811b-84e1-0003c414a40d&name=image.png" />

<b>1. User Request</b>

- External user/browser makes HTTP/HTTPS request

<b>2. AWS Load Balancer</b>

- First entry point
- Distributes traffic across Kubernetes cluster
- Provides external IP address

<b>3. NGINX Ingress Controller</b>

- Acts as <b>reverse proxy</b> inside Kubernetes
  <p>
  <b>Forward Proxy (Client-side)Client → Forward Proxy → Internet/Servers</b>
  </p>

  - Sits <b>in front of clients (</b>Clients know about the proxy, Hides client identity from servers)
  - <b>Client says</b>: "Hey proxy, fetch google.com for me"

  <p>
  <b>Reverse Proxy (Server-side)Client → Reverse Proxy → Backend Servers</b>
  </p>

  - Sits <b>in front of servers (</b>Clients DON'T know backend servers exist, Hides server identity/architecture from clients)
  - <b>Client says</b>: "Give me myapp.com" (doesn't know there are 10 pods behind it)
- Routes traffic based on rules (host, path, etc.)
- Single entry point to cluster services
- Handles <b>SSL/TLS termination</b>: Decrypting HTTPS traffic at a specific point, then forwarding it as plain HTTP internally.
  ```xml
  Client (HTTPS encrypted) 
     ↓
  NGINX Ingress [DECRYPTS HERE] ← SSL/TLS TERMINATION
     ↓
  Backend Pods (HTTP unencrypted)
  ```
- Load balancing within cluster

<b>4. Services (svc)</b>

- Kubernetes Services group pods
- Provide stable internal endpoints
- Abstract pod location

## <b>Key Security Principle:</b>

<b>"Cluster component never directly exposed"</b>

- Pods and services hidden behind Ingress
- Only Load Balancer + Ingress are externally accessible
- Defense in depth: multiple layers of routing/security

## <b>Why This Architecture?</b>

- <b>Centralized routing</b>: One controller for all traffic rules
- <b>Security</b>: Internal components isolated
- <b>Scalability</b>: Easy to add/remove pods
- <b>SSL management</b>: Handled at ingress level
- <b>Cloud-native</b>: Works seamlessly with AWS EKS
