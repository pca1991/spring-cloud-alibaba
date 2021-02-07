package com.example.service.impl;

import com.example.service.AnimalServie;
import org.springframework.stereotype.Service;

@Service
public class Dog implements AnimalServie {
    @Override
    public String getName() {
        return "dog";
    }

    @Override
    public String getColor() {
        return "black";
    }
}
