package com.desafio.locadora.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "TA_USUARIO")
@Data
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name = "ID_USER", nullable = false)
    private Long idUser;

    @Column(name = "USERNAME", nullable = false)
    @Email
    private String username;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }
}
