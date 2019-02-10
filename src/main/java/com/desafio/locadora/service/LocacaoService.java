package com.desafio.locadora.service;

import com.desafio.locadora.converter.FilmeToFilmeOutConverter;
import com.desafio.locadora.domain.out.FilmeOut;
import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.entity.Locacao;
import com.desafio.locadora.entity.Usuario;
import com.desafio.locadora.entity.enums.LocacaoEnum;
import com.desafio.locadora.exception.BusinessException;
import com.desafio.locadora.exception.ResourceNotFoundException;
import com.desafio.locadora.repository.LocacaoRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;
    private final FilmeService filmeService;
    private final FilmeToFilmeOutConverter filmeToFilmeOutConverter;

    public LocacaoService(LocacaoRepository locacaoRepository, FilmeService filmeService, FilmeToFilmeOutConverter filmeToFilmeOutConverter) {
        this.locacaoRepository = locacaoRepository;
        this.filmeService = filmeService;
        this.filmeToFilmeOutConverter = filmeToFilmeOutConverter;
    }

    public Locacao findByidFilme(Long idFilme) {
        return locacaoRepository.findByIdFilme(idFilme).orElseThrow(()
                -> new ResourceNotFoundException(
                String.format("Locação com o filme de id '%d' não encontrada.", idFilme)));
    }

    public FilmeOut rentFilm(Long idFilme) {
        Usuario usuario = new Usuario();
        usuario.setId(123);
        Filme filme = filmeService.findById(idFilme);
        if (Objects.equals(LocacaoEnum.NAO, filme.getLocado())) {
            filme.setLocado(LocacaoEnum.SIM);
            filmeService.save(filme);
            Locacao locacao = new Locacao(idFilme, usuario.getId());
            locacaoRepository.save(locacao);
            return filmeToFilmeOutConverter.convert(filme);
        } else throw new BusinessException(String.format("O Filme %d, %s já está alugado", idFilme, filme.getNome()));
    }

    public FilmeOut returnFilm(Long idFilme) {
        Filme filme = filmeService.findById(idFilme);
        Locacao locacao = findByidFilme(idFilme);
        if (Objects.equals(LocacaoEnum.SIM, filme.getLocado())) {
            filme.setLocado(LocacaoEnum.NAO);
            filmeService.save(filme);
            locacaoRepository.deleteById(locacao.getId());
            return filmeToFilmeOutConverter.convert(filme);
        } else throw new BusinessException(String.format("O Filme %d, %s não está alugado", idFilme, filme.getNome()));
    }
}
