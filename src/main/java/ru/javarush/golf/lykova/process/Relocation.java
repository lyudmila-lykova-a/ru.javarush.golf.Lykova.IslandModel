package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.model.Animal;
import ru.javarush.golf.lykova.model.Island;
import ru.javarush.golf.lykova.model.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Relocation {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    private final Island island;

    public Relocation(Island island) {
        this.island = island;
    }

    public void relocate(Animal animal) {
        int xOffset = 0;
        int yOffset = 0;
        int stepsCount = random.nextInt(animal.getMaxSpeed() + 1);
        for (int i = 0; i < stepsCount; i++) {
            int direction = random.nextInt(4);
            switch(direction) {
                case 0 -> xOffset++;
                case 1 -> yOffset++;
                case 2 -> xOffset--;
                case 3 -> yOffset--;
            }
        }
        if (xOffset == 0 && yOffset == 0) {
            return;
        }
        Location possibleLocation = island.takeLocationByOffset(animal, xOffset, yOffset);
        if (canRelocate(possibleLocation, animal)) {
            island.moveOffset(animal, xOffset, yOffset);
        }
    }

    private boolean canRelocate(Location possibleLocation, Animal animal) {
        int animalAmount = possibleLocation.takeAnimalAmount(animal);
        return animalAmount < animal.getMaxCountInLocation();
    }
}