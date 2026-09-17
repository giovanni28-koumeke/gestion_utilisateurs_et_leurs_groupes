module.exports = {
  tutorialSidebar: [
    'intro',
    {
      type: 'category',
      label: 'Getting started',
      items: [
        'getting-started/prerequisites',
        'getting-started/installation',
        'getting-started/configuration',
        'getting-started/first-launch',
      ],
    },
    {
      type: 'category',
      label: 'User guide',
      items: [
        'user-guide/groups',
        'user-guide/users',
        'user-guide/crud-operations',
      ],
    },
    {
      type: 'category',
      label: 'Tutorials',
      items: ['tutorials/create-group', 'tutorials/create-user'],
    },
    {
      type: 'category',
      label: 'Concepts',
      items: [
        'concepts/architecture',
        'concepts/data-flow',
        'concepts/jpa',
        'concepts/database',
      ],
    },
    {
      type: 'category',
      label: 'Developer guide',
      items: [
        'developer-guide/project-structure',
        'developer-guide/persistence',
        'developer-guide/troubleshooting',
        'developer-guide/quality',
      ],
    },
    'reference/operations',
    'technical-blog',
  ],
};
