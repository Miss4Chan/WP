package com.example.lab.service.Impl;


import com.example.lab.model.Exceptions.InvalidArgumentsException;
import com.example.lab.model.Exceptions.InvalidUserCredentialsException;
import com.example.lab.model.Exceptions.PasswordsDoNotMatchException;
import com.example.lab.model.Exceptions.UsernameAlreadyExistsException;
import com.example.lab.model.User;
import com.example.lab.model.UserFullname;
import com.example.lab.repository.jpa.UserRepository;
import com.example.lab.service.AuthService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidArgumentsException();
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, LocalDate dateOfBirth) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidArgumentsException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if (!userRepository.findByUsername(username).isEmpty() ||
                userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        System.out.println(name);
        System.out.println(surname);
        User user = new User(username,name,surname, password, dateOfBirth);
        return userRepository.save(user);
    }

}