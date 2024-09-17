package br.com.doistech.temporaqui_api.temporaqui_api.repoditory;

import br.com.doistech.temporaqui_api.temporaqui_api.model.ContratoPlano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoPlanoRepository extends JpaRepository<ContratoPlano, Long> {
}

