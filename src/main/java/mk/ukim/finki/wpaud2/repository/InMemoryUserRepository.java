package mk.ukim.finki.wpaud2.repository;

import mk.ukim.finki.wpaud2.bootstrap.DataHolder;
import mk.ukim.finki.wpaud2.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryUserRepository {
    public Optional<User> findByUsername(String username)
    {
        return DataHolder.users.stream().filter(i->i.getUsername().equals(username)).findFirst();
    }
    public Optional<User> findByUserNameAndPassword(String username,String password)
    {
        return DataHolder.users.stream().filter(i->i.getUsername().equals(username) && i.getPassword().equals(password)).findFirst();
    }
    public User saveOrUpdate(User user) {
        DataHolder.users.removeIf(i->i.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }
    public void delete(String username)
    {
        DataHolder.users.removeIf(i->i.getUsername().equals(username));
    }
}
