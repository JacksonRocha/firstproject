package io.github.jackson.domain.exception;

public class CozinhaNaoEncontradaException extends handleEntidadeNaoEncontradaException {
    public CozinhaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CozinhaNaoEncontradaException(Long cozinhaId) {
        this(String.format("Não existe um cadastro de cozinha com codigo %d", cozinhaId));
    }
}
