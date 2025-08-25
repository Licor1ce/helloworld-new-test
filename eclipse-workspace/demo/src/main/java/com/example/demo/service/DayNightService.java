package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DayNightService {

    public String getMorningMessage() {
        return "Good morning!";
    }

    public String getNightMessage() {
        return "Good night.";
    }
}
