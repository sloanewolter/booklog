package com.example.booklog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.antlr.v4.runtime.misc.NotNull;


//TO-DO: Add errors

@Entity
public class Book extends AbstractEntity{

    private String title;

    private String author;

    private int rating;

    private int yearPublished;

    @ManyToOne
    @NotNull
    private Genre genre;

    public Book(String title, String author, int rating, int yearPublished, Genre genre) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.yearPublished= yearPublished;
        this.genre = genre;
    }

    public Book() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return title;
    }

}
