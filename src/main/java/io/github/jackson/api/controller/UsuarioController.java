package io.github.jackson.api.controller;

import io.github.jackson.api.assembler.GrupoInputDisassembler;
import io.github.jackson.api.assembler.GrupoModelAssembler;
import io.github.jackson.api.assembler.UsuarioInputDisassembler;
import io.github.jackson.api.assembler.UsuarioModelAssembler;
import io.github.jackson.api.model.GrupoModel;
import io.github.jackson.api.model.UsuarioModel;
import io.github.jackson.api.model.mixin.input.GrupoInput;
import io.github.jackson.api.model.mixin.input.SenhaInput;
import io.github.jackson.api.model.mixin.input.UsuarioComSenhaInput;
import io.github.jackson.api.model.mixin.input.UsuarioInput;
import io.github.jackson.domain.model.Grupo;
import io.github.jackson.domain.model.Usuario;
import io.github.jackson.domain.repository.GrupoRepository;
import io.github.jackson.domain.repository.UsuarioRepository;
import io.github.jackson.domain.service.CadastroGrupoService;
import io.github.jackson.domain.service.CadastroUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;

    @Autowired
    private UsuarioInputDisassembler usuarioInputDisassembler;

    @GetMapping
    public List<UsuarioModel> listar() {
        List<Usuario> todosUsuarios = usuarioRepository.findAll();

        return usuarioModelAssembler.toCollectionModel(todosUsuarios);
    }

    @GetMapping("/{usuarioId}")
    public UsuarioModel buscar(@PathVariable Long usuarioId) {
        Usuario usuario = cadastroUsuarioService.buscarOuFalhar(usuarioId);

        return usuarioModelAssembler.toModel(usuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioComSenhaInput) {
        Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioComSenhaInput);

        usuario = cadastroUsuarioService.salvar(usuario);

        return usuarioModelAssembler.toModel(usuario);
    }

    @PutMapping("/{usuarioId}")
    public UsuarioModel atualizar(@PathVariable Long usuarioId,
           @RequestBody @Valid UsuarioInput usuarioInput) {
        Usuario usuarilAtual = cadastroUsuarioService.buscarOuFalhar(usuarioId);

        usuarioInputDisassembler.copyToDomainObject(usuarioInput, usuarilAtual);

        usuarilAtual = cadastroUsuarioService.salvar(usuarilAtual);

        return usuarioModelAssembler.toModel(usuarilAtual);
    }

    @DeleteMapping("/{usuarioId}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarSenha(@PathVariable Long usuarioId, @RequestBody @Valid
                             SenhaInput senhaInput) {

        cadastroUsuarioService.alterarSenha(usuarioId, senhaInput.getSenhaAtual(), senhaInput.getNovaSenha());
    }
}
