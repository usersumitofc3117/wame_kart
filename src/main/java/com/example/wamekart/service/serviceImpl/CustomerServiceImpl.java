package com.example.wamekart.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.wamekart.model.Customer;
import com.example.wamekart.repository.UsernameRepo;
import com.example.wamekart.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
private UsernameRepo usernameRepo;
@Autowired
private PasswordEncoder passwordEncoder;
    @Override
    public Customer getRegister(Customer customer) {
customer.setRole("ROLE_USER");

String encodepassword = passwordEncoder.encode(customer.getPassword());
customer.setPassword(encodepassword);
Customer savCustomer = usernameRepo.save(customer);
       return savCustomer;


    }
 

  
 
}
