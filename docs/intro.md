---
slug: /
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

The project demonstrates entity-based persistence with JPA. The DAO listing methods also use native SQL queries, so database access is not exclusively expressed through the JPA query API.

## Project goal

The application provides desktop workflows for creating and managing groups and users in a database. Its focus is persistence, entity relationships, and a simple architecture organized around CRUD operations.

## Relationship model

The business relationship is:

- one group can include many users
- every user must belong to one group

The relationship is modeled as a `ManyToOne` relation from `Utilisateur` to `Groupe`. The current mapping and form do not enforce the required group assignment.

## Scope

This project is limited to a desktop application and does not expose a REST API or a web application. The persistence layer is managed directly through `EntityManager` and JPA queries.

## Project structure

The source code is organized into entity, DAO, service, controller, and Swing view packages. The application starts from `jpa.Jpa`, and its persistence unit is configured in `src/META-INF/persistence.xml`.
