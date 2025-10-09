

# Focus Track API

![Java](https://img.shields.io/badge/Java-21-blue) 
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.6-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![OpenAPI](https://img.shields.io/badge/OpenAPI-3.0-orange)
![GitHub Repo Size](https://img.shields.io/github/repo-size/cstefc/focus_track_api)
![GitHub Stars](https://img.shields.io/github/stars/cstefc/focus_track_api?style=social)


**Focus Track API** is a work-in-progress project designed as a portfolio piece to showcase my backend development skills. It allows me to deepen my knowledge of **Spring Boot** while building a practical application to help track personal goals.  

This API is part of a full-stack project. The corresponding front-end can be found on my GitHub [here](https://github.com/cstefc/focus_track_ui). The goal is to create a seamless application for managing todos, logging progress, and tracking personal objectives.
## Tech Stack

- **Backend**: Spring Boot  
- **Database**: PostgreSQL 17
- **Language**: Java 21  
- **Authentication**: Planned (OAuth/JWT)  
- **Front-end**: React [(link to repo)](https://github.com/cstefc/focus_track_ui)
## Features (Work in Progress)

- **Environment Variables**: Sensitive information such as database credentials is stored in `.env` files.  
- **User Endpoint**: `/users` – Returns JSON data of all users.  
- **Mock Data**: Pre-generated data available for front-end development and testing purposes.  

> ⚠️ Note: Additional endpoints for todos, goal tracking, and sports sessions are planned as the API continues development.
## Roadmap

The project follows a **feature-driven development approach**, starting from the front-end and then integrating with the back-end. Planned features include:

- **OAuth Authentication** – Secure communication between front-end and back-end.  
- **Project Management** – Ability to create and manage projects.  
- **Plans & Steps** – Add detailed plans with steps inside projects.  
- **Logging Feature** – Track progress and updates within projects.  
- **Events** – Add and manage events related to goals and projects.

> ⚠️ Note: These features are under development and will be gradually implemented.
## Usage / Examples

### Prerequisites
- **PostgreSQL** database + user for the API  
- **Java 21** installed  

### Step 1: Create '.env' file
Create a '.env' file in the project root (or set the environment variables locally). Default values:

```
DB_USER=postgres
DB_PASS=postgres
DB_IP=localhost
DB_PORT=5432
DB_NAME=focus_track
```

### Step 2: Run the application

#### Linux / macOS
```
./mvnw spring-boot:run
```

#### Windows
```
mvnw.cmd spring-boot:run
```

Once the server is running, visit:

```
http://localhost:8080/users
```

to see the current JSON response of all users.
