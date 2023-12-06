package com.registro.login.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="RESERVA",uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Reserva implements UserDetails {

    @Id
    @GeneratedValue
    Integer id;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    User usuario;
    @ManyToOne
    @JoinColumn(name = "id_establecimiento", nullable = false)
    Establecimiento establecimiento;
    @Column(nullable = false)
    String horaReserva;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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
}
