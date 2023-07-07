# Wildlife Tracker

Welcome to Wildlife Tracker! This application allows you to track animals and sightings in a wildlife reserve.

## Setup Instructions

To set up and run the Wildlife Tracker application, follow the instructions below.

### Prerequisites

- Java Development Kit (JDK) 11 or later
- PostgreSQL database

### Database Setup

1. Create a PostgreSQL database for the application.
2. Update the database connection details in the `src/main/java/org/javaweek3/db/DatabaseConnection.java` file with your database credentials.

### Building the Application

1. Clone the repository to your local machine.
2. Open a terminal and navigate to the project's root directory.
3. Build the application using Gradle by running the following command:
   ./gradlew build

### Running the Application

1. In the terminal, navigate to the project's root directory.
2. Start the application using Gradle by running the following command:
   ./gradlew run


3. The application will be available at http://localhost:4567.

### API Endpoints

- `GET /animals`: Get a list of all animals.
- `POST /sightings`: Create a new sighting. Required parameters: `animalId`, `location`, `rangerName`.
- `GET /sightings`: Get a list of all sightings.

### Additional Notes

- The application uses Spark Java as the web framework.
- The database schema and table structures are automatically created when running the application for the first time.
- The application uses SQL2o as the database access library.

## License

The project is licensed under GPL (General Public License).

Copyright (c) 2023 **Pius Mutundu**


