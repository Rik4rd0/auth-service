package com.auth_service.auth.infraestructure.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.auth.domain.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/Form")
    public ResponseEntity<Map<String, String>> saveUser() {
        return ResponseEntity.ok(userService.getForm());
    }

}
