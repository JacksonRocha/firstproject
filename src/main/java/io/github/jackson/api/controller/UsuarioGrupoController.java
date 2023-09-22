package io.github.jackson.api.controller;

import io.github.jackson.api.assembler.GrupoModelAssembler;
import io.github.jackson.api.assembler.PermissaoModelAssembler;
import io.github.jackson.api.assembler.UsuarioModelAssembler;
import io.github.jackson.api.model.GrupoModel;
import io.github.jackson.api.model.PermissaoModel;
import io.github.jackson.domain.model.Grupo;
import io.github.jackson.domain.model.Usuario;
import io.github.jackson.domain.service.CadastroGrupoService;
import io.github.jackson.domain.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/{usuarioId}/grupos")
public class UsuarioGrupoController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Autowired
    private GrupoModelAssembler grupoModelAssembler;

    @GetMapping
    public List<GrupoModel> listar(@PathVariable Long usuarioId) {
        Usuario usuario = cadastroUsuarioService.buscarOuFalhar(usuarioId);

        return grupoModelAssembler.toCollectionModel(usuario.getGrupos());
    }

    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
        cadastroUsuarioService.desassocirGrupo(usuarioId, grupoId);
    }

    @PutMapping("/{permissaoId}")
    public void associar (@PathVariable Long usuarioId, @PathVariable Long grupoId) {
        cadastroUsuarioService.associarGrupo(usuarioId, grupoId);
    }

}
