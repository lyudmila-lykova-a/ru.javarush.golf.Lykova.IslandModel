package ru.javarush.golf.lykova.model;

import java.util.ArrayList;
import java.util.Collection;
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

    public void killAnimal(Animal animal) {
        animal.setLocation(null);
        animalList.remove(animal);
    }

    public int takeAnimalAmount(Animal animal) {
        int result = 0;
        for (Animal currentAnimal : animalList) {
            if (currentAnimal.getClass().getName().equals(animal.getClass().getName())) {
                result++;
            }
        }
        return result;
    }

    public List<Animal> takeAnimals(Collection<Class<? extends Animal>> animalClassList) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animalClassList.contains(animal.getClass())) {
                result.add(animal);
            }
        }
        return result;
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
