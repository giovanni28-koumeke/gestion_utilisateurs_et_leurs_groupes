/** @type {import('@docusaurus/types').Config} */
const config = {
  title: 'JPA Project Documentation',
  tagline: 'Java Swing, JPA and PostgreSQL project reference',
  favicon: 'img/favicon.ico',

  url: 'https://your-org.github.io',
  baseUrl: '/',
  organizationName: 'your-org',
  projectName: 'jpa-project',

  onBrokenLinks: 'warn',

  markdown: {
    hooks: {
      onBrokenMarkdownLinks: 'warn',
    },
  },

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
          href: 'https://github.com/your-org/your-repo',
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
