# Final Presentation

## 1. Platform Introduction

The project is a Java Swing desktop application for managing `Groupe` and `Utilisateur` entities with JPA, EclipseLink, and PostgreSQL. It is intended for learners and developers exploring desktop Java persistence. Clear documentation supports installation, explains the persistence workflow, and distinguishes implemented behavior from limitations.

## 2. Documentation Walkthrough

The Docusaurus documentation site presents the project through the following sections:

- **Project overview:** status, prerequisites, configuration, and launch instructions.
- **Installation and tutorial:** environment setup and a 30-minute group-and-user tutorial.
- **User guide:** group and user workflows, including create, list, update, and delete operations.
- **Developer guide:** project structure, persistence, development workflows, troubleshooting, quality review, and SME interview questions.
- **Reference:** implemented Java/DAO operations and an explanation of why HTTP request and response documentation does not apply to this desktop application.
- **Concepts:** architecture, data flow, JPA, and database mapping.
- **Technical blog:** analysis of the group-selector refresh behavior and its current restart workaround.

## 3. Key Challenges

An important challenge is distinguishing intended CRUD behavior from behavior implemented in source. For example, the user controller loads groups when it is constructed. A group created later in the same application session does not appear in the user selector until the application is restarted. The project exposes Java methods but no HTTP endpoints, so its API reference describes the available Java operations.

## 4. Lessons Learned

- Trace user actions through the view, controller, service, DAO, entity, and persistence configuration.
- Consider object lifetime and UI state when investigating data-flow behavior.
- Use tutorials, task-focused how-tos, reference information, and conceptual explanations for distinct learning needs.
- Confirm product rules and edge cases with subject-matter experts.
- Validate installation and build instructions in a clean environment.

## 5. Q&A

Discussion topics include the project's current limitations, the absence of an HTTP API, the JPA `create` schema-generation setting, and the local installation and persistence workflow.
