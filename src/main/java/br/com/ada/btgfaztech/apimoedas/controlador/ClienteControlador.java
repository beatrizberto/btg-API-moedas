package br.com.ada.btgfaztech.apimoedas.controlador;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteRequest;
import br.com.ada.btgfaztech.apimoedas.controlador.dto.ClienteResponse;
import br.com.ada.btgfaztech.apimoedas.servico.ClienteServico;
import org.apache.coyote.Response;
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
        return ResponseEntity.ok(clienteServico.buscarPorCpf(cpf));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> editarCliente(@PathVariable Integer id, @RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity.ok(clienteServico.editarCliente(id, clienteRequest));
    }

}
