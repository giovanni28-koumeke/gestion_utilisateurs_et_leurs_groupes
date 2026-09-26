# First launch

This guide describes how to start the Swing application for the first time.

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

The `create` action requests schema creation by the persistence provider. The PostgreSQL database and role must already exist. Use an empty, disposable database because this setting does not promise to preserve existing schema data.

## Expected result

If startup succeeds, the application opens the home screen. The available CRUD flows use Swing forms and dialogs; some other service methods remain incomplete and are not exposed through this screen.

## Troubleshooting first launch

If the application does not launch:

- confirm PostgreSQL is running
- verify the `jpa` database exists
- verify the user `jpa` has access to the database
- confirm the JAR files in the lib directory are present
- verify NetBeans sees the project as a Java application

The application is a desktop client; it does not provide a web interface or REST API.
