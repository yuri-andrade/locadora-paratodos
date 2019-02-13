package com.desafio.locadora.service;

import com.desafio.locadora.converter.UsuarioToUsuarioOutConverter;
import com.desafio.locadora.domain.out.UsuarioOut;
import com.desafio.locadora.entity.Usuario;
import com.desafio.locadora.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioToUsuarioOutConverter usuarioToUsuarioOutConverter;

    public UsuarioService(UsuarioRepository usuarioRepository,
            UsuarioToUsuarioOutConverter usuarioToUsuarioOutConverter) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioToUsuarioOutConverter = usuarioToUsuarioOutConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public UsuarioOut save(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuarioToUsuarioOutConverter.convert(usuario);
    }
}
