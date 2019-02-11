package com.desafio.locadora.converter;

import com.desafio.locadora.domain.out.LocacaoOut;
import com.desafio.locadora.entity.Locacao;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LocacaoToLocacaoOutConverter implements Converter<Locacao, LocacaoOut> {
    private final ModelMapper modelMapper;

    public LocacaoToLocacaoOutConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LocacaoOut convert(Locacao locacao) {
        LocacaoOut locacaoOut = modelMapper.map(locacao, LocacaoOut.class);
        if (Objects.isNull(locacaoOut)) {
            throw new IllegalArgumentException("Objeto Locacao não pode ser convertido em LocacaoOut");
        }
        return locacaoOut;
    }
}
