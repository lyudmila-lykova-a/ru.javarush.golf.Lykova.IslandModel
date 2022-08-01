package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.model.Animal;
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
        Map<Class<? extends Animal>, Double> animalClassToEatingPossibilityMap = consumerAnimal.getAnimalClassToEatingPossibilityMap();
        List<Animal> eatableAnimalsList = location.takeAnimals(animalClassToEatingPossibilityMap.keySet());
        if (eatableAnimalsList.isEmpty()) {
            return;
        }
        Animal victimAnimal = eatableAnimalsList.get(random.nextInt(eatableAnimalsList.size()));
        Double eatingPossibility = animalClassToEatingPossibilityMap.get(victimAnimal.getClass());
        if (random.nextDouble() >= eatingPossibility) {
            return;
        }
        consumerAnimal.eat(victimAnimal);
        victimAnimal.getLocation().killAnimal(victimAnimal);
    }
}

