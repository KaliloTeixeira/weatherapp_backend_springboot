# Dockerfile for Java 17 Spring Boot 3.1.2 project

# Use a base image with Java 17 installed
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Create a directory for the application
RUN mkdir -p /app/weatherapp_backend/target

# Copy the .war file to the container
COPY weatherapp_backend/target/weatherapp_backend-0.0.1-SNAPSHOT.war /app/weatherapp_backend/target/app.war

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "weatherapp_backend/target/app.war"]