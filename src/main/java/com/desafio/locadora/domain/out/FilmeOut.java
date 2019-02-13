package com.desafio.locadora.domain.out;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class FilmeOut {

    @ApiModelProperty(notes = "Nome do filme")
    private String nome;

    @ApiModelProperty(notes = "Nome do diretor do filme")
    private String diretor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FilmeOut filmeOut = (FilmeOut) o;
        return Objects.equals(nome, filmeOut.nome)
                && Objects.equals(diretor, filmeOut.diretor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, diretor);
    }
}
