package org.telran.pizzaservice.de.repository;

import org.springframework.stereotype.Component;
import org.telran.pizzaservice.de.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserInMemoryRepository implements UserRepository {

    private Map<String, User> storage = new HashMap<>();

    public UserInMemoryRepository() {
        init();
    }

    private void init() {
        User user1 = new User("login1", "password1", "Name1", "Surname1", "email1@example.com");
        User user2 = new User("login2", "password2", "Name2", "Surname2", "email2@example.com");
        User user3 = new User("login3", "password3", "Name3", "Surname3", "email3@example.com");
        storage.put(user1.getLogin(), user1);
        storage.put(user2.getLogin(), user2);
        storage.put(user3.getLogin(), user3);
    }

    @Override
    public User create(User user) {
        new User(user.getLogin(), user.getPassword(), user.getName(), user.getSurname(), user.getEmail());
        storage.put(user.getLogin(), user);
        return user;
    }

    @Override
    public void delete(String login) {
        storage.remove(login);
    }

    @Override
    public List<User> getAll() {
        return storage.values().stream().toList();
    }
}
