package io.github.jackson.api.model.mixin.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInput {

    @NotNull
    private String nome;

    @Valid
    @NotNull
    private EstadoInput estado;
}
