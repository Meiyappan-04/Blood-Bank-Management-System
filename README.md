# 🩸 Blood Bank Management System

A Java-based web application developed to manage blood donor records efficiently. The system allows users to add donor details, search for donors by name and donation date, and view all donor records. It follows the MVC architecture and uses Oracle Database for data storage.

---

## 📌 Project Overview

The Blood Bank Management System is designed to simplify donor record management. It provides a user-friendly interface for storing and retrieving donor information while ensuring unique record identification through automatic Record ID generation.

---

## ✨ Features

- ➕ Add new donor records
- 🔍 Search donor records by donor name and donation date
- 📋 View all donor records
- 🆔 Automatic Record ID generation
- ✔️ Input validation
- 🗄️ Oracle Database integration using JDBC
- 🏗️ MVC architecture for better code organization

---

## 🛠️ Technologies Used

- Java
- JSP (JavaServer Pages)
- Servlets
- JDBC
- Oracle Database 11g XE
- Apache Tomcat 10
- Eclipse IDE
- HTML
- CSS

---

## 📂 Project Structure

```
Blood Bank Management System
│
├── src/
│   ├── bean/
│   ├── dao/
│   ├── service/
│   ├── servlets/
│   ├── util/
│   └── exception/
│
├── WebContent/
│   ├── addDonor.jsp
│   ├── viewDonor.jsp
│   ├── viewAllDonors.jsp
│   ├── displayDonor.jsp
│   ├── displayAllDonors.jsp
│   ├── menu.html
│   ├── success.html
│   └── error.html
│
└── Database
    ├── Table Script
    └── Sequence Script
```

---

## ⚙️ Installation & Setup

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/Blood-Bank-Management-System.git
```

### 2. Import the project

Import the project into **Eclipse IDE** as an existing project.

### 3. Configure Oracle Database

- Create the `BLOODBANK_TB` table.
- Create the `BLOODBANK_SEQ` sequence.
- Update the database username and password in the database utility class.

### 4. Configure Tomcat

- Add Apache Tomcat 10 to Eclipse.
- Deploy the project to the server.

### 5. Run the application

Open your browser and visit:

```
http://localhost:8080/BloodBankManagementSystem/
```

---

## 📷 Screenshots

Added screenshots of the following pages:

- Home/Menu Page
- Add Donor
- View Donor
- View All Donors
- Success Page
- Error Page

Example:

```
README Images/
│
├── home.png
├── add-donor.png
├── view-donor.png
├── view-all.png
├── success.png
└── error.png
```

---

## 🚀 Future Enhancements

- Blood availability management
- Donor update functionality
- Delete donor records
- Search by blood group
- User authentication (Admin Login)
- Dashboard with donor statistics
- Responsive UI
- Email/SMS notifications for donors

---

## 👨‍💻 Author

**Meiyappan C T**

- GitHub: https://github.com/Meiyappan-04
- LinkedIn: https://linkedin.com/in/meiyappan-chidambaram-92488a412/

---

## 📄 License

This project is developed for learning and educational purposes.
