package io.github.caique;

import io.github.caique.domain.entity.Cliente;
import io.github.caique.domain.entity.Pedido;
import io.github.caique.domain.entity.Produto;
import io.github.caique.domain.repository.Clientes;
import io.github.caique.domain.repository.Pedidos;
import io.github.caique.domain.repository.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

   /* @Bean
    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes, @Autowired Produtos produtos){
        return args ->{
          Cliente c = new Cliente(null, "fulano");
          clientes.save(c);
          Produto p = new Produto(null, "Fone de ouvido", 205.5);
          produtos.save(p);
        };
    }*/

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
