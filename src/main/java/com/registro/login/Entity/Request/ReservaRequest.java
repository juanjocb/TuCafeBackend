package com.registro.login.Entity.Request;

import com.registro.login.Entity.Establecimiento;
import com.registro.login.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaRequest {
    Integer id_usuario;
    Integer id_establecimiento;
    String horaReserva;
}
