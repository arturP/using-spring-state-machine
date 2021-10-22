package io.artur.spring.usingspringstatemachine.repositories;

import io.artur.spring.usingspringstatemachine.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
