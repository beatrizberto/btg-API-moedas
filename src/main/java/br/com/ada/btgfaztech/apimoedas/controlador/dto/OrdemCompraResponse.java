package br.com.ada.btgfaztech.apimoedas.controlador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdemCompraResponse {
    private Integer       idCompra;
    private Integer       idCliente;
    private String        cpfCliente;
    private LocalDateTime dataSolicitacao;
    private String        tipoMoeda;
    private BigDecimal    valorMoedaEstrangeira;
    private BigDecimal    valorCotacao;
    private BigDecimal    valorTotalOperacao;
    private String        numeroAgenciaRetirada;
}
