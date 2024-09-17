package br.com.doistech.temporaqui_api.temporaqui_api.service;

import br.com.doistech.temporaqui_api.temporaqui_api.model.Plano;
import br.com.doistech.temporaqui_api.temporaqui_api.repoditory.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public List<Plano> findAll() {
        return planoRepository.findAll();
    }

    public Optional<Plano> findById(Long id) {
        return planoRepository.findById(id);
    }

    public Plano save(Plano plano) {
        return planoRepository.save(plano);
    }

    public void deleteById(Long id) {
        planoRepository.deleteById(id);
    }
}

