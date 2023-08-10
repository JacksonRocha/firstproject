package io.github.jackson.api.controller;

import io.github.jackson.api.assembler.EstadoInputDisassembler;
import io.github.jackson.api.assembler.EstadoModelAssembler;
import io.github.jackson.api.model.EstadoModel;
import io.github.jackson.api.model.mixin.input.EstadoInput;
import io.github.jackson.domain.model.Estado;
import io.github.jackson.domain.repository.EstadoRepository;
import io.github.jackson.domain.service.CadastroEstadoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService cadastroEstadoService;

    @Autowired
    private EstadoModelAssembler estadoModelAssembler;

    @Autowired
    private EstadoInputDisassembler estadoInputDisassembler;

    @GetMapping
    public List<EstadoModel> listar() {
        List<Estado> todosEstados = estadoRepository.findAll();

        return estadoModelAssembler.toCollectionModel(todosEstados);
    }

    @GetMapping("/{estadoId}")
    public EstadoModel buscar(@PathVariable Long estadoId) {
        Estado estado = cadastroEstadoService.buscarOuFalar(estadoId);

       return estadoModelAssembler.toModel(estado);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoModel adicionar(@RequestBody @Valid EstadoInput estadoInput) {
        Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);

        estado = cadastroEstadoService.salvar(estado);

        return estadoModelAssembler.toModel(estado);
    }

    @PutMapping("/{estadoId}")
    public EstadoModel atualizar(@PathVariable Long estadoId,
                            @RequestBody @Valid EstadoInput estadoInput) {
            Estado estadoAtual = cadastroEstadoService.buscarOuFalar(estadoId);

            estadoInputDisassembler.copyToDomainObject(estadoInput, estadoAtual);

            estadoAtual = cadastroEstadoService.salvar(estadoAtual);

            return  estadoModelAssembler.toModel(estadoAtual);
    }

    @DeleteMapping("/{estadoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long estadoId) {
        cadastroEstadoService.excluir(estadoId);
    }
}
