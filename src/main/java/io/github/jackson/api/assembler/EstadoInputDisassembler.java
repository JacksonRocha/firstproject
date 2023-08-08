package io.github.jackson.api.assembler;

import io.github.jackson.api.model.mixin.input.EstadoInput;
import io.github.jackson.api.model.mixin.input.RestauranteInput;
import io.github.jackson.domain.model.Cozinha;
import io.github.jackson.domain.model.Estado;
import io.github.jackson.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstadoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Estado toDomainObject(EstadoInput estadoInput) {
        return modelMapper.map(estadoInput, Estado.class);
    }

    public void copyToDomainObject(EstadoInput estadoInput, Estado estado) {
        modelMapper.map(estadoInput, estado);
    }
}
