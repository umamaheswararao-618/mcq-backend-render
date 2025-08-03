# Stage 1: Build the application using Maven
FROM maven:3.8.5-openjdk-17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file to download dependencies
COPY pom.xml .

# Download all the dependencies
RUN mvn dependency:go-offline

# Copy the rest of your source code
COPY src ./src

# Package the application into a JAR file
RUN mvn package -DskipTests


# Stage 2: Create the final, lightweight runtime image
FROM eclipse-temurin:17-jre-jammy

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port your application runs on (default for Spring Boot is 8080)
EXPOSE 8080

# The command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]