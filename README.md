# jpa

## Project name

jpa

## Description

This project is a Java Swing desktop application that manages groups and users using JPA and PostgreSQL. It is a small CRUD example built around a relational model where each user belongs to a group.

## Objective

The application allows a user to create, update, delete, and list groups and users through a Swing interface. The persistence layer is implemented with JPA and an EntityManager connected to a PostgreSQL database.

## Features

The application currently implements the following operations:

- Add a group
- List groups
- Update a group
- Delete a group
- Add a user
- List users
- Update a user
- Delete a user
- Find a group or user by ID

## Technologies used

- Java 21 (defined in NetBeans project settings)
- Swing for the desktop interface
- Jakarta Persistence API (JPA)
- EclipseLink as the JPA provider
- PostgreSQL JDBC driver
- NetBeans IDE

## Architecture

The project follows a simplified MVC-style structure:

- View: Swing forms in the presentation.vue package
- Controller: classes in presentation.controleur
- Service: business logic in service
- DAO: persistence logic in dao
- Entity: JPA classes in entite
- Database: PostgreSQL accessed via JPA / EntityManager

## Prerequisites

Before running the project, ensure the following are available:

- Java JDK installed
- NetBeans IDE available
- PostgreSQL installed locally
- A PostgreSQL database named jpa exists
- A PostgreSQL user named jpa with password jpa exists

## Installation

1. Open the project in NetBeans.
2. Confirm the dependencies are available under the lib folder.
3. Ensure the PostgreSQL database is running locally.

## Configuration

The database configuration is defined in src/META-INF/persistence.xml.

The project is configured with:

- persistence unit name: jpaPU
- JDBC driver: org.postgresql.Driver
- URL: jdbc:postgresql://localhost:5432/jpa
- username: jpa
- password: jpa
- schema-generation.database.action: create

This means the project is configured to generate database tables automatically if they do not exist yet.

## Launch

The project is configured in NetBeans with the main class:

- jpa.Jpa

To run it:

1. Open the project in NetBeans.
2. Right-click the project.
3. Select Run.

## Quick usage

After launch:

1. Use the home screen to add or list groups.
2. Use the home screen to add or list users.
3. A user can be assigned to an existing group.
4. The application stores the data in PostgreSQL through JPA.

## Project structure

```text
src/
├── dao/
│   ├── GroupeDao.java
│   └── UtilisateurDao.java
├── entite/
│   ├── Groupe.java
│   └── Utilisateur.java
├── jpa/
│   └── Jpa.java
├── META-INF/
│   └── persistence.xml
├── presentation/
│   ├── controleur/
│   │   ├── AcceilControleur.java
│   │   ├── GroupeControleur.java
│   │   └── UtilisateurControleur.java
│   └── vue/
│       ├── AcceuilUI.java
│       ├── GroupeUI.java
│       └── UtilisateurUI.java
├── service/
│   ├── GroupeService.java
│   └── UtilisateurService.java
└── ...
```

## License

The project header indicates NetBeans default licensing, but no explicit custom license file was found in the repository.

## Notes

This project is a practical JPA and Swing CRUD exercise. It demonstrates persistence between Java entities and a PostgreSQL database with a direct Java desktop interface.
