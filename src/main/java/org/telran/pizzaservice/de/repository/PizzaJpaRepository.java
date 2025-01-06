package org.telran.pizzaservice.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.pizzaservice.de.entity.Pizza;

import java.util.List;

@Repository
public interface PizzaJpaRepository extends JpaRepository<Pizza, Long> {

    Pizza save(Pizza pizza);

    List<Pizza>findAll();

    List<Pizza> findByTitle(String title); //SELECT * FROM pizza WHERE title =: title

    void deleteById(Long id);

}
