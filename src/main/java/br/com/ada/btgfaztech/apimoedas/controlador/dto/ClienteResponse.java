package br.com.ada.btgfaztech.apimoedas.controlador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {
    private Integer id;
    private String nome;
    private String cpf;
}
