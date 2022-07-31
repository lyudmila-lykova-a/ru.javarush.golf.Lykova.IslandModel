package ru.javarush.golf.lykova.model;

public class Wolf extends Animal {

    public Wolf() {
        super(50, 30, 3, 0.5, 8);
    }

    @Override
    public Animal reproduction() {
        return new Wolf();
    }
}
