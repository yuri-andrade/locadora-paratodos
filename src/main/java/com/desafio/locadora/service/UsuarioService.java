package com.desafio.locadora.service;

import com.desafio.locadora.converter.UsuarioToUsuarioOutConverter;
import com.desafio.locadora.domain.out.UsuarioOut;
import com.desafio.locadora.entity.Usuario;
import com.desafio.locadora.exception.BusinessException;
import com.desafio.locadora.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioToUsuarioOutConverter usuarioToUsuarioOutConverter;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
            UsuarioToUsuarioOutConverter usuarioToUsuarioOutConverter, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioToUsuarioOutConverter = usuarioToUsuarioOutConverter;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public UsuarioOut save(Usuario usuario) {
        if (Objects.nonNull(loadUserByUsername(usuario.getUsername()))) {
            throw new BusinessException("E-mail já cadastrado");
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);

        return usuarioToUsuarioOutConverter.convert(usuario);
    }
}
