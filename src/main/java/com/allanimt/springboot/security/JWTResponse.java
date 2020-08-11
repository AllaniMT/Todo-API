package com.allanimt.springboot.security;

public class JWTResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JWTResponse(String token) {
        this.token = token;
    }
}
