package br.com.doistech.temporaqui_api.temporaqui_api.controller;

import br.com.doistech.temporaqui_api.temporaqui_api.model.Companhia;
import br.com.doistech.temporaqui_api.temporaqui_api.service.CompanhiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

    @Autowired
    private CompanhiaService companhiaService;

    @GetMapping
    public ResponseEntity<List<Companhia>> getAllCompanhias() {
        List<Companhia> companhias = companhiaService.findAll();
        return new ResponseEntity<>(companhias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Companhia> getCompanhiaById(@PathVariable Long id) {
        Optional<Companhia> companhia = companhiaService.findById(id);
        return companhia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Companhia> createCompanhia(@RequestBody Companhia companhia) {
        Companhia savedCompanhia = companhiaService.save(companhia);
        return new ResponseEntity<>(savedCompanhia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Companhia> updateCompanhia(@PathVariable Long id, @RequestBody Companhia companhia) {
        if (companhiaService.findById(id).isPresent()) {
            companhia.setId(id);
            Companhia updatedCompanhia = companhiaService.save(companhia);
            return new ResponseEntity<>(updatedCompanhia, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanhia(@PathVariable Long id) {
        if (companhiaService.findById(id).isPresent()) {
            companhiaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

