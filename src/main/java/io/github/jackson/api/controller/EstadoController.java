package io.github.jackson.api.controller;

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

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    public Estado buscar(@PathVariable Long estadoId) {
       return cadastroEstadoService.buscarOuFalar(estadoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody @Valid Estado estado) {
        return estadoRepository.save(estado);
    }

    @PutMapping("/{estadoId}")
    public Estado atualizar(@PathVariable Long estadoId, @Valid
                            @RequestBody Estado estado) {
            Estado estadoAtual = cadastroEstadoService.buscarOuFalar(estadoId);

            BeanUtils.copyProperties(estado, estadoAtual,"id");

            return  cadastroEstadoService.salvar(estadoAtual);
    }

    @DeleteMapping("/{estadoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long estadoId) {
        cadastroEstadoService.excluir(estadoId);
    }
}
