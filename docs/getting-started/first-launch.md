# First launch

This guide explains the first run of the Swing application as implemented in the current codebase.

## Launch from NetBeans

1. Open the project in NetBeans.
2. Make sure PostgreSQL is already running locally.
3. Verify that the database `jpa` is available.
4. Run the project using the main class:

```text
jpa.Jpa
```

The entry point is defined in [src/jpa/Jpa.java](../../src/jpa/Jpa.java), which creates the home controller:

```java
AcceilControleur acc = new AcceilControleur();
```

## What appears at startup

The home interface is defined in [src/presentation/vue/AcceuilUI.java](../../src/presentation/vue/AcceuilUI.java). It displays action buttons for:

- add a group
- add a user
- list groups
- list users
- modify a group
- modify a user
- delete a group
- delete a user

## Initial behavior

When the application starts, the JPA persistence unit is initialized through `Persistence.createEntityManagerFactory("jpaPU")` and the database is accessed through `EntityManager` objects from the DAO layer.

If the database schema is missing, the configured `create` action can generate tables automatically.

## Expected result

If the database connection and project dependencies are correctly configured, the application opens the home screen and allows CRUD operations through Swing dialogs and forms.

## Troubleshooting first launch

If the application does not launch:

- confirm PostgreSQL is running
- verify the `jpa` database exists
- verify the user `jpa` has access to the database
- confirm the JAR files in the lib directory are present
- verify NetBeans sees the project as a Java application

## Important note

This documentation reflects the actual implementation present in the repository. No web interface or REST API is present in the current application.
