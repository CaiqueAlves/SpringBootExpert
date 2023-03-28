package io.github.caique.service;

import io.github.caique.model.Cliente;
import io.github.caique.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientesService {
    //injeção de dependencia: controle externo, classe, configuração via arquivo
    @Autowired
    private ClientesRepository repository;

    public ClientesService(ClientesRepository repository){
        this.repository = repository;
    }
    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);//aqui esta delegada a classe clienteRepository a função de persistir
    }
    public void validarCliente(Cliente cliente){
        //aplica validações
    }
}
