package io.artur.spring.usingspringstatemachine.services;

import io.artur.spring.usingspringstatemachine.domain.Payment;
import io.artur.spring.usingspringstatemachine.repositories.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    private Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder()
                .amount(BigDecimal.valueOf(20.00))
                .build();
    }

    @Transactional
    @Test
    void preAuthPayment() {
        Payment saved = paymentService.newPayment(payment);

        paymentService.preAuthPayment(saved.getId());

        Payment preAuth = paymentRepository.getById(saved.getId());

        System.out.println(preAuth);
    }
}