package io.artur.spring.usingspringstatemachine.domain;

/**
 *
 */
public enum PaymentEvent {
    PRE_AUTHORIZED, PRE_AUTH_APPROVED, PRE_AUTH_DECLINED, AUTHORIZED, AUTH_APPROVED, AUTH_DECLINED
}
