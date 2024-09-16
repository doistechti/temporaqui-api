package br.com.doistech.api_temporaqui.repository;

import br.com.doistech.api_temporaqui.model.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
}
