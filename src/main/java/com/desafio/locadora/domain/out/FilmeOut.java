package com.desafio.locadora.domain.out;


import com.desafio.locadora.entity.enums.LocacaoEnum;
import io.swagger.annotations.ApiModelProperty;


public class FilmeOut {
    @ApiModelProperty(notes = "ID auto-gerado para identificação da entidade")
    private Long id;

    @ApiModelProperty(notes = "Nome do filme")
    private String nome;

    @ApiModelProperty(notes = "Nome do diretor do filme")
    private String diretor;

    @ApiModelProperty(notes = "Identificador de status locação", allowEmptyValue = true)
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
