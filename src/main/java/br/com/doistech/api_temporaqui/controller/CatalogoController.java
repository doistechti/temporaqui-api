package br.com.doistech.api_temporaqui.controller;

import br.com.doistech.api_temporaqui.model.Catalogo;
import br.com.doistech.api_temporaqui.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catalogos")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    @GetMapping
    public List<Catalogo> getAllCatalogos() {
        return catalogoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Catalogo> getCatalogoById(@PathVariable Long id) {
        return catalogoService.findById(id);
    }

    @PostMapping
    public Catalogo createCatalogo(@RequestBody Catalogo catalogo) {
        return catalogoService.save(catalogo);
    }

    @DeleteMapping("/{id}")
    public void deleteCatalogo(@PathVariable Long id) {
        catalogoService.deleteById(id);
    }
}
