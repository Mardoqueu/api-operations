package com.challenge.operations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.challenge.operations.entity.Record;
import java.util.List;

/**
 * RecordRepository is an interface for managing Record entities in the system.
 * It extends the JpaRepository to provide JPA specific methods for standard database
 * operations on the Record entity.
 *
 * This repository interface allows for the basic CRUD operations and includes a custom
 * query method to retrieve transaction records based on a specific user.
 *
 * Methods:
 * - List<Record> findByUserId(Long userId): Retrieves a list of Record entities
 *   associated with the specified user ID.
 *
 * The Record entity represents a financial transaction and contains information about
 * the transaction such as the amount, user balance, operation response, and timestamp.
 */
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserId(Long userId);
}
