package io.github.jackson.domain.service;

import io.github.jackson.domain.exception.EntidadeEmUsoException;
import io.github.jackson.domain.exception.EntidadeNaoEncontradaException;
import io.github.jackson.domain.model.Cidade;
import io.github.jackson.domain.model.Estado;
import io.github.jackson.domain.repository.CidadeRepository;
import io.github.jackson.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();

        Estado estado = estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de estado com codigo %d", estadoId)));

        cidade.setEstado(estado);

        return cidadeRepository.save(cidade);
    }

    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.deleteById(cidadeId);

        }catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cidade com codiog %d", cidadeId));

        }catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de codigo %d não pode ser removida, pois esta em uso", cidadeId));
        }
    }
}
