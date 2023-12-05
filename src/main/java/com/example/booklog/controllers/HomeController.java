package com.example.booklog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("log/index")

public class HomeController {

    @GetMapping
    public String index() {
        return "/log/index";
    }


}
