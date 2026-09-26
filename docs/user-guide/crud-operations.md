# CRUD operations

The home screen wires add, list, modify, and delete flows for both entities through a desktop Swing interface. The corresponding DAO methods exist, but this does not mean every service method in the project is implemented.

## Supported operations

### Create

The application creates a new `Groupe` or `Utilisateur` through the corresponding form UI and then persists it with the DAO layer.

### Read

The DAO layer has `Trouver(int id)` methods, but the home screen does not expose a find-by-ID action. The UI listing flows use `GroupeService.TrouverGroupes()` and `UtilisateurService.trouverUtilisateurs()`.

### Update

The user selects a record and changes values in the form. The controller calls the service method to update it. The group modification flow does not perform the same non-empty-name validation as group creation.

### Delete

The project passes selected records to the DAO `Supprimer(...)` methods. Deleting a group that is still referenced by users can fail due to the database foreign-key constraint.

## Example flow for a user

1. Open the home screen.
2. Click "Ajouter un utilisateur".
3. Fill in the fields.
4. Select a group.
5. Click "Enregistrer".
6. The controller stores the object in the database through the persistence layer.

## DAO methods actually present

### GroupeDAO

- `Ajouter(Groupe groupe)`
- `Trouver(int id)`
- `Modifier(Groupe groupe)`
- `Supprimer(Groupe groupe)`
- `TrouverGroupes()`

### UtilisateurDAO

- `Ajouter(Utilisateur utilisateur)`
- `Trouver(int id)`
- `Modifier(Utilisateur utilisateur)`
- `Supprimer(Utilisateur utilisateur)`
- `trouverUtilisateur()`

## Important limitation

Methods such as `GroupeService.lister()`, `UtilisateurService.lister()`, identifier-based user lookup, and some identifier-based delete methods return `null` or have empty bodies. They are not the listing flows used by the home screen. This project does not define REST endpoints or a formal HTTP API.
