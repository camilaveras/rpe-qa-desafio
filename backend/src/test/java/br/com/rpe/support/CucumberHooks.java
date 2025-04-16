package br.com.rpe.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.mapper.ObjectMapperType;

public class CucumberHooks {

    @Before
    public void beforeScenario() {
        System.out.println("[HOOK] Iniciando cenário...");

        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.config = RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.JACKSON_2));
    }

    @After
    public void afterScenario() {
        System.out.println("[HOOK] Finalizando cenário...");
    }
}
