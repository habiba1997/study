# API security

Source: https://app.notion.com/p/2b6fc75cbbd98038b1dbed0b0a319370?pvs=204

<p>
APIs are entry points into your system - like doors to your application. Without proper protection, attackers can access user data and compromise your entire system. 
</p>

## 1. Rate Limiting

<b>What it is:</b> Controls how many requests a client can make within a specific time period.

<b>How it works:</b>

- Set limits like "100 requests per minute per user"
- When someone exceeds the limit (request #101), block them temporarily
- After a cooldown period, they can make requests again

<b>Implementation levels:</b>

- <b>Per endpoint:</b> <code>/comments</code> endpoint might allow 50 requests/minute
- <b>Per user/IP:</b> Track requests by user ID or IP address
- <b>Global limits:</b> Overall system-wide limits to prevent DDoS attacks

<b>Why it matters:</b> Without rate limiting, attackers can:

- Send thousands of requests to crash your server
- Brute force passwords or data
- Use bots with different IPs to overwhelm your system (DDoS attack)

<p />
