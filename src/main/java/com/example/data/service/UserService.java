package com.example.data.service;

import com.example.data.entity.LoginRequest;
import com.example.data.entity.UserEntity;

public interface UserService {

    boolean LoginRequestAuthentication(LoginRequest loginRequest);

    UserEntity getUserByUsername(String username);

    UserEntity getUserById(Integer id);
}
