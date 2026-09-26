# Installation

Install the desktop application from this NetBeans Java Ant project. The project targets Java 21 and uses the JAR dependencies already tracked in `lib/`; it does not use Maven or Gradle.

## 1. Install the prerequisites

Install JDK 21, NetBeans with Java Ant project support, and PostgreSQL. See [Prerequisites](./prerequisites.md) for the project settings.

## 2. Create the PostgreSQL role and database

Connect to PostgreSQL as an administrator. If the role and database do not already exist, execute these statements separately:

```sql
CREATE ROLE jpa LOGIN PASSWORD 'jpa';
CREATE DATABASE jpa OWNER jpa;
```

If either object already exists, inspect its permissions rather than running the matching `CREATE` statement again. The values are local demonstration credentials from `src/META-INF/persistence.xml`; change them before using any non-disposable database.

## 3. Open the project in NetBeans

1. Open NetBeans and choose **File > Open Project**.
2. Select the repository root containing `build.xml` and `nbproject/`.
3. Confirm that NetBeans recognizes the project and resolves the JAR files in `lib/`.
4. Select a JDK 21 installation for the project if NetBeans reports a different platform.

The configured main class is `jpa.Jpa`, as declared in the NetBeans project properties.

## 4. Check the persistence settings

The persistence unit is `jpaPU` in `src/META-INF/persistence.xml`. Its JDBC URL is `jdbc:postgresql://localhost:5432/jpa`, with role `jpa` and the demonstration password `jpa`.

The schema action is `create`. It does not create the PostgreSQL role or database, and it is not a migration mechanism. Use a disposable database with no data to preserve; do not assume existing tables or records will be kept.

## 5. Run the application

In NetBeans, run the project using the configured main class. The home window should present buttons for group and user operations. To try a user workflow, first create at least one group.

## Bundled dependencies

The project currently contains:

- `lib/eclipselink-4.0.4.jar`
- `lib/jakarta.persistence-api-3.2.0.jar`
- `lib/postgresql-42.7.11.jar`

If NetBeans reports unresolved libraries, verify that these files exist and inspect `nbproject/project.properties`. The project properties include absolute library paths from another development environment as well as relative paths into `lib/`; on a different machine, resolve the project classpath to the bundled JAR files.
