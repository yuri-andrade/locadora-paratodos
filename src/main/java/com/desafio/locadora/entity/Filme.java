package com.desafio.locadora.entity;

import com.desafio.locadora.entity.enums.LocacaoEnum;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Filme {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @ApiModelProperty(notes = "ID auto-gerado para identificação da entidade", allowEmptyValue = true)
    private Long id;

    @ApiModelProperty(notes = "Nome do filme", allowEmptyValue = true)
    @Column(name = "nome", nullable = false)
    private String nome;

    @ApiModelProperty(notes = "Nome do diretor do filme", allowEmptyValue = true)
    @Column(name = "diretor", nullable = false)
    private String diretor;

    @ApiModelProperty(notes = "Identificador de status locação", allowEmptyValue = true)
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

