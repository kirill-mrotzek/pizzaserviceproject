package org.telran.pizzaservice.de.security.model;

public class JwtAuthenticationResponse {

    private String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public JwtAuthenticationResponse() {
        //
    }

    public void setToken(String token) {
        this.token = token;
    }
}
