package io.github.caique.rest.controller;

import io.github.caique.domain.entity.Cliente;
import io.github.caique.domain.entity.Pedido;

import io.github.caique.domain.entity.Produto;
import io.github.caique.domain.repository.Produtos;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    private Produtos produtos;
    public ProdutosController(Produtos produtos){
        this.produtos = produtos;
    }

    @GetMapping("{id}")
    public Produto getPedidoById(@PathVariable Integer id){
        return produtos
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Produtos não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save(@RequestBody Produto produto){
        return produtos.save(produto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        produtos.findById(id)
                .map(produto -> {
                    produtos.delete(produto);
                    return produto;
                });
    }

    @PutMapping("{id}")
    public void update (@PathVariable Integer id, @RequestBody Produto produto){
        produtos.findById(id)
                .map(produtoExistente -> {
                    produto.setId(produtoExistente.getId());
                    produtos.save(produto);
                    return produtoExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Produto não encontrado"));
    }

    @GetMapping
    public List<Produto> find(Produto filtro){
        ExampleMatcher matcher = ExampleMatcher
                                    .matching().
                                    withIgnoreCase().
                                    withStringMatcher(
                                            ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Produto> lista = produtos.findAll(example);
        return produtos.findAll(example);
    }
}
