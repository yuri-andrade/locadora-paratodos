package com.desafio.locadora.entity;

import com.desafio.locadora.entity.enums.LocacaoEnum;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ApiIgnore
@Entity
public class Filme {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "diretor", nullable = false)
    private String diretor;

    @Column(name = "locado", nullable = false)
    private LocacaoEnum locado;

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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public LocacaoEnum getLocado() {
        return locado;
    }

    public void setLocado(LocacaoEnum locado) {
        this.locado = locado;
    }
}

