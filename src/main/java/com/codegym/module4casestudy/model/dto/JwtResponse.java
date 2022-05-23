package com.codegym.module4casestudy.model.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
@Data
public class JwtResponse {
    private Long id;
    private String token; //jwt
    private String type = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String accessToken, Long id, String username, Collection<? extends GrantedAuthority> roles) {
        this.token = accessToken;
        this.username = username;
        this.roles = roles;
        this.id = id;
    }
}