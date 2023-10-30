package br.com.ada.btgfaztech.apimoedas.controlador.exception;

public class ValidaMoedaErro extends RuntimeException {
    public ValidaMoedaErro() {
        super("Por favor, escolha uma moeda do tipo USD ou EUR.");
    }
}
