-- Task 3: JDBC Integration
-- Run this file in MySQL Workbench (or mysql CLI) before running the Java app.

CREATE DATABASE IF NOT EXISTS weintern_jdbc_task;
USE weintern_jdbc_task;

CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL
);

-- A couple of sample rows are optional - the Java app can also insert
-- records on its own through insertRecord().
-- INSERT INTO employees (name, department, salary) VALUES ('John Doe', 'IT', 45000);
