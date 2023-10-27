package br.com.ada.btgfaztech.apimoedas.utils;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.OrdemCompraRequest;
import br.com.ada.btgfaztech.apimoedas.controlador.dto.OrdemCompraResponse;
import br.com.ada.btgfaztech.apimoedas.modelo.Cliente;
import br.com.ada.btgfaztech.apimoedas.modelo.OrdemCompra;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrdemCompraConversor {
    public static OrdemCompra toEntity(OrdemCompraRequest ordemCompraRequest, BigDecimal valorCotacao, BigDecimal valorTotal, Cliente cliente)
    {
        OrdemCompra ordemCompra = new OrdemCompra();
        ordemCompra.setCliente(cliente);
        ordemCompra.setDataSolicitacao(LocalDateTime.now());
        ordemCompra.setTipoMoeda(ordemCompraRequest.getTipoMoeda());
        ordemCompra.setValorMoedaEstrangeira(ordemCompraRequest.getValorMoedaEstrangeira());
        ordemCompra.setValorCotacao(valorCotacao);
        ordemCompra.setValorTotalOperacao(valorTotal);
        ordemCompra.setNumeroAgenciaRetirada(ordemCompraRequest.getNumeroAgenciaRetirada());

        return ordemCompra;
    }


    public static OrdemCompraResponse toResponse(OrdemCompra ordemCompra) {
        Cliente cliente = ordemCompra.getCliente();
        OrdemCompraResponse ordemCompraResponse = new OrdemCompraResponse();
        ordemCompraResponse.setIdCompra(ordemCompra.getId());
        ordemCompraResponse.setIdCliente(cliente.getId());
        ordemCompraResponse.setCpfCliente(cliente.getCpf());
        ordemCompraResponse.setDataSolicitacao(ordemCompra.getDataSolicitacao());
        ordemCompraResponse.setTipoMoeda(ordemCompra.getTipoMoeda());
        ordemCompraResponse.setValorMoedaEstrangeira(ordemCompra.getValorMoedaEstrangeira());
        ordemCompraResponse.setValorCotacao(ordemCompra.getValorCotacao());
        ordemCompraResponse.setValorTotalOperacao(ordemCompra.getValorTotalOperacao());
        ordemCompraResponse.setNumeroAgenciaRetirada(ordemCompra.getNumeroAgenciaRetirada());

        return ordemCompraResponse;
    }
}




