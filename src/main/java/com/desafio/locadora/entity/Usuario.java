package com.desafio.locadora.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "TA_USUARIO")
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

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

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
