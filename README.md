# Event & Participant Manager

A professional full-stack application for managing corporate events and attendee registrations.

## Tech Stack
* **Backend:** Java 17, Maven, Javalin (REST API)
* **Database:** PostgreSQL
* **Frontend:** HTML5, CSS3 , JavaScript (Fetch API)
* **JSON Mapping:** Jackson

## Getting Started

### 1. Database Setup
Execute the following SQL commands in your PostgreSQL terminal:

CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    date DATE,
    location VARCHAR(255)
);

CREATE TABLE participants (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    event_id INT REFERENCES events(id)
);

### 2. Configuration
Open `src/main/java/db/DatabaseManager.java` and update the database credentials:
* **URL:** jdbc:postgresql://localhost:5432/your_db_name
* **USER:** your_username
* **PASSWORD:** your_password

### 3. Execution
1. Run the `Main.java` class to start the server.
2. The server will start on `http://localhost:8080`.
3. Open `index.html` in any modern web browser.

## Project Structure
* `model/` — Core entities (Event and Participant).
* `repository/` — Data Access Layer (PostgreParticipantRepository, IParticipantRepository).
* `controller/` — Request handling logic.
* `factory/` — Implementation of the Factory Pattern for object creation.
* `index.html` — Minimalist "Premium Dark" user interface.

## API Endpoints
* `GET /events` — Retrieve all events.
* `POST /events` — Create a new event.
* `GET /participants` — Retrieve all participants.
* `POST /participants` — Register a new participant.
