package com.desafio.locadora.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TA_LOCACAO")
public class Locacao {
    @Id
    @GeneratedValue
    @Column(name = "ID_LOCACAO", nullable = false)
    private Long idLocacao;

    @Column(name = "ID_FILME", nullable = false)
    private Long idFilme;

    @Column(name = "USUARIO", nullable = false)
    private String usuario;

    @Column(name = "DATA_EMPRESTIMO", nullable = false)
    private LocalDateTime dataEmprestimo;

    @Column(name = "DATA_RETORNO")
    private LocalDateTime dataRetorno;

    @JoinColumn(name = "ID_FILME", referencedColumnName = "ID_FILME", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Filme filme;

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
            locacao.setDataEmprestimo(emprestimo);
            return this;
        }

        public Builder retorno(LocalDateTime retorno) {
            locacao.setDataRetorno(retorno);
            return this;
        }

        public Builder filme(Filme filme) {
            locacao.setFilme(filme);
            return this;
        }

        public Locacao build() {
            locacao.setIdLocacao(null);
            return locacao;
        }
    }

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

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
}
