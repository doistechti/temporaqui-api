package br.com.doistech.temporaqui_api.temporaqui_api.service;

import br.com.doistech.temporaqui_api.temporaqui_api.model.ContratoPlano;
import br.com.doistech.temporaqui_api.temporaqui_api.repoditory.ContratoPlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoPlanoService {

    @Autowired
    private ContratoPlanoRepository contratoPlanoRepository;

    public List<ContratoPlano> findAll() {
        return contratoPlanoRepository.findAll();
    }

    public Optional<ContratoPlano> findById(Long id) {
        return contratoPlanoRepository.findById(id);
    }

    public ContratoPlano save(ContratoPlano contratoPlano) {
        return contratoPlanoRepository.save(contratoPlano);
    }

    public void deleteById(Long id) {
        contratoPlanoRepository.deleteById(id);
    }
}

