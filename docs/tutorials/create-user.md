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

The add form validates only the following conditions:

- the last name is not empty
- the identifier is not empty

The first name and password are not required by the form's validation. The group selection also has no separate validation check.

## 5. Select the group

The form includes a combo box populated with the group list loaded when the user controller starts. If you created a group after launching the application, close and restart the application before opening this form so the new group appears. The selected group is assigned to the `groupe` field of `Utilisateur`.

## 6. Save the user

Press the "Enregistrer" button.

At this point:

- the controller receives the action
- the `Utilisateur` object is filled from the form
- the service delegates the operation to the DAO
- the DAO persists the current entity using JPA and `EntityManager`

## 7. Verify the result

After a successful save, the form closes. Return to the home screen and choose **Lister tous les utilisateurs** to check the result. The project does not show a dedicated success confirmation.

## Result

The user is now stored with:

- a name
- a first name
- an identifier
- a password value
- a group assignment

## Important note

This tutorial reflects the current implementation. The project does not include a web form, API layer, authentication flow, password hashing, or password policy. Do not enter real credentials.
