# loanapp_full_autoharga

Full Spring Boot sample app with JWT authentication, MySQL, and UI that auto-populates vehicle price from backend.

Run with Docker MySQL:
1. docker-compose up -d
2. mvn clean package
3. mvn spring-boot:run

Default demo users:
- sales / password  (role SALES)
- approver / password (role APPROVER)
