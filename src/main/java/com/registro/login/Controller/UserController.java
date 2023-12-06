package com.registro.login.Controller;


import com.registro.login.Controller.Response.UserResponse;
import com.registro.login.Entity.Establecimiento;
import com.registro.login.Entity.Request.*;
import com.registro.login.Entity.User;
import com.registro.login.Service.AuthService;
import com.registro.login.Service.ProfileServiceUser;
import com.registro.login.Service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tuCafe/v1")
@RequiredArgsConstructor
public class UserController {
	
	private final AuthService authService;
	private final ReservaService reservaService;
	private final ProfileServiceUser profileServiceUser;


	@PostMapping("/reservar")
	public ResponseEntity<String> hacerReserva(@RequestBody ReservaRequest request){
		return ResponseEntity.ok(reservaService.hacerReserva(request));
	}
	
	@PostMapping(value = "loginU")
	public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(authService.login(request));
	}

	@PostMapping(value = "loginE")
	public ResponseEntity<UserResponse> loginEstablecimiento(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(authService.loginEstablecimiento(request));
	}
	
	@PostMapping(value = "registerU")
	public ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authService.registerUsuario(request));
	}

	@PostMapping(value = "registerE")
	public ResponseEntity<String> registerEstablecimiento(@RequestBody RegisterEstRequest requestEst ) {
		return authService.registerEstablecimiento(requestEst);
	}

	@GetMapping(value = "profile")
	public ResponseEntity<User>getProfileUser(){
		User profile = profileServiceUser.getProfUser();
		if (profile != null){
			return ResponseEntity.ok(profile);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@PutMapping(value = "updateProfile")
	public ResponseEntity<User> updateProfile(@RequestBody UserProfileUpdateRequest updateRequest) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			String username = authentication.getName();
			User updatedUser = profileServiceUser.updateProfileUser(username, updateRequest);

			if (updatedUser.getErrorMessage() != null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updatedUser);
			} else {
				return ResponseEntity.ok(updatedUser);
			}
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

}
