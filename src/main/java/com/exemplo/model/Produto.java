package com.exemplo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Produto extends AbstractEntity {
    @Column(columnDefinition = "int default 0")
    @Version
    public Long version;

    public String nome;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    public Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNome(String nome) {
        Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.nome = nome.trim().toUpperCase();
    }
}
