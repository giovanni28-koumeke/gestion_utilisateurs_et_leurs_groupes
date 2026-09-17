# Tutorial: create a new group

This tutorial uses the real functionality currently implemented in the project.

## 1. Prepare the application

Before creating a group:

- make sure NetBeans is open on the project
- confirm PostgreSQL is running
- confirm the `jpa` database exists
- start the application from the main class `jpa.Jpa`

## 2. Launch the application

Run the project in NetBeans. The main screen appears with the action buttons for group and user operations.

## 3. Open the group form

On the home screen, click the button:

- "Ajouter un groupe"

This opens the `GroupeUI` form.

## 4. Fill in the form

Complete the following fields:

- Nom du groupe
- Description

The current implementation validates the following condition:

- the group name is not empty

## 5. Save the group

Press the "Enregistrer" button.

At this point:

- the controller receives the action
- the `Groupe` object is filled from the form
- the service delegates the operation to the DAO
- the DAO persists the current entity using JPA and `EntityManager`

## 6. Verify the result

After saving, the form closes and the group is stored in PostgreSQL. The project can then be checked by listing the groups from the home screen.

## Result

The group is now stored with:

- a name
- a description

## Important note

This tutorial reflects the actual behavior of the current implementation. The project does not currently include a dedicated web form, API layer, or admin panel for group management beyond the desktop Swing interface.
