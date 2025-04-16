# Testes Automatizados - Backend (API ReqRes)

Este projeto contém testes automatizados da API pública [ReqRes](https://reqres.in) utilizando **Java**, **RestAssured
**, **JUnit 5** e **Cucumber**.

---

## 🧠 Planejamento de Testes

### 1. Elaboração de um plano de testes

O plano de testes foi construído com foco na validação dos principais fluxos da API ReqRes, simulando operações comuns como criação, atualização, deleção e listagem de usuários. O objetivo foi garantir a conformidade das respostas da API com os padrões esperados de status HTTP, estrutura e campos obrigatórios.

A abordagem utilizada foi **funcional e baseada em critérios de aceitação** definidos via Gherkin (BDD), com uso do framework Cucumber para facilitar a leitura e colaboração.

---

### 2. Levantamento de cenários e especificação dos casos de teste

Os casos de teste foram especificados em arquivos `.feature`, cobrindo os seguintes cenários:

| Funcionalidade            | Cenário                                          | Verificação                         |
|--------------------------|--------------------------------------------------|-------------------------------------|
| Criação de Usuário       | Criar um usuário com sucesso                     | Status 201 e campo `id` retornado   |
| Atualização Completa     | Atualizar todos os dados de um usuário           | Status 200 e campo `updatedAt`      |
| Atualização Parcial      | Atualizar apenas parte dos dados de um usuário   | Status 200 e campo `updatedAt`      |
| Exclusão de Usuário      | Deletar um usuário existente                     | Status 204                          |
| Listagem de Usuários     | Listar usuários da página 2                      | Status 200 e presença do campo `data` |

---

### 3. Identificação de possíveis bugs

Durante os testes, como a API ReqRes é estática e usada para testes simulados, **não foram encontrados bugs funcionais reais**.

Porém, destacam-se dois pontos de atenção observados e documentados:

- 🔍 **A API aceita updates e deletions sem validação de dados de entrada**, o que em um sistema real poderia ser uma falha de segurança ou lógica.
- 🔍 **Campos como `updatedAt` são gerados mesmo quando nenhum dado foi alterado** (por exemplo, envio de `PATCH` com `null`).

Esses comportamentos foram registrados como **potenciais inconsistências** e evidenciados nos logs do projeto via `RTF.log()` e relatórios do Allure.


## 📦 Instalação

Antes de rodar o projeto, é necessário ter instalado:

- Java 11+
- Maven 3.8+
- Git

Clone o repositório e entre na pasta `backend`:

```bash
    git clone https://github.com/seu-usuario/rpe-qa-desafio.git
    cd rpe-qa-desafio/backend

```

📚 Dependências
As principais bibliotecas utilizadas estão no pom.xml:

```bash
<dependencies>
  <!-- REST Assured -->
  <dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.3.1</version>
    <scope>test</scope>
  </dependency>

  <!-- JUnit 5 -->
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.3</version>
    <scope>test</scope>
  </dependency>

  <!-- JSON -->
  <dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20230227</version>
    <scope>test</scope>
  </dependency>

  <!-- Jackson -->
  <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.2</version>
  </dependency>

  <!-- Allure -->
  <dependency>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-rest-assured</artifactId>
    <version>2.20.1</version>
    <scope>test</scope>
  </dependency>

  <!-- Cucumber -->
  <dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.14.0</version>
    <scope>test</scope>
  </dependency>

  <dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit-platform-engine</artifactId>
    <version>7.14.0</version>
    <scope>test</scope>
  </dependency>

  <dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-suite</artifactId>
    <version>1.9.3</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

▶️ Como rodar os testes

1. Acesse a pasta backend:
    ```bash
       cd backend
    ```

2. Rode os testes com Maven:

   ```bash
      mvn clean test
    ```

📈 Como visualizar o relatório
📄 Relatório HTML do Cucumber
Após a execução dos testes, abra o arquivo:

   ```bash
        target/cucumber-report.html
   ```

📊 Relatório Allure (opcional)
Se quiser gerar um relatório mais completo com o Allure:

   ```bash
        mvn allure:report
   ```

O relatório será gerado em target/site/allure-maven-plugin/index.html.

