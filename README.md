# Student Management System Using JDBC PreparedStatement

## Project Overview
The Student Management System is a console-based Java application that performs database operations on student records using JDBC and MySQL. It uses `PreparedStatement` to execute SQL queries and manage student data.

## Technologies Used
- Core Java
- JDBC (Java Database Connectivity)
- MySQL
- PreparedStatement
- ResultSet
- SQL CRUD Operations
- Exception Handling

## Project Structure
```text
Student-Management-System/
└── src/
    └── com/
        └── jdbc/
            ├── client/
            │   └── TestStudent.java
            ├── service/
            │   └── I/
            │       └── Requirement.java
            └── service/
                └── impl/
                    └── ServiceImpl.java
```

## Features
1. Create the student table.
2. Insert multiple student records.
3. Update a student's name using their roll number.
4. View all student records.
5. Delete a student record using their roll number.
6. Delete the complete student table.

## Student Table Structure

| Column | Data Type | Constraint |
|---|---|---|
| rollno | INT | Primary Key |
| name | VARCHAR(45) | NOT NULL |
| marks | FLOAT | — |
| email | VARCHAR(45) | UNIQUE |

## Database Configuration
- Database name: `day2_preparedstatement`
- MySQL port: `3308`
- Username: `root`

Update the connection URL, username, and password in `ServiceImpl.java` according to your MySQL configuration.

## How to Run
1. Install Java and MySQL.
2. Create the `day2_preparedstatement` database.
3. Add the MySQL Connector/J library to the project.
4. Open the project in Eclipse, IntelliJ IDEA, or VS Code.
5. Run `TestStudent.java`.
6. Choose an operation from the console menu.

## JDBC Concepts Demonstrated
- Establishing a database connection using `DriverManager`.
- Executing SQL statements using `PreparedStatement`.
- Retrieving records using `ResultSet`.
- Performing insert, update, select, and delete operations.
- Managing database tables using SQL commands.

## Data Storage
Student records are stored in a MySQL database, so data persists after the Java application terminates unless records or the table are deleted.

## Author
Java Developer Fresher
