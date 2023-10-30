package br.com.ada.btgfaztech.apimoedas.servico;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteRequest;
import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteResponse;
import br.com.ada.btgfaztech.apimoedas.controlador.exception.ClienteNaoEncontradoException;
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
        Optional<Cliente> clienteResponse = clienteRepositorio.findByCpf(cpf);

        if (clienteResponse.isEmpty()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado para o CPF: " + cpf);
        }
        return ClienteConversor.toResponse(clienteResponse.get());
    }

    public ClienteResponse buscarPorId(Integer id) {
        Optional<Cliente> clienteResponse = clienteRepositorio.findById(id);

        if (clienteResponse.isEmpty()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado para o ID: " + id);
        }
        return ClienteConversor.toResponse(clienteResponse.get());
    }


    public ClienteResponse editarCliente(Integer id, ClienteRequest clienteRequest) {
        Optional<Cliente> clienteParaAlterar = clienteRepositorio.findById(id);

        if (clienteParaAlterar.isEmpty()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado para o ID: " + id);
        } else {
            Cliente cliente = clienteParaAlterar.get();
            cliente.setNome(clienteRequest.getNome());
            cliente.setDataNascimento(clienteRequest.getDataNascimento());
            cliente.setEstadoCivil(clienteRequest.getEstadoCivil());
            cliente.setSexo(clienteRequest.getSexo());

            System.out.println("Dados do cliente atualizados com sucesso.");
            return ClienteConversor.toResponse(clienteRepositorio.save(cliente));
        }
    }

    public void deletarCliente(Integer id) {
        clienteRepositorio.deleteById(id);
    }
}