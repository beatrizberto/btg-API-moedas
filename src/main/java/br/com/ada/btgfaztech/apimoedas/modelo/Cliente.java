package br.com.ada.btgfaztech.apimoedas.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;
    private LocalDate dataNascimento;
    private String estadoCivil;
    private String sexo;

    @OneToMany(mappedBy = "cliente")
    private List<OrdemCompra> ordensCompra;
}
