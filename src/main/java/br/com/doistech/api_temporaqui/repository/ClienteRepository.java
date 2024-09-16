package br.com.doistech.api_temporaqui.repository;

import br.com.doistech.api_temporaqui.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
