package org.telran.pizzaservice.de.service;

import org.telran.pizzaservice.de.entity.Pizzeria;
import org.telran.pizzaservice.de.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(String login);

    List<User> getAll();

    List<Pizzeria> getAllPizzerias();
}
