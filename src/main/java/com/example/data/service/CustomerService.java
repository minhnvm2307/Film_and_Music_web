package com.example.data.service;

import java.util.List;

import com.example.data.entity.CustomerEntity;

public interface CustomerService {

    // Add the method signature here
    List<CustomerEntity> findAll();
}