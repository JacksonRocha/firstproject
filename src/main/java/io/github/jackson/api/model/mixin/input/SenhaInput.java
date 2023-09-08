package io.github.jackson.api.model.mixin.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SenhaInput {

    @NotBlank
    private String senhaAtual;

    @NotBlank
    private String novaSenha;
}
