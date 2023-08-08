package io.github.jackson.api.assembler;

import io.github.jackson.api.model.mixin.input.CidadeInput;
import io.github.jackson.api.model.mixin.input.CozinhaIdInput;
import io.github.jackson.api.model.mixin.input.CozinhaInput;
import io.github.jackson.domain.model.Cidade;
import io.github.jackson.domain.model.Cozinha;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CozinhaInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cozinha toDomainObject(CozinhaIdInput cozinhaIdInput) {
        return modelMapper.map(cozinhaIdInput, Cozinha.class);
    }

    public void copyToDomainObject(CozinhaInput cozinhaInput, Cozinha cozinha) {
        modelMapper.map(cozinhaInput, cozinha);
    }
}
