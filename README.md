# Catalog Service

## Overview
The `Catalog Service` is a Spring Boot application designed to register itself with a Eureka server for service discovery. It is part of a microservices architecture and communicates with other services via Eureka.

## Features
- Service discovery using Eureka.
- Configurable via `application.yml`.
- Dockerized for easy deployment.

## Prerequisites
- Java 21
- Gradle
- Docker
- IntelliJ IDEA (optional, for development)

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/tirth-grid/catalog-service.git
cd catalog-service
```
### Build the Project
```bash
./gradlew build
```
### Run the Application
```bash
./gradlew bootRun
```
### Access the Application
Open your web browser and navigate to:
```
http://localhost:8080/catalog
```
### Docker
To build and run the application in a Docker container, follow these steps:
1. Build the Docker image:
   ```bash
   docker build -t catalog-service .
   ```
2. Run the Docker container:
   ```bash
    docker run -p 8080:8080 catalog-service
    ```
### Configuration
The application can be configured via the `application.yml` file located in the `src/main/resources` directory. Key configurations include:
- `eureka.client.serviceUrl.defaultZone`: URL of the Eureka server.
- `server.port`: Port on which the application runs.
- `spring.application.name`: Name of the application as registered with Eureka.
### Testing
To run tests, use the following command:
```bash
./gradlew test
```
### IntelliJ IDEA Setup
If you are using IntelliJ IDEA, you can import the project as a Gradle project:
1. Open IntelliJ IDEA.
2. Select "Open" and choose the `build.gradle` file.
3. Wait for IntelliJ to import the project and download dependencies.
4. Run the application using the Gradle tool window or by right-clicking the main class and selecting "Run".
5. Ensure that the Gradle wrapper is configured to use Java 21 in IntelliJ IDEA:
   - Go to `File` -> `Project Structure` -> `Project`.
   - Set the `Project SDK` to Java 21.
   - Set the `Project language level` to 21.
### Troubleshooting
If you encounter issues, check the following:
- Ensure that the Eureka server is running and accessible.
- Check the application logs for any errors.
- Verify that the `application.yml` file is correctly configured.