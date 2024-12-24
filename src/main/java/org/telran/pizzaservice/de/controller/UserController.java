package org.telran.pizzaservice.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.pizzaservice.de.entity.User;
import org.telran.pizzaservice.de.service.UserService;

import java.util.List;

//http://localhost:8080

@RestController
@RequestMapping("/api/users") // http://localhost:8080/api/users
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create (@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{login}")
    public void delete (@PathVariable(name = "login") String login) {
        userService.delete(login);
    }
}
