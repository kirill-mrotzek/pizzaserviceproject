package org.telran.pizzaservice.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.pizzaservice.de.entity.DeliveryAddress;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryAddressJpaRepository extends JpaRepository<DeliveryAddress, Long> {

    Optional<DeliveryAddress> findAllByUserId(Long userId);
}