package com.desafio.locadora.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "TA_LOCACAO")
@Data
@Builder
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

}
