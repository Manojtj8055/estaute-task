# Employee Bell Curve Calculation and Visualization

## Overview
This project implements a solution for fetching employee data and category details, calculating a bell curve distribution based on the data, and displaying the results in a chart.

![image](https://github.com/user-attachments/assets/79318f24-24c5-4668-9231-5e6a25178691)


## Features
- Fetch employee data and category details from the database.
- Perform bell curve calculations on the data.
- Visualize the results using a chart for better insights.
- A table of employee data with their appraisal details

## Technologies Used
- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **ORM**: Hibernate
- **Visualization**: Chart.js

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
    http://localhost:8080/api/index.html
    ```

2. You will see the bell curve chart along with the employee appraisal details displayed on the UI.

---

