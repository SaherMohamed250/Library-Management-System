# Library-Management-System

### 🔧 Project Overview

This is a backend system for a Library Management System built using **Spring Boot**. The application manages books, users, and transactions, providing a clean, structured, and secure RESTful API.

---

### 🏗️ Design Decisions

- **Project Structure**  
  I followed the standard Spring Boot structure with clear separation of layers to make the codebase clean and easy to read.

- **Database Design**  
  - Started by designing the database schema.  
  - Defined all models with appropriate JPA annotations.  
  - Established relationships between tables (OneToMany, ManyToOne, etc.).  
  - Set primary keys and configured entity relationships using Spring Data JPA.

- **Repository Layer**  
  - Created repositories to handle direct data access and interaction with the database.

- **Service Layer**  
  - Wrote all business logic inside the service layer using the repositories.

- **API Layer (Controllers)**  
  - Created well-organized and clearly named API endpoints for each operation.  
  - Focused on making the endpoints RESTful and easy to understand.

- **Handling Circular References**  
  - Used `@JsonIgnore` to prevent infinite loops caused by bidirectional relationships during JSON serialization.

- **Security Integration**  
  - Integrated Spring Security for authentication and authorization.  
  - Implemented password encryption using BCrypt.  
  - Reused a pre-written JWT token generation and validation logic from a previous project.

- **Postman Testing**  
  - Verified all API endpoints using Postman to ensure correctness and reliability.

  
