package com.challenge.operations.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a financial transaction record in the system.
 *
 * This class is used to store information about transactions
 * associated with a particular user and operation. It includes
 * details such as the transaction amount, user balance at the
 * time of the transaction, the operation response, and the date
 * when the transaction took place.
 *
 * It is a JPA entity that can be persisted to a database.
 * Instances of this class are managed through a database
 * using JPA annotations for objects relational mapping.
 *
 * Fields in this class include:
 * - id: Unique identifier for each record.
 * - user: The user associated with the record.
 * - operation: The operation related to this record.
 * - amount: The amount involved in the transaction.
 * - userBalance: The balance of the user at the time of transaction.
 * - operationResponse: The result response of the operation.
 * - date: The date and time when the transaction occurred.
 * - expression: An optional expression used in the transaction.
 */
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    private Operation operation;

    private BigDecimal amount;
    private BigDecimal userBalance;
    private String operationResponse;
    private LocalDateTime date;
    private String expression;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(BigDecimal userBalance) {
        this.userBalance = userBalance;
    }

    public String getOperationResponse() {
        return operationResponse;
    }

    public void setOperationResponse(String operationResponse) {
        this.operationResponse = operationResponse;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getExpression() { return expression; }

    public void setExpression(String expression) { this.expression = expression; }
}

