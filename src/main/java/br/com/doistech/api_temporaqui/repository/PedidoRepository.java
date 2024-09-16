package br.com.doistech.api_temporaqui.repository;

import br.com.doistech.api_temporaqui.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

