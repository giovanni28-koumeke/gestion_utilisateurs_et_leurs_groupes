# Case study

## Problem statement

The project is a small Java desktop application for managing groups and users in PostgreSQL through JPA. The documentation challenge was to explain its layered persistence workflow while accounting for incomplete service methods and the absence of a network API.

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

The source structure includes:

- entity classes mapped with JPA,
- DAO classes for database access,
- service classes for business logic,
- Swing controller classes,
- Swing view classes,
- a PostgreSQL connection configured in the persistence unit.

The application structure and persistence settings are reflected in the source packages and JPA configuration.

## Documentation strategy

The documentation describes the implemented desktop workflows, JPA configuration, entity relationship, and known limitations. It is organized into user guidance, developer information, concepts, troubleshooting, and reference material, and is published as a Docusaurus site.

## Tools used

- Java source analysis
- NetBeans project review
- PostgreSQL configuration review
- JPA persistence inspection
- Docusaurus documentation site generation
- Git-based project management workflow

## Difficulties encountered

Some service methods are incomplete or return `null`, and the project is a desktop application rather than a REST API. The documentation therefore distinguishes operations available through the interface from incomplete methods and describes the Java persistence layer without presenting it as a network service.

## Solutions applied

The resulting documentation separates user workflows, developer procedures, conceptual explanations, and method-level reference. Its architecture descriptions follow the package structure, and its operation guides distinguish working interface flows from incomplete service methods.

## Results

The resulting documentation covers:

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
