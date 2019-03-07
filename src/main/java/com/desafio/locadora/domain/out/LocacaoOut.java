package com.desafio.locadora.domain.out;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

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

    public Long getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(Long idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDateTime dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public FilmeOut getFilme() {
        return filme;
    }

    public void setFilme(FilmeOut filme) {
        this.filme = filme;
    }
}
