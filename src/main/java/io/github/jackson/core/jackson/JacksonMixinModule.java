package io.github.jackson.core.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import io.github.jackson.api.model.mixin.CidadeMixin;
import io.github.jackson.api.model.mixin.CozinhaMixin;
import io.github.jackson.api.model.mixin.RestauranteMixin;
import io.github.jackson.domain.model.Cidade;
import io.github.jackson.domain.model.Cozinha;
import io.github.jackson.domain.model.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }

}
