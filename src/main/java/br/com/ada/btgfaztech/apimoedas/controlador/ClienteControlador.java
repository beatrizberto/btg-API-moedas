package br.com.ada.btgfaztech.apimoedas.controlador;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteRequest;
import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteResponse;
import br.com.ada.btgfaztech.apimoedas.controlador.exception.ClienteNaoEncontradoException;
import br.com.ada.btgfaztech.apimoedas.servico.ClienteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClienteControlador {

    @Autowired
    ClienteServico clienteServico;

    @PostMapping
    public ResponseEntity<ClienteResponse> criarCliente(
            @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse cliente = clienteServico.criarCliente(clienteRequest);
        return ResponseEntity.created(URI.create("/cliente/" + cliente.getId())).body(cliente);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ClienteResponse> buscarPorCpf(@PathVariable String cpf) {
        try {
            ClienteResponse clienteResponse = clienteServico.buscarPorCpf(cpf);
            return ResponseEntity.ok(clienteResponse);
        } catch (ClienteNaoEncontradoException exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Integer id) {
        try {
            ClienteResponse clienteResponse = clienteServico.buscarPorId(id);
            return ResponseEntity.ok(clienteResponse);
        } catch (ClienteNaoEncontradoException exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<ClienteResponse> editarCliente(@PathVariable Integer id, @RequestBody ClienteRequest clienteRequest) {
        try {
            return ResponseEntity.ok(clienteServico.editarCliente(id, clienteRequest));
        } catch (ClienteNaoEncontradoException exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Integer id) {
        ClienteResponse clienteResponse = clienteServico.buscarPorId(id);
        if (clienteResponse == null) {
            return ResponseEntity.notFound().build();
        }
        clienteServico.deletarCliente(id);
        return ResponseEntity.ok("Cliente deletado com sucesso.");
    }
}
