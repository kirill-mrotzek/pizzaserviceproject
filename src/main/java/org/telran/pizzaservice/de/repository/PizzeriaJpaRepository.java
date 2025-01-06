package org.telran.pizzaservice.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.pizzaservice.de.entity.Pizzeria;

import java.util.List;

@Repository
public interface PizzeriaJpaRepository extends JpaRepository<Pizzeria, Long> {

    List<Pizzeria> findAll();

    List<Pizzeria> findById(long id);

    void deleteById(Long id);

    Pizzeria save(Pizzeria pizzeria);
}
