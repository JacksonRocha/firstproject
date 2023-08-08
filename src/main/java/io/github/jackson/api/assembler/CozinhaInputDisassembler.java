package io.github.jackson.api.assembler;

import io.github.jackson.api.model.mixin.input.CozinhaInput;
import io.github.jackson.domain.model.Cozinha;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CozinhaInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cozinha toDomainObject(@Valid CozinhaInput cozinhaIdInput) {
        return modelMapper.map(cozinhaIdInput, Cozinha.class);
    }

    public void copyToDomainObject(CozinhaInput cozinhaInput, Cozinha cozinha) {
        modelMapper.map(cozinhaInput, cozinha);
    }
}
