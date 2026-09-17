# Data flow

This project follows a simple data flow from the Swing interface to the PostgreSQL database.

## Default flow

```text
Utilisateur
   ↓
Vue Swing
   ↓
Contrôleur
   ↓
Service
   ↓
DAO
   ↓
EntityManager
   ↓
PostgreSQL
```

## Example: create a user

1. The user fills the form in `UtilisateurUI`.
2. The controller receives the save action.
3. The controller validates the data and calls the service.
4. The service delegates to the DAO.
5. The DAO creates an `EntityManager`.
6. JPA persists the `Utilisateur` entity.
7. PostgreSQL stores the record.

This flow is consistent with the actual controller and DAO implementation in the project.

## Example: list users

1. The home screen triggers the list action.
2. `UtilisateurControleur` calls the listing method.
3. The `UtilisateurService` delegates to the DAO.
4. The DAO executes a native query:

```java
em.createNativeQuery("SELECT * FROM utilisateurs", Utilisateur.class)
```

5. The result is returned to the Swing UI.
6. The list is displayed in a JTable inside a dialog.

## Real implementation notes

This is a simple application and not a full enterprise flow. Certain methods return null or are intentionally left empty in the service layer, so the conceptual flow matches the code while the business logic remains intentionally minimal.
