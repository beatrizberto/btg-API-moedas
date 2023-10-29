package br.com.ada.btgfaztech.apimoedas.servico;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.OrdemCompraRequest;
import br.com.ada.btgfaztech.apimoedas.controlador.dto.OrdemCompraResponse;
import br.com.ada.btgfaztech.apimoedas.controlador.exception.ValidaMoedaErro;
import br.com.ada.btgfaztech.apimoedas.modelo.Cliente;
import br.com.ada.btgfaztech.apimoedas.modelo.CotacaoMoeda;
import br.com.ada.btgfaztech.apimoedas.modelo.OrdemCompra;
import br.com.ada.btgfaztech.apimoedas.repositorio.IClienteRepositorio;
import br.com.ada.btgfaztech.apimoedas.repositorio.IOrdemCompraRepositorio;
import br.com.ada.btgfaztech.apimoedas.utils.OrdemCompraConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class OrdemCompraServico {

    @Autowired
    private IClienteRepositorio clienteRepositorio;
    @Autowired
    private IOrdemCompraRepositorio ordemCompraRepositorio;

    @Autowired
    private CotacaoMoedaServico cotacaoMoedaServico;

    public OrdemCompraResponse criarOrdemCompra(OrdemCompraRequest ordemCompraRequest) {
        String moeda = ordemCompraRequest.getTipoMoeda();
        CotacaoMoeda cotacao = cotacaoMoedaServico.obterCotacaoMoeda(moeda);

        if(cotacao == null) {
            System.out.println("testestestestes");
            throw new ValidaMoedaErro();
        }

        BigDecimal valorCotacao = cotacao.getAsk();

        BigDecimal valorTotal = valorCotacao.multiply(ordemCompraRequest.getValorMoedaEstrangeira());

        Optional<Cliente> cliente = clienteRepositorio.findByCpf(ordemCompraRequest.getCpf());
        if(!cliente.isPresent()) {
            return null;
        }
        OrdemCompra ordemCompra = OrdemCompraConversor.toEntity(ordemCompraRequest, valorCotacao, valorTotal, cliente.get());

        return OrdemCompraConversor.toResponse(ordemCompraRepositorio.save(ordemCompra));
    }

    public OrdemCompraResponse buscarPorId(Integer id) {
        Optional<OrdemCompra> ordemCompraResponse =  ordemCompraRepositorio.findById(id);

        if(ordemCompraResponse.isPresent()){
            return OrdemCompraConversor.toResponse(ordemCompraResponse.get());
        } else {
            return null;
        }
    }


    public OrdemCompraResponse editarOrdemCompra(Integer id, OrdemCompraRequest ordemCompraRequest) {
        String moeda = ordemCompraRequest.getTipoMoeda();
        CotacaoMoeda cotacao = cotacaoMoedaServico.obterCotacaoMoeda(moeda);

        if(cotacao == null) {
            throw new ValidaMoedaErro();
        }

        BigDecimal valorCotacao = cotacao.getAsk();

        BigDecimal valorTotal = valorCotacao.multiply(ordemCompraRequest.getValorMoedaEstrangeira());

        Optional<Cliente> cliente = clienteRepositorio.findByCpf(ordemCompraRequest.getCpf());
        if(!cliente.isPresent()) {
            return null;
        }
        OrdemCompra ordemCompra = OrdemCompraConversor.toEntity(ordemCompraRequest, valorCotacao, valorTotal, cliente.get());
        ordemCompra.setId(id);
        return OrdemCompraConversor.toResponse(ordemCompraRepositorio.save(ordemCompra));
    }



    public void cancelarOrdemDeCompra(Integer id) {ordemCompraRepositorio.deleteById(id);}
}
