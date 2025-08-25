package com.example.demo.controller;

import com.example.demo.service.DayNightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DayNightController {

    @Autowired
    private DayNightService dayNightService;

    @GetMapping("/morning")
    public String morning(Model model) {
        String message = dayNightService.getMorningMessage();
        model.addAttribute("message", message);
        return "hello";
    }

    @GetMapping("/night")
    public String night(Model model) {
        String message = dayNightService.getNightMessage();
        model.addAttribute("message", message);
        return "hello";
    }
}
