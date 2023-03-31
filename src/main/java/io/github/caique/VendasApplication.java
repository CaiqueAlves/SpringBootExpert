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
            clientes.save(new Cliente("Caique"));
            clientes.save(new Cliente("Dougllas"));

            boolean existe = clientes.existsByNome("Caique");
            System.out.println("existe um cliente com o nome caique? " + existe);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
