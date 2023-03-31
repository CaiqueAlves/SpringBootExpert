package io.github.caique.domain.repsitorio;

import io.github.caique.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Clientes extends JpaRepository <Cliente, Integer>{

    List<Cliente> findByNomeLike(String nome);
}
