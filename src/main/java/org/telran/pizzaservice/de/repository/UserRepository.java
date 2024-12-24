package org.telran.pizzaservice.de.repository;

import org.telran.pizzaservice.de.entity.User;

import java.util.List;

public interface UserRepository {

    User create(User user);

    void delete(String login);

    List<User> getAll();
}
