package com.example.service.impl;

import com.example.service.AnimalServie;
import org.springframework.stereotype.Service;

@Service
public class Duck implements AnimalServie {
    @Override
    public String getName() {
        return "duck";
    }

    @Override
    public String getColor() {
        return "yellow";
    }
}
