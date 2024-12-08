package com.challenge.operations.exception;

/**
 * Exception thrown when a specific user cannot be found.
 * This is a runtime exception that indicates the requested user
 * does not exist in the system. This can be used in scenarios
 * where user retrieval operations fail, such as when looking up
 * a user by their ID or username and no corresponding user is found.
 *
 * The exception message provides additional context about the missing user,
 * typically including details like the user ID, which can be useful for
 * debugging or logging purposes.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
