Premier Zone Analytics Dashboard
A professional scouting and analytics dashboard for Premier League player statistics. This project features a Spring Boot backend connected to a SQL Server database, with a sleek, real-time frontend for data discovery.

Key Features
Instant Intelligence Search: Real-time player search by name with high-performance results.

Global Leaderboards: Automated tracking of top goalscorers, playmakers, and disciplinary records.

Discovery Drill-down: Clickable data points to instantly filter players by club, position, or nationality.

Detailed Analytics: Comprehensive player modal cards displaying advanced stats like xG, starts, and minutes played.

Automatic Data Sanitization: Built-in logic to filter out non-player summary rows from the dataset.

Technology Stack
Backend: Java 21, Spring Boot 4.0.1, Spring Data JPA.

Database: Microsoft SQL Server.

Frontend: Modern Vanilla JavaScript, HTML5, CSS3 (Bootstrap 5.3).

Styling: Professional Premier League purple and white aesthetic.

Project Structure
src/main/java: Spring Boot backend logic (Controller, Service, Repository, Entity).

src/main/resources/static: Professional frontend dashboard (index.html).

src/main/resources/application.properties.example: Configuration template for database setup.

How to Run Locally
Database Setup: Create a local SQL Server database named PremStats.

Configuration: Copy application.properties.example to a new file named application.properties and enter your SQL Server credentials.

Build & Run: Use IntelliJ IDEA or run ./mvnw spring-boot:run in your terminal.

Access: Open your browser and navigate to http://localhost:8080.

Data Notes
Nationality: Stored in a custom "ISO short-code" format (e.g., eng ENG).

Positioning: Uses standard football abbreviations (FW, MF, DF, GK).

ID System: Currently uses the Player Name as the primary key for direct data mapping.

<img width="1440" height="777" alt="Skærmbillede 2026-01-22 kl  15 44 10" src="https://github.com/user-attachments/assets/74964f6d-80fe-49e4-b5b5-c12d910a7021" />
