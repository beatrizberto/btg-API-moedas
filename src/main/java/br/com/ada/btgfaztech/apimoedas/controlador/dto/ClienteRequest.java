package br.com.ada.btgfaztech.apimoedas.controlador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ClienteRequest {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String estadoCivil;
    private String sexo;
}
