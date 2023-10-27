package br.com.ada.btgfaztech.apimoedas.repositorio;

import br.com.ada.btgfaztech.apimoedas.modelo.OrdemCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdemCompraRepositorio extends JpaRepository<OrdemCompra, Integer> {
}
