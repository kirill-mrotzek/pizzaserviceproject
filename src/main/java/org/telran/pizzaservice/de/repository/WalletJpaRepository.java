package org.telran.pizzaservice.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.pizzaservice.de.entity.Wallet;

import java.util.Optional;

@Repository
public interface WalletJpaRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByUserId(Long userId);
}
