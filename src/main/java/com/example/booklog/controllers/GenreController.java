package com.example.booklog.controllers;

import com.example.booklog.data.GenreRepository;
import com.example.booklog.models.Genre;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("log/genres")
    public class GenreController {

        @Autowired
        private GenreRepository genreRepository;

        @GetMapping("index")
        public String displayAllGenres(Model model) {
            model.addAttribute("title", "All Genres");
            model.addAttribute("genres", genreRepository.findAll());
            return "/log/genres/index";
        }

        @GetMapping("add")
        public String renderCreateGenreForm(Model model) {
            model.addAttribute("title", "Add New Genre");
            model.addAttribute(new Genre());
            return "/log/genres/add";

        }

        @PostMapping("add")
        public String processCreateGenreForm(@Valid @ModelAttribute Genre genre, Model model) {
            genreRepository.save(genre);
            return "/log/genres/index";
        }

    }


