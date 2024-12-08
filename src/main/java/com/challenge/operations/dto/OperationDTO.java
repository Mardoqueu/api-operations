package com.challenge.operations.dto;

/**
 * Data Transfer Object for operations.
 *
 * This class encapsulates the details needed to perform an operation,
 * including the ID of the user requesting the operation and the
 * mathematical expression that defines the operation to be executed.
 */
public class OperationDTO {

    private Long userId;
    private String expression;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}

