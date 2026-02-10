<img width="1918" height="1026" alt="Screenshot 2026-02-10 125036" src="https://github.com/user-attachments/assets/b2a921c4-b422-41e4-8a42-ec6201a9f4d7" /># Online Banking System

A backend banking system built using Spring Boot and PostgreSQL.

## Features
- User registration & login
- Deposit & withdraw
- Balance check
- PostgreSQL database
- REST APIs
- Layered architecture (Controller, Service, Repository)

## Tech Stack
Java  
Spring Boot  
PostgreSQL  
JPA/Hibernate  
Maven

## Run Locally
1. Create database: bankdb
2. Update application.properties with DB credentials
3. Run:
   mvn spring-boot:run

## API Endpoints
Register:
GET /users/register?name=&password=&balance=

Login:
GET /users/login?name=&password=

Deposit:
GET /users/{id}/deposit?amount=

Withdraw:
GET /users/{id}/withdraw?amount=

Get User:
GET /users/{id}

## Working Status
1.User Registration API Response (Spring Boot Running on localhost:8080)
<img width="1918" height="1026" alt="Screenshot 2026-02-10 125036" src="https://github.com/user-attachments/assets/ed72fea6-6259-43ed-b7ea-e7af8dc30614" />

2.PostgreSQL Database Table View in DBeaver (User Data Stored Successfully)
<img width="1919" height="1020" alt="Screenshot 2026-02-10 125055" src="https://github.com/user-attachments/assets/8b5952f9-4efb-4681-ab72-45e5a643a8ea" />

3.Withdraw API Execution and Updated Balance Response
<img width="1919" height="961" alt="Screenshot 2026-02-10 125135" src="https://github.com/user-attachments/assets/8493212b-c9ed-4920-b2b8-02e880b40080" />

4.Database Verification After Transaction (Updated Balance in PostgreSQL)
<img width="1919" height="1003" alt="Screenshot 2026-02-10 125214" src="https://github.com/user-attachments/assets/2c76f73c-f683-4efc-9ab4-f469b9a0e694" />







