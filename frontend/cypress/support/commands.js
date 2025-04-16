Cypress.Commands.add("login", () => {
  cy.visit("/");

  cy.fixture("usuario").then((user) => {
    cy.get('input[name="username"]').type(user.username);
    cy.get('input[name="password"]').type(user.password);
    cy.get('button[type="submit"]').click();
  });
});

Cypress.Commands.add("cadastrarCliente", (nome, cpf, saldo) => {
  cy.get("#nome").type(nome);
  cy.get("#cpf").type(cpf);
  cy.get("#saldoCliente").type(saldo);
  cy.get("button[type='botaoSalvar']").click();
});

Cypress.Commands.add("cadastrarCliente", (nome, cpf, saldo) => {
  cy.get("#nome").type(nome);
  cy.get("#cpf").type(cpf);
  cy.get("#saldoCliente").type(saldo);
  cy.get("#botaoSalvar").click();
});

Cypress.Commands.add("navegarParaCadastro", () => {
  cy.get('a[title="QA"]').click();
  cy.wait(300);
  cy.contains("span.menu-item-parent", "Clientes").click({ force: true });
  cy.wait(300);
  cy.contains("span.menu-item-parent", "Incluir").click({ force: true });
});

Cypress.Commands.add("navegarParaTransacao", () => {
  cy.get('a[title="QA"]').click();
  cy.wait(300);

  cy.get('a[title="Transações"]').click({ force: true }); // corrigido
  cy.wait(300);

  cy.get('a[href="/desafioqa/incluirVenda"]').click({ force: true }); // corrigido
});

Cypress.Commands.add("realizarTransacaoPorNome", (nomeCliente, valor) => {
  cy.get("#cliente").select(nomeCliente);
  cy.get("#valorTransacao").type(valor);
  cy.get("#botaoSalvar").click();
});
