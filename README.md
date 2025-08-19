# Task Manager Backend

This is the **backend** of the Task Manager application, built with **Spring Boot** and **MySQL**.  
It provides a REST API for authentication (login/register) and task management.

---

## ⚙️ Requirements

- Java 17+
- Gradle (wrapper included: `./gradlew`)
- MySQL 8+

---

## Clone the repository

- git clone git@github.com:DimitrisGkosios/Task-Manager-Back-End.git
- cd taskmanager

## Build the Project

- ./gradlew build

---
## 🚀 Running the Application

- ./gradlew bootRun

---
## 🛢 Database Setup

1. Create a MySQL database:

```sql
CREATE DATABASE taskmanagerdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'taskmanager'@'%' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON taskmanagerdb.* TO 'taskmanager'@'%';
FLUSH PRIVILEGES;

