package io.github.jackson.domain.repository;

import io.github.jackson.domain.model.Estado;
import io.github.jackson.domain.model.Usuario;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long>, CustomJpaRepository<Estado, Long> {
}
