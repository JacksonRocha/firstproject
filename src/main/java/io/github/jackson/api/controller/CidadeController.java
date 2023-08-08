package io.github.jackson.api.controller;

import io.github.jackson.api.assembler.CidadeInputDisassembler;
import io.github.jackson.api.assembler.CidadeModelAssembler;
import io.github.jackson.api.model.CidadeModel;
import io.github.jackson.api.model.mixin.input.CidadeInput;
import io.github.jackson.domain.exception.EstadoNaoEncontradaException;
import io.github.jackson.domain.exception.NegocioException;
import io.github.jackson.domain.model.Cidade;
import io.github.jackson.domain.repository.CidadeRepository;
import io.github.jackson.domain.service.CadastroCidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroCidadeService cadastroCidadeService;

    @Autowired
    private CidadeModelAssembler cidadeModelAssembler;

    @Autowired
    private CidadeInputDisassembler cidadeInputDisassembler;


    @GetMapping
    public List<CidadeModel> listar() {
        List<Cidade> todasCidades = cidadeRepository.findAll();

        return cidadeModelAssembler.toCollectionModel(todasCidades);
    }

    @GetMapping("/{cidadeId}")
    public CidadeModel buscar(@PathVariable Long cidadeId) {
       Cidade cidade = cadastroCidadeService.buscarOuFalhar(cidadeId);

        return cidadeModelAssembler.toModel(cidade);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeModel adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
        try {
            Cidade cidade = cidadeInputDisassembler.toDomainObject(cidadeInput);

            cidade = cadastroCidadeService.salvar(cidade);

            return cidadeModelAssembler.toModel(cidade);
        } catch (EstadoNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @PutMapping("/{cidadeId}")
    public CidadeModel atualizar(@PathVariable Long cidadeId,
                            @RequestBody @Valid CidadeInput cidadeInput) {
                try {
                    Cidade cidadeAtual = cadastroCidadeService.buscarOuFalhar(cidadeId);

                    cidadeInputDisassembler.copyToDomainObject(cidadeInput, cidadeAtual);

                    cidadeAtual = cadastroCidadeService.salvar(cidadeAtual);

                    return cidadeModelAssembler.toModel(cidadeAtual);
                } catch (EstadoNaoEncontradaException e ) {
                    throw new NegocioException(e.getMessage(), e);
                }
    }

    @DeleteMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cidadeId) {
            cadastroCidadeService.excluir(cidadeId);
            }


}
