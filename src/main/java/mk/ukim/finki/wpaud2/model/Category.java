package mk.ukim.finki.wpaud2.model;

import lombok.Data;

@Data
public class Category {

    private String name;
    private String desc;

    public Category(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
