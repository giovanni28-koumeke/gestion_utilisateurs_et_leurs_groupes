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

This means each user can be assigned to one group.

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

Validation requires:

- last name is not empty
- identifier is not empty

## Modify a user

The application allows selecting an existing user from a list and editing their data, including the assigned group.

## Delete a user

A selected user can be deleted through the controller and service stack.

## List users

Users are listed in a Swing table showing:

- name
- first name
- identifier
- group

## Important note

The `mot_de_passe` field is stored as a string in the JPA entity. The project does not define a hashing mechanism or password policy in the current implementation.
