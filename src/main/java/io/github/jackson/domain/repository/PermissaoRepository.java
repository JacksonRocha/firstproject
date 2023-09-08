package io.github.jackson.domain.repository;

import io.github.jackson.domain.model.Permissao;
import io.github.jackson.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>, CustomJpaRepository<Permissao, Long> {
}
