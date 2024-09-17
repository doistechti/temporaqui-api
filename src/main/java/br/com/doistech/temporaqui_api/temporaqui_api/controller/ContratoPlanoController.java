package br.com.doistech.temporaqui_api.temporaqui_api.controller;

import br.com.doistech.temporaqui_api.temporaqui_api.model.ContratoPlano;
import br.com.doistech.temporaqui_api.temporaqui_api.service.ContratoPlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contratos")
public class ContratoPlanoController {

    @Autowired
    private ContratoPlanoService contratoPlanoService;

    @GetMapping
    public ResponseEntity<List<ContratoPlano>> getAllContratos() {
        List<ContratoPlano> contratos = contratoPlanoService.findAll();
        return new ResponseEntity<>(contratos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoPlano> getContratoById(@PathVariable Long id) {
        Optional<ContratoPlano> contrato = contratoPlanoService.findById(id);
        return contrato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContratoPlano> createContrato(@RequestBody ContratoPlano contratoPlano) {
        ContratoPlano savedContratoPlano = contratoPlanoService.save(contratoPlano);
        return new ResponseEntity<>(savedContratoPlano, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoPlano> updateContrato(@PathVariable Long id, @RequestBody ContratoPlano contratoPlano) {
        if (contratoPlanoService.findById(id).isPresent()) {
            contratoPlano.setId(id);
            ContratoPlano updatedContratoPlano = contratoPlanoService.save(contratoPlano);
            return new ResponseEntity<>(updatedContratoPlano, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable Long id) {
        if (contratoPlanoService.findById(id).isPresent()) {
            contratoPlanoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}