package io.github.jackson.api.assembler;

import io.github.jackson.api.model.mixin.input.CidadeInput;
import io.github.jackson.api.model.mixin.input.EstadoInput;
import io.github.jackson.domain.model.Cidade;
import io.github.jackson.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cidade toDomainObject(CidadeInput cidadeInput) {
        return modelMapper.map(cidadeInput, Cidade.class);
    }

    public void copyToDomainObject(CidadeInput cidadeInput, Cidade cidade) {
        cidade.setEstado(new Estado());

        modelMapper.map(cidadeInput, cidade);
    }
}
