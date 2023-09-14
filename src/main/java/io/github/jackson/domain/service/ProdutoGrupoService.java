package io.github.jackson.domain.service;

import io.github.jackson.domain.exception.EntidadeEmUsoException;
import io.github.jackson.domain.exception.GrupoNaoEncontradaException;
import io.github.jackson.domain.exception.ProdutoNaoEncontradoException;
import io.github.jackson.domain.model.Grupo;
import io.github.jackson.domain.model.Produto;
import io.github.jackson.domain.repository.GrupoRepository;
import io.github.jackson.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoGrupoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarOuFalhar(Long restauranteId, Long produtoId) {
        return produtoRepository.findById(restauranteId, produtoId)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(restauranteId, produtoId));
    }
}
