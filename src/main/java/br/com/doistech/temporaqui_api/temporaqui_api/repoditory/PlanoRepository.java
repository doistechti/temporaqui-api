package br.com.doistech.temporaqui_api.temporaqui_api.repoditory;

import br.com.doistech.temporaqui_api.temporaqui_api.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {
}

