package io.github.jackson.api.model.mixin.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoInput {

    @NotNull
    private String nome;
}
