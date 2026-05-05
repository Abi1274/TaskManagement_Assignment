# 💼 Employee Task Management System & Task Manager (Core Java)

---

# 📌 1. Core Java Console Application  
## 🖥️ Task Manager (Custom Linked List + Multithreading)

### 📖 Overview
This is a **Core Java console-based application** that manages tasks using a **custom singly linked list**.  
It demonstrates **OOP concepts, data structures, multithreading, and synchronization**.

---

## 🛠 Technologies Used
- Java (Core Java)
- OOP Concepts
- Custom Linked List (No java.util.LinkedList)
- Multithreading
- Synchronization

---

## ⚙️ Features
- Add Task  
- Delete Task  
- Search Task  
- Display All Tasks  
- Reverse Task List  
- Multithreaded Task Processing  

---

## 🧠 Key Concepts

### ✔ Custom Linked List
- Implemented using `Node` and `TaskLinkedList`
- Manual traversal and manipulation

### ✔ Multithreading
- Two worker threads process tasks concurrently

### ✔ Synchronization
- Used `synchronized` methods
- Prevents race condition
- Ensures each task is processed only once

---

## 🔄 Task Processing Flow
1. Tasks are stored in custom linked list  
2. Threads fetch **PENDING tasks**  
3. Status changes to **IN_PROGRESS**  
4. Task is processed (simulated using `Thread.sleep()`)  
5. Status updated to **COMPLETED**

---

## ▶️ How to Run
1. Open project in Eclipse / IntelliJ  
2. Run `Main.java`  
3. Use console menu to perform operations  

---

## ⚠️ Assumptions
- Task ID must be unique  
- Priority values: HIGH / MEDIUM / LOW  

---

## ⚠️ Limitations
- Console-based UI  
- No database (data not persisted)  

---

## 🚀 Future Improvements
- Add database/file storage  
- Priority-based scheduling  
- GUI (JavaFX / Web UI)  

---

# 🌐 2. Spring MVC Web Application  
## 💼 Employee Task Management System

---

## 📖 Project Overview
This is a **Spring MVC web application** used to manage employees and assign tasks.  
It follows the **MVC architecture** and supports **CRUD operations with database integration**.

---

## 🛠 Technologies Used
- Java  
- Spring MVC  
- JSP  
- Maven  
- Apache Tomcat  
- MySQL  

---

## 📂 Modules

### 👨‍💼 Employee Management
- Add Employee  
- View Employee List  
- Edit Employee  
- Delete Employee  

### 📋 Task Management
- Create Task and assign to employee  
- View Task List  
- Edit Task  
- Delete Task  
- Update Task Status  

---

## ⚙️ Setup Instructions
1. Import project into Eclipse as **Maven Project**  
2. Configure **Apache Tomcat Server**  
3. Update database credentials in `DBConfig.java`  
4. Run the project on server  
5. Open browser:  
   http://localhost:8081/taskmanagement/employee/list  

---

## 🗄 Database Setup
- Execute the provided `database.sql` file in MySQL  

---

## 📸 Screenshots
- Screenshots are available in the `screenshots` folder  

---

## ⚠️ Assumptions
- Each task is assigned to one employee  
- Employee must exist before assigning a task  

---

## ⚠️ Limitations
- Basic UI (no advanced styling)  
- No pagination  
- Limited validation  

---

## 🚀 Future Improvements
- Add search and filter features  
- Implement pagination  
- Improve UI using Bootstrap  
- Add global exception handling  
- Develop REST APIs  

---

# 🎯 Interview Summary

This project demonstrates:
- Strong understanding of **Core Java concepts**
- Implementation of **custom data structures**
- Knowledge of **multithreading and synchronization**
- Experience in building **web applications using Spring MVC**
- Integration with **MySQL database**

---

## 👤 Author
**Abinaya P**
