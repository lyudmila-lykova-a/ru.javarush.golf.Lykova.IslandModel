package ru.javarush.golf.lykova.model;

import java.util.Collections;
import java.util.Map;

public abstract class Creature {

    private final double weight;
    private final int maxCountInLocation;
    private final int maxSpeed;
    private final double reproductionPossibility; // вероятность размножения 0 - 1;
    private final double fullSatiety;
    private final Map<Class<? extends Creature>, Double> creatureClassToEatingPossibilityMap;
    private double satiety; // сытость, кг
    private Location location;


    public Creature(double weight, int maxCountInLocation, int maxSpeed, double reproductionPossibility,
                    Map<Class<? extends Creature>, Double> creatureClassToEatingPossibilityMap, double satiety) {
        this.weight = weight;
        this.maxCountInLocation = maxCountInLocation;
        this.maxSpeed = maxSpeed;
        this.reproductionPossibility = reproductionPossibility;
        this.fullSatiety = satiety;
        this.satiety = satiety;
        this.creatureClassToEatingPossibilityMap = creatureClassToEatingPossibilityMap;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountInLocation() {
        return maxCountInLocation;
    }

    // todo move out?
    public int getMaxSpeed() {
        return maxSpeed;
    }

    // todo move out?
    public double getReproductionPossibility() {
        return reproductionPossibility;
    }

    // todo move out?
    public Map<Class<? extends Creature>, Double> getCreatureClassToEatingPossibilityMap() {
        return Collections.unmodifiableMap(creatureClassToEatingPossibilityMap);
    }

    // todo move out?
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

    // todo move out?
    public double getFullSatiety() {
        return fullSatiety;
    }

    // todo move out?
    public void eat(Creature creature) {
        satiety = Math.min(satiety + creature.getWeight(), fullSatiety);
    }
}
