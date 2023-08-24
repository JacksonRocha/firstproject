package io.github.jackson.api.assembler;

import io.github.jackson.api.model.mixin.input.CidadeInput;
import io.github.jackson.api.model.mixin.input.GrupoInput;
import io.github.jackson.domain.model.Cidade;
import io.github.jackson.domain.model.Estado;
import io.github.jackson.domain.model.Grupo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrupoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Grupo toDomainObject(GrupoInput grupoInput) {
        return modelMapper.map(grupoInput, Grupo.class);
    }

    public void copyToDomainObject(GrupoInput grupoInput, Grupo grupo) {
               modelMapper.map(grupoInput, grupo);
    }
}
