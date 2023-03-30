package io.github.caique;

import io.github.caique.domain.entity.Cliente;
import io.github.caique.domain.repsitorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {

            System.out.println("SALVANDO CLIENTES");
            clientes.salvar(new Cliente("Caique"));
            clientes.salvar(new Cliente("Dougllas"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

           /* System.out.println("ATUALIZANDO CLIENTES");
            todosClientes.forEach(c ->{
                c.setNome(c.getNome() + " atualizado.");
                clientes.atualizar(c);
            });

            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("--BUSCANDO CLIENTES--");
            clientes.buscarPorNome("Cai").forEach(System.out::println);
            System.out.println("--BUSCANDO CLIENTES--");


            /*System.out.println("DELETANDO CLIENTES");
            clientes.obterTodos().forEach(c->{
                clientes.deletar(c);
            });

            todosClientes = clientes.obterTodos();
            if(todosClientes.isEmpty()){
                System.out.println("NENHUM CLIENTE ENCONTRADO");
            }else {
                todosClientes.forEach(System.out::println);
            }*/
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
