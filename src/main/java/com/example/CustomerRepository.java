package com.example;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
class CustomerRepository {

    public CustomerRepository() {
        // This is a constructor
    }

    public void save(Customer customer) {
        // This saves the customer to the database
    }

    public Customer findById(Long id) {
        // This finds a customer by their ID
        return null;
    }

    public List<Customer> findAll() {
        // This finds all customers in the database
        return null;
    }

    public void delete(Customer customer) {
        // This deletes the customer from the database
    }
}