package com.example.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.data.entity.CustomerEntity;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    List<CustomerEntity> findAll();
}
