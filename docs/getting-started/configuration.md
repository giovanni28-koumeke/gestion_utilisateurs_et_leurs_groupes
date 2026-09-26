# Configuration

The project configuration is centered on the JPA persistence unit defined in `src/META-INF/persistence.xml`.

## Persistence unit

The configuration declares the following persistence unit:

- name: `jpaPU`
- transaction type: `RESOURCE_LOCAL`
- provider: `org.eclipse.persistence.jpa.PersistenceProvider`

This configuration was validated directly in the source file [src/META-INF/persistence.xml](../../src/META-INF/persistence.xml).

## Entity registration

The persistence unit explicitly registers the following entity classes:

- `entite.Utilisateur`
- `entite.Groupe`

## Database settings

The current configuration is:

```xml
<property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
<property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/jpa"/>
<property name="jakarta.persistence.jdbc.user" value="jpa"/>
<property name="jakarta.persistence.jdbc.password" value="jpa"/>
```

## Schema generation

The project uses:

```xml
<property name="jakarta.persistence.schema-generation.database.action" value="create"/>
```

This requests schema creation by the persistence provider. It does not create the PostgreSQL database or role and is not a migration strategy. Do not point this configuration at a database whose existing data must be preserved.

## Logging settings

The project also includes EclipseLink logging parameters:

```xml
<property name="eclipselink.logging.level" value="FINE"/>
<property name="eclipselink.logging.parameters" value="true"/>
```

These settings help trace SQL and JPA operations during execution.

## Important note

This configuration is real and was validated from the source code. No alternative environment configuration was detected in the project.
