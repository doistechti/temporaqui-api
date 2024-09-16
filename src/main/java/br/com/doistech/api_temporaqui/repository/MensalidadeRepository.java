package br.com.doistech.api_temporaqui.repository;

import br.com.doistech.api_temporaqui.model.Mensalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long> {
}
