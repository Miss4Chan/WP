package mk.ukim.finki.wpaud2.repository;

import mk.ukim.finki.wpaud2.bootstrap.DataHolder;
import mk.ukim.finki.wpaud2.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository //adapter for getting data from some pool
public class InMemoryCategoryRepository {
    public List<Category> findAll()
    {
        return DataHolder.categoryList;
    }
    public Category save(Category c)
    {
        if(c==null || c.getName()==null || c.getName().isEmpty())
        {
            return null;
        }
        DataHolder.categoryList.removeIf(i->i.getName().equals(c.getName()));
        DataHolder.categoryList.add(c);
        return c;
    }
    public Optional<Category> findByName(String name)
    {
        return DataHolder.categoryList.stream().filter(i->i.getName().equals(name)).findFirst();
    }
    public List<Category> search (String text)
    {
        return DataHolder.categoryList.stream()
                .filter(i->i.getName().contains(text)||i.getDesc().contains(text)).collect(Collectors.toList());
    }
    public void delete(String name)
    {
        if(name==null)
            return;
        DataHolder.categoryList.removeIf(i->i.getName().equals(name));
    }
}
