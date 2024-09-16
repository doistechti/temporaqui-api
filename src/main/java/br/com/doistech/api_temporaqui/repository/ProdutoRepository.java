package br.com.doistech.api_temporaqui.repository;

import br.com.doistech.api_temporaqui.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
