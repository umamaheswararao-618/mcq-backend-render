# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy Maven wrapper and pom first (better caching)
COPY mvnw mvnw.cmd ./
COPY .mvn .mvn
COPY pom.xml ./

# Download dependencies
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy the source code
COPY src src

# Build the jar
RUN ./mvnw clean package -DskipTests

# Stage 2: Run
FROM openjdk:21-jdk
WORKDIR /app
COPY --from=builder /app/target/Multiple-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
