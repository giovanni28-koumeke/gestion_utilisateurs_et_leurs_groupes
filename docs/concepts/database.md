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

The current configuration sets schema generation to `create`, so the tables are created automatically if they do not exist.

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

This is consistent with the `@ManyToOne` relationship defined in the `Utilisateur` class.

## Important note

The database is configured for local development only. No production database configuration or migration system was detected in the current repository.
