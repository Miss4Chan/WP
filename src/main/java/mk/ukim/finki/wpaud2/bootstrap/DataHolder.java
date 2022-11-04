package mk.ukim.finki.wpaud2.bootstrap;

import mk.ukim.finki.wpaud2.model.Category;
import mk.ukim.finki.wpaud2.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Category> categoryList = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    @PostConstruct //Have the method called upon creation
    public void init()
    {
        categoryList.add(new Category("Software","Neshto software babush"));
        categoryList.add(new Category("Books","Neshto chitam ja Svetle"));
        users.add(new User("depkarepka","pass","Despina","Misheva"));
        users.add(new User("x","x","x","x"));
    }
}
