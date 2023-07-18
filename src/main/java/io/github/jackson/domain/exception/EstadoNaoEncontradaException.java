package io.github.jackson.domain.exception;

public class EstadoNaoEncontradaException extends handleNaoEncontradaException {
    public EstadoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public EstadoNaoEncontradaException (Long estadoId) {
        this(String.format("Não existe um cadastro de estado com codigo %d", estadoId));
    }
}
