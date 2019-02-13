package com.desafio.locadora.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Locacao {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "idFilme", nullable = false)
    private Long idFilme;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "emprestimo", nullable = false)
    private LocalDateTime emprestimo;

    @Column(name = "retorno", nullable = true)
    private LocalDateTime retorno;


    public Locacao(Long idFilme, String usuario, LocalDateTime emprestimo) {
        this.idFilme = idFilme;
        this.usuario = usuario;
        this.emprestimo = emprestimo;
    }

    public Locacao() {
    }

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
