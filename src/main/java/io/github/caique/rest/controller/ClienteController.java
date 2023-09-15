package io.github.caique.rest.controller;

import io.github.caique.domain.entity.Cliente;
import io.github.caique.domain.repository.Clientes;
import io.swagger.annotations.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Api("Api Clientes")
public class ClienteController {

    private Clientes Repository;
    public ClienteController(Clientes Repository){
        this.Repository = Repository;
    }

    @GetMapping("{id}")
    @ApiOperation("Obter detalhes de um cliente")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cliente encontrado"),
            @ApiResponse(code = 404, message = "Cliente não encontrado para o ID informado")
    })
    public Cliente getClienteById(@PathVariable @ApiParam("Id do cliente") Integer id) {
       return Repository
               .findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                       "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Salva um novo cliente")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Cliente salvo com sucesso"),
            @ApiResponse(code = 400, message = "Erro de validação")
    })
    public Cliente save(@RequestBody @Valid Cliente cliente){
        return Repository.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
            Repository.findById(id)
                    .map(cliente -> {
                        Repository.delete(cliente);
                        return cliente;
                    })
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Cliente não encontrado"));


    }

    @PutMapping("{id}")
    public void update (@PathVariable Integer id, @RequestBody @Valid Cliente cliente){
         Repository.
                findById(id)
                .map(clienteExistente -> {
                     cliente.setId(clienteExistente.getId());
                    Repository.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Cliente não encontrado"));
    }

    @GetMapping
    public List <Cliente> find( Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher.
                                matching().
                                withIgnoreCase().
                                withStringMatcher(
                                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = Repository.findAll(example);
        return Repository.findAll(example);
    }
}
