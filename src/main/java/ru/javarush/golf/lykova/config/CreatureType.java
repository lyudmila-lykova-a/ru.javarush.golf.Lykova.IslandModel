package ru.javarush.golf.lykova.config;

import ru.javarush.golf.lykova.model.Animal;
import ru.javarush.golf.lykova.model.Creature;

import java.util.HashMap;
import java.util.Map;

public enum CreatureType {

    WOLF(Animal.class, 10, 50, 30, 3, 0.5, 8),
    MOUSE(Animal.class, 100, 0.05, 500, 1, 0.5, 0.01),
    PLANT(Creature.class, 10, 1.0, 200, 0, 0, 1);


    private final Class<? extends Creature> creatureClass;
    private final int initAmount;
    private final double weight;
    private final int maxCountInLocation;
    private final int maxSpeed;
    private final double reproductionPossibility;
    private final double fullSatiety;
    private final Map<CreatureType, Double> creatureTypeToEatingPossibilityMap = new HashMap<>();

    CreatureType(Class<? extends Creature> creatureClass, int initAmount, double weight,
                 int maxCountInLocation, int maxSpeed, double reproductionPossibility, double fullSatiety) {
        this.creatureClass = creatureClass;
        this.initAmount = initAmount;
        this.weight = weight;
        this.maxCountInLocation = maxCountInLocation;
        this.maxSpeed = maxSpeed;
        this.reproductionPossibility = reproductionPossibility;
        this.fullSatiety = fullSatiety;
    }

    public Creature reproduction() {
        try {
            return creatureClass.getConstructor(CreatureType.class).newInstance(this);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public void putCreatureTypeToEatingPossibilityMap(Map<CreatureType, Double> creatureTypeToEatingPossibilityMap) {
        this.creatureTypeToEatingPossibilityMap.putAll(creatureTypeToEatingPossibilityMap);
    }

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

    public double getFullSatiety() {
        return fullSatiety;
    }

    public Map<CreatureType, Double> getCreatureTypeToEatingPossibilityMap() {
        return creatureTypeToEatingPossibilityMap;
    }

}

