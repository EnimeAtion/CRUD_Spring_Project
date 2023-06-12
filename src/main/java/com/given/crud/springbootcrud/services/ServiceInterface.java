package com.given.crud.springbootcrud.services;

import com.given.crud.springbootcrud.model.User;

import java.util.List;

public interface ServiceInterface {
    /**
     * CRUD operation - Retrieve all users
     * @return - all users
     */
    public List<User> findAllUsers();

    /**
     * CRUD operation - Retrieve a user by id
     * @param id - the id of the user to retrieve
     * @return - the user
     */
    public User findUserById(Long id);

    /**
     * CRUD operation - Create a new user
     * @param user - the user to create
     * @return - the created user
     */
    public User createUser(User user);

    /**
     * CRUD operation - Update a user
     * @param user - the user to update
     * @return - the updated user
     */
    public User updateUser(User user);

    /**
     * CRUD operation - Delete a user
     * @param id - the id of the user to delete
     */
    public void deleteUser(Long id);
}
