const { defineConfig } = require("cypress");

module.exports = defineConfig({
  reporter: "mochawesome", // 👈 adiciona aqui
  reporterOptions: {
    reportDir: "cypress/reports",
    overwrite: false,
    html: false,
    json: true,
  },
  e2e: {
    baseUrl: "http://provaqa.prc.rpe.tech:9080/desafioqa",
    supportFile: "cypress/support/e2e.js",
    setupNodeEvents(on, config) {
      // Se quiser depois usar mochawesome-merge, isso pode ser necessário
    },
  },
});
