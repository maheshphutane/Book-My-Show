package com.scaler.bookmyshow.controller;

import com.scaler.bookmyshow.dto.CustomerRequestDTO;
import com.scaler.bookmyshow.model.Customer;
import com.scaler.bookmyshow.service.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/bms/v1")
@Log4j2
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/signup")
    public ResponseEntity<Long> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO ) {
        log.info("Create customer with details: "+customerRequestDTO);
        Customer customer = Customer.builder()
                .name(customerRequestDTO.getName())
                .email(customerRequestDTO.getEmail())
                .bookings(new ArrayList<>()).build();
        customerService.signUp(customer);
        log.info("Customer created successfully!");
        return new ResponseEntity<>(customer.getId(), HttpStatus.OK);
    }
}
