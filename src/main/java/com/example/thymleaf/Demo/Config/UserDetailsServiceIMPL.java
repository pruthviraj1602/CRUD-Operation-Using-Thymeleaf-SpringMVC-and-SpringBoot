package com.example.thymleaf.Demo.Config;

import com.example.thymleaf.Demo.Entities.Customer;
import com.example.thymleaf.Demo.Repositories.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceIMPL implements UserDetailsService {

    @Autowired
    private customerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username);

        if(customer!=null){
            return User.builder()
                    .username(customer.getCEmail())
                    .password(customer.getCPassword())
                    .build();
        }
       throw new UsernameNotFoundException("User Not Found");
    }
}
