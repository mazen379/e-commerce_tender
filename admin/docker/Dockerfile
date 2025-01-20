# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the maintainer label
LABEL maintainer="your-email@example.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Copy the application's jar to the container
COPY target/your-spring-boot-app.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]