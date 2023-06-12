package com.given.crud.springbootcrud.repository;

import com.given.crud.springbootcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository -  This is a Spring Data JPA repository.
 *                It is used to indicate that the class provides
 *                the mechanism for storage, retrieval, search, update
 *                and delete operation on objects.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
