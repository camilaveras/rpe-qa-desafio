# Testes Automatizados - Backend (API ReqRes)

Este projeto contém testes automatizados da API pública [ReqRes](https://reqres.in) utilizando **Java**, **RestAssured**, **JUnit 5** e **Cucumber**.

---

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

