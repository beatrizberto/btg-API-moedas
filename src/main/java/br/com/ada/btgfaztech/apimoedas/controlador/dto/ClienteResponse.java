package br.com.ada.btgfaztech.apimoedas.controlador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteResponse {

    private Integer id;
    private String nome;
    private String cpf;
}
