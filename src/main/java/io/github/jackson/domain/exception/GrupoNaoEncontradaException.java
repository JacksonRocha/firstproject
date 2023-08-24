package io.github.jackson.domain.exception;

public class GrupoNaoEncontradaException extends EntidadeNaoEncontradaException {

    public GrupoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public GrupoNaoEncontradaException(Long estadoId) {
        this(String.format("Não existe um cadastro de forma de grupo com código %d", estadoId));
    }
}
