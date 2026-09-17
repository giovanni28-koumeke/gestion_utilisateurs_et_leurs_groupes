# Installation

This project is already structured as a NetBeans Java project. No package manager or build system such as Maven or Gradle is used in the current configuration.

## Step-by-step installation

1. Open NetBeans.
2. Open the project folder containing the project files.
3. Confirm that the `lib` folder contains the required JAR files.
4. Confirm the project is recognized as a Java project.
5. Ensure PostgreSQL is running locally.
6. Verify that the database `jpa` exists and is reachable.
7. Open the project and resolve any Java configuration warnings if NetBeans prompts for them.

## Verified project structure

The project is structured as a classic NetBeans Java desktop application:

```text
src/
├── dao/
├── entite/
├── jpa/
├── META-INF/
├── presentation/
├── service/
└── ...
```

## Files relevant to installation

The following project files are important:

- nbproject/project.properties
- src/META-INF/persistence.xml
- lib/

## Java configuration

The project configuration specifies the following build and runtime parameters:

- source compatibility: Java 21
- main class: jpa.Jpa

These values are defined in the NetBeans project properties.

## Dependency check

The project depends on the following libraries:

```text
lib/
├── eclipselink-4.0.4.jar
├── jakarta.persistence-api-3.2.0.jar
└── postgresql-42.7.11.jar
```

If one of these libraries is missing, JPA or database connectivity may fail.

## Local database check

Before running the application, verify the PostgreSQL instance is reachable with the configured credentials:

- database: jpa
- user: jpa
- password: jpa

The project configuration points to:

```text
jdbc:postgresql://localhost:5432/jpa
```

## Result

If the database is running and the project dependencies are available, the application can be launched in NetBeans.
