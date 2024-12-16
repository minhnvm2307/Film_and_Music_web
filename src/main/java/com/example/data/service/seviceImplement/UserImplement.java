package com.example.data.service.seviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.entity.LoginRequest;
import com.example.data.entity.UserEntity;
import com.example.data.repository.UserRepository;
import com.example.data.service.UserService;

@Service
public class UserImplement implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public boolean LoginRequestAuthentication(LoginRequest loginRequest) {
        UserEntity userEntity = userRepository.findByUsername(loginRequest.getUsername());
        if (userEntity != null) {
            if (userEntity.getPassword().equals(loginRequest.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new NullPointerException("User not found: " + username);
        }
        return userEntity;
    }
    
}
