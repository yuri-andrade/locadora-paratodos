package com.desafio.locadora.domain.in;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class LocacaoIn {

    @ApiModelProperty(notes = "Id do filme para encerramento de uma locação")
    private Long idFilme;

    @ApiModelProperty(notes = "Nome do filme para abertura de uma locação")
    private String nomeFilme;
}
