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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;
    private final FilmeService filmeService;
    private final FilmeToFilmeOutConverter filmeToFilmeOutConverter;

    public LocacaoService(LocacaoRepository locacaoRepository, FilmeService filmeService,
                          FilmeToFilmeOutConverter filmeToFilmeOutConverter) {
        this.locacaoRepository = locacaoRepository;
        this.filmeService = filmeService;
        this.filmeToFilmeOutConverter = filmeToFilmeOutConverter;
    }

    public Locacao findByidFilme(Long idFilme) {
        List<Locacao> lista = locacaoRepository.findByIdFilme(idFilme).orElseThrow(()
                -> new ResourceNotFoundException(
                String.format("Locação com o filme de id '%d' não encontrada.", idFilme)));
        return lista.stream().filter(locacaos -> Objects.isNull(locacaos.getRetorno())).findAny().orElseThrow(()
                -> new ResourceNotFoundException(String
                .format("Locação em aberto com o filme de id '%d' não encontrada.", idFilme)));
    }

    public FilmeOut rentFilm(Long idFilme) {
        Usuario usuario = new Usuario();
        usuario.setId(123);
        Filme filme = filmeService.findById(idFilme);
        if (filmeService.isAvailable(filme)) {
            filme.setLocado(LocacaoEnum.SIM);
            filmeService.save(filme);
            Locacao locacao = new Locacao(idFilme, usuario.getId(), LocalDateTime.now());
            locacaoRepository.save(locacao);
            return filmeToFilmeOutConverter.convert(filme);
        } else throw new BusinessException(String.format("O Filme %d, %s já está alugado", idFilme, filme.getNome()));
    }

    public FilmeOut returnFilm(Long idFilme) {
        Filme filme = filmeService.findById(idFilme);
        Locacao locacao = findByidFilme(idFilme);
        if (!filmeService.isAvailable(filme)) {
            filme.setLocado(LocacaoEnum.NAO);
            filmeService.save(filme);
            locacao.setRetorno(LocalDateTime.now());
            locacaoRepository.save(locacao);
            return filmeToFilmeOutConverter.convert(filme);
        } else throw new BusinessException(String.format("O Filme %d, %s não está alugado", idFilme, filme.getNome()));
    }
}
