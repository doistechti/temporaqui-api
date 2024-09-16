package br.com.doistech.api_temporaqui.service;

import br.com.doistech.api_temporaqui.model.Composicao;
import br.com.doistech.api_temporaqui.repository.ComposicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComposicaoService {
    @Autowired
    private ComposicaoRepository composicaoRepository;

    public List<Composicao> findAll() {
        return composicaoRepository.findAll();
    }

    public Optional<Composicao> findById(Long id) {
        return composicaoRepository.findById(id);
    }

    public Composicao save(Composicao composicao) {
        return composicaoRepository.save(composicao);
    }

    public void deleteById(Long id) {
        composicaoRepository.deleteById(id);
    }
}
