package io.github.jackson.domain.exception;

public class NegocioException extends RuntimeException {
    public NegocioException(String mensagem) {
        super(mensagem);
    }

    public NegocioException (String mensagem, Throwable cause) {
        super (mensagem, cause);
    }
}
