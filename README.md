# SpringORM

This project demonstrates a basic CRUD (Create, Read, Update, Delete) operation using Spring ORM, Hibernate, and MySQL with XML-based configuration.

🔧 Technologies Used
Java 17

Spring Framework 5.3.24

Spring ORM

Hibernate 5.6.14

HikariCP (Connection Pool)

MySQL 8.0.33

Maven

XML Configuration (No Java-based or Annotation-only config)

🗂️ Project Structure

![image](https://github.com/user-attachments/assets/4a03c927-5f3c-4cdc-88cb-e41128fde294)



🏃 How to Run
Set up the MySQL database:

Create a database (e.g., application)

Update credentials and URL in applicationContext.xml

Build the project:

bash
Copy
Edit
mvn clean install
Run the test or main class:

bash
Copy
Edit
java -cp target/ORMProj01-CURDOperations-0.0.1-SNAPSHOT.jar com.nt.test.YourTestClass


✨ Features
XML-based Spring configuration

Hibernate with annotation-based entities

HikariCP for high-performance DB connections

Basic CRUD: Add, Retrieve, Update, Delete

Lightweight and modular structure

📌 Notes
Lombok annotations require Lombok plugin in your IDE.

Hibernate hbm2ddl.auto=update is useful for dev/testing. For production, consider managing schema manually.

🧑‍💻 Author
Vaibhav Shete
Associate Software Developer
LinkedIn | GitHub
