package ru.javarush.golf.lykova.model;

import java.util.Collections;
import java.util.Map;

public abstract class Animal {

    private final double weight;
    private final int maxCountInLocation;
    private final int maxSpeed;
    private final double reproductionPossibility; // вероятность размножения 0 - 1;
    private final double fullSatiety;
    private final Map<Class<? extends Animal>, Double> animalClassToEatingPossibilityMap;
    private double satiety; // сытость, кг
    private Location location;


    public Animal(double weight, int maxCountInLocation, int maxSpeed, double reproductionPossibility,
                  Map<Class<? extends Animal>, Double> animalClassToEatingPossibilityMap, double satiety) {
        this.weight = weight;
        this.maxCountInLocation = maxCountInLocation;
        this.maxSpeed = maxSpeed;
        this.reproductionPossibility = reproductionPossibility;
        this.fullSatiety = satiety;
        this.satiety = satiety;
        this.animalClassToEatingPossibilityMap = animalClassToEatingPossibilityMap;
    }

    public abstract Animal reproduction();

    public double getWeight() {
        return weight;
    }

    public int getMaxCountInLocation() {
        return maxCountInLocation;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getReproductionPossibility() {
        return reproductionPossibility;
    }

    public Map<Class<? extends Animal>, Double> getAnimalClassToEatingPossibilityMap() {
        return Collections.unmodifiableMap(animalClassToEatingPossibilityMap);
    }

    public double getSatiety() {
        return satiety;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        // todo check location is not null
        return location;
    }

    public double getFullSatiety() {
        return fullSatiety;
    }

    public void eat(Animal animal) {
        satiety = Math.min(satiety + animal.getWeight(), fullSatiety);
    }
}
