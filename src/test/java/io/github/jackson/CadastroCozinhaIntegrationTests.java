package io.github.jackson;

import io.github.jackson.domain.model.Cozinha;
import io.github.jackson.domain.service.CadastroCozinhaService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CadastroCozinhaIntegrationTests {

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    @Test
    public void testarCadastroCozinhaComSucesso() {
        // cenário
        Cozinha novaCozinha = new Cozinha();
        novaCozinha.setNome("Chinesa");

        // ação
        novaCozinha =  cadastroCozinhaService.salvar(novaCozinha);

        // validação
        assertThat(novaCozinha).isNotNull();
        assertThat(novaCozinha.getId()).isNotNull();
    }


}
