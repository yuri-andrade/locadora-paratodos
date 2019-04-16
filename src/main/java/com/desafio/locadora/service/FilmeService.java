package com.desafio.locadora.service;

import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.entity.enums.LocacaoEnum;
import com.desafio.locadora.exception.BusinessException;
import com.desafio.locadora.exception.ResourceNotFoundException;
import com.desafio.locadora.repository.FilmeRepository;
import com.desafio.locadora.utils.MessagesUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;
    private final MessagesUtils messagesUtils;

    public FilmeService(FilmeRepository filmeRepository, MessagesUtils messagesUtils) {
        this.filmeRepository = filmeRepository;
        this.messagesUtils = messagesUtils;
    }

    public List<Filme> findByNome(String nome) {
        return filmeRepository.findByNome(nome)
                .orElseThrow(() -> new ResourceNotFoundException(messagesUtils.getMessage(
                        "filme.nao.encontrado.nome", nome)));
    }

    public Filme findById(Long id) {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(messagesUtils.getMessage(
                        "filme.nao.encontrado.id", id)));
    }

    public Set<Filme> findAllAvailable() {
        return new HashSet<>(filmeRepository.findAllByLocado(LocacaoEnum.NAO)
                .orElseThrow(() -> new BusinessException("Nenhum filme disponível")));
    }


    public Boolean isAvailable(Filme filme) {
        return Objects.equals(LocacaoEnum.NAO, filme.getLocado());
    }

    public Filme getAvailableFilm(String nomeFilme) {
        return findByNome(nomeFilme).stream().filter(this::isAvailable).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(messagesUtils
                        .getMessage("filme.nao.disponivel", nomeFilme)));
    }

    public Filme rentFilm(String nomeFilme) {
        Filme filme = getAvailableFilm(nomeFilme);
        filme.setLocado(LocacaoEnum.SIM);
        filmeRepository.save(filme);
        return filme;
    }

    public void returnFilm(Long idFilme) {
        Filme filme = findById(idFilme);
        if (!isAvailable(filme)) {
            filme.setLocado(LocacaoEnum.NAO);
            filmeRepository.save(filme);
        } else {
            throw new BusinessException(messagesUtils.getMessage("filme.nao.alugado", idFilme, filme.getNome()));
        }
    }
}
