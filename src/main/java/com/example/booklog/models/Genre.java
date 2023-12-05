package com.example.booklog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre extends AbstractEntity{

private String name;

@OneToMany(mappedBy = "genre")
    private final List<Book> books = new ArrayList<>();



public Genre () {}

    public Genre(String name) {
    this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return  name;
    }
}
