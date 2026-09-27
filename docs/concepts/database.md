# Database

The project uses PostgreSQL as the database system.

## Connection details

The actual connection details defined in the code are:

- driver: `org.postgresql.Driver`
- URL: `jdbc:postgresql://localhost:5432/jpa`
- user: `jpa`
- password: `jpa`

## Tables created by JPA

The persistence unit registers two entities:

- `Groupe`
- `Utilisateur`

The current configuration sets schema generation to `create`, which requests schema creation by the persistence provider. It does not create the PostgreSQL role or database and is not a migration strategy. Existing schema data must not be assumed to be preserved.

## Observed database model

### `groupe` table

This is the table mapped from the `Groupe` entity.

Fields include:

- `id`
- `nom`
- `description`

### `utilisateurs` table

This is the table mapped from the `Utilisateur` entity.

Fields include:

- `id`
- `nom`
- `prenom`
- `identifiant`
- `mot_de_passe`
- `id_groupe`

## Foreign key relationship

The `utilisateurs` table includes a foreign key column named `id_groupe` pointing to the `groupe` table.

This corresponds to the `@ManyToOne` relationship defined in `Utilisateur`. The business rule requires every user to have a group, but the join column is not declared non-null in the current entity mapping; the database mapping therefore does not enforce that requirement.

The business rule also prohibits deleting a group while users are assigned to it. The foreign-key constraint prevents that deletion at the database level, although the current controller does not provide a clear user-facing explanation when the database rejects it.

## Important note

The persistence file contains local demonstration credentials in plain text. No production database configuration or migration system was detected in the current repository.
