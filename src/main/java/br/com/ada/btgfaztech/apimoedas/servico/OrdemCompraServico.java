package br.com.ada.btgfaztech.apimoedas.servico;

import br.com.ada.btgfaztech.apimoedas.repositorio.IClienteRepositorio;
import br.com.ada.btgfaztech.apimoedas.repositorio.IOrdemCompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrdemCompraServico {

    //precisa da classe cotação de moeda
    @Autowired
    private IClienteRepositorio clienteRepositorio;
    @Autowired
    private IOrdemCompraRepositorio ordemCompraRepositorio;

}