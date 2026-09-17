# Architecture

This project uses a simplified layered architecture for a desktop Java application with JPA persistence.

## Layered structure

```text
Swing UI
   ↓
Controller
   ↓
Service
   ↓
DAO
   ↓
JPA / EntityManager
   ↓
PostgreSQL
```

## Entity layer

The entity classes are located in the `entite` package.

These classes represent database records as Java objects and are mapped to tables using JPA annotations.

### Examples

- `Groupe`
- `Utilisateur`

## DAO layer

The DAO layer contains classes that manage direct access to the database through `EntityManager`.

Examples:

- `GroupeDao`
- `UtilisateurDao`

These classes provide persistence operations such as:

- insert
- update
- delete
- find by id
- list items

## Service layer

The service layer sits between controllers and DAOs. It wraps DAO calls and offers a business-friendly interface for the rest of the application.

Examples:

- `GroupeService`
- `UtilisateurService`

## Controller layer

The controller classes are responsible for linking UI events to service calls.

Examples:

- `GroupeControleur`
- `UtilisateurControleur`
- `AcceilControleur`

## View layer

The view layer is composed of Swing forms and dialog windows.

Examples:

- `AcceuilUI`
- `GroupeUI`
- `UtilisateurUI`

## Why this structure matters

This structure separates responsibilities and makes the project easier to understand:

- the view handles the interface
- the controller handles user actions
- the service handles business logic
- the DAO interacts with persistence
- the entity models the database record

## Verified implementation in the project

The actual code confirms this layered flow:

- Swing views are implemented under `src/presentation/vue`
- controller logic is implemented under `src/presentation/controleur`
- service logic is implemented under `src/service`
- persistence operations are implemented under `src/dao`
- entity mappings are implemented under `src/entite`

## Important note

The project is a teaching example, so the separation is intentionally simple and not fully production-optimized.
