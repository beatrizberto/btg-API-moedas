package br.com.ada.btgfaztech.apimoedas.controlador;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.*;

import br.com.ada.btgfaztech.apimoedas.controlador.exception.ValidaMoedaErro;
import br.com.ada.btgfaztech.apimoedas.modelo.Cliente;
import br.com.ada.btgfaztech.apimoedas.servico.OrdemCompraServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/ordens-compra")
public class OrdemCompraControlador {

    @Autowired
    private OrdemCompraServico ordemCompraServico;

    @PostMapping
    public ResponseEntity<?> criarOrdemCompra(@RequestBody OrdemCompraRequest ordemCompraRequest) {
        try {
            OrdemCompraResponse ordemCompraResponse = ordemCompraServico.criarOrdemCompra(ordemCompraRequest);
            return ResponseEntity.created(URI.create("/ordens-compra/" + ordemCompraResponse.getIdCompra())).body(ordemCompraResponse);
        } catch (ValidaMoedaErro ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        catch (RuntimeException ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemCompraResponse> buscarPorId(@PathVariable Integer id) {
        OrdemCompraResponse ordemCompraResponse = ordemCompraServico.buscarPorId(id);

        if(ordemCompraResponse == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ordemCompraResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemCompraResponse> editarOrdemCompra(@PathVariable Integer id, @RequestBody OrdemCompraRequest ordemCompraRequest, BigDecimal valorCotacao, BigDecimal valorTotal, Cliente cliente) {
        return ResponseEntity.ok(ordemCompraServico.editarOrdemCompra(id, ordemCompraRequest));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelarOrdemDeCompra(@PathVariable Integer id) {
        OrdemCompraResponse ordemCompraResponse = ordemCompraServico.buscarPorId(id);
        if (ordemCompraResponse == null) {
            return ResponseEntity.notFound().build();
        }
        ordemCompraServico.cancelarOrdemDeCompra(id);
        return ResponseEntity.ok("Ordem de compra cancelada com sucesso.");
    }
}