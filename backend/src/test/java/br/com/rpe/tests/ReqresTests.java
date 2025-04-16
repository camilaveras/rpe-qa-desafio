package br.com.rpe.tests;

import br.com.rpe.config.BaseTest;
import br.com.rpe.data.UserFactory;
import br.com.rpe.util.RTF;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import br.com.rpe.dto.UserDTO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReqresTests extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("GET /users?page=2")
    public void deveListarUsuarios() {
        RTF.log("GET", "Listando usuários da página 2");

        given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data", not(empty()));
    }

    @Test
    @Order(2)
    @DisplayName("POST /users")
    public void deveCriarUsuarioComSucesso() {
        RTF.log("POST", "Criando usuário");

        given()
                .contentType(ContentType.JSON)
                .body(UserFactory.validUser()) // ← aqui tá certo agora
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }


    @Test
    @Order(3)
    @DisplayName("PUT /users/2")
    public void deveAtualizarUsuario() {
        RTF.log("PUT", "Atualizando usuário");

        given()
                .contentType(ContentType.JSON)
                .body(UserFactory.updatedUser())
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .body("updatedAt", notNullValue());
    }

    @Test
    @Order(4)
    @DisplayName("PATCH /users/2")
    public void deveAtualizarParcialmenteUsuario() {
        RTF.log("PATCH", "Atualização parcial de usuário");

        given()
                .contentType(ContentType.JSON)
                .body(UserFactory.partialUpdate())
                .when()
                .patch("/users/2")
                .then()
                .statusCode(200)
                .body("updatedAt", notNullValue());
    }

    @Test
    @Order(5)
    @DisplayName("DELETE /users/2")
    public void deveDeletarUsuario() {
        RTF.log("DELETE", "Removendo usuário");

        when()
                .delete("/users/2")
                .then()
                .statusCode(204);
    }
}
