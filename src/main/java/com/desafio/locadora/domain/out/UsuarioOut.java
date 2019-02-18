package com.desafio.locadora.domain.out;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioOut {
    @ApiModelProperty(notes = "ID auto-gerado para identificação da entidade", allowEmptyValue = true)
    private Long id;

    @ApiModelProperty(notes = "E-mail utilizado para logar aplicação")
    private String username;

    @ApiModelProperty(notes = "Nome do usuário")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
