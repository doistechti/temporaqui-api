package br.com.doistech.temporaqui_api.temporaqui_api.controller;

import br.com.doistech.temporaqui_api.temporaqui_api.model.Aplicacao;
import br.com.doistech.temporaqui_api.temporaqui_api.service.AplicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aplicacoes")
public class AplicacaoController {

    @Autowired
    private AplicacaoService aplicacaoService;

    @GetMapping
    public ResponseEntity<List<Aplicacao>> getAllAplicacoes() {
        List<Aplicacao> aplicacoes = aplicacaoService.findAll();
        return new ResponseEntity<>(aplicacoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aplicacao> getAplicacaoById(@PathVariable Long id) {
        Optional<Aplicacao> aplicacao = aplicacaoService.findById(id);
        return aplicacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aplicacao> createAplicacao(@RequestBody Aplicacao aplicacao) {
        Aplicacao savedAplicacao = aplicacaoService.save(aplicacao);
        return new ResponseEntity<>(savedAplicacao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aplicacao> updateAplicacao(@PathVariable Long id, @RequestBody Aplicacao aplicacao) {
        if (aplicacaoService.findById(id).isPresent()) {
            aplicacao.setId(id);
            Aplicacao updatedAplicacao = aplicacaoService.save(aplicacao);
            return new ResponseEntity<>(updatedAplicacao, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAplicacao(@PathVariable Long id) {
        if (aplicacaoService.findById(id).isPresent()) {
            aplicacaoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

