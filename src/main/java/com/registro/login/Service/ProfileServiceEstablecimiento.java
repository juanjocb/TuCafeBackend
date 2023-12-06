package com.registro.login.Service;

import com.registro.login.Entity.Establecimiento;
import com.registro.login.Entity.Request.EstProfileUpdateRequest;
import com.registro.login.Entity.Request.UserProfileUpdateRequest;
import com.registro.login.Entity.User;
import com.registro.login.Repository.EstablecimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceEstablecimiento {

    private final EstablecimientoRepository establecimientoRepository;



    public Establecimiento getProfEst() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String username = authentication.getName();
            return establecimientoRepository.findByUsername(username).orElse(null);
        }
        return null;
    }

    public Establecimiento updateProfileEst(String username, EstProfileUpdateRequest updateRequest) {
        Establecimiento establecimiento = establecimientoRepository.findByUsername(username).orElse(null);

        if (establecimiento != null) {
            if (updateRequest.getCorreo() != null) {
                establecimiento.setCorreo(updateRequest.getCorreo());
            }

            if (updateRequest.getPassword() != null) {
                establecimiento.setPassword(updateRequest.getPassword());
            }
            if (updateRequest.getCategoria() != null) {
                establecimiento.setCategoria(updateRequest.getCategoria());
            }
            if (updateRequest.getDireccion() != null) {
                establecimiento.setDescripcion(updateRequest.getDireccion());
            }
            if (updateRequest.getDescripcion() != null) {
                establecimiento.setDescripcion(updateRequest.getDescripcion());
            }
            if (updateRequest.getUbicacion() != null) {
                establecimiento.setUbicacion(updateRequest.getUbicacion());
            }
            if (updateRequest.getHoraApertura() != null) {
                establecimiento.setHoraApertura(updateRequest.getHoraApertura());
            }
            if (updateRequest.getHoraCierre() != null) {
                establecimiento.setHoraCierre(updateRequest.getHoraCierre());
            }
            if (updateRequest.getNumeroTelefono() != null) {
                establecimiento.setNumeroTelefono(updateRequest.getNumeroTelefono());
            }
            establecimientoRepository.save(establecimiento);

            return establecimiento;
        } else {
            return new Establecimiento("Establecimiento no encontrado");
        }
    }
}
