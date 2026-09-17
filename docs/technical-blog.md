---
sidebar_position: 10
---

# Technical blog post

## Title

Managing Groups and Users with Java Swing and JPA

## Why this topic matters

This project is a practical example of how a desktop Java application can interact with a relational database using JPA. It demonstrates a simple but complete persistence flow for managing entities, validating user input, and persisting records in PostgreSQL.

## Problem statement

When working with Java desktop applications, it is common to need a clean way to represent domain objects and map them to a relational database. In this project, the challenge was to manage a group-user relationship using JPA while keeping the architecture simple and readable.

## Project overview

The application includes two main entities:

- `Groupe`
- `Utilisateur`

Each user belongs to one group, and each group can include several users. The implementation uses a `ManyToOne` association from `Utilisateur` to `Groupe`, which is mapped directly by JPA.

## Architecture in practice

The project follows a simplified layered architecture:

- Swing user interface
- controller layer
- service layer
- DAO layer
- JPA entity manager
- PostgreSQL database

This separation allows the application to keep UI logic, business logic, and persistence logic distinct without requiring a full enterprise framework.

## Code-level observations

The project uses a `Persistence` unit named `jpaPU` and creates an `EntityManagerFactory` in the DAO classes. Each DAO method handles `EntityManager` initialization, transaction begin/commit, and rollback in the event of an exception.

This is a useful pattern for learning how JPA works in a small application, especially when the focus is on CRUD operations and entity mapping rather than high-scale production concerns.

## User flow

From the desktop UI, a user can:

- add a group,
- list groups,
- update a group,
- delete a group,
- add a user,
- list users,
- update a user,
- delete a user.

The actual interaction is handled by the Swing form classes and the controller classes, which validate form values before sending the data to the service and DAO layers.

## What this project teaches

This project is useful for understanding:

- entity mapping with JPA,
- relationship modeling in Java,
- transaction handling in a desktop application,
- CRUD logic in a simple layered architecture,
- PostgreSQL integration with Java persistence.

## Final reflection

Although the project is intentionally simple, it remains a strong example of how Java desktop applications can interact with relational storage using standard JPA patterns. It is especially valuable as a teaching resource because the architecture is readable and the persistence flow is easy to trace.
