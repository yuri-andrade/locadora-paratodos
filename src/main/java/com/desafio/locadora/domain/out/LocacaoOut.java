package com.desafio.locadora.domain.out;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LocacaoOut {

    @ApiModelProperty(notes = "ID auto-gerado para identificação da entidade")
    private Long idLocacao;

    @ApiModelProperty(notes = "ID de identificação do Filme alugado")
    private Long idFilme;

    @ApiModelProperty(notes = "Nome do Usuario da locação")
    private String usuario;

    @ApiModelProperty(notes = "Data de início da locação")
    private LocalDateTime dataEmprestimo;

    @ApiModelProperty(notes = "Data de final da locação", allowEmptyValue = true)
    private LocalDateTime dataRetorno;

    @ApiModelProperty(notes = "Filme locado")
    private FilmeOut filme;

}
