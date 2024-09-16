package br.com.doistech.api_temporaqui.service;

import br.com.doistech.api_temporaqui.model.CategoriaComposicao;
import br.com.doistech.api_temporaqui.repository.CategoriaComposicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaComposicaoService {

    @Autowired
    private CategoriaComposicaoRepository categoriaComposicaoRepository;

    public List<CategoriaComposicao> findAll() {
        return categoriaComposicaoRepository.findAll();
    }

    public Optional<CategoriaComposicao> findById(Long id) {
        return categoriaComposicaoRepository.findById(id);
    }

    public CategoriaComposicao save(CategoriaComposicao categoriaComposicao) {
        return categoriaComposicaoRepository.save(categoriaComposicao);
    }

    public void deleteById(Long id) {
        categoriaComposicaoRepository.deleteById(id);
    }
}
