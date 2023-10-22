package br.com.ada.btgfaztech.apimoedas.servico;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteRequest;
import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteResponse;
import br.com.ada.btgfaztech.apimoedas.modelo.Cliente;
import br.com.ada.btgfaztech.apimoedas.repositorio.IClienteRepositorio;
import br.com.ada.btgfaztech.apimoedas.utils.ClienteConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServico {

    @Autowired
    IClienteRepositorio clienteRepositorio;


    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        Cliente novoCliente = ClienteConversor.toEntity(clienteRequest);

        return ClienteConversor.toResponse(clienteRepositorio.save(novoCliente));
    }

    public ClienteResponse buscarPorCpf(String cpf) {
        Optional<Cliente> clienteResponse =  clienteRepositorio.findByCpf(cpf);

        if(clienteResponse.isPresent()){
            return ClienteConversor.toResponse(clienteResponse.get());
        } else {
            //throw new RuntimeException("Cliente não encontrado");
            return null;
        }
    }

    public ClienteResponse editarCliente(Integer id, ClienteRequest clienteRequest) {
        Cliente cliente = ClienteConversor.toEntity(clienteRequest);
        cliente.setId(id);
        return ClienteConversor.toResponse(clienteRepositorio.save(cliente));
    }

    public void deletarCliente(Integer id) {
        clienteRepositorio.deleteById(id);
    }

}