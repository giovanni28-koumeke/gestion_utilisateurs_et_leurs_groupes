# Groups and Users Management

A Java Swing desktop application for managing groups and users with JPA, EclipseLink, and PostgreSQL. The project demonstrates entity mapping and database persistence in a small NetBeans Java application.

## Project Status

This is an educational project and is not intended for production use. The desktop interface connects group and user add, list, update, and delete actions to the DAO layer. Some additional service methods are incomplete. The project does not provide an HTTP API, authentication, or Docker deployment.

## Features

- Add, list, update, and delete groups through the Swing interface.
- Add, list, update, and delete users through the Swing interface.
- Associate a user with a group through a JPA `ManyToOne` relationship.
- Find an entity by ID through DAO methods; ID lookup is not available from the main menu.

Some service methods not used by these interface flows remain incomplete. See the [operations reference](docs/reference/operations.md) and [troubleshooting guide](docs/developer-guide/troubleshooting.md).

## Technology

- Java 21, as configured by the NetBeans project
- Java Swing
- Jakarta Persistence API 3.2.0
- EclipseLink 4.0.4
- PostgreSQL JDBC driver 42.7.11 and PostgreSQL
- NetBeans Java project built with Apache Ant

The dependency JAR files are included in `lib/`. The repository does not specify a minimum PostgreSQL or NetBeans version.

## Prerequisites

- JDK 21
- NetBeans IDE with Java Ant project support
- PostgreSQL available at `localhost:5432`
- A PostgreSQL database named `jpa` and a role named `jpa` with access to that database

The demonstration credentials are stored in plain text in `src/META-INF/persistence.xml`. They are not suitable for production use.

## Installation and Quick Start

1. Install JDK 21, NetBeans, and PostgreSQL.
2. If needed, create the role and database by running these statements separately in `psql` as a PostgreSQL administrator:

   ```sql
   CREATE ROLE jpa LOGIN PASSWORD 'jpa';
   CREATE DATABASE jpa OWNER jpa;
   ```

   If either object already exists, verify its permissions instead of running its `CREATE` statement again.
3. Open the repository root in NetBeans and verify that the libraries in `lib/` are resolved.
4. Run the NetBeans project. Its configured main class is `jpa.Jpa`.
5. Use the home-screen buttons to open the group and user forms and lists.

The JPA configuration uses `jdbc:postgresql://localhost:5432/jpa` and sets `schema-generation.database.action` to `create`. This is not a migration mechanism and does not guarantee preservation of existing data. Use a disposable database with no data to preserve.

See the [30-minute quickstart](docs/tutorials/quickstart-30-min.md) for a guided group-and-user workflow.

## Docusaurus Documentation Site

The documentation site uses Node.js and npm. From the repository root, install the locked dependencies and start the development server:

```powershell
npm ci
npm run start
```

Build and serve the production site locally with:

```powershell
npm run build
npm run serve
```

The GitHub Actions workflow uses Node.js 20. The generated site is written to `docusaurus-build/`, separate from NetBeans' `build/` directory. `npm run deploy` publishes the site and requires a configured GitHub repository and deployment credentials.

## Configuration

| Setting | Current value | Source |
|---|---|---|
| Persistence unit | `jpaPU` | `src/META-INF/persistence.xml` |
| Transaction type | `RESOURCE_LOCAL` | `src/META-INF/persistence.xml` |
| JDBC URL | `jdbc:postgresql://localhost:5432/jpa` | `src/META-INF/persistence.xml` |
| Database user and password | `jpa` / `jpa` | Plain-text demonstration values in `src/META-INF/persistence.xml` |
| Schema generation | `create` | JPA provider schema generation; not a migration |

## Project Structure

```text
src/
├── dao/
│   ├── GroupeDao.java
│   └── UtilisateurDao.java
├── entite/
│   ├── Groupe.java
│   └── Utilisateur.java
├── jpa/
│   └── Jpa.java
├── META-INF/
│   └── persistence.xml
├── presentation/
│   ├── controleur/
│   │   ├── AcceilControleur.java
│   │   ├── GroupeControleur.java
│   │   └── UtilisateurControleur.java
│   └── vue/
│       ├── AcceuilUI.java
│       ├── GroupeUI.java
│       └── UtilisateurUI.java
└── service/
    ├── GroupeService.java
    └── UtilisateurService.java
```

## Contributing

1. Create a branch from `main`.
2. Keep changes focused and update the documentation when documented behavior changes.
3. For documentation changes, run `npm ci` and `npm run build`. For Java changes, compile and test the project in NetBeans against a disposable database.
4. Submit a pull request describing the change and the checks performed.

## License

No license file or explicit license declaration is included in the repository. Reuse and redistribution terms are therefore not specified.
