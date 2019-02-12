package com.desafio.locadora.converter;

import com.desafio.locadora.domain.out.UsuarioOut;
import com.desafio.locadora.entity.Usuario;
import com.desafio.locadora.utils.ModelMapperUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsuarioToUsuarioOut implements Converter<Usuario, UsuarioOut> {
    private final ModelMapperUtils modelMapperUtils;

    public UsuarioToUsuarioOut(ModelMapperUtils modelMapperUtils) {
        this.modelMapperUtils = modelMapperUtils;
    }

    @Override
    public UsuarioOut convert(Usuario usuario) {
        return modelMapperUtils.map(usuario, UsuarioOut.class);
    }
}
