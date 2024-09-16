package br.com.doistech.api_temporaqui.service;

import br.com.doistech.api_temporaqui.model.Mensalidade;
import br.com.doistech.api_temporaqui.repository.MensalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensalidadeService {

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

    public List<Mensalidade> findAll() {
        return mensalidadeRepository.findAll();
    }

    public Optional<Mensalidade> findById(Long id) {
        return mensalidadeRepository.findById(id);
    }

    public Mensalidade save(Mensalidade mensalidade) {
        return mensalidadeRepository.save(mensalidade);
    }

    public void deleteById(Long id) {
        mensalidadeRepository.deleteById(id);
    }
}
