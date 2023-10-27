package br.com.ada.btgfaztech.apimoedas.servico;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.OrdemCompraRequest;
import br.com.ada.btgfaztech.apimoedas.controlador.dto.OrdemCompraResponse;
import br.com.ada.btgfaztech.apimoedas.controlador.exception.ValidaMoedaErro;
import br.com.ada.btgfaztech.apimoedas.modelo.Cliente;
import br.com.ada.btgfaztech.apimoedas.modelo.CotacaoMoeda;
import br.com.ada.btgfaztech.apimoedas.modelo.OrdemCompra;
import br.com.ada.btgfaztech.apimoedas.repositorio.IClienteRepositorio;
import br.com.ada.btgfaztech.apimoedas.repositorio.IOrdemCompraRepositorio;
import br.com.ada.btgfaztech.apimoedas.utils.ClienteConversor;
import br.com.ada.btgfaztech.apimoedas.utils.OrdemCompraConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Service
public class OrdemCompraServico {

    //precisa da classe cotação de moeda
    @Autowired
    private IClienteRepositorio clienteRepositorio;
    @Autowired
    private IOrdemCompraRepositorio ordemCompraRepositorio;

    @Autowired
    private CotacaoMoedaServico cotacaoMoedaServico;


    public OrdemCompraResponse criarOrdemCompra(OrdemCompraRequest ordemCompraRequest) {
        //buscando cotacao
        String moeda = ordemCompraRequest.getTipoMoeda();
        CotacaoMoeda cotacao = cotacaoMoedaServico.obterCotacaoMoeda(moeda);
        if(cotacao == null) {
            throw new ValidaMoedaErro(moeda);
        }

        BigDecimal valorCotacao = cotacao.getAsk();

        //calculo valor total
        BigDecimal valorTotal = valorCotacao.multiply(ordemCompraRequest.getValorMoedaEstrangeira());

        //buscando cliente
        Optional<Cliente> cliente = clienteRepositorio.findByCpf(ordemCompraRequest.getCpf());
        if(!cliente.isPresent()) {
            throw new RuntimeException();
        }





        OrdemCompra ordemCompra = OrdemCompraConversor.toEntity(ordemCompraRequest, valorCotacao, valorTotal, cliente.get());

        return OrdemCompraConversor.toResponse(ordemCompraRepositorio.save(ordemCompra));
        
    }
}