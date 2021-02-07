package com.example.service.impl;

import com.example.service.AnimalServie;
import org.springframework.stereotype.Service;

@Service(value = "cats")
public class Cat implements AnimalServie {
    @Override
    public String getName() {
        return "cat";
    }

    @Override
    public String getColor() {
        return "white";
    }
}
