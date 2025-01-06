package org.telran.pizzaservice.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.pizzaservice.de.entity.Order;
import org.telran.pizzaservice.de.enums.OrderStatus;

import java.util.List;

@Repository
public interface OrderJpaRepository extends JpaRepository<Order, Long> {

    List<Order>findByUserId(Long userId);

}
