package ru.javarush.golf.lykova.model;

import java.util.Collections;

public class Mouse extends Animal{

    public Mouse() {
        super(0.05, 500, 1, 0.5, Collections.emptyMap(), 0.01);
    }

    @Override
    public Animal reproduction() {
        return new Mouse();
    }
}
