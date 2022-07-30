package ru.javarush.golf.lykova.model;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private final int x;
    private final int y;
    private final List<Animal> animalList = new ArrayList<>();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void add(Animal animal) {
        if (animal.getLocation() != null) {
            animal.getLocation().animalList.remove(animal);
        }
        animal.setLocation(this);
        animalList.add(animal);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", animalList=" + animalList +
                '}';
    }


}
