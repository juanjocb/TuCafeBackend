//package com.registro.login.Controller;
//
//import com.registro.login.Service.ReservaService;
//import lombok.RequiredArgsConstructor;
//import com.registro.login.Entity.Request.ReservaRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/tuCafe/v1")
//@RequiredArgsConstructor
//public class ReservaController {
//
//    private final ReservaService reservaService;
//
//    @PostMapping(value = "reservar")
//    public ResponseEntity<String> hacerReserva(@RequestParam ReservaRequest request){
//        return ResponseEntity.ok(reservaService.hacerReserva(request));
//    }
//}
