package io.artur.spring.usingspringstatemachine.services;

import io.artur.spring.usingspringstatemachine.domain.Payment;
import io.artur.spring.usingspringstatemachine.domain.PaymentEvent;
import io.artur.spring.usingspringstatemachine.domain.PaymentState;
import io.artur.spring.usingspringstatemachine.repositories.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.annotation.Repeat;
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

    @Transactional
    @RepeatedTest(3)
    @Test
    void authPayment() {
        Payment initPayment = paymentService.newPayment(payment);
        StateMachine<PaymentState, PaymentEvent> stateMachine = paymentService.preAuthPayment(initPayment.getId());
        Payment preAuth = paymentRepository.getById(initPayment.getId());
        System.out.println(stateMachine.getState().getId());
        System.out.println(preAuth);

        if (stateMachine.getState().getId() == PaymentState.PRE_AUTH) {
            stateMachine = paymentService.authorizedPayment(initPayment.getId());
            System.out.println("After authorization:");
            System.out.println(stateMachine.getState().getId());
            Payment auth = paymentRepository.getById(initPayment.getId());

            System.out.println(auth);
        } else {
            System.out.println("Cannot authorized!");
        }
    }
}