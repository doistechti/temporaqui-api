package br.com.doistech.temporaqui_api.temporaqui_api.service;

import br.com.doistech.temporaqui_api.temporaqui_api.model.Aplicacao;
import br.com.doistech.temporaqui_api.temporaqui_api.repoditory.AplicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicacaoService {

    @Autowired
    private AplicacaoRepository aplicacaoRepository;

    public List<Aplicacao> findAll() {
        return aplicacaoRepository.findAll();
    }

    public Optional<Aplicacao> findById(Long id) {
        return aplicacaoRepository.findById(id);
    }

    public Aplicacao save(Aplicacao aplicacao) {
        return aplicacaoRepository.save(aplicacao);
    }

    public void deleteById(Long id) {
        aplicacaoRepository.deleteById(id);
    }
}

