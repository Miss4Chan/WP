package mk.ukim.finki.wpaud2.bootstrap;

import lombok.Getter;
import mk.ukim.finki.wpaud2.model.Category;
import mk.ukim.finki.wpaud2.model.Manufacturer;
import mk.ukim.finki.wpaud2.model.Product;
import mk.ukim.finki.wpaud2.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories.add(new Category("Movies", "Movies category"));
        categories.add(new Category("Books", "Books category"));
        categories.add(new Category("Software", "Software category"));

        users.add(new User("depkarepka","pass","Despina","Misheva"));
        users.add(new User("x","x","x","x"));
        Category category = new Category("Sport", "Sports category");
        categories.add(category);

        Manufacturer manufacturer = new Manufacturer("Nike", "NY NY");
        manufacturers.add(manufacturer);
        manufacturers.add(new Manufacturer("Apple", "LA LA"));

        products.add(new Product("Ball", 350.0, 3, category, manufacturer));
        products.add(new Product("Harry Potter", 500.0, 3, category, manufacturer));
    }
}
