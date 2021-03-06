package com.desafio.locadora.domain.out;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioOut {
    @ApiModelProperty(notes = "E-mail utilizado para logar aplicação")
    private String username;

    @ApiModelProperty(notes = "Nome do usuário")
    private String nome;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
