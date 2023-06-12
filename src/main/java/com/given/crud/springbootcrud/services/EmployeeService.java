package com.given.crud.springbootcrud.services;

import com.given.crud.springbootcrud.repository.UserRepository;
import org.springframework.stereotype.Service;
import at.favre.lib.crypto.bcrypt.BCrypt;
import com.given.crud.springbootcrud.model.User;

import java.util.List;

/**
 * @Service - This is a Spring annotation that marks a class as a service provider.
 */
@Service
public class EmployeeService implements ServiceInterface {
    private final UserRepository userRepository;

    /**
     * Constructor for the EmployeeService
     * @param userRepository - the repository that is used to access the database.
     *                        This is injected into the constructor to allow for dependency injection.
     *                        This is done so that the EmployeeService can be tested without
     *                        having to create a mock repository.
     */
    public EmployeeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method is used to find all users in the database
     * @return - a list of all users in the database
     */
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * This method is used to find a user by their id
     * @param id - the id of the user to find
     * @return - the user with the given id
     */
    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * This method is used to save a user to the database
     * @param user - the user to save to the database
     * @return - the saved user
     */
    @Override
    public User createUser(User user) {
        /**
         * The password is hashed before it is saved to the database.
         * This is done using the BCrypt library by the Favre library(at.favre.lib.crypto.bcrypt)
         * The version of the library is set to the version 2y.
         */
        String hashedPsw = BCrypt.with(BCrypt.Version.VERSION_2Y).hashToString(12, user.getPassword().toCharArray());
        user.setPassword(hashedPsw);
        return userRepository.save(user);
    }

    /**
     * Checks if the password is correct
     * @param password - the password to check against the hashed password in the database.
     *                  The password is hashed before it is checked against the database.
     *                  This is done to prevent the user from being able to see the database
     *                  password in plain text.
     *                  The password is not checked against the database password in this method.
     *                  The password is checked against the database password in the database
     * @param hashedPassword - the hashed password in the database
     * @return - true if the password is correct, false otherwise
     */
    public Boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified;
    }

    /**
     * This method is used to update a user in the database
     * @param user - the user to update in the database
     * @return - the updated user
     */
    @Override
    public User updateUser(User user) {
        //Hashing the password after the user is updated
        String hashedPsw = BCrypt.with(BCrypt.Version.VERSION_2Y).hashToString(12, user.getPassword().toCharArray());
        user.setPassword(hashedPsw);

        return userRepository.save(user);
    }

    /**
     * This method is used to delete a user from the database
     * @param id - the id of the user to delete
     */
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public String deletedUser(User user) {
        return "Employee with id " + user.getId() + " has been deleted";
    }
}
