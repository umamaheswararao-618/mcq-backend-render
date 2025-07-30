# Use OpenJDK 21
FROM openjdk:21-jdk

# Set working directory
WORKDIR /app

# Copy JAR file
COPY target/Multiple-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8081

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
