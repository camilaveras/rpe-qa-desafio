# Desafio Técnico - QA Frontend | RPE Tech

Este repositório contém a automação de testes end-to-end do desafio técnico de QA Frontend da RPE, utilizando Cypress + Faker + Mochawesome para geração de relatórios.

## ✅ Escopo Atendido

- Elaboração do plano de testes com foco nos fluxos principais
- Levantamento e automação dos seguintes fluxos:
  - Login
  - Cadastro de cliente (com saldo e sem saldo)
  - Transação (com sucesso e com bloqueio por saldo insuficiente)
- Identificação de comportamento inesperado (detalhado abaixo)
- Relatório visual dos testes via Mochawesome

---

## 🧶 Plano de Testes

### Funcionalidades testadas:

| Funcionalidade      | Cenário                                  | Status |
| ------------------- | ---------------------------------------- | ------ |
| Login               | Login válido com credenciais admin/admin | ✅     |
| Cadastro de cliente | Cliente com saldo positivo               | ✅     |
| Cadastro de cliente | Cliente com saldo zero                   | ✅     |
| Transação           | Cliente com saldo suficiente             | ✅     |
| Transação           | Cliente com saldo insuficiente           | ✅     |

---

## 📟 Casos de Teste Automatizados

- Login bem-sucedido
- Cadastro de cliente com saldo (`R$ 500`)
- Cadastro de cliente com saldo zerado (`R$ 0`)
- Transação com valor menor que o saldo (espera sucesso)
- Transação com valor maior que o saldo (espera bloqueio)

---

## 🐞 Bugs e Comportamentos Inesperados

1. **Clientes com saldo maior que R$ 1.000 estão com erro**

   - Ao cadastrar clientes com saldo acima de R$ 1.000, o sistema apresenta comportamento inesperado.

2. **Cliente com saldo zerado mostra campo de "validade do cartão"**

   - Esse campo não deveria aparecer, pois não é relevante para a tela de cadastro ou transação.

3. **Transação com cliente sem saldo não exibe mensagem de erro**

   - O botão é clicado, mas nenhuma resposta ou feedback é mostrado ao usuário, mesmo após aguardar 3 minutos.

4. **Não há validação de CPF**

   - É possível cadastrar CPFs inválidos como `000.000.000-00`.

5. **Botão "Listar Transações" não apresenta nenhuma ação**
   - O botão está presente mas não gera nenhuma resposta ou listagem.

## 🐞 Sugestões de melhoria:

- Adicionar validação de CPF.
- Garantir mensagens de erro para todos os fluxos que bloqueiam o usuário.
- Corrigir a exibição de campos irrelevantes como "validade do cartão".
- Habilitar corretamente os botões de listagem e feedback visual após operações.

---

## 📁 Estrutura do Projeto

frontend/ ├── cypress/ │ ├── e2e/ │ │ ├── login.cy.js │ │ ├── cadastro.cy.js │ │ └── transacao.cy.js │ ├── support/ │ │ ├── commands.js │ │ └── e2e.js │ └── fixtures/ │ └── usuario.json ├── cypress.config.js ├── package.json └── README.md

---

## 🚀 Como Executar os Testes

1. Instale as dependências:

   ```bash
   npm install
   ```

2. Instale as bibliotecas adicionais utilizadas:

   ```bash
    npm install cypress --save-dev
    npm install @faker-js/faker --save-dev
    npm install mochawesome mochawesome-merge mochawesome-report-generator --save-dev
   ```

3. Rode os testes:
   ```bash
   npm run test
   ```
4. Gere o relatório:
   ```bash
   npm run report
   ```
5. O relatório final estará em:
   ```bash
   cypress/reports/html/report.html
   ```

🌟 Diferenciais Aplicados

- Uso de Faker para gerar dados realistas e dinâmicos

- Reutilização de comandos personalizados (cy.login, cy.cadastrarCliente, cy.realizarTransacaoPorNome)

- Testes bem estruturados e modulares

- Identificação clara de bugs com sugestões

- Relatório HTML integrado

  Desenvolvido por: Camila — QA com anos de experiência e foco em qualidade com impacto
