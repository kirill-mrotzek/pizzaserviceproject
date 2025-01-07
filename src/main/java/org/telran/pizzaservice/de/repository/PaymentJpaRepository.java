package org.telran.pizzaservice.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.pizzaservice.de.entity.Payment;

@Repository
public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {

}
