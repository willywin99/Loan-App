# Loan App - Spring Boot

This project is Spring Boot application for handling loan applications (pengajuan angsuran) with approve/reject flows.
It uses MySQL as database (configured in `application.properties`).

## Quick start

1. Create MySQL database:
   ```sql
   CREATE DATABASE loanapp;
   ```
2. Update `src/main/resources/application.properties` with your MySQL credentials.
3. Build and run:
   ```bash
   mvn clean package
   java -jar target/loan-app-0.0.1-SNAPSHOT.jar
   ```
4. Open `http://localhost:8080/` for UI, or use the API endpoints under `/api`.

## API endpoints

- `GET /api/applications` - list applications
- `GET /api/applications/{id}` - get application
- `POST /api/applications` - create & submit application
- `POST /api/applications/{id}/approve` - approve (ROLE_APPROVER)
- `POST /api/applications/{id}/reject` - reject (ROLE_APPROVER)

Authentication: Basic auth (demo users configured in SecurityConfig).

## Docker Compose

A `docker-compose.yml` is provided to run MySQL if you prefer.
