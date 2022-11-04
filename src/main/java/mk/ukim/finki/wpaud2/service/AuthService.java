package mk.ukim.finki.wpaud2.service;

import mk.ukim.finki.wpaud2.model.User;

public interface AuthService {
    User login(String username, String password);
    User register(String username,String password,String repeartPassword,String name, String surname);

}
