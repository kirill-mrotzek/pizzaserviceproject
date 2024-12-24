package org.telran.pizzaservice.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.Pizzeria;
import org.telran.pizzaservice.de.entity.User;
import org.telran.pizzaservice.de.repository.PizzeriaRepository;
import org.telran.pizzaservice.de.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private PizzeriaRepository pizzeriaRepository;

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public void delete(String login) {
        userRepository.delete(login);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public List<Pizzeria> getAllPizzerias() {
        return pizzeriaRepository.getAllPizzerias();
    }
}
