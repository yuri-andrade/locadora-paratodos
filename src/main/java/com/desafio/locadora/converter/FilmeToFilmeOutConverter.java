package com.desafio.locadora.converter;

import com.desafio.locadora.domain.out.FilmeOut;
import com.desafio.locadora.entity.Filme;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class FilmeToFilmeOutConverter implements Converter<Filme, FilmeOut> {
    private final ModelMapper modelMapper;

    public FilmeToFilmeOutConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public FilmeOut convert(Filme filme) {
        FilmeOut filmeOut = modelMapper.map(filme, FilmeOut.class);
        if (Objects.isNull(filmeOut)) {
            throw new IllegalArgumentException("Objeto Filme não pode ser convertido em FilmeOut");
        }
        return filmeOut;
    }

    public List<FilmeOut> convertList(List<Filme> filmes) {
        if (Objects.isNull(filmes)) {
            throw new IllegalArgumentException("Lista de Filme não pode ser convertido em Lista de FilmeOut");
        }
        return filmes.parallelStream().map(this::convert).collect(Collectors.toList());
    }
}
