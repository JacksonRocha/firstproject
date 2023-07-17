package io.github.jackson.api.exceptionhandler;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Problem {

    private LocalDateTime dataHora;
    private String mensagem;

}
