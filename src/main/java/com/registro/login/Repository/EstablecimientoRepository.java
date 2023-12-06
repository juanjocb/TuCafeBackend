package com.registro.login.Repository;

import com.registro.login.Entity.Establecimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Integer> {

    Optional<Establecimiento> findByUsername(String username);

}
