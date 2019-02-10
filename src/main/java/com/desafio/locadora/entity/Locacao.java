package com.desafio.locadora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Locacao {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "idFilme", nullable = false)
    private Long idFilme;

    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "emprestimo", nullable = false)
    private LocalDateTime emprestimo;

    @Column(name = "retorno", nullable = true)
    private LocalDateTime retorno;



    public Locacao(Long idFilme, Long idUsuario, LocalDateTime emprestimo) {
        this.idFilme = idFilme;
        this.idUsuario = idUsuario;
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
