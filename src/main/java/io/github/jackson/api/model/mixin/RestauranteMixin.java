package io.github.jackson.api.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.jackson.domain.model.Cozinha;
import io.github.jackson.domain.model.Endereco;
import io.github.jackson.domain.model.FormaPagamento;
import io.github.jackson.domain.model.Produto;

import java.time.LocalDateTime;
import java.util.List;

public abstract class RestauranteMixin {

    @JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Cozinha cozinha;

    @JsonIgnore
    private Endereco endereco;

    @JsonIgnore
    private LocalDateTime dataCadastro;

    @JsonIgnore
    private LocalDateTime dataAtualizacao;

    @JsonIgnore
    private List<FormaPagamento> formasPagamento;

    @JsonIgnore
    private List<Produto> produtos;
}
