package io.artur.spring.usingspringstatemachine.services;

import io.artur.spring.usingspringstatemachine.domain.Payment;
import io.artur.spring.usingspringstatemachine.domain.PaymentEvent;
import io.artur.spring.usingspringstatemachine.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

/**
 *
 */
public interface PaymentService {
    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuthPayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizedPayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuthPayment(Long paymentId);


}
