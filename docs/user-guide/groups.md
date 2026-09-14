# Groups

The project includes a complete group management flow through the desktop UI.

## What a group represents

A group is represented by the `Groupe` entity defined in [src/entite/Groupe.java](../../src/entite/Groupe.java).

Its fields are:

- `id`
- `nom_du_groupe`
- `description`

The entity is mapped with JPA and stored in the `groupe` table.

## Group actions available in the current application

The main interface exposes these actions:

- Add a group
- List groups
- Modify a group
- Delete a group

These actions are wired through [src/presentation/controleur/GroupeControleur.java](../../src/presentation/controleur/GroupeControleur.java) and the service/DAO layers.

## Add a group

From the home screen, click the button labeled "Ajouter un groupe".

This opens a Swing form created in [src/presentation/vue/GroupeUI.java](../../src/presentation/vue/GroupeUI.java).

The form contains:

- name field
- description field
- save button

The validation logic checks that the group name is not empty:

```java
return !nom.getText().trim().isEmpty();
```

## Update a group

The application allows selecting an existing group and then opening a form to edit it.

The controller obtains the list of groups and then calls `GroupeUI.selectionerGroupe(...)` to let the user pick a group before updating it.

## Delete a group

The user selects a group from the list and the project calls the DAO service to delete the selected entity.

## List groups

The application lists groups using a Swing table rendered in a dialog through `GroupeUI.afficherTableauGroupe(...)`.

The displayed columns are:

- group name
- description

## Important note

The current code does not include a separate admin screen or a REST endpoint for group management. Group actions are handled in the desktop interface only.
