# Online Bank Management System (Java + REST API)

A Java-based console application that simulates basic banking operations using REST APIs.
The project uses json-server as a mock backend and follows real-world backend design principles.

---

## Features
- Add new users (duplicate users prevented)
- View balance using unique user ID
- Deposit money
- Withdraw money with validation
- REST API integration using HTTP (GET, POST, PATCH)

---

## Tech Stack
- Java (Core Java)
- REST API
- json-server
- VS Code

---

## Project Structure
- online-bank-management/
  ├── Main.java
  ├── ApiClient.java
  ├── db.json


---

## ▶ How to Run

### 1. Start Backend Server
```bash
json-server --watch db.json --port 3000

### 2.Compile & Run Java App
javac *.java
java Main