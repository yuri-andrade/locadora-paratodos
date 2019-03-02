package com.desafio.locadora.service;

import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.entity.enums.LocacaoEnum;
import com.desafio.locadora.exception.BusinessException;
import com.desafio.locadora.exception.ResourceNotFoundException;
import com.desafio.locadora.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> findByNome(String nome) {
        return filmeRepository.findByNome(nome)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Filme com o nome '%s' não encontrado.", nome)));
    }

    public Filme findById(Long id) {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Filme com o id %d não encontrado.", id)));
    }

    public Set<Filme> findAllAvailable() {
        return new HashSet<>(filmeRepository.findAllByLocado(LocacaoEnum.NAO)
                .orElseThrow(() -> new BusinessException("Nenhum filme disponível")));
    }


    public Boolean isAvailable(Filme filme) {
        return Objects.equals(LocacaoEnum.NAO, filme.getLocado());
    }

    public Long rentFilm(String nomeFilme) {
        Filme filme = findByNome(nomeFilme).stream().filter(this::isAvailable).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Filme '%s' não disponível.", nomeFilme)));
        filme.setLocado(LocacaoEnum.SIM);
        filmeRepository.save(filme);
        return filme.getId();
    }

    public void returnFilm(Long idFilme) {
        Filme filme = findById(idFilme);
        if (!isAvailable(filme)) {
            filme.setLocado(LocacaoEnum.NAO);
            filmeRepository.save(filme);
        } else {
            throw new BusinessException(String.format("O Filme %d, %s não está alugado",
                    idFilme, filme.getNome()));
        }
    }
}
