/** @type {import('@docusaurus/types').Config} */
const config = {
  title: 'JPA Project Documentation',
  tagline: 'Java Swing, JPA and PostgreSQL project reference',
  url: 'https://giovanni28-koumeke.github.io',
  baseUrl: '/gestion_utilisateurs_et_leurs_groupes/',
  organizationName: 'giovanni28-koumeke',
  projectName: 'gestion_utilisateurs_et_leurs_groupes',

  onBrokenLinks: 'warn',

  markdown: {
    mermaid: true,
    hooks: {
      onBrokenMarkdownLinks: 'warn',
    },
  },

  themes: ['@docusaurus/theme-mermaid'],

  i18n: {
    defaultLocale: 'en',
    locales: ['en'],
  },

  presets: [
    [
      'classic',
      {
        docs: {
          routeBasePath: '/',
          sidebarPath: require.resolve('./sidebars.js'),
        },
        blog: false,
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      },
    ],
  ],

  themeConfig: {
    navbar: {
      title: 'JPA Project',
      items: [
        {
          type: 'doc',
          docId: 'intro',
          position: 'left',
          label: 'Documentation',
        },
        {
          href: 'https://github.com/giovanni28-koumeke/gestion_utilisateurs_et_leurs_groupes',
          label: 'GitHub',
          position: 'right',
        },
      ],
    },
    footer: {
      style: 'dark',
      copyright: `Copyright © ${new Date().getFullYear()} JPA Project Documentation`,
    },
  },
};

module.exports = config;
