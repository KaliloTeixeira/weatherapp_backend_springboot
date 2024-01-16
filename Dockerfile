# Dockerfile for Java 17 Spring Boot 3.1.2 project

# Use a base image with Java 17 installed
# use another base image if you want to use a different Java version
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the .war file to the container
COPY /weatherapp_backend/target/weatherapp_backend-0.0.1-SNAPSHOT.war /app/app.war

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.war"]

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.war"]
