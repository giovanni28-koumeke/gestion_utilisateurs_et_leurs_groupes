# Development workflows

This guide explains how to trace and extend the Java Swing application using its source structure and NetBeans project configuration.

## Architecture reference

The application flow is Swing view → controller → service → DAO → JPA `EntityManager` → PostgreSQL. The entities are mapped separately under `src/entite/`. See [Architecture](../concepts/architecture.md) and [Data flow](../concepts/data-flow.md) for diagrams and the user-list example.

| Responsibility | Current source location | Example |
|---|---|---|
| Desktop entry point | `src/jpa/` | `Jpa.main()` creates `AcceilControleur` |
| Swing screens | `src/presentation/vue/` | `AcceuilUI`, `GroupeUI`, `UtilisateurUI` |
| UI event handling | `src/presentation/controleur/` | `AcceilControleur`, `GroupeControleur`, `UtilisateurControleur` |
| Service delegation | `src/service/` | `GroupeService`, `UtilisateurService` |
| Persistence operations | `src/dao/` | `GroupeDao`, `UtilisateurDao` |
| Entity mapping | `src/entite/` | `Groupe`, `Utilisateur` |
| Persistence configuration | `src/META-INF/` | `persistence.xml`, unit `jpaPU` |

## Add or change a feature

1. **Confirm the behavior first.** Write down the intended user action, validation rules, success result, and failure cases. Ask the SME questions in the [interview worksheet](./sme-interview.md) where the source does not establish product intent.
2. **Trace the existing path.** Start at the button in the relevant Swing view, follow its listener in the controller, and check the service and DAO methods it calls. Do not assume a similarly named service method is implemented; for example, both `lister()` methods currently return `null` while the home-screen list actions use other methods.
3. **Update the view and controller together.** Keep form fields, validation, user feedback, and event wiring consistent. Current validation is limited: group creation checks the group name, and user creation checks the name and identifier. The user form's group list is loaded when its controller is constructed.
4. **Implement the service behavior.** Delegate to the intended DAO operation and define behavior for empty results and invalid input. Existing service methods with empty bodies or `null` returns are not working examples to copy.
5. **Implement persistence in the DAO.** Follow the existing `EntityManager` and transaction pattern: open an entity manager, begin a transaction for writes, commit on success, rollback an active transaction on failure, and close the entity manager in `finally`.
6. **Update mappings only when needed.** Entity annotations are in `src/entite/`; registered classes and database defaults are in `src/META-INF/persistence.xml`. Review foreign-key behavior before changing or deleting related records. The current `Utilisateur.groupe` mapping has no explicit non-null or cascade setting.
7. **Verify with disposable data.** The configured schema action is `create`, so use a disposable local database. Build and run through the NetBeans project, then exercise the changed UI path and relevant empty/error cases. No automated Java tests are currently present under `test/`.
8. **Update the documentation with the implementation.** Add or revise the tutorial for a learning path, a how-to for a specific task, a reference for exact method/configuration details, and an explanation for architectural rationale. Link claims to the relevant source files.

## Configuration and defaults

| Setting | Current value | Source |
|---|---|---|
| Java source and target | `21` | `nbproject/project.properties` |
| Persistence unit | `jpaPU` | `src/META-INF/persistence.xml` |
| Transaction type | `RESOURCE_LOCAL` | `src/META-INF/persistence.xml` |
| JDBC URL | `jdbc:postgresql://localhost:5432/jpa` | `src/META-INF/persistence.xml` |
| Schema-generation action | `create` | `src/META-INF/persistence.xml` |
| Database credentials | `jpa` / `jpa` | Plain-text demo values in `src/META-INF/persistence.xml` |

There are no environment-specific persistence profiles in the repository. Do not point the checked-in demonstration credentials or schema-generation setting at a database that contains data to preserve.

## Error handling and edge cases

- Controllers currently catch some update/delete exceptions and print generic messages to standard output; they do not consistently present the underlying database cause to users.
- Deleting a group referenced by a user can fail due to the foreign-key constraint. No cascade behavior is declared on the mapping.
- `UtilisateurControleur` loads its group list during construction. Adding a group after launch does not refresh that list; the UI currently needs an application restart before the new group appears in the user selector.
- The user form validates name and identifier, but not first name, password, or group selection. Entity/database constraints can still reject persistence.
- DAO list methods use native SQL against `groupe` and `utilisateurs`; changing table names requires updating these queries as well as the entity mappings.

## Collaboration with technical writers

- Share the intended behavior and edge cases before implementation so that tutorial steps can be reviewed while the UI changes.
- Keep source names, configuration values, and user-visible labels available to the writer; the writer should not infer them from feature names.
- Review documentation changes alongside the code change and identify which claims have not yet been verified.
- After a behavior change, update the relevant user guide, reference page, and troubleshooting entry before release.
- Record verification performed and known gaps in the pull request. Do not describe an unrun manual test as successful.
