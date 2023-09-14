package io.github.jackson.api.assembler;

import io.github.jackson.api.model.mixin.input.GrupoInput;
import io.github.jackson.api.model.mixin.input.ProdutoInput;
import io.github.jackson.domain.model.Grupo;
import io.github.jackson.domain.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Produto toDomainObject(ProdutoInput produtoInput) {
        return modelMapper.map(produtoInput, Produto.class);
    }

    public void copyToDomainObject(ProdutoInput produtoInput, Produto produto) {
               modelMapper.map(produtoInput, produto);
    }
}
