package com.example.wamekart.config;

import java.util.Arrays;
import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.wamekart.model.Customer;

public class CustomUser implements UserDetails {
    
private Customer user;


public CustomUser(Customer user) {
super();
    this.user = user;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
  return Arrays.asList(authority);
}

@Override
public @Nullable String getPassword() {
   
    return user.getPassword();
}

@Override
public String getUsername() {
    return user.getEmail();
}
}
