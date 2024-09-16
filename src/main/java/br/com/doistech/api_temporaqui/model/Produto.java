package br.com.doistech.api_temporaqui.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalogo_id")
    private Catalogo catalogo;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Composicao> composicoes;

    @ManyToMany(mappedBy = "produtos")
    private Set<CategoriaComposicao> categoriaComposicoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Set<Composicao> getComposicoes() {
        return composicoes;
    }

    public void setComposicoes(Set<Composicao> composicoes) {
        this.composicoes = composicoes;
    }

    public Set<CategoriaComposicao> getCategoriaComposicoes() {
        return categoriaComposicoes;
    }

    public void setCategoriaComposicoes(Set<CategoriaComposicao> categoriaComposicoes) {
        this.categoriaComposicoes = categoriaComposicoes;
    }
}
