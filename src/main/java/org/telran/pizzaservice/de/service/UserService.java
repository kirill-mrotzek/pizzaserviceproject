package org.telran.pizzaservice.de.service;

import org.telran.pizzaservice.de.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(Long id);

    List<User> getAll();

    User getById(Long id);

    User getByName(String name);

    List<User> getWithEqualsPassword(String password);

    String getCurrentUserName();

    Long getCurrentUserId();

    User getCurrentUser();
}
