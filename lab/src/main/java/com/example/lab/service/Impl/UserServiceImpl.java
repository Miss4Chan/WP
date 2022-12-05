package com.example.lab.service.Impl;

import com.example.lab.model.User;
import com.example.lab.repository.jpa.UserRepository;
import com.example.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }
}
