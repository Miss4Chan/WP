package mk.ukim.finki.wpaud2.service;

import mk.ukim.finki.wpaud2.model.Category;

import java.util.List;

public interface CategoryService {
    Category create(String name, String desc);
    Category update(String name, String desc);
    void delete(String name);
    List<Category> listCategories();
    List<Category> searchCategories(String searchText);
}
