package io.artur.spring.usingspringstatemachine.config.gurards;

import io.artur.spring.usingspringstatemachine.domain.PaymentEvent;
import io.artur.spring.usingspringstatemachine.domain.PaymentState;
import io.artur.spring.usingspringstatemachine.services.PaymentServiceImpl;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class PaymentIdGuard implements Guard<PaymentState, PaymentEvent> {

    @Override
    public boolean evaluate(StateContext<PaymentState, PaymentEvent> context) {
        return context.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER) != null;
    }
}
