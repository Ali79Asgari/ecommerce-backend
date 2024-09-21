# **E-commerce Backend Application**

This project demonstrates a simple backend service for a basic e-commerce application with a focus on shopping cart functionality. It is developed using **Spring Boot** in **Java/Kotlin** and implements essential programming concepts like RESTful APIs, object-oriented design, and basic data persistence using in-memory data structures.

## **Project Overview**

This backend system allows users to manage products and shopping carts via RESTful APIs. While no database is used, data is persisted using Java/Kotlin data structures. The system handles basic product management, shopping cart operations, and calculates cart totals.

### **Key Features**

- **RESTful API Endpoints**:
  - Provides endpoints to manage products (create, read, update, delete).
  - Manages shopping cart functionality (add, remove, update items).
  
- **Product Management**:
  - Track product details such as `name`, `description`, `price`, and `stock quantity`.
  
- **Shopping Cart Management**:
  - Add, remove, and update products in the shopping cart.
  - Calculate the total price of items in the cart.
  - Handle edge cases such as out-of-stock products.

- **Clean Architecture**:
  - Clear separation of concerns with modular services.
  
- **Unit Testing**:
  - Comprehensive test coverage to ensure the quality and reliability of the system.

## **API Endpoints**

### **Products**

- **GET** `/products`: Retrieve all available products.
- **GET** `/products/{id}`: Retrieve a specific product by ID.
- **POST** `/products`: Create a new product.
- **PUT** `/products/{id}`: Update an existing product.
- **DELETE** `/products/{id}`: Delete a product by ID.

### **Shopping Cart**

- **GET** `/cart`: Retrieve the current cart.
- **POST** `/cart`: Add a product to the cart.
- **PUT** `/cart/{id}`: Update a product in the cart.
- **DELETE** `/cart/{id}`: Remove a product from the cart.
- **GET** `/cart/total`: Calculate the total price of the cart.

## **Technical Details**

### **Tech Stack**

- **Programming Language**: Java
- **Framework**: Spring Boot
- **Data Persistence**: In-memory data structures
- **Testing Framework**: JUnit

### **System Design**

The application follows a basic layered architecture:
- **Controller**: Handles incoming API requests and maps them to services.
- **Service**: Contains business logic for handling products and shopping carts.
- **Model**: Defines product and shopping cart entities.
- **Repository**: Manages in-memory data persistence.

### **Tests**

This project includes unit tests to ensure that:
- Product creation, retrieval, update, and deletion are handled correctly.
- Shopping cart operations, including price calculation and stock management, work as expected.
