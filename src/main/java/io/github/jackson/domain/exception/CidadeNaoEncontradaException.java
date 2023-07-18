package io.github.jackson.domain.exception;

public class CidadeNaoEncontradaException extends handleNaoEncontradaException {
    public CidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CidadeNaoEncontradaException(Long cidadeId) {
        this(String.format("Não existe um cadastro de cidade com codigo %d", cidadeId));
    }
}
