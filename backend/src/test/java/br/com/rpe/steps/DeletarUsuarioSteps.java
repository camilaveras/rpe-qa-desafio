package br.com.rpe.steps;

import br.com.rpe.util.RTF;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeletarUsuarioSteps {
    private Response response;

    @Quando("eu envio uma requisicao DELETE para {string}")
    public void envioDelete(String endpoint) {
        response = given()
                .when()
                .delete(endpoint);
        RTF.evidenciar("Requisição DELETE enviada", endpoint, String.valueOf(response.getStatusCode()));
    }

    @Entao("o sistema deve retornar status 204")
    public void validaDelete() {
        response.then().statusCode(204);
        RTF.evidenciar("Validação do status code 204", "204", String.valueOf(response.getStatusCode()));
    }
}
