package br.com.ada.btgfaztech.apimoedas.controlador.dto;

import br.com.ada.btgfaztech.apimoedas.modelo.CotacaoMoeda;
import br.com.ada.btgfaztech.apimoedas.servico.CotacaoMoedaServico;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ApiCotacaoResponse {
    private CotacaoMoeda USDBRL;
    private CotacaoMoeda EURBRL;
}
