package io.github.jackson.api.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.jackson.domain.model.Estado;

public abstract class CidadeMixin {

    @JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Estado estado;
}
