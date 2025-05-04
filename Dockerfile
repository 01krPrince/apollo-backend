# Use Java 17 base image
FROM eclipse-temurin:17-jdk

# Metadata (optional)
LABEL maintainer="iforg"

# Make a volume for temporary files
VOLUME /tmp

# Copy the built jar file into the container
COPY target/*.jar app.jar

# Command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "/app.jar"]
