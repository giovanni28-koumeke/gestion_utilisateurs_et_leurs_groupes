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

This mapping lets a user reference at most one group. The join column is not declared `nullable = false`, so the entity mapping itself does not require an association.

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

The add form validates only these fields:

- last name is not empty
- identifier is not empty

The first name, password, and selected group are not separately checked by this form. The user controller loads its group list when it is constructed at application startup; restart the application after adding a group if that group should appear in the selector.

## Modify a user

The application allows selecting an existing user from a list and editing their data, including the assigned group.

## Delete a user

A selected user can be deleted through the controller and service stack. If a database operation fails, the controller's catch block writes a generic message to standard output; it does not show the underlying database error in a dialog.

## List users

Users are listed in a Swing table showing:

- name
- first name
- identifier
- group

## Important note

The `mot_de_passe` field is stored as a string in the JPA entity and the UI uses a password input control. The project does not define hashing, authentication, or a password policy. Do not use real credentials with this application.
