package com.example.lab.model;

import lombok.Data;

import javax.persistence.Convert;
import java.io.Serializable;

@Data
public class UserFullname implements Serializable {
    String name;
    String surname;
}
