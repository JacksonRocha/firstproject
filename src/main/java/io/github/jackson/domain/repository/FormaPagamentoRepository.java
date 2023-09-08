package io.github.jackson.domain.repository;

import io.github.jackson.domain.model.FormaPagamento;
import io.github.jackson.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>, CustomJpaRepository<FormaPagamento, Long> {
}
