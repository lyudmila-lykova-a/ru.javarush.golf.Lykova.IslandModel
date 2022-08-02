package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.config.CreatureType;
import ru.javarush.golf.lykova.model.Creature;
import ru.javarush.golf.lykova.model.Island;
import ru.javarush.golf.lykova.model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WorldGenerator {
    
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    private final int weight;
    private final int height;

    public WorldGenerator(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public Island generate() throws ReflectiveOperationException {
        Island island = new Island(weight, height);
        for (CreatureType creatureType : CreatureType.values()) {
            List<Creature> creatures = generateCreaturesByType(creatureType.getCreatureClass(), creatureType.getInitAmount());
            creatures.forEach(creature -> allocate(island, creature));
        }
        return island;
    }

    private List<Creature> generateCreaturesByType(Class<? extends Creature> creatureClass, int amount) throws ReflectiveOperationException {
        List<Creature> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Creature creature = creatureClass.getConstructor().newInstance();
            result.add(creature);
        }
        return result;
    }

    private void allocate(Island island, Creature creature) {
        int retries = 10;
        while (retries > 0) {
            int x = random.nextInt(0, weight);
            int y = random.nextInt(0, height);

            if (canRelocate(island.takeLocation(x, y), creature)) {
                island.move(creature, x, y);
                return;
            }
            retries--;
        }
    }

    private boolean canRelocate(Location possibleLocation, Creature creature) {
        int creatureAmount = possibleLocation.takeCreatureAmount(creature);
        return creatureAmount < creature.getMaxCountInLocation();
    }
}
