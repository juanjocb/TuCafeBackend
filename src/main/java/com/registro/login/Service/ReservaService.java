package com.registro.login.Service;

import com.registro.login.Entity.Establecimiento;
import com.registro.login.Entity.Request.ReservaRequest;
import com.registro.login.Entity.Reserva;
import com.registro.login.Entity.User;
import com.registro.login.Repository.EstablecimientoRepository;
import com.registro.login.Repository.ReservaRepository;
import com.registro.login.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final UserRepository userRepository;
    private final EstablecimientoRepository establecimientoRepository;
    public String hacerReserva(ReservaRequest request) {
        User usuario = userRepository.findById(request.getId_usuario()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Establecimiento establecimiento = establecimientoRepository.findById(request.getId_establecimiento()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Reserva reserva = Reserva.builder()
                .usuario(usuario)
                .establecimiento(establecimiento)
                .horaReserva(request.getHoraReserva())
                .build();
        reservaRepository.save(reserva);
        return "Reserva Realizada con EXITO";
    }
}
