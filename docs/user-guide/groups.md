# Groups

The desktop home screen provides group add, list, modify, and delete actions. These flows are implemented in the current Swing application; they are not HTTP operations.

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

When adding a group, the form rejects an empty or whitespace-only name:

```java
return !nom.getText().trim().isEmpty();
```

## Update a group

The application allows selecting an existing group and then opening a form to edit it. Unlike the add flow, the modify flow does not call `champValide()` before persisting; do not assume it applies the same non-empty-name check.

The controller obtains the list of groups and then calls `GroupeUI.selectionerGroupe(...)` to let the user pick a group before updating it.

## Delete a group

The user selects a group and the controller asks the service/DAO to delete it. If users still reference that group, the database foreign-key constraint can reject the deletion. The controller catches exceptions and writes a generic message to standard output rather than presenting the database error in a dialog.

## List groups

The application lists groups using a Swing table rendered in a dialog through `GroupeUI.afficherTableauGroupe(...)`.

The displayed columns are:

- group name
- description

## Important note

The current code does not include a separate admin screen or a REST endpoint for group management. Group actions are handled in the desktop interface only.
