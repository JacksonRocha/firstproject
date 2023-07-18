package io.github.jackson.domain.exception;

public class RestauranteNaoEncontradaException extends EntidadeNaoEncontradaException {
    public RestauranteNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public RestauranteNaoEncontradaException(Long restauranteId) {
        this(String.format("Não existe um cadastro de restaurante com codigo %d", restauranteId));
    }
}
