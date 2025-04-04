package com.auth_service.auth.infraestructure.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.auth.config.SecurityConfig.AuthenticationService;
import com.auth_service.auth.domain.model.AuthenticationRequest;
import com.auth_service.auth.domain.model.AuthenticationResponse;
import com.auth_service.auth.domain.model.RegisterRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AutenticateController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
       log.info("intentando aunteticar: ", request.getEmail());
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest) {
        log.info("me estoy registrando",registerRequest);
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
}
