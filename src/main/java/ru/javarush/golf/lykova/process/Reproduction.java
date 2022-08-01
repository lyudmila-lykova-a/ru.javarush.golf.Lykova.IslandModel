package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.model.Animal;

import java.util.concurrent.ThreadLocalRandom;

public class Reproduction {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public void reproduce(Animal animal) {
        if (animal.getLocation().takeAnimalAmount(animal) >= animal.getMaxCountInLocation()) {
            return;
        }
        if (animal.getLocation().takeAnimalAmount(animal) < 2) {
            return;
        }
        double reproductionPossibility = animal.getReproductionPossibility();
        if (random.nextDouble() >= reproductionPossibility) {
            return;
        }
        animal.getLocation().add(animal.reproduction());
    }
}
