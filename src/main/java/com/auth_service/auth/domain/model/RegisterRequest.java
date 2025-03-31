package com.auth_service.auth.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private String idDocument;

}
