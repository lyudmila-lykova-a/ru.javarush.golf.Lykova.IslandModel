package ru.javarush.golf.lykova.model;

import java.util.Collections;
import java.util.Map;

public abstract class Animal extends Creature {

    public Animal(double weight, int maxCountInLocation, int maxSpeed, double reproductionPossibility,
                  Map<Class<? extends Creature>, Double> creatureClassToEatingPossibilityMap, double satiety) {
        super(weight, maxCountInLocation, maxSpeed, reproductionPossibility, creatureClassToEatingPossibilityMap, satiety);
    }

    public abstract Animal reproduction();
}
