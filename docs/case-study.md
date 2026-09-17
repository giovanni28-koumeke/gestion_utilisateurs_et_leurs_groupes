# Case study

## Problem statement

The project is a small Java desktop application designed to manage groups and users in a PostgreSQL database through JPA. The central challenge was to document the existing implementation clearly and accurately without inventing missing features or behaviors.

## Project selected

The selected project is a Java Swing + JPA + PostgreSQL exercise that implements a basic CRUD workflow for two entities:

- `Groupe`
- `Utilisateur`

## Target audience

The documentation targets:

- learners exploring Java desktop applications,
- students working with JPA and relational mapping,
- technical writers practicing real project documentation,
- developers who need to understand the current architecture quickly.

## Documentation goals

The goal was to produce a structured, professional documentation set that explains:

- the purpose of the project,
- the architecture and responsibilities of each layer,
- the persistence configuration with JPA,
- the relationship between groups and users,
- the operations implemented in the code,
- the practical steps to run and use the application.

## Analysis of the project

The actual code structure includes:

- entity classes mapped with JPA,
- DAO classes for database access,
- service classes for business logic,
- Swing controller classes,
- Swing view classes,
- a PostgreSQL connection configured in the persistence unit.

This analysis was performed directly from the repository, including the source files and the JPA configuration.

## Documentation strategy

The chosen strategy was to document the project as it exists today, not as an idealized system. This included:

- a clear project overview,
- user-oriented sections,
- conceptual documentation,
- technical reference pages,
- Docusaurus-based structure,
- a troubleshooting section based on real configuration issues.

## Tools used

- Java source analysis
- NetBeans project review
- PostgreSQL configuration review
- JPA persistence inspection
- Docusaurus documentation site generation
- Git-based project management workflow

## Difficulties encountered

The main difficulty was avoiding unsupported assumptions. Some service methods are incomplete or return `null`, and the project is a desktop application rather than a REST API. This required careful phrasing and disciplined documentation based on real implementation.

## Solutions applied

The solution was to:

- rely on the actual source code,
- document only implemented features,
- keep the architecture description aligned with the package structure,
- use a Docusaurus structure for professional publication,
- separate conceptual documentation from user documentation.

## Results

The documentation now provides a coherent view of:

- startup and configuration,
- CRUD operations,
- JPA mapping,
- user flows,
- project structure,
- developer guidance,
- troubleshooting steps.

## Limits

The project remains a small academic or training-oriented application. It does not include:

- a REST API,
- authentication and authorization,
- full production-grade architecture,
- advanced deployment automation.

## What I learned

This project demonstrates that good technical documentation must be grounded in the actual codebase and must remain honest about what is implemented versus what is only intended.

## Future improvements

Possible future improvements include:

- adding a more complete developer onboarding guide,
- documenting a stronger testing strategy,
- improving the quality of the generated Docusaurus navigation,
- expanding the project with a richer business model if the application evolves.
