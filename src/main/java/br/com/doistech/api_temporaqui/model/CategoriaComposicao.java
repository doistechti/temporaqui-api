package br.com.doistech.api_temporaqui.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class CategoriaComposicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "categoriaComposicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Composicao> composicoes;

    @ManyToMany
    @JoinTable(
            name = "produto_categoria_composicao",
            joinColumns = @JoinColumn(name = "categoria_composicao_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private Set<Produto> produtos;
}
