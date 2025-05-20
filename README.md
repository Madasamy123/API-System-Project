# 🏋️‍♂️ Fitness Management System

A simple Fitness Management System built using Java Spring Boot for backend APIs. This system allows **Users** to manage their fitness data and **Admins** to monitor user details.

---

## 📌 Project Overview

This system helps users track their fitness-related data (like workouts, progress, profile info). It supports:

- User registration and login
- Adding and viewing workout records
- Updating user profile
- Admin dashboard to view all users and their data

---

## ✨ Features

User Registration & Login (with JWT token)

Admin & User roles

Users can:

Add/update/delete their health metrics

View personal profile

Admins can:

View all users

Manage user metrics

## 🛠️ Tech Stack

- **Backend:** Java Spring Boot  
- **Database:** MySQL  
- **API Testing:** Postman, Swagger UI  
- **Tooling:** IntelliJ IDEA, Maven

---

🗂️ ER Diagram (Entity Relationship Diagram)

![Screenshot 2025-05-20 175932](https://github.com/user-attachments/assets/5756e51b-40f7-4c6e-9b56-148b9fb95971)


## 👥 Roles and Permissions

| Role   | Permissions |
|--------|-------------|
| **User** | 🔹 Add Fitness Data <br> 🔹 View Their Own Data <br> 🔹 Update Profile |
| **Admin** | 🔹 View All Users <br> 🔹 View Fitness Data of All Users |

---

## 🔐 Authentication Flow

User registers via /api/auth/register

Logs in via /api/auth/login

Receives JWT token

Sends token in Authorization: Bearer <token> for all protected routes


## 📸 Swagger Screenshot

![Screenshot 2025-05-20 173440](https://github.com/user-attachments/assets/5169c077-d228-4464-96e7-55b60cee860d)


To generate Swagger UI, visit: http://localhost:8080/swagger-ui/index.html#/



## ✨ How to Run

Clone project 

Set DB config in application.properties

Run using IntelliJ or mvn spring-boot:run

Use Postman or Swagger to test endpoints


## Clone Project

git clone https://github.com/Madasamy123/API-System-Project.git
cd fitness-management
