# API documentation and this project

## What an API is

An application programming interface (API) is a defined contract through which one software component uses another. An API may be a library interface inside one process or a network interface such as HTTP. API documentation should identify the contract that actually exists: its operations, inputs, outputs, constraints, errors, and security requirements.

## API provided by this repository

This repository is a Java Swing desktop application. The source defines Java methods on controllers, services, and DAOs, but it does **not** define an HTTP server, REST routes, request/response DTOs, or an OpenAPI document. There are no HTTP endpoints to call from a browser or another service.

Authentication is not applicable to the current interface: no login or authentication mechanism is implemented. The `Utilisateur` entity's `mot_de_passe` field is data stored by the application, not evidence of an authentication API; the project does not hash or verify it.

## Existing Java operation contract

The following Java DAO method retrieves a group by its primary key:

```java
public Groupe Trouver(int id)
```

| Item | Contract in the source |
|---|---|
| Owner | `dao.GroupeDao` |
| Input | `id`: Java `int`, the group primary-key value |
| Return | `entite.Groupe`, or `null` when `EntityManager.find()` finds no row |
| HTTP request/response | Not applicable; this is a Java method call |
| Failure behavior | Persistence/provider exceptions may propagate; no HTTP error mapping exists |

Example call-site fragment:

```java
Groupe groupe = groupeDao.Trouver(id);
if (groupe == null) {
    // No group exists for this identifier.
}
```

The call requires a configured `GroupeDao` instance and an `id` value in the surrounding Java code. Other operations are listed in the [application operations reference](./operations.md).

## HTTP/OpenAPI fields

| Documentation field | Status for this project |
|---|---|
| HTTP method and path | Not applicable: no HTTP endpoint exists |
| Request path, query, or body parameters | Not applicable: no HTTP request contract exists |
| Response body and status codes | Not applicable: no HTTP response contract exists |
| HTTP error codes | Not applicable: failures are Java/JPA/database exceptions, not HTTP responses |
| Authentication scheme | Not applicable: no authentication layer is implemented |
| OpenAPI endpoint example | Cannot be supplied truthfully from this source tree |

OpenAPI is a specification for describing HTTP APIs. Because this application has no HTTP endpoints, it has no project endpoint that can be represented in an OpenAPI specification. If an HTTP service is added, its routes, request and response schemas, status codes, and authentication requirements can be documented from that implementation.

The DAO and controller methods described here are internal Java operations for the desktop application; they are not a supported external API. The `Utilisateur` table and Swing actions do not define REST endpoints.
