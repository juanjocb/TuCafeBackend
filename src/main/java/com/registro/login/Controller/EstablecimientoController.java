package com.registro.login.Controller;


import com.registro.login.Entity.Establecimiento;
import com.registro.login.Entity.Request.EstProfileUpdateRequest;
import com.registro.login.Entity.Request.UserProfileUpdateRequest;
import com.registro.login.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.registro.login.Service.ProfileServiceEstablecimiento;

@RestController
@RequestMapping("/tuCafe/v1/")
@RequiredArgsConstructor
public class EstablecimientoController {

    private final  ProfileServiceEstablecimiento profileServiceEstablecimiento;

    @GetMapping(value = "profileEst")
    public ResponseEntity<Establecimiento> getProfileEst(){
        Establecimiento profile = profileServiceEstablecimiento.getProfEst();
        if (profile != null){
            return ResponseEntity.ok(profile);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping(value = "updateProfileEst")
    public ResponseEntity<Establecimiento> updateProfileEst(@RequestBody EstProfileUpdateRequest updateRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String username = authentication.getName();
            Establecimiento updatedEst = profileServiceEstablecimiento.updateProfileEst(username, updateRequest);

            if (updatedEst.getErrorMessage() != null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updatedEst);
            } else {
                return ResponseEntity.ok(updatedEst);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


}
