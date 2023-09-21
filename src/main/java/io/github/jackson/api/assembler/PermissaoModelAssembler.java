package io.github.jackson.api.assembler;

import io.github.jackson.api.model.FormaPagamentoModel;
import io.github.jackson.api.model.PermissaoModel;
import io.github.jackson.domain.model.FormaPagamento;
import io.github.jackson.domain.model.Permissao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissaoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PermissaoModel toModel(Permissao permissao) {
      return modelMapper.map(permissao, PermissaoModel.class);
    }

    public List<PermissaoModel> toCollectionModel(Collection<Permissao> permissaos){
        return permissaos.stream()
                .map(permissao -> toModel(permissao))
                .collect(Collectors.toList());
    }
}
