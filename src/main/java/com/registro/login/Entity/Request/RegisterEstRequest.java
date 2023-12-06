package com.registro.login.Entity.Request;

import com.registro.login.Entity.Enum.Estado;
import com.registro.login.Entity.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEstRequest{
    String username;
    String correo;
    Role role;
    String password;
    String descripcion;
    String direccion;
    String numeroTelefono;
    String ubicacion;
    Estado estado;
    String categoria;
    String horaApertura;
    String horaCierre;
}
