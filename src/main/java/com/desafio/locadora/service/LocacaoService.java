package com.desafio.locadora.service;

import com.desafio.locadora.domain.in.LocacaoIn;
import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.entity.Locacao;
import com.desafio.locadora.exception.BusinessException;
import com.desafio.locadora.exception.ResourceNotFoundException;
import com.desafio.locadora.repository.LocacaoRepository;
import com.desafio.locadora.utils.MessagesUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;
    private final FilmeService filmeService;
    private final MessagesUtils messagesUtils;

    public LocacaoService(LocacaoRepository locacaoRepository, FilmeService filmeService, MessagesUtils messagesUtils) {
        this.locacaoRepository = locacaoRepository;
        this.filmeService = filmeService;
        this.messagesUtils = messagesUtils;
    }

    public Locacao findByidFilme(Long idFilme) {
        Supplier<ResourceNotFoundException> resourceNotFoundExceptionSupplier = () ->
                new ResourceNotFoundException(messagesUtils.getMessage("locacao.nao.encontrada.id", idFilme));

        List<Locacao> lista = locacaoRepository.findByIdFilme(idFilme)
                .orElseThrow(resourceNotFoundExceptionSupplier);
        return lista.stream().filter(locacoes -> Objects.isNull(locacoes.getDataRetorno())).findAny()
                .orElseThrow(resourceNotFoundExceptionSupplier);
    }

    public Locacao startLocacao(LocacaoIn locacaoIn) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = Objects.nonNull(authentication.getName()) ? authentication.getName() : null;
        if (Objects.nonNull(locacaoIn.getNomeFilme())) {
            Filme filme = filmeService.rentFilm(locacaoIn.getNomeFilme());
            Locacao locacao = Locacao.builder().idFilme(filme.getIdFilme()).usuario(currentUserName)
                    .dataEmprestimo((LocalDateTime.now())).filme(filme).build();
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
            locacao.setDataRetorno(LocalDateTime.now());
            locacaoRepository.save(locacao);
            return locacao;
        } else {
            throw new BusinessException("O id do filme deve ser informado");
        }
    }
}
