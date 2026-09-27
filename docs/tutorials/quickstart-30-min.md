# Quickstart: create a group and a user in 30 minutes

**Duration:** about 30 minutes  
**Type:** tutorial  
**Audience:** a developer or learner running the application locally for the first time

## Learning objectives

After completing this tutorial, participants should be able to:

- open and run the Java Swing project in NetBeans;
- connect the application to a local PostgreSQL database;
- create and list a group;
- create and list a user associated with that group.

## Prerequisites

- JDK 21, which is the source and target level configured in `nbproject/project.properties`;
- NetBeans with Java Ant project support;
- PostgreSQL reachable at `localhost:5432`;
- the `jpa` role and `jpa` database, or permission to create them;
- the dependency JAR files present in the repository's `lib/` directory.

The configured demonstration database credentials are `jpa` / `jpa`. Do not use them for a database containing valuable or production data. The `create` schema-generation setting is not a migration and does not create the PostgreSQL role or database.

## Tutorial

### 1. Check the local prerequisites (0–4 minutes)

Confirm that NetBeans can use JDK 21, PostgreSQL is running on port `5432`, and the three JAR files listed in [Prerequisites](../getting-started/prerequisites.md) are present. The project is a NetBeans Ant project; this tutorial does not use Maven, Gradle, Docker, or a REST service.

### 2. Create the demo database if needed (4–9 minutes)

Connect to PostgreSQL as an administrator. On installations where the PostgreSQL administrator role is named `postgres`, the following terminal command opens a connection:

```powershell
psql -h localhost -p 5432 -U postgres -d postgres
```

If the administrator role has another name, substitute that role in the command. Execute each statement separately and only when the corresponding object does not already exist:

```sql
CREATE ROLE jpa LOGIN PASSWORD 'jpa';
CREATE DATABASE jpa OWNER jpa;
```

Exit `psql` after the database and role are ready. For installations that do not use `localhost:5432` or do not permit the administrator connection shown above, the local PostgreSQL connection procedure must be adapted; the application itself is configured for the URL shown above.

### 3. Open the project in NetBeans (9–14 minutes)

Open the repository root as a project. Confirm NetBeans recognizes the Ant project, resolves the JARs in `lib/`, and uses JDK 21. The configured main class is `jpa.Jpa`.

### 4. Start the desktop application (14–17 minutes)

Run the project in NetBeans. Confirm that the home window opens and shows actions for adding, listing, modifying, and deleting groups and users. If the application fails during startup, check the PostgreSQL URL and credentials in `src/META-INF/persistence.xml` and verify that the role can connect to the database.

### 5. Create and list a group (17–22 minutes)

Click **Ajouter un groupe**, enter a non-empty group name and an optional description, then click **Enregistrer**. Return to the home window and click **Lister tous les groupes**. Confirm the new group appears in the table.

### 6. Restart and create a user (22–28 minutes)

Close and run the application again before creating the user. The current controller loads the group list once at application startup; restarting refreshes the list used by the user form.

Click **Ajouter un utilisateur**. Enter a non-empty name and a unique identifier, then select the group created in the previous step, as required by the business rules. The current form checks that the name and identifier are non-empty but does not enforce identifier uniqueness or group selection. The code also does not require a non-empty first name or password. Click **Enregistrer**.

### 7. List users and verify the result (28–30 minutes)

Click **Lister tous les utilisateurs**. Confirm the user and selected group appear in the table. The password is not shown in this table.

## Expected result

The group and associated user should be stored in the configured PostgreSQL database and displayed by the corresponding list actions.

## Troubleshooting

- **The application cannot connect:** confirm the server is listening at `localhost:5432`, the `jpa` database and role exist, and the credentials match `src/META-INF/persistence.xml`.
- **No group appears in the user selector:** restart the application after creating the group. The current controller caches the group list when it is constructed.
- **The save action does not accept the form:** group creation requires a name; user creation requires a name and identifier. The form does not currently check identifier uniqueness. Other database constraints or connection errors may also cause persistence to fail.
- **Existing data matters:** stop before running the application against it. The configured schema action is `create`, and preservation of existing schema data is not guaranteed.

Additional procedures are available in the [Group guide](../user-guide/groups.md), [User guide](../user-guide/users.md), and [Installation guide](../getting-started/installation.md).
