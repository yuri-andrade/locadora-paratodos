package com.desafio.locadora.repository;

import com.desafio.locadora.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    Optional<List<Filme>> findByNome(String nome);
}

