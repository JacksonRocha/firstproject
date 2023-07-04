package io.github.jackson.infrastructure.repository;

import io.github.jackson.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteRepositoryQueries {
    List<Restaurante> find(String nome,
                           BigDecimal taxaFreteInicial,
                           BigDecimal taxaFreteFinal);

    List<Restaurante> findComFreteGratis(String nome);
}
