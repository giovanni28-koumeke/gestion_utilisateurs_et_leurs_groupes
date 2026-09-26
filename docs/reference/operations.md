# Reference: application operations

This reference lists the DAO operations used to access groups and users.

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

The application is a Java Swing desktop client and does not expose REST endpoints. The DAO operations above are Java methods, not HTTP operations. Some additional service methods are incomplete: `GroupeService.lister()` and `UtilisateurService.lister()` return `null`, while identifier-based user lookup and delete methods have empty implementations.
