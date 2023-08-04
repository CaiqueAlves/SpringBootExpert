package io.github.caique.service;

import io.github.caique.domain.entity.Pedido;
import io.github.caique.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);
}
