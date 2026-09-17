---
sidebar_position: 4
---

# Documentation quality checklist

This checklist is intended to validate the quality of the project documentation before final delivery. It is based on the real content of the repository and should be applied manually during review.

## 1. Structure and hierarchy

- Check that each page has a clear title.
- Confirm that heading levels follow a logical sequence.
- Keep one H1 per page and use subsections consistently.
- Avoid redundant titles or duplicated section names.

## 2. Technical correctness

- Verify that all statements match the real code.
- Confirm that names of classes, packages, and methods are accurate.
- Keep the description aligned with the current JPA and PostgreSQL configuration.
- Remove any claim that is not supported by the repository.

## 3. Terminology

- Use consistent names such as `Groupe`, `Utilisateur`, `EntityManager`, and `jpaPU`.
- Prefer project-specific terminology over generic phrasing when the real name is known.
- Use one style for the terms “group” and “user” across the entire documentation.

## 4. Navigation and links

- Check that internal links refer to existing files.
- Confirm that sidebar entries match the actual documentation pages.
- Validate that cross-references are useful and easy to follow.
- Avoid broken relative paths.

## 5. Accessibility

- Use descriptive link text instead of generic labels such as “click here”.
- Keep paragraph length readable.
- Use lists and headings to improve scanability.
- Ensure contrast remains good in the rendered site.
- Keep code blocks readable and not excessive in length.

## 6. Writing quality

- Prefer clear and concise sentences.
- Use active voice whenever possible.
- Avoid repeating the same concept across multiple pages.
- Keep introductions short and focused on purpose.

## 7. Publication review

Before closing the project documentation, verify that:

- the site still builds locally,
- the sidebar lists the expected pages,
- the introduction reflects the actual project state,
- the user guide matches the implemented CRUD flows,
- the troubleshooting section is limited to realistic issues.

## Important note

This checklist should be used as a review guide. No accessibility audit was carried out automatically in this project, so the checklist is the recommended manual validation step before final publication.
