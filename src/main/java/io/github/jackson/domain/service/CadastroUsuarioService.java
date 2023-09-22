package io.github.jackson.domain.service;

import io.github.jackson.domain.exception.GrupoNaoEncontradaException;
import io.github.jackson.domain.exception.NegocioException;
import io.github.jackson.domain.model.Grupo;
import io.github.jackson.domain.model.Usuario;
import io.github.jackson.domain.repository.CozinhaRepository;
import io.github.jackson.domain.repository.RestauranteRepository;
import io.github.jackson.domain.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CadastroUsuarioService {

    public static final String MSG_SENHA_USUARIO = "Senha atual informada não coincide com a senha de usuário.";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastroGrupoService cadastroGrupoService;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        usuarioRepository.detach(usuario);

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
            throw new NegocioException(String.format("Já existe um usuário cadastrado com o e-mail %s", usuario.getEmail()));
        }


        return usuarioRepository.save(usuario);
    }


    @Transactional
    public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
        Usuario usuario = buscarOuFalhar(usuarioId);

        if (usuario.senhaNaoCoincideCom(senhaAtual)) {
            throw new NegocioException(MSG_SENHA_USUARIO);
        }

        usuario.setSenha(novaSenha);
    }

    public Usuario buscarOuFalhar(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new GrupoNaoEncontradaException(usuarioId));
    }

    @Transactional
    public void desassocirGrupo(Long usuarioId, Long grupoId) {
        Usuario usuario = buscarOuFalhar(usuarioId);
        Grupo grupo = cadastroGrupoService.buscarOuFalhar(grupoId);

        usuario.removerGrupo(grupo);
    }

    @Transactional
    public void associarGrupo(Long usuarioId, Long grupoId) {
        Usuario usuario = buscarOuFalhar(usuarioId);
        Grupo grupo = cadastroGrupoService.buscarOuFalhar(grupoId);

        usuario.adicionarGrupo(grupo);
    }

}
