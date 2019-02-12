package com.desafio.locadora.converter;

import com.desafio.locadora.domain.out.FilmeOut;
import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.utils.ModelMapperUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmeToFilmeOutConverter implements Converter<Filme, FilmeOut> {
    private final ModelMapperUtils modelMapperUtils;

    public FilmeToFilmeOutConverter(ModelMapperUtils modelMapperUtils) {
        this.modelMapperUtils = modelMapperUtils;
    }

    @Override
    public FilmeOut convert(Filme filme) {
        return modelMapperUtils.map(filme, FilmeOut.class);
    }

    public List<FilmeOut> convertList(List<Filme> filmes) {
        return modelMapperUtils.mapList(filmes, FilmeOut.class);
    }
}
