package ru.javarush.golf.lykova.model;

import java.util.Map;

public interface AbleToEat {
    Map<Class<? extends Creature>, Double> getCreatureClassToEatingPossibilityMap();
    void eat(Creature creature);
    double getSatiety();
    double getFullSatiety();
}
