package com.desafio.locadora.entity;

import com.desafio.locadora.entity.enums.LocacaoEnum;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiIgnore
@Entity
@Table(name = "TA_FILME")
public class Filme {
    @Id
    @GeneratedValue
    @Column(name = "ID_FILME", nullable = false)
    private Long idFilme;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DIRETOR", nullable = false)
    private String diretor;

    @Column(name = "LOCADO", nullable = false)
    private LocacaoEnum locado;

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
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

