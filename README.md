
Student Management System - README
---------------------------------------------------------------------------
Student Management System
---------------------------------------------------------------------------
Description
The Student Management System is a Spring-based Java application that allows users to perform CRUD operations (Create, Read, Update, Delete) on student records. It demonstrates the use of Java Persistence API (JPA), Spring framework for dependency injection, and integrates with a relational database to manage student information effectively.
---------------------------------------------------------------------------
Features
---------------------------------------------------------------------------
Add a new student with details like name, age, address, and phone number.
Retrieve student details by their unique ID.
Update existing student information by ID.
Delete a student record by ID.
List all students in the system.
Find a student by their name.
Technologies Used
Java: Programming language for backend logic.
Spring Framework: Used for Dependency Injection and configuration management.
Spring JPA (Java Persistence API): Used for database operations.
Hibernate: ORM framework to interact with the database.
MySQL: Relational database to store student data.
Maven: Dependency management and project build.
Lombok: To reduce boilerplate code.
----------------------------------------------------------------------------
Project Structure
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── jsp
│   │   │           ├── config
│   │   │           │   └── StudentConfig.java
│   │   │           ├── dao
│   │   │           │   └── StudentDao.java
│   │   │           ├── entity
│   │   │           │   └── Student.java
│   │   │           ├── exceptionClass
│   │   │           │   ├── InvalidAge.java
│   │   │           │   └── InvalidPhone.java
│   │   │           ├── service
│   │   │           │   └── StudentService.java
│   │   │           └── StudentDriver.java
│   │   └── resources
│   └── test
---------------------------------------------------------------------------

Installation and Setup
---------------------------------------------------------------------------
Clone the repository:
Use this Command
git clone https://github.com/yourusername/student-management-system.git
cd student-management-system
Configure the Database:

Open application.properties file and configure your database connection details:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=root
Run the application:

Open the project in your IDE (Eclipse, IntelliJ IDEA, etc.)
Build the project using Maven:
mvn clean install
Run the StudentDriver class as a Java application.
Use the application:

The application will allow you to input student details and interact with the database through a simple menu in the console.
License
This project is licensed under the MIT License.
