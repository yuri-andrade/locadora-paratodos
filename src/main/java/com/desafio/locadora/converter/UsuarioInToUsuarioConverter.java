package com.desafio.locadora.converter;

import com.desafio.locadora.domain.in.UsuarioIn;
import com.desafio.locadora.entity.Usuario;
import com.desafio.locadora.utils.ModelMapperUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInToUsuarioConverter implements Converter<UsuarioIn, Usuario> {
    private final ModelMapperUtils modelMapperUtils;

    public UsuarioInToUsuarioConverter(ModelMapperUtils modelMapperUtils) {
        this.modelMapperUtils = modelMapperUtils;
    }


    @Override
    public Usuario convert(UsuarioIn usuarioIn) {
        return modelMapperUtils.map(usuarioIn, Usuario.class);
    }
}
