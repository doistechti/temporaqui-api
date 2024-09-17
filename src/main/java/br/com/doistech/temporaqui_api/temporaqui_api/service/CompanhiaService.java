package br.com.doistech.temporaqui_api.temporaqui_api.service;

import br.com.doistech.temporaqui_api.temporaqui_api.model.Companhia;
import br.com.doistech.temporaqui_api.temporaqui_api.repoditory.CompanhiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanhiaService {

    @Autowired
    private CompanhiaRepository companhiaRepository;

    public List<Companhia> findAll() {
        return companhiaRepository.findAll();
    }

    public Optional<Companhia> findById(Long id) {
        return companhiaRepository.findById(id);
    }

    public Companhia save(Companhia companhia) {
        return companhiaRepository.save(companhia);
    }

    public void deleteById(Long id) {
        companhiaRepository.deleteById(id);
    }
}