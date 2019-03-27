package com.desafio.locadora.domain.out;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioOut {
    @ApiModelProperty(notes = "ID auto-gerado para identificação da entidade", allowEmptyValue = true)
    private Long id;

    @ApiModelProperty(notes = "E-mail utilizado para logar aplicação")
    private String username;

    @ApiModelProperty(notes = "Nome do usuário")
    private String nome;
}
