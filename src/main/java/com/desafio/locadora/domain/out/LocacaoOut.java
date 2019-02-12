package com.desafio.locadora.domain.out;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class LocacaoOut {

    @ApiModelProperty(notes = "ID auto-gerado para identificação da entidade")
    private Long id;

    @ApiModelProperty(notes = "ID de identificação do Filme alugado")
    private Long idFilme;

    @ApiModelProperty(notes = "Nome do Usuario da locação")
    private String usuario;

    @ApiModelProperty(notes = "Data de início da locação")
    private LocalDateTime emprestimo;

    @ApiModelProperty(notes = "Data de final da locação", allowEmptyValue = true)
    private LocalDateTime retorno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(LocalDateTime emprestimo) {
        this.emprestimo = emprestimo;
    }

    public LocalDateTime getRetorno() {
        return retorno;
    }

    public void setRetorno(LocalDateTime retorno) {
        this.retorno = retorno;
    }
}
