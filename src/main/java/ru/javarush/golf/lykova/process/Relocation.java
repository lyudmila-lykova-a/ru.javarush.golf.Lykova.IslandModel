package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.model.Creature;
import ru.javarush.golf.lykova.model.Island;
import ru.javarush.golf.lykova.model.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Relocation {

    public boolean relocate(Island island, Creature creature) {
        int xOffset = 0;
        int yOffset = 0;
        int stepsCount = ThreadLocalRandom.current().nextInt(creature.getMaxSpeed() + 1);
        for (int i = 0; i < stepsCount; i++) {
            int direction = ThreadLocalRandom.current().nextInt(4);
            switch (direction) {
                case 0 -> xOffset++;
                case 1 -> yOffset++;
                case 2 -> xOffset--;
                case 3 -> yOffset--;
            }
        }
        if (xOffset == 0 && yOffset == 0) {
            return false;
        }
        Location possibleLocation = island.takeLocationByOffset(creature, xOffset, yOffset);
        synchronized (this) {
            if (canRelocate(possibleLocation, creature)) {
                island.moveOffset(creature, xOffset, yOffset);
                return true;
            }
        }
        return false;
    }

    private boolean canRelocate(Location possibleLocation, Creature creature) {
        int creatureAmount = possibleLocation.takeCreatureAmount(creature);
        return creatureAmount < creature.getMaxCountInLocation();
    }
}
