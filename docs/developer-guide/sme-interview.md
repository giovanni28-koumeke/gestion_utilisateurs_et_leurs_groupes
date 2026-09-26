# SME Interview Questions

The following questions guide discussion of feature goals, business rules, operating requirements, error handling, and configuration with a subject-matter expert.

## Questions

1. **Feature goals:** What user problem should group and user management solve, and which outcomes define a successful create, list, update, or delete operation?
2. **Relationship rules and edge cases:** Must every user belong to a group? What should happen when a group with users is selected for deletion, when no groups exist, or when a user is moved to another group?
3. **Prerequisites:** Which Java, NetBeans, and PostgreSQL versions should the team officially support, and what database state must be present before first launch?
4. **Validation rules:** Which fields are required, what formats or uniqueness rules apply to identifiers, and what should the application do with blank or excessively long values?
5. **Error modes and recovery:** What should users see when the database is unavailable, a transaction fails, a record cannot be found, or a constraint rejects a change? Should retry or rollback behavior be exposed?
6. **Configuration and defaults:** Are the current JDBC URL, role, password, port, and schema-generation action intended only for local demonstrations? What are the approved defaults and how should contributors override them?
7. **Acceptance and ownership:** Who approves changes to behavior and documentation, what manual or automated checks are required before release, and where should unresolved decisions be recorded?

