package com.desafio.locadora.service;

import com.desafio.locadora.converter.FilmeToFilmeOutConverter;
import com.desafio.locadora.domain.out.FilmeOut;
import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.entity.enums.LocacaoEnum;
import com.desafio.locadora.exception.ResourceNotFoundException;
import com.desafio.locadora.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;
    private final FilmeToFilmeOutConverter filmeToFilmeOutConverter;

    public FilmeService(FilmeRepository filmeRepository, FilmeToFilmeOutConverter filmeToFilmeOutConverter) {
        this.filmeRepository = filmeRepository;
        this.filmeToFilmeOutConverter = filmeToFilmeOutConverter;
    }

    public List<FilmeOut> findByNome(String nome) {
        return filmeToFilmeOutConverter.convertList(filmeRepository.findByNome(nome).orElseThrow(()
                -> new ResourceNotFoundException(String.format("Filme com o nome '%s' não encontrado.", nome))));
    }

    public Filme findById(Long id) {
        return filmeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException(String.format("Filme com o id %d não encontrado.", id)));
    }

    public List<FilmeOut> findAllAvailable() {
        return filmeToFilmeOutConverter.convertList(filmeRepository.findAll().stream().filter(filme -> LocacaoEnum.NAO.equals(filme.getLocado()))
                .collect(Collectors.toList()));
    }

    public void save(Filme filme) {
        filmeRepository.save(filme);
    }

}
