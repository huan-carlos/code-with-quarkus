package com.exemplo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.*;

@Entity
public class Categoria extends AbstractEntity {
    @Column(columnDefinition = "int default 0")
    @Version
    public Long version;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    public List<Produto> produtos = new ArrayList<>();

    public String descricao, sigla;

    public Categoria(long id, String descricao, String sigla) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public Categoria() {
    }
}