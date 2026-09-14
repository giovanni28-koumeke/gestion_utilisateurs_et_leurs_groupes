# Persistence layer

The persistence layer is the database access layer of the application.

## Main technologies

- JPA
- EntityManager
- EntityManagerFactory
- PostgreSQL JDBC driver
- EclipseLink provider

## DAO methods

### GroupeDao

The implementation currently includes:

- `Ajouter(Groupe groupe)`
- `Trouver(int id)`
- `Modifier(Groupe groupe)`
- `Supprimer(Groupe groupe)`
- `TrouverGroupes()`

### UtilisateurDao

The implementation currently includes:

- `Ajouter(Utilisateur utilisateur)`
- `Trouver(int id)`
- `Modifier(Utilisateur utilisateur)`
- `Supprimer(Utilisateur utilisateur)`
- `trouverUtilisateur()`

## Transaction pattern

Each write operation follows a standard transaction pattern:

```java
transaction.begin();
em.persist(...);
transaction.commit();
```

and includes rollback handling in a catch block.

## Query style

The application uses a mix of:

- `EntityManager.find()`
- `em.merge()`
- `em.persist()`
- `em.remove()`
- native SQL queries via `createNativeQuery()`

## Important note

This project uses raw native queries in addition to JPA entity operations. This is valid in the current code but is not necessarily the most robust long-term pattern for a larger application.
