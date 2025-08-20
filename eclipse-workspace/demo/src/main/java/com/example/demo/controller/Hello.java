package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        return "hello";
    }

    @GetMapping("/morning")
    public String morning(Model model) {
        model.addAttribute("message", "Good morning!");
        return "hello";
    }

    @GetMapping("/night")
    public String night(Model model) {
        model.addAttribute("message", "Good night.");
        return "hello";
    }
}

