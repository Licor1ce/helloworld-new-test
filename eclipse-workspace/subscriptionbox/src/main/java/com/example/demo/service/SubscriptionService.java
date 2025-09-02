package com.example.demo.service;

import com.example.demo.model.Subscriber;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionService {

    private final List<Subscriber> storage = new ArrayList<>();

    public void save(Subscriber subscriber) {
        // En un proyecto real aquí guardas en BD; para el ejercicio guardamos en memoria
        storage.add(subscriber);
    }

    public List<Subscriber> findAll() {
        return new ArrayList<>(storage);
    }

    public void clearAll() {
        storage.clear();
    }
}
