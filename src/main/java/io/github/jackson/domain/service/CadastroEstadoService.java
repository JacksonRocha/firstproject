package io.github.jackson.domain.service;

import io.github.jackson.domain.exception.EntidadeEmUsoException;
import io.github.jackson.domain.exception.EstadoNaoEncontradaException;
import io.github.jackson.domain.model.Estado;
import io.github.jackson.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroEstadoService {

    public static final String MSG_ESTADO_EM_USO
            = "Estado de codigo %d nãp pode ser removida, pois esta em uso";

    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Transactional
    public void excluir(Long estadoId) {
        try {
            estadoRepository.deleteById(estadoId);
            estadoRepository.flush();

        }catch (EmptyResultDataAccessException e) {
           throw new EstadoNaoEncontradaException(estadoId);

        }catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_ESTADO_EM_USO, estadoId));
        }
    }
    public Estado buscarOuFalar (Long estadoId) {
        return estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EstadoNaoEncontradaException(estadoId));
    }
}
