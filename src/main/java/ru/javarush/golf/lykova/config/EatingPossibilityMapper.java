package ru.javarush.golf.lykova.config;

import java.util.Map;

public class EatingPossibilityMapper {

    public void initMapping() {
        CreatureType.WOLF.putCreatureTypeToEatingPossibilityMap(Map.of(
                CreatureType.MOUSE, 0.8, CreatureType.HORSE, 0.1, CreatureType.DEER, 0.15, CreatureType.RABBIT, 0.6,
                CreatureType.GOAT, 0.6, CreatureType.SHEEP, 0.7, CreatureType.BOAR, 0.15, CreatureType.DUCK, 0.4));
        CreatureType.BOA.putCreatureTypeToEatingPossibilityMap(Map.of(
                CreatureType.FOX, 0.15, CreatureType.RABBIT, 0.2, CreatureType.MOUSE, 0.4, CreatureType.DUCK, 0.1));
        CreatureType.FOX.putCreatureTypeToEatingPossibilityMap(Map.of(
                CreatureType.RABBIT, 0.7, CreatureType.MOUSE, 0.9, CreatureType.DUCK, 0.6, CreatureType.CATERPILLAR, 0.4));
        CreatureType.BEAR.putCreatureTypeToEatingPossibilityMap(Map.of(
                CreatureType.BOA, 0.8, CreatureType.HORSE, 0.4, CreatureType.DEER, 0.8, CreatureType.RABBIT, 0.8,
                CreatureType.MOUSE, 0.9, CreatureType.GOAT, 0.7, CreatureType.SHEEP, 0.7, CreatureType.BOAR, 0.5,
                CreatureType.BUFFALO, 0.2, CreatureType.DUCK, 0.1));
        CreatureType.EAGLE.putCreatureTypeToEatingPossibilityMap(Map.of(
                CreatureType.FOX, 0.1, CreatureType.RABBIT, 0.9, CreatureType.MOUSE, 0.9, CreatureType.DUCK, 0.8));
        CreatureType.HORSE.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.PLANT, 1.0));
        CreatureType.DEER.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.PLANT, 1.0));
        CreatureType.RABBIT.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.PLANT, 1.0));
        CreatureType.MOUSE.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.CATERPILLAR, 0.9, CreatureType.PLANT, 1.0));
        CreatureType.GOAT.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.PLANT, 1.0));
        CreatureType.SHEEP.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.PLANT, 1.0));
        CreatureType.BOAR.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.MOUSE, 0.5, CreatureType.CATERPILLAR, 0.9, CreatureType.PLANT, 1.0));
        CreatureType.BUFFALO.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.PLANT, 1.0));
        CreatureType.DUCK.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.CATERPILLAR, 0.9, CreatureType.PLANT, 1.0));
        CreatureType.CATERPILLAR.putCreatureTypeToEatingPossibilityMap(Map.of(CreatureType.PLANT, 1.0));
    }

}
