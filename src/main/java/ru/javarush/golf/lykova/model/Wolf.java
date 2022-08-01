package ru.javarush.golf.lykova.model;

import java.util.Map;

public class Wolf extends Animal {

    public Wolf() {
        super(50, 30, 3, 0.5, Map.of(Mouse.class, 0.8), 8);
    }

    @Override
    public Animal reproduction() {
        return new Wolf();
    }
}
