package io.github.jackson.domain.exception;

public abstract class handleNaoEncontradaException extends NegocioException {
    public handleNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
