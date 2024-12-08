package com.challenge.operations.exception;

/**
 * Exception thrown when an operation cannot be completed due to insufficient
 * balance. This runtime exception indicates that the user's balance is not
 * enough to cover the required amount for a specific operation.
 */
public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
