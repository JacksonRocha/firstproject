package io.github.jackson.domain.repository;

import io.github.jackson.domain.model.Grupo;
import io.github.jackson.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository
        extends JpaRepository<Grupo,Long>, CustomJpaRepository<Grupo, Long> {
}
