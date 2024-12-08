package com.challenge.operations.repository;

import com.challenge.operations.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository interface for managing {@link Operation} entities with CRUD operations.
 *
 * This interface extends {@link JpaRepository}, providing a full suite of data management
 * functions for the {@link Operation} entity, using a Long type as the ID.
 *
 * Methods in this interface can be executed in a transactional context managed by Spring Data JPA.
 */
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Optional<Operation> findByType(String type);
}

