package com.desafio.locadora.service;

import com.desafio.locadora.domain.in.LocacaoIn;
import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.entity.Locacao;
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

    public LocacaoService(LocacaoRepository locacaoRepository, FilmeService filmeService) {
        this.locacaoRepository = locacaoRepository;
        this.filmeService = filmeService;
    }

    public Locacao findByidFilme(Long idFilme) {
        List<Locacao> lista = locacaoRepository.findByIdFilme(idFilme)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Locação com o filme de id '%d' não encontrada.", idFilme)));
        return lista.stream().filter(locacaos -> Objects.isNull(locacaos.getRetorno())).findAny()
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Locação em aberto com o filme de id '%d' não encontrada.", idFilme)));
    }

    public Locacao startLocacao(LocacaoIn locacaoIn) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = Objects.nonNull(authentication.getName()) ? authentication.getName() : null;
        if (Objects.nonNull(locacaoIn.getNomeFilme())) {
            Filme filme = filmeService.rentFilm(locacaoIn.getNomeFilme());
            Locacao locacao = Locacao.builder.idFilme(filme.getId()).usuario(currentUserName)
                    .emprestimo(LocalDateTime.now()).build();
            locacaoRepository.save(locacao);
            return locacao;
        } else {
            throw new BusinessException("O nome do filme deve ser informado");
        }
    }

    public Locacao endLocacao(LocacaoIn locacaoIn) {
        if (Objects.nonNull(locacaoIn.getIdFilme())) {
            Locacao locacao = findByidFilme(locacaoIn.getIdFilme());
            filmeService.returnFilm(locacaoIn.getIdFilme());
            locacao.setRetorno(LocalDateTime.now());
            locacaoRepository.save(locacao);
            return locacao;
        } else {
            throw new BusinessException("O id do filme deve ser informado");
        }
    }
}
