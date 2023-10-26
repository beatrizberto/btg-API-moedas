package br.com.ada.btgfaztech.apimoedas.controlador;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.*;
import br.com.ada.btgfaztech.apimoedas.modelo.CotacaoMoeda;
import br.com.ada.btgfaztech.apimoedas.servico.CotacaoMoedaServico;
import br.com.ada.btgfaztech.apimoedas.servico.OrdemCompraServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ordens-compra")
public class OrdemCompraControlador {

    @Autowired
    private OrdemCompraServico ordemCompraServico;


    @PostMapping
    public ResponseEntity<OrdemCompraResponse> criarOrdemCompra(
            @RequestBody OrdemCompraRequest ordemCompraRequest) {

        OrdemCompraResponse ordemCompraResponse = ordemCompraServico.criarOrdemCompra(ordemCompraRequest);
        return ResponseEntity.created(URI.create("/ordens-compra/" + ordemCompraResponse.getIdCompra())).body(ordemCompraResponse);

    }



}
