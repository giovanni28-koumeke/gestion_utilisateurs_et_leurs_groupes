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

This corresponds to the `@ManyToOne` relationship defined in `Utilisateur`. The join column is not declared non-null in the entity mapping.

## Important note

The persistence file contains local demonstration credentials in plain text. No production database configuration or migration system was detected in the current repository.
