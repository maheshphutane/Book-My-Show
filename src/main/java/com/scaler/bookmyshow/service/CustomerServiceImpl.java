package com.scaler.bookmyshow.service;

import com.scaler.bookmyshow.model.Customer;
import com.scaler.bookmyshow.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer signUp(Customer customer) {
        return customerRepository.save(customer);
    }
}
