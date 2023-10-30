package br.com.ada.btgfaztech.apimoedas.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OrdemCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
