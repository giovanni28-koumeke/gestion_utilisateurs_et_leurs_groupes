# Reference: application operations

This reference documents the operational methods that are truly implemented in the project.

## Group operations

### `GroupeDao.Ajouter(Groupe groupe)`

Adds a new group to the database.

### `GroupeDao.Trouver(int id)`

Returns one group by its ID.

### `GroupeDao.Modifier(Groupe groupe)`

Updates an existing group.

### `GroupeDao.Supprimer(Groupe groupe)`

Removes an existing group.

### `GroupeDao.TrouverGroupes()`

Returns the list of all groups by executing a native query.

---

## User operations

### `UtilisateurDao.Ajouter(Utilisateur utilisateur)`

Adds a new user to the database.

### `UtilisateurDao.Trouver(int id)`

Returns one user by ID.

### `UtilisateurDao.Modifier(Utilisateur utilisateur)`

Updates an existing user.

### `UtilisateurDao.Supprimer(Utilisateur utilisateur)`

Deletes a user.

### `UtilisateurDao.trouverUtilisateur()`

Returns the list of users using a native SQL query.

---

## Service layer equivalents

The service classes expose corresponding methods such as:

- `GroupeService.Ajouter(...)`
- `GroupeService.Trouver(...)`
- `GroupeService.Modifier(...)`
- `GroupeService.Supprimer(...)`
- `GroupeService.TrouverGroupes()`

- `UtilisateurService.Ajouter(...)`
- `UtilisateurService.Trouver(...)`
- `UtilisateurService.Modifier(...)`
- `UtilisateurService.Supprimer(...)`
- `UtilisateurService.trouverUtilisateurs()`

## Important note

This project is a desktop Java Swing application and does not expose a REST API or HTTP endpoints. The reference above documents the real application operations implemented in the codebase, not a hypothetical HTTP interface.

Some service methods are currently only partially implemented and may return `null` or remain empty. The reference above describes only the operations that exist in the real codebase.
