package br.com.doistech.api_temporaqui.service;

import br.com.doistech.api_temporaqui.model.Pedido;
import br.com.doistech.api_temporaqui.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }
}
