---
sidebar_position: 1
---

# Introduction

This project is a Java desktop application designed to manage groups and users in a PostgreSQL database using JPA. It is a small but functional CRUD example built with Swing and persistence technology.

The application consists of several layers:

- entity classes mapped with JPA
- DAO classes to access the database
- service classes for business logic
- controller classes to respond to UI actions
- Swing UI classes for user interaction

The project acts as a practical example of how Java objects can be persisted in a relational database without writing raw SQL in the application logic.

## Project goal

The goal of the application is to allow a user to create and manage groups and users in a database through an interface. The focus is on persistence, entity relationships, and a simple architecture built around CRUD operations.

## Relationship model

The real relationship implemented in the code is:

- one group can include many users
- one user belongs to one group

This is modeled as a `ManyToOne` relation from `Utilisateur` to `Groupe`.

## Scope

This project is limited to a desktop application and does not expose a REST API or a web application. The persistence layer is managed directly through `EntityManager` and JPA queries.

## Documentation scope

This documentation is intentionally based on the real implementation present in the repository. It describes the current Java Swing UI, the JPA persistence layer, and the PostgreSQL configuration as they are implemented in the source code.

## Audit status

The project was validated against the actual code structure before writing the technical documentation. The main verified components are:

- entity classes in `src/entite`
- DAO classes in `src/dao`
- service classes in `src/service`
- controller classes in `src/presentation/controleur`
- Swing views in `src/presentation/vue`
- persistence configuration in `src/META-INF/persistence.xml`

This documentation therefore reflects the current state of the project rather than a hypothetical architecture.
