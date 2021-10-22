package io.artur.spring.usingspringstatemachine.domain;

/**
 *
 */
public enum PaymentState {
    NEW, PRE_AUTH, PRE_AUTH_ERROR, AUTH, AUTH_ERROR
}
