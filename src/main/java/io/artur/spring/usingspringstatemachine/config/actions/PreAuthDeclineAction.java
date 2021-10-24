package io.artur.spring.usingspringstatemachine.config.actions;

import io.artur.spring.usingspringstatemachine.domain.PaymentEvent;
import io.artur.spring.usingspringstatemachine.domain.PaymentState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

/**
 *
 */
public class PreAuthDeclineAction implements Action<PaymentState, PaymentEvent> {

    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> context) {
        System.out.println("Notification - PreAuth Declined.");
    }
}
