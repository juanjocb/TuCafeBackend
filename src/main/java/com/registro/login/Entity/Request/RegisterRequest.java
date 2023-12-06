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
public class RegisterRequest {
	String username;
	String correo;
	Role role;
	String password;
}
