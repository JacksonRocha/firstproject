package io.github.jackson.api.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jackson.api.assembler.FormaPagamentoInputDisassembler;
import io.github.jackson.api.assembler.FormaPagamentoModelAssembler;
import io.github.jackson.api.assembler.RestauranteInputDisassembler;
import io.github.jackson.api.assembler.RestauranteModelAssembler;
import io.github.jackson.api.model.FormaPagamentoModel;
import io.github.jackson.api.model.RestauranteModel;
import io.github.jackson.api.model.mixin.input.RestauranteInput;
import io.github.jackson.domain.exception.CidadeNaoEncontradaException;
import io.github.jackson.domain.exception.CozinhaNaoEncontradaException;
import io.github.jackson.domain.exception.NegocioException;
import io.github.jackson.domain.exception.RestauranteNaoEncontradaException;
import io.github.jackson.domain.model.FormaPagamento;
import io.github.jackson.domain.model.Restaurante;
import io.github.jackson.domain.repository.RestauranteRepository;
import io.github.jackson.domain.service.CadastroRestauranteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/restaurantes/{restauranteId}/formas-pagamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestauranteFormaPagamentoController {


    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @Autowired
    private FormaPagamentoModelAssembler formaPagamentoModelAssembler;

    @Autowired
    private FormaPagamentoInputDisassembler formaPagamentoInputDisassembler;

 }
