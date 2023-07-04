package io.github.jackson.domain.service;

import io.github.jackson.domain.exception.EntidadeEmUsoException;
import io.github.jackson.domain.exception.EntidadeNaoEncontradaException;
import io.github.jackson.domain.model.Cozinha;
import io.github.jackson.domain.model.Restaurante;
import io.github.jackson.domain.repository.CozinhaRepository;
import io.github.jackson.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de cozinha %d", cozinhaId)));

        restaurante.setCozinha(cozinha);
         return restauranteRepository.save(restaurante);
    }

    public void excluir(Long restauranteId) {
        try {
            restauranteRepository.deleteById(restauranteId);
        }catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de restaurante com codigo %d", restauranteId));
        }catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Restauramte de código %d não pode ser removida, pois esta em uso", restauranteId));
        }
    }
}


