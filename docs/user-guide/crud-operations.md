# CRUD operations

The project implements basic CRUD flows for both entities through a desktop Swing interface.

## Supported operations

### Create

The application creates a new `Groupe` or `Utilisateur` through the corresponding form UI and then persists it with the DAO layer.

### Read

The application can load records by ID through DAO methods such as `Trouver(int id)` and also list all records using the `...TrouverGroupes()` and `trouverUtilisateurs()` methods.

### Update

The user selects the record to modify and changes the values in the form. The controller then calls the service method to update the persisted entity.

### Delete

The project deletes selected records using the DAO `Supprimer(...)` methods.

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

This project is focused on database persistence and desktop interactions. It does not define RESTful endpoints or a formal API specification.
