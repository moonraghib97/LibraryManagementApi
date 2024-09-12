# Library Management System API

## Overview

This project is a RESTful API application developed using Spring Boot for a Library Management System. It implements a robust backend system for managing books, copies, loans, and members in a library setting. The system includes four main entities with linked relational database tables and exposes CRUD operations for each entity.

## Features

- RESTful API endpoints for CRUD operations on Books, Copies, Loans, and Members
- Authentication and authorization using JWT (JSON Web Tokens)
- Utilisation of various design patterns (Repository, Service, DTO)
- API documentation using Swagger

## Project Structure

The project follows a standard Spring Boot application structure:

```
librarymanagemenetsystem/
├── .idea/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── librarymanagementsystem/
│   │   │           ├── config/
│   │   │           │   └── SwaggerConfig.java
│   │   │           ├── controller/
│   │   │           │   ├── BookController.java
│   │   │           │   ├── CopyController.java
│   │   │           │   ├── JwtAuthenticationController.java
│   │   │           │   ├── LoanController.java
│   │   │           │   └── MemberController.java
│   │   │           ├── dto/
│   │   │           │   ├── BookDTO.java
│   │   │           │   ├── CopyDTO.java
│   │   │           │   ├── LoanDTO.java
│   │   │           │   ├── LoanMapper.java
│   │   │           │   ├── MemberDTO.java
│   │   │           │   └── MemberMapper.java
│   │   │           ├── entities/
│   │   │           │   ├── Book.java
│   │   │           │   ├── Copy.java
│   │   │           │   ├── Loan.java
│   │   │           │   └── Member.java
│   │   │           ├── repository/
│   │   │           │   ├── BookRepository.java
│   │   │           │   ├── CopyRepository.java
│   │   │           │   ├── LoanRepository.java
│   │   │           │   └── MemberRepository.java
│   │   │           ├── security/
│   │   │           │   ├── JwtAuthenticationEntryPoint.java
│   │   │           │   ├── JwtRequestFilter.java
│   │   │           │   └── SecurityConfig.java
│   │   │           ├── service/
│   │   │           │   ├── impl/
│   │   │           │   │   ├── BookServiceImpl.java
│   │   │           │   │   ├── CopyServiceImpl.java
│   │   │           │   │   ├── LoanServiceImpl.java
│   │   │           │   │   └── MemberServiceImpl.java
│   │   │           │   ├── BookService.java
│   │   │           │   ├── CopyService.java
│   │   │           │   ├── LoanService.java
│   │   │           │   └── MemberService.java
│   │   │           ├── util/
│   │   │           │   ├── JwtRequest.java
│   │   │           │   ├── JwtResponse.java
│   │   │           │   ├── JwtUserDetailsService.java
│   │   │           │   └── JwtUtil.java
│   │   │           └── LibrarymanagementsystemApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
├── target/
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Technologies Used

- Java 17 
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT for authentication
- Swagger for API documentation
- Maven for dependency management and build
- MySQL

## Prerequisites

- Java JDK 11 or later
- Maven 3.6.x or later
- MySQL

## Setup Instructions

1. Clone the repository:
   ```
   https://github.com/moonraghib97/LibraryManagementApi.git
   ```

2. Navigate to the project directory:
   ```
   cd librarymanagemenetsystem
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

This application uses JWT for authentication. To access protected endpoints:

1. Obtain a JWT token by sending a POST request to `/authenticate` with valid credentials.
2. Include the token in the Authorisation header of subsequent requests:
   ```
   Authorization: Bearer <your_jwt_token>
   ```

Refer to the Swagger documentation for more details on the authentication process.

## Contributing

We welcome contributions to this project. Please follow these steps to contribute:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/NewFeature`)
3. Make your changes
4. Commit your changes (`git commit -m 'Add some NewFeature'`)
5. Push to the branch (`git push origin feature/NewFeature`)
6. Open a Pull Request

Please ensure your code adheres to the existing style and passes all tests.


## Contact

Moon 
