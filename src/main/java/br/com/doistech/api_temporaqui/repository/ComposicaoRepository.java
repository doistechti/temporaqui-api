package br.com.doistech.api_temporaqui.repository;

import br.com.doistech.api_temporaqui.model.Composicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposicaoRepository extends JpaRepository<Composicao, Long> {
}
