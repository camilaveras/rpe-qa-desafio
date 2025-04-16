package br.com.rpe.steps;

import br.com.rpe.data.UserFactory;
import br.com.rpe.dto.User;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class CriarUsuarioSteps {

    private Response response;

    @Dado("que desejo criar um novo usuario")
    public void queDesejoCriarUmNovoUsuario() {

    }

    @Quando("eu envio uma requisicao POST para {string}")
    public void envioRequisicaoPost(String endpoint) {
        User user = UserFactory.validUser();

        response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post(endpoint);
    }

    @Entao("o sistema deve retornar status 201 e um ID criado")
    public void deveRetornar201() {
        response.then()
                .statusCode(201)
                .body("id", notNullValue());
    }
}
