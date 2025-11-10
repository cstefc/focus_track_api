

# Focus Track API

![status](https://img.shields.io/badge/status-WIP-yellow)
![Java](https://img.shields.io/badge/Java-21-blue) 
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.6-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![OpenAPI](https://img.shields.io/badge/OpenAPI-3.0-orange)

**Focus Track API** is a work-in-progress project designed as a portfolio piece to showcase my backend development skills. It allows me to deepen my knowledge of **Spring Boot** while building a practical application to help track personal goals.  

This API is part of a full-stack project. The corresponding front-end can be found on my GitHub [here](https://github.com/cstefc/focus_track_ui). The goal is to create a seamless application for managing todos, logging progress, and tracking personal objectives.
## Tech Stack

- **Backend**: Spring Boot  
- **Database**: PostgreSQL 17
- **Language**: Java 21  
- **Authentication**: OAuth2/JWT using Firebase
- **Front-end**: React [(link to repo)](https://github.com/cstefc/focus_track_ui)

## Features (Work in Progress)

- **Environment Variables**: Sensitive information such as database credentials is stored in `.env` files.  
- **OAuth2 Authentication** – Secure communication between front-end and back-end.  
- **Endpoints**:
     - `/project`: get
- **Mock Data**: Pre-generated data available for front-end development and testing purposes.  

> ⚠️ Note: Additional endpoints for todos, goal tracking, and sports sessions are planned as the API continues development.
## Roadmap

The project follows a **feature-driven development approach**, starting from the front-end and then integrating with the back-end. Planned features include:
- **Project Management** – Ability to create and manage projects.  
- **Plans & Steps** – Add detailed goals with steps inside projects.  
- **Logging Feature** – Track progress and updates within projects.  
- **Events** – Add and manage events related to goals and projects.

> ⚠️ Note: These features are under development and will be gradually implemented.
## Usage / Examples

### Prerequisites
- **PostgreSQL** database + appUser for the API
- **Firebase Project**
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

### Step 2: Download private key from Firebase console
See [this tutorial](https://clemfournier.medium.com/how-to-get-my-firebase-service-account-key-file-f0ec97a21620)
Put the private key in `src/main/resources/private-key.json`

### Step 3: Run the application

#### Linux / macOS
```
./mvnw spring-boot:run
```

#### Windows
```
mvnw.cmd spring-boot:run
```

### Step 4: Check if the API is working

Once the server is running, go to `http://localhost:8080/public/docs` to see the documentation
Please note that you can only access the endpoints when you have following header in the request:
```
Authorization: Bearer *JWT token from Firebase login*
```
