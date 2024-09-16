package br.com.doistech.api_temporaqui.service;

import br.com.doistech.api_temporaqui.model.Catalogo;
import br.com.doistech.api_temporaqui.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository catalogoRepository;

    public List<Catalogo> findAll() {
        return catalogoRepository.findAll();
    }

    public Optional<Catalogo> findById(Long id) {
        return catalogoRepository.findById(id);
    }

    public Catalogo save(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }

    public void deleteById(Long id) {
        catalogoRepository.deleteById(id);
    }
}
