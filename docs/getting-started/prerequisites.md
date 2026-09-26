# Prerequisites

Have these tools and services available before opening the desktop application.

## Required software

| Requirement | Project evidence |
|---|---|
| JDK 21 | `nbproject/project.properties` sets `javac.source` and `javac.target` to `21` |
| NetBeans IDE with Java Ant project support | The repository contains `build.xml` and `nbproject/` project metadata |
| PostgreSQL server reachable from the desktop | `src/META-INF/persistence.xml` points to `localhost:5432` |

## PostgreSQL state

Before launch, a PostgreSQL role named `jpa` and database named `jpa` must exist, and the role must be able to connect to the database. JPA schema generation does **not** create the database or role.

The current local demonstration configuration uses the password `jpa` in plain text. Do not expose this configuration to an untrusted or production database.

## Bundled Java libraries

These JAR files are present in `lib/`:

- `eclipselink-4.0.4.jar`
- `jakarta.persistence-api-3.2.0.jar`
- `postgresql-42.7.11.jar`

## Checklist

- [ ] JDK 21 is installed and selected by NetBeans.
- [ ] PostgreSQL is running and reachable on port `5432`.
- [ ] The `jpa` role and `jpa` database exist, and the role can connect.
- [ ] The project libraries under `lib/` are resolved by NetBeans.

No application server, REST service, Docker configuration, or authentication setup is present in this repository.
