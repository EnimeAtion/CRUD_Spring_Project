package com.given.crud.springbootcrud.exception;

public class EmployeeNotFoundException extends RuntimeException
{
    /**
     * Constructor for EmployeeNotFoundException
     * @param message - Message to be displayed when exception is thrown
     */
    public EmployeeNotFoundException(String message)
    {
        super(message);
    }

    /**
     * Constructor for EmployeeNotFoundException
     * @param message - Message to be displayed when exception is thrown
     * @param cause - Cause of the exception
     */
    public EmployeeNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
