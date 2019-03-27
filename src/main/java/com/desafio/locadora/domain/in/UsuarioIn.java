package com.desafio.locadora.domain.in;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class UsuarioIn {
    @ApiModelProperty(notes = "E-mail utilizado para logar aplicação")
    private String username;

    @ApiModelProperty(notes = "Nome do usuário")
    private String nome;

    @ApiModelProperty(notes = "Senha utilizada para logar na aplicação")
    private String password;
}
