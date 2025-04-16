describe("Login", () => {
  it("deve fazer login com sucesso", () => {
    cy.login();

    cy.url().should("include", "/inicio");

    cy.contains("Bem vindo ao Desafio").should("be.visible");
  });
});
