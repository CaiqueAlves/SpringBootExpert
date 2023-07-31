package io.github.caique.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne// many é referente a entidade atual e one é referente a entidade que esta na variavel
    @JoinColumn(name = "cliente_id")//nome da varival estrangeira na tabela "Many"
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    //1000.00
    @Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

}
