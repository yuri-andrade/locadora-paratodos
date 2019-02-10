package com.desafio.locadora.converter;

import com.desafio.locadora.domain.out.FilmeOut;
import com.desafio.locadora.entity.Filme;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<FilmeOut> filmeOut = new ArrayList<>();
        for (Filme f : filmes) {
            filmeOut.add(convert(f));
        }
        return filmeOut;
    }
}
