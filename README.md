# Employee Appraisal and Bell Curve - Spring Boot Application

## Overview

This application helps to manage employee appraisals and visualize their performance using a bell curve chart. The backend is built using Spring Boot, and the frontend provides an interactive UI to display appraisal data and bell curve statistics.

## Setup Instructions

### 1. Configure Database Credentials

- Open the `src/main/resources/application.yml` file.
- Update the following fields with your local PostgreSQL database connection details:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/your_database_name
    username: your_database_username
    password: your_database_password
    driver-class-name: org.postgresql.Driver
```



## 1. Set Up the Database

Navigate to the `src/main/resources/db/migrations/` directory.

Run the `initial_setup.sql` script on your local PostgreSQL database to create the necessary tables and insert initial data. You can execute the script using the following command:

```bash
psql -U your_database_username -d your_database_name -f src/main/resources/db/migrations/initial_setup.sql
```
# Application Setup Guide

## 3. Build and Run the Application

To build the application, follow these steps:

1. Open a terminal or command prompt and navigate to the root directory of your project.

2. Run the following Maven command to clean and install the necessary dependencies:

    ```bash
    mvn clean install
    ```

3. Once the build process is complete, start the Spring Boot application with the following command:

    ```bash
    mvn spring-boot:run
    ```

The application should now be running locally.

---

## 4. Access the Application

1. Open a web browser and navigate to the following URL to view the application’s user interface:

    ```text
    http://localhost:8080/index.html
    ```

2. You will see the bell curve chart along with the employee appraisal details displayed on the UI.

---

