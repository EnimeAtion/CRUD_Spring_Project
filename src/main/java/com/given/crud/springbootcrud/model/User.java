package com.given.crud.springbootcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.GenerationType;

/**
 * @Entity - specifies that the class is an entity and is mapped to a database table.
 * @Data - generates getters and setters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields.
 * @AllArgsConstructor - generates a constructor with all fields as arguments.
 * @NoArgsConstructor - generates a constructor with no arguments.
 * @Table - specifies the name of the database table to be used for mapping.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class User {

    /**
     * @Id - assigns the primary key of the entity.
     * @GeneratedValue - specifies the strategy used to generate the values for the primary key.
     * @Column - specifies the column name of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
