package com.desafio.locadora.converter;

import com.desafio.locadora.domain.out.LocacaoOut;
import com.desafio.locadora.entity.Locacao;
import com.desafio.locadora.utils.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LocacaoToLocacaoOutConverter implements Converter<Locacao, LocacaoOut> {
    private final ModelMapperUtils modelMapperUtils;

    public LocacaoToLocacaoOutConverter(ModelMapperUtils modelMapperUtils) {
        this.modelMapperUtils = modelMapperUtils;
    }

    @Override
    public LocacaoOut convert(Locacao locacao) {
        return modelMapperUtils.map(locacao, LocacaoOut.class);
    }
}