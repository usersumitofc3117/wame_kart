package com.example.wamekart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.wamekart.model.Customer;
import com.example.wamekart.repository.UsernameRepo;

@Service
public class CustomuserDetailServiceimpl implements UserDetailsService{

@Autowired
private UsernameRepo usernameRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

Customer customer = usernameRepo.findByEmail(username);
       
if (customer == null) {
    throw new UsernameNotFoundException("customer not found");
}
        return new CustomUser(customer);
    }
}
