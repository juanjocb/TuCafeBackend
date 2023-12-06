package com.registro.login.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.registro.login.Entity.Enum.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "ESTABLECIMIENTO", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})

public class Establecimiento implements UserDetails {
    @Id
    @GeneratedValue
    Integer id;
    @Column(nullable = false)
    String username;
    String password;
    String correo;
    @Enumerated(EnumType.STRING)
    Role role;
    String descripcion;
    String direccion;
    String numeroTelefono;
    String ubicacion;
    boolean estado;
    String categoria;
    String horaApertura;
    String horaCierre;

    @JsonIgnore
    private String errorMessage;

    public Establecimiento (String errorMessage){
        this.errorMessage = errorMessage;
    }


    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
