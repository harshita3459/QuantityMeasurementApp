package com.app.quantitymeasurementapp.service;

import com.app.quantitymeasurementapp.entity.UserEntity;
import com.app.quantitymeasurementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                ((UserDetails) user).getUsername(),
                ((UserDetails) user).getPassword(),
                Collections.emptyList()
        );
    }
}