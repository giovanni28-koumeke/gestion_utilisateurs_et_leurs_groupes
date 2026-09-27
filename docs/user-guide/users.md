# Users

The application includes a user management flow linked to the group model.

## What a user represents

A user is represented by the `Utilisateur` entity, defined in [src/entite/Utilisateur.java](../../src/entite/Utilisateur.java).

Its fields are:

- `id`
- `nom`
- `prenom`
- `identifiant`
- `mot_de_passe`
- `groupe`

## JPA relationship

The `Utilisateur` entity has a `@ManyToOne` relationship with `Groupe`:

```java
@ManyToOne
@JoinColumn(name = "id_groupe")
private Groupe groupe;
```

The business rule is that every user must belong to one group. The current mapping permits a nullable association because the join column is not declared `nullable = false`; the form also does not validate group selection. The implementation therefore does not yet enforce this requirement.

## User actions in the current application

The home screen exposes the following actions:

- add a user
- list users
- modify a user
- delete a user

These actions are implemented in [src/presentation/controleur/UtilisateurControleur.java](../../src/presentation/controleur/UtilisateurControleur.java).

## Add a user

The user is created in the Swing form defined in [src/presentation/vue/UtilisateurUI.java](../../src/presentation/vue/UtilisateurUI.java).

The form includes:

- last name
- first name
- identifier
- password
- group selector

The business rules require a non-empty name, a non-empty identifier, and a unique identifier. The current add form validates only these fields for non-empty values:

- last name is not empty
- identifier is not empty

The current form and entity mapping do not check that the identifier is unique. The first name and password are not separately checked by this form. Although the business rule requires a group, the form does not validate the selected value. The user controller loads its group list when it is constructed at application startup; restart the application after adding a group if that group should appear in the selector.

## Modify a user

The application allows selecting an existing user from a list and editing their data, including reassigning the user to another group. Saving the form updates the `Utilisateur.groupe` association.

## Delete a user

A selected user can be deleted through the controller and service stack. The expected behavior is to show an appropriate on-screen error when an operation fails. The current controller instead writes a generic message to standard output and does not show the underlying database error in a dialog.

## List users

Users are listed in a Swing table showing:

- name
- first name
- identifier
- group

## Important note

The `mot_de_passe` field is stored as a string in the JPA entity and the UI uses a password input control. The project does not define hashing, authentication, or a password policy. Do not use real credentials with this application.
