package io.github.jackson.domain.repository;

import io.github.jackson.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>, CustomJpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
