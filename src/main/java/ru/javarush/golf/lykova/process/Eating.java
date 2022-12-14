package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.config.CreatureType;
import ru.javarush.golf.lykova.model.AbleToEat;
import ru.javarush.golf.lykova.model.Creature;
import ru.javarush.golf.lykova.model.Location;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Eating {

    public boolean eat(AbleToEat ableToEat, Location location){
        if (ableToEat.getSatiety() >= ableToEat.getFullSatiety()) {
            return false;
        }
        Map<CreatureType, Double> creatureTypeToEatingPossibilityMap = ableToEat.getCreatureTypeToEatingPossibilityMap();
        List<Creature> eatableCreaturesList = location.takeCreatures(creatureTypeToEatingPossibilityMap.keySet());
        if (eatableCreaturesList.isEmpty()) {
            return false;
        }
        Creature victimCreature = eatableCreaturesList.get(ThreadLocalRandom.current().nextInt(eatableCreaturesList.size()));
        Double eatingPossibility = creatureTypeToEatingPossibilityMap.get(victimCreature.getCreatureType());
        if (ThreadLocalRandom.current().nextDouble() >= eatingPossibility) {
            return false;
        }
        ableToEat.eat(victimCreature);
        victimCreature.getLocation().killCreature(victimCreature);
        return true;
    }
}

