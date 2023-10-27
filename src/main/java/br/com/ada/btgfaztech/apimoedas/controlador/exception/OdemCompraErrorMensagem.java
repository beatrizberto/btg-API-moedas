package br.com.ada.btgfaztech.apimoedas.controlador.exception;

import br.com.ada.btgfaztech.apimoedas.controlador.dto.OrdemCompraResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//classe para encapsular mensagens de erro
public class OdemCompraErrorMensagem {
    private String mensagem;


    public OdemCompraErrorMensagem(String mensagem) {
        this.mensagem = mensagem;

    }


}