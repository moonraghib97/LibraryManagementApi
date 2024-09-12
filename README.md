# Library Management System API

## Overview

This project is a RESTful API application developed using Spring Boot for a Library Management System. It implements a robust backend system for managing books, copies, loans, and members in a library setting. The system includes four main entities with linked relational database tables and exposes CRUD operations for each entity.

## Features

- RESTful API endpoints for CRUD operations on Books, Copies, Loans, and Members
- Authentication and authorisation using Spring Security with OAuth and JWT
- Utilisation of various design patterns (Singleton, Factory, Strategy, Repository)
- API documentation using Swagger

## Project Structure

The project follows a standard Spring Boot application structure:

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── yourcompany/
│   │           └── library/
│   │               ├── config/
│   │               │   └── SwaggerConfig.java
│   │               ├── controller/
│   │               │   ├── BookController.java
│   │               │   ├── CopyController.java
│   │               │   ├── LoanController.java
│   │               │   ├── MemberController.java
│   │               │   └── JwtAuthenticationController.java
│   │               ├── dto/
│   │               │   ├── BookDTO.java
│   │               │   ├── CopyDTO.java
│   │               │   ├── LoanDTO.java
│   │               │   └── MemberDTO.java
│   │               ├── model/
│   │               │   ├── Book.java
│   │               │   ├── Copy.java
│   │               │   ├── Loan.java
│   │               │   └── Member.java
│   │               ├── repository/
│   │               │   ├── BookRepository.java
│   │               │   ├── CopyRepository.java
│   │               │   ├── LoanRepository.java
│   │               │   └── MemberRepository.java
│   │               ├── service/
│   │               │   ├── BookService.java
│   │               │   ├── CopyService.java
│   │               │   ├── LoanService.java
│   │               │   └── MemberService.java
│   │               └── LibraryApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── yourcompany/
                └── library/
                    └── [test classes]
```

## Technologies Used

- Java 17
- Spring Boot 
- Spring Security
- Spring Data JPA
- OAuth 2.0 and JWT for authentication
- Swagger  for API documentation
- MySQL

## Prerequisites

- Java JDK 11 or later
- Maven 3.6.x or later
- MySQL

## Setup Instructions

1. Clone the repository:
   ```
   git clone https://github.com/moonraghib97/LibraryManagementApi.git
   ```

2. Navigate to the project directory:
   ```
   cd library-management-system
   ```

3. Install dependencies:
   ```
   mvn install
   ```

4. Configure the database:
   - Open `src/main/resources/application.properties`
   - Update the database URL, username, and password according to your setup

5. Run the application:
   ```
   mvn spring-boot:run
   ```

The application should now be running on `http://localhost:8080`.

## API Documentation

API documentation is available via Swagger UI. Once the application is running, you can access it at:

```
http://localhost:8080/swagger-ui.html
```

This documentation provides detailed information about all available endpoints, request/response structures, and authentication requirements.

## Authentication

This application uses OAuth 2.0 with JWT for authentication. To access protected endpoints:

1. Obtain a JWT token by sending a POST request to `/api/authenticate` with valid credentials.
2. Include the token in the Authorisation header of subsequent requests:
   ```
   Authorization: Bearer <your_jwt_token>
   ```

Refer to the Swagger documentation for more details on the authentication process.

## Contributing

We welcome contributions to this project. Please follow these steps to contribute:

1. Fork the repository
2. Create a new branch 
3. Make your changes
4. Commit your changes 
5. Push to the branch 
6. Open a Pull Request

Please ensure your code adheres to the existing style and passes all tests.


## Contact

Moon Raghib - moonraghib97@gmail.com
