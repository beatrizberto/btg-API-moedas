package br.com.ada.btgfaztech.apimoedas.servico;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteRequest;
import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteResponse;
import br.com.ada.btgfaztech.apimoedas.modelo.Cliente;
import br.com.ada.btgfaztech.apimoedas.repositorio.IClienteRepositorio;
import br.com.ada.btgfaztech.apimoedas.utils.ClienteConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServico {

    @Autowired
    IClienteRepositorio clienteRepositorio;


    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        Cliente novoCliente = ClienteConversor.toEntity(clienteRequest);

        return ClienteConversor.toResponse(clienteRepositorio.save(novoCliente));


    }

}