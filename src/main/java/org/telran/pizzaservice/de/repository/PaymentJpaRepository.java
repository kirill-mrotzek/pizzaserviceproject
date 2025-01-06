package org.telran.pizzaservice.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telran.pizzaservice.de.entity.Payment;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {

}
