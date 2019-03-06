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


    public static final Builder builder = new Builder();

    public static class Builder {

        Locacao locacao = new Locacao();

        public Builder idFilme(Long idFilme) {
            locacao.setIdFilme(idFilme);
            return this;
        }

        public Builder usuario(String usuario) {
            locacao.setUsuario(usuario);
            return this;
        }

        public Builder emprestimo(LocalDateTime emprestimo) {
            locacao.setEmprestimo(emprestimo);
            return this;
        }

        public Builder retorno(LocalDateTime retorno) {
            locacao.setRetorno(retorno);
            return this;
        }

        public Locacao build() {
            return locacao;
        }
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
