package com.given.crud.springbootcrud.controller;

import com.given.crud.springbootcrud.model.User;
import com.given.crud.springbootcrud.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @RestController - annotation that marks a class as a controller
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    /**
     * Constructor of EmployeeController
     * @param employeeService - the service that provides methods for working with the database
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * This  method gets all users from the database
     * @return - list of users available in the database
     */
    @GetMapping("/")
    public List<User> getAllUsers() {
        return employeeService.findAllUsers();
    }

    /**
     * This method gets a user by id from the database
     * @param id - id of the user that we want to get from the database
     * @return - user with the specified id
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return employeeService.findUserById(id);
    }

    /**
     * This method creates a new user in the database
     * @param user - user that we want to create in the database
     * @return - created user
     */
    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return employeeService.createUser(user);
    }

    /**
     * This method updates a user in the database
     * @param id - id of the user that we want to update
     * @param user - user that we want to update
     * @return - updated user
     */
    @PutMapping("/edit/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        return employeeService.updateUser(user);
    }

    /**
     * This method deletes a user from the database
     * @param id - id of the user that we want to delete
     */
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        employeeService.deleteUser(id);
        User user = employeeService.findUserById(id);
        employeeService.deletedUser(user);
    }
}
