import { faker } from "@faker-js/faker";

describe("Cadastro de Clientes com saldo e sem saldo", () => {
  let clienteComSaldo;
  let clienteSemSaldo;

  before(() => {
    clienteComSaldo = {
      nome: faker.person.firstName(),
      cpf: faker.number.int({ min: 10000000000, max: 99999999999 }).toString(),
      saldo: "900.00",
    };

    clienteSemSaldo = {
      nome: faker.person.firstName(),
      cpf: faker.number.int({ min: 10000000000, max: 99999999999 }).toString(),
      saldo: "0",
    };
  });

  beforeEach(() => {
    cy.login();
  });

  it("deve cadastrar cliente com saldo", () => {
    cy.navegarParaCadastro();
    cy.cadastrarCliente(
      clienteComSaldo.nome,
      clienteComSaldo.cpf,
      clienteComSaldo.saldo,
    );
    cy.contains("Cliente salvo com sucesso").should("be.visible");
  });

  it("deve cadastrar cliente sem saldo", () => {
    cy.navegarParaCadastro();
    cy.cadastrarCliente(
      clienteSemSaldo.nome,
      clienteSemSaldo.cpf,
      clienteSemSaldo.saldo,
    );
    cy.contains("Cliente salvo com sucesso").should("be.visible");
  });
});
