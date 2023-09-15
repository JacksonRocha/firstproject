package io.github.jackson.api.controller;

import io.github.jackson.api.assembler.ProdutoInputDisassembler;
import io.github.jackson.api.assembler.ProdutoModelAssembler;
import io.github.jackson.api.model.GrupoModel;
import io.github.jackson.api.model.ProdutoModel;
import io.github.jackson.api.model.mixin.input.GrupoInput;
import io.github.jackson.api.model.mixin.input.ProdutoInput;
import io.github.jackson.domain.model.Grupo;
import io.github.jackson.domain.model.Produto;
import io.github.jackson.domain.model.Restaurante;
import io.github.jackson.domain.repository.ProdutoRepository;
import io.github.jackson.domain.service.CadastroRestauranteService;
import io.github.jackson.domain.service.CadastroProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @Autowired
    private ProdutoModelAssembler produtoModelAssembler;

    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @Autowired
    private ProdutoInputDisassembler produtoInputDisassembler;

    @GetMapping
    public List<ProdutoModel> listar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestauranteService.buscarOuFalhar(restauranteId);

        List<Produto> todosProdutos = produtoRepository.findByRestaurante(restaurante);

        return produtoModelAssembler.toCollectionModel(todosProdutos);
    }

    @GetMapping("/{produtoId}")
    public ProdutoModel buscar(@PathVariable Long restauranteId, @PathVariable Long produtoId) {
        Produto produto = cadastroProdutoService.buscarOuFalhar(restauranteId, produtoId);

        return produtoModelAssembler.toModel(produto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel adicionar(@PathVariable Long restauranteId,
                                  @RequestBody @Valid ProdutoInput produtoInput) {
        Restaurante restaurante = cadastroRestauranteService.buscarOuFalhar(restauranteId);

        Produto produto = produtoInputDisassembler.toDomainObject(produtoInput);
        produto.setRestaurante(restaurante);

        produto = cadastroProdutoService.salvar(produto);

        return produtoModelAssembler.toModel(produto);
    }

    @PutMapping("/{produtoId}")
    public ProdutoModel atualizar(@PathVariable Long restauranteId, @PathVariable Long produtoId,
           @RequestBody @Valid ProdutoInput produtoInput) {
        Produto produtoAtual = cadastroProdutoService.buscarOuFalhar(restauranteId, produtoId);

        produtoInputDisassembler.copyToDomainObject(produtoInput, produtoAtual);

        produtoAtual = cadastroProdutoService.salvar(produtoAtual);

        return produtoModelAssembler.toModel(produtoAtual);
    }
}
