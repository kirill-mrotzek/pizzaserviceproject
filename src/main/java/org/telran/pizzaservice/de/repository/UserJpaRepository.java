package org.telran.pizzaservice.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.telran.pizzaservice.de.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {


    User save(User user);

    List<User> findAll();

    void deleteById(Long id);

    Optional<User> findByName(String login);

    List<User> findAllByPassword(String password);

    @Query("SELECT u FROM User u WHERE u.email IS NOT NULL ")
    List<User> getUserWithUserInfo();

}
