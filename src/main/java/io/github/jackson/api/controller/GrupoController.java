package io.github.jackson.api.controller;

import io.github.jackson.api.assembler.GrupoInputDisassembler;
import io.github.jackson.api.assembler.GrupoModelAssembler;
import io.github.jackson.domain.repository.GrupoRepository;
import io.github.jackson.domain.service.CadastroGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private CadastroGrupoService cadastroGrupoService;

    @Autowired
    private GrupoModelAssembler grupoModelAssembler;

    @Autowired
    private GrupoInputDisassembler grupoInputDisassembler;


}
