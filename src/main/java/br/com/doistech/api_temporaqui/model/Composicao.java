package br.com.doistech.api_temporaqui.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Composicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double valorAdicional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_composicao_id")
    private CategoriaComposicao categoriaComposicao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;

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

    public Double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(Double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public CategoriaComposicao getCategoriaComposicao() {
        return categoriaComposicao;
    }

    public void setCategoriaComposicao(CategoriaComposicao categoriaComposicao) {
        this.categoriaComposicao = categoriaComposicao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
