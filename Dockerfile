# Start with a base image of OpenJDK 23
FROM openjdk:23-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar file (Ensure the jar file is built with mvn clean package)
COPY target/EcommerceBackend-0.0.1-SNAPSHOT.jar ecommerce-backend.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application with Java 23
ENTRYPOINT ["java", "-jar", "ecommerce-backend.jar"]