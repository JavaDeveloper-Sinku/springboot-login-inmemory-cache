
# Login System with Spring Boot, H2, and Spring Cache

This project is a **Spring Boot-based login system** demonstrating how to implement a fast login API using **H2 in-memory database** and **Spring Cache abstraction**.  
The system clearly shows **DB hits vs Cache hits** in the console.

---

## Features

- **Login API** with username and password  
- **H2 in-memory database** for storing user credentials  
- **Spring Cache abstraction** to reduce database load  
- Console logging of **DB hits** and **Cache hits**  
- Separate `UserCacheService` to handle cacheable DB fetch (best practice)  
- Supports multiple users  

---

## Technologies Used

- Java 17+  
- Spring Boot 3.x  
- Spring Data JPA  
- H2 Database (in-memory)  
- Spring Cache abstraction (ConcurrentMapCache by default)  
- Maven   

---

## Project Structure

```

src/main/java
├── controller
│   └── AuthController.java         # Handles login API
├── service
│   ├── AuthService.java            # Login logic + cache detection
│   └── UserCacheService.java       # Cacheable DB fetch service
├── entity
│   └── User.java                   # User entity
├── repository
│   └── UserRepository.java         # JPA repository for User
└── dto
└── LoginRequest.java           # DTO for login request

````

---

## Setup Instructions

1. **Clone the repository**  

```bash
git clone <repo-url>
cd loginSystem
````

2. **Run the application**

* Using IDE ( IntelliJ ) → Run `LoginApplication`

```bash
mvn spring-boot:run
```

3. **Access H2 console**

* URL: `http://localhost:8080/h2-console`
* JDBC URL: `jdbc:h2:mem:testdb`
* User: `sa`
* Password: *(leave blank)*

4. **Insert test users**

```sql
INSERT INTO USERS (USERNAME, PASSWORD) VALUES ('rishi', '1234');
INSERT INTO USERS (USERNAME, PASSWORD) VALUES ('john', 'abcd');
```

---

## API Endpoints

### Login

```
POST /auth/login
Content-Type: application/json
```

**Request Body:**

```json
{
  "username": "rishi",
  "password": "1234"
}
```

**Responses:**

* `"Login successful"` → Correct credentials
* `"Invalid credentials"` → Wrong password

---

## Console Behavior

* **DB HIT** → Printed when the database is accessed for the first time:

```
[DB HIT] Fetching user: rishi
Login successful for: rishi
```

* **Cache HIT** → Printed when data is fetched from cache:

```
[CACHE HIT] Returning cached user: rishi
Login successful for: rishi
```
