# Spring Boot GraphQL Employee Management

A Spring Boot employee management application that provides both GraphQL and REST APIs using PostgreSQL and Spring Data JPA.

## Features

- Create and retrieve employees
- GraphQL queries and mutations
- REST API support
- PostgreSQL database integration
- Jakarta Validation
- GraphiQL interface

## Technology Stack

- Java 25
- Spring Boot 4.2.0
- Spring GraphQL
- Spring Data JPA
- PostgreSQL
- Maven

## Prerequisites

- JDK 25
- PostgreSQL
- Maven 3.9 or later

## Database Setup

Create a PostgreSQL database:

```sql
CREATE DATABASE employee_management;
```

Update `src/main/resources/application.properties` with your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/employee_management
spring.datasource.username=postgres
spring.datasource.password=your_password
```

## Run the Application

### Windows

```powershell
.\mvnw.cmd spring-boot:run
```

### Linux or macOS

```bash
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080`.

## GraphQL Endpoint

- GraphQL endpoint: `http://localhost:8080/graphql`
- GraphiQL interface: `http://localhost:8080/graphiql`

### Get All Employees

```graphql
query {
  employees {
    id
    name
    email
    department
    salary
  }
}
```

### Get an Employee by ID

```graphql
query {
  employee(id: "YOUR_EMPLOYEE_ID") {
    id
    name
    email
    department
    salary
  }
}
```

### Create an Employee

```graphql
mutation {
  createEmployee(
    input: {
      name: "Alice"
      email: "alice@example.com"
      department: "IT"
      salary: 60000
    }
  ) {
    id
    name
    email
    department
    salary
  }
}
```

## Project Structure

```text
src/main/java/com/example/employee_management/
├── employee
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
└── EmployeeManagementApplication.java

src/main/resources/
├── application.properties
└── graphql/
    └── employee.graphqls
```
