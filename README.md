# SponsoredAds

Prerequisites
Before proceeding with the build and run instructions, please make sure you have the following software installed on your machine:

- JDK 17 or higher
- maven
- Docker

Additionally, you will need to clone the repository of the Java 17 Spring Boot application to your local machine.

Build Instructions
To build the Java 17 Spring Boot application using IntelliJ IDEA, follow these steps:

- Open IntelliJ IDEA and import the cloned repository.
- Once the project is imported, go to the "Maven Projects" tab on the right-hand side of the window.
- Expand the project's folder.
- Expand the lifecycle option.
- Mark the options "Clean" + "Install" and press the run option. 
- This will build the Java 17 Spring Boot application and create an executable JAR file in the target directory.

Run Instructions - Using Docker Compose
- Make sure Docker is installed and running on your machine.
- Open a command prompt or terminal window.
- Navigate to the directory where the cloned repository is located.
- Run the following command to start the application and its dependencies (such as a MySQL database) in Docker containers:

docker-compose up -d
- Wait until the 2 containers (MySql and SponsoredAds) will pulled and running.
- After the 2 containers are up and running - you can use the Postman collection for testing the APIs



