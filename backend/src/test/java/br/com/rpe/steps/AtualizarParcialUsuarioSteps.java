package br.com.rpe.steps;

import br.com.rpe.data.UserFactory;
import br.com.rpe.dto.User;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AtualizarParcialUsuarioSteps {

    private Response response;

    @Quando("eu envio uma requisicao PATCH para {string}")
    public void envioPatch(String endpoint) {
        User user = UserFactory.partialUpdate();

        response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .patch(endpoint);
    }

    @Entao("o sistema deve retornar status 200 e um campo updatedAt no Patch")
    public void validaAtualizacaoComUpdatedAt() {
        response.then()
                .statusCode(200)
                .body("updatedAt", notNullValue());
    }
}
