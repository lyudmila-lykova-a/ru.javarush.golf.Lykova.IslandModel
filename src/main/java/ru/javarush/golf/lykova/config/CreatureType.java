package ru.javarush.golf.lykova.config;

import ru.javarush.golf.lykova.model.Animal;
import ru.javarush.golf.lykova.model.Creature;

import java.util.HashMap;
import java.util.Map;

public enum CreatureType {

    WOLF(Animal.class, 10, 50, 30, 3, 0.1, 8),
    MOUSE(Animal.class, 10, 0.05, 500, 1, 0.1, 0.01),
    PLANT(Creature.class, 30, 1.0, 200, 0, 0, 1),
    BOA(Animal.class, 10, 15, 30, 1, 0.1, 3),
    FOX(Animal.class, 10, 8, 30, 2, 0.1, 2),
    BEAR(Animal.class, 10, 500, 5, 2, 0.1, 80),
    EAGLE(Animal.class, 10, 6, 20, 3, 0.1, 1),
    HORSE(Animal.class, 10, 400, 20, 4, 0.1, 60),
    DEER(Animal.class, 10, 300, 20, 4, 0.1, 50),
    RABBIT(Animal.class, 10, 2, 150,2, 0.1, 0.45),
    GOAT(Animal.class, 10, 60, 140, 3, 0.1, 10),
    SHEEP(Animal.class, 10, 70, 140, 3, 0.1, 15),
    BOAR(Animal.class, 10, 400, 50, 2, 0.1, 50),
    BUFFALO(Animal.class, 10, 700, 10, 3, 0.1, 100),
    DUCK(Animal.class, 10, 1, 200, 4, 0.1, 0.15),
    CATERPILLAR(Creature.class, 10, 0.01, 1000, 0, 0, 1);


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

    public int getInitAmount() {
        return initAmount;
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

