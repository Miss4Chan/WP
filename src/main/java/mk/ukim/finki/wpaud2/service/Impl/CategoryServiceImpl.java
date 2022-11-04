package mk.ukim.finki.wpaud2.service.Impl;

import mk.ukim.finki.wpaud2.model.Category;
import mk.ukim.finki.wpaud2.repository.InMemoryCategoryRepository;
import mk.ukim.finki.wpaud2.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final InMemoryCategoryRepository inMemoryCategoryRepository;

    public CategoryServiceImpl(InMemoryCategoryRepository inMemoryCategoryRepository)
    {
        this.inMemoryCategoryRepository= inMemoryCategoryRepository;
    }
    @Override
    public Category create(String name, String desc) {
        if (name==null || name.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        Category c= new Category(name, desc);
        //best business logic practice is to create complex objects inside of methods instead of passing them as arguments
        //It's best that the arguments are some primitive types
        inMemoryCategoryRepository.save(c);
        return c;
    }

    @Override
    public Category update(String name, String desc) {
        if (name==null || name.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        Category c= new Category(name, desc);
        inMemoryCategoryRepository.save(c);
        return c;
    }

    @Override
    public void delete(String name) {
        if (name==null || name.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        inMemoryCategoryRepository.delete(name);
    }

    @Override
    public List<Category> listCategories() {
        return inMemoryCategoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategories(String searchText) {
        return inMemoryCategoryRepository.search(searchText);
    }
}
