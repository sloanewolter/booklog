package com.example.booklog.controllers;

import com.example.booklog.data.BookRepository;
import com.example.booklog.data.GenreRepository;
import com.example.booklog.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("log/books")
public class BookController {

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("index")
    public String displayBooks(Model model) {
        model.addAttribute("title", "All Books");
        model.addAttribute("books", bookRepository.findAll());
        return "/log/books/index";
    }

    @GetMapping("add")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Add New Book");
        model.addAttribute(new Book());
        model.addAttribute("genres", genreRepository.findAll());
        return "/log/books/add";
    }

    @PostMapping("add")
    public String processCreateEventForm(@ModelAttribute Book newBook,
                                         Errors errors, Model model) {

        bookRepository.save(newBook);
        return "redirect:/log/books/index";
    }

    //Add capacity to delete and edit books

}
