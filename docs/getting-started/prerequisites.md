# Prerequisites

Before working with this project, make sure the required local tools and services are installed.

## Required software

### Java

The NetBeans project configuration defines Java 21 as the target version.

### NetBeans IDE

The project is currently set up as a NetBeans Java project. The project can be opened and run in NetBeans without additional project scaffolding.

### PostgreSQL

The project uses PostgreSQL locally and is configured to access:

- database: jpa
- user: jpa
- password: jpa

The database must be running locally on:

- host: localhost
- port: 5432

## Required database state

The configuration in the persistence file is set to automatically generate database tables.

This means the following should already exist or be created automatically:

- the database `jpa`
- the PostgreSQL user `jpa`
- the database connection access from localhost

## Libraries

The project includes the required JPA and PostgreSQL dependencies in the lib folder:

- eclipselink-4.0.4.jar
- jakarta.persistence-api-3.2.0.jar
- postgresql-42.7.11.jar

## Checklist

Use this checklist before running the project:

- [ ] Java is installed
- [ ] NetBeans is installed
- [ ] PostgreSQL is installed and running
- [ ] Database `jpa` exists
- [ ] User `jpa` exists and has access to the database
- [ ] The project is opened in NetBeans
- [ ] Dependencies are available in the lib directory

## Important note

This documentation is based on the project code and configuration currently present in the repository. No additional application server or REST infrastructure was detected.
