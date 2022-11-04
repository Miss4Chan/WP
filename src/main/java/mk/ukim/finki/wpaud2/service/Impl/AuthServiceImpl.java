package mk.ukim.finki.wpaud2.service.Impl;

import mk.ukim.finki.wpaud2.model.User;
import mk.ukim.finki.wpaud2.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.wpaud2.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.wpaud2.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.wpaud2.repository.InMemoryUserRepository;
import mk.ukim.finki.wpaud2.service.AuthService;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {
    private final InMemoryUserRepository userRepository;

    public AuthServiceImpl(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password.isEmpty())
        {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUserNameAndPassword(username,password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeartPassword, String name, String surname) {
        if(username==null || username.isEmpty() || password.isEmpty())
        {
            throw new InvalidArgumentsException();
        }
        if(!password.equals(repeartPassword))
        {
            throw new PasswordsDoNotMatchException();
        }
        User user = new User(username, password, name, surname);
        return userRepository.saveOrUpdate(user);
    }
}
