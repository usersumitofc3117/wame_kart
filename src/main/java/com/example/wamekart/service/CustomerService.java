package com.example.wamekart.service;

import org.springframework.stereotype.Service;

import com.example.wamekart.model.Customer;
@Service
public interface CustomerService {
    public Customer getRegister(Customer customer); 

}
