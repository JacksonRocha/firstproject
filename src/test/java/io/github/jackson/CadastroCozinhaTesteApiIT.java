package io.github.jackson;

import io.github.jackson.domain.model.Cozinha;
import io.github.jackson.domain.repository.CozinhaRepository;
import io.github.jackson.util.DatabaseCleaner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroCozinhaTesteApiIT {

    @LocalServerPort
    private int port;

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @BeforeEach
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/cozinhas";

        databaseCleaner.clearTables();
        prepararDados();
    }
    @Test
    public void deveRetornarStatus200_QuandoConsultarCozinhas() {
        given()
                .accept(ContentType.JSON)
            .when()
                .get()
            .then()
                .statusCode(200);
    }

    @Test
    public void deveConter5Cozinhas_QuandoConsultarCozinhas() {
        given()
            .accept(ContentType.JSON)
        .when()
            .get()
        .then()
            .body("", hasSize(5));

    }

    @Test
    public void deveRetornarStatus201_QuandoCadastrarCozinha() {
        given()
            .body("{ \"nome\": \"Chinesa\" }")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
        .when()
            .post()
        .then()
            .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void deveRetornarRespostaEStatusCorretos_QuandoConsultarCozinhaExistente() {
        given()
             .pathParams("cozinhaId", 2)
             .accept(ContentType.JSON)
        .when()
             .get("/{cozinhaId}")
        .then()
             .statusCode(HttpStatus.OK.value())
             .body("nome", equalTo("Americana"));
    }

    @Test
    public void deveRetornarStatus404_QuandoConsultarCozinhaInexistente() {
        given()
                .pathParams("cozinhaId", 100)
                .accept(ContentType.JSON)
                .when()
                .get("/{cozinhaId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    private void prepararDados() {
        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Tailandesa");
        cozinhaRepository.save(cozinha1);

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Americana");
        cozinhaRepository.save(cozinha2);

        Cozinha cozinha3 = new Cozinha();
        cozinha3.setNome("Indiana");
        cozinhaRepository.save(cozinha3);

        Cozinha cozinha4 = new Cozinha();
        cozinha4.setNome("Brasileira");
        cozinhaRepository.save(cozinha4);

        Cozinha cozinha5 = new Cozinha();
        cozinha5.setNome("Chinesa");
        cozinhaRepository.save(cozinha5);
    }
}
