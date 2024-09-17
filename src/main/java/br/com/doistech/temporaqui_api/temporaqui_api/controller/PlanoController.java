package br.com.doistech.temporaqui_api.temporaqui_api.controller;

import br.com.doistech.temporaqui_api.temporaqui_api.model.Plano;
import br.com.doistech.temporaqui_api.temporaqui_api.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping
    public ResponseEntity<List<Plano>> getAllPlanos() {
        List<Plano> planos = planoService.findAll();
        return new ResponseEntity<>(planos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> getPlanoById(@PathVariable Long id) {
        Optional<Plano> plano = planoService.findById(id);
        return plano.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Plano> createPlano(@RequestBody Plano plano) {
        Plano savedPlano = planoService.save(plano);
        return new ResponseEntity<>(savedPlano, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> updatePlano(@PathVariable Long id, @RequestBody Plano plano) {
        if (planoService.findById(id).isPresent()) {
            plano.setId(id);
            Plano updatedPlano = planoService.save(plano);
            return new ResponseEntity<>(updatedPlano, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlano(@PathVariable Long id) {
        if (planoService.findById(id).isPresent()) {
            planoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}