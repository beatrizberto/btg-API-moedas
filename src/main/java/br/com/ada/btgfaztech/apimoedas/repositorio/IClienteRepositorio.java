package br.com.ada.btgfaztech.apimoedas.repositorio;

import br.com.ada.btgfaztech.apimoedas.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepositorio extends JpaRepository<Cliente, Integer> {


}
