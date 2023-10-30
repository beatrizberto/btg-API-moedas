package br.com.ada.btgfaztech.apimoedas.controlador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class  OrdemCompraRequest {
    private String     cpf;
    private String     tipoMoeda;
    private BigDecimal valorMoedaEstrangeira;
    private String     numeroAgenciaRetirada;
}
