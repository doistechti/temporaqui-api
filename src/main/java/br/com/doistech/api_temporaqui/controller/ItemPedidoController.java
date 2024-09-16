package br.com.doistech.api_temporaqui.controller;

import br.com.doistech.api_temporaqui.model.ItemPedido;
import br.com.doistech.api_temporaqui.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List<ItemPedido> getAllItensPedido() {
        return itemPedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ItemPedido> getItemPedidoById(@PathVariable Long id) {
        return itemPedidoService.findById(id);
    }

    @PostMapping
    public ItemPedido createItemPedido(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.save(itemPedido);
    }

    @DeleteMapping("/{id}")
    public void deleteItemPedido(@PathVariable Long id) {
        itemPedidoService.deleteById(id);
    }
}
