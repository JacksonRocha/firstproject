package io.github.jackson.domain.repository;

import io.github.jackson.domain.model.FormaPagamento;
import io.github.jackson.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>, CustomJpaRepository<FormaPagamento, Long> {
}
