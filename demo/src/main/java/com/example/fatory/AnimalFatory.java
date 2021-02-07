package com.example.fatory;

import com.example.service.AnimalServie;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AnimalFatory implements ApplicationContextAware {
    Map<String, AnimalServie> animalMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        animalMap = applicationContext.getBeansOfType(AnimalServie.class);
    }

    public  <T extends AnimalServie> T getService(String name) {
        return (T)animalMap.get(name);

    }
}