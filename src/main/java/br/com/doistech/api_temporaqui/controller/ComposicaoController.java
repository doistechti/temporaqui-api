package br.com.doistech.api_temporaqui.controller;

import br.com.doistech.api_temporaqui.model.Composicao;
import br.com.doistech.api_temporaqui.service.ComposicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/composicoes")
public class ComposicaoController {

    @Autowired
    private ComposicaoService composicaoService;

    @GetMapping
    public List<Composicao> getAllComposicoes() {
        return composicaoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Composicao> getComposicaoById(@PathVariable Long id) {
        return composicaoService.findById(id);
    }

    @PostMapping
    public Composicao createComposicao(@RequestBody Composicao composicao) {
        return composicaoService.save(composicao);
    }

    @DeleteMapping("/{id}")
    public void deleteComposicao(@PathVariable Long id) {
        composicaoService.deleteById(id);
    }
}
