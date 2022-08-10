package ru.javarush.golf.lykova;

import ru.javarush.golf.lykova.config.ApplicationConfig;
import ru.javarush.golf.lykova.model.*;
import ru.javarush.golf.lykova.process.*;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LifeCycle {

    private final Eating eating = new Eating();
    private final Reproduction reproduction = new Reproduction();
    private final Relocation relocation = new Relocation();
    private final StarvationDeath starvationDeath = new StarvationDeath();
    private final IslandInfo islandInfo = new IslandInfo();
    private Island island;
    private ScheduledExecutorService executorService;
    private boolean hasLife;
    private boolean hasAction;


    public void startLife() {
        WorldGenerator worldGenerator = new WorldGenerator(ApplicationConfig.ISLAND_WIDTH, ApplicationConfig.ISLAND_HEIGHT);
        island = worldGenerator.generate();
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(
                this::iterationProcessing,
                0,
                ApplicationConfig.TACT_DURATION_MS,
                TimeUnit.MILLISECONDS);
    }

    private void iterationProcessing() {
        hasLife = false;
        hasAction = false;
        try {
            for (Location location : island.takeAllLocations()) {
                creaturesProcessing(location.takeAllCreatures());
            }
            islandInfo.printIslandInfo(island);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!hasLife) {
            System.out.println("Все умерли. Симуляция создания мира завершена.");
            executorService.shutdown();
        }
        if (!hasAction) {
            System.out.println("Активности нет. Симуляция мира остановлена.");
            executorService.shutdown();
        }
    }

    private void creaturesProcessing(Set<Creature> creatureSet) {
        for (Creature creature : creatureSet) {
            if (!creature.isAlive()) {
                continue;
            }
            hasLife = true;
            singleCreatureProcessing(creature);
            if (creature instanceof AbleToEat ableToEat) {
                starvationDeath.killIfLowSatiety(ableToEat);
            }
        }
    }

    private void singleCreatureProcessing(Creature creature) {
        if (creature instanceof AbleToEat ableToEat) {
            boolean eat = eating.eat(ableToEat, creature.getLocation());
            if (eat) {
                hasAction = true;
                return;
            }
        }

        if (creature instanceof Reproductable reproductable) {
            int amountOnLocation = creature.getLocation().takeCreatureAmount(creature);
            boolean reproduce = reproduction.reproduce(reproductable, creature.getLocation(), amountOnLocation, creature.getMaxCountInLocation());
            if (reproduce) {
                hasAction = true;
                return;
            }
        }

        boolean relocate = relocation.relocate(island, creature);
        hasAction |= relocate;
    }

}
