package org.telran.pizzaservice.de.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.telran.pizzaservice.de.entity.User;
import org.telran.pizzaservice.de.exception.UserNotFoundException;
import org.telran.pizzaservice.de.repository.UserJpaRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User create(User user) {
        User newUser = userJpaRepository.save(user);
        log.info("Successfully created user " + newUser);
        return userJpaRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userJpaRepository.findAll();
    }


    @Override
    public User getById(Long id) {
       return userJpaRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));

    }

    @Override
    public User getByName(String name) {
        return userJpaRepository.findByName(name)
                .orElseThrow(() -> new UserNotFoundException("User with name " + name + " not found"));

    }

    @Override
    public List<User> getWithEqualsPassword(String password) {
        return userJpaRepository.findAllByPassword(password);
    }

    @Override
    public String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //получаем данные идентификации из контекста
        if (authentication != null) { //если данные аутентификации не равны null (т.е. пользователь идентифицирован)
            return authentication.getName(); //возвращает имя текущего пользователя, который сейчас авторизован
        }
        return null;
    }

    @Override
    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String name = authentication.getName();
            User userEntity = getByName(name);
            return userEntity.getId();
        }
        return null;
    }

    @Override
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
