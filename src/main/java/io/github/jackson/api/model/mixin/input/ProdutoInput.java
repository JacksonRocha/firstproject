package io.github.jackson.api.model.mixin.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProdutoInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private BigDecimal preco;

    @NotBlank
    private Boolean ativo;
}
