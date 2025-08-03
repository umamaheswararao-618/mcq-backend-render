# Stage 1: Build the application using the Maven Wrapper with Java 21
# CHANGE: Updated the base image from version 17 to 21
FROM eclipse-temurin:21-jdk-jammy AS builder

# Set the working directory
WORKDIR /app

# Copy the Maven Wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Make the wrapper executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application.
RUN ./mvnw package -DskipTests -B


# Stage 2: Create the final, lightweight runtime image with Java 21
# CHANGE: Updated the runtime image from version 17 to 21
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copy the JAR file from the builder stage and rename it to app.jar
COPY --from=builder /app/target/*.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# The command to run your application.
ENTRYPOINT ["java", "-jar", "app.jar"]