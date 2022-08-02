package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.model.Animal;
import ru.javarush.golf.lykova.model.Creature;
import ru.javarush.golf.lykova.model.Location;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Eating {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public void eat(Animal consumerAnimal){
        if (consumerAnimal.getSatiety() >= consumerAnimal.getFullSatiety()) {
            return;
        }
        Location location = consumerAnimal.getLocation();
        Map<Class<? extends Creature>, Double> creatureClassToEatingPossibilityMap = consumerAnimal.getCreatureClassToEatingPossibilityMap();
        List<Creature> eatableCreaturesList = location.takeCreatures(creatureClassToEatingPossibilityMap.keySet());
        if (eatableCreaturesList.isEmpty()) {
            return;
        }
        Creature victimCreature = eatableCreaturesList.get(random.nextInt(eatableCreaturesList.size()));
        Double eatingPossibility = creatureClassToEatingPossibilityMap.get(victimCreature.getClass());
        if (random.nextDouble() >= eatingPossibility) {
            return;
        }
        consumerAnimal.eat(victimCreature);
        victimCreature.getLocation().killCreature(victimCreature);
    }
}

