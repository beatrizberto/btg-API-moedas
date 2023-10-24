package br.com.ada.btgfaztech.apimoedas.utils;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.ApiCotacaoResponse;
import br.com.ada.btgfaztech.apimoedas.controlador.dto.OrdemCompraResponse;

public class ApiCotacaoConversor {
    public static OrdemCompraResponse toOrdemCompraResponse(ApiCotacaoResponse apiCotacaoResponse)
    {
        OrdemCompraResponse ordemCompraResponse = new OrdemCompraResponse();
//        ordemCompraResponse.setTipoMoeda(apiCotacaoResponse.getCode());
//        ordemCompraResponse.setValorCotacao(apiCotacaoResponse.getAsk());
//
        return ordemCompraResponse;
    }
}




