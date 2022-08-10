package ru.javarush.golf.lykova.config;

import java.util.Map;

public class EatingPossibilityMapper {

    public void initMapping() {
        CreatureType.WOLF.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.MOUSE, 0.8));
    }

}
