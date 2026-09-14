# JPA

The project uses Java Persistence API to map Java classes to relational tables.

## Role of JPA

JPA is the persistence standard used to abstract database operations. Instead of writing SQL directly in the application logic, the project uses entity classes and the `EntityManager` API.

## Main JPA classes used in the code

### EntityManagerFactory

The DAO classes create an `EntityManagerFactory` using:

```java
Persistence.createEntityManagerFactory("jpaPU")
```

This factory is the entry point to create `EntityManager` instances.

### EntityManager

The `EntityManager` is used to:

- persist data
- merge updates
- remove records
- query entities
- find entities by their primary key

### Persistence unit

The persistence unit is defined in `src/META-INF/persistence.xml` and named `jpaPU`.

## JPA in this project

The entities are:

- `entite.Groupe`
- `entite.Utilisateur`

They are marked with annotations such as:

- `@Entity`
- `@Table`
- `@Id`
- `@GeneratedValue`
- `@Column`
- `@ManyToOne`
- `@JoinColumn`

## Relation mapping

The `Utilisateur` entity maps to the `id_groupe` foreign key, establishing the relationship between a user and their group.

## Note

The project uses EclipseLink as the provider and PostgreSQL as the database backend, which is consistent with the libraries and persistence configuration present in the project.
