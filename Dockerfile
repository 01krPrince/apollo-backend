# Use Java 17 base image
FROM eclipse-temurin:17-jdk

# Metadata (optional)
LABEL maintainer="iforg"

# Make a volume for temporary files
VOLUME /tmp

# Set the working directory
WORKDIR /app

# Copy the built jar file from the target directory to the container's working directory
COPY target/*.jar app.jar

# Expose port 8080 to make the app accessible externally
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar"]
