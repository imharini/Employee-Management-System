Employee Management System

A Full-Stack Web Application for managing employee records with CRUD operations.
Built with Spring Boot (Backend), React.js (Frontend), and MySQL (Database).

Features:
1.Add new employees
2.View employee details
3.Update employee information
4.Delete employees
5.RESTful API integration (Spring Boot)
6.Persistent data storage with MySQL
7.Responsive frontend with React.js

Tech Stack:
Frontend: React.js, Axios, Tailwind/Bootstrap (if used)
Backend: Spring Boot, Spring Data JPA, REST APIs
Database: MySQL
Tools: IntelliJ IDEA, VS Code, Postman, Git & GitHub

Project Setup
🔹 Backend (Spring Boot)

1.Clone the repository:
git clone https://github.com/your-username/ems-backend.git
cd ems-backend

2.Configure application.properties (MySQL connection):
spring.datasource.url=jdbc:mysql://localhost:3306/ems
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3.Run the backend using IntelliJ IDEA or:
mvn spring-boot:run

🔹 Frontend (React.js)

1.Navigate to frontend folder:
cd ems-frontend

2.Install dependencies:
Install dependencies

3.Start development server:
npm run dev


License:
This project is licensed under the MIT License.
