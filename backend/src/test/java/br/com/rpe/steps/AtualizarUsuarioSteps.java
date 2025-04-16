package br.com.rpe.steps;

import br.com.rpe.data.UserFactory;
import br.com.rpe.dto.User;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AtualizarUsuarioSteps {

    private Response response;

    @Dado("que desejo atualizar um usuario")
    public void desejoAtualizarUsuario() {

    }

    @Quando("eu envio uma requisicao PUT para {string}")
    public void envioPut(String endpoint) {
        User user = UserFactory.fullUpdate();

        response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .put(endpoint);
    }

    @Entao("o sistema deve retornar status 200 e um campo updatedAt no PUT")
    public void validaAtualizacaoComUpdatedAt() {
        response.then()
                .statusCode(200)
                .body("updatedAt", notNullValue());
    }
}