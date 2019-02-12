package com.desafio.locadora.service;

import com.desafio.locadora.converter.LocacaoToLocacaoOutConverter;
import com.desafio.locadora.domain.out.LocacaoOut;
import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.entity.Locacao;
import com.desafio.locadora.entity.enums.LocacaoEnum;
import com.desafio.locadora.exception.BusinessException;
import com.desafio.locadora.exception.ResourceNotFoundException;
import com.desafio.locadora.repository.LocacaoRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;
    private final FilmeService filmeService;
    private final LocacaoToLocacaoOutConverter locacaoToLocacaoOutConverter;

    public LocacaoService(LocacaoRepository locacaoRepository, FilmeService filmeService,
                          LocacaoToLocacaoOutConverter locacaoToLocacaoOutConverter) {
        this.locacaoRepository = locacaoRepository;
        this.filmeService = filmeService;
        this.locacaoToLocacaoOutConverter = locacaoToLocacaoOutConverter;
    }

    public Locacao findByidFilme(Long idFilme) {
        List<Locacao> lista = locacaoRepository.findByIdFilme(idFilme).orElseThrow(()
                -> new ResourceNotFoundException(
                String.format("Locação com o filme de id '%d' não encontrada.", idFilme)));
        return lista.stream().filter(locacaos -> Objects.isNull(locacaos.getRetorno())).findAny().orElseThrow(()
                -> new ResourceNotFoundException(String
                .format("Locação em aberto com o filme de id '%d' não encontrada.", idFilme)));
    }

    public LocacaoOut rentFilm(Long idFilme) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = Objects.nonNull(authentication.getName()) ? authentication.getName() : null;

        Filme filme = filmeService.findById(idFilme);
        if (filmeService.isAvailable(filme)) {
            filme.setLocado(LocacaoEnum.SIM);
            filmeService.save(filme);
            Locacao locacao = new Locacao(idFilme, currentUserName, LocalDateTime.now());
            locacaoRepository.save(locacao);
            return locacaoToLocacaoOutConverter.convert(locacao);
        } else throw new BusinessException(String.format("O Filme %d, %s já está alugado", idFilme, filme.getNome()));
    }

    public LocacaoOut returnFilm(Long idFilme) {
        Filme filme = filmeService.findById(idFilme);
        Locacao locacao = findByidFilme(idFilme);
        if (!filmeService.isAvailable(filme)) {
            filme.setLocado(LocacaoEnum.NAO);
            filmeService.save(filme);
            locacao.setRetorno(LocalDateTime.now());
            locacaoRepository.save(locacao);
            return locacaoToLocacaoOutConverter.convert(locacao);
        } else throw new BusinessException(String.format("O Filme %d, %s não está alugado", idFilme, filme.getNome()));
    }
}
