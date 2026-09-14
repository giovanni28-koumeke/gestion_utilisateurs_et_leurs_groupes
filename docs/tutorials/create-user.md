# Tutorial: create a new user

This tutorial uses the real functionality currently implemented in the project.

## 1. Prepare the application

Before creating a user:

- make sure NetBeans is open on the project
- confirm PostgreSQL is running
- confirm the `jpa` database exists
- start the application from the main class `jpa.Jpa`

## 2. Launch the application

Run the project in NetBeans. The main screen appears with the action buttons for group and user operations.

## 3. Open the user form

On the home screen, click the button:

- "Ajouter un utilisateur"

This opens the `UtilisateurUI` form.

## 4. Fill in the form

Complete the following fields:

- Nom
- Prenom
- Identifiant
- Mot de passe
- Groupe

The current implementation validates the following conditions:

- the last name is not empty
- the identifier is not empty

## 5. Select the group

The form includes a combo box listing the available groups. The selected group is assigned to the user via the `Groupe` field of the `Utilisateur` entity.

## 6. Save the user

Press the "Enregistrer" button.

At this point:

- the controller receives the action
- the `Utilisateur` object is filled from the form
- the service delegates the operation to the DAO
- the DAO persists the current entity using JPA and `EntityManager`

## 7. Verify the result

After saving, the form closes and the user data is stored in PostgreSQL. The project can then be checked by listing the users from the home screen.

## Result

The user is now stored with:

- a name
- a first name
- an identifier
- a password value
- a group assignment

## Important note

This tutorial reflects the actual behavior of the current implementation. The project does not currently include a dedicated web form, API layer, or authentication flow.
