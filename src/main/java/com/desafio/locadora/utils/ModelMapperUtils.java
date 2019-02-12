package com.desafio.locadora.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ModelMapperUtils {

    private final ModelMapper modelMapper;

    public ModelMapperUtils(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D> D map(Object source, Class<D> destinationType) {
        Assert.notNull(source, "Objeto de origem não pode ser nulo");
        Assert.notNull(destinationType, "Tipo do objeto de destino não pode ser nulo");
        return Optional.of(modelMapper.map(source, destinationType))
                .orElseThrow(() -> new IllegalArgumentException("Objeto não pode ser convertido"));
    }

    public <D, C> List<D> mapList(List<C> sourceList, Class<D> destinationType) {
        Assert.notEmpty(sourceList, "A lista não pode estar vazia");
        return sourceList.parallelStream().map(o -> this.map(o, destinationType)).collect(Collectors.toList());
    }
}