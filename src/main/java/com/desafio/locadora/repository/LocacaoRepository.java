package com.desafio.locadora.repository;

import com.desafio.locadora.entity.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    Optional<List<Locacao>> findByIdFilme(Long idFilme);

}
