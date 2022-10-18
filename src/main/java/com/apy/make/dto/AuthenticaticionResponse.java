package com.apy.make.dto;

public class AuthenticaticionResponse {
    private String jwt;

    public AuthenticaticionResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
