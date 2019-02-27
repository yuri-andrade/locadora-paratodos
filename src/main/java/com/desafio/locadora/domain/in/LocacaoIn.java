package com.desafio.locadora.domain.in;

import io.swagger.annotations.ApiModelProperty;

public class LocacaoIn {

    @ApiModelProperty(notes = "Id do filme")
    private Long idFilme;

    @ApiModelProperty(notes = "Nome do filme")
    private String nomeFilme;


    public Long getIdFilme() {
        return idFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }
}
