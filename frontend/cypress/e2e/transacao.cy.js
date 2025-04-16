import { faker } from "@faker-js/faker";

describe("Transações com clientes reais já cadastrados", () => {
  beforeEach(() => {
    cy.login();
    cy.navegarParaTransacao();
  });

  it("deve realizar uma transação com sucesso para a cliente Madeline", () => {
    cy.realizarTransacaoPorNome("Madeline", "300");
    cy.contains("Venda realizada com sucesso").should("be.visible");
  });

  it("deve bloquear a transação para a cliente Winona (saldo insuficiente)", () => {
    cy.realizarTransacaoPorNome("Winona", "100");
    cy.get("body").then(($body) => {
      if ($body.text().includes("Venda realizada com sucesso")) {
        throw new Error(
          "Erro crítico: transação com saldo insuficiente foi aceita",
        );
      } else {
        cy.log("Transação foi corretamente bloqueada (sem feedback visível)");
      }
    });
  });
});
