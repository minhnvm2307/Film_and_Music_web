package com.example.data.service.seviceImplement;

import org.springframework.stereotype.Service;
import com.example.data.entity.CustomerEntity;
import com.example.data.repository.CustomerRepository;
import com.example.data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CustomerImplement implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Add the implementation of the CustomerService interface here
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }
}
