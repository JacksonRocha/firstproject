package io.github.jackson.api.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problema {

    private Integer status;
    private String type;
    private String title;
    private String detail;

}
