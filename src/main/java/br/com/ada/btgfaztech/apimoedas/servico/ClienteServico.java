package br.com.ada.btgfaztech.apimoedas.servico;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteRequest;
import br.com.ada.btgfaztech.apimoedas.modelo.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteServico {

    public Cliente criarCliente(ClienteRequest clienteRequest) {
        Cliente novoCliente = new Cliente();
        novoCliente.setCpf(clienteRequest.getCpf());
        novoCliente.setNome(clienteRequest.getNome());
        novoCliente.setDataNascimento(clienteRequest.getDataNascimento());
        novoCliente.setEstadoCivil(clienteRequest.getEstadoCivil());
        novoCliente.setSexo(clienteRequest.getSexo());

        return null;
    }

}