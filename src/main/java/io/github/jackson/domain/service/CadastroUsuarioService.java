package io.github.jackson.domain.service;

import io.github.jackson.domain.exception.GrupoNaoEncontradaException;
import io.github.jackson.domain.exception.NegocioException;
import io.github.jackson.domain.model.Usuario;
import io.github.jackson.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroUsuarioService {

    public static final String MSG_SENHA_USUARIO = "Senha atual informada não coincide com a senha de usuário.";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
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
}
