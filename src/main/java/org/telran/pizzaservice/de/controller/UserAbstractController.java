package org.telran.pizzaservice.de.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.telran.pizzaservice.de.entity.User;

import java.util.List;

public abstract class UserAbstractController {

    @Operation(summary = "Get all users", description = "Get all users in system"
            , security = @SecurityRequirement(name = "swagger-ui"))
    @ApiResponse(responseCode = "200", description = "Successfully executed")
    public abstract List<User> getAll();
}


