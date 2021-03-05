package com.example.fatory;

import com.example.service.AnimalServie;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AnimalFatory {

    @Autowired
    Map<String, AnimalServie> animalMap;

    public  AnimalServie getService(String name) {
        return animalMap.get(name);

    }
}