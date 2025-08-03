# Stage 1: Build the application using the Maven Wrapper
FROM eclipse-temurin:17-jdk-jammy AS builder

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

# Build the application. The -B flag runs it in batch mode (less verbose logs)
RUN ./mvnw package -DskipTests -B

# (Optional Debugging Step) - This will list the contents of the target directory
# so you can see the JAR file name in the Render build logs if it fails again.
RUN ls -la target/


# Stage 2: Create the final, lightweight runtime image
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Define an argument for the JAR file name
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the builder stage and rename it to app.jar
# This is a more robust way to copy, as it doesn't depend on the version number.
COPY --from=builder /app/${JAR_FILE} app.jar

# Expose the port your application runs on
EXPOSE 8080

# The command to run your application.
# It looks for app.jar in the root of the WORKDIR.
ENTRYPOINT ["java", "-jar", "app.jar"]