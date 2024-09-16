package br.com.doistech.api_temporaqui.controller;

import br.com.doistech.api_temporaqui.model.CategoriaComposicao;
import br.com.doistech.api_temporaqui.service.CategoriaComposicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias-composicoes")
public class CategoriaComposicaoController {

    @Autowired
    private CategoriaComposicaoService categoriaComposicaoService;

    @GetMapping
    public List<CategoriaComposicao> getAllCategoriasComposicoes() {
        return categoriaComposicaoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaComposicao> getCategoriaComposicaoById(@PathVariable Long id) {
        return categoriaComposicaoService.findById(id);
    }

    @PostMapping
    public CategoriaComposicao createCategoriaComposicao(@RequestBody CategoriaComposicao categoriaComposicao) {
        return categoriaComposicaoService.save(categoriaComposicao);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoriaComposicao(@PathVariable Long id) {
        categoriaComposicaoService.deleteById(id);
    }
}
