package br.com.ada.btgfaztech.apimoedas.utils;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteRequest;
import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteResponse;
import br.com.ada.btgfaztech.apimoedas.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteConversor {

    public static Cliente toEntity(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequest.getNome());
        cliente.setCpf(clienteRequest.getCpf());
        cliente.setDataNascimento(clienteRequest.getDataNascimento());
        cliente.setEstadoCivil(clienteRequest.getEstadoCivil());
        cliente.setSexo(cliente.getSexo());

        return cliente;
    }

    public static ClienteResponse toResponse(Cliente cliente) {
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setId(cliente.getId());
        clienteResponse.setCpf(cliente.getCpf());
        clienteResponse.setNome(cliente.getNome());

        return clienteResponse;
    }

    public static List<ClienteResponse> toResponseList(List<Cliente> clientes) {
        List<ClienteResponse> clienteResponses = new ArrayList<>();

        for (Cliente cliente : clientes) {
            ClienteResponse clienteResponse = ClienteConversor.toResponse(cliente);
            clienteResponses.add(clienteResponse);
        }

        return clienteResponses;
    }
}
