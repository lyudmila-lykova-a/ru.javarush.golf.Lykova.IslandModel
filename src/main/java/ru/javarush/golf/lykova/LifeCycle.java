package ru.javarush.golf.lykova;

import ru.javarush.golf.lykova.model.*;
import ru.javarush.golf.lykova.process.Eating;
import ru.javarush.golf.lykova.process.Relocation;
import ru.javarush.golf.lykova.process.Reproduction;
import ru.javarush.golf.lykova.process.WorldGenerator;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LifeCycle {

    private final Eating eating = new Eating();
    private final Reproduction reproduction = new Reproduction();
    private final Relocation relocation = new Relocation();
    private Island island;

    public void startLife() throws ReflectiveOperationException {
        WorldGenerator worldGenerator = new WorldGenerator(3, 3);
        island = worldGenerator.generate();
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                () -> iterationProcessing(island),
                0,
                1000,
                TimeUnit.MILLISECONDS);
    }

    private void iterationProcessing(Island island) {
        for (Location location : island.takeAllLocations()) {
            creaturesProcessing(location.takeAllCreatures());
        }
    }

    private void creaturesProcessing(Set<Creature> creatureSet) {
        for (Creature creature : creatureSet) {
            singleCreatureProcessing(creature);
        }
    }

    private void singleCreatureProcessing(Creature creature) {
        if (creature instanceof AbleToEat ableToEat) {
            if (ableToEat.getSatiety() < ableToEat.getFullSatiety()) {
                eating.eat(ableToEat, creature.getLocation());
                return;
            }
        }

        if (creature instanceof Reproductable reproductable) {
            int amountOnLocation = creature.getLocation().takeCreatureAmount(creature);
            if (amountOnLocation > 1) {
                reproduction.reproduce(reproductable, creature.getLocation(), amountOnLocation, creature.getMaxCountInLocation());
                return;
            }
        }

        relocation.relocate(island, creature);
    }

}
