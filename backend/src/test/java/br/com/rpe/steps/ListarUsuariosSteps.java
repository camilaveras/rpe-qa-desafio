package br.com.rpe.steps;

import br.com.rpe.util.RTF;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ListarUsuariosSteps {
    private Response response;

    @Quando("eu envio uma requisicao GET para {string}")
    public void envioRequisicaoGet(String endpoint) {
        response = given()
                .when()
                .get(endpoint);
        RTF.evidenciar("Requisição GET enviada", endpoint, String.valueOf(response.getStatusCode()));
    }

    @Entao("o sistema deve retornar status 200 e uma lista de usuarios")
    public void deveRetornar200ComLista() {
        response.then().statusCode(200)
                .body("data", notNullValue());
        RTF.evidenciar("Validação do status code 200 e corpo da resposta", "200", String.valueOf(response.getStatusCode()));
    }
}
