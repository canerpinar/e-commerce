package org.web.entity;

public class JwtResponse {
    String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken(){
        return this.token;
    }
}
