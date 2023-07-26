package io.github.jackson.api.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.jackson.domain.model.Restaurante;

import java.util.List;

public abstract class CozinhaMixin {

    @JsonIgnore
    private List<Restaurante> restaurantes;
}
