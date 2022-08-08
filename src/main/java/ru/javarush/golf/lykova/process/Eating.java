package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.model.AbleToEat;
import ru.javarush.golf.lykova.model.Animal;
import ru.javarush.golf.lykova.model.Creature;
import ru.javarush.golf.lykova.model.Location;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Eating {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public void eat(AbleToEat ableToEat, Location location){
        if (ableToEat.getSatiety() >= ableToEat.getFullSatiety()) {
            return;
        }
        Map<Class<? extends Creature>, Double> creatureClassToEatingPossibilityMap = ableToEat.getCreatureClassToEatingPossibilityMap();
        List<Creature> eatableCreaturesList = location.takeCreatures(creatureClassToEatingPossibilityMap.keySet());
        if (eatableCreaturesList.isEmpty()) {
            return;
        }
        Creature victimCreature = eatableCreaturesList.get(random.nextInt(eatableCreaturesList.size()));
        Double eatingPossibility = creatureClassToEatingPossibilityMap.get(victimCreature.getClass());
        if (random.nextDouble() >= eatingPossibility) {
            return;
        }
        ableToEat.eat(victimCreature);
        victimCreature.getLocation().killCreature(victimCreature);
    }
}

