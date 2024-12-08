package com.challenge.operations.exception;

/**
 * Thrown to indicate that a specific operation could not be found.
 * This exception is a subclass of {@code RuntimeException}, and
 * is typically used to signal that an operation requested by the
 * user does not exist or is unavailable in the system.
 *
 * Instances of this exception should be used in scenarios where
 * operations are queried or manipulated, such as when attempting
 * to retrieve or delete an operation by its identifier, and the
 * requested operation is not present.
 *
 * The exception message provides additional context about the
 * missing operation, which can be useful for debugging or logging
 * purposes.
 */
public class OperationNotFoundException extends RuntimeException {
    public OperationNotFoundException(String message) {
        super(message);
    }
}
