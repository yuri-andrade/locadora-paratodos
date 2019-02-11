package com.desafio.locadora.domain.out;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class LocacaoOut {

    @ApiModelProperty(notes = "ID auto-gerado para identificação da entidade", allowEmptyValue = true)
    private Long id;

    @ApiModelProperty(notes = "ID de identificação do Filme alugado", allowEmptyValue = true)
    private Long idFilme;

    @ApiModelProperty(notes = "ID de identificação da Usuario da locação", allowEmptyValue = true)
    private Long idUsuario;

    @ApiModelProperty(notes = "Data de início da locação", allowEmptyValue = true)
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
