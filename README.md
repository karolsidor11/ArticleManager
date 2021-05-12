# Article Manager
Article Manager is a simple article management application that issues a REST API for basic CRUD operations. 

## Overview
Application is written using Java 11, Spring Boot, JPA, running on the H2 database. 
The application is based on hexagonal architecture.

To import the project into your IDE execute ./gradlew eclipse or ./gradlew idea first (depending on your IDE) to generate project files and import them into IDE

### Building the application
```
 ./gradlew clean build -x test
```

### Unit tests
```
./gradlew test 
```

### Run the application 
```
./gradlew bootRun 
```
The application is available on swagger:
 http://localhost:8080/swagger-ui.html