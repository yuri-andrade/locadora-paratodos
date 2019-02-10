package com.desafio.locadora.service;

import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.entity.enums.LocacaoEnum;
import com.desafio.locadora.exception.BusinessException;
import com.desafio.locadora.exception.ResourceNotFoundException;
import com.desafio.locadora.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> findByNome(String nome) {
        return filmeRepository.findByNome(nome).orElseThrow(()
                -> new ResourceNotFoundException(String.format("Filme com o nome '%s' não encontrado.", nome)));
    }

    public Filme findById(Long id) {
        return filmeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException(String.format("Filme com o id %d não encontrado.", id)));
    }

    public List<Filme> findAllAvailable() {
        return filmeRepository.findAll().stream().filter(filme -> LocacaoEnum.NAO.equals(filme.getLocado()))
                .collect(Collectors.toList());
    }

    public Filme rentFilm(Long id) {
        Filme filme = findById(id);
        if (Objects.equals(LocacaoEnum.NAO, filme.getLocado())) {
            filme.setLocado(LocacaoEnum.SIM);
            return filmeRepository.save(filme);
        } else throw new BusinessException(String.format("O Filme %d, %s já está alugado", id, filme.getNome()));
    }

    public Filme returnFilm(Long id) {
        Filme filme = findById(id);
        if (Objects.equals(LocacaoEnum.SIM, filme.getLocado())) {
            filme.setLocado(LocacaoEnum.NAO);
            return filmeRepository.save(filme);
        } else throw new BusinessException(String.format("O Filme %d, %s não está alugado", id, filme.getNome()));
    }
}
