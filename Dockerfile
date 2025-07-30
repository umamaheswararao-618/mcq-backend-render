# Use OpenJDK 21
FROM openjdk:21-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies (offline build)
RUN ./mvnw dependency:go-offline

# Build the application
RUN ./mvnw clean package -DskipTests

# Copy the built jar to app.jar
COPY target/Multiple-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
