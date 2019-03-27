package com.desafio.locadora.entity;

import com.desafio.locadora.entity.enums.LocacaoEnum;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

@ApiIgnore
@Entity
@Table(name = "TA_FILME")
@Data
public class Filme {
    @Id
    @GeneratedValue
    @Column(name = "ID_FILME", nullable = false)
    private Long idFilme;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DIRETOR", nullable = false)
    private String diretor;

    @Column(name = "LOCADO", nullable = false)
    private LocacaoEnum locado;
}

