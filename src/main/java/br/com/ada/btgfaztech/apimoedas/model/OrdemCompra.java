package br.com.ada.btgfaztech.apimoedas.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OrdemCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //muitas ordens de compra pertencem a um cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    private LocalDateTime dataSolicitacao;
    private String tipoMoeda;
    private BigDecimal valorMoedaEstrangeira;
    private BigDecimal valorCotacao;
    private BigDecimal valorTotalOperacao;
    private String numeroAgenciaRetirada;

}
