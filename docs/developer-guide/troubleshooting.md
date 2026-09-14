# Troubleshooting

This section documents the most realistic project issues based on the current configuration and code.

## 1. PostgreSQL connection issues

### Symptom

The application cannot connect to the database.

### What to check

- PostgreSQL is running locally
- the `jpa` database exists
- the user `jpa` exists and has permissions
- the connection URL is correct

### Verified configuration

```text
jdbc:postgresql://localhost:5432/jpa
```

## 2. JPA configuration issues

### Symptom

The project fails to create the persistence unit or cannot initialize JPA.

### What to check

- the `persistence.xml` file is present in `src/META-INF`
- the `jpaPU` name matches the code using `Persistence.createEntityManagerFactory("jpaPU")`
- the JAR dependencies are present in the lib directory

## 3. Missing dependencies

### Symptom

Compilation or runtime errors mention missing JPA or PostgreSQL classes.

### What to check

Verify the presence of:

- eclipselink-4.0.4.jar
- jakarta.persistence-api-3.2.0.jar
- postgresql-42.7.11.jar

## 4. Application launch issues

### Symptom

The project does not start from NetBeans.

### What to check

- the project is opened in NetBeans as a Java project
- the main class is `jpa.Jpa`
- there are no missing build paths or broken references

## 5. Database schema issues

### Symptom

The application starts but database tables are not created.

### What to check

The project is configured with:

```xml
<property name="jakarta.persistence.schema-generation.database.action" value="create"/>
```

If this is not respected in the runtime environment, the generated schema may not appear as expected.

## 6. Known limitation in the current project

Some service methods are unimplemented or return `null`.

This means some flows may be incomplete from a production perspective and should be reviewed before extending the project.

## Important note

This troubleshooting guide is intentionally limited to issues that are realistic within the current code and configuration. No fictional system failures were introduced.
