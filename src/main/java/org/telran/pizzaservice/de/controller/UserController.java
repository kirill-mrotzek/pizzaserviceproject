package org.telran.pizzaservice.de.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.AbstractController;
import org.telran.pizzaservice.de.converter.Converter;
import org.telran.pizzaservice.de.dto.UserCreateDto;
import org.telran.pizzaservice.de.dto.UserResponseDto;
import org.telran.pizzaservice.de.entity.User;
import org.telran.pizzaservice.de.security.AuthenticationService;
import org.telran.pizzaservice.de.security.model.JwtAuthenticationResponse;
import org.telran.pizzaservice.de.security.model.SignInRequest;
import org.telran.pizzaservice.de.service.UserService;

import java.util.List;


//http://localhost:8080

@RestController
@RequestMapping("/api/users") // http://localhost:8080/api/users
public class UserController extends UserAbstractController {

    @Autowired
    private UserService userService;

    @Autowired
    private Converter<User, UserCreateDto, UserResponseDto> createConverter;

    @Autowired
    private View error;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authenticationService;



    @PostMapping
    public UserResponseDto create(@RequestBody @Valid UserCreateDto userDto) {
        User user = createConverter.toEntity(userDto);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userFromDataBase = userService.create(user);
        UserResponseDto dto = createConverter.toDto(userFromDataBase);
        return dto;
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody SignInRequest request) {
        return authenticationService.authenticate(request);
    }

    @Override
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/search")
    public User getByName(@RequestParam(name = "name") String name) {
        return userService.getByName(name);
    }

    @PostMapping("/equals_password")
    public List<User> getWithEqualsPassword(@RequestBody String password) {
        return userService.getWithEqualsPassword(password);
    }

}


