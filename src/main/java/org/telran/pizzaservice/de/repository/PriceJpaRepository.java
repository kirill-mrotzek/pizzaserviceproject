package org.telran.pizzaservice.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.pizzaservice.de.entity.Price;

@Repository
public interface PriceJpaRepository extends JpaRepository<Price, Long> {

    void deleteById(Long id);

    Price save(Price price);
}
