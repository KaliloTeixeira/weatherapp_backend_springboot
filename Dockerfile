# Dockerfile for Java 17 Spring Boot 3.1.2 project

# Use a base image with Java 17 installed
FROM adoptopenjdk:17-jdk-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the .war file to the container
COPY /weatherapp_backend/target/weatherapp_backend-0.0.1-SNAPSHOT.war /app/app.war

# Expose the port on which the Spring Boot application will run
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.war"]
