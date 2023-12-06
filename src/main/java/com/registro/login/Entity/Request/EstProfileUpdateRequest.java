package com.registro.login.Entity.Request;

import com.registro.login.Entity.Enum.Estado;
import com.registro.login.Entity.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstProfileUpdateRequest {
    String correo;
    String password;
    String descripcion;
    String direccion;
    String numeroTelefono;
    String ubicacion;
    String categoria;
    String horaApertura;
    String horaCierre;
}
