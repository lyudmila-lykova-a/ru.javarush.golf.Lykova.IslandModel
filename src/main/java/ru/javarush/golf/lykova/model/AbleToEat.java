package ru.javarush.golf.lykova.model;

import ru.javarush.golf.lykova.config.CreatureType;

import java.util.Map;

public interface AbleToEat {
    Map<CreatureType, Double> getCreatureTypeToEatingPossibilityMap();
    void eat(Creature creature);
    double getSatiety();
    double getFullSatiety();
    void hunger();
}
