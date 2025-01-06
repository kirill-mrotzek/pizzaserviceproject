package org.telran.pizzaservice.de.security;

import org.telran.pizzaservice.de.security.model.JwtAuthenticationResponse;
import org.telran.pizzaservice.de.security.model.SignInRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse authenticate(SignInRequest request);
}
