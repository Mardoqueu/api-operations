package com.challenge.operations.exception;


/**
 * Exception thrown to indicate that an invalid expression has been encountered
 * during parsing or evaluation processes.
 *
 * This exception is typically used within expression evaluation contexts to
 * signify various errors such as mismatched parentheses, consecutive operators,
 * division by zero, invalid tokens, or other structural issues within the
 * expression being processed.
 *
 * The message provided during the construction of this exception gives specific
 * details about the nature of the invalid expression detected.
 */
public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException(String message) {
        super(message);
    }
}