# Project structure

This project has a straightforward structure that reflects a simple Java desktop JPA application.

## Root structure

```text
jpa/
├── build.xml
├── manifest.mf
├── lib/
├── nbproject/
├── src/
├── test/
├── README.md
└── docs/
```

## Source package breakdown

### `src/entite`

Entity classes:

- `Groupe.java`
- `Utilisateur.java`

These are mapped with JPA annotations.

### `src/dao`

Persistence access objects:

- `GroupeDao.java`
- `UtilisateurDao.java`

### `src/service`

Business service classes:

- `GroupeService.java`
- `UtilisateurService.java`

### `src/presentation/controleur`

UI event handlers and controller logic:

- `AcceilControleur.java`
- `GroupeControleur.java`
- `UtilisateurControleur.java`

### `src/presentation/vue`

Swing interface classes:

- `AcceuilUI.java`
- `GroupeUI.java`
- `UtilisateurUI.java`

### `src/jpa`

Application entry point:

- `Jpa.java`

### `src/META-INF`

JPA configuration:

- `persistence.xml`

## Notes

This structure is compact and intentionally simple. The project is not intended to be a multi-module application or a SaaS architecture. It is a teaching-oriented CRUD application showing how JPA can be used with Swing and PostgreSQL.

## What is already implemented

From the source code, the project matches the following structure and responsibilities:

- entity mapping and persistence metadata in `src/entite`
- database access logic in `src/dao`
- the controller logic in `src/presentation/controleur`
- Swing UI forms in `src/presentation/vue`
- runtime startup in `src/jpa/Jpa.java`
- JPA configuration in `src/META-INF/persistence.xml`

This is the architecture actually present in the repository and should be used as the reference for the project documentation.
