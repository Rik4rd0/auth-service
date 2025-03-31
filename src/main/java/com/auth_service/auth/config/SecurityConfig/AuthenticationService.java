package com.auth_service.auth.config.SecurityConfig;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth_service.auth.config.jwt.JwtService;
import com.auth_service.auth.domain.model.AuthenticationRequest;
import com.auth_service.auth.domain.model.AuthenticationResponse;
import com.auth_service.auth.domain.model.RegisterRequest;
import com.auth_service.auth.infraestructure.adapters.postgreSQL.model.RoleEnum;
import com.auth_service.auth.infraestructure.adapters.postgreSQL.model.UserEntity;
import com.auth_service.auth.infraestructure.adapters.postgreSQL.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generate(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        UserEntity user = UserEntity.builder()
                .name(registerRequest.getName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .idDocument(registerRequest.getIdDocument())
                .id(registerRequest.getId())
                .roleEnum(RoleEnum.USER).build();

        repository.save(user);

        return AuthenticationResponse.builder()
                .token(jwtService.generate(user))
                .build();

    }
}
