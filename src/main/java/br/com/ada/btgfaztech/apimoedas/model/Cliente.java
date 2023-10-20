package br.com.ada.btgfaztech.apimoedas.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String estadoCivil;
    private String sexo;

    //cliente pode ter várias ordens de compra
    @OneToMany(mappedBy = "cliente")
    private List<OrdemCompra> ordensCompra;

}
