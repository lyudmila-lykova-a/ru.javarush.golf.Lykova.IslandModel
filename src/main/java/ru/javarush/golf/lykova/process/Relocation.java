package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.model.Creature;
import ru.javarush.golf.lykova.model.Island;
import ru.javarush.golf.lykova.model.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Relocation {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public void relocate(Island island, Creature creature) {
        int xOffset = 0;
        int yOffset = 0;
        int stepsCount = random.nextInt(creature.getMaxSpeed() + 1);
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
        Location possibleLocation = island.takeLocationByOffset(creature, xOffset, yOffset);
        if (canRelocate(possibleLocation, creature)) {
            island.moveOffset(creature, xOffset, yOffset);
        }
    }

    private boolean canRelocate(Location possibleLocation, Creature creature) {
        int creatureAmount = possibleLocation.takeCreatureAmount(creature);
        return creatureAmount < creature.getMaxCountInLocation();
    }
}
