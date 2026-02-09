# Online Banking System

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
