# Stage 1: Build the Spring Boot application using Maven
FROM maven:3.8.6-openjdk-17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies (cached layer for faster builds)
COPY doctor-api/pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY doctor-api/src ./src

# Build the application, generating the .jar file in /app/target/
RUN mvn package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the .jar file from the builder stage
COPY --from=builder /app/target/doctor-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on (default is 8080)
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]