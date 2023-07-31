package io.github.caique.service.impl;

import io.github.caique.domain.repository.Pedidos;
import io.github.caique.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
