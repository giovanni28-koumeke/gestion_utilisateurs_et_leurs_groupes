# SME Interview Questions

The following questions guide discussion of feature goals, business rules, operating requirements, error handling, and configuration with a subject-matter expert.

## Questions

1. **Feature goals:** What user problem should group and user management solve, and which outcomes define a successful create, list, update, or delete operation?
2. **Relationship rules and edge cases:** Must every user belong to a group? What should happen when a group with users is selected for deletion, when no groups exist, or when a user is moved to another group?
3. **Prerequisites:** Which Java, NetBeans, and PostgreSQL versions should the team officially support, and what database state must be present before first launch?
4. **Validation rules:** Which fields are required, what formats or uniqueness rules apply to identifiers, and what should the application do with blank or excessively long values?
5. **Error modes and recovery:** What should users see when the database is unavailable, a transaction fails, a record cannot be found, or a constraint rejects a change? Should retry or rollback behavior be exposed?
6. **Configuration and defaults:** Are the current JDBC URL, role, password, port, and schema-generation action intended only for local demonstrations? What are the approved defaults and how should contributors override them?
7. **Release checks:** Which manual or automated checks must pass before the project is submitted?

## Confirmed Business Requirements

- **Purpose:** Organize users by assigning them to groups.
- **Group assignment:** Every user must belong to a group.
- **Group deletion:** A group with one or more assigned users must not be deleted.
- **Group reassignment:** Changing a user's group must update that user's group membership.
- **Required user fields:** A user's name and identifier are required.
- **Identifier uniqueness:** Each user's identifier must be unique.
- **Error feedback:** When an operation fails, the application should show an appropriate error message on screen.
- **Demonstration configuration:** The `jpa` / `jpa` credentials and `create` schema action are for local demonstrations only.
- **Java version:** Java 21 is the version used for the project. Compatibility with other Java versions has not been established.
- **Submission responsibility:** The project author is responsible for checking readiness before submission.

## Implementation Alignment

- The `Utilisateur.groupe` mapping does not declare `nullable = false`, and the user form does not validate that a group is selected. The mandatory-assignment requirement is therefore not enforced by the current entity mapping or form validation.
- The group deletion flow attempts deletion and relies on the database foreign-key constraint when users still reference the group. The controller catches the exception and prints a generic message to standard output; it does not provide a clear user-facing rejection.
- The user edit form assigns the selected group to `Utilisateur.groupe`, so reassignment is available through the current interface. The group list is loaded when the controller is constructed, so groups added later are not available in that selector until the application is restarted.
- The add form checks that the name and identifier are non-empty, but it does not check identifier uniqueness. The entity mapping does not declare the identifier column unique. The database schema generated from this mapping therefore does not enforce the confirmed uniqueness requirement.
- Some controller error handlers print generic messages to standard output instead of showing an appropriate on-screen message. This does not meet the confirmed error-feedback requirement.
- The source configures Java 21. Support for other Java, NetBeans, and PostgreSQL versions has not been established.
- The credentials and schema-generation setting are confirmed for local demonstrations only. The repository does not define an alternative contributor configuration mechanism.

