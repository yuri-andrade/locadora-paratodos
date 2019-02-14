package com.desafio.locadora.domain.in;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioIn {
    @ApiModelProperty(notes = "E-mail utilizado para logar aplicação")
    private String username;

    @ApiModelProperty(notes = "Nome do usuário")
    private String nome;

    @ApiModelProperty(notes = "Senha utilizada para logar na aplicação")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
