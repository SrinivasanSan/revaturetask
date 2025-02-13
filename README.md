This project is designed to manage tasks. It allows users to add, update, delete, and view tasks. The system uses a MySQL database to store the task data.

Features

Add new tasks

Update task details

Delete tasks

View all tasks

Prerequisites

JDK 8 or later

MySQL 5.7 or later

Maven (for project management and dependencies)

Installation

1. Clone the repository:

git clone https://github.com/SrinivasanSan/revaturetask.git

2. Set up the MySQL Database:

Create the database using the following SQL command:

CREATE DATABASE Task;

3. Configure Database Connection:

Update the application.properties file in the src/main/resources directory with your database credentials.

Example:
server.port=9090
spring.datasource.url=jdbc:mysql://localhost:3366/task
spring.datasource.username=root
spring.datasource.password=Srini@2002
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
