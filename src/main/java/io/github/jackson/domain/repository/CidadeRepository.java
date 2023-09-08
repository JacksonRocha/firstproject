package io.github.jackson.domain.repository;


import io.github.jackson.domain.model.Cidade;
import io.github.jackson.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>, CustomJpaRepository<Cidade, Long> {
}
