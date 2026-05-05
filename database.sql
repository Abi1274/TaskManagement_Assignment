CREATE DATABASE taskmanagement_db;
USE taskmanagement_db;

CREATE TABLE employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(100),
    email VARCHAR(100),
    department VARCHAR(100),
    designation VARCHAR(100)
);

CREATE TABLE task (
    task_id INT PRIMARY KEY AUTO_INCREMENT,
    task_title VARCHAR(100),
    description VARCHAR(255),
    priority VARCHAR(20),
    status VARCHAR(20),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);
