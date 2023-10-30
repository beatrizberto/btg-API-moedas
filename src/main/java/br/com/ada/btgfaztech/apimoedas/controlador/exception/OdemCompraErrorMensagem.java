package br.com.ada.btgfaztech.apimoedas.controlador.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdemCompraErrorMensagem {
    private String mensagem;

    public OdemCompraErrorMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}