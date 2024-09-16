package br.com.doistech.api_temporaqui.controller;

import br.com.doistech.api_temporaqui.model.Mensalidade;
import br.com.doistech.api_temporaqui.service.MensalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mensalidades")
public class MensalidadeController {

    @Autowired
    private MensalidadeService mensalidadeService;

    @GetMapping
    public List<Mensalidade> getAllMensalidades() {
        return mensalidadeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Mensalidade> getMensalidadeById(@PathVariable Long id) {
        return mensalidadeService.findById(id);
    }

    @PostMapping
    public Mensalidade createMensalidade(@RequestBody Mensalidade mensalidade) {
        return mensalidadeService.save(mensalidade);
    }

    @DeleteMapping("/{id}")
    public void deleteMensalidade(@PathVariable Long id) {
        mensalidadeService.deleteById(id);
    }
}
